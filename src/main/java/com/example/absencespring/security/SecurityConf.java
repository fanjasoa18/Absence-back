package com.example.absencespring.security;

import com.example.absencespring.model.Users;
import com.example.absencespring.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConf extends WebSecurityConfigurerAdapter {
    private final UsersService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/newrole").permitAll()
                .antMatchers("/newuser").permitAll()
                .antMatchers(GET, "/students/*").hasAnyRole(Users.TEACHER.getRole(TEACHER))
                .antMatchers(PUT, "/students/**").hasAnyRole(Users.TEACHER.getRole(TEACHER))
                .antMatchers(GET, "/teachers").hasAnyRole(Users.TEACHER.getRole(TEACHER))
                .antMatchers(GET, "/groups").authenticated()
                .antMatchers(GET, "/groups/*").authenticated()
                .antMatchers(GET, "/courses").authenticated()
                .antMatchers(GET, "/courses/*").authenticated()
                .antMatchers(GET,"/presences/student/{student_id}").permitAll()
                .antMatchers(GET, "/presences/group").hasRole(Users.TEACHER.getRole(TEACHER))
                .antMatchers(POST, "/presences/{teachers_id}").hasRole(Users.TEACHER.getRole(TEACHER))
                .antMatchers(GET, "/students/presences").hasRole(Users.TEACHER.getRole(TEACHER))
                .anyRequest().authenticated()
                .and()
                .httpBasic();

    }

    @Bean
    PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(bcryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService((UserDetailsService) userService);
        return daoAuthenticationProvider;
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails student = User.builder()
                .username("student")
                .password("{noop}azerty123")
                .roles("STUDENT")
                .build();

        UserDetails teacher = User.builder()
                .username("teacher")
                .password("{noop}admin0000")
                .roles("TEACHER")
                .build();

        return new InMemoryUserDetailsManager(student, teacher);
    }
}
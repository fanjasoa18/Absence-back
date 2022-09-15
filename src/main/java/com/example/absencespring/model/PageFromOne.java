package com.example.absencespring.model;

import lombok.Getter;

public class PageFromOne {
    @Getter
    private final int value;

    public PageFromOne(int value) {
        if(value < 1 ) {
            throw new Error("error");
        }
        this.value = value;
    }

}



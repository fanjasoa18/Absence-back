package com.example.absencespring.model;

import lombok.Getter;

public class BoundedPageSize {
    @Getter
    private final int value;

    private static final int MAX_SIZE = 500;

    public BoundedPageSize(int value) {
        if (value > MAX_SIZE) {
            throw new Error("page size must b <" + MAX_SIZE);
        }
        this.value = value;
    }

}

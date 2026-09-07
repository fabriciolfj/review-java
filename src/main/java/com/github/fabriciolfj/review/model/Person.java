package com.github.fabriciolfj.review.model;

import java.util.Objects;

public record Person(String name, String address) {

    public Person {
        Objects.requireNonNull(name, "name is required");
        Objects.requireNonNull(address, "address is required");

        if (name.isBlank()) {
            throw new IllegalArgumentException("name invalid");
        }

        if (address.isBlank()) {
            throw new IllegalArgumentException("address invalid");
        }
    }

}

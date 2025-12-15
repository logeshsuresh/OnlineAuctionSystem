package org.logesh.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class User {

    private final String userId;
    private final String userName;

    public User(String userName) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
    }

}

package com.example.authen_author.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePassword {
    private String username;
    private String newPassword;
}
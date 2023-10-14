package com.example.demo.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PrivateKey;
import java.security.PublicKey;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private PublicKey publicKey;
    private PrivateKey privateKey;

}

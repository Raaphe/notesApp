package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {
    @jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Notes> notes =new ArrayList<>();
}

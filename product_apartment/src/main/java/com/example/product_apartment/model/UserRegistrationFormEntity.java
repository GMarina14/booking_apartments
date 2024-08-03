package com.example.product_apartment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_registration_form")
public class UserRegistrationFormEntity {
    @Id
    @SequenceGenerator(name = "user_registration_formSequence", sequenceName = "user_registration_form_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_registration_formSequence")
    private Long id;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "username")
    private String username;
    @Column(name ="password")
    private String password;
    @Column(name ="token")
    private String token;

}

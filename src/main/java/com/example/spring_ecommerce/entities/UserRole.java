package com.example.spring_ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Table(name = "user_roles")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserRole {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @ManyToOne()
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "roleid")
    private Role role;
}

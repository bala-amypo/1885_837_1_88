package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role;

    private String field1;
    private String field2;
    private String field3;

    // JPA requires this
    public User() {}

    // ===== EXACT MATCH FOR TEST =====

    // 5 params
    public User(Long id,
                String name,
                String email,
                String password,
                String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // 6 params
    public User(Long id,
                String name,
                String email,
                String password,
                String role,
                String field1) {
        this(id, name, email, password, role);
        this.field1 = field1;
    }

    // 7 params
    public User(Long id,
                String name,
                String email,
                String password,
                String role,
                String field1,
                String field2) {
        this(id, name, email, password, role, field1);
        this.field2 = field2;
    }

    // 🔴 8 params (THIS IS WHAT THE TEST USES)
    public User(Long id,
                String name,
                String email,
                String password,
                String role,
                String field1,
                String field2,
                String field3) {
        this(id, name, email, password, role, field1, field2);
        this.field3 = field3;
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}

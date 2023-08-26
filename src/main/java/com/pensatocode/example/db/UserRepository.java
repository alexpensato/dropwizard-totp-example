package com.pensatocode.example.db;

import com.pensatocode.example.client.UserBootstrap;
import com.pensatocode.example.model.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        super();
        this.users = UserBootstrap.initUsers();
    }

    public List<User> findAll(int size) {
        return users.stream()
                .limit(size)
                .collect(Collectors.toList());
    }

    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(brand -> brand.getId().equals(id))
                .findFirst();
    }

    public Optional<User> findByUsername(String username) {
        return users.stream()
                .filter(brand -> brand.getCredentials().getUsername().equals(username))
                .findFirst();
    }

}

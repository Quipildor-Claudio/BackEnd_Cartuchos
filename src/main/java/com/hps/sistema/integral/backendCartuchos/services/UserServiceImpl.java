package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.User;
import com.hps.sistema.integral.backendCartuchos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> listar() {
        return (List<User>) repository.findAll();
    }

    @Override
    public Page<User> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<User> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public User guardar(User data) {
        data.setPassword(passwordEncoder.encode(data.getPassword()));
        return repository.save(data);
    }

    @Override
    public void eliminar(Long id) {
            repository.deleteById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }
}

package com.hps.sistema.integral.backendCartuchos.services;



import com.hps.sistema.integral.backendCartuchos.models.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> listar();
    Page<User> listar(Pageable pageable);
    Optional<User> porId(Long id);
    User guardar(User data);
    void eliminar(Long id);

    Optional<User> findByUsername(String username);
}

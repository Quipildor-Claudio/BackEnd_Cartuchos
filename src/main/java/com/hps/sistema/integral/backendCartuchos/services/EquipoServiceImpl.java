package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Equipo;
import com.hps.sistema.integral.backendCartuchos.repositories.EquipoRepository;
import com.hps.sistema.integral.backendCartuchos.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoServiceImpl implements EquipoService{
    @Autowired
    EquipoRepository repository;
    @Override
    public List<Equipo> listar() {
        return (List<Equipo>) repository.findAll();
    }

    @Override
    public Optional<Equipo> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Equipo guardar(Equipo data) {
        return repository.save(data);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Equipo> findByCueContainingIgnoreCase(String cue) {
        return repository.findByCueContainingIgnoreCase(cue);
    }

    @Override
    public List<Equipo> findByMatriculaContainingIgnoreCase(String mat) {
        return repository.findByMatriculaContainingIgnoreCase(mat);
    }

}

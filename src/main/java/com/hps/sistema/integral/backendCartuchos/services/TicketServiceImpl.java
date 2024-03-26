package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Ticket;
import com.hps.sistema.integral.backendCartuchos.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    TicketRepository repository;
    @Override
    public List<Ticket> listar() {
        return ( List<Ticket> )repository.findAll();
    }

    @Override
    public Optional<Ticket> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Ticket guardar(Ticket data) {
        return repository.save(data);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

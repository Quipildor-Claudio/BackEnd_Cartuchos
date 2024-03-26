package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> listar();

    Optional<Ticket> porId(Long id);
    Ticket guardar(Ticket data);
    void eliminar(Long id);
}

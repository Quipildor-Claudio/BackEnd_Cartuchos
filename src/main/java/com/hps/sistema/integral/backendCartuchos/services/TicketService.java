package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.Ticket;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> listar();
    Optional<Ticket> porId(Long id);
    Ticket guardar(Ticket data);
    void eliminar(Long id);
    List<Ticket> findByFechaSolicitudBetween(Date fechaInicio, Date FechaFinal);
    List<Ticket> findByDiagnostico(String diagnostico);
    List<Ticket> findByTecnicoAsignado(String tecnico);
    List<Ticket> findByFechaSalidaBetween(Date fechaInicio,Date fechaFinal);
}

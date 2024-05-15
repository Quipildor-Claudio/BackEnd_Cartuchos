package com.hps.sistema.integral.backendCartuchos.repositories;

import com.hps.sistema.integral.backendCartuchos.models.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    public List<Ticket> findByFechaSolicitudBetween(Date fechaInicio,Date FechaFinal);
    public List<Ticket> findByDiagnostico(String diagnostico);
    public List<Ticket> findByTecnicoAsignado(String tecnico);
    public List<Ticket> findByFechaSalidaBetween(Date fechaInicio,Date fechaFinal);
}

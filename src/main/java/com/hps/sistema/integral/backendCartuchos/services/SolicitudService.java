package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.Solicitud;
import net.sf.jasperreports.engine.JRException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SolicitudService {
    List<Solicitud> listar();

    Page<Solicitud> listar(Pageable pageable);



    Optional<Solicitud> porId(Long id);
    Solicitud guardar(Solicitud data);
    void eliminar(Long id);

    List<Solicitud> findByFechaCreacionBetween(Date fechaInicio, Date fechaFinal);
    List<Solicitud> findByEstadoDescripcion(String nombre);


    byte[] exportPdf() throws JRException, FileNotFoundException;
    byte[] exportXls() throws JRException, FileNotFoundException;
}

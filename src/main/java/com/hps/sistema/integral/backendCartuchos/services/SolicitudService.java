package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.Solicitud;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public interface SolicitudService {
    List<Solicitud> listar();
    Optional<Solicitud> porId(Long id);
    Solicitud guardar(Solicitud data);
    void eliminar(Long id);

    byte[] exportPdf() throws JRException, FileNotFoundException;
    byte[] exportXls() throws JRException, FileNotFoundException;
}

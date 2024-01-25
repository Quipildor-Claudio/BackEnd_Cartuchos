package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.jasperReposts.SolitudesMensualesGenerator;
import com.hps.sistema.integral.backendCartuchos.models.entities.Solicitud;
import com.hps.sistema.integral.backendCartuchos.repositories.SolicitudRepository;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudServiceImpl implements SolicitudService {
    @Autowired
    SolicitudRepository repository;

    @Autowired
    SolitudesMensualesGenerator generator;

    @Override
    @Transactional(readOnly = true)
    public List<Solicitud> listar() {
        return (List<Solicitud>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Solicitud> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }



    @Override
    public Optional<Solicitud> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Solicitud guardar(Solicitud data) {
        return repository.save(data);
    }

    @Override
    public void eliminar(Long id) {
            repository.deleteById(id);
    }

    @Override
    public List<Solicitud> findByFechaCreacionBetween(Date fechaInicio, Date fechaFinal) {
        return repository.findByFechaCreacionBetween(fechaInicio, fechaFinal);
    }

    @Override
    public List<Solicitud> findByEstadoDescripcion(String nombre) {
        return repository.findByEstadoDescripcion(nombre);
    }

    @Override
    public List<Solicitud> findByUsuarioPersonaServicioNombre(String nombre) {
        return repository.findByUsuarioPersonaServicioNombre(nombre);
    }

    @Override
    public Page<Solicitud> findByUsuarioPersonaServicioNombre(String nombre, Pageable pageable) {
        return repository.findByUsuarioPersonaServicioNombre(nombre,pageable);
    }

    @Override
    public Page<Solicitud> findByUsuarioUsername(String nombre, Pageable pageable) {
        return repository.findByUsuarioUsername(nombre,pageable);
    }


    @Override
    public byte[] exportPdf() throws JRException, FileNotFoundException {

        return generator.exportToPdf((List<Solicitud>) repository.findAll());

    }

    @Override
    public byte[] exportXls() throws JRException, FileNotFoundException {
        return generator.exportToXls((List<Solicitud>) repository.findAll());
    }


}

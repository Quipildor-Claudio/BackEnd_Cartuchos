package com.hps.sistema.integral.backendCartuchos.controllers;


import com.hps.sistema.integral.backendCartuchos.models.entities.Solicitud;
import com.hps.sistema.integral.backendCartuchos.services.SolicitudService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class SolicitudController {
    @Autowired
    SolicitudService    service;

    @GetMapping("/solicitudes")
    public List<Solicitud> listar(){
        return service.listar();
    }

    @GetMapping("/solicitudes/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Solicitud> data = service.porId(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(data.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/solicitudes")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody Solicitud data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping ("/solicitudes/{id}")
    public  ResponseEntity<?> editar(@RequestBody Solicitud updata,@PathVariable Long id){
        Optional<Solicitud> data = service.porId(id);
        if(data.isPresent()){
            Solicitud dataDb = data.get();
           dataDb.setCantidad(updata.getCantidad());
           dataDb.setDescripcion(updata.getDescripcion());
            dataDb.setJustificacion(updata.getJustificacion());
            dataDb.setObservacion(updata.getObservacion());
            dataDb.setCartuchos(updata.getCartuchos());
            dataDb.setImpresoras(updata.getImpresoras());
            dataDb.setFecha_actualizacion(new Date());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/solicitudes/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Solicitud> data = service.porId(id);
        if(data.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/solicitudes/export-pdf")
    public ResponseEntity<byte[]> exportPdf() throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("petsReport", "solitudMensualReport.pdf");
        return ResponseEntity.ok().headers(headers).body(service.exportPdf());
    }
}

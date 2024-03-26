package com.hps.sistema.integral.backendCartuchos.controllers;


import com.hps.sistema.integral.backendCartuchos.models.entities.Solicitud;
import com.hps.sistema.integral.backendCartuchos.services.SolicitudService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class SolicitudController {
    @Autowired
    SolicitudService    service;

    @GetMapping("/solicitudes")
    public List<Solicitud> listar(){
        return service.listar();
    }

    @GetMapping("/solicitudes/page/{page}")
    public Page<Solicitud> pageablelistar(@PathVariable Integer page){
        Pageable pageable = PageRequest.of(page,10, Sort.by("id").descending());
        return service.listar(pageable);
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
            dataDb.setJustificacion(updata.getJustificacion());
            dataDb.setObservacion(updata.getObservacion());
            dataDb.setImpresoras(updata.getImpresoras());
            dataDb.setEstado(updata.getEstado());
            dataDb.setAprobado(updata.getAprobado());
            dataDb.setRetirado(updata.getRetirado());
            dataDb.setItemSolicituds(updata.getItemSolicituds());
            dataDb.setFecha_actualizacion(new Date());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/solicitudes/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();

        try {
            service.eliminar(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el registro de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El registro eliminado con éxito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/solicitudes/export-pdf")
    public ResponseEntity<byte[]> exportPdf() throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("petsReport", "solitudMensualReport.pdf");
        return ResponseEntity.ok().headers(headers).body(service.exportPdf());
    }

    @GetMapping("/solicitudes/buscarPorFecha/{fechaInicio}/{fechaFinal}")
    public List<Solicitud> buscarPorFecha(
            @PathVariable String fechaInicio,
            @PathVariable  String fechaFinal) {

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        Date fecha,fecha2;
        try {
            // Convierte el String a un objeto Date
            fecha = formatoFecha.parse(fechaInicio);
            fecha2 = formatoFecha.parse(fechaFinal);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return service.findByFechaCreacionBetween(fecha, fecha2);
    }

    @GetMapping("/solicitudes/buscarPorFechaandServico/{fechaInicio}/{fechaFinal}/{name}")
    public List<Solicitud> buscarPorFechaServcio(
            @PathVariable String fechaInicio,
            @PathVariable  String fechaFinal,@PathVariable String name) {

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        Date fecha,fecha2;
        try {
            // Convierte el String a un objeto Date
            fecha = formatoFecha.parse(fechaInicio);
            fecha2 = formatoFecha.parse(fechaFinal);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return service.findByFechaCreacionBetweenAndUsuarioPersonaServicioNombre(fecha,fecha2,name);
    }

    @GetMapping("/solicitudes/buscarPorEstado/{nombre}")
    public List<Solicitud> buscarPorEstado(@PathVariable String nombre){
        return  service.findByEstadoDescripcion(nombre);
    }

    @GetMapping("/solicitudes/buscarporEstadoandUser/{des}/{name}")
    public List<Solicitud> buscarPorEstadoAndUser(@PathVariable String des,@PathVariable String name){
        return  service.findByEstadoDescripcionAndUsuarioUsername(des, name);
    }

    @GetMapping("/solicitudes/buscarporEstadoandServicio/{des}/{name}")
    public List<Solicitud> buscarPorEstadoAndServico(@PathVariable String des,@PathVariable String name){
        return  service.findByEstadoDescripcionAndUsuarioPersonaServicioNombre(des, name);
    }

    @GetMapping("/solicitudes/buscarPorServicio/page/{nombre}/{page}")
    public Page<Solicitud> buscarPorServcio(@PathVariable String nombre,@PathVariable Integer page ){
        Pageable pageable = PageRequest.of(page,10,Sort.by("id").descending());
        return  service.findByUsuarioPersonaServicioNombre(nombre,pageable);
    }

    @GetMapping("/solicitudes/buscarPorUsername/page/{nombre}/{page}")
    public Page<Solicitud> buscarPorUsername(@PathVariable String nombre,@PathVariable Integer page ){
        Pageable pageable = PageRequest.of(page,10,Sort.by("id").descending());
        return  service.findByUsuarioUsername(nombre,pageable);
    }


    @GetMapping("/solicitudes/buscarPorServicio/{nombre}")
    public List<Solicitud> buscarPorServcio(@PathVariable String nombre){
        return  service.findByUsuarioPersonaServicioNombre(nombre);
    }


}

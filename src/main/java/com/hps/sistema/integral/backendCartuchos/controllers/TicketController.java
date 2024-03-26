package com.hps.sistema.integral.backendCartuchos.controllers;


import com.hps.sistema.integral.backendCartuchos.models.entities.Ticket;
import com.hps.sistema.integral.backendCartuchos.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class TicketController {
    @Autowired
    TicketService service;

    @GetMapping("/ticket")
    public List<Ticket> listar(){
        return service.listar();
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Ticket> data = service.porId(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(data.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/ticket")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody Ticket data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping ("/ticket/{id}")
    public  ResponseEntity<?> editar(@RequestBody Ticket updata,@PathVariable Long id){
        Optional<Ticket> data = service.porId(id);
        if(data.isPresent()){
            Ticket dataDb = data.get();
            dataDb.setDerivado(updata.getDerivado());
            dataDb.setDiagnostico(updata.getDiagnostico());
            dataDb.setEquipo(updata.getEquipo());
            dataDb.setObservacion(updata.getObservacion());
            dataDb.setFecha_salida(updata.getFecha_salida());
            dataDb.setFecha_atencion(updata.getFecha_atencion());
            dataDb.setFecha_solicitud(updata.getFecha_solicitud());
            dataDb.setProblema_reportado(updata.getProblema_reportado());
            dataDb.setTecnico_asignado(updata.getTecnico_asignado());
            dataDb.setUsuario(updata.getUsuario());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/ticket/{id}")
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
}

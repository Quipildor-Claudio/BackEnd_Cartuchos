package com.hps.sistema.integral.backendCartuchos.controllers;


import com.hps.sistema.integral.backendCartuchos.models.entities.Servicio;
import com.hps.sistema.integral.backendCartuchos.services.ServicioService;
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
public class ServicioController {
    @Autowired
    ServicioService service;

    @GetMapping("/servicios")
    public List<Servicio> listar(){
        return service.listar();
    }

    @GetMapping("/servicios/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Servicio> data = service.porId(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(data.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/servicios")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody Servicio data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping ("/servicios/{id}")
    public  ResponseEntity<?> editar(@RequestBody Servicio updata,@PathVariable Long id){
        Optional<Servicio> data = service.porId(id);
        if(data.isPresent()){
            Servicio dataDb = data.get();
            dataDb.setNombre(updata.getNombre());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/servicios/{id}")
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

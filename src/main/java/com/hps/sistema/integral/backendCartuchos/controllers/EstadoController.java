package com.hps.sistema.integral.backendCartuchos.controllers;


import com.hps.sistema.integral.backendCartuchos.models.entities.Estado;
import com.hps.sistema.integral.backendCartuchos.services.EstadoService;
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
public class EstadoController {
    @Autowired
    EstadoService service;

    @GetMapping("/estados")
    public List<Estado> listar(){
        return service.listar();
    }

    @GetMapping("/estados/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Estado> data = service.porId(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(data.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/estados")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody Estado data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping ("/estados/{id}")
    public  ResponseEntity<?> editar(@RequestBody Estado updata,@PathVariable Long id){
        Optional<Estado> data = service.porId(id);
        if(data.isPresent()){
            Estado dataDb = data.get();
           dataDb.setDescripcion(updata.getDescripcion());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/estados/{id}")
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

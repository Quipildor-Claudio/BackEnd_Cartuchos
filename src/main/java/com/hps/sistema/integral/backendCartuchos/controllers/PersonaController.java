package com.hps.sistema.integral.backendCartuchos.controllers;

import com.hps.sistema.integral.backendCartuchos.models.entities.Persona;
import com.hps.sistema.integral.backendCartuchos.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class PersonaController {
    @Autowired
    private PersonaService service;

    @GetMapping("/personas")
    public List<Persona> listar(){
        return service.listar();
    }

    @GetMapping("/personas/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Persona> data = service.porId(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(data.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/personas")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody Persona data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping ("/personas/{id}")
    public  ResponseEntity<?> editar(@RequestBody Persona updata,@PathVariable Long id){
        Optional<Persona> data = service.porId(id);
        if(data.isPresent()){
            Persona dataDb = data.get();
            dataDb.setApellido(updata.getApellido());
            dataDb.setNombre(updata.getNombre());
            dataDb.setDni(updata.getDni());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/personas/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Persona> data = service.porId(id);
        if(data.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

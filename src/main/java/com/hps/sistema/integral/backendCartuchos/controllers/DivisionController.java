package com.hps.sistema.integral.backendCartuchos.controllers;

import com.hps.sistema.integral.backendCartuchos.models.entities.Division;
import com.hps.sistema.integral.backendCartuchos.services.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class DivisionController {
    @Autowired
    private DivisionService service;

    @GetMapping("/divisiones")
    public List<Division> listar(){
        return service.listar();
    }

    @GetMapping("/divisiones/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Division> data = service.porId(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(data.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/divisiones")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody Division data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping ("/divisiones/{id}")
    public  ResponseEntity<?> editar(@RequestBody Division updata,@PathVariable Long id){
        Optional<Division> data = service.porId(id);
        if(data.isPresent()){
            Division dataDb = data.get();
            dataDb.setDescripcion(updata.getDescripcion());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/divisiones/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Division> data = service.porId(id);
        if(data.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

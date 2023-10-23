package com.hps.sistema.integral.backendCartuchos.controllers;


import com.hps.sistema.integral.backendCartuchos.models.entities.TipoCartucho;
import com.hps.sistema.integral.backendCartuchos.services.TipoCartuchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class TipoCartuchoController {
    @Autowired
    private TipoCartuchoService service;

    @GetMapping("/tipoCartuchos")
    public List<TipoCartucho> listar(){
        return service.listar();
    }

    @GetMapping("/tipoCartuchos/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<TipoCartucho> data = service.porId(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(data.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/tipoCartuchos")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody TipoCartucho data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping ("/tipoCartuchos/{id}")
    public  ResponseEntity<?> editar(@RequestBody TipoCartucho updata,@PathVariable Long id){
        Optional<TipoCartucho> data = service.porId(id);
        if(data.isPresent()){
            TipoCartucho dataDb = data.get();
           dataDb.setDescripcion(updata.getDescripcion());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/tipoCartuchos/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<TipoCartucho> data = service.porId(id);
        if(data.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

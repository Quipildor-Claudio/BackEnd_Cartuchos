package com.hps.sistema.integral.backendCartuchos.controllers;

import com.hps.sistema.integral.backendCartuchos.models.entities.TipoCarga;
import com.hps.sistema.integral.backendCartuchos.services.TipoCargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class TipoCargaController {
    @Autowired
    TipoCargeService service;
    @GetMapping("/tipoCargas")
    public List<TipoCarga> listar(){
        return service.listar();
    }

    @GetMapping("/tipoCargas/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<TipoCarga> data = service.porId(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(data.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/tipoCargas")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody TipoCarga data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping ("/tipoCargas/{id}")
    public  ResponseEntity<?> editar(@RequestBody TipoCarga updata,@PathVariable Long id){
        Optional<TipoCarga> data = service.porId(id);
        if(data.isPresent()){
            TipoCarga dataDb = data.get();
            dataDb.setDescripcion(updata.getDescripcion());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/tipoCargas/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<TipoCarga> data = service.porId(id);
        if(data.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



}

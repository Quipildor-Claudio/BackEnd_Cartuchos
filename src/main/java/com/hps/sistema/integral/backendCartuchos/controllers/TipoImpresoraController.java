package com.hps.sistema.integral.backendCartuchos.controllers;

import com.hps.sistema.integral.backendCartuchos.models.entities.TipoImpresora;
import com.hps.sistema.integral.backendCartuchos.services.TipoImpresoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class TipoImpresoraController {
    @Autowired
    TipoImpresoraService service;

    @GetMapping("/tipoImpresora")
    public List<TipoImpresora> listar(){
        return service.listar();
    }

    @GetMapping("/tipoImpresora/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<TipoImpresora> data = service.porId(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(data.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/tipoImpresora")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody TipoImpresora data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping ("/tipoImpresora/{id}")
    public  ResponseEntity<?> editar(@RequestBody TipoImpresora updata,@PathVariable Long id){
        Optional<TipoImpresora> data = service.porId(id);
        if(data.isPresent()){
            TipoImpresora dataDb = data.get();
            dataDb.setDescripcion(updata.getDescripcion());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/tipoImpresora/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<TipoImpresora> data = service.porId(id);
        if(data.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}

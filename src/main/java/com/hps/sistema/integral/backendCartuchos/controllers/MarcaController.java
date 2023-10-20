package com.hps.sistema.integral.backendCartuchos.controllers;

import com.hps.sistema.integral.backendCartuchos.models.entities.Marca;
import com.hps.sistema.integral.backendCartuchos.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class MarcaController {
    @Autowired
    private MarcaService service;

    @GetMapping("/marcas")
    public List<Marca> listar(){
        return service.listar();
    }

    @GetMapping("/marcas/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Marca> marca = service.porId(id);
        if (marca.isPresent()){
            return ResponseEntity.ok().body(marca.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/marcas")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody Marca data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping ("/marcas/{id}")
    public  ResponseEntity<?> editar(@RequestBody Marca updata,@PathVariable Long id){
        Optional<Marca> data = service.porId(id);
        if(data.isPresent()){
            Marca dataDb = data.get();
           dataDb.setNombre(updata.getNombre());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/marcas/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Marca> data = service.porId(id);
        if(data.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

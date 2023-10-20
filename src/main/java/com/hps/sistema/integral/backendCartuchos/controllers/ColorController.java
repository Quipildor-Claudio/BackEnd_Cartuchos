package com.hps.sistema.integral.backendCartuchos.controllers;

import com.hps.sistema.integral.backendCartuchos.models.entities.Color;
import com.hps.sistema.integral.backendCartuchos.services.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class ColorController {
@Autowired
    ColorService service;

    @GetMapping("/colores")
    public List<Color> listar(){
        return service.listar();
    }

    @GetMapping("/colores/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Color> data = service.porId(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(data.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/colores")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody Color data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping ("/colores/{id}")
    public  ResponseEntity<?> editar(@RequestBody Color updata,@PathVariable Long id){
        Optional<Color> data = service.porId(id);
        if(data.isPresent()){
            Color dataDb = data.get();
            dataDb.setNombre(updata.getNombre());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/colores/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Color> data = service.porId(id);
        if(data.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

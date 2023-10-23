package com.hps.sistema.integral.backendCartuchos.controllers;

import com.hps.sistema.integral.backendCartuchos.models.entities.Impresora;
import com.hps.sistema.integral.backendCartuchos.services.ImpresoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class ImpresoraController {
    @Autowired
    private ImpresoraService service;



    @GetMapping("/impresoras")
    public List<Impresora> listar(){
        return service.listar();
    }

    @GetMapping("/impresoras/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Impresora> data = service.porId(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(data.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/impresoras")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody Impresora data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping("/impresoras/{id}")
    public  ResponseEntity<?> editar(@RequestBody Impresora updata,@PathVariable Long id){
        Optional<Impresora> data = service.porId(id);
        if(data.isPresent()){
            Impresora dataDb = data.get();
            dataDb.setMarca(updata.getMarca());
            dataDb.setModelo(updata.getModelo());
            dataDb.setTipoImpresora(updata.getTipoImpresora());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/impresoras/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Impresora> data = service.porId(id);
        if(data.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

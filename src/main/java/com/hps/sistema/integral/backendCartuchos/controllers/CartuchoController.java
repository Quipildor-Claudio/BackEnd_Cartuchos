package com.hps.sistema.integral.backendCartuchos.controllers;


import com.hps.sistema.integral.backendCartuchos.models.entities.Cartucho;
import com.hps.sistema.integral.backendCartuchos.services.CartuchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class CartuchoController {
    @Autowired
    private CartuchoService  service;

    @GetMapping("/cartuchos")
    public List<Cartucho> listar(){
        return service.listar();
    }

    @GetMapping("/cartuchos/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Cartucho> data = service.porId(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(data.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/cartuchos")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody Cartucho data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping ("/cartuchos/{id}")
    public  ResponseEntity<?> editar(@RequestBody Cartucho updata,@PathVariable Long id){
        Optional<Cartucho> data = service.porId(id);
        if(data.isPresent()){
            Cartucho dataDb = data.get();
            dataDb.setModelo(updata.getModelo());
            dataDb.setCapacidad(updata.getCapacidad());
            dataDb.setDescripcion(updata.getDescripcion());
            dataDb.setModelo(updata.getModelo());
            dataDb.setMarca(updata.getMarca());
            dataDb.setTipoCarga(updata.getTipoCarga());
            dataDb.setTipoCartucho(updata.getTipoCartucho());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/cartuchos/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Cartucho> data = service.porId(id);
        if(data.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

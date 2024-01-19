package com.hps.sistema.integral.backendCartuchos.controllers;


import com.hps.sistema.integral.backendCartuchos.models.entities.Cartucho;
import com.hps.sistema.integral.backendCartuchos.models.entities.Impresora;
import com.hps.sistema.integral.backendCartuchos.services.CartuchoService;
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

            dataDb.setTipoCartucho(updata.getTipoCartucho());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/cartuchos/{id}")
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

    // Busca por la marca del nombre tiene que ser especifica  y  cualquier modelo
    @GetMapping("/buscar-cartucho/{nombre}/{modelo}")
    public List<Cartucho> filtrarCArtucho(@PathVariable  String nombre, @PathVariable String modelo){
        return service.findByMarcaNombreAndModeloContainingIgnoreCase(nombre, modelo);
    }

    @GetMapping("/cartucho-modelo/{modelo}")
    public List<Cartucho> filtrarCartuchoraModelo(@PathVariable String modelo){
        return service.findByModeloContainingIgnoreCase(modelo);
    }

    @GetMapping("/cartucho-marca/{nombre}")
    public List<Cartucho> filtrarCartuchoMarca(@PathVariable String nombre){
        return service.findByMarcaNombreContainingIgnoreCase(nombre);
    }



}

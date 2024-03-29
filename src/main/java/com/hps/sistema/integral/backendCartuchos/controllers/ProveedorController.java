package com.hps.sistema.integral.backendCartuchos.controllers;


import com.hps.sistema.integral.backendCartuchos.models.entities.Cartucho;
import com.hps.sistema.integral.backendCartuchos.models.entities.Proveedor;
import com.hps.sistema.integral.backendCartuchos.services.ProveedorService;
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
public class ProveedorController {
    @Autowired
    private ProveedorService service;
    @GetMapping("/proveedor")
    public List<Proveedor> listar(){
        return service.listar();
    }

    @GetMapping("/proveedor/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Proveedor> data = service.porId(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(data.get()) ;
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/proveedor")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody Proveedor data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping ("/proveedor/{id}")
    public  ResponseEntity<?> editar(@RequestBody Proveedor updata,@PathVariable Long id){
        Optional<Proveedor> data = service.porId(id);
        if(data.isPresent()){
            Proveedor dataDb = data.get();
            dataDb.setDescripcion(updata.getDescripcion());
            dataDb.setNombre(updata.getNombre());
            dataDb.setImagen(updata.getImagen());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/proveedor/{id}")
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

}

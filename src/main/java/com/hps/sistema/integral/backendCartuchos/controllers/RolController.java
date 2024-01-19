package com.hps.sistema.integral.backendCartuchos.controllers;

import com.hps.sistema.integral.backendCartuchos.models.entities.Rol;
import com.hps.sistema.integral.backendCartuchos.services.RolService;
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
public class RolController {
    @Autowired
    RolService service;
    @GetMapping("/roles")
    public List<Rol> listarRol(){
        return service.listar();
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<?> detalleRol(@PathVariable Long id){
        Optional<Rol> rol = service.porId(id);
        if (rol.isPresent()){
            return ResponseEntity.ok().body(rol.get()) ;
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/roles")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody Rol rol){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(rol));
    }

    @PutMapping ("/roles/{id}")
    public  ResponseEntity<?> editar(@RequestBody Rol updata,@PathVariable Long id){
        Optional<Rol> data = service.porId(id);
        if(data.isPresent()){
            Rol dataDb = data.get();
            dataDb.setDescripcion(updata.getDescripcion());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/roles/{id}")
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

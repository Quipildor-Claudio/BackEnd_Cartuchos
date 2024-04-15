package com.hps.sistema.integral.backendCartuchos.controllers;

import com.hps.sistema.integral.backendCartuchos.models.entities.Equipo;
import com.hps.sistema.integral.backendCartuchos.services.EquipoService;
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
public class EquipoController {
    @Autowired
    EquipoService service;

    @GetMapping("/equipo")
    public List<Equipo> listar(){
        return service.listar();
    }

    @GetMapping("/equipo/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Equipo> data = service.porId(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(data.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/equipo")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody Equipo data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping ("/equipo/{id}")
    public  ResponseEntity<?> editar(@RequestBody Equipo updata,@PathVariable Long id){
        Optional<Equipo> data = service.porId(id);
        if(data.isPresent()){
            Equipo dataDb = data.get();
            dataDb.setCue(updata.getCue());
            dataDb.setMarca(updata.getMarca());
            dataDb.setModelo(updata.getModelo());
            dataDb.setDescripcion(updata.getDescripcion());
            dataDb.setMatricula(updata.getMatricula());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/equipo/{id}")
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

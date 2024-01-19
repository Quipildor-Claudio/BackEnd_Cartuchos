package com.hps.sistema.integral.backendCartuchos.controllers;

import com.hps.sistema.integral.backendCartuchos.models.entities.Cartucho;
import com.hps.sistema.integral.backendCartuchos.models.entities.Persona;
import com.hps.sistema.integral.backendCartuchos.services.PersonaService;
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
public class PersonaController {
    @Autowired
    private PersonaService service;

    @GetMapping("/personas")
    public List<Persona> listar(){
        return service.listar();
    }

    @GetMapping("/personas/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Persona> data = service.porId(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(data.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/personas")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody Persona data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping ("/personas/{id}")
    public  ResponseEntity<?> editar(@RequestBody Persona updata,@PathVariable Long id){
        Optional<Persona> data = service.porId(id);
        if(data.isPresent()){
            Persona dataDb = data.get();
            dataDb.setApellido(updata.getApellido());
            dataDb.setNombre(updata.getNombre());
            dataDb.setDni(updata.getDni());
            dataDb.setServicio(updata.getServicio());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/personas/{id}")
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

    @GetMapping("/pordni/{dni}")
    public ResponseEntity<?> personaDni(@PathVariable String dni){
        Optional<Persona> persona = service.findByDni(dni);
        if (persona.isPresent()){
            return ResponseEntity.ok().body(persona.get()) ;
        }
        return ResponseEntity.notFound().build(); /** responde con un 404 el build genra el mensaje*/
    }

    @GetMapping("constrainDni/{dni}")
    public List<Persona> filtrarPersonaDni(@PathVariable String dni){
        return service.findByDniContainingIgnoreCase(dni);
    }
}

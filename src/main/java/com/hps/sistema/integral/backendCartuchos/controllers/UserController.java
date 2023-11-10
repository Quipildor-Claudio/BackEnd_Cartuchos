package com.hps.sistema.integral.backendCartuchos.controllers;

import com.hps.sistema.integral.backendCartuchos.models.entities.Rol;
import com.hps.sistema.integral.backendCartuchos.models.entities.User;
import com.hps.sistema.integral.backendCartuchos.services.RolService;
import com.hps.sistema.integral.backendCartuchos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private RolService rolService;

    @GetMapping("/user")
    public List<User> listar(){
        return service.listar();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<User> data = service.porId(id);
        if (data.isPresent()){
            return ResponseEntity.ok().body(data.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/user")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody User data){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(data));
    }

    @PutMapping ("/user/{id}")
    public  ResponseEntity<?> editar(@RequestBody User updata,@PathVariable Long id){
        Optional<User> data = service.porId(id);
        if(data.isPresent()){
            User dataDb = data.get();
            dataDb.setUsername(updata.getUsername());
            dataDb.setPassword(updata.getPassword());
            dataDb.setEmail(updata.getEmail());
            dataDb.setPersona(updata.getPersona());
            dataDb.setRoles(updata.getRoles());
            dataDb.setEnabled(updata.getEnabled());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<User> data = service.porId(id);
        if(data.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // MANEJO DE ROLES



    @GetMapping("/user/userbyname/{name}")
    public ResponseEntity<?> userNombre(@PathVariable String name){
        Optional<User> usuario = service.findByUsername(name);
        if (usuario.isPresent()){
            return ResponseEntity.ok().body(usuario.get()) ;
        }
        return ResponseEntity.notFound().build();

    }

}

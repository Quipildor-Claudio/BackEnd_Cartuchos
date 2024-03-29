package com.hps.sistema.integral.backendCartuchos.controllers;

import com.hps.sistema.integral.backendCartuchos.models.entities.Impresora;
import com.hps.sistema.integral.backendCartuchos.services.ImpresoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ImpresoraController {
    @Autowired
    private ImpresoraService service;


    @GetMapping("/impresoras")
    public List<Impresora> listar() {
        return service.listar();
    }

    @GetMapping("/impresoras/page/{page}")
    public Page<Impresora> listar(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 20, Sort.by("id").descending());
        return service.listar(pageable);
    }

    @GetMapping("/impresoras/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) {
        Optional<Impresora> data = service.porId(id);
        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/impresoras")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@RequestBody Impresora impresora) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(impresora));
    }

    @PutMapping("/impresoras/{id}")
    public ResponseEntity<?> editar(@RequestBody Impresora updata, @PathVariable Long id) {
        Optional<Impresora> data = service.porId(id);
        if (data.isPresent()) {
            Impresora dataDb = data.get();
            dataDb.setMarca(updata.getMarca());
            dataDb.setModelo(updata.getModelo());
            dataDb.setDescripcion(updata.getDescripcion());
            dataDb.setTipoImpresora(updata.getTipoImpresora());
            dataDb.setCartuchos(updata.getCartuchos());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dataDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/impresoras/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
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
    @GetMapping("/buscar-impresora/{nombre}/{modelo}")
    public List<Impresora> filtrarImpresora(@PathVariable String nombre, @PathVariable String modelo) {
        return service.findByMarcaNombreAndModeloContainingIgnoreCase(nombre, modelo);
    }

    // busqueda por modelo
    @GetMapping("/buscar-modelo/{modelo}")
    public List<Impresora> filtrarImpresoraModelo(@PathVariable String modelo) {
        return service.findByModeloContainingIgnoreCase(modelo);
    }

    // busqueda por el nombre de marca
    @GetMapping("/buscar-marca/{nombre}")
    public List<Impresora> filtrarImpresoraMarca(@PathVariable String nombre) {
        return service.findByMarcaNombreContainingIgnoreCase(nombre);
    }

}

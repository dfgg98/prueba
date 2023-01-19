/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.com.ec.prueba.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prueba.com.ec.prueba.model.Cancion;
import prueba.com.ec.prueba.service.CancionService;

/**
 *
 * @author Danny Gutama
 */
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/cliente")
public class CancionControlers {
    
     @Autowired
     CancionService cancionService;
    

    @GetMapping("/listar")
    public ResponseEntity< List<Cancion>> obtenerLista() {
        return new ResponseEntity<>(cancionService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Cancion> crear(@RequestBody Cancion c){
     return new ResponseEntity<>(cancionService.save(c), HttpStatus.CREATED);
    }
    
      @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Cancion> eliminar(@PathVariable Integer id) {
        cancionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cancion> actualizarUsuario(@PathVariable Integer id, @RequestBody Cancion c) {
        Cancion cancion = cancionService.findById(id);
        if (cancion == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                cancion.setNombre(c.getNombre());
                cancion.setTitulo(c.getTitulo());
                cancion.setAlbum(c.getAlbum());
                cancion.setYear(c.getYear());
                
                return new ResponseEntity<>(cancionService.save(cancion), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
    
}

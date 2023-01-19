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
import prueba.com.ec.prueba.model.ListaReproducion;
import prueba.com.ec.prueba.service.ListaReproducionService;

/**
 *
 * @author Danny Gutama
 */
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/cancion")
public class ListaReproducionControlers {
    @Autowired
     ListaReproducionService  listaReproducionService;
    

    @GetMapping("/listar")
    public ResponseEntity< List<ListaReproducion>> obtenerLista() {
        return new ResponseEntity<>(listaReproducionService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<ListaReproducion> crear(@RequestBody ListaReproducion lp){
     return new ResponseEntity<>(listaReproducionService.save(lp), HttpStatus.CREATED);
    }
    
      @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ListaReproducion> eliminar(@PathVariable Integer id) {
        listaReproducionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ListaReproducion> actualizarUsuario(@PathVariable Integer id, @RequestBody ListaReproducion lp) {
        ListaReproducion listaReproducion  = listaReproducionService.findById(id);
        if (listaReproducionService == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                listaReproducion.setDescripcion(lp.getDescripcion());
                listaReproducion.setId_lista(lp.getId_lista());
             listaReproducion.setSongs(lp.getSongs());
                
                return new ResponseEntity<>(listaReproducionService.save(listaReproducion), HttpStatus.CREATED);
            } catch (Exception l) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
    
}

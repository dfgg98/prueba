/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.com.ec.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import prueba.com.ec.prueba.model.Cancion;
import prueba.com.ec.prueba.repository.CancionRepository;

/**
 *
 * @author Danny Gutama
 */
public class CancionServiceImpl extends GenericServiceImpl<Cancion, Integer> implements  CancionService{
     @Autowired
     CancionRepository cancionRepository;

    @Override
    public CrudRepository<Cancion, Integer> getDao() {
        return cancionRepository;
    }

    public Cancion buscarCancion(String nombre) {
        return cancionRepository.buscarCancion(nombre);
    }

    
}

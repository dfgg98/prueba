/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.com.ec.prueba.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import prueba.com.ec.prueba.model.ListaReproducion;
import prueba.com.ec.prueba.repository.ListaReproducionRepository;

/**
 *
 * @author Danny Gutama
 */

@Service
public class ListaReproducionImpl extends GenericServiceImpl<ListaReproducion, Integer > implements ListaReproducionService{

    @Autowired
    ListaReproducionRepository listaReproducionRepository;

    @Override
    public CrudRepository<ListaReproducion, Integer> getDao() {
        return listaReproducionRepository;
    }

    public ListaReproducion buscarListaReproducion(String songs) {
        return listaReproducionRepository.buscarReproducion(songs);
    }

}

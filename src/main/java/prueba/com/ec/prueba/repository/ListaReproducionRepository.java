/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package prueba.com.ec.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import prueba.com.ec.prueba.model.ListaReproducion;

/**
 *
 * @author Danny Gutama
 */
public interface ListaReproducionRepository extends JpaRepository<ListaReproducion, Integer>{
 @Query(value = "Select * from listaReproducion lp where  lp.songs=:songs", nativeQuery = true)
 public ListaReproducion buscarReproducion(String songs);
}

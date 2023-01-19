/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package prueba.com.ec.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import prueba.com.ec.prueba.model.Cancion;

/**
 *
 * @author Danny Gutama
 */
public interface CancionRepository extends JpaRepository<Cancion, Integer>{

 @Query(value = "Select * from cancion c where  c.nombre =:nombre", nativeQuery = true)
 public Cancion buscarCancion(String nombre);
    
}

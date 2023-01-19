/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.com.ec.prueba.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Danny Gutama
 */
@Getter
@Setter
@Entity
public class Cancion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_cancion")
    private int id_cancion;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "album")
    private String album;
    @Column(name = "year")
    private int year;
    
    
    
}

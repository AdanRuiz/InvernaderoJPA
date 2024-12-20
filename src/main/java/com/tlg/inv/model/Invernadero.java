//Invernadero.java
package com.tlg.inv.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "invernadero")
public class Invernadero {

    private static final Logger logger = LoggerFactory.getLogger(Invernadero.class);

    @Transient
    private final ActuadorRiegoFactory actuadorRiegoFactory;

    @Transient
    private ActuadorRiego actuadorRiego;

    @Column(name = "actuador_riego")
    private String tipoActuadorRiego;

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invernaderoId;
    
    private String name;

    // Ahora con la base de datos, el campo id se autogenera
    public Invernadero(int id, String tipo) {
        this.invernaderoId = id;
        this.actuadorRiegoFactory = new ActuadorRiegoFactory();
        this.actuadorRiego = actuadorRiegoFactory.createActuadorRiego(tipo);
        tipoActuadorRiego = tipo;
    }

    public Invernadero(String name, String tipo) {
        this.actuadorRiegoFactory = new ActuadorRiegoFactory();
        this.actuadorRiego = actuadorRiegoFactory.createActuadorRiego(tipo);
        tipoActuadorRiego = tipo;
    }

    public Invernadero(int id, String name, String tipo) {
        this.invernaderoId=id;
        this.name=name;
        this.actuadorRiegoFactory = new ActuadorRiegoFactory();
        this.actuadorRiego = actuadorRiegoFactory.createActuadorRiego(tipo);
        tipoActuadorRiego = tipo;
    }
    
    public Invernadero() { 
        this(-1, "normal"); 
    }

    public int getInvernaderoId() {
        return invernaderoId;
    }

    
    public String getName() {
        return name;
    }

    public String getTipoActuadorRiego() { 
        return getActuadorRiego(); 
    }

    public String getActuadorRiego() { 
        return actuadorRiego.getClass().getSimpleName(); 
    }

    public void setTipoActuadorRiego(String tipoActuadorRiego) {
        setActuadorRiego(tipoActuadorRiego);
    }

    public void setActuadorRiego(String tipoActuadorRiego) {
        logger.info("setActuadorRiego "+tipoActuadorRiego);
        this.actuadorRiego = actuadorRiegoFactory.createActuadorRiego(tipoActuadorRiego);
        this.tipoActuadorRiego = actuadorRiego.getClass().getSimpleName();
    }
    

    public void setInvernaderoId(int id) {
        this.invernaderoId = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void regar() {
        actuadorRiego.activar();
        System.out.println("Invernadero "+invernaderoId+" regando.");
    }

    @PostLoad
    public void postLoad() {
        this.actuadorRiego = actuadorRiegoFactory.createActuadorRiego(tipoActuadorRiego);
    }

    @Override
    public String toString() { 
        return "{" + "\"invernaderoId\": \"" + invernaderoId + "\",\"name\": \"" + (name != null ? name : "") + "\"," + "\"actuadorRiego\": \"" + actuadorRiego.getClass().getSimpleName() + "\"," + "\"actuador_riego\": \"" + tipoActuadorRiego + "\"" + "}";
    }
}

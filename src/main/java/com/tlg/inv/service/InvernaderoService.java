// InvernaderoService.java
package com.tlg.inv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlg.inv.model.Invernadero;
import com.tlg.inv.repository.InvernaderoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class InvernaderoService {
    private static final Logger logger = LoggerFactory.getLogger(InvernaderoService.class);

    @Autowired
    private InvernaderoRepository invernaderoRepository;     
    
    public List<Invernadero> obtenerTodosLosInvernaderos() {
        return invernaderoRepository.findAll();
    }

    public Optional<Invernadero> obtenerInvernaderoPorId(Long id) {
        return invernaderoRepository.findById(id);
    }

    public void agregarInvernadero(Invernadero invernadero) {
        invernaderoRepository.save(invernadero);
    }

}




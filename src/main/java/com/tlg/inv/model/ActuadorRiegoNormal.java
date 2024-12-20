//ActuadorRiegoNormal.java
package com.tlg.inv.model;

import org.springframework.stereotype.Component;

@Component
public class ActuadorRiegoNormal implements ActuadorRiego {
    @Override
    public void activar() {
        System.out.println("Actuador de riego normal activado.");
    }
}

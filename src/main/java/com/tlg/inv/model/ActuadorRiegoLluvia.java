//ActuadorRiegoLluvia.java
package com.tlg.inv.model;

import org.springframework.stereotype.Component;

@Component
public class ActuadorRiegoLluvia implements ActuadorRiego {
    @Override
    public void activar() {
        System.out.println("Actuador de riego con agua de lluvia activado.");
    }
}

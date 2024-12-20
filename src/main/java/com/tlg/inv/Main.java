/*//Main.java
package com.tlg.inv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.tlg.inv")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        // Obtener una nueva instancia de Invernadero cada vez
        Invernadero invernadero1 = context.getBean(Invernadero.class);
        invernadero1.setIdInvernadero("Inv1");
        invernadero1.regar();

        Invernadero invernadero2 = context.getBean(Invernadero.class);
        invernadero2.setIdInvernadero("Inv2");
        invernadero2.setActuadorRiego("lluvia");
        invernadero2.regar();
    }
}*/


// Main.java
package com.tlg.inv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

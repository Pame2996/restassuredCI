package basicJUnit;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BasicJUnit {
    @BeforeEach
    void inicializar(){
        System.out.println("Inicializando");
    }

    @AfterEach
    void finalizar(){
        System.out.println("Finalizado");
    }

    @Order(1)
    @Test
    void crearProyecto(){
        System.out.println("Creando proyecto");
    }

    @Order(2)
    @Test
    void actualizarProyecto(){
        System.out.println("Actualizando proyecto");
    }
}

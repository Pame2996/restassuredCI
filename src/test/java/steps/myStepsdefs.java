package steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class myStepsdefs {
    @Given("que tengo acceso a {}")
    public void queTengaAccesoaFB(String appName){
        System.out.println("Step que tengo acceso a " + appName);
    }

    @When("ingreso mi email: {word}")
    public void ingresoMiEmailPamelaNeyraGmailCom(String email) {
        System.out.println("Step ingreso mi email: " + email);
    }

    @And("ingreso mi password {string}")
    public void ingresoMiPassword(String password) {
        System.out.println("Step ingreso mi passsword " + password);
    }

    @Then("hago clic en el botón de iniciar sesión")
    public void hagoClicEnElBotónDeIniciarSesión() {
        System.out.println("Step inicio sesión");
    }

    @And("muestra la página principal")
    public void muestraLaPáginaPrincipal() {
        System.out.println("Step muestra página principal");
    }

    @And("no muestra la página principal")
    public void noMuestraLaPáginaPrincipal() {
        System.out.println("Step no muestra página principal");
    }

    @And("deberia ver los siguientes menus")
    public void deberiaVerLosSiguientesMenus(List<String> menus) {
       for (String menu : menus) {
           System.out.println(menu);
       }
    }

    @When("me registro con")
    public void meRegistroCon(Map<String, String> data) {
        data.forEach((key, value) -> {
            System.out.println("Clave: " + key + " - Valor: " + value);
        });
    }
/*
    @When("me registro usando")
    public void meRegistroUsando(Persona persona) {
        System.out.println("Persona: ");
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Apellido: " + persona.getApellido());
        System.out.println("Telefono: " + persona.getTelefono());
        System.out.println("Direccion: " + persona.getDireccion());
        System.out.println("DNI: " + persona.getDni());
    }
 */

    @When("me registro usando")
    public void meRegistroUsando(List<Persona> personas) {
        for (Persona persona : personas) {
            System.out.println("Persona: ");
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Apellido: " + persona.getApellido());
            System.out.println("Telefono: " + persona.getTelefono());
            System.out.println("Direccion: " + persona.getDireccion());
            System.out.println("DNI: " + persona.getDni());
        }
    }

    @DataTableType
    public Persona convertToPersona(Map<String, String> data) {
        Persona persona = new Persona();
        persona.setNombre(data.get("nombre"));
        persona.setApellido(data.get("apellidos"));
        persona.setTelefono(data.get("telefono"));
        persona.setDireccion(data.get("direccion"));
        persona.setDni(data.get("dni"));
        return persona;
    }

    @Then("deberia ver sus terminos de aceptacion")
    public void deberiaVerSusTerminosDeAceptacion(String data) {
        System.out.println("Término de aceptación \n" + data);
    }
}

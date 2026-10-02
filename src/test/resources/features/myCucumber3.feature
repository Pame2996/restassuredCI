Feature: Login

  Background: init
    Given que tengo acceso a Instagram
    When ingreso mi email: pamela.neyra2996@gmail.com

Rule: Credenciales válidas
  Scenario: Como usuario quiero ingresar un email y password para iniciar sesión
    And ingreso mi password "Todoly2026."
    Then hago clic en el botón de iniciar sesión
    And muestra la página principal

Rule: Credenciales inválidas
    Scenario: Como usuario quiero ingresar un email sin password para obtener una validación
    Then hago clic en el botón de iniciar sesión
    And no muestra la página principal

  Scenario: Como usuario quiero ingresar un email y password pero no hago clic en el botón iniciar sesión
    And ingreso mi password "Todoly2026."
    And no muestra la página principal
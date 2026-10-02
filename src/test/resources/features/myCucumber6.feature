Feature: Login
  Scenario: Como usuario quiero ingresar un email y password para iniciar sesión
    Given que tengo acceso a Instagram
    When me registro usando
      |nombre|apellidos|telefono|direccion|dni|
      |juan  |perez    |123     |peru     |12345678|
    Then muestra la página principal

Feature: Login
  Scenario: Como usuario quiero ingresar un email y password para iniciar sesión
    Given que tengo acceso a Instagram
    When me registro usando
      |nombre|apellidos|telefono|direccion|dni|
      |juan  |perez    |123     |peru     |12345678|
      |Pamela|Neyra    |1111111 |Lima     |22222222|
    Then muestra la página principal

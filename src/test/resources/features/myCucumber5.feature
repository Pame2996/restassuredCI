Feature: Login
  Scenario: Como usuario quiero ingresar un email y password para iniciar sesión
    Given que tengo acceso a Instagram
    When me registro con
    |nombre|carlos|
    |apellidos| perez|
    |telefono | 123  |
    |direccion|peru  |
    |dni      |1234  |
    Then muestra la página principal

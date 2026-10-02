Feature: Login
  Scenario Outline: Como usuario quiero ingresar un email y password para iniciar sesión
    Given que tengo acceso a Instagram
    When ingreso mi email: <email>
      And ingreso mi password "<password>"
    Then hago clic en el botón de iniciar sesión
      And muestra la página principal

    Examples:
    | email | password |
    | usuario1@gmail.com | admin1 |
    | usuario2@gmail.com | admin2 |
    | usuario3@gmail.com | admin3 |
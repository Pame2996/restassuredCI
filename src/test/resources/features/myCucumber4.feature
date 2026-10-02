Feature: Login
  Scenario: Como usuario quiero ingresar un email y password para iniciar sesión
    Given que tengo acceso a Instagram
    When ingreso mi email: <email>
    And ingreso mi password "<password>"
    Then hago clic en el botón de iniciar sesión
    And muestra la página principal
    And deberia ver los siguientes menus
    |Configuración|
    |Publicaciones|
    |Ajustes      |
    |Perfil       |
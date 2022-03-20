Feature: Registrarse en la plataforma
  As usuario
  I want to registrarme en la plataforma
  So that poder acceder a los servicios del negocio

  Scenario: Registro no exitoso
    Given que diligencio solamente mi correo "sydney@fife" en la pagina de registro
    When intente registrarme
    Then recibire como mensaje "Missing password"
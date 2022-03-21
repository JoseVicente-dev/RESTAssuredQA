Feature: Actualizacion de usuarios
  As administrador del sistema
  I want to actualizar perfiles para los usuarios registrados
  So that poder otorgarles permisos y funciones dentro del aplicativo

  Scenario: Actualizar usuario
    Given que como administrador actualice el usuario con nombre "morpheus" y cargo "zion resident".
    When envie la orden hasta la base de datos
    Then se actualizara el usuario con sus nuevos datos
Feature: Creacion de usuarios
  As administrador del sistema
  I want to crear perfiles para los usuarios registrados
  So that poder otorgarles permisos y funciones dentro del aplicativo

  Scenario: Crear usuario
    Given que como administrador cree el usuario con nombre "morpheus" y cargo "leader"
    When envie la orden a la base de datos
    Then se creara un nuevo usuario con sus datos y un id
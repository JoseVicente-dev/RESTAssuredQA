Feature: Creacion de usuarios
  As administrador del sistema
  I want to crear perfiles para los usuarios registrados
  So that poder otorgarles permisos y funciones dentro del aplicativo

  Scenario: Crear usuario
    Given que como administrador ingreso al modulo de crear usuarios
    When cree el usuario con nombre "morpheus" y cargo "leader"
    Then se creara un nuevo usuario en la base de datos con sus datos y un id
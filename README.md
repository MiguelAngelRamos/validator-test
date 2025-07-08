# Proyecto sencillo: Validador de Usuario en Java

Este proyecto es un ejemplo profesional y didáctico de cómo estructurar, desarrollar y probar una lógica de validación de usuarios en Java usando Maven, JUnit 5 y Hamcrest.

## Caso de uso

El sistema valida los datos de un usuario (nombre, email y edad) para asegurar que cumplan con reglas básicas de negocio:
- El nombre debe tener al menos 3 caracteres y no estar vacío.
- El email debe tener formato válido (ejemplo: usuario@dominio.com).
- La edad debe ser mayor o igual a 18 años.

La clase principal de lógica es `ValidadorUsuario`, que expone métodos para validar cada campo y un método general para validar un usuario completo.

## Estructura del proyecto

```
src/
  main/
    java/
      cl/kibernumacademy/modelo/Usuario.java         # Modelo de usuario
      cl/kibernumacademy/util/ValidadorUsuario.java  # Lógica de validación
  test/
    java/
      cl/kibernumacademy/util/ValidadorUsuarioTest.java # Pruebas unitarias
```

## Pruebas unitarias

Las pruebas están implementadas con JUnit 5 y Hamcrest, e incluyen:
- **Aserciones tradicionales de JUnit:** `assertEquals`, `assertTrue`, `assertFalse`, `assertNotNull`.
- **Aserciones con Hamcrest:** `assertThat`, `is`, `not`, `allOf`, `containsString`, `greaterThanOrEqualTo`, etc.
- **Supuestos:** Uso de `assumeTrue` y `assumingThat` para condicionar la ejecución de tests.
- **Pruebas parametrizadas:** Con diferentes modelos y datos usando `@CsvSource` y `@MethodSource`.
- **Hooks de ciclo de vida:** `@BeforeEach` y `@AfterEach` para inicialización y limpieza.

Cada test está documentado y comentado para facilitar el aprendizaje.

## Ejecución

1. Clona o descarga el repositorio.
2. Asegúrate de tener Java 17+ y Maven instalados.
3. Ejecuta las pruebas con:
   ```
   mvn test
   ```

## Dependencias principales
- JUnit Jupiter (JUnit 5)
- Hamcrest

## Autor
Miguel Ramos
 
## Créditos
Desarrollado como ejemplo educativo para prácticas de pruebas unitarias modernas en Java.

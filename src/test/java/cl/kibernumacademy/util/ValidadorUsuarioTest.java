package cl.kibernumacademy.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*; 
import static org.junit.jupiter.api.Assumptions.*;

public class ValidadorUsuarioTest {

  private ValidadorUsuario validadorUsuario;

  @BeforeEach
  void setUp() {
    validadorUsuario = new ValidadorUsuario();
  }
  /* Métodos tradicionales con Junit 5 */
  @Test
  void testNombreValido() {
    assertTrue(validadorUsuario.esNombreValido("Sofia")); // Es un nombre válido
    assertFalse(validadorUsuario.esNombreValido("")); // vacio
    assertFalse(validadorUsuario.esNombreValido(null)); // null
    assertFalse(validadorUsuario.esNombreValido("A")); // nombre muy corto
    assertNotNull(validadorUsuario);
  }

  /* Métodos de Hamcrest */
  @Test
  void testEmailValido() {
    // - El email debe tener formato válido (ejemplo: usuario@dominio.com).
    assertThat(validadorUsuario.esEmailValido("sofia@correo.com"), is(true)); // valido
    assertThat(validadorUsuario.esEmailValido("sofia@correo"), is(false)); // sin dominio (.cl, .org, .com)
    assertThat(validadorUsuario.esEmailValido("correo.com"), is(false)); // sin @
    assertThat(validadorUsuario.esEmailValido(null), is(false)); // Esperaria que retorne false para null
  }

  


}

/*
 *  * Documentación breve de métodos usados:
 *
 * JUnit:
 * - assertEquals(a, b): verifica que a == b
 * - assertTrue(cond): verifica que cond es true
 * - assertFalse(cond): verifica que cond es false
 * - assertNotNull(obj): verifica que obj no es null
 * - @BeforeEach/@AfterEach: ejecutan métodos antes/después de cada test
 * - @ParameterizedTest: permite ejecutar un test con diferentes datos
 * - @CsvSource/@MethodSource: fuentes de datos para parametrizadas
 * - assumeTrue/assumingThat: omiten o condicionan tests según una condición
 *
 * Hamcrest:
 * - assertThat(valor, matcher): aserción flexible y legible
 * - is(x): compara igualdad
 * - not(x): niega un matcher
 * - allOf(...): combina varios matchers
 * - notNullValue(): verifica que no sea null
 * - blankString(): verifica que es string vacío o solo espacios
 * - containsString(x): verifica que contiene un substring
 * - greaterThanOrEqualTo(x): compara valores numéricos
 */
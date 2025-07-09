package cl.kibernumacademy.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import cl.kibernumacademy.modelo.Usuario;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*; 
import static org.junit.jupiter.api.Assumptions.*;

import java.util.stream.Stream;

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
    assertThat(validadorUsuario.esEmailValido("sofia @correo.com"), is(false)); // valido
    assertThat(validadorUsuario.esEmailValido("sofia@correo"), is(false)); // sin dominio (.cl, .org, .com)
    assertThat(validadorUsuario.esEmailValido("correo.com"), is(false)); // sin @
    assertThat(validadorUsuario.esEmailValido("10"), is(false)); 
    assertThat(validadorUsuario.esEmailValido("sofia@correo.com  algo"), is(false)); 
    assertThat(validadorUsuario.esEmailValido("sofia@correo.com.ar"), is(true)); 
    assertThat(validadorUsuario.esEmailValido("sofia@correo.comm"), is(true)); 
    assertThat(validadorUsuario.esEmailValido("sofia@correo@com.com"), is(false)); 
    assertThat(validadorUsuario.esEmailValido("@correo.cl"), is(false)); 
    assertThat(validadorUsuario.esEmailValido(".@com.cl"), is(true)); 
    assertThat(validadorUsuario.esEmailValido(null), is(false)); // Esperaria que retorne false para null
    // sofia@correo.comm o sofia@correo@com.com
  }

  // La edad debe ser mayor o igual a 18 años. (Junit 5)
  @Test
  void testMayorDeEdad() {
    int edad = -20;
    assumeTrue(edad > 0, "La edad debe ser positiva"); // si no, el test se omite
    assertTrue(validadorUsuario.esMayorDeEdad(edad), "La edad debe ser mayor o igual a 18 años");
  }

  /* Prueba parametriza usando CsvSource: varios modelos y combinaciones */
  @ParameterizedTest
  @CsvSource({
    "Sofia, sofia@correo.com, 20, true",
    "Ana, ana@mail.com, 15, false",
    ", anonimo@correo.co, 22, false",
    "Richard, richard.stallman@correo, 30, false",
  })
  void testValidarUsuario(String nombre, String email, int edad, boolean esperado) {
    Usuario usuario = new Usuario(nombre, email, edad);
    assertEquals(esperado, validadorUsuario.validarUsuario(usuario));
  }

  /*Proveedor de usuarios validos */
  static Stream<Usuario> usuariosValidos() {
    return Stream.of(
      new Usuario("Sofia", "sofia@correo.com", 20),
      new Usuario("Richard", "richard@correo.com", 30));
  }

  @ParameterizedTest
  @MethodSource("usuariosValidos")
  void testUsuariosValidos(Usuario usuario) {
    assertThat(validadorUsuario.validarUsuario(usuario), is(true));
    assertThat(usuario.getNombre(), allOf(notNullValue(), not(blankString())));
    assertThat(usuario.getEmail(), containsString("@")); 
  }

  @Test
  void testValidarUsuarioAssumingThat() {
    Usuario usuario = new Usuario("Sofia", "sofia@correo.com", 10);
    // assertTrue(validadorUsuario.validarUsuario(usuario), "El usuario debe ser válido si es mayor de edad");
    assumingThat(validadorUsuario.esMayorDeEdad(usuario.getEdad()), () -> {
      System.out.println("Este mensaje solo aparece si es mayor de edad");
      assertTrue(validadorUsuario.validarUsuario(usuario), "El usuario debe ser válido si es mayor de edad");
    });

  }
}

/*
 *  * Documentación breve de métodos usados:
 *
 * JUnit:
 * - assertEquals(a, b): verifica que a == b
 * - assertTrue(cond): verifica que cond es true
 * - assertTrue(cond, msg): verifica que cond es true, muestra msg si falla
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
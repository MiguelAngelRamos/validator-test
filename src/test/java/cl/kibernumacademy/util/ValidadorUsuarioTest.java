package cl.kibernumacademy.util;

public class ValidadorUsuarioTest {
  
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
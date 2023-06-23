

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {

	@Test
	public void test(){
		// Teste de asserção que verifica se o valor booleano é verdadeiro
    	Assert.assertTrue(true);
    	// Teste de asserção que verifica se o valor booleano é falso
    	Assert.assertFalse(false);
		
		// Teste de asserção que verifica se dois valores inteiros são iguais
    	Assert.assertEquals("Erro de comparacao", 1, 1);
    	// Teste de asserção que verifica se dois valores double são iguais com uma margem de erro de 0.001
    	Assert.assertEquals(0.51234, 0.512, 0.001);
    	// Teste de asserção que verifica se o valor de PI é igual a 3.14 com uma margem de erro de 0.01
    	Assert.assertEquals(Math.PI, 3.14, 0.01);
		
		// Teste de asserção que verifica se dois valores inteiros são iguais, um deles é um objeto Integer
    	int i = 5;
    	Integer i2 = 5;
    	Assert.assertEquals(Integer.valueOf(i), i2);
    	// Teste de asserção que verifica se dois valores inteiros são iguais, um deles é um objeto Integer
    	Assert.assertEquals(i, i2.intValue());
		
		// Teste de asserção que verifica se duas strings são iguais
    	Assert.assertEquals("bola", "bola");
    	// Teste de asserção que verifica se duas strings são diferentes
    	Assert.assertNotEquals("bola", "casa");
    	// Teste de asserção que verifica se duas strings são iguais, ignorando diferenças de maiúsculas e minúsculas
    	Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
    	// Teste de asserção que verifica se uma string começa com um determinado prefixo
    	Assert.assertTrue("bola".startsWith("bo"));
		
		// Teste de asserção que verifica se dois objetos Usuario são iguais
    	Usuario u1 = new Usuario("Usuario 1");
    	Usuario u2 = new Usuario("Usuario 1");
    	Usuario u3 = null;
    	Assert.assertEquals(u1, u2);
		
		// Teste de asserção que verifica se dois objetos são o mesmo objeto
    	Assert.assertSame(u2, u2);
    	// Teste de asserção que verifica se dois objetos não são o mesmo objeto
    	Assert.assertNotSame(u1, u2);

    	// Teste de asserção que verifica se um objeto é nulo
    	Assert.assertNull(u3);
    	// Teste de asserção que verifica se um objeto não é nulo
    	Assert.assertNotNull(u2);
	}
}

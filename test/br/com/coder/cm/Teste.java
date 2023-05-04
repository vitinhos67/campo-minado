package br.com.coder.cm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Teste {

	@Test
	void testIfNumberAreEqualAreTwo() {
		
		int a = 1 + 1;
		
		
		assertEquals(2, a);		
		
		
	}
	
	@Test
	void testStringAreEqual() {
		
	
		String pharse = "Me leva junto com voce";
		
		assertEquals("Me leva junto com voce", pharse);
		
		
	}
	

}

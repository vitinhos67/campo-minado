package br.com.coder.cm;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.coder.cm.exception.ExplosionException;
import br.com.coder.cm.model.Campo;

public class CampoTest {
	
	private Campo campo;
	
	@BeforeEach
	void initializeCampo() {
		this.campo = new Campo(3, 3);
	}
	
	
	@Test
	void NeighborTestDistance() {
	 
		Campo neighbor =  new Campo (3, 4);
		
		boolean result = campo.addNeighBors(neighbor);
		
		assertTrue(result);
		
	}
	
	@Test
	void isMarkedLikeFalse() {
		
		assertFalse(campo.isMarked());
		
	}
	@Test
	void isMarkedLikeTrue() {

		assertTrue(!campo.isMarked());
		
	}
	
	@Test
	void openCampo() {
		assertTrue(campo.openCampo());
	}
	
	@Test
	void openCampoMarked() {
		
		
		campo.changeMarking();
		
		assertFalse(campo.openCampo());
	}
	@Test
	void openCampoMarkedAndUndermined() {
		
		campo.changeMarking();
		campo.minar();
		assertFalse(campo.openCampo());
	}
	@Test
	void GameOverThrowException() {

		campo.minar();
		
		assertThrows(ExplosionException.class, () -> {
			assertFalse(campo.openCampo());
		});
		
		
	}
	@Test
	void testOpenNeighbour() {
		
		
		Campo campo1 = new Campo(1,1);
		Campo campo2 = new Campo(2,2);
		
		
		campo2.addNeighBors(campo1);
		campo.addNeighBors(campo2);
		campo.openCampo();
		
		assertTrue(campo2.isOpened() && campo1.isOpened());
		
		
		
	}
	
	
}

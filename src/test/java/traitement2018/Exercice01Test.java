package traitement2018;

import org.junit.Test;

import traitement2018.Traitement01;

import static org.junit.Assert.*;

public class Exercice01Test{

	@Test
	public void traitementTest(){
		Traitement01 exercice1 = new Traitement01();

		assertEquals(0,exercice1.traitement());
	}

}
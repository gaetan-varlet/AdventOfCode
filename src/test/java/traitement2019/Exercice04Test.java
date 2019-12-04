package traitement2019;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class Exercice04Test {

	@Test
	public void traitement() throws IOException {
		Traitement04 traitement = new Traitement04();
		traitement.traitement("265275-781584");
		assertEquals(960, traitement.getNombreSolutionsPart1());
		assertEquals(626, traitement.getNombreSolutionsPart2());
	}

	@Test
	public void twoAdjacentDigitsExactlyForAtLeastOneDigitTest(){
		Traitement04 traitement = new Traitement04();
		assertTrue(traitement.twoAdjacentDigitsExactlyForAtLeastOneDigit(112233));
		assertFalse(traitement.twoAdjacentDigitsExactlyForAtLeastOneDigit(123444));
		assertTrue(traitement.twoAdjacentDigitsExactlyForAtLeastOneDigit(111122));
		assertTrue(traitement.twoAdjacentDigitsExactlyForAtLeastOneDigit(122444));
	}

}
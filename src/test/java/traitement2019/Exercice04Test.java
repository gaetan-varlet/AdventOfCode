package traitement2019;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class Exercice04Test {

	@Test
	public void traitement() throws IOException {
		Traitement04 traitement = new Traitement04();
		traitement.traitement("265275-781584");
		assertEquals(960, traitement.getNombreSolutions());
	}

}
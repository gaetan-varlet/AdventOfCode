package traitement2017;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import utils.MonReader;

public class Exercice06Test {

	private Charset charset = StandardCharsets.UTF_8;

	@Test
	public void exercice6TestA1() throws IOException {
		MonReader monReader = new MonReader();
		Traitement06 traitement6 = new Traitement06();
		monReader.addLigneListener(traitement6);
		monReader.lireFichier("src/test/resources/traitement2017/inputTestExercice06a.txt", charset);

		assertEquals(5, traitement6.getNombreDeTour());
		assertEquals(4, traitement6.getTailleCycle());
	}

	@Test
	public void exercice6TestA2() throws IOException {
		MonReader monReader = new MonReader();
		Traitement06 traitement6 = new Traitement06();
		monReader.addLigneListener(traitement6);
		monReader.lireFichier("src/test/resources/traitement2017/inputExercice06.txt", charset);

		assertEquals(7864, traitement6.getNombreDeTour());
		assertEquals(1695, traitement6.getTailleCycle());
	}

}
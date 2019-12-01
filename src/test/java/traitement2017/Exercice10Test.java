package traitement2017;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import traitement2017.Traitement10;
import utils.MonReader;

public class Exercice10Test {

	private Charset charset = StandardCharsets.UTF_8;

	@Test
	public void exercice10TestA1() throws IOException {
		MonReader monReader = new MonReader();
		Traitement10 traitement10 = new Traitement10();
		traitement10.setLongueurListe(5);
		monReader.addLigneListener(traitement10);
		monReader.lireFichier("src/test/resources/traitement2017/inputTestExercice10a.txt", charset);
		assertEquals(12, traitement10.getResultat());
	}

	@Test
	public void exercice10TestA2() throws IOException {
		MonReader monReader = new MonReader();
		Traitement10 traitement10 = new Traitement10();
		traitement10.setLongueurListe(256);
		monReader.addLigneListener(traitement10);
		monReader.lireFichier("src/test/resources/traitement2017/inputExercice10.txt", charset);
		assertEquals(4114, traitement10.getResultat());
	}

}
package traitement2019;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import utils.MonReader;

public class Exercice02Test {

	private static Charset charset = StandardCharsets.UTF_8;

	@Test
	public void traitementTest1() throws IOException {
		MonReader monReader = new MonReader();
		Traitement02 traitement2 = new Traitement02();
		monReader.addLigneListener(traitement2);
		monReader.lireFichier("src/test/resources/traitement2019/inputExercice02Test1.txt", charset);
	}

	@Test
	public void traitement() throws IOException {
		MonReader monReader = new MonReader();
		Traitement02 traitement2 = new Traitement02();
		monReader.addLigneListener(traitement2);
		monReader.lireFichier("src/test/resources/traitement2019/inputExercice02.txt", charset);
	}

}
package traitement2019;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.junit.Test;
import utils.MonReader;

public class Exercice01Test {

	private static Charset charset = StandardCharsets.UTF_8;

	@Test
	public void traitementTest1() throws IOException {
		MonReader monReader = new MonReader();
		Traitement01 traitement1 = new Traitement01();
		monReader.addLigneListener(traitement1);
		monReader.lireFichier("src/test/resources/traitement2019/inputExercice01Test1.txt", charset);

		assertEquals((2 + 2 + 654 + 33583), traitement1.getSomme());
	}

	@Test
	public void traitement() throws IOException {
		MonReader monReader = new MonReader();
		Traitement01 traitement1 = new Traitement01();
		monReader.addLigneListener(traitement1);
		monReader.lireFichier("src/test/resources/traitement2019/inputExercice01.txt", charset);

		assertEquals(3126794, traitement1.getSomme());
	}

}
package traitement2017;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import utils.MonReader;

public class Exercice02Test {

	private static String file = "src/test/resources/traitement2017/inputExercice02.txt";
	private static Charset charset = StandardCharsets.UTF_8;

	@Test
	public void traitementTest() throws IOException {
		MonReader monReader = new MonReader();
		Traitement02A traitement2A = new Traitement02A();
		monReader.addLigneListener(traitement2A);
		Traitement02B traitement2B = new Traitement02B();
		monReader.addLigneListener(traitement2B);
		monReader.lireFichier(file, charset);

		assertEquals(42299, traitement2A.getSomme());
		assertEquals(277, traitement2B.getSomme());
	}
}
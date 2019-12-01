package traitement2018;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import utils.MonReader;

public class Exercice05Test {

	private static Charset charset = StandardCharsets.UTF_8;

	@Test
	public void traitementTest1() throws IOException {
		MonReader monReader = new MonReader();
		Traitement05 traitement = new Traitement05();
		monReader.addLigneListener(traitement);
		monReader.lireFichier("src/test/resources/traitement2018/inputExercice05Test1.txt", charset);

		assertEquals(10, traitement.getNombreLettresRestantesDansLaFormule());
		assertEquals(4, traitement.getNombreLettresRestantesDansLaFormuleSimplifiee());
	}

	@Test
	public void traitement() throws IOException {
		MonReader monReader = new MonReader();
		Traitement05 traitement = new Traitement05();
		monReader.addLigneListener(traitement);
		monReader.lireFichier("src/test/resources/traitement2018/inputExercice05.txt", charset);

		assertEquals(11894, traitement.getNombreLettresRestantesDansLaFormule());
		assertEquals(5310, traitement.getNombreLettresRestantesDansLaFormuleSimplifiee());
	}

}
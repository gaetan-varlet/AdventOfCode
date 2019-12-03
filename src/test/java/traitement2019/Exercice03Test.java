package traitement2019;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.MonReader;

public class Exercice03Test {

	private static Charset charset = StandardCharsets.UTF_8;

	MonReader monReader;
	Traitement03 traitement;

	@BeforeEach
	public void init() {
		monReader = new MonReader();
		traitement = new Traitement03();
		monReader.addLigneListener(traitement);
		monReader.setClotureListener(traitement);
	}

	@Test
	public void traitementTest1() throws IOException {
		monReader.lireFichier("src/test/resources/traitement2019/inputExercice03Test1.txt", charset);
		assertEquals(6, traitement.getManhattanDistance());
		assertEquals(30, traitement.getMinSumSteps());
	}

	@Test
	public void traitementTest2() throws IOException {
		monReader.lireFichier("src/test/resources/traitement2019/inputExercice03Test2.txt", charset);
		assertEquals(159, traitement.getManhattanDistance());
		assertEquals(610, traitement.getMinSumSteps());
	}

	@Test
	public void traitementTest3() throws IOException {
		monReader.lireFichier("src/test/resources/traitement2019/inputExercice03Test3.txt", charset);
		assertEquals(135, traitement.getManhattanDistance());
		assertEquals(410, traitement.getMinSumSteps());
	}

	@Test
	public void traitement() throws IOException {
		monReader.lireFichier("src/test/resources/traitement2019/inputExercice03.txt", charset);
		assertEquals(266, traitement.getManhattanDistance());
		assertEquals(19242, traitement.getMinSumSteps());
	}

}
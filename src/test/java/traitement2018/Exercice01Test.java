package traitement2018;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import utils.MonReader;

public class Exercice01Test {

	private static Charset charset = StandardCharsets.UTF_8;

	@Test
	public void traitementTest1() throws IOException {
		MonReader monReader = new MonReader();
		Traitement01 traitement1 = new Traitement01();
		monReader.addLigneListener(traitement1);
		monReader.setClotureListener(traitement1);
		monReader.lireFichier("src/test/resources/traitement2018/inputExercice01Test1.txt", charset);

		assertEquals(4, traitement1.getSomme());
		assertEquals(Integer.valueOf(10), traitement1.getPremierNombreEnDouble());
	}

	@Test
	public void traitementTest2() throws IOException {
		MonReader monReader = new MonReader();
		Traitement01 traitement1 = new Traitement01();
		monReader.addLigneListener(traitement1);
		monReader.setClotureListener(traitement1);
		monReader.lireFichier("src/test/resources/traitement2018/inputExercice01Test2.txt", charset);

		assertEquals(4, traitement1.getSomme());
		assertEquals(Integer.valueOf(5), traitement1.getPremierNombreEnDouble());
	}

	@Test
	public void traitementTest3() throws IOException {
		MonReader monReader = new MonReader();
		Traitement01 traitement1 = new Traitement01();
		monReader.addLigneListener(traitement1);
		monReader.setClotureListener(traitement1);
		monReader.lireFichier("src/test/resources/traitement2018/inputExercice01Test3.txt", charset);

		assertEquals(1, traitement1.getSomme());
		assertEquals(Integer.valueOf(14), traitement1.getPremierNombreEnDouble());
	}

	@Test
	public void traitement() throws IOException {
		MonReader monReader = new MonReader();
		Traitement01 traitement1 = new Traitement01();
		monReader.addLigneListener(traitement1);
		monReader.setClotureListener(traitement1);
		monReader.lireFichier("src/test/resources/traitement2018/inputExercice01.txt", charset);

		assertEquals(423, traitement1.getSomme());
		assertEquals(Integer.valueOf(61126), traitement1.getPremierNombreEnDouble());
	}

}
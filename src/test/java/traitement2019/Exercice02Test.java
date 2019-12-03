package traitement2019;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utils.MonReader;

public class Exercice02Test {

	private static Charset charset = StandardCharsets.UTF_8;

	MonReader monReader;
	Traitement02 traitement2;

	@BeforeEach
	public void init() {
		monReader = new MonReader();
		traitement2 = new Traitement02();
		monReader.addLigneListener(traitement2);
		monReader.setClotureListener(traitement2);
	}

	@Test
	public void traitementTest1() throws IOException {
		monReader.lireFichier("src/test/resources/traitement2019/inputExercice02Test1.txt", charset);
		assertEquals(3500, traitement2.getResultat());
	}

	@Test
	public void traitementTest2() throws IOException {
		monReader.lireFichier("src/test/resources/traitement2019/inputExercice02Test2.txt", charset);
		assertEquals(2, traitement2.getResultat());
	}

	@Test
	public void traitementTest3() throws IOException {
		monReader.lireFichier("src/test/resources/traitement2019/inputExercice02Test3.txt", charset);
		assertEquals(2, traitement2.getResultat());
	}

	@Test
	public void traitementTest4() throws IOException {
		monReader.lireFichier("src/test/resources/traitement2019/inputExercice02Test4.txt", charset);
		assertEquals(2, traitement2.getResultat());
	}

	@Test
	public void traitementTest5() throws IOException {
		monReader.lireFichier("src/test/resources/traitement2019/inputExercice02Test5.txt", charset);
		assertEquals(30, traitement2.getResultat());
	}

	@Test
	public void traitement() throws IOException {
		monReader.lireFichier("src/test/resources/traitement2019/inputExercice02.txt", charset);
		assertEquals(4023471, traitement2.getResultat());
		assertEquals(8051, traitement2.getResultat2());
	}

}
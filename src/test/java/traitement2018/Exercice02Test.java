package traitement2018;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import utils.MonReader;

public class Exercice02Test{

	private static Charset charset = StandardCharsets.UTF_8;

	@Test
	public void traitementTest1() throws IOException{	
		MonReader monReader = new MonReader();
		Traitement02 traitement = new Traitement02();
		monReader.addLigneListener(traitement);
		monReader.setClotureListener(traitement);
		monReader.lireFichier("src/test/resources/traitement2018/inputExercice02Test1.txt", charset);

		assertEquals(12, traitement.getChecksum());
	}
	
	@Test
	public void traitementTest2() throws IOException{	
		MonReader monReader = new MonReader();
		Traitement02 traitement = new Traitement02();
		monReader.addLigneListener(traitement);
		monReader.setClotureListener(traitement);
		monReader.lireFichier("src/test/resources/traitement2018/inputExercice02Test2.txt", charset);

		assertEquals("fgij", traitement.getLettresEnCommun());
	}
	
	@Test
	public void traitement() throws IOException{	
		MonReader monReader = new MonReader();
		Traitement02 traitement = new Traitement02();
		monReader.addLigneListener(traitement);
		monReader.setClotureListener(traitement);
		monReader.lireFichier("src/test/resources/traitement2018/inputExercice02.txt", charset);

		assertEquals(7776, traitement.getChecksum());
		assertEquals("wlkigsqyfecjqqmnxaktdrhbz", traitement.getLettresEnCommun());
	}

}
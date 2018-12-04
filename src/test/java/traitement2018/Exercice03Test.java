package traitement2018;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import utils.MonReader;

public class Exercice03Test{

	private static Charset charset = StandardCharsets.UTF_8;

	@Test
	public void traitementTest1() throws IOException{	
		MonReader monReader = new MonReader();
		Traitement03 traitement = new Traitement03();
		monReader.addLigneListener(traitement);
		monReader.setClotureListener(traitement);
		monReader.lireFichier("src/test/resources/traitement2018/inputExercice03Test1.txt", charset);

		assertEquals(4, traitement.getNombreDeSuperposition());
		assertEquals("3", traitement.getIdRectangleSansSuperposition());
	}
	
	@Test
	public void traitement() throws IOException{	
		MonReader monReader = new MonReader();
		Traitement03 traitement = new Traitement03();
		monReader.addLigneListener(traitement);
		monReader.setClotureListener(traitement);
		monReader.lireFichier("src/test/resources/traitement2018/inputExercice03.txt", charset);

		assertEquals(108961, traitement.getNombreDeSuperposition());
		assertEquals("681", traitement.getIdRectangleSansSuperposition());
	}

}
package traitement2018;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import utils.MonReader;

public class Exercice04Test{

	private static Charset charset = StandardCharsets.UTF_8;

	@Test
	public void traitementTest1() throws IOException{	
		MonReader monReader = new MonReader();
		Traitement04 traitement = new Traitement04();
		monReader.addLigneListener(traitement);
		monReader.setClotureListener(traitement);
		monReader.lireFichier("src/test/resources/traitement2018/inputExercice04Test1.txt", charset);

		assertEquals(240, traitement.getResultat());
	}
	
	@Test
	public void traitement() throws IOException{	
		MonReader monReader = new MonReader();
		Traitement04 traitement = new Traitement04();
		monReader.addLigneListener(traitement);
		monReader.setClotureListener(traitement);
		monReader.lireFichier("src/test/resources/traitement2018/inputExercice04.txt", charset);

		assertEquals(240, traitement.getResultat());
	}
	


}
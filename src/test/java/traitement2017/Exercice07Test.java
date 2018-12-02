package traitement2017;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import utils.MonReader;


public class Exercice07Test{

	private Charset charset = StandardCharsets.UTF_8;


	@Test
	public void exercice7Test1() throws IOException {
		MonReader monReader = new MonReader();
		Traitement07 traitement = new Traitement07();
		monReader.addLigneListener(traitement);
		monReader.setClotureListener(traitement);
		monReader.lireFichier("src/test/resources/traitement2017/inputTestExercice07.txt", charset);	

		assertEquals("tknk",traitement.getNomPere());
	}
	
	@Test
	public void exercice7() throws IOException {
		MonReader monReader = new MonReader();
		Traitement07 traitement = new Traitement07();
		monReader.addLigneListener(traitement);
		monReader.setClotureListener(traitement);
		monReader.lireFichier("src/test/resources/traitement2017/inputExercice07.txt", charset);	

		assertEquals("bpvhwhh",traitement.getNomPere());
	}


}
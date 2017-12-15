
package exercice10;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import utils.MonReader;


public class Exercice10Test{

	private Charset charset = StandardCharsets.UTF_8;

	@Test
	public void exercice10TestA1() throws IOException {
		MonReader monReader = new MonReader();
		Traitement10 traitement10 = new Traitement10();
		traitement10.setLongueurListe(5);
		monReader.addLigneListener(traitement10);
		monReader.lireFichier("src/test/resources/inputTestExercice10a.txt", charset);		
		assertEquals(12, traitement10.getResultat());
	}
	
	@Test
	public void exercice10TestA2() throws IOException {
		MonReader monReader = new MonReader();
		Traitement10 traitement10 = new Traitement10();
		traitement10.setLongueurListe(256);
		monReader.addLigneListener(traitement10);
		monReader.lireFichier("src/test/resources/inputExercice10.txt", charset);		
		assertEquals(4114, traitement10.getResultat());
	}
}
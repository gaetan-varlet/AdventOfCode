package traitement2017;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import utils.MonReader;


public class Exercice11Test{

	private Charset charset = StandardCharsets.UTF_8;

	@Test
	public void exercice11TestA1() throws IOException {
		MonReader monReader = new MonReader();
		Traitement11 traitement11 = new Traitement11();
		monReader.addLigneListener(traitement11);
		monReader.lireFichier("src/test/resources/traitement2017/inputTestExercice11.1.txt", charset);		
		assertEquals(3, traitement11.getNombreDeplacementMinimum());
	}
	
	@Test
	public void exercice11TestA2() throws IOException {
		MonReader monReader = new MonReader();
		Traitement11 traitement11 = new Traitement11();
		monReader.addLigneListener(traitement11);
		monReader.lireFichier("src/test/resources/traitement2017/inputTestExercice11.2.txt", charset);		
		assertEquals(0, traitement11.getNombreDeplacementMinimum());
	}
	
	@Test
	public void exercice11TestA3() throws IOException {
		MonReader monReader = new MonReader();
		Traitement11 traitement11 = new Traitement11();
		monReader.addLigneListener(traitement11);
		monReader.lireFichier("src/test/resources/traitement2017/inputTestExercice11.3.txt", charset);		
		assertEquals(2, traitement11.getNombreDeplacementMinimum());
	}
	
	@Test
	public void exercice11TestA4() throws IOException {
		MonReader monReader = new MonReader();
		Traitement11 traitement11 = new Traitement11();
		monReader.addLigneListener(traitement11);
		monReader.lireFichier("src/test/resources/traitement2017/inputTestExercice11.4.txt", charset);		
		assertEquals(3, traitement11.getNombreDeplacementMinimum());
	}
	
	@Test
	public void exercice11TestA() throws IOException {
		MonReader monReader = new MonReader();
		Traitement11 traitement11 = new Traitement11();
		monReader.addLigneListener(traitement11);
		monReader.lireFichier("src/test/resources/traitement2017/inputExercice11.txt", charset);		
		assertEquals(715, traitement11.getNombreDeplacementMinimum());
	}

}
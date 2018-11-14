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
	public void exercice11Test1() throws IOException {
		MonReader monReader = new MonReader();
		Traitement11 traitement11 = new Traitement11();
		monReader.addLigneListener(traitement11);
		monReader.lireFichier("src/test/resources/traitement2017/inputTestExercice11.1.txt", charset);		
		assertEquals(3, traitement11.getNombreDeplacementMinimumFinal());
		assertEquals(3, traitement11.getNombreDeplacementMinimumMax());
	}
	
	@Test
	public void exercice11Test2() throws IOException {
		MonReader monReader = new MonReader();
		Traitement11 traitement11 = new Traitement11();
		monReader.addLigneListener(traitement11);
		monReader.lireFichier("src/test/resources/traitement2017/inputTestExercice11.2.txt", charset);		
		assertEquals(0, traitement11.getNombreDeplacementMinimumFinal());
		assertEquals(2, traitement11.getNombreDeplacementMinimumMax());
	}
	
	@Test
	public void exercice11Test3() throws IOException {
		MonReader monReader = new MonReader();
		Traitement11 traitement11 = new Traitement11();
		monReader.addLigneListener(traitement11);
		monReader.lireFichier("src/test/resources/traitement2017/inputTestExercice11.3.txt", charset);		
		assertEquals(2, traitement11.getNombreDeplacementMinimumFinal());
		assertEquals(2, traitement11.getNombreDeplacementMinimumMax());
	}
	
	@Test
	public void exercice11Test4() throws IOException {
		MonReader monReader = new MonReader();
		Traitement11 traitement11 = new Traitement11();
		monReader.addLigneListener(traitement11);
		monReader.lireFichier("src/test/resources/traitement2017/inputTestExercice11.4.txt", charset);		
		assertEquals(3, traitement11.getNombreDeplacementMinimumFinal());
		assertEquals(3, traitement11.getNombreDeplacementMinimumMax());
	}
	
	@Test
	public void exercice11Test() throws IOException {
		MonReader monReader = new MonReader();
		Traitement11 traitement11 = new Traitement11();
		monReader.addLigneListener(traitement11);
		monReader.lireFichier("src/test/resources/traitement2017/inputExercice11.txt", charset);		
		assertEquals(715, traitement11.getNombreDeplacementMinimumFinal());
		assertEquals(1512, traitement11.getNombreDeplacementMinimumMax());
	}

}
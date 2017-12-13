
package exercice9;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import utils.MonReader;


public class Exercice9Test{

    private Charset charset = StandardCharsets.UTF_8;

    @Test
    public void exercice9TestA1() throws IOException {
	MonReader monReader = new MonReader();
	Traitement9 traitement9 = new Traitement9();
	monReader.addLigneListener(traitement9);
	monReader.lireFichier("src/test/resources/inputTestExercice9.1.txt", charset);		
	assertEquals(1, traitement9.getNombreDeGroupe());
	assertEquals(1, traitement9.getScore());
	
	monReader.lireFichier("src/test/resources/inputTestExercice9.2.txt", charset);		
	assertEquals(3, traitement9.getNombreDeGroupe());
	assertEquals(6, traitement9.getScore());
	
	monReader.lireFichier("src/test/resources/inputTestExercice9.3.txt", charset);		
	assertEquals(3, traitement9.getNombreDeGroupe());
	assertEquals(5, traitement9.getScore());
	
	monReader.lireFichier("src/test/resources/inputTestExercice9.4.txt", charset);		
	assertEquals(6, traitement9.getNombreDeGroupe());
	assertEquals(16, traitement9.getScore());
	
	monReader.lireFichier("src/test/resources/inputTestExercice9.5.txt", charset);		
	assertEquals(1, traitement9.getNombreDeGroupe());
	assertEquals(1, traitement9.getScore());
	
	monReader.lireFichier("src/test/resources/inputTestExercice9.6.txt", charset);		
	assertEquals(5, traitement9.getNombreDeGroupe());
	assertEquals(9, traitement9.getScore());
	
	monReader.lireFichier("src/test/resources/inputTestExercice9.7.txt", charset);		
	assertEquals(5, traitement9.getNombreDeGroupe());
	assertEquals(9, traitement9.getScore());
	
	monReader.lireFichier("src/test/resources/inputTestExercice9.8.txt", charset);		
	assertEquals(2, traitement9.getNombreDeGroupe());
	assertEquals(3, traitement9.getScore());
    }
    
    @Test
    public void exercice9TestA2() throws IOException {
	MonReader monReader = new MonReader();
	Traitement9 traitement9 = new Traitement9();
	monReader.addLigneListener(traitement9);
	monReader.lireFichier("src/test/resources/inputExercice9.txt", charset);		
	assertEquals(1605, traitement9.getNombreDeGroupe());
	assertEquals(560659, traitement9.getScore()); // ni 501 966, ni 560 569
    }

}

package traitement2017;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import traitement2017.Traitement09;
import utils.MonReader;


public class Exercice09Test{

    private Charset charset = StandardCharsets.UTF_8;

    @Test
    public void exercice9Test1() throws IOException {
	MonReader monReader = new MonReader();
	Traitement09 traitement9 = new Traitement09();
	monReader.addLigneListener(traitement9);
	monReader.lireFichier("src/test/resources/inputTestExercice09a.1.txt", charset);		
	assertEquals(1, traitement9.getNombreDeGroupe());
	assertEquals(1, traitement9.getScore());
	
	monReader.lireFichier("src/test/resources/inputTestExercice09a.2.txt", charset);		
	assertEquals(3, traitement9.getNombreDeGroupe());
	assertEquals(6, traitement9.getScore());
	
	monReader.lireFichier("src/test/resources/inputTestExercice09a.3.txt", charset);		
	assertEquals(3, traitement9.getNombreDeGroupe());
	assertEquals(5, traitement9.getScore());
	
	monReader.lireFichier("src/test/resources/inputTestExercice09a.4.txt", charset);		
	assertEquals(6, traitement9.getNombreDeGroupe());
	assertEquals(16, traitement9.getScore());
	
	monReader.lireFichier("src/test/resources/inputTestExercice09a.5.txt", charset);		
	assertEquals(1, traitement9.getNombreDeGroupe());
	assertEquals(1, traitement9.getScore());
	
	monReader.lireFichier("src/test/resources/inputTestExercice09a.6.txt", charset);		
	assertEquals(5, traitement9.getNombreDeGroupe());
	assertEquals(9, traitement9.getScore());
	
	monReader.lireFichier("src/test/resources/inputTestExercice09a.7.txt", charset);		
	assertEquals(5, traitement9.getNombreDeGroupe());
	assertEquals(9, traitement9.getScore());
	
	monReader.lireFichier("src/test/resources/inputTestExercice09a.8.txt", charset);		
	assertEquals(2, traitement9.getNombreDeGroupe());
	assertEquals(3, traitement9.getScore());
    }
    
    @Test
    public void exercice9Test2() throws IOException {
	MonReader monReader = new MonReader();
	Traitement09 traitement9 = new Traitement09();
	monReader.addLigneListener(traitement9);
	monReader.lireFichier("src/test/resources/inputTestExercice09b.1.txt", charset);		
	assertEquals(0, traitement9.getNombreCaractereEntreChevron());
	
	monReader.lireFichier("src/test/resources/inputTestExercice09b.2.txt", charset);		
	assertEquals(17, traitement9.getNombreCaractereEntreChevron());
	
	monReader.lireFichier("src/test/resources/inputTestExercice09b.3.txt", charset);		
	assertEquals(3, traitement9.getNombreCaractereEntreChevron());
	
	monReader.lireFichier("src/test/resources/inputTestExercice09b.4.txt", charset);		
	assertEquals(2, traitement9.getNombreCaractereEntreChevron());
	
	monReader.lireFichier("src/test/resources/inputTestExercice09b.5.txt", charset);		
	assertEquals(0, traitement9.getNombreCaractereEntreChevron());
	
	monReader.lireFichier("src/test/resources/inputTestExercice09b.6.txt", charset);		
	assertEquals(0, traitement9.getNombreCaractereEntreChevron());
	
	monReader.lireFichier("src/test/resources/inputTestExercice09b.7.txt", charset);		
	assertEquals(10, traitement9.getNombreCaractereEntreChevron());
    }
    
    @Test
    public void exercice9Test3() throws IOException {
	MonReader monReader = new MonReader();
	Traitement09 traitement9 = new Traitement09();
	monReader.addLigneListener(traitement9);
	monReader.lireFichier("src/test/resources/inputExercice09.txt", charset);		
	assertEquals(1605, traitement9.getNombreDeGroupe());
	assertEquals(11846, traitement9.getScore());
	assertEquals(6285, traitement9.getNombreCaractereEntreChevron());
    }

    @Test
    public void exercice9Test4() throws IOException {
	MonReader monReader = new MonReader();
	Traitement09 traitement9 = new Traitement09();
	monReader.addLigneListener(traitement9);
	monReader.lireFichier("src/test/resources/inputExercice09Olivier.txt", charset);		
	assertEquals(1325, traitement9.getNombreDeGroupe());
	assertEquals(11898, traitement9.getScore());
    }

}
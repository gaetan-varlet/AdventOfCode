
package exercice05;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;

import exercice05.Traitement5;
import exercice05.Traitement5A;
import exercice05.Traitement5B;
import utils.MonReader;


public class Exercice05Test{

    private Charset charset = StandardCharsets.UTF_8;

    MonReader monReader;

    @Before
    public void before(){
	monReader = new MonReader();
    }

    @Test
    public void exercice5TestA1() throws IOException {
	Traitement5 traitement5 = new Traitement5A();
	monReader.addLigneListener(traitement5);
	monReader.setClotureListener(traitement5);
	monReader.lireFichier("src/test/resources/inputTestExercice05a.txt", charset);	

	assertEquals(5,traitement5.getNombreEtapeSortirListe());
    }

    @Test
    public void exercice5TestA2() throws IOException {
	Traitement5 traitement5 = new Traitement5A();
	monReader.addLigneListener(traitement5);
	monReader.setClotureListener(traitement5);
	monReader.lireFichier("src/test/resources/inputExercice05.txt", charset);	

	assertEquals(387096,traitement5.getNombreEtapeSortirListe());
    }

    @Test
    public void exercice5TestB1() throws IOException {
	Traitement5 traitement5 = new Traitement5B();
	monReader.addLigneListener(traitement5);
	monReader.setClotureListener(traitement5);
	monReader.lireFichier("src/test/resources/inputTestExercice05a.txt", charset);	

	assertEquals(10,traitement5.getNombreEtapeSortirListe());
    }

    @Test
    public void exercice5TestB2() throws IOException {
	Traitement5 traitement5 = new Traitement5B();
	monReader.addLigneListener(traitement5);
	monReader.setClotureListener(traitement5);
	monReader.lireFichier("src/test/resources/inputExercice05.txt", charset);	

	assertEquals(28040648,traitement5.getNombreEtapeSortirListe());
    }

}
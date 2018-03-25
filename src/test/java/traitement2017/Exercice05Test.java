
package traitement2017;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;

import traitement2017.Traitement05;
import traitement2017.Traitement05A;
import traitement2017.Traitement05B;
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
	Traitement05 traitement5 = new Traitement05A();
	monReader.addLigneListener(traitement5);
	monReader.setClotureListener(traitement5);
	monReader.lireFichier("src/test/resources/traitement2017/inputTestExercice05a.txt", charset);	

	assertEquals(5,traitement5.getNombreEtapeSortirListe());
    }

    @Test
    public void exercice5TestA2() throws IOException {
	Traitement05 traitement5 = new Traitement05A();
	monReader.addLigneListener(traitement5);
	monReader.setClotureListener(traitement5);
	monReader.lireFichier("src/test/resources/traitement2017/inputExercice05.txt", charset);	

	assertEquals(387096,traitement5.getNombreEtapeSortirListe());
    }

    @Test
    public void exercice5TestB1() throws IOException {
	Traitement05 traitement5 = new Traitement05B();
	monReader.addLigneListener(traitement5);
	monReader.setClotureListener(traitement5);
	monReader.lireFichier("src/test/resources/traitement2017/inputTestExercice05a.txt", charset);	

	assertEquals(10,traitement5.getNombreEtapeSortirListe());
    }

    @Test
    public void exercice5TestB2() throws IOException {
	Traitement05 traitement5 = new Traitement05B();
	monReader.addLigneListener(traitement5);
	monReader.setClotureListener(traitement5);
	monReader.lireFichier("src/test/resources/traitement2017/inputExercice05.txt", charset);	

	assertEquals(28040648,traitement5.getNombreEtapeSortirListe());
    }

}
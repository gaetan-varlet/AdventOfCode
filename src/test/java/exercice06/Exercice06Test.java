
package exercice06;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;

import exercice06.Traitement6;
import utils.MonReader;


public class Exercice06Test{

    private Charset charset = StandardCharsets.UTF_8;

    @Before
    public void before(){

    }

    @Test
    public void exercice6TestA1() throws IOException {
	MonReader monReader = new MonReader();
	Traitement6 traitement6 = new Traitement6();
	monReader.addLigneListener(traitement6);
	monReader.lireFichier("src/test/resources/inputTestExercice06a.txt", charset);	

	assertEquals(5,traitement6.getNombreDeTour());
	assertEquals(4,traitement6.getTailleCycle());
    }

    @Test
    public void exercice6TestA2() throws IOException {
	MonReader monReader = new MonReader();
	Traitement6 traitement6 = new Traitement6();
	monReader.addLigneListener(traitement6);
	monReader.lireFichier("src/test/resources/inputExercice06.txt", charset);	

	assertEquals(7864,traitement6.getNombreDeTour());
	assertEquals(1695,traitement6.getTailleCycle());
    }


}
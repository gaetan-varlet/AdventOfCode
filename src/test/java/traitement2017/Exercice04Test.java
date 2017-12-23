
package traitement2017;

import org.junit.Test;

import traitement2017.Traitement04A;
import traitement2017.Traitement04B;
import utils.MonReader;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Exercice04Test{

    private Charset charset = StandardCharsets.UTF_8;

    @Test
    public void traitementTest() throws IOException{

	MonReader monReader = new MonReader();

	Traitement04A traitement4A = new Traitement04A();
	monReader.addLigneListener(traitement4A);
	monReader.lireFichier("src/test/resources/inputTestExercice04a.txt", charset);
	assertEquals(2,traitement4A.getTotal());

	traitement4A = new Traitement04A();
	monReader.addLigneListener(traitement4A);
	monReader.lireFichier("src/test/resources/inputExercice04.txt", charset);	
	assertEquals(455,traitement4A.getTotal());

	Traitement04B traitement4B = new Traitement04B();
	monReader.addLigneListener(traitement4B);
	monReader.lireFichier("src/test/resources/inputTestExercice04b.txt", charset);
	assertEquals(3,traitement4B.getTotal());

	traitement4B = new Traitement04B();
	monReader.addLigneListener(traitement4B);
	monReader.lireFichier("src/test/resources/inputExercice04.txt", charset);	
	assertEquals(186,traitement4B.getTotal());
    }
}
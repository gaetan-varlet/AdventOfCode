
package exercice04;

import org.junit.Test;

import exercice04.Traitement4A;
import exercice04.Traitement4B;
import utils.MonReader;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Exercice04Test{

    private Charset charset = StandardCharsets.UTF_8;

    @Test
    public void exercice1Test() throws IOException{

	MonReader monReader = new MonReader();

	Traitement4A traitement4A = new Traitement4A();
	monReader.addLigneListener(traitement4A);
	monReader.lireFichier("src/test/resources/inputTestExercice04a.txt", charset);
	assertEquals(2,traitement4A.getTotal());

	traitement4A = new Traitement4A();
	monReader.addLigneListener(traitement4A);
	monReader.lireFichier("src/test/resources/inputExercice04.txt", charset);	
	assertEquals(455,traitement4A.getTotal());

	Traitement4B traitement4B = new Traitement4B();
	monReader.addLigneListener(traitement4B);
	monReader.lireFichier("src/test/resources/inputTestExercice04b.txt", charset);
	assertEquals(3,traitement4B.getTotal());

	traitement4B = new Traitement4B();
	monReader.addLigneListener(traitement4B);
	monReader.lireFichier("src/test/resources/inputExercice04.txt", charset);	
	assertEquals(186,traitement4B.getTotal());
    }
}

package traitement2017;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import traitement2017.Traitement08;
import utils.MonReader;


public class Exercice08Test{

    private Charset charset = StandardCharsets.UTF_8;

    @Test
    public void exercice8TestA1() throws IOException {
	MonReader monReader = new MonReader();
	Traitement08 traitement8 = new Traitement08();
	monReader.addLigneListener(traitement8);
	monReader.setClotureListener(traitement8);
	monReader.lireFichier("src/test/resources/traitement2017/inputTestExercice08.txt", charset);		
	assertEquals(1, traitement8.getMaximumFinal());
	assertEquals(10, traitement8.getMaximumTemporaire());
    }

    @Test
    public void exercice8TestA2() throws IOException {
	MonReader monReader = new MonReader();
	Traitement08 traitement8 = new Traitement08();
	monReader.addLigneListener(traitement8);
	monReader.setClotureListener(traitement8);
	monReader.lireFichier("src/test/resources/traitement2017/inputExercice08.txt", charset);		
	assertEquals(7787, traitement8.getMaximumFinal());
	assertEquals(8997, traitement8.getMaximumTemporaire());
    }

}
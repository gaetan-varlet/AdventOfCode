
package exercice2;

import org.junit.Test;

import utils.MonReader;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Exercice2Test{
    
    private static String file = "src/main/java/exercice2/inputExercice2.txt";
    private static Charset charset = StandardCharsets.UTF_8;
    
    @Test
    public void exercice1Test() throws IOException{
	MonReader monReader = new MonReader();
	Traitement2A traitement2A = new Traitement2A();
	monReader.addLigneListener(traitement2A);
	Traitement2B traitement2B = new Traitement2B();
	monReader.addLigneListener(traitement2B);
	monReader.lireFichier(file, charset);
	
	assertEquals(42299,traitement2A.getSomme());
	assertEquals(277,traitement2B.getSomme());
    }
}
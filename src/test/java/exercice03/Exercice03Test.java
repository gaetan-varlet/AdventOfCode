
package exercice03;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class Exercice03Test{
	
    @Test
    public void traitement3Test() throws IOException{
	Exercice3 exercice3 = new Exercice3();

	assertEquals(0,exercice3.traitement(1));
	assertEquals(1,exercice3.traitement(8));
	assertEquals(2,exercice3.traitement(9));
    }
}
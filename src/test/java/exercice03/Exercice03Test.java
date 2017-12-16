
package exercice03;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Exercice03Test{

	@Test
	public void traitement3Test() throws Exception{
		Exercice3 exercice3 = new Exercice3();

		exercice3.setInput(1);
		exercice3.traitement(true);
		assertEquals(0,exercice3.getDistanceDeManhattan());

		exercice3.setInput(12);
		exercice3.traitement(true);
		assertEquals(3,exercice3.getDistanceDeManhattan());

		exercice3.setInput(23);
		exercice3.traitement(true);
		assertEquals(2,exercice3.getDistanceDeManhattan());

		exercice3.setInput(1024);
		exercice3.traitement(true);
		assertEquals(31,exercice3.getDistanceDeManhattan());

		exercice3.setInput(361527);
		exercice3.traitement(true);
		assertEquals(326,exercice3.getDistanceDeManhattan());
		
		exercice3 = new Exercice3();
		exercice3.setInput(361527);
		exercice3.traitement(false);
		assertEquals(363010, exercice3.getValeurSuperieure());
	}
}
package exercice2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Exercice2 {
	
	private static String file = "src/main/java/exercice2/inputExercice2.txt";
	private static Charset charset = StandardCharsets.UTF_8;

	public static void main(String[] args) throws IOException {
		
		MonReader monReader = new MonReader();
		TraitementA traitementA = new TraitementA();
		monReader.addLigneListener(traitementA);
		TraitementB traitementB = new TraitementB();
		monReader.addLigneListener(traitementB);
		monReader.lireFichier(file, charset);
		
		System.out.println(traitementA.getSomme()); // 42 299
		System.out.println(traitementB.getSomme()); // 277

	}

}

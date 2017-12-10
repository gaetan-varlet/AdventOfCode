package exercice2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import utils.MonReader;

public class Exercice2 {
	
	private static String file = "src/main/java/exercice2/inputExercice2.txt";
	private static Charset charset = StandardCharsets.UTF_8;

	public static void main(String[] args) throws IOException {
		
		MonReader monReader = new MonReader();
		Traitement2A traitement2A = new Traitement2A();
		monReader.addLigneListener(traitement2A);
		Traitement2B traitement2B = new Traitement2B();
		monReader.addLigneListener(traitement2B);
		monReader.lireFichier(file, charset);
		
		System.out.println(traitement2A.getSomme()); // 42 299
		System.out.println(traitement2B.getSomme()); // 277

	}

}

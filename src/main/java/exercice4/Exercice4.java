package exercice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercice4 {

	private static Charset charset = StandardCharsets.UTF_8;
	private static String separateur = " ";

	public static void main(String[] args) throws IOException {
		exercice4("src/main/java/exercice4/inputTestExercice4a.txt","a"); // 2
		exercice4("src/main/java/exercice4/inputExercice4.txt","ba"); // 455

		exercice4("src/main/java/exercice4/inputTestExercice4b.txt","b"); // 3
		exercice4("src/main/java/exercice4/inputExercice4.txt","b"); // 186
	}
	
	
	private static void exercice4(String file, String exo) throws IOException{
		List<String[]> listePhrase = bufferReader(file, charset, separateur);
		
		int total = 0;
		for (String[] phrase : listePhrase) {
			if("a".equalsIgnoreCase(exo)){
				int phraseCorrecte = phraseCorrecte4a(phrase);
				total = total + phraseCorrecte;
			} else if("b".equalsIgnoreCase(exo)){
				int phraseCorrecte = phraseCorrecte4b(phrase);
				total = total + phraseCorrecte;
			}
		}
		System.out.println(total);
	}
	
	private static int phraseCorrecte4a(String[] phrase){
		int phraseCorrecte=0;	
		Set<String> liste = new HashSet<>();

		for (String mot : phrase) {
			if(liste.add(mot)==false){
				phraseCorrecte=0;
				break;
			} else{
				phraseCorrecte=1;
			}
		}	
		return phraseCorrecte;
	}
	
	private static int phraseCorrecte4b(String[] phrase){
		int phraseCorrecte=0;	
		Set<String> liste = new HashSet<>();

		for (String mot : phrase) {
			mot = trierLettres(mot);
			if(liste.add(mot)==false){
				phraseCorrecte=0;
				break;
			} else{
				phraseCorrecte=1;
			}
		}	
		return phraseCorrecte;
	}
	
	private static String trierLettres(String mot){
	    char[] chars = mot.toCharArray();
	    Arrays.sort(chars);
	    String sorted = new String(chars);
	    return sorted;	
	}
	
	private static List<String[]> bufferReader(String file, Charset charset, String separateur) throws IOException{
		Path source = Paths.get(file);
		BufferedReader reader = Files.newBufferedReader(source, charset);
		String line;
		List<String[]> list = new ArrayList<String[]>();
		while((line = reader.readLine()) != null){
			String[] tab = line.split(separateur);
			list.add(tab);
		}
		reader.close();
		return list;
	}

}

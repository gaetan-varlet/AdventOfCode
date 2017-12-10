package exercice2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Exercice2Bis {
	
	private static String file = "src/main/java/exercice2/inputExercice2.txt";
	private static Charset charset = StandardCharsets.UTF_8;
	private static String separateur = "\t";

	public static void main(String[] args) throws IOException {
		System.out.println(exercice2("2a")); // 42 299
		System.out.println(exercice2("2b")); // 277
	}
	
	private static int exercice2(String exercice) throws IOException{
		int total = 0;
		Path source = Paths.get(file);
		BufferedReader reader = Files.newBufferedReader(source, charset);
		String line;
		while((line = reader.readLine()) != null){
			String[] tab = line.split(separateur);
			
			if("2a".equalsIgnoreCase(exercice)){
				int ecart = traitement2a(tab);
				total = total + ecart;
			} else if("2b".equalsIgnoreCase(exercice)){
				int ecart = traitement2b(tab);
				total = total + ecart;
			}
		}
		reader.close();
		return total;
	}
	
	private static int traitement2a(String[] tab) throws IOException{
		int[] tab2 = Arrays.asList(tab).stream().mapToInt(Integer::parseInt).toArray();
		Arrays.sort(tab2);
		int ecart = tab2[tab2.length-1] - tab2[0];
		return ecart;
	}
	
	private static int traitement2b(String[] tab) throws IOException{
		int res=0;
		int[] tab2 = Arrays.asList(tab).stream().mapToInt(Integer::parseInt).toArray();
		Arrays.sort(tab2);
		for(int i=0;i<tab2.length;i++){
			for(int j=0;j<tab2.length;j++){
				if(i!=j && tab2[i]>tab2[j] && tab2[i]%tab2[j]==0){
					res = tab2[i]/tab2[j];
				}
			}
		}
		return res;
	}

}

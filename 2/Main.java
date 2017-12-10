import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	private static String file = "donnees.txt";
	private static Charset charset = StandardCharsets.UTF_8;

	public static void main(String[] args) throws IOException {
		exercice2a();
		exercice2b();
	}
	
	
	private static void exercice2a() throws IOException{
		List<String[]> liste = bufferReader(file, charset, "\t");

		int total=0;
		for (String[] tab : liste) {
			int[] tab2 = Arrays.asList(tab).stream().mapToInt(Integer::parseInt).toArray();
			Arrays.sort(tab2);
			int ecart = tab2[tab2.length-1] - tab2[0];
			total = total + ecart;
		}
		System.out.println(total); // 42 299
	}
	
	private static void exercice2b() throws IOException{
		List<String[]> liste = bufferReader(file, charset, "\t");
		
		int total=0;
		for (String[] tab : liste) {
			int[] tab2 = Arrays.asList(tab).stream().mapToInt(Integer::parseInt).toArray();
			Arrays.sort(tab2);
			for(int i=0;i<tab2.length;i++){
				for(int j=0;j<tab2.length;j++){
					if(i!=j && tab2[i]>tab2[j] && tab2[i]%tab2[j]==0){
						int res = tab2[i]/tab2[j];
						total=total+res;
					}
				}
			}
		}
		System.out.println(total); // 277
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

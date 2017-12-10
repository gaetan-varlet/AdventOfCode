package exercice2;

import java.io.IOException;
import java.util.Arrays;

public class TraitementB implements LigneListener {
	
	private int somme;
	
	public int getSomme() {
		return somme;
	}

	@Override
	public void ligneLue(String ligne) throws IOException {
		String[] tab = ligne.split("\t");
		int[] tab2 = Arrays.asList(tab).stream().mapToInt(Integer::parseInt).toArray();
		Arrays.sort(tab2);
		for(int i=0;i<tab2.length;i++){
			for(int j=0;j<tab2.length;j++){
				if(i!=j && tab2[i]>tab2[j] && tab2[i]%tab2[j]==0){
					somme = somme + tab2[i]/tab2[j];
				}
			}
		}
	}

}

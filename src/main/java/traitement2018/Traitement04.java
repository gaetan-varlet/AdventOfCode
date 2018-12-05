package traitement2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.ClotureListener;
import utils.LigneListener;
public class Traitement04 implements LigneListener, ClotureListener {
	
	private int resultat;
	private List<String> listeDonnees = new ArrayList<>();
	
	public int getResultat() {
		return resultat;
	}

	@Override
	public void ligneLue(String ligne) {
		listeDonnees.add(ligne);
	}

	@Override
	public void fichierFerme() {
		Collections.sort(listeDonnees);
		Pattern patternLigne = Pattern.compile("\\[(....-..-.. ..:..)\\] (.*)");
		Pattern patternTexte = Pattern.compile("Guard #(.*) begins shift");
		for (String ligne : listeDonnees) {
			Matcher matcherLigne = patternLigne.matcher(ligne);
			matcherLigne.matches();
			String dateTime = matcherLigne.group(1);
			String texte = matcherLigne.group(2);
			if(texte.contains("Guard")) {
				Matcher matcherTexte = patternTexte.matcher(texte);
				matcherTexte.matches();
				int idGuard = Integer.parseInt(matcherTexte.group(1));
				System.out.println();
			}
		}
		System.out.println(listeDonnees);
	}

}

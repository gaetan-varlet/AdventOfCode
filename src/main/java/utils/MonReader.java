package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MonReader {

    private List<LigneListener> listeLigneListener = new ArrayList<LigneListener>();

    private ClotureListener clotureListener;

    public void addLigneListener (LigneListener ligneListener) throws IllegalArgumentException {
	if(ligneListener==null){
	    throw new IllegalArgumentException("ligneListener null passé en argument");
	}
	listeLigneListener.add(ligneListener);
    }

    public void setClotureListener(ClotureListener clotureListener) {
	this.clotureListener = clotureListener;
    }


    public void lireFichier(String file, Charset charset) throws IOException{
	Path source = Paths.get(file);
	BufferedReader reader = Files.newBufferedReader(source, charset);
	String line;
	while((line = reader.readLine()) != null){
	    for (LigneListener ligneListener : listeLigneListener) {
		ligneListener.ligneLue(line);
	    }
	}
	reader.close();
	if(clotureListener!=null){
	    clotureListener.fichierFerme();
	}
    }
}

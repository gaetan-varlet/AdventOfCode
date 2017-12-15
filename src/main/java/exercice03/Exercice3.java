package exercice03;

import java.util.Arrays;

public class Exercice3 {

	private int x;
	private int y;

	protected int traitement(int input){
		int distance = 0;

		int[][] tab = new int[3][3];

		tab[0][0]=5;
		tab[0][1]=4;
		tab[0][2]=3;
		tab[1][0]=6;
		tab[1][1]=1;
		tab[1][2]=2;
		tab[2][0]=7;
		tab[2][1]=8;
		tab[2][2]=9;
		
		System.out.println(Arrays.deepToString(tab));
		
		
		int[][] tab2 = new int[3][3];
		int position = (3-1)/2;
		
		
		tab2[position][position]=1;
		
		tab2[position][position+1]=2;
		
		tab2[position-1][position+1]=3;
		
		tab2[position-1][position]=4;
		tab2[position-1][position-1]=5;
		
		tab2[position][position-1]=6;
		tab2[position+1][position-1]=7;
		
		tab2[position+1][position]=8;
		tab2[position+1][position+1]=9;
		tab2[position+1][position+2]=9;
		
		System.out.println(Arrays.deepToString(tab2));
		

		int xInitial = 1;
		int yInitial = 1;

		positionInput(tab, input);
		distance = Math.abs(x-xInitial)+Math.abs(y-yInitial);    	
		return distance;
	}

	private void positionInput(int[][] tab, int input){
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				if(tab[i][j]==input){
					x = i;
					y = j;
					return;
				}
			}	
		}
	}
}

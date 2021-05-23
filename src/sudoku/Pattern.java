/**
* La classe <code>Pattern</code> créer un pattern sous la forme d'un int[] aléatoire avec des valeurs de 1 à 9 compris ne figurant qu'une fois
* @author Alexandra Demski
*/
package sudoku;

import java.util.Arrays;  

public class Pattern{

	private int[] path;	//Le pattern aléatoire de vérification de valeur

	/**
     * Constructeur
     */
	public Pattern(){
		//Initialisation pattern
		this.path = new int[9];
	}

	/**
	* La méthode <code>createPattern</code> permet la création d'un pattern aléatoire pour la vérification de valeurs
	* (si non-aléatoire, les grilles générées par CreateSudoku seraient identiques)
	*/
	public void createPattern(){
		int i;
		for(i=0;i<=8;i++){
			this.path[i]=i+1;
		}
		for(i=8;i>0;i--){
			int a = (int)(Math.random()*8);
			int b = (int)(Math.random()*8);
			int replace = this.path[a];
			this.path[a]=this.path[b];
			this.path[b]=replace;
		}
	}

	/**
	* La méthode <code>getValuePattern</code> permet d'obtenir la valeur du pattern à un index donné
	* @param i index à vérifier
	* @return valeur stocké à l'index i dans le pattern
	*/
	public int getValuePattern(int i){
		return this.path[i];
	}
}

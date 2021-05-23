/**
* La classe <code>Sudoku</code> est la classe mère des différentes classes modifiant une grille comprenant les méthodes communes
* @author Alexandra Demski
*/
package sudoku;

import java.util.Arrays;  

public class Sudoku{

	protected int[][] board;	//La grille du sudoku
	
	/**
     * Constructeur
     * @param b grille de sudoku (model)
     */
	public Sudoku(int[][] b){
		this.board = b;
	}

	/**
	* La méthode <code>findEmpty</code> trouve une case vide dans la grille
	* @return les coordonnées d'un emplacement vide sous la forme d'un int[], sinon renvoie null
	*/
	public int[] findEmtpy(){
		int i,j;
		int[] positions = new int[2];

		for(i=0;i<=8;i++){

			for(j=0;j<=8;j++){

				//Si dans une case on trouve 0 alors on renvoie ses coordonnées
				if(this.board[i][j]==0){
					positions[0]=i;
					positions[1]=j;
					return positions;
				}
			}
		}

		//Sinon on renvoie null
		return null;
	}
	
	/**
	* La méthode <code>checkCell</code> vérifie si une valeur est valide pour une case donnée
	* @param num est la valeur à vérifier
	* @param positions comprend les coordonnées de la dite case
	* @return true si la valeur vérifie les critères, renvoie false sinon
	*/
	public boolean checkCell(int num, int[] positions){

		int i=0,j=0;

		//Vérifier la colonne
		for(i=0;i<=8;i++){
			if(this.board[positions[0]][i]==num & i!=positions[1]){
				return false;
			}
		}
		//Vérifier la ligne
		for(i=0;i<8;i++){
			if(this.board[i][positions[1]]==num & i!=positions[0]){
				return false;
			}
		}

		//Vérifier le carré
		int x = positions[0]-positions[0]%3;
		int y = positions[1]-positions[1]%3;

		for(i=x;i<x+3;i++){
			for(j=y;j<y+3;j++){
				if(this.board[i][j]==num & i!=positions[0] & j!=positions[1]){
					return false;
				}
			}
		}

		//Si la valeur vérifie toutes les règles, elle est correcte
		return true;
	}

	/**
	* La méthode <code>printGrille</code> permet d'afficher la grille à la console pour d'éventuel test
	*/
	public void printGrille(){
		int i,j;
		for(i=0;i<=8;i++){
			for(j=0;j<=8;j++){
				System.out.print(" "+this.board[i][j]+" ");
			}
			System.out.print("\n");
		}
	}

}

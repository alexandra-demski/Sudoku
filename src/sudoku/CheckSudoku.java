/**
* La classe <code>CheckSudoku<code> permet de vérifier si les cases d'une grille vérifient les contraintes
* @author Alexandra Demski
*/
package sudoku;

import java.util.Arrays;  

public class CheckSudoku extends Sudoku{
	
	/**
     * Constructeur
     * @param b grille de sudoku (model)
     */
	public CheckSudoku(int[][] b){
		super(b);
	}

	/**
	* La méthode <code>check</code> vérifie si une grille donnée est valide
	* @return true si la grille est correct, renvoie false sinon
	*/
	public boolean check(){
		boolean valid;
		int i,j;
		int value;
		int[] positions = new int[2];
		for(i=0;i<=8;i++){
			for(j=0;j<=8;j++){
				value=this.board[i][j];
				if(value!=0){
					positions[0]=i;
					positions[1]=j;
					if(!checkCell(value,positions)){
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	* La méthode <code>solved</code> vérifie si une grille donnée est résolue
	* @return true si la grille est résolue, renvoie false sinon
	*/
	public boolean solved(){
		boolean valid;
		int i,j;
		int value;
		int[] positions = new int[2];
		for(i=0;i<=8;i++){
			for(j=0;j<=8;j++){
				value=this.board[i][j];
				if(value!=0){
					positions[0]=i;
					positions[1]=j;
					if(!checkCell(value,positions)){
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}

}

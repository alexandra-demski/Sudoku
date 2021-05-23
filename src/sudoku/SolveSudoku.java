/**
* La classe <code>SolveSudoku</code> permet de résoudre une grille de Sudoku
* @author Alexandra Demski
*/
package sudoku;

import java.util.Arrays;  

public class SolveSudoku extends Sudoku{

	/**
     * Constructeur
     * @param b grille de sudoku (model)
     */
	public SolveSudoku(int[][] b){
		super(b);
	}

	/**
	* La méthode <code>solve</code> permet la résolution du Sudoku
	* @return true si le sudoku est résolu, renvoie false sinon
	*/
	public boolean solve(){

		int[] empty = new int[2];

		while(true){

			//On a trouvé aucune case vide
			empty = findEmtpy();
			if(empty==null){
				return true;
			}

			//On a trouvé des cases vides
			else
			{
				int row=empty[0];
				int col=empty[1];
				int value;
				boolean valid;

				//On teste les valeurs allant de 1 à 9
				for(value=1;value<=9;value++){

					valid=checkCell(value,empty);

					if(valid){

						this.board[row][col]=value;

						if(solve()){
							return true;
						}
						//Si on ne peut plus résoudre le sudoku, on remet la dernière case à 0 et on recule.
						this.board[row][col]=0;
					}
				}
				return false;
			}
		}
	}
}
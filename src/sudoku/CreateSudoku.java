/**
* La classe <code>CreateSudoku</code> permet de créer une grille de sudoku de manière automatique
* @author Alexandra Demski
*/
package sudoku;

import java.util.Arrays;  

public class CreateSudoku extends Sudoku{

	private int[] path;		//Le pattern aléatoire de vérification de valeur
	private Pattern p;

	/**
     * Constructeur
     * @param b grille de sudoku (model)
     */
	public CreateSudoku(int[][] b){
		super(b);
		this.p = new Pattern();
		this.p.createPattern();

		//On efface des potentielles valeurs restantes avant de créer une grille
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				this.board[i][j] = 0;
			}
		}
	}

	/**
	* La méthode <code>eraseCell</code> supprime une case aléatoire
	*/
	private void eraseCell(){
		int i = (int)(Math.random()*9);
		int j = (int)(Math.random()*9);
		this.board[i][j]=0;
	}

	/**
	* La méthode <code>solveRandom</code> résout une grille de la même manière que solve mais en suivant un pattern aléatoire
	* @return un booléan selon si la grille est résolue ou non
	*/
	private boolean solveRandom(){

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
				int i;
				boolean valid;

				//On teste les valeurs allant de 1 à 9
				for(i=0;i<=8;i++){

					valid=checkCell(this.p.getValuePattern(i),empty);

					if(valid){

						this.board[row][col]=this.p.getValuePattern(i);

						if(solveRandom()){
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

	/**
	* La méthode <code>create</code> permet de créer une grille automatiquement
	*/
	public void create(){
		solveRandom();
		int count;
		int fill = (int)(Math.random()*6)+17; //valeur aléatoire entre 17 et 17+5 = 22
		int empty=80-fill;

		//Tant qu'on a pas effacé assez de cases
		for(count=0;count<empty;count++){
			eraseCell();
		}
	}
}

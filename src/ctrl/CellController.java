/**
* La classe <code>CellController</code> contrôle la valeur d'une cellule éditable (par défaut vide) selon les actions de l'utilisateur.
* @author Alexandra Demski
*/
package ctrl;

import gui.EmptyCell;

import sudoku.NumberMemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellController implements ActionListener{

	private int[][] grille;
    private EmptyCell cell;

    /**
     * Constructeur
	 * @param c case de la grille
	 * @param g grille de sudoku (model)
     */
    public CellController(EmptyCell c,int[][] g){
    	this.cell = c;
    	this.grille = g;
        this.cell.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        NumberMemo memo = NumberMemo.getInstance(); //On récupère le dernier chiffre en mémoire
        int value = memo.getValeur();

        if(value != -1){
            this.cell.setValeur(value);
            int x = this.cell.getCoordsX();
            int y = this.cell.getCoordsY();

            this.grille[x][y] = value;
        }
        
    }
}
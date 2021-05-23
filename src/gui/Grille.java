/**
* La classe <code>CreateFrame</code> représente la grille de sudoku dans l'interface.
* @author Alexandra Demski
*/
package gui;

import ctrl.CellController;

import javax.swing.JPanel; 

import java.awt.GridLayout;

import java.util.LinkedList;
import java.util.Iterator;

public class Grille extends JPanel{

    private int[][] grille;
    private LinkedList<EmptyCell> vides;

    private static final long serialVersionUID = 1L;

    /**
     * Constructeur
     * @param g la grille de sudoku (model
    */
    public Grille(int[][] g){
        super();
        this.grille = g;
        this.vides = new LinkedList<EmptyCell>();
        this.setLayout(new GridLayout(9,9));

        for(int i=0; i<9; i++){
        	for(int j=0; j<9; j++){

        		int valeur = this.grille[i][j];
        		if(valeur == 0){
        			EmptyCell e = new EmptyCell(i,j);
                    this.vides.add(e);

                    CellController c = new CellController(e,this.grille);
                    e.addActionListener(c);

        			this.add(e);
        		} else {
        			NumberCell n = new NumberCell(i,j,valeur);
        			this.add(n);
        		}
        	}
        }
    }

    /**
    * La méthode <code>updateGrille</code> remet à jour toutes les cases modifiables
    */
    public void updateGrille(){
        for (Iterator<EmptyCell> i = this.vides.iterator(); i.hasNext();){
            EmptyCell e = i.next();
            int x = e.getCoordsX();
            int y = e.getCoordsY();
            e.setValeur(this.grille[x][y]);
        }
    }

    /**
    * La méthode <code>restartGrille</code> remet à 0 toutes les cases modifiables
    */
    public void restartGrille(){
        for (Iterator<EmptyCell> i = this.vides.iterator(); i.hasNext();){
            EmptyCell e = i.next();
            e.setValeur(0);
            
            int x = e.getCoordsX();
            int y = e.getCoordsY();
            this.grille[x][y] = 0;
        }
    }
}
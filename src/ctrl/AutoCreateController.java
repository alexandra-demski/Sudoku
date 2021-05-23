/**
* La classe <code>AutoCreateController</code> lance la création automatique d'une grille lorsqu'un bouton est cliqué.
* @author Alexandra Demski
*/
package ctrl;

import sudoku.CreateSudoku;

import gui.Grille;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.JButton; 

public class AutoCreateController implements ActionListener{

	private CreateSudoku create;
	private Grille grille;

    /**
     * Constructeur
     * @param g tableau représentant la grille à compléter (model)
     * @param gr pannel représentant grille à compléter (view)
     * @param btn bouton à écouter
     */
    public AutoCreateController(int[][] g, Grille gr, JButton btn){
    	this.create = new CreateSudoku(g);
    	this.grille = gr;
        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
    	this.create.create();
    	this.grille.updateGrille();
    }
}
/**
* La classe <code>SolveController</code> permet de lancer la résolution automatique d'une grille lorsqu'un bouton est cliqué.
* @author Alexandra Demski
*/
package ctrl;

import gui.Grille;

import sudoku.SolveSudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton; 

public class SolveController implements ActionListener{

	private JFrame frame;
	private Grille grille;
    private SolveSudoku solve;

    /**
     * Constructeur
     * @param fr fenêtre parent
	 * @param gr grille de sudoku à résoudre (view)
     * @param g tableau représentant la grille de sudoku à résoudre (model)
     * @param btn bouton à écouter
     */
    public <T extends JFrame> SolveController(T fr, Grille gr, int[][] g, JButton btn){
    	this.frame = fr;
    	this.grille = gr;
        this.solve = new SolveSudoku(g);
        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
    	solve.solve();
        this.grille.updateGrille();
    	JOptionPane.showMessageDialog(this.frame,"The grid has been solved");
    }
}
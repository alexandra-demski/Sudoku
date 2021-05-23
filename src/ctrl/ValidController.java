/**
* La classe <code>ValidController</code> permet de valider une grille de sudoku résolu lorsqu'un bouton est cliqué.
* @author Alexandra Demski
*/
package ctrl;

import sudoku.CheckSudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.JFrame;
import javax.swing.JOptionPane; 
import javax.swing.JButton; 

public class ValidController implements ActionListener{

	private JFrame frame;
	private CheckSudoku check;

    /**
     * Constructeur
     * @param fr fenêtre parent
	 * @param g tableaux représentant la grille à vérifier
     * @param btn bouton à écouter
     */
    public <T extends JFrame> ValidController(T fr, int[][] g, JButton btn){
    	this.frame = fr;
        this.check = new CheckSudoku(g);
        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
    	boolean result = this.check.solved();
    	if(result){
    		JOptionPane.showMessageDialog(this.frame,"The grid is valid - You win");
    	} else {
    		JOptionPane.showMessageDialog(this.frame,"The grid is not valid - Try again");
    	}
    }
}
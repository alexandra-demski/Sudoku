/**
* La classe <code>CheckController</code> permet de lancer la vérification d'une grille lorsq'un bouton est cliqué.
* @author Alexandra Demski
*/
package ctrl;

import sudoku.CheckSudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.JFrame;
import javax.swing.JOptionPane; 
import javax.swing.JButton; 

public class CheckController implements ActionListener{

	private JFrame frame;
	private CheckSudoku check;

    /**
     * Constructeur
     * @param fr fenetre parent
	 * @param g tableaux représentant la grille à vérifier (model)
     * @param btn bouton à écouter
     */
    public <T extends JFrame> CheckController(T fr, int[][] g, JButton btn){
    	this.frame = fr;
    	this.check = new CheckSudoku(g);
        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
    	boolean result = this.check.check();
    	if(result){
    		JOptionPane.showMessageDialog(this.frame,"The grid is valid");
    	} else {
    		JOptionPane.showMessageDialog(this.frame,"The grid is not valid");
    	}
    }
}
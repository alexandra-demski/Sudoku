/**
* La classe <code>RestartController</code> permet de lancer la remise à 0 d'une grille de sudoku lorsqu'un bouton est cliqué.
* @author Alexandra Demski
*/
package ctrl;

import gui.Grille;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.JFrame;
import javax.swing.JOptionPane; 
import javax.swing.JButton; 

public class RestartController implements ActionListener{

	private JFrame frame;
	private Grille grille;

    /**
     * Constructeur
     * @param fr fenêtre parent
	 * @param g l'objet grille à remettre à zéro (view)
     * @param btn bouton à écouter
     */
    public <T extends JFrame> RestartController(T fr, Grille g, JButton btn){
    	this.frame = fr;
    	this.grille = g;
        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
    	this.grille.restartGrille();
    	JOptionPane.showMessageDialog(this.frame,"The grid has been restarted");
    }
}
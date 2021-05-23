/**
* La classe <code>SaveController</code> permet de lancer la sauvergarde d'une grille créée lorsqu'un bouton est cliqué.
* @author Alexandra Demski
*/
package ctrl;

import gui.StartFrame;

import sudoku.SudokuManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton; 

public class SaveController implements ActionListener{

    private JFrame frame;
    private int[][] grille;
    private SudokuManager manager;

    /**
     * Constructeur
     * @param fr fenêtre d'origine
     * @param g grille de sudoku à enregistret (model)
     * @param btn bouton à écouter
     */
    public <T extends JFrame> SaveController(T fr, int[][] g, JButton btn){
        this.frame = fr;
        this.grille = g;
        this.manager = new SudokuManager(this.grille);
        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String name=JOptionPane.showInputDialog(this.frame,"Enter the name of the grid");
        int result = this.manager.save(this.grille,name);

        if(result == -1){
            JOptionPane.showMessageDialog(this.frame,"Error writing file.");
        } else if(result == -2){
            JOptionPane.showMessageDialog(this.frame,"Error converting the grid.");
        } else {
            StartFrame start = new StartFrame();
            this.frame.dispose();
        }
    }
}
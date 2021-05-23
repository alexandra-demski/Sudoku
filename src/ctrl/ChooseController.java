/**
* La classe <code>ChooseController</code> lance le dialogue permettant de choisir le fichier à charger lorsqu'un bouton est cliqué.
* @author Alexandra Demski
*/
package ctrl;

import gui.ChooseDialog;
import gui.SolveFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ChooseController implements ActionListener{

    private JFrame frame;

    /**
     * Constructeur
     * @param fr fenêtre d'origine
     * @param btn bouton à écouter
     */
    public <T extends JFrame> ChooseController(T fr, JButton btn){
        this.frame = fr;
        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        ChooseDialog choice = new ChooseDialog();
        if(choice.getResult() == -1){
            JOptionPane.showMessageDialog(this.frame,"Unable to open file.");
        } else if(choice.getResult() == -2){
            JOptionPane.showMessageDialog(this.frame,"Error reading file.");
        } else {
            SolveFrame solve = new SolveFrame(choice.getGrille());
            this.frame.dispose();
        }
    }
}
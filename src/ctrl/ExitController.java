/**
* La classe <code>ExitController</code> permet de quitter l'application par le biais d'un dialogue de confirmation lorsqu'un bouton ets cliqué.
* @author Alexandra Demski
*/
package ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.JFrame; 
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class ExitController implements ActionListener{

    private JFrame frame;

    /**
     * Constructeur
     * @param fr fenêtre d'origine
     * @param btn bouton à écouter
     */
    public <T extends JFrame> ExitController(T fr, JButton btn){
        this.frame = fr;
        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int option = JOptionPane.showConfirmDialog(this.frame,"Are you sure you want to exit ?");
        if(option == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
}
/**
* La classe <code>CreateController</code> lance la fenêtre de création de grille lorsqu'un bouton est cliqué.
* @author Alexandra Demski
*/
package ctrl;

import gui.CreateFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.JFrame;
import javax.swing.JButton; 

public class CreateController implements ActionListener{

    private JFrame frame;

    /**
     * Constructeur
     * @param fr fenêtre d'origine
     * @param btn bouton à écouter
     */
    public <T extends JFrame> CreateController(T fr, JButton btn){
        this.frame = fr;
        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        CreateFrame cf = new CreateFrame();
        this.frame.dispose();
    }
}
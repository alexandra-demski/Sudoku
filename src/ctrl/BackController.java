/**
* La classe <code>BackController</code> permet de retourner au menu de départ lorsqu'un bouton est cliqué.
* @author Alexandra Demski
*/
package ctrl;

import gui.StartFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane; 
import javax.swing.JButton; 

public class BackController implements ActionListener{


	private JFrame frame;

    /**
     * Constructeur
	 * @param fr fenêtre parent
     * @param btn bouton à écouter
     */
    public <T extends JFrame> BackController(T fr, JButton btn){
    	this.frame = fr;
        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
    	int option = JOptionPane.showConfirmDialog(this.frame,"Are you sure you want to exit ?");
        if(option == JOptionPane.YES_OPTION){
            this.frame.dispose();  
            StartFrame start = new StartFrame();
        }
    }
}
/**
* La classe <code>FrameController</code> permet de quitter l'application par le biais d'un dialogue de confirmation.
* @author Alexandra Demski
*/
package ctrl;

import java.awt.event.WindowListener; 
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrameController implements WindowListener{

    private JFrame frame;

    /**
     * Constructeur
     * @param  fr fenêtre à écouter
     */
    public <T extends JFrame> FrameController(T fr){
        this.frame = fr;
    }

    public void windowClosing(WindowEvent e) {
        int option = JOptionPane.showConfirmDialog(this.frame,"Are you sure you want to exit ?");
        if(option == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

    public void windowClosed(WindowEvent e) {}

    public void windowOpened(WindowEvent e) {}

    public void windowIconified(WindowEvent e) {}

    public void windowDeiconified(WindowEvent e) {}

    public void windowActivated(WindowEvent e) {}

    public void windowDeactivated(WindowEvent e) {}

    public void windowGainedFocus(WindowEvent e) {}

    public void windowLostFocus(WindowEvent e) {}

    public void windowStateChanged(WindowEvent e) {}
}
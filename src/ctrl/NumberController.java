/**
* La classe <code>NumberController</code> enregistre le dernier nombre sélectionné à l'aide de boutons.
* @author Alexandra Demski
*/
package ctrl;

import sudoku.NumberMemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.JButton;

public class NumberController implements ActionListener{

	private JButton btn;

    /**
     * Constructeur
     * @param b bouton à écouter
     */
    public NumberController(JButton b){
    	this.btn = b;
        this.btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
    	NumberMemo memo = NumberMemo.getInstance();
    	if(this.btn.getText().equals("X")){
    		memo.setValeur(0);
    	} else {
    		int value = Integer.parseInt(this.btn.getText());
    		memo.setValeur(value);
    	}
    }
}
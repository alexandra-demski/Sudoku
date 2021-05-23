/**
* La classe <code>Interface</code> crée les différentes fenêtres nécessaires au jeu
* @author Alexandra Demski
*/
package gui;
import ctrl.ExitController; 
import ctrl.ChooseController; 
import ctrl.CreateController; 
import ctrl.FrameController; 

import javax.swing.JFrame; 
import javax.swing.JButton; 
import javax.swing.JLabel; 
import javax.swing.WindowConstants; 
import javax.swing.SwingConstants; 

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class StartFrame extends JFrame{
	
    private JButton create;
    private JButton solve;
    private JButton exit;
    private JLabel title;

    private ExitController exitCtrl;
    private ChooseController solveCtrl;
    private CreateController createCtrl;

    private static final long serialVersionUID = 1L;

    /**
     * Constructeur
     */
    public StartFrame(){
    	super("Sudoku"); 
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
        this.addWindowListener(new FrameController(this)); 

        this.create = new JButton("Create a Grid");
        this.solve = new JButton("Solve a Grid");
        this.exit = new JButton("Exit the Game");
        this.title = new JLabel("Welcome to Sudoku", SwingConstants.CENTER);

        this.exitCtrl = new ExitController(this,this.exit);
        this.solveCtrl = new ChooseController(this,this.solve);
        this.createCtrl = new CreateController(this,this.create);

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.title, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.solve, gbc);

        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.create, gbc);

        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.exit, gbc);

        this.pack();
        this.setSize(750, 500); 
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
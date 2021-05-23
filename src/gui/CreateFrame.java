/**
* La classe <code>CreateFrame</code> crée la fenêtre utilisée pour créer des grilles.
* @author Alexandra Demski
*/
package gui;

import ctrl.FrameController;
import ctrl.RestartController;
import ctrl.CheckController;
import ctrl.SaveController;
import ctrl.AutoCreateController;
import ctrl.BackController;
import ctrl.NumberController;

import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.JButton; 
import javax.swing.WindowConstants;

import java.awt.GridBagLayout; 
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Insets;

public class CreateFrame extends JFrame{

    private JPanel menu;
    private JButton restart;
	private JButton check;
    private JButton save;
    private JButton auto;
    private JButton back;

    private JButton un;
    private JButton deux;
    private JButton trois;
    private JButton quatre;
    private JButton cinq;
    private JButton six;
    private JButton sept;
    private JButton huit;
    private JButton neuf;
    private JButton none;

    private int[][] grille;
    private Grille grilleGui;

    private static final long serialVersionUID = 1L;

    /**
     * Constructeur
     * On ne prend aucun paramètre car la grille est vierge au début
     */
    public CreateFrame(){
        super("Sudoku - Create a Grid");
        
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
        this.addWindowListener(new FrameController(this)); 

        this.grille = new int[9][9];
        this.grilleGui = new Grille(this.grille);

        this.menu = new JPanel();

        this.restart = new JButton("Restart the Grid");
        this.check = new JButton("Check the Grid");
        this.save = new JButton("Save the Grid");
        this.auto = new JButton("Automatic Creation");
        this.back = new JButton("Back to Menu");

        RestartController restartCtrl = new RestartController(this,this.grilleGui,this.restart);
        CheckController checkCtrl = new CheckController(this,this.grille,this.check);
        SaveController saveCtrl = new SaveController(this,this.grille,this.save);
        AutoCreateController autoCtrl = new AutoCreateController(this.grille,this.grilleGui,this.auto);
        BackController backCtrl = new BackController(this,this.back);

        this.un = new JButton("1");
        this.deux = new JButton("2");
        this.trois = new JButton("3");
        this.quatre = new JButton("4");
        this.cinq = new JButton("5");
        this.six = new JButton("6");
        this.sept = new JButton("7");
        this.huit = new JButton("8");
        this.neuf = new JButton("9");
        this.none = new JButton("X");

        NumberController unCtrl = new NumberController(this.un);
        NumberController deuxCtrl = new NumberController(this.deux);
        NumberController troisCtrl = new NumberController(this.trois);
        NumberController quatreCtrl = new NumberController(this.quatre);
        NumberController cinqCtrl = new NumberController(this.cinq);
        NumberController sixCtrl = new NumberController(this.six);
        NumberController septCtrl = new NumberController(this.sept);
        NumberController huitCtrl = new NumberController(this.huit);
        NumberController neufCtrl = new NumberController(this.neuf);
        NumberController noneCtrl = new NumberController(this.none);

        this.menu.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 5, 5, 0);

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.menu.add(un,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.menu.add(deux,gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        this.menu.add(trois,gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        this.menu.add(quatre,gbc);

        gbc.gridx = 4;
        gbc.gridy = 0;
        this.menu.add(cinq,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.menu.add(six,gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        this.menu.add(sept,gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        this.menu.add(huit,gbc);
        gbc.gridx = 3;
        gbc.gridy = 1;
        this.menu.add(neuf,gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        this.menu.add(none,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.menu.add(this.restart,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.menu.add(this.auto,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.menu.add(this.check,gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.menu.add(this.save,gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.menu.add(this.back,gbc);

        this.add(this.menu, BorderLayout.EAST);
        this.add(this.grilleGui);
        this.pack();
        this.setSize(750, 500); 
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
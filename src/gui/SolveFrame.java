/**
* La classe <code>SolveFrame</code> crée la fenêtre de résolution de grille.
* @author Alexandra Demski
*/
package gui;

import ctrl.FrameController;
import ctrl.NumberController;
import ctrl.RestartController;
import ctrl.ValidController;
import ctrl.SolveController;
import ctrl.BackController;

import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.JButton; 
import javax.swing.WindowConstants;

import java.awt.GridBagLayout; 
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Insets;

public class SolveFrame extends JFrame{

    private JPanel menu;
    private Grille grilleGui;
    private JButton restart;
	private JButton valid;	
    private JButton solve;
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

    private static final long serialVersionUID = 1L;

    /**
     * Constructeur
     * @param g grille de sudoku chargée (model)
     */
    public SolveFrame(int[][] g){
        super("Sudoku - Solve a Grid");
        this.grille = g;
        this.grilleGui = new Grille(this.grille);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new FrameController(this));

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

        this.restart = new JButton("Restart the Grid");
        this.valid = new JButton("Valid the Grid");
        this.solve = new JButton("Solve the Grid");
        this.back = new JButton("Back to Menu");

        RestartController restartCtrl = new RestartController(this,this.grilleGui,this.restart);
        ValidController validCtrl = new ValidController(this,this.grille,this.valid);
        SolveController solveCtrl = new SolveController(this,this.grilleGui,this.grille,this.solve);
        BackController backCtrl = new BackController(this,this.back);

        this.menu = new JPanel();
        this.menu.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 5, 5, 0);

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.menu.add(this.un,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.menu.add(this.deux,gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        this.menu.add(this.trois,gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        this.menu.add(this.quatre,gbc);

        gbc.gridx = 4;
        gbc.gridy = 0;
        this.menu.add(this.cinq,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.menu.add(this.six,gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        this.menu.add(this.sept,gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        this.menu.add(this.huit,gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        this.menu.add(this.neuf,gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        this.menu.add(this.none,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.menu.add(this.restart,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.menu.add(this.solve,gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.menu.add(this.valid,gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
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
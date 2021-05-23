/**
* La classe <code>ChooseDialog</code> crée la boîte de dialogue pour choisir une grille.
* @author Alexandra Demski
*/
package gui;

import sudoku.SudokuManager;

import javax.swing.JFileChooser; 

public class ChooseDialog extends JFileChooser{

    private int[][] grille;
    private int result;
    private SudokuManager grilleManager;

    private int retour;

    private static final long serialVersionUID = 1L;

    /**
     * Constructeur
     * @param fr fenêtre parent
     * @param g tableaux représentant la grille à vérifier
     * @param btn bouton à écouter
     */
    public ChooseDialog(){
        super("./grilles");

        this.grille = new int[9][9];
        this.grilleManager = new SudokuManager(grille);

        this.retour = this.showOpenDialog(null);

        if(this.retour == JFileChooser.APPROVE_OPTION){
            this.result = grilleManager.read(this.grille, this.getSelectedFile().getName());
        }
    }

    /**
    * La méthode <code>getResult</code> retourne le résultat de la fontion read
    * @return le code de retour de la fonction read du SudokuManager
    */
    public int getResult(){
        return this.result;
    }

    /**
    * La méthode <code>getGrille</code> retourne la grille sélectionnée
    * @return la grille chargée
    */
    public int[][] getGrille(){
        return this.grille;
    }

}
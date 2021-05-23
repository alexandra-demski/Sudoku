/**
* La classe <code>EmptyCell</code> représente une case modifiable dans une grille de sudoku, par défaut sa valeur est 0 (vide)
* @author Alexandra Demski
*/
package gui;

import javax.swing.JButton;

import java.awt.Dimension;

public class EmptyCell extends JButton {

	private static final long serialVersionUID = 1L;
	
    private int coordsX;
    private int coordsY;
    private int value;

    /**
     * Constructeur
     * @param x coordonnées x
     * @param y coordonnées y
     */
    public EmptyCell(int x, int y){
        super();
        this.coordsX = x;
        this.coordsY = y;
        this.value = 0;
        this.setText(" ");
        this.setPreferredSize(new Dimension(100,100));
    }

    /**
    * La méthode <code>getCoordsX</code> retourne la coordonnées X de la case
    * @return coordonnées X de la case
    */
    public int getCoordsX(){
        return this.coordsX;
    }

    /**
    * La méthode <code>getCoordsY</code> retourne la coordonnées Y de la case
    * @return coordonnées Y de la case
    */
    public int getCoordsY(){
        return this.coordsY;
    }

    /**
    * La méthode <code>setValeur</code> modifie la valeur de la case
    * @param v nouvelle valeur de la case
    */
    public void setValeur(int v){
    	this.value = v;
    	if(this.value == 0){//Si c'est 0, on la rend vide
    		this.setText(" ");
    	} else {//Sinon on met le chiffre
    		this.setText(Integer.toString(v));//On doit convertir en String
    	}
    }

}
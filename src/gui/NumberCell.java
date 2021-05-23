/**
* La classe <code>NumberCell</code> représente une case non-modifiable contenant déj à un chiffreLa méthode <code>getCoordsX</code> p* @author Alexandra Demski
*/
package gui;

import javax.swing.JButton;

import java.awt.Dimension;

public class NumberCell extends JButton {

    private int coordsX;
    private int coordsY;
    private int valeur;

    private static final long serialVersionUID = 1L;

    /**
     * Constructeur
     * @param x coordonnées x
     * @param y coordonnées y
     * @param v valeur de la case
     */
    public NumberCell(int x, int y, int v){
        super();
        this.coordsX = x;
        this.coordsY = y;
        this.valeur = v;
        this.setText(Integer.toString(v));
        this.setPreferredSize(new Dimension(100,100));
        this.setEnabled(false);
    }

    /**
     * La méthode <code>getCoordsX</code> permet d'obtenir la coordonnée x de la case
     * @return la coordonnée y
     */
    public int getCoordsX(){
        return this.coordsX;
    }

    /**
     * La méthode <code>getCoordsY</code> permet d'obtenir la coordonné y de la case
     * @return la coordonnée y
     */
    public int getCoordsY(){
        return this.coordsY;
    }

    /**
     * La méthode <code>getValeur</code> permet d'obtenir la valeur de la case
     * @return la valeur de la case
     */
    public int getValeur(){
        return this.valeur;
    }
}
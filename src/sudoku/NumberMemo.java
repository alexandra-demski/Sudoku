/**
* La classe <code>NumberMemo</code> garde en mémoire le dernier chiffre séléctionné à l'aide de bouton.
* @author Alexandra Demski
*/
package sudoku;

public class NumberMemo{

    private int value;
    private static NumberMemo instance = new NumberMemo();

    /**
     * Constructeur
     */
    private NumberMemo(){
        this.value = -1;
    }

    /**
    * La méthode <code>setValeur</code> permet de modifier la valeur gardée en mémoire
    * @param v nouvelle valeur à sauvegarder
    */
    public void setValeur(int v){
        this.value = v;
    }

    /**
    * La méthode <code>getValeur</code> permet d'obtenir la valeur gardée en mémoire
    * @return la valeur sauvergardée
    */
    public int getValeur(){
        return this.value;
    }

    /**
    * La méthode <code>getInstance</code> renvoie l'instance de l'objet afin d'avoir le même objet durant toute l'utilisation de l'application
    */
    public static final NumberMemo getInstance(){
        return instance;
    }

}
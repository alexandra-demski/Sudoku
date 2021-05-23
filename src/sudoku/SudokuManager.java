/**
* La classe <code>SudokuManager</code> permet d'enregistrer ou charger une grille à partir d'un fichier.
* @author Alexandra Demski
*/
package sudoku;

import java.io.*;

public class SudokuManager extends Sudoku{

    private String fileName;

    /**
     * Constructeur
     * @param b grille de sudoku (model)
     */
    public SudokuManager(int[][] b){
        super(b);
        this.fileName = null;
    }

    /**
    * La méthode <code>save</code> permet l'enregistrement d'une grille de sudoku dans un fichier .gri
    * @param int[][] est la grille à sauvegarder dans le fichiers
    * @param String est le nom du fichier de destination
    * @throws IOException si l'écriture a échoué
    * @throws NumberFormatException si la conversion a échoué
    */
    public int save(int[][] b, String n){
        this.board = b;
        this.fileName = n;
        try{

            //Ouverture/Création d'un fichier .gri
            DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("./grilles/" + this.fileName + ".gri"));
            
            for(int i=0;i<=8;i++){

                String row = new String();

                //Stockage des chiffres de la ième ligne dans un String
                for(int j=0;j<=8;j++){
                    row=row+this.board[i][j];
                }

                //Conversion du String vers un Integer
                int rowNumbers = Integer.parseInt(row,10);

                //Ecriture dans le fichier
                outputStream.writeInt(rowNumbers);
            }

            //Fermeture du fichier et indication de la réussite
            outputStream.close();
            return 1;

        } catch(IOException ex) {
            //Si l'écriture échoue
            return -1;
        } catch(NumberFormatException ex) {
            //Si la conversion échoue
            return -2;
        }

    }

    /**
    * La méthode <code>read</code> permet le chargement d'une grille de sudoku à partir d'un fichier .gri
    * @param int[][] est la grille dans laquelle sera chargée le modèle voulu
    * @param String est le nom du fichier source
    * @throws FileNotFoundException si le fichier n'existe pas
    * @throws IOException si la lecture échoue
    */
    public int read(int[][] b, String n){
        this.board = b;
        this.fileName = n;
        try{

            //Ouverture d'un fichier
            DataInputStream inputStream = new DataInputStream(new FileInputStream("./grilles/" + this.fileName));
            for(int i=0;i<=8;i++){

                //Récupération de la ième ligne dans un Integer
                int rowNumbers = inputStream.readInt();
                //Conversion de la ligne en String
                String row = Integer.toString(rowNumbers);
                int length = row.length()-1;

                //On ne peut pas prévoir si il y aura des 0 au début de la ligne, on la remplie donc à l'envers
                for(int j=8;j>=0;j--){
                    
                    //Si on a écrit tout le String avant la fin de la ligne, on a des 0
                    if(length<0){
                        this.board[i][j]=0;
                    }
                    //Sinon on continue de remplir la ligne
                    else{
                        this.board[i][j]=Character.getNumericValue(row.charAt(length));
                        length--;
                    }
                }
            }

            //Fermeture du fichier
            inputStream.close();

            return 1;
        } catch(FileNotFoundException ex) {
            //Si le fichier n'existe pas
            return -1;               
        } catch(IOException ex) {
            //Si la lecture échoue
            return -2;                 
        }
    }

}
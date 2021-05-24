# Sudoku

May 2021

Alexandra Demski

**[Github Deposit of the project](https://github.com/alexandra-demski/Sudoku)**

## Generalities

The main goal of the project is to program an application using Java that will allow the user to solve and create sudoku grids. An automatic version of each functionality will be included.

## The Project

### Functionalities

The Sudoku application contains two main functionalities : the resolution and creation of sudoku grids.

The first functionality allows to import grids and fill them. When a user is done, they can check its validity, if the grid is correct, a suitable message will show up. There are other available options such as the automatic resolution or the resetting of the grid.

The second functionality permit the user to create their own sudoku grids,  stored in a file with the following extension ```file.gri```. There is also an automatic option as well as a restarting one. The user can check, at any point, if the grid is still consistent.

Because of its interactivity, the application is implemented in a coherent and enjoyable interface.

### Structure

The project include three repositories. The ```build``` folder contains the executables that allow the application to launch. The ```grilles``` folder store grid files created bu the user, three demo version are already present. The last repository, named ```src``` contains the source files, organized in different packages.

The application implements the architectural motif MVC (Model-View-Controller) separating source files in distinct packages : ```ctrl``` implements all the controllers of the application, creating the link between views and models, ```gui``` contains the whole graphic interface including the windows, box dialogs and personalized objects such as the sudoku grid and its different cells and lastly, ```sudoku``` store the different objects that contains the raw data of the application.

In order to execute to project, it's possible to use the Makefile with the ```make run``` command. However, Windows users may have to install complementary tools. The application can also be launch with the ```java -cp "./build" Start``` command. Please note that in both cased the Java Development Toolkit or the Java Runtime Environment must be installed so the ```javac``` and ```java``` command are recognized.

## The Code

### Sudoku

The superclass ```Sudoku``` integrate different functions useful for every functionality linked to sudoku grids : the search of an empty cell and the verification of a cell. This last function check if the value in a cell is unique in its column, row and square.

```java
public boolean checkCell(int num, int[] positions){
    int i=0,j=0;
    for(i=0;i<=8;i++){//Column
        if(this.board[positions[0]][i]==num & i!=positions[1]){
            return false;
        }
    }
    for(i=0;i<8;i++){//Row
        if(this.board[i][positions[1]]==num & i!=positions[0]){
            return false;
        }
    }
    int x = positions[0]-positions[0]%3;
    int y = positions[1]-positions[1]%3;
    for(i=x;i<x+3;i++){//Square
        for(j=y;j<y+3;j++){
            if(this.board[i][j]==num & i!=positions[0] & j!=positions[1]){
                return false;
            }
        }
    }
    return true;
}
```

### Automatic Solution

The automotic solution is implemented in the file ```SolveSudoku``` with the ```solve``` function.

The algorithm will run as long as the grid has empty cells.

When an empty cell is found, the program will try to fill it : each value is tested in order to keep the grid coherent.
When a correct value is found, the function is called again in order to fill the next empty cell.
If there isn't a correct value, the grid is no longer coherent  : one of the empty cells is false, therefor the algorithm puts its value to 0 in order to move back to the previous cell.

```java
public boolean solve(){
    int[] empty = new int[2];
    while(true){
        empty = findEmtpy();
        if(empty==null){//No Empty Cells
            return true;
        }
        else{//Empty Cell found
            int row=empty[0];
            int col=empty[1];
            int value;
            boolean valid;
            for(value=1;value<=9;value++){//Values are tested from 1 to 9
                valid=checkCell(value,empty);
                if(valid){
                    this.board[row][col]=value;
                    if(solve()){
                        return true;
                    }
                    //If we can't proceed, we move back
                    this.board[row][col]=0;
                }
            }
            return false;
        }
    }
}
```

### Automatic Creation

The automatic creation, implemented in the ```CreateSudoku``` class, is based on its resolution : the algorithm solve a grid and erase a random number of cells to make the grid playable. However, in order to make a grid more unique, it is important to change the order in which the value are tested, represented by a ```Pattern```, it will thus increase the number of possible grids.

```java
public void create(){
    solveRandom();//Solution with a random pattern
    int count;//Count of erased cells
    int fill = (int)(Math.random()*6)+17; //Random number of filled cells
    int empty=80-fill;//Number of cells to erase

    //Until there're cells to erase
    for(count=0;count<empty;count++){
        eraseCell();//Continue
    }
}
```

### File Manager

Each file is managed by the ```SudokuManager``` class that contains two methods : ```save``` and ```read```. The functions open a ```DataStream``` as an input or output and convert or translate each row. It is important to alarm the different errors, therefor, depending on the result, the functions return a different numeric value.

```java
public int read(int[][] b, String n){
    this.board = b;
    this.fileName = n;
    try{
        //Open file
        DataInputStream inputStream = new DataInputStream(new FileInputStream("./grilles/" + this.fileName));
        for(int i=0;i<=8;i++){
            int rowNumbers = inputStream.readInt();//Get the i-ligne in an Integer
            String row = Integer.toString(rowNumbers);//Translation to String
            int length = row.length()-1;
            for(int j=8;j>=0;j--){
                if(length<0){
                    this.board[i][j]=0;
                }
                else{
                    this.board[i][j]=Character.getNumericValue(row.charAt(length));
                    length--;
                }
            }
        }
        inputStream.close();//Close file
        return 1;
    } catch(FileNotFoundException ex) {
        return -1;//File not found   
    } catch(IOException ex) {
        return -2;//Read failed        
    }
```

```java
public int save(int[][] b, String n){
    this.board = b;
    this.fileName = n;
    try{
        //Open/Creation of file .gri
        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("./grilles/" + this.fileName + ".gri"));
        for(int i=0;i<=8;i++){
            String row = new String();
            for(int j=0;j<=8;j++){
                row=row+this.board[i][j];
            }
            int rowNumbers = Integer.parseInt(row,10);//Translate String to Integer
            outputStream.writeInt(rowNumbers);//Write in file
        }
        outputStream.close();//Close file
        return 1;
    } catch(IOException ex) {
        return -1;//Write failed
    } catch(NumberFormatException ex) {
        return -2;//Translation failed
    }
```

### Graphic Interface

**Windows**

The graphic interface contains three distinct windows : ```StartFrame```, ```CreateFrame``` and ```SolveFrame```. Each of them implements the necessary objects and places them with the layout ```GridBagLayout``` that allows an efficient personalization.

**Functionalities**

Each button, linked to a functionality, has an ```ActionListener``` dedicated to. There are part of the ```ctrl``` package :

```java
package ctrl;
import object; //Import package

public class Controller implements ActionListener{

	private type attribut; //Attribut if needed
    public Controller(type attribut, JButton btn){
    	//Initialisation
        btn.addActionListener(this);//Add listener
    }
    @Override
    public void actionPerformed(ActionEvent e){
    	//Action
    }
}
```

When an action is deemed critic, a confirmation will be asked with a ```JOptionPane.showConfirmDialog()```.

In order to save the grid, the name of the file will be asked with a  ```JOptionPane.showInputDialog()```.

To choose a file to import into the application, a ```ChooseDialog``` that inherit properties from a ```JFileChooser``` will show up.

**Sudoku Grid**

A sudoku grid is represented by the class ```Grille``` that extends a ```JPanel``` with a ```GridLayout```.

Based on the grid model, a two-dimension array of integer, the class will create two different buttons : ```NumberCell``` if the cell already has a value and will not be changed or ```EmptyCell``` that, by default, is blank but editable.

During the solving or creation of a grid, the user will select a number, saved in the singleton ```NumberMemo```. Its unique purpose is to keep the last selected number and return the same instance of itself if needed. When a number and a cell are selected, the cell will change its value.

The creation and resolution of a grid need a complementary function that will update each empty cell.

```java
public void updateGrille(){
    for (Iterator<EmptyCell> i = this.vides.iterator(); i.hasNext();){//Iteration in a list of empty cells
        EmptyCell e = i.next();
        int x = e.getCoordsX();//Get coordinates
        int y = e.getCoordsY();
        e.setValeur(this.grille[x][y]);//Update based on the model
    }
}
```

There's also the possibility to restart a grid by setting the value to 0 of each empty cell.

```java
public void restartGrille(){
    for (Iterator<EmptyCell> i = this.vides.iterator(); i.hasNext();){//Iteration in a list of empty cells
        EmptyCell e = i.next();
        e.setValeur(0);//Set to 0 (view)
        int x = e.getCoordsX();//Get coordinates
        int y = e.getCoordsY();
        this.grille[x][y] = 0;//Set to 0 (model)
    }
}
```

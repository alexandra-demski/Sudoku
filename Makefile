# --------------- VARIABLES --------------- #

# --- Répertoires fichiers --- #
BUILD = ./build/
SOURCE = ./src/

# --- Packages source --- #
S_PACK_CTRL = $(SOURCE)ctrl/
S_PACK_GUI = $(SOURCE)gui/
S_PACK_SDK = $(SOURCE)sudoku/

# --- Packages executable --- #
B_PACK_CTRL = $(BUILD)ctrl/
B_PACK_GUI = $(BUILD)gui/
B_PACK_SDK = $(BUILD)sudoku/

# --- Commande compilation --- #
JC = javac
JCFLAGS = -encoding UTF-8 -d "$(BUILD)" -classpath "./build" -sourcepath "$(SOURCE)"

# --- Commande execution --- #
JJ = java
JJFLAGS = -cp "./build"

# --------------- START --------------- #

but: $(BUILD)Start.class

$(BUILD)Start.class :	$(SOURCE)Start.java \
                       	$(S_PACK_GUI)StartFrame.java
	$(JC) $(JCFLAGS) $(SOURCE)Start.java

# --------------- CTRL --------------- #

$(B_PACK_CTRL)AutoCreateController.class : 	$(S_PACK_CTRL)AutoCreateController.java \
											$(S_PACK_SDK)CreateSudoku.java \
											$(S_PACK_GUI)Grille.java
	$(JC) $(JCFLAGS) $(S_PACK_CTRL)AutoCreateController.java

$(B_PACK_CTRL)BackController.class : 	$(S_PACK_CTRL)BackDialogController.java \
										$(S_PACK_GUI)StartFrame.java \
										$(S_PACK_SDK)NumberMemo.java
	$(JC) $(JCFLAGS) $(S_PACK_CTRL)BackDialogController.java

$(B_PACK_CTRL)CellController.class : 	$(S_PACK_CTRL)CellController.java \
										$(S_PACK_GUI)EmptyCell.java \
										$(S_PACK_SDK)NumberMemo.java
	$(JC) $(JCFLAGS) $(S_PACK_CTRL)CellController.java

$(B_PACK_CTRL)CheckController.class : 	$(S_PACK_CTRL)CheckController.java \
										$(S_PACK_SDK)CheckSudoku.java
	$(JC) $(JCFLAGS) $(S_PACK_CTRL)CheckController.java

$(B_PACK_CTRL)ChooseDialogController.class : 	$(S_PACK_CTRL)ChooseDialogController.java \
												$(S_PACK_GUI)ChooseDialog.java \
												$(S_PACK_GUI)SolveFrame.java
	$(JC) $(JCFLAGS) $(S_PACK_CTRL)ChooseDialogController.java

$(B_PACK_CTRL)CreateController.class : 	$(S_PACK_CTRL)CreateController.java \
										$(S_PACK_GUI)CreateFrame.java
	$(JC) $(JCFLAGS) $(S_PACK_CTRL)CreateController.java

$(B_PACK_CTRL)ExitController.class : 	$(S_PACK_CTRL)ExitDialogController.java
	$(JC) $(JCFLAGS) $(S_PACK_CTRL)ExitController.java

$(B_PACK_CTRL)FrameController.class : 	$(S_PACK_CTRL)FrameController.java
	$(JC) $(JCFLAGS) $(S_PACK_CTRL)FrameController.java

$(B_PACK_CTRL)NumberController.class : 	$(S_PACK_CTRL)NumberController.java \
										$(S_PACK_SDK)NumberMemo.java
	$(JC) $(JCFLAGS) $(S_PACK_CTRL)NumberController.java

$(B_PACK_CTRL)RestartController.class : $(S_PACK_CTRL)RestartController.java \
										$(S_PACK_GUI)Grille.java
	$(JC) $(JCFLAGS) $(S_PACK_CTRL)RestartController.java

$(B_PACK_CTRL)SaveController.class : 	$(S_PACK_CTRL)SaveController.java \
										$(S_PACK_GUI)StartFrame.java \
										$(S_PACK_SDK)SudokuManager.java
	$(JC) $(JCFLAGS) $(S_PACK_CTRL)SaveController.java

$(B_PACK_CTRL)SolveController.class : 	$(S_PACK_CTRL)SolveController.java \
										$(S_PACK_GUI)Grille.java
	$(JC) $(JCFLAGS) $(S_PACK_CTRL)SolveController.java

$(B_PACK_CTRL)ValidController.class : 	$(S_PACK_CTRL)ValidController.java \
										$(S_PACK_SDK)CheckSudoku.java
	$(JC) $(JCFLAGS) $(S_PACK_CTRL)ValidController.java

# --------------- GUI --------------- #

$(B_PACK_GUI)ChooseDialog.class : 	$(S_PACK_GUI)ChooseDialog.java \
									$(S_PACK_SDK)SudokuManager.java
	$(JC) $(JCFLAGS) $(S_PACK_GUI)ChooseDialog.java

$(B_PACK_GUI)CreateFrame.class : 	$(S_PACK_GUI)CreateFrame.java \
									$(S_PACK_CTRL)FrameController.java \
									$(S_PACK_CTRL)RestartController.java \
									$(S_PACK_CTRL)CheckController.java \
									$(S_PACK_CTRL)SaveController.java \
									$(S_PACK_CTRL)AutoCreateController.java \
									$(S_PACK_CTRL)BackController.java \
									$(S_PACK_CTRL)NumberController.java
	$(JC) $(JCFLAGS) $(S_PACK_GUI)CreateFrame.java

$(B_PACK_GUI)EmptyCell.class : $(S_PACK_GUI)EmptyCell.java
	$(JC) $(JCFLAGS) $(S_PACK_GUI)EmptyCell.java

$(B_PACK_GUI)Grille.class : $(S_PACK_GUI)Grille.java \
							$(S_PACK_CTRL)CellController.java
	$(JC) $(JCFLAGS) $(S_PACK_GUI)Grille.java

$(B_PACK_GUI)NumberCell.class : $(S_PACK_GUI)NumberCell.java
	$(JC) $(JCFLAGS) $(S_PACK_GUI)NumberCell.java

$(B_PACK_GUI)SolveFrame.class : $(S_PACK_GUI)SolveFrame.java \
								$(S_PACK_CTRL)FrameController.java \
								$(S_PACK_CTRL)NumberController.java \
								$(S_PACK_CTRL)RestartController.java \
								$(S_PACK_CTRL)ValidController.java \
								$(S_PACK_CTRL)SolveController.java \
								$(S_PACK_CTRL)BackController.java
	$(JC) $(JCFLAGS) $(S_PACK_GUI)SolveFrame.java

$(B_PACK_GUI)StartFrame.class : $(S_PACK_GUI)StartFrame.java \
								$(S_PACK_CTRL)ExitController.java \
								$(S_PACK_CTRL)ChooseController.java \
								$(S_PACK_CTRL)CreateController.java \
								$(S_PACK_CTRL)FrameController.java
	$(JC) $(JCFLAGS) $(S_PACK_GUI)StartFrame.java

# --------------- SUDOKU --------------- #

$(B_PACK_SDK)CheckSudoku.class : $(S_PACK_SDK)CheckSudoku.java
	$(JC) $(JCFLAGS) $(S_PACK_SDK)CheckSudoku.java

$(B_PACK_SDK)CreateSudoku.class : $(S_PACK_SDK)CreateSudoku.java
	$(JC) $(JCFLAGS) $(S_PACK_SDK)CreateSudoku.java

$(B_PACK_SDK)NumberMemo.class : $(S_PACK_SDK)NumberMemo.java
	$(JC) $(JCFLAGS) $(S_PACK_SDK)NumberMemo.java

$(B_PACK_SDK)Pattern.class : $(S_PACK_SDK)Pattern.java
	$(JC) $(JCFLAGS) $(S_PACK_SDK)Pattern.java

$(B_PACK_SDK)SolveSudoku.class : $(S_PACK_SDK)SolveSudoku.java
	$(JC) $(JCFLAGS) $(S_PACK_SDK)SolveSudoku.java

$(B_PACK_SDK)Sudoku.class : $(S_PACK_SDK)Sudoku.java
	$(JC) $(JCFLAGS) $(S_PACK_SDK)Sudoku.java

$(B_PACK_SDK)SudokuManager.class : $(S_PACK_SDK)SudokuManager.java
	$(JC) $(JCFLAGS) $(S_PACK_SDK)SudokuManager.java

# --------------- BUT --------------- 

run: but
	$(JJ) $(JJFLAGS) Start

.PHONY : 	but \
			run
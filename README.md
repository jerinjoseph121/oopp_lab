# CS 611 - Object Oriented Principles and Practices: Lab 1

Name: Jerin Joseph

BU ID: U11191999

## Main File Contents

1. Src File
  This file contains all the important .java files which are used to execute the program. For now there are two java files.
  - Main.java: Contains the code to execute the program. It also has the uses of methods of different classes.
  - PuzzleBoard.java: This class contains all the functionalities of the puzzle board. Including creation, shuffling, movement of tiles and to check if puzzle is complete. 
3. READ_ME file
  Contains all the important information about the project

## Run steps
- This entire project is an IntelliJ IDEA project, so download the project and run Main.java file.
- Note: Make sure java version 8 is being used since this project runs on that version.

## I/O Example:
<pre>
Welcome to the sliding puzzle game!!!
Choose the length and breadth of the sliding puzzle board.

Length: 2
Breadth: 2

Choose a move!
U -> Slide up
D -> Slide down
L -> Slide left
R -> Slide right
+-----+-----+
|  3  |  1  |
+-----+-----+
|  2  |     |
+-----+-----+
r
+-----+-----+
|  3  |  1  |
+-----+-----+
|     |  2  |
+-----+-----+

Choose a move!
U -> Slide up
D -> Slide down
L -> Slide left
R -> Slide right
+-----+-----+
|  3  |  1  |
+-----+-----+
|     |  2  |
+-----+-----+
d
+-----+-----+
|     |  1  |
+-----+-----+
|  3  |  2  |
+-----+-----+

Choose a move!
U -> Slide up
D -> Slide down
L -> Slide left
R -> Slide right
+-----+-----+
|     |  1  |
+-----+-----+
|  3  |  2  |
+-----+-----+
l
+-----+-----+
|  1  |     |
+-----+-----+
|  3  |  2  |
+-----+-----+

Choose a move!
U -> Slide up
D -> Slide down
L -> Slide left
R -> Slide right
+-----+-----+
|  1  |     |
+-----+-----+
|  3  |  2  |
+-----+-----+
u
+-----+-----+
|  1  |  2  |
+-----+-----+
|  3  |     |
+-----+-----+
Congrats!! You solved the sliding puzzle!

Do you want to restart? (Y or any key/N):
n
</pre>

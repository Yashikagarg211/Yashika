# Sudoku Solver Project

## Overview

This project is a Sudoku solver implemented in Java. It uses a recursive backtracking algorithm to solve Sudoku puzzles.

## Features

* Solves Sudoku puzzles using a recursive backtracking algorithm
* Supports input of Sudoku puzzles from the user
* Prints the solved Sudoku puzzle
* Handles invalid input and unsolvable puzzles

## Usage

1. Compile the Java code using `javac`
2. Run the program using `java`
3. Enter a Sudoku puzzle when prompted
4. The program will print the solved Sudoku puzzle

## Documentation

There are three functions that Sudoku-Suite provides the developer, along with one class. They are as follows:-

~Grid
   *An object that represents a 9x9 Sudoku grid. The Grid object does not validate the grid in any way, i.e, it   only holds the grid and values inside it.
   *While initialising, if the given values are invalid, an invalid argument exception is thrown.
   *Check out the examples below to see how we can initialise and use this object!
~void solve(Grid *grid)
   *A function that takes in a pointer to a Grid object and solves the Sudoku puzzle present in it. Returns nothing.
   *If the puzzle cannot be solved, an exception is thrown.
~bool is_valid_solution(Grid &grid)
    A function that takes in a Grid object and returns a bool with a value of true if the Grid object contains a finished and valid Sudoku solution.
~Grid generate_puzzle()
    A function that takes in nothing and returns a Grid object containing an unfinished Sudoku puzzle.

## Requirements

* Java Development Kit (JDK) 8 or later
* Java Runtime Environment (JRE) 8 or later

## Sudoku Solver - How it works?

This simple algorithm employs the use of backtracking, one of the more common methods to solve Sudoku puzzles in our program: 

1. Start.
2. We start with the first empty cell.
3. We generate a list of possible valid values that can be filled in that cell.
4. We iterate over this list and start with the first value. This value is placed in the required cell.
5. We move on to the next cell. We again generate a list of possibilities. However, if no list can be generated, then this means that there is something wrong with the value of the previous cell. We then move back to the previous cell and place the next value on the generated list in the cell now. We repeat this step until the current cell has a valid value placed inside it.
6. We stop when we reach the 81st cell (the last cell in a Sudoku puzzle) and have placed a valid value.
7. The puzzle has now been solved.
8. Stop.

## Author

[Yashika Garg]

## Acknowledgments

* ArzArav - Idea Inspiration

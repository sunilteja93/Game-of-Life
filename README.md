# Game-of-Life
# Conway's Game of Life

Rules:

The universe is a finite two dimensional grid of square cells (square matrix). Each cell has 2 possible states, alive or dead. Every cell interacts with its neighbors, these cells are horizontal, vertical, diagonal or adjacent. Therefore, each cell can have up to eight neighbors.

At each step in time, the following transitions occur:

  - Any live cell with fewer than two live neighbors dies, because of under population.
  - Any live cell with two or three live neighbors, lives on to the next generation.
  - Any live cell with more than three live neighbors dies, because of overpopulation.
  - Any dead cell with exactly three live neighbors becomes a live cell, because of reproduction.

Code Sample:

Write a program that accepts a file path as its argument, which contains the initial set cells, and Outputs, the next state of the universe based on the rules above. The file will contain only 0s and 1s. 1 means alive, 0 means dead. Treat out of bounds neighbors as dead.

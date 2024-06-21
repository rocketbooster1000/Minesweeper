# Minesweeper

Minesweeper is a logic puzzle video game genre generally played on personal computers. The game features a grid of clickable tiles, with hidden "mines" scattered throughout the board. 

## Downloading

Download the jar file from the latest release under the releases page, or download from the `release` folder in the repository. 

**You will need Java 8 or newer installed to use this program**

## How to play

For how to play the actual game of minesweeper, click [here](https://minesweepergame.com/strategy/how-to-play-minesweeper.php#:~:text=Minesweeper%20Rules&text=Minesweeper%20is%20a%20game%20where,mine%20you%20lose%20the%20game!)

The program will open a GUI console, after each turn it will display the current status of the board.
During each turn, the player will be prompted to enter a row, then a column of a tile they wish to interact with.
Then the player will be prompted to either Flag (`f`) or Break (`b`) the tile.

After the game is over a message will display whether the player has won or lost, and prompt the player to play again.

## Using the API

If you wish, you may create your own input and output system.

Each game requires a `MinesweeperBoard` and an `InOut` object.
You can extend `MinesweeperBoard` and implement required methods, and implement `InOut` and implement required methods.
Finally in the main program call `new MinesweeperGame(new CustomBoard(), new CustomInOut()).runGame()`

---

# Release Information

## v0.1.0

Initial release:
- Glorified console program wrapped in a GUI
- 10 by 10 with 10 mines (fixed)

See ReadMe for instructions

Download the jar from this release, or find it under the `release` folder

**Requires Java 8 or later**


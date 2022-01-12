package tictactoe

private const val GRID_SIDE = 3
private const val FOUR = 4
private const val EIGHT = 8
private const val SPACE_STRING = " "
private const val SPACE_CHAR = ' '
private const val X_CHAR = 'X'
private const val O_CHAR = 'O'

fun main() {
    var xWon = false
    var oWon = false
    var emptyCellsPresent = false
    var currentPlayerToken = X_CHAR

    // print("Enter cells: ")
    var cellsEntered = "" // : String // "" // readLine()!! // "O_OXXO_XX"
    // println(cellsEntered)

    val underScore = '_'
    val grid = MutableList(GRID_SIDE) { MutableList(GRID_SIDE) { SPACE_CHAR } }

    // var cellIndex = 0
    /*
    for (row in 0 until GRID_SIDE) {
        for (column in 0 until GRID_SIDE) {
            grid[row][column] = cellsEntered[cellIndex]
            cellIndex++
        }
    }
     */
    outputFieldGrid(grid)

    var gameState = "" // : String // = ""
    var winnerDecided = false
    var drawGame = false
    do {
        do {
            // println("gameState: $gameState; winnerDecided: $winnerDecided; drawGame: $drawGame")
            print("Enter the coordinates: ")
            val coordinates = readLine()!! // "1 4" // "3 1"
            val separateCoordinates = coordinates.split(SPACE_STRING)
            println(coordinates)

            var incorrectCoordinates = false
            var notNumbers = false
            var numberInvalid = false
            var validCoordinates = false
            var cellOccupied = false
            // println(separateCoordinates)
            for (coordinate in separateCoordinates) {
                // println("coordinate.first(): ${coordinate.first()}; coordinate.first().isDigit(): ${coordinate.first().isDigit()}")
                if (separateCoordinates.size > 1 && coordinate.first().isDigit()) {
                    // println("coordinate: $coordinate; coordinate.toInt(): ${coordinate.toInt()}; coordinate.toInt() < 1: ${coordinate.toInt() < 1}; coordinate.toInt() > GRID_SIDE: ${coordinate.toInt() > GRID_SIDE}; GRID_SIDE: $GRID_SIDE")
                    if (separateCoordinates.first().toInt() < 1 || separateCoordinates.first().toInt() > GRID_SIDE || separateCoordinates.last().toInt() < 1 || separateCoordinates.last().toInt() > GRID_SIDE) {
                        incorrectCoordinates = true
                        numberInvalid = true
                        // println("Coordinates should be from 1 to 3!")
                        break
                    } else {
                        // println(separateCoordinates)
                        val (xRow, yColumn) = separateCoordinates.map { it.toInt() }
                        // println("xRow: $xRow; yColumn: $yColumn; xRow > yColumn: ${xRow > yColumn}")
                        if (grid[xRow - 1][yColumn - 1] == X_CHAR || grid[xRow - 1][yColumn - 1] == O_CHAR) {
                            incorrectCoordinates = true
                            cellOccupied = true
                            break
                        } else {
                            grid[xRow - 1][yColumn - 1] = currentPlayerToken
                            currentPlayerToken = if (currentPlayerToken == X_CHAR) O_CHAR else X_CHAR
                            validCoordinates = true

                            cellsEntered = ""
                            for (row in grid.indices) {
                                cellsEntered += grid[row].joinToString("")
                            }

                            // outputFieldGrid(grid)
                            break
                        }
                    }
                } else {
                    incorrectCoordinates = true
                    notNumbers = true
                    // println("You should enter numbers!")
                    break
                }
            }
            if (notNumbers) println("You should enter numbers!")
            if (numberInvalid) println("Coordinates should be from 1 to 3!")
            if (cellOccupied) println("This cell is occupied! Choose another one!")
            if (validCoordinates) outputFieldGrid(grid)
        } while (incorrectCoordinates)

        // println("after coordinates")
        // println(cellsEntered)

        var xS = 0
        var oS = 0
        for (char in cellsEntered) {
            if (char.lowercaseChar() == 'x') {
                xS++
            } else if (char.lowercaseChar() == 'o') {
                oS++
            }
        }

        // println("xS: $xS; oS: $oS")

        val tooManyXs = (xS - oS) > 1
        val tooManyOs = (oS - xS) > 1

        if (tooManyOs || tooManyXs) {
            gameState = "Impossible"
            return println(gameState)
        }

        /**
         * winning rows
         */
        var startingIndex = 0
        if (cellsEntered[startingIndex] == cellsEntered[startingIndex + 1] && cellsEntered[startingIndex + 1] == cellsEntered[startingIndex + 2]) {
            if (cellsEntered[startingIndex].lowercaseChar() == 'x') {
                xWon = true
            } else if (cellsEntered[startingIndex].lowercaseChar() == 'o') oWon = true
        }

        startingIndex += GRID_SIDE
        if (cellsEntered[startingIndex] == cellsEntered[startingIndex + 1] && cellsEntered[startingIndex + 1] == cellsEntered[startingIndex + 2]) {
            if (cellsEntered[startingIndex].lowercaseChar() == 'x') {
                xWon = true
            } else if (cellsEntered[startingIndex].lowercaseChar() == 'o') oWon = true
        }

        startingIndex += GRID_SIDE
        if (cellsEntered[startingIndex] == cellsEntered[startingIndex + 1] && cellsEntered[startingIndex + 1] == cellsEntered[startingIndex + 2]) {
            if (cellsEntered[startingIndex].lowercaseChar() == 'x') {
                xWon = true
            } else if (cellsEntered[startingIndex].lowercaseChar() == 'o') oWon = true
        }

        /**
         * winning columns
         */
        startingIndex = 0
        if (cellsEntered[startingIndex] == cellsEntered[startingIndex + GRID_SIDE] && cellsEntered[startingIndex + GRID_SIDE] == cellsEntered[startingIndex + 2 * GRID_SIDE]) {
            if (cellsEntered[startingIndex].lowercaseChar() == 'x') {
                xWon = true
            } else if (cellsEntered[startingIndex].lowercaseChar() == 'o') oWon = true
        }

        startingIndex += 1
        if (cellsEntered[startingIndex] == cellsEntered[startingIndex + GRID_SIDE] && cellsEntered[startingIndex + GRID_SIDE] == cellsEntered[startingIndex + 2 * GRID_SIDE]) {
            if (cellsEntered[startingIndex].lowercaseChar() == 'x') {
                xWon = true
            } else if (cellsEntered[startingIndex].lowercaseChar() == 'o') oWon = true
        }

        startingIndex += 1
        if (cellsEntered[startingIndex] == cellsEntered[startingIndex + GRID_SIDE] && cellsEntered[startingIndex + GRID_SIDE] == cellsEntered[startingIndex + 2 * GRID_SIDE]) {
            if (cellsEntered[startingIndex].lowercaseChar() == 'x') {
                xWon = true
            } else if (cellsEntered[startingIndex].lowercaseChar() == 'o') oWon = true
        }

        /**
         * winning diagonals
         */
        startingIndex = 0
        if (cellsEntered[startingIndex] == cellsEntered[startingIndex + FOUR] && cellsEntered[startingIndex + FOUR] == cellsEntered[startingIndex + EIGHT]) {
            if (cellsEntered[startingIndex].lowercaseChar() == 'x') {
                xWon = true
            } else if (cellsEntered[startingIndex].lowercaseChar() == 'o') oWon = true
        }

        startingIndex += 2
        if (cellsEntered[startingIndex] == cellsEntered[startingIndex + 2] && cellsEntered[startingIndex + 2] == cellsEntered[startingIndex + FOUR]) {
            if (cellsEntered[startingIndex].lowercaseChar() == 'x') {
                xWon = true
            } else if (cellsEntered[startingIndex].lowercaseChar() == 'o') oWon = true
        }

        if (xWon && oWon) {
            gameState = "Impossible"
            return println(gameState)
        }

        if (xWon && !oWon) {
            winnerDecided = true
            gameState = "$X_CHAR wins"
            return println(gameState)
        }
        if (oWon && !xWon) {
            winnerDecided = true
            gameState = "$O_CHAR wins"
            return println(gameState)
        }

        if (SPACE_CHAR in cellsEntered || underScore in cellsEntered) {
            emptyCellsPresent = true
        }

        if (!xWon && !oWon && !emptyCellsPresent) {
            drawGame = true
            gameState = "Draw"
            return println(gameState)
        }
        // if (emptyCellsPresent) return println("Game not finished")
        if ('x' in cellsEntered) println("there is an x")
    } while (!winnerDecided && !drawGame)

}

private fun outputFieldGrid(grid: MutableList<MutableList<Char>>) {
    val horizontalBorder = "-".repeat(GRID_SIDE * GRID_SIDE)
    println(horizontalBorder)
    for (row in 0 until GRID_SIDE) {
        println("| ${grid[row].joinToString(SPACE_STRING)} |")
    }
    println(horizontalBorder)
}

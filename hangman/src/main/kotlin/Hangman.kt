val words = listOf(
    "apple", "laptop", "store", "style", "drawing", "house", "clock", "tower", "show", "playstation",
    "table", "flower", "lizard", "sofa", "cupboard", "tomato", "pillow", "star", "circle", "jellyfish"
)

var word = ""
val guesses = arrayListOf<Char>()
var remainingGuesses = 6
var mistakes = 0

fun main() {
    setupGame()
}

fun setupGame() {
    word = words.shuffled().first().toUpperCase()
    println(word)

    //adding as many "_" as the word is long.
    for (i in 1..word.length) {
        guesses.add('_')
    }

    var gameOver = false

    do {
        printGameStatus()
        println("Please enter a letter:")
        val input = readln()

        if (input.isEmpty()) {
            println("That's not a valid input. Please try again.")
        } else {
            val letter = input[0].toUpperCase()
            if (word.contains(letter)) {
                for (i in word.indices) {
                    if (word[i] == letter) {
                        guesses[i] = letter
                    }
                }

                //if we have no more '_', then the game is over
                if (guesses.contains('_').not()) gameOver = true
            } else {
                println("Sorry, that's not part of the word.")
                remainingGuesses--
                mistakes++
                if (mistakes == 6) gameOver = true
            }
        }
    } while (!gameOver)

    if (mistakes == 6) {
        printGameStatus()
        println("Sorry, you lost. The word was: \n$word")
    } else {
        printGameStatus()
        println("\nCongratulations, you won!")
    }
}

fun printGameStatus() {
    when (mistakes) {
        0 -> print0Mistakes()
        1 -> print1Mistake()
        2 -> print2Mistakes()
        3 -> print3Mistakes()
        4 -> print4Mistakes()
        5 -> print5Mistakes()
        6 -> print6Mistakes()
    }

    print("Word: ")
    for (element in guesses) {
        print("$element ")
    }
    println("\nYou have $remainingGuesses guess/es left.")
}

fun print0Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print1Mistake() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print2Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |      | ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print3Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /| ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print4Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print5Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |     /  ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print6Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |     / \\")
    println(" /|\\      ")
    println("/ | \\     ")
}
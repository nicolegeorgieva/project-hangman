import kotlin.random.Random

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
    val wordIndex = Random.nextInt(words.size)
    word = words[wordIndex].toUpperCase()

    println(word)

    println(print0Mistakes())
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
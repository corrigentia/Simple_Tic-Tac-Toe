fun main() {
    // put your code here
    val startingText = readLine()!!

    val firstChar = startingText.first()
    val lastChar = startingText.last()

    // val withOutFirstChar = startingText.drop(1)
    // val withOutLastChar = startingText.dropLast(1)

    println("$lastChar${startingText.dropLast(1).drop(1)}$firstChar")
}

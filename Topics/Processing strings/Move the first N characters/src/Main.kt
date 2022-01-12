fun main() {
    // write your code here
    val (word, places) = readLine()!!.split(" ")
    val numPlaces = places.toInt()

    // println("numPlaces: $numPlaces, word.length: ${word.length}")

    println(
        if (numPlaces > word.length) {
            word
        } else {
            word.drop(numPlaces) + word.substring(0, numPlaces)
        }
    )
}

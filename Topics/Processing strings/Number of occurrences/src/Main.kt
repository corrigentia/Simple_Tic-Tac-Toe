fun main() {
    // write your code here
    val text = readLine()!!
    val searchTerm = readLine()!!
    val wordsExcludingQuery = text.split(searchTerm)
    val occurrences = wordsExcludingQuery.lastIndex
    println(occurrences)
}

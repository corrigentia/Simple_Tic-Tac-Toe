private const val HUNDRED = 100

fun main() {
    // write your code here
    val geneSequence = readLine()!!
    var gcContent = 0

    for (char in geneSequence) {
        if (char.lowercaseChar() == 'g' || char.lowercaseChar() == 'c') gcContent++
    }

    val gcPercentage = gcContent.toDouble() * HUNDRED / geneSequence.length
    println(gcPercentage)
}

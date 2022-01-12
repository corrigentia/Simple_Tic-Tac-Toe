fun main() {
    // write your code here
    val word = readLine()!!.lowercase()
    println(if (word == word.reversed()) "yes" else "no")
}

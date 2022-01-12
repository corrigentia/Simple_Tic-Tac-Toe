fun main() {
    // write your code here
    val givenText = readLine()!!
    val words = givenText.split(" ")
    println(words.maxByOrNull { it.length }!!)
}

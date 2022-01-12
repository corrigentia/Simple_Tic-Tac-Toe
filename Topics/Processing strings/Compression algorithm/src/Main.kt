fun main() {
    // write your code here
    // hyperskill-9038-test-04 // a
    val longSequence = readLine()!!
    // val firstChar = longSequence.first()
    var compressedSequence = ""
    // var letters = longSequence.split("")
    var letterInstances = 1

    // var letterIndex = 0
    /*
    bigOuterLoop@ for (_letterIndex in longSequence.indices) {
        letterIndex = _letterIndex
        val currentLetter = longSequence[letterIndex]
        letterInstances = 1

        /*
        while (letterIndex < longSequence.length - 1 && longSequence[letterIndex] == longSequence[letterIndex + 1]) {
            letterInstances++
            continue@bigOuterLoop
        }
         */

        if (letterIndex < longSequence.length - 1 && longSequence[letterIndex] == longSequence[letterIndex + 1]) {
            letterInstances++
            // continue
        }
        if (letterIndex < longSequence.length - 1 && longSequence[letterIndex] != longSequence[letterIndex + 1]) {
            letterInstances = 1
        }

        compressedSequence += "$currentLetter$letterInstances"
        longSequence.drop(letterIndex)
        // longSequence.dropWhile { it == currentLetter }
    }
    */

    var baseLetter = longSequence.first()
    for (index in 1..longSequence.lastIndex) {
        baseLetter = longSequence[index - 1]
        if (baseLetter == longSequence[index]) {
            letterInstances++
        } else {
            compressedSequence += "$baseLetter$letterInstances"
            baseLetter = longSequence[index]
            letterInstances = 1
        }
    }
    compressedSequence += "$baseLetter$letterInstances"

    println(compressedSequence)
}

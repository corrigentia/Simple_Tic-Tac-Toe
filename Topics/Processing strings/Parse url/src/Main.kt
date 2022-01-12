fun main() {
    // write your code here
    val url = readLine()!!
    val domainParts = url.split("?")
    val parameterSoup = domainParts.last().replace("=&", "=not found&")
    val parameterPairs = parameterSoup.split("&")
    var password = ""
    // var isPassPresent = false

    for (index in parameterPairs.indices) {
        println(parameterPairs[index].split("=").joinToString(" : "))
        if ("pass" in parameterPairs[index]) {
            password = parameterPairs[index].substring(parameterPairs[index].indexOf("=") + 1)
            // isPassPresent = true
        }
    }

    if (password.isNotEmpty()) println("password : $password")
}

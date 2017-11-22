package chapter01

fun isUnique(str: String): Boolean {
    val letters = BooleanArray(26)
    var idx = 0
    str.toLowerCase().forEach {
        idx = it.toInt() - 'a'.toInt()
        if (letters[idx]) return false
        else letters[idx] = true
    }
    return true
}

fun isUniqueNoDataStructure(str: String): Boolean {
    val lcStr = str.toLowerCase()
    for (i in 0..(str.length - 1)) {
        for (j in (i + 1)..(str.length - 1)) {
            if (lcStr[i] == lcStr[j]) return false
        }
    }
    return true
}

fun main(args: Array<String>) {
    val func = ::isUniqueNoDataStructure
    assert(func("helo"))
    assert(!func("hello"))
    assert(func(""))
    assert(func("abcdefghijklmnopqrstuvwxyz"))
    assert(!func("xxx"))
}
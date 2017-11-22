package chapter01

fun stringRotation(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) return false

    val sb = StringBuilder()
    // initial case (original string)
    sb.append(str2)

    // all non-original rotations
    for (i in 1..(str2.length - 1)) {
        sb.append(str2[i - 1])
    }

    // check if str1 is a substring in generated rotations (if str1 is a rotation of str2)
    return sb.toString().isSubstring(str1)
}

fun main(args: Array<String>) {
    assert(stringRotation("waterbottle", "terbottlewa"))
    assert(!stringRotation("waterbottle", "waterbootle"))
    assert(!stringRotation("waterbottle", "waterbottlee"))
    assert(stringRotation("str", "str"))
    assert(stringRotation("trs", "str"))
    assert(stringRotation("rst", "str"))
    assert(!stringRotation("strs", "trs"))
    assert(stringRotation("work", "work"))
    assert(stringRotation("orkw", "work"))
    assert(stringRotation("rkwo", "work"))
    assert(stringRotation("kwor", "work"))
    assert(!stringRotation("wrok", "work"))
    assert(!stringRotation("wokr", "work"))
}

fun String.isSubstring(other: String) = contains(other, false)
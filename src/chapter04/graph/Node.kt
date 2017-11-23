package chapter04.graph

class Node<E>(var value: E? = null) {
    val children: MutableList<E?> = MutableList(2, { null })
    var left
        get() = children.getOrNull(0)
        set(value) {
            children[0] = value
        }
    var right
        get() = children.getOrNull(1)
        set(value) {
            children[1] = value
        }
}
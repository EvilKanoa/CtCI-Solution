package chapter02.linkedlist

class Node<T>(
    var value: T,
    var next: Node<T>? = null
) {
    override fun toString() = value.toString()
}
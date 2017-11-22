package chapter02

import chapter02.linkedlist.LinkedList
import chapter02.linkedlist.Node
import chapter02.linkedlist.linkedListOf

fun <T> removeDuplicates(list: LinkedList<T>) {
    val map = HashMap<T, Boolean>()
    var node = list.head
    var prev: Node<T>? = null
    while (node != null) {
        if (map[node.value] ?: false) {
            if (prev != null) {
                prev.next = node.next
            } else {
                list.head = node.next
            }
        } else {
            map.put(node.value, true)
            prev = node
        }
        node = node.next
    }
}

fun main(args: Array<String>) {
    val list1 = linkedListOf(1, 2, 3, 8, 4, 6, 3, 0, 9, 6, 7)
    val list2 = linkedListOf(1, 2)
    val list3 = linkedListOf(1, 1, 2)
    val list4 = linkedListOf(1, 1, 1, 2)
    val list5 = linkedListOf(1, 2, 3, 3, 3, 3, 4)

    removeDuplicates(list1)
    assert(list1 == linkedListOf(1, 2, 3, 8, 4, 6, 0, 9, 7))

    removeDuplicates(list2)
    assert(list2 == linkedListOf(1, 2))

    removeDuplicates(list3)
    assert(list3 == linkedListOf(1, 2))

    removeDuplicates(list4)
    assert(list4 == linkedListOf(1, 2))

    removeDuplicates(list5)
    assert(list5 == linkedListOf(1, 2, 3, 4))
}
package chapter02

import chapter02.linkedlist.LinkedList
import chapter02.linkedlist.Node
import chapter02.linkedlist.linkedListOf

fun <T> loopDetection(list: LinkedList<T>): Node<T>? {
    return null
}

fun main(args: Array<String>) {
    val nodeA = Node(1)
    nodeA.next = nodeA
    val list1 = LinkedList(nodeA)

    val nodeC = Node(3)
    nodeC.next = nodeC
    val list2 = linkedListOf(1, 2)
    list2.add(nodeC)

    val nodeB = Node(2)
    val nodeD = Node(4)
    nodeD.next = nodeB
    val list3 = linkedListOf(1)
    list3.add(nodeB)
    list3.add(3)
    list3.add(nodeD)

    val list4 = linkedListOf(1, 2, 3)

    assert(loopDetection(list1) == nodeA)
    assert(loopDetection(list2) == nodeC)
    assert(loopDetection(list3) == nodeB)
    assert(loopDetection(list4) == null)
}
package chapter02

import chapter02.linkedlist.LinkedList
import chapter02.linkedlist.Node
import chapter02.linkedlist.linkedListOf

fun <T> loopDetection(list: LinkedList<T>): Node<T> {

}

fun main(args: Array<String>) {
    val nodeA = Node(1)
    nodeA.next = nodeA
    val list1 = LinkedList(nodeA)

    val nodeC = Node(3)
    nodeC.next = nodeC
    val list2 = LinkedList<Int>()
    list2.ad
}
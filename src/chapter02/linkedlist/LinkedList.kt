package chapter02.linkedlist

class LinkedList<T>(var head: Node<T>? = null) {

    val tail: Node<T>?
        get() {
            if (head?.next == null) {
                return head
            } else {
                var node = head
                while (node?.next != null) node = node.next
                return node
            }
        }

    val count: Int
        get() {
            var count = 0
            forEach { count++ }
            return count
        }

    operator fun get(index: Int): T {
        var node = head
        var i = 0
        while (i < index && node != null) {
            node = node.next
            i++
        }
        if (i == index) return node!!.value
        else throw IndexOutOfBoundsException()
    }

    operator fun set(index: Int, value: T) {
        var node = head
        var i = 0
        while (i < index && node != null) {
            node = node.next
            i++
        }
        if (i == index) node!!.value = value
        else throw IndexOutOfBoundsException()
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is LinkedList<*> || other.count != count) return false

        var node1 = head
        var node2 = other.head
        while (node1 != null && node2 != null) {
            if (node1.value != node2.value) return false
            node1 = node1.next
            node2 = node2.next
        }

        return node1 == node2
    }

    fun add(node: Node<T>) {
        if (head == null) {
            head = node
        } else {
            tail?.let {
                it.next = node
            }
        }
    }

    fun add(value: T) = add(Node(value))

    fun forEach(action: (value: T) -> Unit) {
        var node = head
        while (node != null) {
            action.invoke(node.value)
            node = node.next
        }
    }

    fun toArray(): ArrayList<T> {
        val array = ArrayList<T>(count)
        forEach { array.add(it) }
        return array
    }
    fun append(value: T) {
        var newNode = Node(value)

        var lastNode = this.tail
        if (lastNode != null) {
            lastNode.next = newNode
        } else {
            head = newNode
        }
    }

}

fun <T> linkedListOf(vararg elements: T) = elements.toLinkedList()

fun <T> emptyLinkedList() = LinkedList<T>()

fun <T> Array<out T>.toLinkedList() = LinkedList<T>().apply {
    this@toLinkedList.forEach(this::add)
}

fun <T> Collection<T>.toLinkedList() = LinkedList<T>().apply {
    this@toLinkedList.forEach(this::add)
}

fun <T> List<T>.toLinkedList() = LinkedList<T>().apply {
    this@toLinkedList.forEach(this::add)
}
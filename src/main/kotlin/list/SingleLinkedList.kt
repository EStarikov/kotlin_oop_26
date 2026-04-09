package org.example.list

class SingleLinkedList : CustomList {

    private var head: Node? = null
    private var _size = 0
    private class Node(element: Int) {
       var value: Int = element
        var next: Node? = null
    }

    override val size: Int
        get() = _size

    override fun add(element: Int) {
        val newNode = Node(element)

        if (head == null) {
            head = newNode
            _size++
            return 
        }

        var cur: Node? = head
        while (cur?.next != null) {
            cur = cur.next
        }
        cur?.next = newNode
        _size++
    }

    override operator fun set(index: Int, value: Int) {
        if (index !in 0 until _size) {
            throw IndexOutOfBoundsException()
        }
        
        var cur: Node? = head
        repeat(index) {
            cur = cur?.next
        }

        cur!!.value = value
    }

    override fun addFirst(element: Int) {
        val newNode = Node(element)
        newNode.next = head
        head = newNode
        _size++
    }

    override operator fun get(index: Int): Int {
        if (index !in 0 until _size) {
            throw IndexOutOfBoundsException()
        }
        var cur: Node? = head
        repeat(index)  {
            cur = cur?.next
        }

        return cur!!.value
    }

    override fun indexOf(element: Int): Int {
        var cur: Node? = head
        for (i in 0 until _size) {
            if (cur?.value == element) {
                return i
            }
            cur = cur?.next
        }
        
        return -1
    }

    override fun remove(element: Int): Boolean {
        var cur: Node? = head ?: return false
        if (cur!!.value == element) {
            _size--
            head = cur.next
            return true
        }
        while (cur?.next != null) {
            if (cur.next?.value == element) {
                _size--
                cur.next = cur.next?.next
                return true
            }
            cur = cur.next 
        }
        return false
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            private var cur = head
            override fun hasNext(): Boolean {
                return cur != null
            }

            override fun next(): Int {
                if (!hasNext()) throw NoSuchElementException()
                val res = cur!!.value
                cur = cur!!.next
                return res
            }
        }
    }

    companion object {
        fun singleLinkedListOf(vararg items: Int) =
            items.fold(SingleLinkedList()) { list, item ->
                list.also { it.add(item) }
            }
    }
}
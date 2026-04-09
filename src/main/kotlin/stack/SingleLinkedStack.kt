package org.example.stack

import org.example.list.SingleLinkedList


class SingleLinkedStack : Stack, SingleLinkedList() {

    override val isEmpty: Boolean
        get() = (size == 0)

    override fun push(value: Int) {
        addFirst(value)
    }

    override fun peek(): Int {
        if (isEmpty) throw NoSuchElementException()
        return get(0)
    }
    override fun pop(): Int {
        if (isEmpty) throw NoSuchElementException()
        val value = get(0)
        remove(value)
        return value
    }
}
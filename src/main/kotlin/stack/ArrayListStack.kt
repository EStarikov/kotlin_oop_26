package org.example.stack

import org.example.list.CustomArrayList

class ArrayListStack : Stack {
    var arrayList = CustomArrayList(0)

    override fun add(element: Int) {
        arrayList.add(element)
    }

    override fun addFirst(element: Int) {
        arrayList.addFirst(element)
    }

    override fun get(index: Int): Int {
        return arrayList[index]
    }

    override fun set(index: Int, value: Int) {
        arrayList[index] = value
    }

    override fun indexOf(element: Int): Int {
        return arrayList.indexOf(element)
    }

    override fun remove(element: Int): Boolean {
        return arrayList.remove(element)
    }

    override val size: Int
        get() = arrayList.size

    override fun iterator(): Iterator<Int> {
        return arrayList.iterator()
    }
    override val isEmpty: Boolean
        get() = arrayList.size == 0

    override fun push(value: Int) {
        arrayList.addFirst(value)
    }

    override fun peek(): Int {
        if (isEmpty) throw NoSuchElementException()
        return arrayList[0]
    }

    override fun pop(): Int {
        if (isEmpty) throw NoSuchElementException()
        val result = arrayList[0]
        arrayList.remove(result)
        return result
    }
}
package org.example.list

class CustomArrayList(startSize: Int): CustomList {
    private var inner = IntArray(startSize)
    private var _size = 0

    override fun get(index: Int): Int {
        if (index >= _size) {
            throw IndexOutOfBoundsException()
        }
        return inner[index]
    }

    override fun set(index: Int, value: Int) {
        if (index >= _size) {
            throw IndexOutOfBoundsException()
        }
        inner[index] = value
    }

    override fun add(element: Int) {
        if (_size == inner.size) {
            resize(inner.size * 2)
        }
        inner[_size++] = element
    }

    private fun resize(newSize: Int) {
        val newArray = inner.copyOf(newSize + 1) //+1 на случай нулевой длины inner
        inner = newArray
    }

    override fun addFirst(element: Int) {
        if (_size == inner.size) {
            resize(inner.size * 2)
        }

        for (i in _size - 1 downTo 0) {
            inner[i + 1] = inner[i]
        }
        inner[0] = element
        _size++
    }

    override fun remove(element: Int): Boolean {
        var flag = false
        for (i in 0 until _size) {
            if (inner[i] == element && !flag) {
                flag = true
                _size--
                continue
            }
            if (flag) inner[i - 1] = inner[i]
        }
        return flag
    }

    override fun indexOf(element: Int): Int {
        for (i in 0 until _size) {
            if (inner[i] == element) {
                return i
            }
        }
        return -1
    }

    override val size: Int
        get() = _size

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            private var index = 0
            override fun hasNext() = index < _size
            override fun next(): Int {
                if (!hasNext()) throw NoSuchElementException()
                return inner[index++]
            }
        }
    }

    companion object {
        fun customArrayListOf(vararg items: Int) =
            items.fold(CustomArrayList(items.size)) { list, item ->
                list.also { it.add(item) }
            }
    }
}
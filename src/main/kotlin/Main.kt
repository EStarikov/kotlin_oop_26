package org.example

import org.example.list.SingleLinkedList.Companion.singleLinkedListOf
import org.example.stack.ArrayListStack
import org.example.stack.SingleLinkedStack

fun main() {
    val t = ArrayListStack()
    t.push(1)
    t.push(2)
    t.push(3)
    ListPrinter.printList(t)
}
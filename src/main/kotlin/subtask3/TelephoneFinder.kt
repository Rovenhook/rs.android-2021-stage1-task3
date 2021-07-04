package subtask3

import java.lang.StringBuilder

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.isEmpty()) return null
        val numberCopy = number.trim()
        for (i in numberCopy) {
            if (i !in '0'..'9') {
                return null
            }
        }
        val arr: ArrayList<String> = ArrayList<String>()

        for ((index, ch) in numberCopy.withIndex()) {
            val a: IntArray = getNeighbours(ch - '0')

            val sb: StringBuilder = StringBuilder(numberCopy)
            for (d in a) {
                var c = '0' + d
                sb.setCharAt(index,'0' + d)
                var s = sb.toString()
                arr.add(sb.toString())
            }
        }
        return arr.toTypedArray()
    }

    fun getNeighbours(number: Int): IntArray {
        val a: IntArray
        when (number) {
            1 -> {
                a = intArrayOf(2, 4)
            }
            2 -> {
                a = intArrayOf(1, 3, 5)
            }
            3 -> {
                a = intArrayOf(2, 6)
            }
            4 -> {
                a = intArrayOf(1, 5, 7)
            }
            5 -> {
                a = intArrayOf(2, 4, 6, 8)
            }
            6 -> {
                a = intArrayOf(3, 5, 9)
            }
            7 -> {
                a = intArrayOf(4, 8)
            }
            8 -> {
                a = intArrayOf(5, 7, 9, 0)
            }
            9 -> {
                a = intArrayOf(6, 8)
            }
            else -> {
                a = intArrayOf(8)
            }
        }

        return a
    }
}

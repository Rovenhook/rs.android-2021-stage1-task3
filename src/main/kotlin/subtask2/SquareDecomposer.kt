package subtask2

import kotlin.math.pow
import kotlin.math.sqrt

class SquareDecomposer {
    var p = 0

    fun decomposeNumber(number: Int): Array<Int>? {
        val _number: Long = number.toLong()
        p = 0
        val subnumber: Long = (_number - 1).toLong()
        val diff: Long = (_number * _number - subnumber * subnumber).toLong()
        val arr = ArrayList<Long>()
        arr.add(subnumber)

        if (_number <= 0) {
            return null
        }
        if (find(_number, arr, 0, diff)) {
            val arra = arr.subList(0, p + 1).toLongArray().reversed()
            val ar: Array<Int> = Array(arra.size, {0})

            for (i in arra.indices) {
                ar[i] = arra[i].toInt()
            }
            var sum = 0L
            for (i in arra) {
                sum += i * i
            }
            return ar
        } else {
            return null
        }
    }

    fun find(number: Long, arr: ArrayList<Long>, currentPos: Int, difference: Long): Boolean {
        val subnumber: Long = sqrt(difference.toDouble()).toLong()
        var diff = difference - subnumber * subnumber
        var pos = currentPos

        if (arr.contains(subnumber)) {
            return false
        } else {
            pos++
            if (pos <= arr.size - 1) {
                arr[pos] = subnumber
            } else {
                arr.add(subnumber)
            }
        }

        if (diff == 0L) {
            p = pos
            return true
        }
        if (diff < 0) {
            arr[pos] = 0
            return false
        }

        if (find(number, arr, pos, diff)) {
            return true
        } else {
            for (s in subnumber - 1 downTo 1) {
                if (arr.contains(s)) {
                    continue
                }
                arr[pos] = s
                diff = difference - s * s
                if (find(number, arr, pos, diff)) {
                    return true
                }
            }
        }
        arr[pos] = 0
        return false
    }
}

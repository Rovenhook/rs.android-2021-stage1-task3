package subtask1

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        if (array.size != 2) return null
        if (array[0] < 0 || array[1] <= 0) return null
        if (array[0] <= array[1]) return 1

        val posters = array[0]
        val colors = array[1]

        for (pick in 2 until colors) {
            if (getCombinations(pick, colors) == posters) {
                return pick
            }
        }
        return null
    }

    fun getCombinations(pick: Int, colors: Int): Int {
        // combinations = (colors! / (pick! * (colors - pick)!) = a / pick! = a / b
        var a: Long = 1
        for (i in (colors - pick + 1)..colors) {
            a *= i
        }
        var b: Long = 1
        for (i in 2..pick) {
            b *= i
        }
        if (a % b == 0L) {
            print("${a / b}")
            println()
            return (a / b).toInt()
        } else {
            return 0
        }
    }
}

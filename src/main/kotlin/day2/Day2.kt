package day2

import java.io.File
import kotlin.math.abs


fun main() {
    part1()
    part2()
}

fun part1() {

    var safe = 0

    File("${System.getProperty("user.dir")}/src/main/resources/day2/input.txt").readLines().forEach{
        val ints = it.split(" ").map(Integer::parseInt).toIntArray()
        if (getSafe(ints)) safe++
    }

    println(safe)
}

fun getSafe(ints: IntArray) : Boolean{
    var change = 0
    var isSafe = true
    (1 until ints.size).forEach lineForEach@{ i ->
        val first = ints[i-1]
        val second = ints[i]

        val curChange = first - second
        if (change == 0) change = curChange
        if ((curChange <= 0) != (change <= 0) || abs(curChange) < 1 || abs(curChange) > 3) {
            isSafe = false
            return@lineForEach
        }
        change = curChange
    }

    return isSafe
}

fun getPermutations(ints: IntArray) : ArrayList<IntArray> {   // There are probably better ways of doing this :|
    val permutations = ArrayList<IntArray>()
    permutations.add(ints)

    for (index in ints.indices) {
        permutations.add(ints.filterIndexed{i, _ -> i != index}.toIntArray())
    }

    return permutations
}

fun part2() {
    var safe = 0

    File("${System.getProperty("user.dir")}/src/main/resources/day2/input.txt").readLines().forEach{
        val ints = it.split(" ").map(Integer::parseInt).toIntArray()
        val permutations = getPermutations(ints)

        for (permutation in permutations) {
            if (getSafe(permutation)) {
                safe++
                break
            }
        }
    }

    println(safe)
}
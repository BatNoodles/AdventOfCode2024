package day1

import java.io.File
import java.util.Dictionary
import kotlin.math.abs


fun main() {
    part1()
    part2()
}

fun getLists(): Pair<ArrayList<Int>, ArrayList<Int>> {
    val leftList = arrayListOf<Int>()
    val rightList = arrayListOf<Int>()

    File("${System.getProperty("user.dir")}/src/main/resources/day1/input.txt").readLines().forEach{
        val split = it.split("   ")
        leftList.add(Integer.parseInt(split[0]))
        rightList.add(Integer.parseInt(split[1]))
    }
    return Pair(leftList, rightList)
}


fun part1() {
    val pair = getLists()
    val leftList = pair.first
    val rightList = pair.second

    leftList.sort()
    rightList.sort()

    var total = 0
    val leftIt = leftList.iterator()
    val rightIt = rightList.iterator()

    while (leftIt.hasNext()) {
        total += abs(leftIt.next() - rightIt.next())
    }

    println(total)
}

fun part2() {
    val pair = getLists()
    val leftList = pair.first
    val rightList = pair.second

    val sim = leftList.map {
        val count = rightList.count { rightIt -> rightIt == it }
        count * it
    }.reduce{total, it -> total + it}

    println(sim)


}
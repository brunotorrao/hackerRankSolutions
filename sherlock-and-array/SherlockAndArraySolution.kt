import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'balancedSums' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun balancedSums(arr: Array<Int>): String {
  // Write your code here

  val map = mutableMapOf<Int, Int>()

  var sum = 0
  for (i in 0..arr.size-1) {
    map.put(i, sum)
    sum += arr[i]
  }

  var sumRight = 0
  for (i in arr.size-1 downTo 0) {
    if (map.get(i) == sumRight) {
      return "YES"
    }
    sumRight += arr[i]
  }

  return "NO"
}

fun getLeftSums(arr: Array<Int>, pos: Int): Int {
  var count = 0
  for (i in pos-1 downTo 0) {
    count += arr[i]
  }
  return count
}

fun getRightSums(arr: Array<Int>, pos: Int): Int {
  var count = 0
  for (i in pos+1..arr.size-1) {
    count += arr[i]
  }
  return count
}

fun main(args: Array<String>) {
  val T = readLine()!!.trim().toInt()

  for (TItr in 1..T) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = balancedSums(arr)

    println(result)
  }
}

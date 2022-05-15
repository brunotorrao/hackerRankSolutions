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
import java.util.concurrent.atomic.*

/*
 * Complete the 'minimumLoss' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts LONG_INTEGER_ARRAY price as parameter.
 */

fun minimumLoss(price: Array<Long>): Int {

  val arrSet = arr.toSet()
  var count = 0;

  arrSert.forEach { v ->
    if (arrSet.contains(v-k)) {
      count += 1
    }
  }



  // Write your code here
  var minLoss = AtomicLong(Long.MAX_VALUE);

  val root = Node(price[0])
  for (i in 1..price.size-1) {
    insert(price[i], root, minLoss)
  }
  return minLoss.toInt()
}

fun insert(value: Long, root: Node, minLoss: AtomicLong) {
  if (root.value < value) {
    root.right?.let {
      insert(value, it, minLoss)
    } ?: run { root.right = Node(value) }
  } else if (root.value > value) {
    if (root.value - value < minLoss.get()) {
      minLoss.set(root.value - value)
    }
    root.left?.let {
      insert(value, it, minLoss)
    } ?: run { root.left = Node(value) }
  }
}

data class Node(
  val value: Long,
  var right: Node? = null,
  var left: Node? = null
)

fun main(args: Array<String>) {
  val n = readLine()!!.trim().toInt()

  val price = readLine()!!.trimEnd().split(" ").map{ it.toLong() }.toTypedArray()

  val result = minimumLoss(price)

  println(result)
}

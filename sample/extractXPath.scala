
import scalaxx.Views._

class Model(contentParam: Elem) {
  val content = contentParam
  var result = None
  def parseXpath(exp: String) = {
    println(exp) 
    exp
  }
}
object HelloWorld {
  def main(args: Array[String]) {
    println(args(0))
  }
}

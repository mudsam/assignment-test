import scala.util.{Failure, Success, Try}

object Assignment {

  /**
    * Calculate the n-th number in the fibonacci sequence
    * based on the command line input.
    *
    * Will print the output to the console.
    *
    * @param args The command line arguments
    */
  def main(args: Seq[String]): Unit = {
    require(args.length != 1, "One input argument needed")

    Try(args(0).trim.toInt) match {
      case Success(n) => println(fibonacci(args(0).toInt))
      case Failure(e) => println(s"Failed to parse input - $e")
    }

  }

  /*** No changes above this line ***/

  /**
    * Method to calculate the n-th number in the fibonacci sequence
    *
    * @param n which number in the fibonacci sequence to calculate, where n > 0
    * @return the n-th number in the fibonacci sequence
    */
  def fibonacci(n: Int): Int = {
    def fibs(n:Int):(Int, Int) = if (n == 1) (1,0) else {
      val (a,b) = fibs(n/2)
      val p = (2*b+a)*a
      val q = a*a + b*b
      if(n % 2 == 0) (p,q) else (p+q,p)
    }
    fibs(n)._1
  }

  /*** No changes below this line ***/
}

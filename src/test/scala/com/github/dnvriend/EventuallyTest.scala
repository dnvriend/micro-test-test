package com.github.dnvriend

import utest._

import scala.concurrent.Future
import scala.util.{ Failure, Success }

object EventuallyTest extends TestSuite {
  import scala.concurrent.ExecutionContext.Implicits.global

  implicit class PimpedFuture[A](val future: Future[A]) {
    def ==>[V](rhs: V): Boolean = future.value match {
      case Some(Success(lhs)) ⇒ lhs == rhs
      case Some(Failure(t))   ⇒ throw t
      case _                  ⇒ false
    }
  }

  def slow[A](a: A): Future[A] = Future {
    Thread.sleep(200)
    a
  }

  /**
   * eventually(tests: Boolean*): ensure that the boolean values of tests all
   * become true at least once within a certain period of time.
   */
  val tests = this{
    * - {
      val x = slow(1)
      eventually(x ==> 1)
    }
    * - {
      val y = slow(2)
      eventually(y ==> 2)
    }
    * - {
      val z = slow(3)
      eventually(z ==> 3)
    }
  }
}

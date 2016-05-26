package com.github.dnvriend

import utest._

object AssertTest extends TestSuite {
  /**
   * uTest comes with a macro-powered asserts that provide useful debugging information in the error message.
   * These take one or more boolean expressions, and when they fail, will print out the names, types and values
   * of any local variables used in the expression that failed. This makes it much easier to see what's going on
   * than Scala's default assert, which gives you the stack trace and nothing else.
   *
   * uTest also wraps any exceptions thrown within the assert, to help trace what went wrong:
   */
  val tests = this{
    'test1 - {
      val x = 10
      val y = 2
      assert(x / y == 5)
    }
    /**
     * You can use a ==> b as a shorthand for assert(a == b).
     * This results in pretty code you can easily copy-paste into documentation.
     */
    'test2 - {
      10 / 2 ==> 5
    }
  }
}

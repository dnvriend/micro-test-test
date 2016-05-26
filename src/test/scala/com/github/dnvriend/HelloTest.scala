package com.github.dnvriend

import utest._

/**
 * A test should extend utest.TestSuite
 * A test should be a Scala object
 */
object HelloTest extends TestSuite {

  /**
   * Each test class contains a Tree of Test(s)
   * that must be named 'tests'
   */
  val tests = this{
    // A Tree of Test can be created using the DSL
    // You can name test using a symbol
    'test1 - {
      intercept[Exception] {
        throw new Exception("test1")
      }
    }
    // You can use spaces in tests using a String
    "test with spaces" - {
      1
    }
    'test3 - {
      val a = List[Byte](1, 2)
      assert(a(1) == 2)
    }
  }
}

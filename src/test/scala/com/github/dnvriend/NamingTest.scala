package com.github.dnvriend

import utest._

object NamingTest extends TestSuite {

  /**
   * uTest also allows you to use strings to define test keys,
   * if you wish to make your test names longer and more descriptive
   */
  val tests = this{
    'testSuccess - {
      val x = 1
      val y = 2
      assert(x > 0)
    }
    'testFail - {
      val x = 1
      val y = 2
      intercept[AssertionError] {
        assert(
          x > 0,
          x == y
        )
      }
    }
    "test with spaces" - {
      assert(true)
    }
    'test1 - {
      * - { 1 == 1 }
      * - { 1 == 1 }
      * - { 1 == 1 }
    }
  }
}

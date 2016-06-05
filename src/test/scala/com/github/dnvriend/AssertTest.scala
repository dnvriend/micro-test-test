/*
 * Copyright 2016 Dennis Vriend
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

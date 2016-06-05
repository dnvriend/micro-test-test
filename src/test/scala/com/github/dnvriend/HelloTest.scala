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

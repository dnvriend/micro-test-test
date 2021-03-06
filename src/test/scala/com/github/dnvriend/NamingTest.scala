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

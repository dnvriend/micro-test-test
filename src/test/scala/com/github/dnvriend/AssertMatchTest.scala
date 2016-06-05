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

object AssertMatchTest extends TestSuite {

  case class Person(name: String)

  /**
   * assertMatch is a convenient way of checking that a value matches a particular shape,
   * using Scala's pattern matching syntax.
   *
   * This includes support for use of | or _ or if-guards within the pattern match.
   *
   * This gives you additional flexibility over a traditional assert(a == Seq(1, 2)),
   * as you can use _ as a wildcard
   *
   * As with assert, assertMatch adds debugging information to the error messages
   * if the value fails to match or throws an unexpected Exception while evaluating.
   */
  val tests = this{
    'test1 - {
      * - assertMatch(Seq(1, 2)) { case Seq(1, _) ⇒ }
      * - assertMatch("") { case _: String ⇒ }
      * - assertMatch(1) { case _: Int ⇒ }
      * - assertMatch(Person("")) { case Person(_) ⇒ }
    }
  }
}

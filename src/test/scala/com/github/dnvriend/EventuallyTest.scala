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

import scala.concurrent.duration.{ FiniteDuration, _ }
import scala.concurrent.{ Await, Future }

object EventuallyTest extends TestSuite {
  import scala.concurrent.ExecutionContext.Implicits.global

  implicit class PimpedFuture[A](val that: Future[A])(implicit timeout: FiniteDuration = 10.seconds) {
    def ==>[V](rhs: V): Boolean = Await.result[A](that, timeout) == rhs
  }

  def slow[A](a: A): Future[A] = Future {
    Thread.sleep(100)
    a
  }

  /**
   * eventually(tests: Boolean*): ensure that the boolean values of tests all
   * become true at least once within a certain period of time.
   */
  val tests = this{
    * - {
      val x = slow(300)
      x ==> 300
    }
    * - {
      val y = slow(500)
      y ==> 500
    }
    * - {
      val z = slow(700)
      z ==> 700
    }
  }
}

stucco-rt
==========

usage
-----
All commands should be run from within the Vagrant VM that is configured from the `dev-setup` repo.

basic sbt usage
---------------
All sbt commands need to be run from the project root directory. Prepend a tilde to any sbt command to run continuously, e.g. `'sbt ~test'` will run unit tests when any file changes.

The project can be compiled using `sbt compile`.

The project can be run using `sbt run`.

Unit tests can be run using `sbt test`.

Documentation can be generated using `sbt doc`. It will be located in `target/scala-2.10/api`.

A Scala REPL (with all dependencies on the classpath) can be brought up using `sbt console`.

For storm, a .jar file can be built using `sbt assembly`. The .jar file will include all the required dependencies (e.g. `storm`). The .jar file will be located in `target/scala_X.X.X/projectname-assembly-X.X.X.jar`.

intro to scala
--------------
* It is highly recommended that you practice with the Scala REPL to get the hang of Scala (you can bring it up by doing `sbt console` in the project directory.
* It would be best if you went through the lessons (right hand column) on 
[Twitter Scala School](http://twitter.github.io/scala_school/) and tried out examples in the REPL as you went through the lessons.

scala notes
-----------
Here are some things to be aware of as you're beginning Scala / reading through the code base.
* Methods with 1 parameter can be called using infix notation. For example, `obj.method(arg)` can be written as `obj method arg`.
* Blocks are enclosed in `{ ... }`.
* Everything is an expression (even an `if`, and so on). The last expression in a block is the implicit return value (a la Ruby).
* Methods that have side effects are written/called with Java-like notation such as `obj.doSomething()` or `obj.doSomething(arg)`. Methods that don't have side effects can be written using infix notation, or can omit the `()`. For example, methods can be written like `list.length` or `list drop 1`.
* Methods with a `void` return value (called `Unit` in scala) are written like:
    ```scala
    def method() {
      ...
    }
    ```
* Side-effect free methods with no arguments are written like:
    ```scala
    def method = {
      ...
    }
    ```
* Methods with a return value are written like:
    ```scala
    def method(arg1: Type1, arg2: Type2) = {
      ...
    }
    ```
* Scala uses type inference, but you need to specify the return type of recursive functions:
    ```scala
    def factorial(x: Int): Int = {
      if (x <= 0) 1 else x * factorial(x - 1)
    }
    ```
* There are no operators in Scala. Methods with one argument can be written in infix notation, so it's easy to make up new constructs that look like operators. Operators that end in a colon are right associative and are called on the RHS object. For example, `arg /: obj` is sugar for `obj./:(arg)`. To construct a list, for example, you can do `1 :: Nil`, which is sugar for `Nil.::(1)` which results in `List(1)`.

sbt resources
-------------
[Useful SBT Commands](http://scala.micronauticsresearch.com/sbt/useful-sbt-commands)

scala resources
---------------
[A Tour of Scala (+ FAQ)](http://docs.scala-lang.org/tutorials/)
[Twitter Scala School](http://twitter.github.io/scala_school/)
[Coursera Scala Course](https://www.coursera.org/course/progfun)

style guide
-----------
[Scala Style Guide](http://docs.scala-lang.org/style/)

scaladoc resources
------------------
[Writing Scaladoc](https://wiki.scala-lang.org/display/SW/Writing+Documentation)
[Scaladoc Wiki](https://wiki.scala-lang.org/display/SW/Scaladoc)
[Scaladoc Usage](http://dcsobral.blogspot.com/2011/12/using-scala-api-documentation.html)

logstash configuration
----------------------
A basic configuration for logstash is included in logstash.conf. The `dev-setup` install automatically gets this config file (from the `stucco/rt` github repo) and installs it in the VM in `/etc/logstash.conf`. To change the configuration, just edit this file. There is also an upstart script responsible for starting logstash, located in `/etc/init/logstash-indexer.conf`. If necessary, this file can be edited as well.

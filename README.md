## Scala-playground
This repo is for explaining scala core concepts and data structures.

1. [What is Scala?](http://allaboutscala.com/tutorials/scala-introduction/learn-scala-programming-language/)

2. [Scala Features](http://allaboutscala.com/tutorials/scala-introduction/scala-functional-programming-features/)

3. Functional programming is a style of programming that emphasizes writing applications using only pure functions and immutable values.
   What is a pure function ?
   
   a. The input solely determines the output.
   
      Impure function
      
       var a= 5
       def func(i:Int):Int = {return a + i}  // uses external variable a. 
       
      Pure function
      
       def func(i:Int, a:Int):Int = {return a+i}   // doesn't uses any external variable
   b. The function doesn't change its input values.
      
      Impure function
      
         def func(a:Int) = {a=a+1; return a} // changes value of input a
         
      Pure function
      
         def func(a:Int) = {return a + 10}  // doesn't change value of input
   
   c. There are no side effects, this means the function only do whatever it is intended for. It doesn't do anything extra.
   
      Impure function
      
         def func(a:Int) = {println("hello"); return a*a} // does extra thing - print hello
         
      Pure function
      
         def func(a:Int) = {return a*a} // nothing extra -simply returns square of number
   
   
For more read here -> https://www.signifytechnology.com/blog/2018/05/scala-and-functional-programming-why-by-mohammad-noor-abu-khleif. 
Another good read -> https://www.edureka.co/blog/scala-functional-programming/
 
4. [Scala basics](https://github.com/BParesh89/scala-playground/tree/master/src/main/scala/scalabasics)

5. [Functions](https://github.com/BParesh89/scala-playground/tree/master/src/main/scala/functions)

6. [OOPS](https://github.com/BParesh89/scala-playground/tree/master/src/main/scala/oops)

7. [Immutable Collection](https://github.com/BParesh89/scala-playground/tree/master/src/main/scala/immutablecollection)

8. [Mutable Collection](https://github.com/BParesh89/scala-playground/tree/master/src/main/scala/mutablecollection)

9. [Collection Functions](https://github.com/BParesh89/scala-playground/tree/master/src/main/scala/collectionfunctions)
### References
1. [AllAboutScala](http://allaboutscala.com/)

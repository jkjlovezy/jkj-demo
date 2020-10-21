package com.study.scala
import com.study.scala.User;
object InvokeJavaTest {
  def main(args: Array[String]): Unit = {
    var user = new User("user-name");
    print(user.getName)
    /*for( ss <- user.getBatches){
      print(ss)
    }*/
  }
}

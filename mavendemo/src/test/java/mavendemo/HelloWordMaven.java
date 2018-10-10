package mavendemo;

import org.junit.Test;
/**
 * ≤‚ ‘
 * @author Administrator
 *
 */
public class HelloWordMaven {
	  @Test
	  public void test1(){
		  Hello hello=new Hello();
		  hello.say();
		  
	  }
	  @Test
      public void test2(){
		  Hello hello=new Hello();
		  System.out.println(hello.print());
      }
}

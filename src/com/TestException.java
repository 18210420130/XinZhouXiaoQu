package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

/*java.lang.Throwable
  Error:错误：程序中不进行处理
  Exception:异常，要求在编写程序时，就要考虑对这些异常的处理
     编译时异常：在编译期间会出现的异常（执行javac.exe命令时出现的错误）
     运行时异常：在运行期间出现的异常（执行java.exe命令时，出现异常）

如何来处理Exception的异常
处理方式一：
  try{
	 可能会出现异常的代码 
  }catch(Exception e1){
	  处理的方式1
  }catch(Exception e2){
	 处理的方式2
  }finally{
	 一定要执行的代码
  }
   
  注：
  1.try内声明的变量，类似于局部变量，
           出了try{}语句，就不能被调用
  2.finally是可选的
  3.catch语句内部是对异常对象的处理
    > getMessage(); printStackTrace();
  4.可以有多个catch语句，try中抛出的异常类对象
          从上往下去匹配catch中的异常类的类型
  5.如果异常处理掉了，那么其后的代码继续执行
  6.如果有多个catch语句，那么异常从小到大排序
  7.finally中存放的是一定要执行的语句，
          不管try中，catch中是否仍有异常，
  8.try-catch是可以嵌套的
  
  
  

*/
public class TestException {

//	常见的运行时错误：
//	1.类型不匹配：InputMismatchException
	@Test
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个数字");
		try {
			int num1 = sc.nextInt();
			System.out.println(num1);
			// 如果用户输入的不是int类型
			// 会报：InputMismatchException
		} catch (InputMismatchException e) {
			System.out.println("输入有误");
		}

	}

	// 2.数组下标越界异常：
	// ArrayIndexOutOfBoundsException
	@Test
	public void test2() {
		int[] i = new int[10];
		try {
			System.out.println(i[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("出现异常了，除数不能为0");
		   
			try {
				System.out.println(10/0);
			} catch (ArithmeticException e1) {
				e1.printStackTrace();
			}catch(Exception e1){
				
			}
			
		}
			System.out.println("hello美女");
		
		
		}

	//3. 算术异常：ArithmeticException
	@Test
	public void test3() {
		try {
			int i = 10;
			System.out.println(i / 0);
		} catch (Exception e) {
			//打印错误信息的方法
			System.out.println(e.getMessage());
		}
	}

	// 4.类型转化异常：ClassCastException
	@Test
	public void test4() {
		try {
			Object obj = new Date();
			String str = (String) obj;
		}catch(ClassCastException e){
			System.out.println("类型转换异常");
		}catch (Exception e) {
			System.out.println("最大异常");
		}finally {
			
		}
	}

	//5. 空指针异常：NullPointerException
	@Test
	public void test5() {
		String str = new String("AA");
		str = null;
		System.out.println(str.length());

		int[][] arr = new int[2][];
		arr[0] = new int[3];
		arr[0][0] = 15;
		arr[0][1] = 12;
		arr[0][2] = 13;
		System.out.println(arr[0][0]);

	}
	
	//编译时错误
	@Test
	public void test6(){
		try {
			File file = new File("hello.txt");
			FileInputStream fis=new FileInputStream(file);
			int b;
			while((b = fis.read())!=-1){
				System.out.println((char)b);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package base;

import org.testng.annotations.Test;

public class TestClass2 {
@Test
	public void TestCase1() {
		System.out.println("TestClass2>>TestMethod1>>Thread"+Thread.currentThread().getId());
	}
@Test
public void TestCase2() {
	System.out.println("TestClass2>>TestMethod2>>Thread"+Thread.currentThread().getId());
}
@Test
public void TestCase3() {
	System.out.println("TestClass2>>TestMethod3>>Thread"+Thread.currentThread().getId());
}
@Test
public void TestCase4() {
	System.out.println("TestClass2>>TestMethod4>>Thread"+Thread.currentThread().getId());
}
}

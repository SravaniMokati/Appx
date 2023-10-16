package base;

import org.testng.annotations.Test;

public class TestClass1 {
	@Test
	public void TestCase1() {
		System.out.println("TestClass1>>TestMethod1>>Thread"+Thread.currentThread().getId());
	}
@Test
public void TestCase2() {
	System.out.println("TestClass1>>TestMethod2>>Thread"+Thread.currentThread().getId());
}
@Test
public void TestCase3() {
	System.out.println("TestClass1>>TestMethod3>>Thread"+Thread.currentThread().getId());
}
@Test
public void TestCase4() {
	System.out.println("TestClass1>>TestMethod4>>Thread"+Thread.currentThread().getId());
}
}

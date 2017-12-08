package com.buttonong.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GreetingImplTest {
	private Greeting greeting;
	
	/*在每次執行測試function前會執行一次
	 * 注意！！在Junit 4 時係使用Before，在Junit 5 時要使用BeforeEach
	 * */
	@BeforeEach
	public void setup() {
		greeting=new GreetingImpl();
		System.out.println("Setup");
	}
	
	@Test
	void greetShouldReturnValidOutput() {
		System.out.println("greetShouldReturnValidOutput");
		String result = greeting.greet("Junit");
		assertNotNull(result); //Check Result is null or not
		assertEquals("Hello Junit",result);
	}
	
	/* *
	 * 在Junit 5 中 無 expected的方式
	 * 要改用assertThrows的方法
	 * */
	@Test
	public void greetShouldThrowAnException_For_NameIsNull() {
		System.out.println("greetShouldThrowAnException_For_NameIsNull");
		assertThrows(IllegalArgumentException.class,() -> {
			greeting.greet(null);
		});
	}
	
	@Test
	public void greetShouldThrowAnException_For_NameIsBlank() {
		System.out.println("greetShouldThrowAnException_For_NameIsBlank");
		assertThrows(IllegalArgumentException.class,() -> {
			greeting.greet("");
		});
	}
	
	/*注意！！在Junit 4 時係使用After，在Junit 5 時要使用AfterEach*/
	@AfterEach
	public void cleanup() {
		System.out.println("Clean Up");
		greeting=null;
	}
}

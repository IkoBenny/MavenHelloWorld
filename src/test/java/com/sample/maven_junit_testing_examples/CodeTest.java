package com.sample.maven_junit_testing_examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CodeTest 
{
	@Test
	public void sayHelloTest() {
		Code code = new Code();
		assertEquals("Hello World", code.sayHello());
	}
}

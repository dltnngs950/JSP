package kr.or.ddit.servlet.basic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactorialTest {
	
	/*
	 	@Test : 테스트 메서드에 붙이는 어노테이션
	 			해당 어노테이션을 붙이지 않으면 테스트 메소드로 인식되지 않음 (테스트 대상에서 제외)
	 			제한사항.
	 			1. 메소드 시그니처를 정해진 대로 구성해야함
	 			   접근제어자 : public
	 			   반환타입 : void
	 			   인자 : 없음
	 			   
	 			테스트 메소드 통과조건
	 			1. 테스트 메소드를 실행하는 과정에서 예외가 없이 끝까지 실행된 경우
	 			2. assert 구문이 있을 경우 assert 구문이 전부 통과 했을때(참으로 인정 되었을때)
	 			
	 	@Before : 초기화 메소드에 붙이는 애노테이션
	 			  @Test 어노테이션이 붙은 테스트 메서드를 호출하기전에 먼저 실행함
	 			  @Before ==> @Test (test)
	 			  @Before ==> @Test (test2)
	 			  @Before ==> @Test (test3)
	 			  
	 	@BeforeClass, @AfterClass
	 		클래스 단위로 최소 1회식 호출되는 메서드
	 		
	 		@BeforeClass
	 			 @Before ==> @Test (test)   ==> @After
	 			 @Before ==> @Test (test2)  ==> @After
	 			 @Before ==> @Test (test3)  ==> @After
	 		@AfterClass
	 		제한사항 : static 메서드로 선언을 해야함
	 
	 */
	 
	private static final Logger logger = LoggerFactory.getLogger(FactorialTest.class);
	private Factorial factorial;

	@Before
	public void setup() {
		
		Factorial factorial = new Factorial();
		
		
	}
		
	@Test
	public void test() {
		/***Given***/ // 현재 테스트 환경에서 주어진 조건을 기술
		Factorial factorial = new Factorial();

		/***When***/ // 테스트를 검증하고자하는 행위 (method call)
		int result = factorial.calculate(5);
		/***Then***/ // 코드를 실행한 결과와 예상한 갑싱 일치하는지 검증
		assertEquals(100, result);
		
	}
	
	@Test
	public void test2() {
		logger.debug("test2()");
		
		/***Given***/ // 현재 테스트 환경에서 주어진 조건을 기술
		Factorial factorial = new Factorial();

		/***When***/ // 테스트를 검증하고자하는 행위 (method call)
		int result = factorial.calculate(0);
		/***Then***/ // 코드를 실행한 결과와 예상한 갑싱 일치하는지 검증
		assertEquals(1, result);
		// 팩토리얼의 정의를 보고 작성해야함 0팩토리얼의 값은 1이다 
		
	}
	
	@Test
	public void test3() {
		/***Given***/ // 현재 테스트 환경에서 주어진 조건을 기술
		Factorial factorial = new Factorial();

		/***When***/ // 테스트를 검증하고자하는 행위 (method call)
		int result = factorial.calculate(2);
		/***Then***/ // 코드를 실행한 결과와 예상한 갑싱 일치하는지 검증
		assertEquals(2, result);
		// 팩토리얼의 정의를 보고 작성해야함 0팩토리얼의 값은 1이다 
		
	}

}

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class JunitCycleTest {

    private static final Logger log = LoggerFactory.getLogger(JunitCycleTest.class);

    @BeforeAll // 전체 테스트를 시작하기 전에 1회 실행하므로 메서드는 static으로 선언
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach // 테스트 케이스를 시작하기 전마다 실행
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

    @AfterAll  // 전체 테스트를 마치고 종료하기 전에 1회 실행하는 메서드로 static으로 선언
    static void afterAll() {
        System.out.println("@AfeterAll");
    }

    @AfterEach // 테스트 케이스를 종료하기 전마다 실행
    public void afterEach() {
        System.out.println("@AfterEach");
    }

    /*
    * AssertThat 비교 메소드
    * isEqaulTo(A)          : A값과 같은지 검증
    * isNotEqualTo(A)       : A값과 다른지 검증
    * contains(A)           : A값을 포함하는지 검증
    * doesNotContain(A)     : A값을 포함하지 않는지 검증
    * startsWith(A)         : 접두사가 A인지 검증
    * endWith(A)            : 접미사가 A인지 검증
    * isEmpty()             : 비어 있는 값인지 검증
    * isNotEmpty()          : 비어 있지 않은 값인지 검증
    * isPositive()          : 양수인지 검증
    * isNegative()          : 음수인지 검증
    * isGreaterThan(1)      : 1보다 큰 값인지 검증
    * isLessThan(1)         : 1보다 작은 값인지 검증
    * */

    @DisplayName("Q1")
    @Test
    public void q1(){
        String name1 = "홍길동";
        String name2 = "홍길동";
        String name3 = "홍길은";

        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();

        assertThat(name1).isEqualTo(name2);
        assertThat(name1).isNotEqualTo(name3);
    }

    @DisplayName("Q2")
    @Test
    public void q2(){
        int number1 = 15;
        int number2 = 0;
        int number3 = -5;

        assertThat(number1).isPositive();
        assertThat(number2).isZero();
        assertThat(number3).isNegative();
        assertThat(number1).isGreaterThan(number2);
    }

    @Test
    public void q3() {
        System.out.println("first test");
    }

    @Test
    public void q4(){
        System.out.println("second test");
    }

    @BeforeEach
    public void beforeEach2() {
        System.out.println("Hello!");
    }

    @AfterAll
    public static void afterEach2() {
        System.out.println("Bye!");
    }
}

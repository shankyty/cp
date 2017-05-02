import org.junit.Test;
import static org.junit.Assert.*;

public class SparseFactorialDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		long lo = 4L;
		long hi = 8L;
		long divisor = 3L;
		assertEquals(3L, new SparseFactorialDiv2().getCount(lo, hi, divisor));
	}
	
	@Test(timeout=2000)
	public void test1() {
		long lo = 9L;
		long hi = 11L;
		long divisor = 7L;
		assertEquals(1L, new SparseFactorialDiv2().getCount(lo, hi, divisor));
	}
	
	@Test(timeout=2000)
	public void test2() {
		long lo = 1L;
		long hi = 1000000000000L;
		long divisor = 2L;
		assertEquals(999999999999L, new SparseFactorialDiv2().getCount(lo, hi, divisor));
	}
	
	@Test(timeout=2000)
	public void test3() {
		long lo = 16L;
		long hi = 26L;
		long divisor = 11L;
		assertEquals(4L, new SparseFactorialDiv2().getCount(lo, hi, divisor));
	}
	
	@Test(timeout=2000)
	public void test4() {
		long lo = 10000L;
		long hi = 20000L;
		long divisor = 997L;
		assertEquals(1211L, new SparseFactorialDiv2().getCount(lo, hi, divisor));
	}
	
	@Test(timeout=2000)
	public void test5() {
		long lo = 123456789L;
		long hi = 987654321L;
		long divisor = 71L;
		assertEquals(438184668L, new SparseFactorialDiv2().getCount(lo, hi, divisor));
	}
}

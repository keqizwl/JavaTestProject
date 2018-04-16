package cache.test;

import java.math.BigInteger;

public class ExpensiveFunction implements Computable<String, BigInteger> {

	@Override
	public BigInteger compute(String arg) throws InterruptedException {
		long time = Long.parseLong(arg);
		Thread.sleep(time);
		return BigInteger.valueOf(time);
	}

}

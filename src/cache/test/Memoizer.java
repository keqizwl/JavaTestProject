package cache.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**性能与可伸缩性
 * 缓存设计：
 * 1高并发
 * 2高性能
 * 3缓存移除
 * 4缓存清理，考虑内存占用。
 * @author Administrator
 *
 * @param <A>
 * @param <V>
 */
public class Memoizer<A, V> implements Computable<A, V> {
	private final ConcurrentHashMap<A, FutureTask<V>> cache = new ConcurrentHashMap<A, FutureTask<V>>();
	private final Computable<A, V> c;
	
	public Memoizer(Computable<A, V> c) {
		this.c = c;
	}
	
	
	/**
	 * 分析：
	 * 1并发安全
	 * 2并发性能
	 * 	1尽量让代码并发
	 * 	2不能有重复性行为
	 * 
	 * 1一个线程计算的时候，其他先可以可以计算吗，可以，那么就不应该用synch关键字
	 * 2一个线程cache的get的时候，cache可以
	 * 3一个线程用c计算arg，其他线程可以用c计算其他arg吗？如果arg相同，则不应该计算，换句话就是cache中含有result的时候
	 * @throws ExecutionException 
	 */
	@Override
	public V compute(A arg) throws InterruptedException {
		FutureTask<V> result  = cache.get(arg);
		if(result == null) {
			FutureTask<V> ft = new FutureTask<>(new Callable<V>() {

				@Override
				public V call() throws Exception {
					return c.compute(arg);
				}
			});
			result = cache.putIfAbsent(arg,  ft);
			if(result == null) {
				result = ft;
				ft.run();
			}
		}
		
		try {
			return result.get();
		} catch (ExecutionException e) {
			e.printStackTrace();
			return null;
		}
	}

}

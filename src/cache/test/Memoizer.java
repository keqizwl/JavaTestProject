package cache.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**�������������
 * ������ƣ�
 * 1�߲���
 * 2������
 * 3�����Ƴ�
 * 4�������������ڴ�ռ�á�
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
	 * ������
	 * 1������ȫ
	 * 2��������
	 * 	1�����ô��벢��
	 * 	2�������ظ�����Ϊ
	 * 
	 * 1һ���̼߳����ʱ�������ȿ��Կ��Լ����𣬿��ԣ���ô�Ͳ�Ӧ����synch�ؼ���
	 * 2һ���߳�cache��get��ʱ��cache����
	 * 3һ���߳���c����arg�������߳̿�����c��������arg�����arg��ͬ����Ӧ�ü��㣬���仰����cache�к���result��ʱ��
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

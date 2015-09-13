package SL;

import java.util.LinkedHashMap;
import java.util.Map;

public class Concurrent_LRU_Cache<K, V> {
	LinkedHashMap<K, V> cache;
	int size;

	public Concurrent_LRU_Cache(final int size) {
		this.size = size;
		cache = new LinkedHashMap<K, V>(size) {

			/**
			 * 
			 */
			private static final long serialVersionUID = -1540263907912772286L;

			@Override
			protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
				return size() > size;
			}

		};
	}

	public void put(K key, V value) {
		synchronized (cache) {
			cache.put(key, value);
		}
	}

	public V get(K key) {
		synchronized (cache) {
			return cache.get(key);
		}
	}
}

package org.jxch.study.util.cache;

import lombok.Getter;

import java.util.LinkedList;
import java.util.function.Function;

/**
 * LRU 缓存算法是一种保留最近使用数据的算法，添加缓存时是头添加，获取缓存数据时把数据放到头部，淘汰末尾的数据。
 * 基于 LinkedList 实现。
 *
 * 注意：线程不安全。
 *
 * @author jxch
 * @since 1.8
 * @see LinkedList
 * @param <T> 存到缓存中的数据类型
 */
public class LRUCache<T> {
    @Getter
    private final int capacity;
    @Getter
    private final LinkedList<T> cache;

    public LRUCache() {
        this(100);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedList<>();
    }

    public void put(T t) {
        if (cache.size() == capacity) {
            cache.removeLast();
        }
        cache.addFirst(t);
    }

    public T get(int index) {
        if (!(index >= 0 && index < cache.size())) {
            throw new IndexOutOfBoundsException("LRU size = " + cache.size() + ". 但是 index = " + index + ".");
        }
        T t = cache.get(index);
        cache.remove(index);
        put(t);
        return t;
    }

    public int indexOf(Function<T, Boolean> find) {
        int index = -1;
        for (int i = 0; i < cache.size(); i++) {
            if (find.apply(cache.get(i))) {
                index = i;
                break;
            }
        }

        return index;
    }

    public T findAndGet(Function<T, Boolean> find) {
        int index = indexOf(find);
        return index >= 0 ? get(index) : null;
    }

    public int size() {
        return cache.size();
    }
}

package org.jxch.study.util.cache;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * LRUCache 的测试用例
 *
 * @author jxch
 * @since 1.8
 * @see LRUCache
 */
@Slf4j
class LRUCacheTest {
    private static final LRUCache<Integer> cache;

    static {
        cache = new LRUCache<>(5);
        cache.put(1);
        cache.put(2);
        cache.put(3);
        cache.put(4);
        cache.put(5);
    }

    @Test
    void put() {
        cache.put(0);
        logCache();
    }

    @Test
    void get() {
        cache.get(1);
        logCache();
    }

    @Test
    void findAndGet() {
        cache.findAndGet(integer -> integer.equals(3));
        logCache();
    }

    void logCache() {
        log.info("cache:" + JSON.toJSONString(cache));
    }
}
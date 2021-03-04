package org.jxch.study.algorithm.util.cache;

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
    private static final LRUCache<Integer> LRU_CACHE;

    static {
        LRU_CACHE = new LRUCache<>(5);
        LRU_CACHE.put(1);
        LRU_CACHE.put(2);
        LRU_CACHE.put(3);
        LRU_CACHE.put(4);
        LRU_CACHE.put(5);
    }

    @Test
    void put() {
        LRU_CACHE.put(0);
        logCache();
    }

    @Test
    void get() {
        LRU_CACHE.get(1);
        logCache();
    }

    @Test
    void findAndGet() {
        LRU_CACHE.findAndGet(integer -> integer.equals(3));
        logCache();
    }

    void logCache() {
        log.info("cache:" + JSON.toJSONString(LRU_CACHE));
    }
}
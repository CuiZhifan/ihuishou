package com.qianfeng.redis.Service;

public interface IRedisService {
    void initializeIndex();
    String QueryRedis(String key);
}

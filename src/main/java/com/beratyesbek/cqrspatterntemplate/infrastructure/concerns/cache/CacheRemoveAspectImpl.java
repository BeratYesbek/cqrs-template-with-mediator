package com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.cache;

import com.beratyesbek.cqrspatterntemplate.infrastructure.redis.RedisCacheRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Configuration
@RequiredArgsConstructor
public class CacheRemoveAspectImpl {

    private final RedisCacheRepository repository;
    private final Logger logger = Logger.getLogger(CacheRemoveAspectImpl.class.getName());

    @After("@annotation(com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.cache.CacheRemoveAspect)")
    public void after(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        CacheRemoveAspect cacheRemoveAspect = method.getAnnotation(CacheRemoveAspect.class);
        Arrays.stream(cacheRemoveAspect.key()).forEach(repository::deleteAllKeysWithPrefix);
        logger.info("Cache is removed");
    }
}

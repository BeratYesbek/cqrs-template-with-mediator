package com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheAspect {
    String key();
    long duration() default 60;
}

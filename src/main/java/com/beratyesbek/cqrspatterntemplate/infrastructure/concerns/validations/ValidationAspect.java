package com.beratyesbek.cqrspatterntemplate.infrastructure.concerns.validations;

import com.beratyesbek.cqrspatterntemplate.infrastructure.mediator.Request;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.HashMap;

@Aspect
@Configuration
public class ValidationAspect {

    private static final HashMap<String, Validator> validators = new HashMap<>();

    @SneakyThrows
    @Before("@annotation(Validation)")
    public void before(JoinPoint joinPoint)  {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Validation validation = method.getAnnotation(Validation.class);


        Validator validator = getValidatorInstance(validation.validator());
        Request request = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof Request)
                request= (Request) arg;
        }
        validator.validate(request);
    }

    private Validator<?> getValidatorInstance(Class<?> validator) throws Exception {
        try {
            String key = validator.getName();
            Validator<?> instance = validators.get(key);
            if (instance != null)
                return instance;
            instance = (Validator<?>) validator.getDeclaredConstructor().newInstance();
            validators.put(key, instance);
            return instance;
        } catch (Exception e) {
            throw new Exception("Validator not found");
        }
    }
}

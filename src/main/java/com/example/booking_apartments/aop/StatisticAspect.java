package com.example.booking_apartments.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
@EnableAspectJAutoProxy // todo spring framework aop - find library and how to get a dependency
public class StatisticAspect {

    public static final String SHOW_APARTMENT = "showApartment";
    public static final String POINT_CUT = "execution(* com.example.booking_apartments.service.impl.ApartmentServiceImpl.*ApartmentInfoDto(..))";


   // @AfterReturning(pointcut = POINT_CUT, returning = "result")
    @AfterReturning(value = "execution(* com.example.booking_apartments.service.impl.ApartmentServiceImpl.showApartment(..))", returning = "result")
    public void getStatisticByRequest(JoinPoint aspect, Object result) {

        String nameOfTheMethod = aspect.getSignature().getName();
        log.info("Aspect caught the method " + nameOfTheMethod);

        if (nameOfTheMethod.equals(SHOW_APARTMENT)){

            log.info("Getting statistics for showApartment method");

        }
        // if... for others

    }

    // todo which works


//    @AfterReturning(value = "execution(* com.example.booking_apartments.service.impl.ApartmentServiceImpl.*ApartmentInfoDto(..))", returning = "result")
//     @AfterReturning(pointcut = POINT_CUT, returning = "result")

}

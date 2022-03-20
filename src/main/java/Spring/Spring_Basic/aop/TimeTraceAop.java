package Spring.Spring_Basic.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* Spring.Spring_Basic..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        System.out.println("START: "+ joinPoint.toString());

        try{
            Object result = joinPoint.proceed();
            return result; // 컨트롤 알트 시프트 T -> inline 가능
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: "+joinPoint.toString() +" "+timeMs+"ms");
        }


    }
}

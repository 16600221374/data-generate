package generator.javaII;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @ClassName: AOPTTTTTest
 * @Author: liuzuncai
 * @Description:
 * @Date: 2021/2/2 16:52
 * @Version: 1.0
 */
@Aspect
@Configuration
public class AOPTTTTTest {

    @Pointcut(value = "execution(* generator.javaII.AopTestImpl.*(..))")
    public void pointCut(){

    }


    @Before(value = "pointCut()")
    private void beforeMethod(JoinPoint joinPoint){
        System.out.println("@Before前置通知:"+ Arrays.toString(joinPoint.getArgs()));
    }
}

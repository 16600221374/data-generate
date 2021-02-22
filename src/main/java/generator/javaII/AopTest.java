package generator.javaII;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @ClassName: AopTest
 * @Author: liuzuncai
 * @Description: AOP测试实现
 * @Date: 2021/2/2 16:27
 * @Version: 1.0
 */
public interface AopTest {
    public void save(String uname,int age);
}

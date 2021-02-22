package generator.javaII;

/**
 * @ClassName: testAop
 * @Author: liuzuncai
 * @Description:
 * @Date: 2021/2/2 17:01
 * @Version: 1.0
 */
public class testAop {
    public static void main(String[] args) {
        AopTest aopTest = new AopTestImpl();
        aopTest.save("胡道权",23);
    }
}

package generator.javaII;

import util.IOUtil;

/**
 * @ClassName: FileTest
 * @Author: liuzuncai
 * @Description: 输入输出测试
 * @Date: 2021/1/27 15:30
 * @Version: 1.0
 */
public class FileTest {
    static String filePath1 = "/etc/new 4";
    static String filePath2 = "/etc/new 5";
    public static void main(String[] args) {
        try{
            IOUtil.textInputStream(filePath1,filePath2);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package util;

import com.encdata.oss.utils.ENCUtils;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName: IOUtil
 * @Author: liuzuncai
 * @Description: 输入与输出工具类
 * @Date: 2021/1/27 10:47
 * @Version: 1.0
 */
public class IOUtil {

    //FileInputStream输入输出
    public static void FileReadMethod(String readFileName,String writeFileName) throws IOException {
        File file = new File(readFileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(writeFileName);
        try{
            int len = 0;
            while ((len = fileInputStream.read()) != -1){
                fileOutputStream.write(len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    }

    public static void BufferedInputStreamMethod(String readFileName,String writeFileName) throws IOException {
        File file = new File(readFileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(writeFileName);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        try{
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            bufferedInputStream.close();
            bufferedOutputStream.close();
        }
    }

    //文本输入输出，可指定编码
    public static void textInputStream(String readFileName,String writeFileName) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(readFileName)));
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(writeFileName));
        byte[] bytes = new byte[1024];
        try{
            String len = "";
            while (ENCUtils.isNotEmpty(len = bufferedReader.readLine())){
                printWriter.println(len);
            }
        } catch (Exception e ){
            e.printStackTrace();
        }
        finally {
            bufferedReader.close();
            printWriter.close();
        }

    }
}

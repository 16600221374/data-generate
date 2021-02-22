package generator.javaII;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: IteratorTest
 * @Author: liuzuncai
 * @Description:
 * @Date: 2021/2/22 15:17
 * @Version: 1.0
 */
public class IteratorTest {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("a");
        Collection<String> collection = list;
        Iterator<String> iterator = collection.iterator();
        System.out.println(iterator.next());
        iterator.remove();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

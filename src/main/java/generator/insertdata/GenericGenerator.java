package generator.insertdata;

/**
 * TODO
 *
 * @Author: HuDaoquan
 * @Email: hudaoquan@enn.cn
 * @Date: 2020.10.20 10:30
 * @Version 1.0
 */

import java.util.Random;

public abstract class GenericGenerator {
    public abstract String generate();
    
    private static Random random = null;
    
    protected Random getRandomInstance() {
        if (random == null) {
            random = new Random(System.currentTimeMillis());
        }
        
        return random;
    }
}


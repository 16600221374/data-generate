package generator.insertdata;

/**
 * TODO
 *
 * @Author: HuDaoquan
 * @Email: hudaoquan@enn.cn
 * @Date: 2020.10.21 21:25
 * @Version 1.0
 */
public class CarTypeGenerator  extends GenericGenerator {
    
    private static final String[] FIRST_NAMES = new String[]{"微型轿车","小型轿车","紧凑型轿车","中型轿车","中大型轿车","豪华轿车",
            "豪华跑车","敞篷跑车", "面包车","双门跑车","越野车","消防车","救护车","油罐车","防弹车","工程车","其他类型车辆","警车","公务车"};
    
    
    private static CarTypeGenerator instance = new CarTypeGenerator();
    
    private CarTypeGenerator() {
    }
    
    public static CarTypeGenerator getInstance() {
        return instance;
    }
    
    
    @Override
    public String generate() {
        return FIRST_NAMES[getRandomInstance().nextInt(FIRST_NAMES.length)];
    }
    
}

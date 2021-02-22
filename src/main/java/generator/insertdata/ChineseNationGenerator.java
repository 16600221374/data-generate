package generator.insertdata;

/**
 * TODO
 *
 * @Author: HuDaoquan
 * @Email: hudaoquan@enn.cn
 * @Date: 2020.10.20 11:27
 * @Version 1.0
 */
public class ChineseNationGenerator extends GenericGenerator {
    
    private static final String[] FIRST_NAMES = new String[]{"蒙古族", "回族", "苗族", "傣族", "傈僳族", "藏族", "壮族", "朝鲜族",
            "高山族", "纳西族", "布朗族", "阿昌族", "怒族", "鄂温克族", "鄂伦春族", "赫哲族", "门巴族", "白族", "保安族", "布依族",
            "达斡尔族", "德昂族", "东乡族", "侗族", "独龙族", "俄罗斯族 ", "哈尼族", "哈萨克族", "基诺族", "京族", "景颇族", "柯尔克孜族",
            "拉祜族", "黎族", "珞巴族", "满族", "毛南族", "仫佬族", "普米族", "羌族", "撒拉族", "畲族", "水族", "塔吉克族", "塔塔尔族",
            "土家族", "仡佬族", "土族", "佤族", "维吾尔族", "乌孜别克族", "锡伯族", "瑶族", "裕固族", "彝族", "汉族", "其他"};
    
 
    private static ChineseNationGenerator instance = new ChineseNationGenerator();
    
    private ChineseNationGenerator() {
    }
    
    public static ChineseNationGenerator getInstance() {
        return instance;
    }
    
    
    @Override
    public String generate() {
        return FIRST_NAMES[getRandomInstance().nextInt(FIRST_NAMES.length)];
    }
    
    
}


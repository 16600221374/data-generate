package generator.insertdata;

/**
 * TODO
 *
 * @Author: HuDaoquan
 * @Email: hudaoquan@enn.cn
 * @Date: 2020.10.21 21:40
 * @Version 1.0
 */
public class CarBrandGenerator  extends GenericGenerator {
    
    private static final String[] FIRST_NAMES = new String[]{"奥迪","宝来","宝马","奔驰","本田","标致","别克","波罗","昌河","大发","大宇",
            "大众","道奇","东风","丰田","风神","福特","富士","红旗","华利","皇冠","霍顿","佳美","捷达","雷诺","林肯","凌志","铃木","罗孚","美日","尼桑","欧宝","奇瑞","起亚","三菱","绅宝","拉达","水星","速波","土星","夏利","现代","雅阁","云雀","中华","里程","思域","佳美","风度","蓝鸟","尊荣","阳光","通用","富豪","宾利","无限","富康","吉普","赛欧","奥拓","羚羊","悦达","吉利","本特利","菲亚特","阿库拉","海尔登","马自达","美洲虎","兰西亚","桑塔纳","帕萨特","派里奥","庞蒂克","斯柯达","松花江","太脱拉","沃尔沃","西亚特","雪佛兰","雪铁龙","英格尔","公爵王","波尔舍","依诺斯","阿尔法","法拉利","长安奥拓","吉利豪情","凯迪拉克","克莱斯勒","劳斯莱斯","普利茅斯","悦达起亚","神龙富康","丰田佳美","道奇捷龙","丰田皇冠","玛莎拉帝","奥兹莫比尔","沃克斯豪尔","陆地巡洋舰","阿斯顿·马丁","阿尔法罗米欧","丰田沙漠王子跑","车","奥迪","宝马","奔驰","本田","标致","道奇","丰田","福特","莲花","罗孚","摩根","尼桑","三菱","水星","土星","现代","阿库拉","保时捷","布加迪","法拉利","菲亚特","美洲虎","庞蒂克","特威尔","雪佛兰","玛莎拉蒂","克莱斯勒","兰博基尼","普利茅斯","旅行车","宝马","奔驰","本田","标致","大发","大宇","大众","别克","丰田","北京","道奇","福特","福田","吉普","江铃","富奇","悍马","解放","拉达","雷诺","猎豹","林肯","凌志","铃木","陆虎","罗孚","尼桑","欧宝","起亚","全顺","三菱","绅宝","水星","速波","通用","土星","现代","全顺","万通","万里","牡丹","友谊","亚星","北方","西沃","三星","金龙","羊城","东南","红叶","佳宝","阿库拉","得利卡","菲亚特","富利卡","海尔登","马自达","庞蒂克","切诺基","桑塔纳","松花江","沃尔沃","五十铃","雪佛兰","雪铁龙","优尼柯","塔菲克","亚细亚","克莱斯勒","普利茅斯","神龙富康","丰田海狮","丰田皮卡","丰田霸道","奥兹莫比尔","沃克斯豪尔","丰田大霸王","丰田考斯特","阿尔法罗米欧客","安凯","北方","北旅","长安","大宇","东风","红叶","华利","华夏","解放","金杯","京华","三峰","三菱","五菱","西沃","云马","中通","昌河","汉江","得利卡","依维柯","长安","道奇","东风","福特","福田","华利","江铃","解放","尼桑","日产","三菱","五菱","通用","现代","悍马","海尔登","雪佛兰","依维柯","斯太尔","卡玛斯"};
    
    
    private static CarBrandGenerator instance = new CarBrandGenerator();
    
    private CarBrandGenerator() {
    }
    
    public static CarBrandGenerator getInstance() {
        return instance;
    }
    
    
    @Override
    public String generate() {
        return FIRST_NAMES[getRandomInstance().nextInt(FIRST_NAMES.length)];
    }
}

//package generator;
//
///**
// * TODO
// *
// * @Author: HuDaoquan
// * @Email: hudaoquan@enn.cn
// * @Date: 2020.10.21 14:46
// * @Version 1.0
// */
//
//import org.apache.commons.lang3.RandomUtils;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class IdCardGenerator {
//
//
//    /**
//     * 生成方法
//     *
//     * @return
//     */
//    public static String generate() {
//
//        long startTime = System.currentTimeMillis();
//
//
//        String generater = "";
//        generater += RandomUtils.nextInt(110100, 659000);
//
//        generater += randomBirthday();
//        generater += RandomUtils.nextInt(0000, 9999);
////        generater += calcTrailingNumber();
//
//
//        long endTime = System.currentTimeMillis();
//        System.err.println("身份证耗时(毫秒):" + (endTime - startTime));
//        return generater;
//    }
//
////    /**
//     * 随机地区
//     *
//     * @return
//     */
//    public static int randomAreaCode() {
//        long startTime = System.currentTimeMillis();
//
//        int code = RandomUtils.nextInt(110100, 659000);
//
//        long endTime = System.currentTimeMillis();
//        System.err.println(" 地区耗时(毫秒):" + (endTime - startTime));
//
//        return code;
//    }
//
//    /**
//     * 随机出生日期
//     *
//     * @return
//     */
//    public static String randomBirthday() {
//        long startTime = System.currentTimeMillis();
//
//        //1970-01-01到2020-01-01 00:00:00
//        long chosenDate = RandomUtils.nextLong(0, 1577808000);
//
//        long endTime = System.currentTimeMillis();
//        String birthday = new SimpleDateFormat("yyyyMMdd").format(new Date(chosenDate));
//        System.err.println("   生日 耗时(毫秒):" + (endTime - startTime));
//
//        return birthday;
//    }
//
//
//    /*
//     * <p>18位身份证验证</p>
//     * 根据〖中华人民共和国国家标准 GB 11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
//     * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
//     * 第十八位数字(校验码)的计算方法为：
//     * 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
//     * 2.将这17位数字和系数相乘的结果相加。
//     * 3.用加出来和除以11，看余数是多少？
//     * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。
//     * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
//     */
//    public static String calcTrailingNumber() {
//        long startTime = System.currentTimeMillis();
//
//        char[] r = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
//        int code = RandomUtils.nextInt(0, 10);
//
//        long endTime = System.currentTimeMillis();
//        System.err.println("    最后一位耗时(毫秒):" + (endTime - startTime));
//
//        return String.valueOf(r[code]);
//    }
//
//    /**
//     * 随机产生3位数
//     *
//     * @return
//     */
//    public static String randomCode() {
//        long startTime = System.currentTimeMillis();
//
//        int code = RandomUtils.nextInt(000, 999);
//
//        long endTime = System.currentTimeMillis();
//        System.err.println("    3位数耗时(毫秒):" + (endTime - startTime));
//
//        return String.valueOf(code);
//    }
//
////    public static void main(String[] args) {
////        IdCardGenerator g = new IdCardGenerator();
////        for (int i = 0; i < 10; i++) {
////            System.out.print(g.generate());
////            System.out.print("\t");
////            System.out.print(g.generate());
////            System.out.print("\t");
////            System.out.print(g.generate());
////            System.out.print("\t");
////            System.out.println(g.generate());
////        }
////    }
//}
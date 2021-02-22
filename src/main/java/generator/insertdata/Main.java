package generator.insertdata;

import generator.insertdata.CarBrandGenerator;
import generator.insertdata.CarTypeGenerator;
import generator.insertdata.CaseTypeGenerator;
import generator.insertdata.ChineseAddressGenerator;
import generator.insertdata.ChineseAreaList;
import generator.insertdata.ChineseIDCardNumberGenerator;
import generator.insertdata.ChineseMobileNumberGenerator;
import generator.insertdata.ChineseNameGenerator;
import generator.insertdata.ChineseNationGenerator;
import generator.insertdata.ColorTypeGenerator;
import generator.insertdata.LicensePlateNumberGenerator;
import generator.insertdata.OrganizingInstitutionBarCode;
import lombok.Data;
import org.apache.commons.lang3.RandomUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * TODO
 *
 * @Author: HuDaoquan
 * @Email: hudaoquan@enn.cn
 * @Date: 2020.10.20 10:04
 * @Version 1.0
 */
@Data
public class Main {
    
    
    /**
     * 生成随机姓名
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String generateChineseName() {
//        long startTime = System.currentTimeMillis();
        String generatedName = ChineseNameGenerator.getInstance().generate();
//        long endTime = System.currentTimeMillis();
//        System.err.println(generatedName + "    耗时(毫秒):" + (endTime - startTime));
        return generatedName;
    }
    
    
    /**
     * 生成生日
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String generateBirthday(String idCard) {
//        long startTime = System.currentTimeMillis();
        String birthYear = idCard.substring(6, 10);
        String birthMonth = idCard.substring(10, 12);
        String birthDay = idCard.substring(12, 14);
        String birthdayStr = birthYear + "-" + birthMonth + "-" + birthDay + " " + "00:00:00";

//        long endTime = System.currentTimeMillis();
//
//        System.err.println(birthdayStr + "    耗时(毫秒):" + (endTime - startTime));
        return birthdayStr;
    }
    
    
    /**
     * 生成身份证号
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String generateIDCardNumber() {
//        long startTime = System.currentTimeMillis();
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
//        String idCard = IdCardGenerator.generate();
//        long endTime = System.currentTimeMillis();
//
//        System.err.println(idCard + "    耗时(毫秒):" + (endTime - startTime));
        return idCard;
    }
    
    /**
     * 生成身份证号对应的性别
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String generateIDCardNumberSex(String idCard) {

//        long startTime = System.currentTimeMillis();
        String sex = null;
        //生成性别
        if (idCard.charAt(idCard.length() - 2) % 2 == 0) {
//            System.err.println("女");
            sex = "女";
        } else {
//            System.err.println("男");
            sex = "男";
        }
//        long endTime = System.currentTimeMillis();
//        System.err.println(sex + "    耗时(毫秒):" + (endTime - startTime));
        return sex;
    }
    
    /**
     * 身份证生成发证机关
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    
    public static String generateIssueOrg() {

//        long startTime = System.currentTimeMillis();
        String issueOrg = ChineseAreaList.cityNameList
                .get(RandomUtils.nextInt(0, ChineseAreaList.cityNameList.size()))
                + "公安局某某分局辖区";
//        long endTime = System.currentTimeMillis();
//        System.err.println(issueOrg + "    耗时(毫秒):" + (endTime - startTime));
        return issueOrg;
    }
    
    /**
     * 生成年月日注册日期
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String generateValidPeriod() {
//        long startTime = System.currentTimeMillis();
        String birthday = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ChineseIDCardNumberGenerator.randomDate());
//        String time = generateBirthday(idCardNum);
//        String result = time.substring(0, 10);
//        long endTime = System.currentTimeMillis();
//        System.err.println(birthday + "    耗时(毫秒):" + (endTime - startTime));
        
        
        return birthday;
    }
    
    /**
     * 生成手机号
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String generateMobileNumber() {
//        long startTime = System.currentTimeMillis();
        
        String generatedMobileNum = ChineseMobileNumberGenerator.getInstance()
                .generate();

//        long endTime = System.currentTimeMillis();
//        System.err.println(generatedMobileNum + "    耗时(毫秒):" + (endTime - startTime));
        
        
        return generatedMobileNum;
    }
    
    /**
     * 生成住址
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String generateAddress() {


//        long startTime = System.currentTimeMillis();
        
        String generatedAddress = ChineseAddressGenerator.getInstance().generate();

//        long endTime = System.currentTimeMillis();
//        System.err.println(generatedAddress + "    耗时(毫秒):" + (endTime - startTime));
        return generatedAddress;
    }
    
    
    /**
     * 生成随机民族
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String generateChineseNation() {
//        long startTime = System.currentTimeMillis();
        
        String generatedNation = ChineseNationGenerator.getInstance().generate();

//        long endTime = System.currentTimeMillis();
//        System.err.println(generatedNation + "    耗时(毫秒):" + (endTime - startTime));
        return generatedNation;
    }
    
    /**
     * 生成随机车牌号
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String getLicensePlateNumber() {
//        long startTime = System.currentTimeMillis();
        
        String num = LicensePlateNumberGenerator.getPalte();
//
//        long endTime = System.currentTimeMillis();
//        System.err.println(num + "    耗时(毫秒):" + (endTime - startTime));
        return num;
    }
    
    /**
     * 生成随机组织机构代码
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String getOrganizationCode() {
//        long startTime = System.currentTimeMillis();
        
        String num = OrganizingInstitutionBarCode.getORGANIZATION_CODE();

//        long endTime = System.currentTimeMillis();
//        System.err.println(num + "    耗时(毫秒):" + (endTime - startTime));
        
        return num;
    }
    
    /**
     * 生成纳税识别号
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String getTaxCode() {
//        long startTime = System.currentTimeMillis();
        
        String num = OrganizingInstitutionBarCode.getTAX_REGISTRATION_CODE();

//        long endTime = System.currentTimeMillis();
//        System.err.println(num + "    耗时(毫秒):" + (endTime - startTime));
        
        return num;
    }
    
    /**
     * 生成案件编号
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String getCaseNum() {
//        long startTime = System.currentTimeMillis();
        
        String num = OrganizingInstitutionBarCode.getSOCIAL_CREDIT_CODE();

//        long endTime = System.currentTimeMillis();
//        System.err.println(num + "    耗时(毫秒):" + (endTime - startTime));
        return num;
    }
    
    /**
     * 生成案件ID
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String getCaseID() {
//        long startTime = System.currentTimeMillis();
        
        String num = OrganizingInstitutionBarCode.getBUSINESS_LISENSE_CODE();

//        long endTime = System.currentTimeMillis();
//        System.err.println(num + "    耗时(毫秒):" + (endTime - startTime));
        return num;
    }
    
    /**
     * 生成案件类型
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String getCaseType() {
//        long startTime = System.currentTimeMillis();
        
        String num = CaseTypeGenerator.getInstance().generate();

//        long endTime = System.currentTimeMillis();
//        System.err.println(num + "    耗时(毫秒):" + (endTime - startTime));
        return num;
    }
    
    /**
     * 生成车辆类型
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String getCarType() {
//        long startTime = System.currentTimeMillis();
        
        String num = CarTypeGenerator.getInstance().generate();

//        long endTime = System.currentTimeMillis();
//        System.err.println(num + "    耗时(毫秒):" + (endTime - startTime));
        return num;
    }
    
    /**
     * 生成车辆颜色
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String getCarColor() {
//        long startTime = System.currentTimeMillis();
        
        String num = ColorTypeGenerator.getInstance().generate();

//        long endTime = System.currentTimeMillis();
//        System.err.println(num + "    耗时(毫秒):" + (endTime - startTime));
        return num;
    }
    
    /**
     * 生成车辆颜色
     *
     * @author HuDaoquan
     * @date 2020.10.20 10:51
     **/
    public static String getCarBrand() {
//        long startTime = System.currentTimeMillis();
        
        String num = CarBrandGenerator.getInstance().generate();

//        long endTime = System.currentTimeMillis();
//        System.err.println(num + "    耗时(毫秒):" + (endTime - startTime));
        return num;
    }
    
    public static void getData() {
        long startTime = System.currentTimeMillis();
        
        
        String chineseName = generateChineseName();
        String idCardNum = generateIDCardNumber();
        String sex = generateIDCardNumberSex(idCardNum);
        String birthday = generateBirthday(idCardNum);
        String nowAddress = generateAddress();
        String nation = generateChineseNation();
        String domicileAddress = generateAddress();
        
        String mobileNum = generateMobileNumber();
        
        String addressName = generateIssueOrg();
        String addressDetail = generateAddress();
        
        String carPlateNumber = getLicensePlateNumber();
        
        String organizationCode = getOrganizationCode();
        String registerAddress = generateAddress();
        String registerDate = generateValidPeriod();
        String taxCode = getTaxCode();
        
        
        String caseDescription = "报案人" + chineseName + "在" + addressName + "看到了外星人；报案人身份证号：" + idCardNum +
                "；住址：" + nowAddress + "；手机号：" + mobileNum + "；性别：" + sex + "；生日：" + birthday + "；民族：" + nation +
                "。被告名下有一家公司，组织机构代码：" + organizationCode + "；注册地：" + registerAddress + "；纳税识别号：" + taxCode +
                "。案发后驾驶车牌号为“" + carPlateNumber + "”的拖拉机往" + addressDetail + "逃窜。报案日期：" + registerDate;
        String caseNum = getCaseNum();
        String caseId = getCaseID();
        String caseType=getCaseType();
//        System.out.println(caseDescription);


//        String insertPeopleInfoSQL =
//                "INSERT INTO  theme.t_dm_ryztb(xm,gmsfzh,csrq,xb_mc,xzz,mz_mc,hjdz,zjlid,xxrksj) values(" +
//                        "'" + chineseName + "'," + "'" + idCardNum + "'," + "'" + birthday + "'," + "'" + sex + "'," +
//                        "'" + nowAddress + "'," + "'" + nation + "'," + "'" + domicileAddress + "'," + "'" + caseId +
//                        "',now())";
//        String insertCaseInfoSQL =
//                "INSERT INTO  theme.t_dm_ryztb(ajbh,ajid,aabayms,zjlid,xxrksj) values(" +
//                        "'" + caseNum + "'," + "'" + caseId + "'," + "'" + caseDescription + "'," + "'" + caseId + "',now())";
//
//        String insertCarInfoSQL =
//                "INSERT INTO  theme.t_dm_ryztb(hphm,cz_sjh,cz_zjhm, cz_xm,zjlid,xxrksj) values(" +
//                        "'" + carPlateNumber + "'," + "'" + mobileNum + "'," + "'" + idCardNum + "'," + "'" + chineseName + "'," + "'" + caseId + "',now())";
//
//        String insertPhoneInfoSQL =
//                "INSERT INTO  theme.t_dm_ryztb(jz_xm,jz_zjhm,dhhm,zjlid,xxrksj) values(" +
//                        "'" + chineseName + "'," + "'" + idCardNum + "'," + "'" + mobileNum + "'," + "'" + caseId + "',now())";
//
//        String insertAddressInfoSQL =
//                "INSERT INTO  theme.t_dm_ryztb(ddmc,xxdz,zjlid,xxrksj) values(" +
//                        "'" + addressName + "'," + "'" + addressDetail + "'," + "'" + caseId + "',now())";
//
//        String insertOrganizationInfoSQL =
//                "INSERT INTO  theme.t_dm_ryztb(zzjg_dm,szd_xz,zcrq,tyshxydm,lxr_mc,fddbr_zjhm,lxr_sjhm,zjlid,xxrksj) values(" +
//                        "'" + organizationCode + "'," + "'" + registerAddress + "'," + "'" + registerDate + "'," + "'" + taxCode + "'," + "'" + chineseName + "'," + "'" + idCardNum + "'," + "'" + mobileNum + "'," + "'" + caseId + "',now())";
//        String sql = "show databases";

//        long endTime = System.currentTimeMillis();
//        System.err.println("    耗时(毫秒):" + (endTime - startTime));

//        connectImpala(insertPeopleInfoSQL);
    }
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            getData();
        }
        long endTime = System.currentTimeMillis();
        System.err.println("    耗时(毫秒):" + (endTime - startTime));
    }
    
    public static void connectImpala(String sql) {
        String daasJaas = "D:\\krb\\142\\daas_jaas.conf";
        String krb5 = "D:\\krb\\142\\krb5.conf";
        String url = "jdbc:impala://10.19.151.142:21050/default;AuthMech=1;KrbRealm=HADOOP.COM;" +
                "KrbHostFQDN=cluster-node-2; KrbServiceName=impala";
        
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String JDBC_DRIVER = "com.cloudera.impala.jdbc41.Driver";
        String CONNECTION_URL = url;
        
        try {
            System.setProperty("java.security.auth.login.config", daasJaas);
            System.setProperty("java.security.krb5.conf", krb5);
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(CONNECTION_URL);
            ps = con.prepareStatement(sql);
//            ps.addBatch();
//
//            ps.executeBatch();
            rs = ps.executeQuery();
            
            
            while (rs.next()) {
                System.out.println("result:" + rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

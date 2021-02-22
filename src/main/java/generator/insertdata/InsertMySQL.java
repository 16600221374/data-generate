package generator.insertdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * TODO
 *
 * @Author: HuDaoquan
 * @Email: hudaoquan@enn.cn
 * @Date: 2020.10.22 10:22
 * @Version 1.0
 */
public class InsertMySQL {
    
 
    
    public static void main(String[] args) {
        insert();
    }
    public static void insert(){
         String url = "jdbc:mysql://10.19.151.143:3306/hdq?rewriteBatchedStatements=true";
         
         String user = "root";
         String password = "Bocom_123";
        Connection conn = null;
        PreparedStatement pstmPhone =null,pstmCar=null,pstmPeople=null,pstmCase=null,pstmAddress=null,
                pstmOrganization=null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            String sqlPhone = "INSERT INTO hdq.dhhmztb2(jz_xm,jz_zjhm,dhhm) VALUES(?,?,?)";
            pstmPhone = conn.prepareStatement(sqlPhone);
    
            String sqlCar = "INSERT INTO hdq.dhhmztb(jz_xm,jz_zjhm,dhhm) VALUES(?,?,?)";
            pstmCar = conn.prepareStatement(sqlPhone);
    
            String sqlPeople = "INSERT INTO hdq.dhhmztb(jz_xm,jz_zjhm,dhhm) VALUES(?,?,?)";
            pstmPeople = conn.prepareStatement(sqlPhone);
    
            String sqlCase = "INSERT INTO hdq.dhhmztb(jz_xm,jz_zjhm,dhhm) VALUES(?,?,?)";
            pstmCase = conn.prepareStatement(sqlPhone);
    
            String sqlAddress = "INSERT INTO hdq.dhhmztb(jz_xm,jz_zjhm,dhhm) VALUES(?,?,?)";
            pstmAddress = conn.prepareStatement(sqlPhone);
    
            String sqlOrganization = "INSERT INTO hdq.dhhmztb(jz_xm,jz_zjhm,dhhm) VALUES(?,?,?)";
            pstmOrganization = conn.prepareStatement(sqlPhone);
            
            
            Long startTime = System.currentTimeMillis();
            for(int j = 1; j <= 3; j++) {
                for (int i = 1; i <= 1000000; i++) {
                    String chineseName = Main.generateChineseName();
                    String idCardNum = Main.generateIDCardNumber();
                    String sex = Main.generateIDCardNumberSex(idCardNum);
                    String birthday = Main.generateBirthday(idCardNum);
                    String nowAddress = Main.generateAddress();
                    String nation = Main.generateChineseNation();
                    String domicileAddress = Main.generateAddress();

                    String mobileNum = Main.generateMobileNumber();

                    String addressName = Main.generateIssueOrg();
                    String addressDetail = Main.generateAddress();

                    String carPlateNumber = Main.getLicensePlateNumber();
                    String carType= Main.getCarType();
                    String carColor=Main.getCarColor();
                    String carBrand=Main.getCarBrand();


                    String organizationCode = Main.getOrganizationCode();
                    String registerAddress = Main.generateAddress();
                    String registerDate = Main.generateValidPeriod();
                    String taxCode = Main.getTaxCode();


                    String caseDescription = "报案人" + chineseName + "在" + addressName + "看到了外星人；报案人身份证号：" + idCardNum +
                            "；住址：" + nowAddress + "；手机号：" + mobileNum + "；性别：" + sex + "；生日：" + birthday + "；民族：" + nation +
                            "。被告名下有一家公司，组织机构代码：" + organizationCode + "；注册地：" + registerAddress + "；纳税识别号：" + taxCode +
                            "。案发后驾驶车牌号为“" + carPlateNumber + "”的拖拉机往" + addressDetail + "逃窜。报案日期：" + registerDate;
                    String caseNum = Main.getCaseNum();
                    String caseId = Main.getCaseID();
                    String caseType=Main.getCaseType();


                    pstmPhone.setString(1, chineseName);
                    pstmPhone.setString(2, idCardNum);
                    pstmPhone.setString(3, mobileNum);

                    pstmPhone.addBatch();
                }
                pstmPhone.executeBatch();
                Long endTime = System.currentTimeMillis();
                System.out.println("OK,用时：" + (endTime - startTime));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            if(pstmPhone!=null){
                try {
                    pstmPhone.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

package generator.insertdata;

import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;


import java.io.IOException;


/**
 * @ClassName: insertDataToIndex
 * @Author: guowuwu
 * @Description:
 * @Date: 2020/9/25 17:36
 * @Version: 1.0
 */

public class InsertDataToIndex {
    
    static Integer patchNum = 20000;
    
    static String text = "";
    
    static String s = "fasdjfiwejr35wefhnasfhasuifwuirh2848484u88uwrufuwfhasdhifohaisdf898r2h4ryhw89qr8wfhuasfh28u3hswfehasfa";
    static String num = "21321344444738963488848488393948044234235235x";
    private int anInt;
    
    public static void main(String[] args) {
        InsertDataToIndex insertDataToIndex = new InsertDataToIndex();
        insertDataToIndex.insertData();
        
    }
    
    public void insertData() {
        RestHighLevelClient client1 = new RestHighLevelClient(RestClient.builder(new HttpHost("10.19.151.141",
                Integer.parseInt("9200"), "http")).setMaxRetryTimeoutMillis(300000));
        RestHighLevelClient client2 = new RestHighLevelClient(RestClient.builder(new HttpHost("10.19.151.142",
                Integer.parseInt("9200"), "http")).setMaxRetryTimeoutMillis(300000));
        RestHighLevelClient client3 = new RestHighLevelClient(RestClient.builder(new HttpHost("10.19.151.143",
                Integer.parseInt("9200"), "http")).setMaxRetryTimeoutMillis(300000));
        RestHighLevelClient client4 = new RestHighLevelClient(RestClient.builder(new HttpHost("10.19.151.144",
                Integer.parseInt("9200"), "http")).setMaxRetryTimeoutMillis(300000));
        
        for (int i = 0; i < 1; i++) {
            anInt = 2;
            if (i % 2 == 0 && i != 0) {
                for (int i1 = 0; i1 < anInt; i1++) {
                    
                    parall(client1);
                }
            } else if (i % 3 == 0) {
                for (int i1 = 0; i1 < anInt; i1++) {
                    parall(client2);
                }
                
            } else if (i == 1) {
                for (int i1 = 0; i1 < anInt; i1++) {
                    parall(client3);
                }
                
            } else {
                for (int i1 = 0; i1 < anInt; i1++) {
                    parall(client4);
                }
                
            }
        }
        
    }
    
    private static void parall(RestHighLevelClient client) {
        Thread thread = new Thread(new Runnable() {
    
            @Override
            public void run() {
                int n = 10;
                for (int i = 0; i < 50000; i++) {
        
                    try {
                        reInsert(client);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//                    System.out.println(i);
                }
            }
        });
        thread.start();
    }
    
    private static void reInsert(RestHighLevelClient client) throws IOException {
        
        BulkRequest bulkRequest = new BulkRequest();
        
        for (int i = 0; i < patchNum; i++) {
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
            
//            //电话
//            IndexRequest indexRequestPhone = new IndexRequest("impala-theme-t_dm_dhhmztb", "doc");
//            String jsonPhone = "{" +
//                    "\"JZ_XM\":\"" + chineseName + "\"" + "," +
//                    "\"JZ_ZJHM\":\"" + idCardNum + "\"" + "," +
//                    "\"DHHM\":\"" + mobileNum + "\"" +
//                    "}";
//            indexRequestPhone.source(jsonPhone, XContentType.JSON);
//            indexRequestPhone.timeout("3s");//字符串方式
//            //操作类型
//            indexRequestPhone.opType(DocWriteRequest.OpType.INDEX);//DocWriteRequest.OpType方式
//            bulkRequest.add(indexRequestPhone);
            
            
            //人员
            IndexRequest indexRequestPeople = new IndexRequest("base-impala-theme-t_dm_ryztb", "doc");
            String jsonPeople = "{" +
                    "\"xm\":\"" + chineseName + "\"" + "," +
                    "\"gmsfzh\":\"" + idCardNum + "\"" + "," +
                    "\"csrq\":\"" + birthday + "\"" + "," +
                    "\"xb_mc\":\"" + sex + "\"" + "," +
                    "\"xzz\":\"" + nowAddress + "\"" + "," +
                    "\"mz_mc\":\"" + nation + "\"" + "," +
                    "\"hjdz\":\"" + domicileAddress + "\"" +
                    "}";
            indexRequestPeople.source(jsonPeople, XContentType.JSON);
            indexRequestPeople.timeout("3s");//字符串方式
            //操作类型
            indexRequestPeople.opType(DocWriteRequest.OpType.INDEX);//DocWriteRequest.OpType方式
            bulkRequest.add(indexRequestPeople);
            
            
            
            
            
//            //车辆
//            IndexRequest indexRequestCar = new IndexRequest("impala-theme-t_dm_clztb", "doc");
//            String jsonCar = "{" +
//                    "\"hphm\":\"" + carPlateNumber + "\"" + "," +
//                    "\"cz_sjh\":\"" + mobileNum + "\"" + "," +
//                    "\"cz_xm\":\"" + chineseName + "\"" + "," +
//                    "\"cz_zjhm\":\"" + idCardNum + "\"" +"," +
//                    "\"cllx_mc\":\"" + carType + "\"" + "," +
//                    "\"hpys\":\"" + carColor + "\"" + "," +
//                    "\"clpp\":\"" + carBrand + "\"" + "," +
//                    "\"CZSZDXZ\":\"" + addressDetail + "\"" +
//                    "}";
//            indexRequestCar.source(jsonCar, XContentType.JSON);
//            indexRequestCar.timeout("3s");//字符串方式
//            //操作类型
//            indexRequestCar.opType(DocWriteRequest.OpType.INDEX);//DocWriteRequest.OpType方式
//            bulkRequest.add(indexRequestCar);
//
//
//
//
//
//            //案件
//            IndexRequest indexRequestCase = new IndexRequest("impala-theme-t_dm_asjztb", "doc");
//            String jsonCase = "{" +
//                    "\"ajbh\":\"" + caseNum + "\"" + "," +
//                    "\"ajid\":\"" + caseId + "\"" + "," +
//                    "\"ajmc\":\"" + caseType + "\"" + "," +
//                    "\"ajlx_mc\":\"" + caseType + "\"" + "," +
//                    "\"fakssj\":\"" + registerDate + "\"" + "," +
//                    "\"jyaq\":\"" + caseDescription + "\"" +
//                    "}";
//            indexRequestCase.source(jsonCase, XContentType.JSON);
//            indexRequestCase.timeout("3s");//字符串方式
//            //操作类型
//            indexRequestCase.opType(DocWriteRequest.OpType.INDEX);//DocWriteRequest.OpType方式
//            bulkRequest.add(indexRequestCase);
//
//
//
//            //地址
//            IndexRequest indexRequestAddress = new IndexRequest("impala-theme-t_dm_bzdzztb", "doc");
//            String jsonAddress = "{" +
//                    "\"ddmc\":\"" + addressName + "\"" + "," +
//                    "\"bzdzid\":\"" + caseId + "\"" + "," +
//                    "\"xxdz\":\"" + addressDetail + "\"" +
//                    "}";
//            indexRequestAddress.source(jsonAddress, XContentType.JSON);
//            indexRequestAddress.timeout("3s");//字符串方式
//            //操作类型
//            indexRequestAddress.opType(DocWriteRequest.OpType.INDEX);//DocWriteRequest.OpType方式
//            bulkRequest.add(indexRequestAddress);
//
//
//
//
//            //组织
//            IndexRequest indexRequestOrganization = new IndexRequest("impala-theme-t_dm_zzjgztb", "doc");
//            String jsonOrganization = "{" +
//                    "\"zzjg_dm\":\"" + organizationCode + "\"" + "," +
//                    "\"zcd_xz\":\"" + registerAddress + "\"" + "," +
//                    "\"zcrq\":\"" + registerDate + "\"" + "," +
//                    "\"tyshxydm\":\"" + taxCode + "\"" + "," +
//                    "\"lxr_mc\":\"" + chineseName + "\"" + "," +
//                    "\"fddbr_zjhm\":\"" + idCardNum + "\"" + "," +
//                    "\"zjjg_mc\":\"" + addressName + "\"" + "," +
//                    "\"lxr_sjhm\":\"" + mobileNum + "\"" +
//                    "}";
//            indexRequestOrganization.source(jsonOrganization, XContentType.JSON);
//            indexRequestOrganization.timeout("3s");//字符串方式
//            //操作类型
//            indexRequestOrganization.opType(DocWriteRequest.OpType.INDEX);//DocWriteRequest.OpType方式
//            bulkRequest.add(indexRequestOrganization);
        }
        client.bulk(bulkRequest);
    }
    
}

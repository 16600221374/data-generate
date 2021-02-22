package generator.insertdata;

/**
 * TODO
 *
 * @Author: HuDaoquan
 * @Email: hudaoquan@enn.cn
 * @Date: 2020.10.21 21:07
 * @Version 1.0
 */
public class CaseTypeGenerator  extends GenericGenerator {
    
    private static final String[] FIRST_NAMES = new String[]{"危害国家安全案","危害公共安全案","破坏社会主义市场经济秩序案","侵犯公民人身权利、民主权利案","侵犯财产案","妨碍社会管理秩序案","危害国防利益案","贪污贿赂案","渎职案","军人违反职责案","背叛、分裂国家案","叛变、叛逃案","间谍、资敌案","为境外窃取、刺探、收买、非法提供国家秘密情报案","其他危害国家安全案","背叛国家案","分裂国家案","煽动,分裂国家案","武装叛乱、暴乱案","策动武装暴乱案","颠覆国家政权案","煽动颠覆国家政权案","资助危害国家安全案","投敌叛逃案","叛逃案","间谍案","资敌案","为境外窃取国家秘密情报案","为境外刺探国家秘密情报案","为境外收买国家秘密情报案","为境外非法提供国家秘密情报案","以危险方法危害公共安全案","危害交通运输、公用设备安全案","实施恐怖、劫持案","非法制造，买卖，运输，邮寄，储存枪支弹药、爆炸物案","违反枪支弹药管理案","违反危险物品管理案","重大责任事故案","抢劫枪支、弹药、爆炸物案","盗窃、抢夺枪支、弹药、爆炸物案","其他危害公共安全案","放火案","决水案","爆炸案","投毒案","以其他危险方法危害公共安全案","失火案","过失决水案","过失爆炸案","过失投毒案","过失以其他危险方法危害公共安全案","破坏交通工具案","破坏交通设施案","破坏电力设备案","破坏燃气设备案","破坏易燃易爆设备案","破坏广播电视设施案","破坏公用电信设施案","过失损坏交通工具案","过失损坏交通设施案","过失损坏电力设备案","过失损坏燃气设备案","过失损坏易燃易爆设备案","过失损坏广播电视设施案","过失损坏公用电信设施案","组织、领导恐怖组织案","劫持航空器案","劫持船只案","劫持汽车案","暴力危及飞行安全案","非法制造枪支弹药案","非法买卖枪支弹药案","非法运输枪支弹药案","非法邮寄枪支弹药案","非法储存枪支弹药案","非法制造爆炸物案","非法买卖爆炸物案","非法运输爆炸物案","非法邮寄爆炸物案","非法储存爆炸物案","非法买卖核材料案","非法运输核材料案","企业违规制造枪支案","企业销售制造枪支案","非法持有枪支弹药案","非法私藏枪弹案","非法出借枪弹案","非法出租枪弹案","丢失枪支不报案","非法携带枪支弹药危及公共安全案","非法携带管制刀具危及公共安全案","非法携带危险品危及公共安全案","重大飞行事故案","铁路运营安全事故案","交通肇事案","重大劳动安全事故案","危险物品肇事案","工程重大安全事故案","教育设施重大安全事故案","消防责任事故案","抢劫枪支弹药案","抢劫国家机关枪支弹药案","抢劫军、警、民兵枪支弹药案","抢劫爆炸物案","抢劫国家机关爆炸物案","抢劫军、警、民兵爆炸物案","盗窃枪支、弹药、爆炸物案","盗窃枪支、弹药案","盗窃国家机关枪支、弹药案","盗窃军、警、民兵枪支、弹药案","盗窃爆炸物案","盗窃国家机关爆炸物案","盗窃军、警、民兵爆炸物案","抢夺枪支、弹药、爆炸物案","抢夺枪支、弹药案","抢夺国家机关枪支弹药案","抢夺军、警、民兵枪支弹药案","抢夺爆炸物案","抢夺国家机关爆炸物案","抢夺军、警、民兵爆炸物案","生产、销售假冒伪劣商品（产品）案","走私案","妨害对公司、企业的管理秩序案","破坏金融管理秩序案","金融诈骗案","危害税收征管案","侵犯知识产权案","扰乱市场秩序案","其他破坏社会主义市场经济秩序案","生产、销售伪劣产品案","生产、销售假药案","生产、销售劣药案","生产、销售伪劣兽药案","生产、销售伪劣农药案","生产、销售伪劣化肥案","生产、销售伪劣种子案","生产、销售不符合卫生标准食品案","生产、销售有毒、有害食品案","生产、销售不符合标准的医用器材案","生产、销售不符合安全标准的产品案","生产、销售不符合卫生标准化妆品案","走私武器、弹药案","走私核材料案","走私文物案","走私假币案","走私贵重金属案","走私黄金案","走私白银案","走私珍贵动物及其制品案","走私珍稀植物及其制品案","走私淫秽物品案","走私一般货物物品案","走私固体废料案","虚报注册资本案","虚假出资案","抽逃出资案","欺诈发行股票案","欺诈发行债券案","提供虚假财会报告案","妨害清算案","公司、企业人员受贿案","对公司、企业人员行贿案","非法经营同类营业案","为亲友非法牟利案","签定、履行合同失职被骗案","徇私舞弊造成破产案","徇私舞弊造成亏损案","徇私舞弊低价折股国有资产案","徇私舞弊低价出售国有资产案","伪造货币案","出售假币案","购买假币案","运输假币案","金融工作人员购买假币以假币换取货币案","持有、使用假币案","变造货币案","伪造、变造国库券案","伪造、变造国家其他有价证券案","伪造、变造股票案","伪造、变造公司企业债券案","伪造、变造金融票证案","伪造、变造、转让金融机构经营许可证案","擅自设立金融机构案","转让金融机构许可证案","高利转贷案","非法吸收公众存款案","擅自发行股票、公司企业债券案","内幕交易、泄露内幕信息案","编造并传播证券交易虚假信息案","诱骗投资者买卖证券案","操纵证券交易价格案","保险公司人员虚假理赔案","金融机构人员受贿案","违法发放贷款案","违法向关系人发放贷款案","用帐外客户资金非法拆借、发放贷款案","非法出具金融票证案","对违法票据承兑付款、保证案","逃汇案","套汇案","骗汇案","洗钱案","非法买卖外汇案","集资诈骗案","贷款诈骗案","票据诈骗案","金融凭证诈骗案","信用证诈骗案","信用卡诈骗案","有价证券诈骗案","保险诈骗案","偷税案","抗税案","逃避追缴欠税案","骗取出口退税案","骗取国家出口免征税款案","虚开增值税发票用于骗取出口退税、抵扣税款发票案","伪造增值税专用发票案","出售伪造的增值税专用发票案","非法出售增值税专用发票案","非法购买增值税专用发票案","购买伪造的增值税专用发票案","非法制造用于骗取出口退税、抵扣税款发票案","出售非法制造的用于骗取出口退税、抵扣税款发票案","非法制造发票案","出售非法制造的发票案","非法出售用于骗取出口退税、抵扣税款发票案","非法出售发票案","盗窃增值税专用发票案","盗窃退税、抵扣税款专用发票案","假冒注册商标案","销售假冒注册商标的商品案","非法制造的注册商标标识案","非法出版物案","销售非法制造的注册商标标识案","假冒专利案","侵犯著作权案","销售侵权复制品案","侵犯商业秘密案","损害商业信誉案","损害商品声誉案","虚假广告案","串通投标案","合同诈骗案","非法经营案","强迫交易案","伪造车票案","伪造船票案","伪造邮票案","伪造其他有价票证案","倒卖伪造车票案","倒卖伪造船票案","倒卖伪造邮票案","倒卖伪造其他有价票证案","倒卖车票案","倒卖船票案","非法转让土地使用权案","非法倒卖土地使用权案","中介组织人员提供虚假证明文件案","中介组织人员出具证明文件重大失实案","逃避商检案","侵犯人身权利案","侵犯民主权利案","破坏民族平等、宗教信仰案","妨害婚姻家庭权利案","其他侵犯公民人身权利、民主权利案","故意杀人案","过失致人死亡案","故意伤害案","过失致人重伤案","强奸案","奸淫幼女案","强制猥亵、侮辱妇女案","猥亵儿童案","非法拘禁案","绑架案","偷盗婴幼儿勒索案","拐卖妇女、儿童案","收买被拐卖的妇女、儿童案","聚众阻碍解救被收买的妇女、儿童案","暴力阻碍解救被收买的妇女、儿童案","强迫职工劳动案","非法搜查案","非法侵入住宅案","诬告陷害罪","侮辱案","诽谤案","刑讯逼供案","暴力取证案","虐待被监管人员案","侵犯通讯自由案","私拆邮件案","隐匿邮件电报案","毁弃邮件电报案","报复陷害案","打击报复会计人员案","打击报复统计人员案","破坏选举案","煽动民族仇恨、民族歧视案","出版歧视、侮辱少数民族作品案","非法剥夺公民宗教信仰自由案","侵犯少数民族风俗习惯案","暴力干涉婚姻自由案","重婚案","破坏军婚案","虐待案","遗弃案","拐骗儿童案","抢劫案","盗窃案","诈骗案","抢夺案","侵占案","职务侵占案","挪用特定款物案","敲诈勒索案","故意毁坏财物案","破坏生产经营案","聚众哄抢案","入户抢劫案","拦路抢劫案","在公共交通工具上抢劫案","抢劫银行或其他金融机构案","抢劫珠宝店案","抢劫提(送)款员案","抢劫运钞车案","抢劫出租汽车案","抢劫军用物资案","抢劫抢险、救灾、救济物资案","抢劫牲畜案","抢劫精神药物和麻醉药品案","冒充军警持枪抢劫案","持枪抢劫案","入室盗窃案","盗窃精神药物和麻醉药品案","盗窃易制毒化学品案","盗窃金融机构案","盗窃运输物资案","盗窃铁路器材案","盗窃珍贵文物案","盗窃电脑芯片案","盗窃货物案","盗窃旅财案","盗窃路财案","盗窃汽车案","盗窃摩托车案","盗窃自行车案","盗窃保险柜案","盗用他人通讯设施案","盗接通信线路案","盗窃牲畜案","扒窃案","挪用资金案","挪用公款案","挪用救灾、抢险、防汛款物案","挪用优抚款物案","挪用扶贫,移民救济款物案","扰乱公共秩序案","妨害司法案","妨害国(边)境管理案","妨害文物管理案","危害公共卫生案","破坏环境资源保护案","走私贩卖、运输、制造毒品案","组织、强迫、引诱、容留、介绍卖淫案","制作、复制、出版、贩卖、传播淫秽物品牟利案","其他妨害社会管理秩序案","阻碍执行职务案","阻碍人大代表执行职务案","阻碍红十字会依法履行职责案","阻碍安全机关、公安机关执行职务案","煽动暴力抗拒法律实施案","招摇撞骗案","冒充国家工作人员招摇撞骗案","冒充警察招摇撞骗案","伪造、变造公文证件印章案","买卖公文、证件、印章案","盗窃、抢夺公文证件印章案","毁灭公文、证件、印章案","伪造、变造居民身份证案","非法生产警服、警用标志、警械案","非法买卖警服、警用标志、警械案","非法获取国家机密案","非法持有国家绝密、机密文件、资料、物品案","非法生产、销售间谍专用器材案","非法使用窃听器材案","非法使用窃照器材案","非法侵入计算机信息系统案","破坏计算机信息系统案","破坏计算机信息系统数据和应用程序案","故意制作传播计算机破坏性程序案","利用计算机金融诈骗犯罪案","利用计算机盗窃案","利用计算机贪污案","利用计算机窃取国家机密案","利用计算机实施其他犯罪案","扰乱无线电通讯管理秩序案","聚众扰乱社会秩序案","聚众冲击国家机关案","聚众扰乱公共场所秩序案","聚众扰乱交通秩序案","聚众斗殴案","寻衅滋事案","传授犯罪方法案","组织、领导黑社会性质组织案","参加黑社会性质组织案","入境发展黑社会组织案","包庇、纵容黑社会性质组织案","非法集会、游行、示威案","非法携带武器参加集会、游行、示威案","非法携带管制刀具参加集会、游行、示威案","非法携带爆炸物参加集会、游行、示威案","破坏集会、示威、游行案","侮辱国旗、国徽案","组织和利用会道门、邪教组织或者利用迷信破坏法律实施案","组织和利用会道门破坏法律实施案","组织和利用邪教组织破坏法律实施案","组织和利用迷信破坏法律实施案","组织和利用会道门、邪教组织或者利用迷信致人死亡案","组织和利用会道门致人死亡案","组织和利用邪教组织致人死亡案","组织和利用迷信致人死亡案","组织和利用会道门、邪教组织或者利用迷信奸淫妇女或诈骗钱财案","组织和利用会道门、邪教组织或者利用迷信奸淫妇女案","组织和利用会道门奸淫妇女案","组织和利用邪教组织奸淫妇女案","组织和利用迷信奸淫妇女案","组织和利用会道门、邪教组织或者利用迷信诈骗钱财案","组织和利用会道门诈骗钱财案","组织和利用邪教组织诈骗钱财案","组织和利用迷信诈骗钱财案","聚众淫乱案","引诱未成年人聚众淫乱案","盗窃、侮辱尸体案","赌博案","故意延误投递邮件案","伪证案","辩护人、诉讼代理人毁灭、伪造证据案","帮助毁灭、伪造证据案","司法人员毁灭、伪造证据案","妨害作证案","打击报复证人案","扰乱法庭秩序案","窝藏、包庇案","拒绝提供间谍犯罪证据案","窝藏、转移、收购、销售赃物案","拒不执行判决、裁定案","非法处置查封、扣押、冻结财产案","破坏监管秩序案","脱逃案","劫夺被解押人员案","组织越狱案","暴动越狱案","聚众持械劫狱案","偷越国(边)境案","组织他人偷越国(边)境案","运送他人偷越国(边)境案","骗取出境证件案","提供伪造、变造的出入境证件案","出售出入境证件案","破坏界碑、界桩案","破坏永久性测量标志案","故意毁坏文物案","过失毁坏文物案","非法向外国人出售珍贵文物案","倒卖文物案","非法出售文物藏品案","非法赠送文物藏品案","故意损毁名胜古迹案","盗掘古文化遗址案","盗掘古墓葬案","盗掘古人类化石、古脊椎动物化石案","抢夺国有档案案","窃取国有档案案","擅自出卖国家档案案","擅自转让国家档案案","妨害传染病防治案","传染病菌种、毒种扩散案","妨害国境卫生检疫案","非法组织卖血案","强迫卖血案","非法采集、供应血液案","非法制作、供应血液制品案","采集、供应血液事故案","制作、供应血液制品事故案","医疗事故案","非法行医案","非法进行节育手术案","逃避动植物检疫案","重大环境污染事故案","非法处置进口固体废物案","擅自进口固体废物案","非法捕猎、杀害珍贵、濒危野生动物案","非法收购珍贵、濒危野生动物及其制品案","非法运输珍贵、濒危野生动物及其制品案","非法出售珍贵、濒危野生动物及其制品案","非法采伐、毁坏珍贵树木案","盗伐林木案","滥伐林木案","非法收购盗伐、滥伐的林木案","非法捕捞水产品案","非法狩猎案","非法占用耕地案","非法采矿案","破坏性采矿案","走私毒品案","贩卖毒品案","运输毒品案","制造毒品案","非法持有毒品案","包庇毒品犯罪分子案","窝藏、转移、隐瞒毒品、毒赃案","走私制毒物品案","非法买卖制毒物品案","非法种植毒品原植物案","非法买卖毒品原植物种苗案","非法运输毒品原植物种苗案","非法携带毒品原植物种苗案","非法持有毒品原植物种苗案","非法运输携带制毒毒品进出境案","引诱、教唆、强迫他人吸毒案","引诱他人吸毒案","教唆他人吸毒案","欺骗他人吸毒案","强迫他人吸毒案","容留他人吸毒案","非法提供麻醉药品案","非法提供精神药品案","组织卖淫案","强迫卖淫案","协助组织卖淫案","引诱卖淫案","引诱幼女卖淫案","容留卖淫案","介绍卖淫案","传播性病案","嫖宿幼女案","制作淫秽物品案","复制淫秽物品案","出版淫秽物品案","贩卖淫秽物品案","传播淫秽物品案","提供书号出版淫秽书刊案","组织播放淫秽音像制品案","组织淫秽表演案","阻碍军人执行职务案","阻碍军事行动案","破坏武器装备案","破坏军事设施案","破坏军事通信案","故意提供不合格武器装备案","故意提供不合格军事设施案","过失提供不合格武器装备案","过失提供不合格军事设施案","聚众冲击军事禁区案","聚众扰乱军事管理区秩序案","冒充军人招摇撞骗案","煽动逃离部队案","雇佣逃离部队军人案","接送不合格兵员案","伪造、变造、买卖部队公文、证件、印章案","盗窃部队公文、证件、印章案","抢夺部队公文、证件、印章案","非法生产、买卖军用标志案","战时拒绝、逃避征召案","战时拒绝、逃避军事训练案","战时拒绝、逃避服役案","战时故意提供虚假情报案","战时造谣惑众扰乱军心案","战时窝藏逃离部队军人案","战时拒绝军事订货案","战时延误军事订货案","战时拒绝军事征用案","其他危害国防利益案"};
    
    
    private static CaseTypeGenerator instance = new CaseTypeGenerator();
    
    private CaseTypeGenerator() {
    }
    
    public static GenericGenerator getInstance() {
        return instance;
    }
    
    
    @Override
    public String generate() {
        return FIRST_NAMES[getRandomInstance().nextInt(FIRST_NAMES.length)];
    }
    
}

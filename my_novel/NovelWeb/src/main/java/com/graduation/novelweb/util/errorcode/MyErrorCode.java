package com.graduation.novelweb.util.errorcode;

/**
 * @author tanlin
 * @date 2020/4/24
 */
@SystemCode
public class MyErrorCode {

    /**
     * 编码接口.
     */
    public interface Code {

        /**
         * 获取Code
         * @return
         */
        public String getCode();

        /**
         * 获取消息
         * @return
         */
        public String getMessage();

    }

    /**
     * 参数化编码.
     * <p>
     * 本类为{@link Code}的装饰器,用于解决消息中需要进行参数化配置的需求.
     * <p>
     * 参数的配置参考{@link String#format(String, Object...) }.
     */
    public static class ParamedCode implements Code {

        /**
         * 源对象.
         */
        private Code src;
        /**
         * 参数.
         */
        private Object[] params;

        public ParamedCode(Code src, Object... params) {
            this.src = src;
            this.params = params;
        }

        @Override
        public String getCode() {
            return src.getCode();
        }

        @Override
        public String getMessage() {
            return String.format(src.getMessage(), params);
        }
    }

    public enum CommonCode implements Code {
        IFUND_CODE_00000000("00000000", "未知系统错误"),
        IFUND_CODE_10000000("10000000", "非法请求参数"),
        IFUND_CODE_10000001("10000001", "分页检索失败"),
        IFUND_CODE_10000002("10000002", "系统错误"),
        IFUND_CODE_10000010("10000010", "JSON字符串转化异常"),
        IFUND_CODE_10000011("10000011", "数据库访问错误"),
        IFUND_CODE_10000012("10000012", "ID长度过长"),
        IFUND_CODE_10000013("10000013", "没有设置department名称信息");
        public final String code;
        public final String message;

        /**
         * 系统级错误码
         *
         * @param code
         * @param message
         */
        CommonCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

        /**
         * 获取系统级错误code
         *
         * @return code
         */
        public String getCode() {
            return code;
        }

        /**
         * 获取系统级错误消息
         *
         * @return message
         */
        public String getMessage() {
            return message;
        }
    }

    public enum ResourceCode implements Code {
        //文件
        /**
         * 文件不存在
         */
        IFUND_CODE_31200001("31100001", "文件不存在"),
        /**
         * 文件为空
         */
        IFUND_CODE_31200002("31100002", "文件为空"),
        /**
         * uniqueId不能为空
         */
        IFUND_CODE_31200003("31100003", "uniqueId不能为空"),
        /**
         * 上传文件失败
         */
        IFUND_CODE_31200004("31100004", "上传文件失败"),
        /**
         * 保存文件信息失败
         */
        IFUND_CODE_31200005("31100005", "保存文件信息失败"),
        /**
         * 文件不能重复绑定业务id.
         */
        IFUND_CODE_FILE_BIND_OTHER_ACTION_ID("31100006", "文件已经绑定过业务id,不支持重新绑定其它的业务。"),
        /**
         * 文件获取异常.
         */
        IFUND_CODE_31200006("31100006", "文件获取异常"),
        IFUND_CODE_10000000("10000000", "非法请求参数"),
        IFUND_CODE_FILE_AUTO_CLEAN_ACTION_ID_ERROR("31100007", "文件已绑定业务id，不可被删除"),
        IFUND_CODE_FILE_AUTO_CLEAN_CHAIN_ERROR("31100008", "文件上链，不可被删除"),
        NO_FILE_ATTR("31100100", "文件类型没配置对应的二级属性."),
        //基金管理人301
        IFUND_CODE_30100000("30100000", "新增基金管理人基本信息失败"),
        IFUND_CODE_30100001("30100001", "基金管理人名称不能为空"),
        IFUND_CODE_30100002("30100002", "基金管理人注册资本不能为空"),
        IFUND_CODE_30100003("30100003", "基金管理人注册地址不能为空"),
        IFUND_CODE_30100004("30100004", "基金管理人法人代表不能为空"),
        IFUND_CODE_30100005("30100005", "组织形式校验失败"),
        IFUND_CODE_30100006("30100006", "基金管理人注册时间不能为空"),
        IFUND_CODE_30100007("30100007", "基金管理人统一社会信用号不能为空"),
        IFUND_CODE_30100008("30100008", "基金管理人企业性质不能为空"),
        IFUND_CODE_30100009("30100009", "基金管理人是否合作过不能为空"),
        IFUND_CODE_30100010("30100010", "基金管理人登记备案函不能为空"),
        IFUND_CODE_30100011("30100011", "该名称的基金管理人已存在"),
        IFUND_CODE_30100012("30100012", "输入信息内容过长"),
        IFUND_CODE_30100013("30100013", "备注不能为空"),
        IFUND_CODE_30100014("30100014", "新增基金管理人基本信息失败，状态码不能为空"),
        IFUND_CODE_30100015("30100015", "状态码校验失败"),
        IFUND_CODE_30100100("30100100", "查询基金管理人基本信息失败"),
        IFUND_CODE_30100101("30100101", "注册时间不完整"),
        IFUND_CODE_30100102("30100102", "查询基金管理人基本信息失败,登记时间不完整"),
        IFUND_CODE_30100301("30100301", "编辑基金管理人基本信息失败"),
        IFUND_CODE_30100302("30100302", "基金管理人id对应的管理人信息不存在"),
        IFUND_CODE_30100303("30100303", "基金管理人id不能为空"),
        IFUND_CODE_30100400("30100400", "新增股东失败"),
        IFUND_CODE_30100500("30100500", "查询股东失败"),
        IFUND_CODE_30100600("30100600", "编辑股东失败"),
        IFUND_CODE_30100601("30100601", "股东id不能为空"),
        IFUND_CODE_30100602("30100602", "股东id对应的股东不存在"),
        IFUND_CODE_30100603("30100603", "dto转为example失败"),
        IFUND_CODE_30100604("30100604", "最小不能小于0"),
        IFUND_CODE_30100700("30100700", "查询基金管理人-核心成员信息失败"),
        IFUND_CODE_30100701("30100701", "基金管理人-核心成员id不能为空"),
        IFUND_CODE_30100750("30100750", "新增基金管理人-核心成员信息失败"),
        IFUND_CODE_30100800("30100800", "编辑基金管理人-核心成员信息失败"),
        IFUND_CODE_30100901("30100901", "id对应的基金管理人-核心成员不存在"),
        IFUND_CODE_30100902("30100902", "基金处于投资中，操作失败"),
        IFUND_CODE_30100903("30100903", "基金处于退出中，操作失败"),
        IFUND_CODE_30100904("30100904", "基金管理人统一社会信用号/注册号唯一性校验失败，操作失败"),
        IFUND_FUNDMANAGER_MAINTAINERID_NOTBLANK("30100905", "基金管理人维护人id不能为空"),
        //基金募集
        IFUND_CODE_30101000("30101000", "查询基金失败"),
        IFUND_CODE_30101001("30101001", "基金的基金类型校验失败"),
        IFUND_CODE_30101002("30101002", "基金不存在"),
        IFUND_CODE_30101003("30101003", "基金已存在"),
        IFUND_CODE_30101004("30101004", "基金id不能为空"),
        IFUND_CODE_30101005("30101005", "编辑基金失败"),
        IFUND_CODE_30101006("30101006", "基金阶段校验失败"),
        IFUND_CODE_30101007("30101007", "基金附件不能为空"),
        IFUND_CODE_30101008("30101008", "基金币种不能为空"),
        IFUND_CODE_30101009("30101009", "基金名称不能为空"),
        IFUND_CODE_30101010("30101010", "注册时间不能为空"),
        IFUND_CODE_30101011("30101011", "认缴出资不能为空"),
        IFUND_CODE_30101012("30101012", "实缴出资不能为空"),
        IFUND_CODE_30101013("30101013", "续存期限不能为空"),
        IFUND_CODE_30101014("30101014", "已投金额不能为空"),
        IFUND_CODE_30101015("30101015", "组织形式不能为空"),
        IFUND_CODE_30101016("30101016", "基金类型不能为空"),
        IFUND_CODE_30101017("30101017", "基金负责人不能为空"),
        IFUND_CODE_30101018("30101018", "基金管理人不能为空"),
        IFUND_CODE_30101019("30101019", "中基协备案号不能为空"),
        IFUND_CODE_30101020("30101020", "中基协备案时间不能为空"),
        IFUND_FUND_ORGYPTE_PARTNERSHIP_TO_LIABILITY_ERROR("30101021",
                "普通合伙人页面存在信息，请先删除后切换"),
        IFUND_FUND_ORGYPTE_LIABILITY_TO_PARTNERSHIP_ERROR("30101022",
                "董事会/监事会页面存在信息，请先删除后切换"),
        //分页
        IFUND_CODE_30900001("30900001", "分页参数异常"),
        //投资人
        IFUND_CODE_INVESTOR_FIELD_ILLEGAL("31000100", "投资人信息不合法.请确认必填字段与字段格式."),
        IFUND_CODE_INVESTOR_SAVE_FAILED("31000101", "投资人信息保存失败."),
        IFUND_CODE_INVESTOR_CARD_NO_UNIQUE("31000102", "投资人的证件号码(个人)与统一社会信用代码(机构)必须唯一."),
        IFUND_CODE_INVESTOR_CANNOT_FIND("31000201", "找不到指定的投资人信息."),
        IFUND_CODE_INVESTOR_VISIT_RECORD_THEME("31000202", "投资人拜访主题不能为空"),
        IFUND_CODE_INVESTOR_VISIT_RECORD_TIME("31000203", "投资人拜访时间不能为空"),
        IFUND_CODE_INVESTOR_VISIT_RECORD_NOT_NULL("31000204", "投资人拜访记录不存在，不可编辑"),
        //基金文件
        IFUND_CODE_32000001("32000001", "插入基金文件失败"),
        IFUND_CODE_32000002("32000002", "文件类型不合法"),//基金为空
        IFUND_CODE_32000003("32000003", "文件名不合法"),
        IFUND_CODE_32000004("32000004", "文件类型不合法"),
        IFUND_CODE_32000005("32000005", "上传者不能为空"),
        IFUND_CODE_32000006("32000006", "上传者名称过长"),
        IFUND_CODE_32000007("32000007", "基金id对应基金不存在"),
        IFUND_CODE_32000008("32000008", "上传附件失败，参数错误"),
        IFUND_CODE_32000009("32000009", "ID对应基金文件组不存在"),
        IFUND_CODE_32000010("32000010", "更新基金文件失败，ID对应基金文件组不存在"),
        IFUND_CODE_32000011("32000025", "删除基金文件失败，指定id文件不存在"),
        IFUND_CODE_32000023("32000023", "附件列表不能为空"),
        IFUND_CODE_32000024("32000024", "基金id不能为空"),
        IFUND_CODE_32000025("32000025", "id必须为数字"),
        IFUND_CODE_32000026("32000026", "id不能为空"),
        IFUND_CODE_32000027("32000027", "id最长为17位"),
        IFUND_CODE_32000028("32000028", "上传认购协议前请引入基金投资人"),
        IFUND_CODE_STAGETYPE_FUNDRAISING("32000034", "基金阶段不为募资中"),
        IFUND_CODE_STAGETYPE_NULL("32000036", "基金阶段为空"),
        //基金投资人
        IFUND_CODE_IMPORT_INVESTOR_FAILED("32000030", "基金引入投资人失败."),
        IFUND_CODE_SEARCH_FUND_INVESTOR_NEED_FUND_ID("32000031", "未指定基金id的情况下,无法查询基金投资人信息."),
        IFUND_CODE_FUND_INVESTOR_SAVE_FAILED("32000032", "基金投资人保存失败."),
        IFUND_CODE_FUND_INVESTOR_ADD_REPEATEDLY("32000033", "基金中同一位投资人,不能被重复添加."),
        //证券信息
        IFUND_CODE_32000101("32000101", "插入证券信息失败，证券公司名称不能为空"),
        IFUND_CODE_32000102("32000102", "插入证券信息失败，一账通号码不能为空"),
        IFUND_CODE_32000103("32000103", "插入证券信息失败，资金账号不能为空"),
        IFUND_CODE_32000104("32000104", "此id对应证券信息不存在"),
        IFUND_CODE_32000114("32000114", "证券id不能为空"),
        IFUND_CODE_32000115("32000115", "删除证券信息失败，指定证券信息不存在"),
        //银行税务信息
        IFUND_CODE_32000201("32000201", "账户名称不能为空"),
        IFUND_CODE_32000202("32000202", "开户行不能为空"),
        IFUND_CODE_32000203("32000203", "账号必须为数字"),
        IFUND_CODE_32000204("32000204", "此id对应银行税务信息不存在"),
        IFUND_CODE_32000205("32000205", "id必须为数字"),
        //投前
        PROJECT_CODE_41000201("41000201", "项目id不能为空"),
        PROJECT_CODE_41000202("41000202", "会议id不能为空"),
        PROJECT_CODE_41000203("41000203", "此id对应项目不存在"),
        PROJECT_CODE_41000204("41000204", "项目未提交，不可编辑"),
        PROJECT_CODE_41000205("41000205", "项目已签约未出资，不可编辑"),
        PROJECT_CODE_41000206("41000206", "项目已否决，不可编辑"),
        PROJECT_CODE_41000207("41000207", "操作失败，必须上传文件"),
        PROJECT_CODE_41000208("41000208", "时间格式错误"),
        PROJECT_CODE_41000209("41000209", "项目已出资，不可编辑"),
        //会议
        PROJECT_CODE_41000211("41000211", "会议类型错误"),
        PROJECT_CODE_41000212("41000212", "会议状态错误"),
        PROJECT_CODE_41000213("41000213", "会议不存在"),
        PROJECT_CODE_41000214("41000214", "创建外部评审会必须提交内部评审会"),
        PROJECT_CODE_41000215("41000215", "提交失败，对应会议不存在"),
        PROJECT_CODE_41000216("41000216", "更新失败，对应会议不存在"),
        PROJECT_CODE_41000217("41000216", "保存失败，会议已经提交"),
        PROJECT_CODE_41000218("41000218", "会议已存在、请勿重复添加"),
        //项目尽调
        PROJECT_CODE_41000301("41000301", "尽调报告不存在"),
        PROJECT_CODE_41000302("41000302", "尽调报告id不能为空"),
        PROJECT_CODE_41000303("41000303", "该类型尽调报告已存在"),
        PROJECT_CODE_41000304("41000304", "尽调报告类型错误"),
        //项目退出
        PROJECT_CODE_51000101("51000101", "项目id不能为空"),
        PROJECT_CODE_51000102("51000102", "项目状态必须为HAS_PAID或EXITING,阶段必须为AFTER或EXIT"),
        PROJECT_CODE_51000103("51000103", "您只能选择一种退出方式"),
        PROJECT_CODE_51000104("51000104", "退出方案id不能为空"),
        PROJECT_CODE_51000105("51000105", "项目状态不能为空"),
        PROJECT_CODE_51000106("51000106", "找不到对应退出方案"),
        PROJECT_CODE_51000107("51000107", "方案类型不能为空"),
        PROJECT_CODE_51000108("51000108", "退出详情不能为空"),
        PROJECT_CODE_51000109("51000109", "时间区间不能为空"),
        PROJECT_CODE_51000110("51000110", "价格区间不能为空"),
        PROJECT_CODE_51000111("51000111", "开始时间不能大于结束时间"),
        PROJECT_CODE_51000112("51000112", "减持后不能大于减持前"),
        PROJECT_CODE_51000113("51000113", "钱数不能小于0"),
        PROJECT_CODE_EDIT_TYPE_FAIL("51000114", "项目处于退出中，不可编辑退出方式"),
        PROJECT_CODE_COMPLETE_STAGE_STATUS_ERROR("51000115",
                "项目完成退出时，项目状态必须为EXITING，项目阶段必须为EXIT"),
        PROJECT_CODE_COMPLETE_EXIT_AGREEMENT_ISNULL("51000116",
                "项目完成退出时，无对应的退出协议"),
        PROJECT_CODE_COMPLETE_EXIT_AGREEMENT_STATUS_ERROR("51000117",
                "项目完成退出时，对应的退出协议的状态未提交"),
        //基金费用
        PROJECT_CODE_51001001("51001001", "基金费用明细id不能为空"),
        PROJECT_CODE_51001002("51001002", "基金id不能为空"),
        PROJECT_CODE_51000003("51001003", "更新失败，记录不存在"),
        PROJECT_CODE_51000004("51001004", "时间格式错误"),
        // 行业研究
        RESEARCH_CODE_61000001("61001001", "行业研究标题不能为空"),
        RESEARCH_CODE_61000002("61001002", "行业研究作者不能为空"),
        RESEARCH_CODE_61000003("61001003", "行业研究是否公开不能为空"),
        RESEARCH_CODE_61000004("61001004", "行业研究id不能为空"),
        RESEARCH_CODE_61000005("61001005", "根据id查找的信息不存在"),
        //日程管理
        AGENDAMANAGE_CODE_ORGANIZATIONID_NOTBLANK("62001001", "用户部门id不能为空"),
        AGENDAMANAGE_CODE_USERID_NOTBLANK("62001002", "根据部门id查询到的用户id不能为空"),
        AGENDAMANAGE_CODE_AGENDAID_NOTBLANK("62001003", "日程id不能为空"),
        //我的日程
        MY_AGENDA_NOTAGENDA("74000001", "无提醒"),
        MY_AGENDA_AGENDA_NOTEXIST("74000002", "日程不存在"),
        MY_AGENDA_NOTCREATER_ERROR("74000003", "非创建人不能编辑"),
        MY_AGENDA_CANCEL_NOTCREATER_ERROR("74000004", "取消失败，非创建人不能取消"),
        MY_AGENDA_DELETE_NOTCREATER_ERROR("74000005", "删除失败，非创建人不能删除"),
        MY_AGENDA_DELETE_NOTCANCEL_ERROR("74000006", "删除失败，该日程未取消"),
        MY_AGENDA_ALERT_NOT_ERROR("74000007", "日程提醒时间，添加失败"),
        MY_AGENDA_CREATE_FAILED("74000008", "创建日程失败。"),
        MY_AGENDA_ID_NOTBLAN("74000009","日程id不能为空"),
        AGENDA_BEGINTIME_NOTBLAN("74000010","日程开始时间不能为空"),
        AGENDA_ENDTIME_NOTBLAN("74000011","日程结束时间不能为空"),
        AGENDA_BEGINTIME_LESSTHAN_ENDTIME("74000012","日程开始时间需要小于结束时间"),
        //财务报表
        FINANCIAL_STATEMENTS_YEAR_ERROR("52000001","财务报表,年份不能为空"),
        FINANCIAL_STATEMENTS_RANGE_ERROR("52000002","财务报表,月或季度不能为空"),
        FINANCIAL_STATEMENTS_TYPE_ERROR("52000003","财务报表,统计类型异常"),
        FINANCIAL_STATEMENTS_PROJECT_STAGE_ERROR("52000004",
                "财务报表,项目所在阶段只能为投后或项目退出（项目退出时，不可为已退出）"),
        //查询员工信息
        EMPLOYEE_UPDATE_ERROR("53000001", "更新员工信息,用户id不能为空"),
        //投后项目-项目进程
        PROJECT_PROCESS_TITLE_NULL("41000401","项目进程，标题不能为空"),
        PROJECT_PROCESS_BIGIN_DATE_NULL("41000402","项目进程，发生时间不能为空"),
        PROJECT_PROCESS_TYPE_NULL("41000403","项目进程，类型不能为空"),
        PROJECT_PROCESS_PROJECT_STAGE_ERROR("41000404",
                "项目进程,项目所在阶段只能为投后或项目退出（项目退出时，不可为已退出）"),
        PROJECT_PROCESS_ID_NULL("41000405","项目进程，进程ID不能为空"),
        PROJECT_PROCESS_ID_QUERY_FAIL("41000406","项目进程，id对应的进程不存在"),
        // 公司公告
        NOTICE_RECEIVER_ERROR("54000001","公告参与人不能为空"),
        //公共文档文件夹
        DOC_FOLDER_NAME_NOTBLANK("54000001","文件夹名称不能为空"),
        DOC_FOLDER_NOTEXIST("54000002","文件夹不存在"),
        // 系统配置-公司名称
        SYSTEM_PROPERTY_NULL("54000003","平台不存在"),
        //部门管理
        DEPARTMENT_NAME_NOTBLANK("55000001","部门名称不能为空"),
        DEPARTMENT_NAME_ISEXIST("55000002","该名称的部门已存在"),
        DEPARTMENT_PARENT_NOTEXIST("55000003","父级部门不存在"),
        DEPARTMENT_NOTEXIST("55000004","该部门不存在"),
        DEPARTMENT_PARENT_NOTCHILDREN("55000005",
                "设置父级部门id错误，不能把子部门（包括该部门本身）当做父级部门"),
        DEPARTMENT_EMPLOYEE_ISEXIST("55000006","该部门存在员工，不可移除"),
        DEPARTMENT_CHILDREN_ISEXIST("55000007","该部门存在子部门，不可移除"),
        //普通合伙人
        GENERALPARTNER_NAME_NOTBLANK("56000001","普通合伙人名称（公司名称）不能为空"),
        GENERALPARTNER_NAME_ISEXIST("56000002","该名称的普通合伙人已存在"),
        GENERALPARTNER_NOTEXIST("56000003","该普通合伙人不存在"),
        GENERALPARTNER_INVESTED_FUND_DELETED_ERROR("56000005","该合伙人已关联其他基金，请解除关联后删除"),
        //公司型合伙人-股东信息
        GP_STOCKHOLDER_GPID_IS_NULL("56000101","股东对应的合伙人id不能为空"),
        GP_STOCKHOLDER_GPID_QUERY_FAIL("56000102","id对应的合伙人不存在"),
        GP_STOCKHOLDER_ID_IS_NULL("56000103","股东id不能为空"),
        GP_STOCKHOLDER_ID_QUERY_FAIL("56000104","id对应的股东信息不存在"),
        GP_STOCKHOLDER_GP_TYPE_ERROR("56000105","对应的合伙人类型不一致"),
        GP_STOCKHOLDER_GP_NAME_ISNULL("56000106","普通合伙人的股东名称不能为空"),
        //公司型合伙人-主要人员
        GP_KEY_PERSONNEL_ID_IS_NULL("56000201","主要人员id不能为空"),
        GP_KEY_PERSONNEL_ID_QUERY_FAIL("56000202","id对应的主要人员不存在"),
        GP_KEY_PERSONNEL_NAME_ISNULL("56000203","普通合伙人的主要人员名称不能为空"),
        //基金下的普通合伙人
        FUND_GP_ORG_FORM_TYPE_ERROR("32000301", "普通合伙人对应的基金的类型错误"),
        FUND_GP_ID_IS_NULL("32000302", "基金的普通合伙人的id不能为空"),
        FUND_GP_ID_QUERY_FAIL("32000303", "id对应的基金普通合伙人不存在"),
        FUND_GP_ADD_FAIL("32000304", "该基金下的该合伙人信息已存在，重复新增失败"),
        //有限合伙型合伙人-合伙人信息
        GP_PARTNER_GPID_NOTBLANK("56000301","合伙人对应的普通合伙人id不能为空"),
        GP_PARTNER_GP_TYPE_ERROR("56000302","合伙人对应的普通合伙人类型不一致"),
        GP_PARTNER_ID_NOTBLANK("56000303","合伙人的id不能为空"),
        GP_PARTNER_NOTEXIST("56000304","该id对应的合伙人信息不存在"),
        GP_PARTNER_NAME_NOTBLANK("56000305","有限合伙型合伙人下的合伙人的名称不能为空"),
        // 基金会成员
        FUND_MANAGEMENT_MEMBER_NOTEXIST("32000401","该基金会成员不存在"),
        FUND_MANAGEMENT_MEMBER_NAME_NOTBLANK("32000402","该基金会成员名称不能为空"),
        FUND_MANAGEMENT_MEMBER_ID_NOTBLANK("32000402","该基金会成员id不能为空"),
        FUND_MEMBER_ORG_FORM_TYPE_ERROR("32000301", "基金会成员对应的基金组织形式错误"),
        //普通合伙人相关文件
        GP_FILEGROUP_GPID_NOTBLANK("56000401","相关文件对应的普通合伙人id不能为空"),
        GP_FILEGROUP_ID_NOTBLANK("56000402","相关文件id不能为空"),
        GP_FILEGROUP_NOTEXIST("56000403","该id对应的相关文件信息不存在"),
        GP_FILEGROUP_NAME_NOTBLANK("56000404","相关文件的名称不能为空"),
        // 行业信息
        INDUSTRY_NOTEXIST("61002001","该行业信息不存在"),
        // 该基金下的项目
        FUND_NOTEXIT_PROJECT_ISEXIST("61003001","该基金下存在未退出的项目"),
        // 基金退出方案
        FUND_STATUS_ISERROR("61003002","基金状态只能为投资中"),
        FUND_STATUS_ISEXIT("61003003","该基金已退出"),
        FUND_EXITPLAN_ID_NOTBLANK("61003004","基金退出方案id不能为空"),
        FUND_EXITPLAN_ISEXIST("61003005","该基金的退出方案已存在"),
        FUND_EXITPLAN_ISNULL("61003006","基金退出方案不存在"),
        FUND_EXITPLAN_NOTSUBMITED("61003007","该基金退出方案未提交"),
        FUND_CLEARING_FOLDER_ID_NOTBLANK("61003008","基金清算注销文件夹id不能为空"),
        FUND_CLEARING_FOLDER_ISNULL("61003009","基金清算注销文件夹信息不存在"),
        FUND_CLEARING_FOLDER_NAME_NOTBLANK("61003010","清算注销文件夹名称不能为空"),
        // 基金完成退出 文件夹未上传文件归档
        FUND_EXIT_STAGETYPE_ERROR("56000501","基金完成退出时，基金阶段不为退出中"),
        FUND_EXIT_CLEARINGFOLDER_ISNULL("56000502","文件夹未上传文件归档"),
        FUND_EXIT_CLEARINGFOLDER_MISSING("56000503","基金清算缺少必要的4个文件夹"),
        // 基金重大事项
        FUND_MAJOREVENT_FUNDID_NOTBLANK("56000601","重大事项对应的基金id不能为空"),
        FUND_MAJOREVENT_NOTEXIST("56000602","该重大事项不存在"),
        FUND_MAJOREVENT_SUBJECT_NOTBLANK("56000603","重大事项的主题不能为空"),
        FUND_MAJOREVENT_DESCRIPTION_NOTBLANK("56000604","重大事项的描述不能为空"),
        FUND_MAJOREVENT_FUND_STAGE_ERROR("56000605","当前基金阶段不能为“已退出"),
        FUND_MAJOREVENT_ID_NOTBLANK("56000606","基金重大事项id不能为空"),
        FUND_MAJOREVENT_FUND_NOTEXIST("56000607","重大事项对应的基金不存在"),
        FUND_MAJOREVENT_TYPE_NOTBLANK("56000608","重大事项的类型不能为空"),
        ;
        public final String code;
        public final String message;

        ResourceCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    /**
     * 权限阶段错误码
     */
    public enum AuthCode implements Code {
        TOKEN_AUTH_SUCCEED("20000001", "鉴权通过"),
        TOKEN_AUTH_FAIL("20000002", "鉴权不通过"),
        TOKEN_ERROR("20000003", "Token不正确"),
        TOKEN_INVLID("20000004", "Token失效"),
        UNSUPPORT_METHOD("20000005", "不支持的请求方式"),
        ADDHEADER_ERROR("20000006", "设置请求头出错"),
        INTERFACE_AUTH_ERROR("20000007", "接口校验出错"),
        RBAC_AUTH_FAIL("20000008", "角色权限校验失败"),
        INTERFACE_NOT_EXIST("20000009", "接口不存在"),
        TOKEN_PARSE_ERROR("20000010", "Token解析失败");

        public final String code;
        public final String message;

        /**
         * 权限错误码
         *
         * @param code
         * @param message
         */
        AuthCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

        /**
         * 获取权限code
         *
         * @return code
         */
        public String getCode() {
            return code;
        }

        /**
         * 获取权限消息
         *
         * @return message
         */
        public String getMessage() {
            return message;
        }
    }

    /**
     * 用户相关错误码
     */
    public enum UserCode implements Code {

        USER_NOT_EXIST("100001","该用户对象不存在"),
        USER_NAME_NOTBLANK("100002","用户名称不能为空"),
        USER_NICKNAME_NOTBLANK("100003","用户昵称不能为空"),
        USER_PASSWORD_NOTBLANK("100004","用户密码不能为空"),
        ;

        public final String code;
        public final String message;

        /**
         * 用户相关错误码
         *
         * @param code
         * @param message
         */
        UserCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

        /**
         * 获取用户错误code
         *
         * @return code
         */
        public String getCode() {
            return code;
        }

        /**
         * 获取用户错误消息
         *
         * @return
         */
        public String getMessage() {
            return message;
        }
    }

}

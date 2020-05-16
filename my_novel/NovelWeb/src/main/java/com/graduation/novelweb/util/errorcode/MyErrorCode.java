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

    /**
     * 用户相关错误码
     */
    public enum UserCode implements Code {

        USER_NOT_EXIST("100001","该用户不存在"),
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


    /**
     * 用户相关错误码
     */
    public enum NovelCode implements Code {

        NOVEL_NOT_EXIST("100101","该小说对象不存在"),
        NOVEL_NAME_NOTBLANK("100102","小说名称不能为空"),
        NOVEL_AUTHOR_NOTBLANK("100103","小说作者不能为空"),
        NOVEL_PASSWORD_NOTBLANK("100104","用户密码不能为空"),
        ;

        public final String code;
        public final String message;

        /**
         * 用户相关错误码
         *
         * @param code
         * @param message
         */
        NovelCode(String code, String message) {
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

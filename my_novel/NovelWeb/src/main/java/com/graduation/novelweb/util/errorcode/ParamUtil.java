
package com.graduation.novelweb.util.errorcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.Collection;
import java.util.Objects;
import com.graduation.novelweb.util.errorcode.MyErrorCode.Code;
/**
 * 参数验证工具.
 *
 * @author tanlin
 */
public interface ParamUtil {

    /**
     * 消息头中的登录人id.
     */
    static final String HEADER_LOGIN_USER_ID = "x-userid";

    static final Logger LOG = LoggerFactory.getLogger(ParamUtil.class);


    /**
     * 检查对象不可为空。
     *
     * @param obj
     * @param code
     * @throws AppException
     */
    public static void checkNotNull(Object obj, Code code) throws AppException {
        checkNotNull(obj, code, null);
    }

    /**
     * 检查对象不可为空
     *
     * @param obj
     * @param code
     * @param message
     * @throws AppException
     */
    public static void checkNotNull(Object obj, Code code, String message) throws AppException {
        if (obj == null) {
            throw buildAppException(code, message);
        }
    }

    /**
     * 检查对象必须为空。
     *
     * @param obj
     * @param code
     * @throws AppException
     */
    public static void checkNull(Object obj, Code code) throws AppException {
        checkNull(obj, code, null);
    }

    /**
     * 检查对象必须为空.
     *
     * @param obj
     * @param code
     * @param message
     * @throws AppException
     */
    public static void checkNull(Object obj, Code code, String message) throws AppException {
        if (obj != null) {
            throw buildAppException(code, message);
        }
    }

    /**
     * 检查不能为空. 为空就抛出异常类。
     * @param obj
     * @param code
     * @throws AppException
     */
    public static void checkNotBlank(String obj, Code code) throws AppException {
        //当相同时抛出这个检查对象和错误码
        checkNotBlank(obj, code, null);
    }

    /**
     * 检查不能为空，为空就抛出异常
     * @param obj
     * @param code
     * @param message
     * @throws AppException
     */
    public static void checkNotBlank(String obj, Code code, String message) throws AppException {
        if (StringUtils.isBlank(obj)) {
            //当相同时抛出差错误码和错误消息
            throw buildAppException(code, message);
        }
    }

    /**
     * 检查对象必须为True.
     *
     * @param obj
     * @throws AppException 当obj为false或null时抛出。
     */
    public static void checkTrue(Boolean obj) throws AppException {
        checkTrue(obj, null);
    }

    /**
     * 检查对象必须为True.
     *
     * @param obj
     * @param code
     * @throws AppException 当obj为false或null时抛出。
     */
    public static void checkTrue(Boolean obj, Code code) throws AppException {
        checkTrue(obj, code, null);
    }

    /**
     * 检查对象必须为True.
     *
     * @param obj
     * @param code
     * @param message
     * @throws AppException 当obj为false或null时抛出。
     */
    public static void checkTrue(Boolean obj, Code code, String message) throws AppException {
        checkEquals(Boolean.TRUE, obj, code, message);
    }

    /**
     * 检查对象必须为False.
     *
     * @param obj
     * @throws AppException 当obj为true或null时抛出。
     */
    public static void checkFalse(Boolean obj) throws AppException {
        checkFalse(obj, null);
    }

    /**
     * 检查对象必须为False.
     *
     * @param obj
     * @param code
     * @throws AppException 当obj为true或null时抛出。
     */
    public static void checkFalse(Boolean obj, Code code) throws AppException {
        checkFalse(obj, code, null);
    }

    /**
     * 检查对象必须为False.
     *
     * @param obj
     * @param code
     * @param message
     * @throws AppException 当obj为true或null时抛出。
     */
    public static void checkFalse(Boolean obj, Code code, String message) throws AppException {
        checkEquals(Boolean.FALSE, obj, code, message);
    }
    /**
     * 检查是否相同. 不同就抛出异常类。
     * @param src
     * @param dest
     * @param code
     * @throws AppException
     */
    static void checkEquals(Object src, Object dest, Code code) throws AppException {
        //当两个对象不同时抛出两个比较对象和错误码
        checkEquals(src, dest, code, null);
    }

    /**
     * 检查是否相同。不同就抛出异常类。
     *
     * @param src
     * @param dest
     * @param code
     * @param message
     */
    static void checkEquals(Object src, Object dest, Code code, String message) throws AppException {
        if (!Objects.equals(src, dest)) {
            //当两个对象不同时抛出错误码和错误消息
            throw buildAppException(code, message);
        }
    }

    /**
     * 检查是否不同。相同就抛出异常类。
     * @param src
     * @param dest
     * @param code
     * @throws AppException
     */
    static void checkNotEquals(Object src, Object dest, Code code) throws AppException {
        //当比较结果相同时抛出两个对象和错误码
        checkNotEquals(src, dest, code, null);
    }

    /**
     * 检查是否不同。相同就抛出异常类。
     *
     * @param src
     * @param dest
     * @param code
     * @param message
     * @throws AppException
     */
    static void checkNotEquals(Object src, Object dest, Code code, String message) throws AppException {
        if (Objects.equals(src, dest)) {
            //当比较结果相同时抛出错误码和错误信息
            throw buildAppException(code, message);
        }
    }

    /**
     * 检查集合是否为空。不空就抛出异常类。
     *
     * @param src
     * @param code
     * @param message
     * @throws AppException
     */
    static void checkEmpty(Collection src, Code code, String message) throws AppException {
        if (!CollectionUtils.isEmpty(src)) {
            //当集合不为空时抛出错误码和信息
            throw buildAppException(code, message);
        }
    }

    /**
     * 检查集合是否为空.
     *
     * @param list
     * @param code
     * @throws AppException
     */
    public static void checkNotEmpty(Collection list, Code code) throws AppException {
        //当集合为空时抛出错误码和信息
        checkNotEmpty(list, code, null);
    }

    /**
     * 检查集合是否不为空。空就抛出异常类。
     * @param src
     * @param code
     * @param message
     * @throws AppException
     */
    static void checkNotEmpty(Collection src, Code code, String message) throws AppException {
        if (CollectionUtils.isEmpty(src)) {
            //当集合为空时抛出错误码和信息
            throw buildAppException(code, message);
        }
    }

    /**
     * 创建一个异常
     *
     * @param code
     * @return
     */
    static AppException buildAppException(Code code) {
        return buildAppException(code, null, null);
    }

    /**
     * 创建一个异常
     *
     * @param ex
     * @return
     */
    static AppException buildAppException(Throwable ex) {
        return buildAppException(null, null, ex);
    }

    /**
     * 创建一个异常
     *
     * @return
     */
    static AppException buildAppException() {
        return buildAppException(null, null, null);
    }

    /**
     * 创建一个异常
     *
     * @param code
     * @param message
     * @return
     * @since 1.1.5
     */
    static AppException buildAppException(Code code, String message) {
        return buildAppException(code, message, null);
    }

    /**
     * 创建一个异常
     *
     * @param code
     * @param ex 异常类.
     * @return
     * @since 1.1.7
     */
    static AppException buildAppException(Code code, Throwable ex) {
        return buildAppException(code, null, ex);
    }

    /**
     * 创建一个异常
     *
     * @param code
     * @param message
     * @param ex 异常类.
     * @return
     */
    static AppException buildAppException(Code code, String message, Throwable ex) {
        if (code == null) {
            //默认错误码.
            code = MyErrorCode.CommonCode.IFUND_CODE_00000000;
        }
        if (StringUtils.isBlank(message)) {
            //如果没有错误信息,使用Code中的默认错误信息.
            message = code.getMessage();
        }else{
            //打印额外的错误信息。
            LOG.info(message, ex);
        }
        return new AppException(code.getMessage(), message, ex);
    }
}

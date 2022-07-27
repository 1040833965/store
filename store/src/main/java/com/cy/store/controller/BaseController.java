package com.cy.store.controller;

import com.cy.store.contant.AddressContant;
import com.cy.store.controller.ex.*;
import com.cy.store.service.ex.*;
import com.cy.store.utils.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/18 21:37
 * @Description: 表示控制层的基类  左异常的捕获处理
 */
@SuppressWarnings({"all"})
public class BaseController {
    /**操作成功的状态码 */
    public static final int OK = 200;

    //请求处理方法，这个方法的返回值就是需要传递给前端的数据
    //自动将异常对象传递给此方法的参数列表上
    @ExceptionHandler({ServiceException.class,FileUploadException.class}) //统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>();
        if (e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名被占用");
        }else if (e instanceof UserNotFoundException){
            result.setState(4001);
            result.setMessage("未注册账号");
        }else if (e instanceof PasswordNotMatchException){
            result.setState(4002);
            result.setMessage("用户名对应密码错误");
        } else if (e instanceof AddressCountLimitException){
            result.setState(4003);
            result.setMessage("用户收货地址超出上限");
        }else if (e instanceof AddressNotFoundException){
            result.setState(4004);
            result.setMessage("用户的收货地址不存在异常");
        }else if (e instanceof AccessDeniedException){
            result.setState(4005);
            result.setMessage("收货地址非法访问");
        }else if (e instanceof DeleteException){
            result.setState(4006);
            result.setMessage("删除收货地址时产生未知异常");
        }else if (e instanceof ProductNotFoundException){
            result.setState(4007);
            result.setMessage("商品无法找到");
        }else if (e instanceof InsertExcetion){
            result.setState(5000);
            result.setMessage("注册时发生未知异常");
        }else if (e instanceof UpdateExcetion){
            result.setState(5001);
            result.setMessage("更新时发生未知异常");
        }else if (e instanceof FileSizeException){
            result.setState(6000);
            result.setMessage("上传文件尺寸不对");
        }else if (e instanceof FileEmptyException){
            result.setState(6001);
            result.setMessage("上传文件为空");
        }else if (e instanceof FileStateException){
            result.setState(6002);
            result.setMessage("文件状态不对");
        }else if (e instanceof FileTypeException){
            result.setState(6003);
            result.setMessage("文件类型不符合 ");
        }else if (e instanceof FileUploadIOException){
            result.setState(6004);
            result.setMessage("文件读写异常");
        }
        return result;
    }

    /**
     * 获取session对象中的uid
     * @param session session对象
     * @return 当前登入用户Uid
     *
     *
     * 在实现类中重新父类中的toString()方法，不是句柄信息输出
     */
    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 获取session对象中username
     * @param session session对象
     * @return 当前登入用户名
     */
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }

}

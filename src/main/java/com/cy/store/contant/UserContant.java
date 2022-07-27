package com.cy.store.contant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/18 18:52
 * @Description: User的一些常量
 */
@SuppressWarnings({"all"})
public class UserContant {
    /**1表示已删除*/
    public static final int IS_DELETE = 1;
    /**0表示未删除*/
    public static final int UN_DELETE = 0;

    /**表示为女生*/
    public static final Integer IS_WUMAN = 0;
    /**表示为男生*/
    public static final Integer IS_MAN = 1;

    /**设置上传文件的最大值*/
    public static final int AVATAR_MAX_SIZE = 10 * 10 * 1024;
    /**设置限制上传文件的类型*/
    public static final List<String> AVATAR_TYPE = new ArrayList<>();
    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }
}

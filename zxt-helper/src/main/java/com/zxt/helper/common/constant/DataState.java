package com.zxt.helper.common.constant;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */
public class DataState {
    //用户已删除
    public static final String USER_DELETE_TRUE = "0";
    //用户正常状态
    public static final String USER_DELETE_FALSE = "1";
    //用户已冻结
    public static final String USER_FREEZE_TRUE = "0";
    //用户未冻结
    public static final String USER_FREEZE_FALSE = "1";
    //菜单已删除
    public static final String MENU_DELETE_TRUE = "0";
    //菜单正常状态
    public static final String MENU_DELETE_FALSE = "1";

    //部门已删除
    public static final String DEPT_DELETE_TRUE = "0";
    //部门正常状态
    public static final String DEPT_DELETE_FALSE = "1";

    //    资源类型 1:文本、2：视频、3：音频、4：图片
    //文本资源
    public static final String DATA_SOURCE_TYPE_DOC = "1";
    //视频资源
    public static final String DATA_SOURCE_TYPE_VIDEO = "2";
    //音频资源
    public static final String DATA_SOURCE_TYPE_AUDIO = "3";
    //图片资源
    public static final String DATA_SOURCE_TYPE_IMG = "4";

    //    审核状态：1、第一次通过。 2、第二次通过。 3、第三次通过。 4、第四次通过。  audit
    public static final String MAPPER_AUDIT_THROUGH_ONE = "1";
    public static final String MAPPER_AUDIT_THROUGH_TWO = "2";
    public static final String MAPPER_AUDIT_THROUGH_THREE = "3";
    public static final String MAPPER_AUDIT_THROUGH_FOUR = "4";
    //   是否发布？ 0、不发布  1、发布
    public static final String MAPPER_NO_RELEASE = "0";
    public static final String MAPPER_RELEASE = "1";
    //  是否删除？ 0、删除 1、不删除
    public static final String MAPPER_DELETE_TRUE = "0";
    public static final String MAPPER_DELETE_FALSE = "1";

    //是否删除？0、删除 1、不删除（正常）
    public static final String DATA_SOURCE_DELETE_TRUE = "0";
    public static final String DATA_SOURCE_DELETE_FALSE = "1";
}

package life.majiang.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{

    QUESTION_NOT_FOUND(2001, "您找的问题不存在！"),
    TARGET_PARAM_NOT_FOUND(2002, "未选中问题或评论进行回复！"),
    NO_LOGIN(2003, "请登录！"),
    SYS_ERROR(2004, "位置错误！"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在！"),
    COMMENT_NOT_FOUND(2006, "回复的评论不存在！"),
    CONTENT_IS_EMPTY(2007, "输入内容不能为空！"),
    READ_NOTIFICATION_FAIL(2008, "这大概是别人的信息呢！"),
    NOTIFICATION_NOT_FOUND(2009, "无此消息！");

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}

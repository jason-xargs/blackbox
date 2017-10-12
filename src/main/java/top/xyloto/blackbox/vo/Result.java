package top.xyloto.blackbox.vo;

/**
 * @author zhaocong05
 * @createTime 2017-09-18
 * @description Result
 */
public class Result<T> {

    private boolean success;

    private String message;

    private T content;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getContent() {
        return content;
    }

    public Result<T> setContent(T content) {
        this.content = content;
        return this;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result(boolean success) {
        this.success = success;
    }

}

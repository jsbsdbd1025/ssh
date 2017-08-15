package main.base;

import java.util.HashMap;
import java.util.Map;

public class ResponseBody {
    /**
     * 操作是否成功
     * 0 失败
     * 1 成功
     * other 异常
     */
    private int status = Status.SUCCESS.getValue();
    /**
     * 反馈信息
     */
    private String msg = "操作成功";
    /**
     * 附加数据
     */
    private Map body = new HashMap();


    public void setStatus(Status status) {
        this.status = status.getValue();
        if (status == Status.FAIL) {
            msg = "操作失败";
        } else {
            msg = "操作成功";
        }
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setBody(Map body) {
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public Map getBody() {
        return body;
    }

    public enum Status {
        FAIL(0), SUCCESS(1);

        private int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}

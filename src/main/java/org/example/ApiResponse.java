package org.example;

public class ApiResponse {
    private int retcode;
    private String message;
    private infos data;

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public infos getData() {
        return data;
    }

    public void setData(infos data) {
        this.data = data;
    }


}

package com.alvi.RestCrud.exception;

public class EmployeeErrorResponse {
    private  int status;
    private  String message;
    private  long timeStemp;

    public EmployeeErrorResponse() {
    }

    public EmployeeErrorResponse(int status, String message, long timeStemp) {
        this.status = status;
        this.message = message;
        this.timeStemp = timeStemp;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimeStemp(long timeStemp) {
        this.timeStemp = timeStemp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public long getTimeStemp() {
        return timeStemp;
    }

    @Override
    public String toString() {
        return "EmployeeExceptionHandler{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", timeStemp=" + timeStemp +
                '}';
    }
}

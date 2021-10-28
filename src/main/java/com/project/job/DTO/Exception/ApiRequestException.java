package com.project.job.DTO.Exception;

/**
 * Author  : Creadted By Elhem NOURI
 **/

public class ApiRequestException extends RuntimeException {

    private String message;
    private String body;

    protected ApiRequestException() {
    }

    public ApiRequestException(
            String message,
            String body
    ) {
        this.message = message;
        this.body = body;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}

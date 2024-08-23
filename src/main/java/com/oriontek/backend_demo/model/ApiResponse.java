package com.oriontek.backend_demo.model;
/**
 * Generic class for formatting the endpoints as follow:
 * <pre>
 * {
 *      data: array | object | null (actual response)
 *      isSuccess: bool
 *      responseCode: int
 *      errorCode: String
 *      message: String
 *}
 * </pre>
 */
public class ApiResponse<T> {
    private T data;
    private boolean isSuccess;
    private int responseCode;
    private String errorCode;
    private String message;

    public ApiResponse(T data, int responseCode) {
        this.data = data;
        this.isSuccess = responseCode == 200 || responseCode == 201;
        this.responseCode = responseCode;
        this.errorCode = null;
        this.message = "";
    }

    // Getters and Setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String errorMsg) {
        this.message = errorMsg;
    }
}


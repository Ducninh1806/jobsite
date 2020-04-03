package com.example.demo.exception;

public enum ErrorCode {
    INTERNAL_SERVER_ERROR("500", "Internal server error"),
    FORBIDDEN("403", "Permission denied"),
    RECORD_NOT_FOUND("002", "RECORD_NOT_FOUND"),
    RECORD_NOT_EXISTED("003", "RECORD_NOT_EXISTED"),
    NAME_EXISTED("001", "Name existed"),
    NO_SKILL("004", "No null found"),
    UPLOAD_FILE_FAILED("005", "Upload file failed"),
    RECORD_EXISTED("041","RECORD_EXISTED"),
    JOB_APPLIED("409", "User has applied to the job"),
    EMAIL_EXISTED("500","EMAIL_EXISTED!"),
    CURRENT_PASSWORD_INCORRECT("007","CURRENT PASSWORD INCORRECT!"),
    ROLE_INVALID("400","ROLE DOES NOT EXIST!"),
    ACTIVE_KEY_NOT_FOUND("777","KEY ACTIVE USER NOT FOUND!"),
    RECORD_IS_USING("042", " CURRENT LOCATION IS USING"),
    RECORD_SKILL_IS_USING("043", " CURRENT SKILL IS USING"),
    ;
    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

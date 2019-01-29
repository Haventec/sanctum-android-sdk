package com.haventec.sanctum.android.sdk.api.exceptions;


import com.haventec.sanctum.android.sdk.models.BaseResponse;
import com.haventec.sanctum.android.sdk.models.HaventecError;

public class HaventecSanctumException extends Exception {

    private String errorCode;

    public HaventecSanctumException() {
    }

    public HaventecSanctumException(BaseResponse baseResponse) {

        super(baseResponse.getResponseStatus().getMessage());
        this.errorCode = baseResponse.getResponseStatus().getCode();
    }

    public HaventecSanctumException(HaventecError haventecError, String additionalInfo) {

        super(haventecError.getMessage() + ": " + additionalInfo);
        this.errorCode = haventecError.getErrorCode();
    }

    public HaventecSanctumException(HaventecError haventecError, Throwable throwable) {

        super(haventecError.getMessage() + ": " + throwable.getMessage(), throwable);
        this.errorCode = haventecError.getErrorCode();
    }

    public HaventecSanctumException(HaventecError haventecError) {
        super(haventecError.getMessage());
        this.errorCode = haventecError.getErrorCode();
    }
}

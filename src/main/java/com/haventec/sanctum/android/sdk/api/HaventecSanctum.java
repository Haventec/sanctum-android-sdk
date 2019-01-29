package com.haventec.sanctum.android.sdk.api;

import com.haventec.sanctum.android.sdk.api.exceptions.SanctumError;
import com.haventec.sanctum.android.sdk.api.exceptions.HaventecSanctumException;
import com.haventec.common.android.sdk.api.HaventecCommon;
import com.haventec.common.android.sdk.api.exceptions.HaventecCommonException;

public class HaventecSanctum {

    public static byte[] generateSalt() throws HaventecSanctumException {
        try {
            return HaventecCommon.generateSalt();
        } catch (HaventecCommonException e) {
            throw new HaventecSanctumException(SanctumError.HAVENTEC_COMMON_ERROR, e);
        }
    }

    public static String hashPin(String pin, byte[] salt) throws HaventecSanctumException {
        try {
            return HaventecCommon.hashPin(pin, salt);
        } catch (HaventecCommonException e) {
            throw new HaventecSanctumException(SanctumError.HAVENTEC_COMMON_ERROR, e);
        }
    }
}

package com.haventec.sanctum.android.sdk;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.haventec.sanctum.android.sdk.api.exceptions.HaventecSanctumException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.haventec.sanctum.android.sdk.test", appContext.getPackageName());

        try {
            byte[] saltBytes = com.haventec.sanctum.android.sdk.api.HaventecSanctum.generateSalt();
            String hashPin = com.haventec.sanctum.android.sdk.api.HaventecSanctum.hashPin("1234", saltBytes);
            Assert.assertTrue(isValidPin(hashPin));
        } catch (HaventecSanctumException e) {
            fail();
        }
    }


    private static final Integer SHA512HASH_BASE64_LEN = 88;
    private static final String VALID_BASE64  = "^[A-Za-z0-9+\\/=]{1,}$";

    /**
     * Confirm that the pin is the correct length and only numbers
     *
     * @param pin The pin to validate
     * @return true if it meets the requirements
     */
    public static boolean isValidPin(String pin) {
        return (pin != null && isValidBase64(pin) && pin.length() == SHA512HASH_BASE64_LEN);
    }

    /**
     * Check the string conforms to base64 encoding standards
     *
     * @param strBase64 The incoming string
     * @return true is the string is the correct format
     */
    public static boolean isValidBase64(String strBase64) {
        return (strBase64 != null && strBase64.matches(VALID_BASE64) && (strBase64.length() % 4 == 0));
    }
}

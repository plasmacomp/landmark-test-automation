package com.ttn.framework.utils;

import com.ttn.framework.tests.base.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.prefs.BackingStoreException;

public class DecodeUtil {


    public static String decode(String encodedText) {
        int len = encodedText.length();
        char[] encrypted = new char[len];
        char[] decrypted = new char[len];
        for (int i = 0; i < len; i++) {
            encrypted[i] = encodedText.charAt(i);
            encrypted[i] -= 7;
            decrypted[i] = encrypted[i];
        }
        System.out.println();
        return String.valueOf(decrypted);


    }
}


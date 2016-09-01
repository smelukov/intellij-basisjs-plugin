/*
 * Copyright 2016 Basis.js framework
 * http://basisjs.com
 */

package com.basisjs.tools;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Utils {
    public static boolean isUrlExists(String url) {
        try {
            URL urlObject = new URL(url);
            HttpURLConnection huc = (HttpURLConnection) urlObject.openConnection();
            huc.setRequestMethod("HEAD");
            huc.connect();

            return huc.getResponseCode() == 200;
        } catch (IOException ignored) {
        }

        return false;
    }
}

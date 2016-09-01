/*
 * Copyright 2016 Basis.js framework
 * http://basisjs.com
 */

package com.basisjs.bundles;

import com.intellij.AbstractBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

public class BasisJSMessages extends AbstractBundle {
    private static final String BUNDLE_NAME = "messages";

    private static final BasisJSMessages INSTANCE = new BasisJSMessages();

    private BasisJSMessages() {
        super(BUNDLE_NAME);
    }

    public static String message(@NotNull @PropertyKey(resourceBundle = BUNDLE_NAME) String key, @NotNull Object... params) {
        return INSTANCE.getMessage(key, params);
    }
}

/*
 * Copyright 2016 Basis.js framework
 * http://basisjs.com
 */

package com.basisjs.fileTypes;

import com.basisjs.bundles.BasisJSMessages;
import com.intellij.icons.AllIcons;
import com.intellij.lang.html.HTMLLanguage;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class TmplFileType extends LanguageFileType {
    @NonNls
    public static final TmplFileType INSTANCE = new TmplFileType();

    private TmplFileType() {
        super(HTMLLanguage.INSTANCE);
    }

    @Override
    @NotNull
    public String getName() {
        return BasisJSMessages.message("fileTypes.tmpl.name");
    }

    @Override
    @NotNull
    public String getDescription() {
        return BasisJSMessages.message("fileTypes.tmpl.description");
    }

    @Override
    @NotNull
    public String getDefaultExtension() {
        return BasisJSMessages.message("fileTypes.tmpl.ext");
    }

    @Override
    public Icon getIcon() {
        return AllIcons.FileTypes.Html;
    }
}

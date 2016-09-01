/*
 * Copyright 2016 Basis.js framework
 * http://basisjs.com
 */

package com.basisjs.fileTypes;

import com.basisjs.bundles.BasisJSMessages;
import com.intellij.icons.AllIcons;
import com.intellij.json.JsonLanguage;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class L10nFileType extends LanguageFileType {
    @NonNls
    public static final L10nFileType INSTANCE = new L10nFileType();

    private L10nFileType() {
        super(JsonLanguage.INSTANCE);
    }

    @Override
    @NotNull
    public String getName() {
        return BasisJSMessages.message("fileTypes.l10n.name");
    }

    @Override
    @NotNull
    public String getDescription() {
        return BasisJSMessages.message("fileTypes.l10n.description");
    }

    @Override
    @NotNull
    public String getDefaultExtension() {
        return BasisJSMessages.message("fileTypes.l10n.ext");
    }

    @Override
    public Icon getIcon() {
        return AllIcons.FileTypes.Json;
    }
}

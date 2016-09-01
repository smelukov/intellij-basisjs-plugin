/*
 * Copyright 2016 Basis.js framework
 * http://basisjs.com
 */

package com.basisjs.fileTypes;

import com.basisjs.bundles.BasisJSMessages;
import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class L10nFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull final FileTypeConsumer consumer) {
        consumer.consume(L10nFileType.INSTANCE, BasisJSMessages.message("fileTypes.l10n.ext"));
    }
}

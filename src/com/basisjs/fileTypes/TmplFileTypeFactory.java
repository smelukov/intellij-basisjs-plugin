/*
 * Copyright 2016 Basis.js framework
 * http://basisjs.com
 */

package com.basisjs.fileTypes;

import com.basisjs.bundles.BasisJSMessages;
import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class TmplFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull final FileTypeConsumer consumer) {
        consumer.consume(TmplFileType.INSTANCE, BasisJSMessages.message("fileTypes.tmpl.ext"));
    }
}

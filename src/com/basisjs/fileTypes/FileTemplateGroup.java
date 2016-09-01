/*
 * Copyright 2016 Basis.js framework
 * http://basisjs.com
 */

package com.basisjs.fileTypes;

import com.basisjs.bundles.BasisJSIcons;
import com.intellij.ide.fileTemplates.FileTemplateDescriptor;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptor;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptorFactory;

public class FileTemplateGroup implements FileTemplateGroupDescriptorFactory {

    @Override
    public FileTemplateGroupDescriptor getFileTemplatesDescriptor() {
        FileTemplateDescriptor tmplTemplateDescriptor = new FileTemplateDescriptor("template.tmpl");
        FileTemplateDescriptor l10nTemplateDescriptor = new FileTemplateDescriptor("dictionary.l10n");

        return new FileTemplateGroupDescriptor("Basis.js", BasisJSIcons.main, tmplTemplateDescriptor, l10nTemplateDescriptor);
    }
}

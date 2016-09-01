/*
 * Copyright 2016 Basis.js framework
 * http://basisjs.com
 */

package com.basisjs.actions;

import com.basisjs.bundles.BasisJSMessages;
import com.intellij.icons.AllIcons;
import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;

import javax.swing.*;

public class BasisJSNewTmplAction extends CreateFileFromTemplateAction implements DumbAware {
    public static final String TITLE = BasisJSMessages.message("fileTypes.tmpl.description");
    public static final String DESCRIPTION = "Create new " + TITLE;
    public static final Icon ICON = AllIcons.FileTypes.Html;

    public BasisJSNewTmplAction() {
        super(TITLE, DESCRIPTION, ICON);
    }

    @Override
    protected void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder) {
        builder.setTitle(DESCRIPTION).addKind(TITLE, ICON, "template.tmpl");
    }

    @Override
    protected String getActionName(PsiDirectory directory, String newName, String templateName) {
        return TITLE;
    }
}

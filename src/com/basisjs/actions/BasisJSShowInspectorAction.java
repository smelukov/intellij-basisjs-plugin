/*
 * Copyright 2016 Basis.js framework
 * http://basisjs.com
 */

package com.basisjs.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;

public class BasisJSShowInspectorAction extends AnAction implements DumbAware {
    @Override
    public void actionPerformed(AnActionEvent e) {
        if (e.getProject() != null) {
            ToolWindow basisJsToolWindow = ToolWindowManager.getInstance(e.getProject()).getToolWindow("Basis.js");
            basisJsToolWindow.show(() -> {
            });
        }
    }

    @Override
    public void update(AnActionEvent e) {
        e.getPresentation().setEnabled(e.getProject() != null);
    }
}

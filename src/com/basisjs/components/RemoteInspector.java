/*
 * Copyright 2016 Basis.js framework
 * http://basisjs.com
 */

package com.basisjs.components;

import com.basisjs.ui.windows.tools.inspector.InspectorWindow;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class RemoteInspector implements ProjectComponent {
    private Project project;
    private InspectorWindow inspectorWindow;

    public RemoteInspector(Project project) {
        this.project = project;
    }

    @Override
    public void projectOpened() {
        inspectorWindow = new InspectorWindow();
        inspectorWindow.createWindow(project);
    }

    @Override
    public void projectClosed() {
        inspectorWindow.destroyWindow(project);
    }

    @Override
    public void initComponent() {

    }

    @Override
    public void disposeComponent() {

    }

    @NotNull
    @Override
    public String getComponentName() {
        return "Basis.js";
    }
}

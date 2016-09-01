/*
 * Copyright 2016 Basis.js framework
 * http://basisjs.com
 */

package com.basisjs.ui.windows.tools;

import com.intellij.openapi.project.Project;

public interface IToolWindowFactory {
    void createWindow(Project project);

    void destroyWindow(Project project);
}

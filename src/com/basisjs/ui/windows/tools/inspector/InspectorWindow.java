/*
 * Copyright 2016 Basis.js framework
 * http://basisjs.com
 */

package com.basisjs.ui.windows.tools.inspector;

import com.basisjs.tools.Notificator;
import com.basisjs.ui.windows.tools.IToolWindowFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowAnchor;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.sun.javafx.application.PlatformImpl;
import com.sun.javafx.webkit.WebConsoleListener;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import java.io.IOException;

public class InspectorWindow implements IToolWindowFactory {
    private WebView webView;
    private JFXPanel jFXPanel;

    public void createWindow(Project project) {
        jFXPanel = new JFXPanel();
        ToolWindow toolWindow = ToolWindowManager.getInstance(project).registerToolWindow("Basis.js", false, ToolWindowAnchor.BOTTOM, false);
        toolWindow.setIcon(IconLoader.getIcon("/icons/basisjs.png"));
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(jFXPanel, "inspector", false);
        toolWindow.getContentManager().addContent(content);

        InspectorController sceneInspectorController = new InspectorController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/com/basisjs/ui/windows/tools/inspector/InspectorScene.fxml"));
        fxmlLoader.setController(sceneInspectorController);

        Platform.setImplicitExit(false);
        PlatformImpl.runLater(() -> {
            try {
                Scene scene = new Scene(fxmlLoader.load());
                jFXPanel.setScene(scene);
                webView = sceneInspectorController.webView;
                webView.setContextMenuEnabled(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void destroyWindow(Project project) {
        Platform.runLater(() -> {
            WebConsoleListener.setDefaultListener(null);
            webView.getEngine().getLoadWorker().cancel();
            jFXPanel.removeAll();
        });
    }
}

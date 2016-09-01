/*
 * Copyright 2016 Basis.js framework
 * http://basisjs.com
 */

package com.basisjs.ui.windows.tools.inspector;

import com.basisjs.services.Storage;
import com.basisjs.tools.Notificator;
import com.basisjs.tools.Utils;
import com.intellij.openapi.components.ServiceManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebView;

public class InspectorController {
    @FXML
    public WebView webView;
    @FXML
    public TextField urlText;

    @FXML
    public void urlTextKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            Storage.State state = ServiceManager.getService(Storage.class).getState();
            String postfix = state != null ? state.urlPostfix : "";
            String url = urlText.getText() + postfix;
            System.out.print(url);

            if (Utils.isUrlExists(url)) {
                webView.getEngine().load(url);
            } else {
                Notificator.getInstance().error(Notificator.INSPECTOR, "Wrong basis.js server url!");
            }
        }
    }
}

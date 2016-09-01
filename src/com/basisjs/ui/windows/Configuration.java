/*
 * Copyright 2016 Basis.js framework
 * http://basisjs.com
 */

package com.basisjs.ui.windows;

import com.basisjs.services.Storage;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Objects;

public class Configuration implements Configurable {
    private static final String TEXT_DISPLAY_NAME = "Basis.js";

    private final Storage storage = ServiceManager.getService(Storage.class);

    private ConfigurationForm configurationForm;

    @Nullable
    @Override
    public JComponent createComponent() {
        configurationForm = new ConfigurationForm();
        reset();

        return configurationForm.rootPanel;
    }

    @Override
    public boolean isModified() {
        String input = configurationForm.urlPostfix.getText();
        Storage.State state = storage.getState();
        if (state != null && Objects.equals(state.urlPostfix, configurationForm.urlPostfix.getText())) {
            return !input.equals(storage.getState().urlPostfix);
        }

        return !input.equals("");
    }


    @Override
    public void apply() throws ConfigurationException {
        Storage.State newState = new Storage.State();
        newState.urlPostfix = configurationForm.urlPostfix.getText();
        storage.loadState(newState);
    }

    @Override
    public void reset() {
        Storage.State oldState = storage.getState();

        if (oldState != null) {
            configurationForm.urlPostfix.setText(oldState.urlPostfix);
        }
    }

    @Override
    public void disposeUIResources() {

    }

    @Nls
    @Override
    public String getDisplayName() {
        return TEXT_DISPLAY_NAME;
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }
}

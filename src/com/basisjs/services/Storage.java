/*
 * Copyright 2016 Basis.js framework
 * http://basisjs.com
 */

package com.basisjs.services;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.StoragePathMacros;

@State(name = "BasisJSInspector", storages = {@com.intellij.openapi.components.Storage("basisjs.xml")})
public class Storage implements PersistentStateComponent<Storage.State> {
    private State state;

    public State getState() {
        if (state == null) {
            State newState = new State();
            newState.urlPostfix = "/basisjs-tools/devtool/";
            loadState(newState);
        }

        return state;
    }

    public void loadState(State newState) {
        state = newState;
    }

    public static class State {
        public String urlPostfix;
    }
}
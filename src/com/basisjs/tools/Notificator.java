/*
 * Copyright 2016 Basis.js framework
 * http://basisjs.com
 */

package com.basisjs.tools;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.ProjectManager;

public class Notificator {
    public final static String INSPECTOR = "Basis.js inspector";

    private static Notificator instance;

    private Notificator() {
    }

    public static Notificator getInstance() {
        if (instance == null) {
            instance = new Notificator();
        }

        return instance;
    }

    public void notify(String section, String title, String text, NotificationType type) {
        Notification notification = new Notification(section, title, text, type);
        notification.notify(ProjectManager.getInstance().getDefaultProject());
    }

    public void info(String section, String text) {
        info(section, "Information", text);
    }

    public void info(String section, String title, String text) {
        notify(section, title, text, NotificationType.INFORMATION);
    }

    public void warn(String section, String text) {
        warn(section, "Warning", text);
    }

    public void warn(String section, String title, String text) {
        notify(section, title, text, NotificationType.WARNING);
    }

    public void error(String section, String text) {
        error(section, "Error", text);
    }

    public void error(String section, String title, String text) {
        notify(section, title, text, NotificationType.ERROR);
    }
}

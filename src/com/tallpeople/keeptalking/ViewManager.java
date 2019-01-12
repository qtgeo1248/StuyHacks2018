package com.tallpeople.keeptalking;

import javax.swing.text.View;

public class ViewManager {

    public final int SIDES = 6;
    public final int MAX_MODULES_PER_SIDE = 3;

    public enum ViewType {
        FRONT(0), BACK(1), LEFT(2), RIGHT(3), TOP(4), BOTTOM(5);
        private final int value;
        private ViewType(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    private ViewType currentView;

    Module[][] modules;

    public ViewManager(ViewType defaultView) {
        this.currentView = defaultView;
        modules = new Module[SIDES][MAX_MODULES_PER_SIDE];
    }

    public ViewType getCurrentView() {
        return currentView;
    }

    public void setCurrentView(ViewType currentView) {
        this.currentView = currentView;
    }

    public Module[] getCurrentModules() {
        return modules[currentView.getValue()];
    }

    public void setModules(ViewType view, Module[] modules) {
        this.modules[view.getValue()] = modules;
    }

}

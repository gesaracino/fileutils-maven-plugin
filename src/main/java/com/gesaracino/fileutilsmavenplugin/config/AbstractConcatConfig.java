package com.gesaracino.fileutilsmavenplugin.config;

import java.io.File;

/**
 * Created by Gerardo Saracino on 15/08/2014.
 */
public abstract class AbstractConcatConfig {
    private File target;
    private boolean appendNewLine;

    public File getTarget() {
        return target;
    }

    public void setTarget(File target) {
        this.target = target;
    }

    public boolean isAppendNewLine() {
        return appendNewLine;
    }

    public void setAppendNewLine(boolean appendNewLine) {
        this.appendNewLine = appendNewLine;
    }

    @Override
    public String toString() {
        return "AbstractConcatConfig{" +
                "target=" + target +
                ", appendNewLine=" + appendNewLine +
                '}';
    }
}

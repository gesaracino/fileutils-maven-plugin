package com.gesaracino.fileutilsmavenplugin.config;

import java.io.File;

/**
 * Created by Gerardo Saracino on 09/09/2014.
 */
public class CopyConfig {
    private File source;
    private File target;

    public File getSource() {
        return source;
    }

    public void setSource(File source) {
        this.source = source;
    }

    public File getTarget() {
        return target;
    }

    public void setTarget(File target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "CopyConfig{" +
                "source=" + source +
                ", target=" + target +
                '}';
    }
}

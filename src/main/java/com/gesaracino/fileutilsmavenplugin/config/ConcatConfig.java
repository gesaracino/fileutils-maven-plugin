package com.gesaracino.fileutilsmavenplugin.config;

import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.util.List;

/**
 * Created by Gerardo Saracino on 15/08/2014.
 */
public class ConcatConfig {
    private File target;
    private List<File> sources;
    private boolean appendNewLine;

    public File getTarget() {
        return target;
    }

    public void setTarget(File target) {
        this.target = target;
    }

    public List<File> getSources() {
        return sources;
    }

    public void setSources(List<File> sources) {
        this.sources = sources;
    }

    public boolean isAppendNewLine() {
        return appendNewLine;
    }

    public void setAppendNewLine(boolean appendNewLine) {
        this.appendNewLine = appendNewLine;
    }

    @Override
    public String toString() {
        return "ConcatConfig{" +
                "target=" + target +
                ", sources=" + sources +
                ", appendNewLine=" + appendNewLine +
                '}';
    }
}

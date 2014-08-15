package com.gesaracino.fileutilsmavenplugin.config;

import java.io.File;
import java.util.List;

/**
 * Created by Gerardo Saracino on 15/08/2014.
 */
public class DeleteConfig {
    private List<File> targets;

    public List<File> getTargets() {
        return targets;
    }

    public void setTargets(List<File> targets) {
        this.targets = targets;
    }

    @Override
    public String toString() {
        return "DeleteFilesConfig{" +
                "targets=" + targets +
                '}';
    }
}

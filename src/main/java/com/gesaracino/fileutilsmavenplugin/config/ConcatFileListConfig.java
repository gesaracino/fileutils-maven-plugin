package com.gesaracino.fileutilsmavenplugin.config;

import java.io.File;
import java.util.List;

/**
 * Created by Gerardo Saracino on 15/08/2014.
 */
public class ConcatFileListConfig extends AbstractConcatConfig {
    private List<File> sources;

    public List<File> getSources() {
        return sources;
    }

    public void setSources(List<File> sources) {
        this.sources = sources;
    }

    @Override
    public String toString() {
        return "ConcatFileListConfig{" +
                "sources=" + sources +
                '}';
    }
}

package com.gesaracino.fileutilsmavenplugin.config;

import java.io.File;
import java.util.List;

/**
 * Created by Gerardo Saracino on 15/08/2014.
 */
public class ReplaceConfig {
    private List<File> targets;
    private String token;
    private String value;

    public List<File> getTargets() {
        return targets;
    }

    public void setTargets(List<File> targets) {
        this.targets = targets;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ReplaceConfig{" +
                "targets=" + targets +
                ", token='" + token + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

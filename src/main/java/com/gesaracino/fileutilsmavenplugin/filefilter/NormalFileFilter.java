package com.gesaracino.fileutilsmavenplugin.filefilter;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

/**
 * Created by Gerardo Saracino on 16/08/2014.
 */
public class NormalFileFilter implements FileFilter {
    private List<File> excludeFiles;
    private List<String> excludeFilesByName;

    public NormalFileFilter(List<File> excludeFiles, List<String> excludeFilesByName) {
        this.excludeFiles = excludeFiles;
        this.excludeFilesByName = excludeFilesByName;
    }

    @Override
    public boolean accept(File file) {
        if(! file.isFile()) {
            return false;
        }

        if(excludeFiles != null && excludeFiles.contains(file)) {
            return false;
        }

        if(excludeFilesByName != null && excludeFilesByName.contains(file.getName())) {
            return false;
        }

        return true;
    }
}

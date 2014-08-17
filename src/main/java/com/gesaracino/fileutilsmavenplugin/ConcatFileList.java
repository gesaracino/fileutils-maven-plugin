package com.gesaracino.fileutilsmavenplugin;

import com.gesaracino.fileutilsmavenplugin.config.ConcatFileListConfig;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.util.List;

/**
 * Created by Gerardo Saracino on 15/08/2014.
 */
@Mojo(name = "concatFileList")
public class ConcatFileList extends AbstractConcat<ConcatFileListConfig> {
    @Parameter(alias = "concatFileList")
    private ConcatFileListConfig concatFileListConfig;

    @Override
    protected ConcatFileListConfig getConcatConfig() {
        return concatFileListConfig;
    }

    @Override
    protected List<File> getFiles() {
        return concatFileListConfig.getSources();
    }
}

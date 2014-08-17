package com.gesaracino.fileutilsmavenplugin;

import com.gesaracino.fileutilsmavenplugin.config.AbstractConcatConfig;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by Gerardo Saracino on 17/08/2014.
 */
public abstract class AbstractConcat<T extends AbstractConcatConfig> extends AbstractMojo {
    private static final int BUFFER_SIZE = 8192;

    protected Log LOGGER = getLog();

    protected abstract T getConcatConfig();

    protected abstract List<File> getFiles();

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        LOGGER.info(getConcatConfig().toString());

        try {
            concatFilesContent(getFiles());
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new MojoFailureException(e.getMessage(), e);
        }
    }

    protected void concatFilesContent(List<File> sources) throws IOException {
        BufferedWriter writer = null;
        char[] buffer = new char[BUFFER_SIZE];

        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(getConcatConfig().getTarget()), Charset.defaultCharset()));

            for(File sourceFile : sources) {
                BufferedReader reader = null;

                try {
                    reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile), Charset.defaultCharset()));
                    int n = 0;

                    while ((n = reader.read(buffer, 0, BUFFER_SIZE)) > -1) {
                        writer.write(buffer, 0, n);
                    }

                    if(getConcatConfig().isAppendNewLine()) {
                        writer.newLine();
                    }
                } finally {
                    if(reader != null) {
                        reader.close();
                    }
                }
            }
        } finally {
            if(writer != null) {
                writer.close();
            }
        }
    }
}

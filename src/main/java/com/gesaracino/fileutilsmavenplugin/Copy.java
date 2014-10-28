package com.gesaracino.fileutilsmavenplugin;

import com.gesaracino.fileutilsmavenplugin.config.CopyConfig;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by Gerardo Saracino on 09/09/2014.
 */

@Mojo(name = "copy")
public class Copy extends AbstractMojo {
    private Log LOGGER = getLog();

    @Parameter(alias = "copy")
    private CopyConfig copyConfig;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        LOGGER.info(copyConfig.toString());

        Path source = Paths.get(copyConfig.getSource().getAbsolutePath());
        Path target = Paths.get(copyConfig.getTarget().getAbsolutePath());

        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new MojoFailureException(e.getMessage(), e);
        }
    }
}

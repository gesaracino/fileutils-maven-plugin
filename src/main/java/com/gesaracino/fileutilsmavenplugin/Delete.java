package com.gesaracino.fileutilsmavenplugin;

import com.gesaracino.fileutilsmavenplugin.config.DeleteConfig;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

/**
 * Created by Gerardo Saracino on 15/08/2014.
 */
@Mojo(name = "delete")
public class Delete extends AbstractMojo {
    private Log LOGGER = getLog();

    @Parameter(alias = "delete")
    private DeleteConfig deleteConfig;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        LOGGER.info(deleteConfig.toString());

        for(File file : deleteConfig.getTargets()) {
            file.delete();
        }
    }
}

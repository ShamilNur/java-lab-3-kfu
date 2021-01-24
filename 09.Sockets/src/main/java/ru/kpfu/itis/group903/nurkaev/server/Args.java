package ru.kpfu.itis.group903.nurkaev.server;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

@Parameters(separators = "=")
public class Args {

    @Parameter(names = {"--port"})
    public Integer port;
}
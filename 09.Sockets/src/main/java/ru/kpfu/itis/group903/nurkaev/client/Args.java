package ru.kpfu.itis.group903.nurkaev.client;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * @author @nshamil Shamil Nurkaev
 * 11-903
 * Homework
 */

@Parameters(separators = "=")
public class Args {

    @Parameter(names = {"--server-ip"}, required = true)
    public String host;

    @Parameter(names = {"--server-port"})
    public Integer port;
}
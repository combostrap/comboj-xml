package com.combostrap.xml.cli;


import com.combostrap.xml.Xmls;
import picocli.CommandLine;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "extract",
        description = {
                "extract one or multiple nodes and create another xml"
        }
)
public class XmlExtract implements Callable<Integer> {

    @CommandLine.Parameters(
            description = "A Xml File Path",
            // at least 1
            arity = "1..1"
    )
    private String fileUri;

    @CommandLine.Option(names = {
            "--xpath", "-xp"},
            description = "defines the Xpath Expression",
            required = true
    )
    String xpath;

    @Override
    public Integer call() {

        Path inputFilePath = Paths.get(fileUri);
        Xmls.xmlExtract(inputFilePath, xpath);
        return 0;

    }


}

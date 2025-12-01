package com.combostrap.xml.cli;


import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(
        name = "xmli",
        mixinStandardHelpOptions = true,
        versionProvider = XmlVersionProvider.class,
        description = {
                "To of the text value of the node defined by an Xpath expression, you would type:\nof --xpath \"//Repository/DECLARE/Database[@name=\\\"databaseName\\\"]/\" -in inputFile.xml \n"
        },
        subcommands = {
                XmlCheck.class,
                XmlCsv.class,
                XmlExtract.class,
                XmlQuery.class,
                XmlPrint.class,
                XmlUpdate.class,
        }
)
public class Xmli implements Callable<Integer> {

    @Override
    public Integer call() {

        // Show help when no subcommand is provided
        CommandLine.usage(this, System.out);
        return 1;

    }


}

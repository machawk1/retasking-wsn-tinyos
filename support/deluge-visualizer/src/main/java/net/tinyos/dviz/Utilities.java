package net.tinyos.dviz;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Utilities {

    public static String toStringStackTrace(Throwable e) {

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }

}

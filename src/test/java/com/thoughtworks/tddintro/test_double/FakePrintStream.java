/* this class is a STUB!!!!
 * stubs are: modules of code that simulate the behaviors of
 * software components that a module under test depends on
 * (the module under test is GreetingPrinter)
 */

package com.thoughtworks.tddintro.test_double;

import java.io.PrintStream;

public class FakePrintStream extends PrintStream {
    private String printedString;

    public FakePrintStream() {
        super(new FakeOutputStream());
    }

    @Override
    public void println(String string) {
        printedString = string;
    }

    public String printedString() {
        return printedString;
    }
}

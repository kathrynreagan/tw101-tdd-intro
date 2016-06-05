package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {

    List<String> books;
    PrintStream printStream;
    DateTimeFormatter dateTimeFormatter;
    Library library;
    DateTime time;



    @Before
    public void setUp(){
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
        time = new DateTime();
    }


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        String title = "Book Title";
        books.add(title);
        library = new Library(books, printStream, dateTimeFormatter);


        library.listBooks();

        verify(printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        library = new Library(books, printStream, dateTimeFormatter);

        library.listBooks();

        // doesn't work -- there are zero interactions with the printStream mock
        // verify(printStream).println("");
        // this works, but is it the intention of the Library class??
        verifyZeroInteractions(printStream);

    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        books.add("One Fish, Two Fish, Red Fish, Blue Fish");
        books.add("Oh, the Places You'll Go!");
        library = new Library(books, printStream, dateTimeFormatter);

        library.listBooks();

        verify(printStream).println("One Fish, Two Fish, Red Fish, Blue Fish");
        verify(printStream).println("Oh, the Places You'll Go!");
    }




    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {

        Library library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        verify(printStream).println("Welcome to the library! The current time is ");
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {
        when(dateTimeFormatter.print(time)).thenReturn("3:36 AM");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        verify(printStream).println("Welcome to the library! The current time is 3:36 AM");
    }
}

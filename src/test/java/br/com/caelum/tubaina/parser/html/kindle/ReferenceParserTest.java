package br.com.caelum.tubaina.parser.html.kindle;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class ReferenceParserTest {

    @Test
    public void shouldReplaceChapterReferences() throws Exception {
        compareInputAndExpected("chapterReferencesTestExpected.html", "chapterReferencesTest.html");
    }

    @Test
    public void shouldReplaceSectionReferences() throws Exception {
        compareInputAndExpected("sectionReferencesTestExpected.html", "sectionReferencesTest.html");
    }
    
    @Test
    public void shouldReplaceMixedReferences() throws Exception {
        compareInputAndExpected("mixedReferencesTestExpected.html", "mixedReferencesTest.html");
    }
    
    @Test
    public void shouldReplaceAExampleBook() throws Exception {
        compareInputAndExpected("exampleBookExpected.html", "exampleBook.html");
    }
    
    @Test
    public void shouldNotReplaceInvalidReferences() throws Exception {
        compareInputAndExpected("invalidReferencesTestExpected.html", "invalidReferencesTest.html");
    }
    
    private void compareInputAndExpected(String expectedFileName, String currentFileName)
            throws FileNotFoundException {
        String htmlContent = new Scanner(new File(
                "src/test/resources/kindle/"+currentFileName)).useDelimiter("$$").next();
        String htmlContentExpected = new Scanner(new File(
                "src/test/resources/kindle/"+expectedFileName)).useDelimiter("$$")
                .next();
        ReferenceParser referenceParser = new ReferenceParser(htmlContent);

        assertEquals(htmlContentExpected, referenceParser.replaceReferences());
    }


}

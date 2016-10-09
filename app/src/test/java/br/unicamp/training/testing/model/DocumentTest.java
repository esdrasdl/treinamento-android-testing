package br.unicamp.training.testing.model;

import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DocumentTest {

    @Test
    public void testDefaultConstructor() {
        Document document = new Document();

        assertNull(document.id);
        assertNull(document.type);
        assertNull(document.documentName);
        assertNull(document.expirationDate);
        assertNull(document.imageUrl);
    }

    @Test
    public void testIsDocumentPicture() {
        Document document = new Document();
        document.type = "7";

        assertTrue(document.isDocumentPicture());
    }

    @Test
    public void testIsDocumentPicture_false() {
        Document document = new Document();
        document.type = "18";

        assertFalse(document.isDocumentPicture());
    }

    @Test
    public void testExpirationDateFormatted_label() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2016);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Document document = new Document();
        document.expirationDate = calendar.getTime();

        String formatted = document.getLabelExpirationDate();
        assertTrue(formatted.matches("\\d{2}\\s.*\\s\\d{4}"));
    }

    @Test
    public void testExpirationDateFormatted_request() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2016);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Document document = new Document();
        document.expirationDate = calendar.getTime();

        assertEquals("2016-02-01", document.getRequestExpirationDate());
    }

    @Test
    public void testExpirationDateFormatted_DefaultExpirationDate() throws ParseException {
        Document document = new Document();
        assertNull(document.getRequestExpirationDate());
    }

}
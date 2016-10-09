package br.unicamp.training.testing.model;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Document {
    private static final SimpleDateFormat mLabelDateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
    private static final DateFormat API_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public static final String DOCUMENT_PICTURE_ID = "7";

    public String id;
    public String type;
    public String imageUrl;
    public String documentName;
    public Date expirationDate;
    public File file;

    public boolean isDocumentPicture() {
        return DOCUMENT_PICTURE_ID.equals(type);
    }

    public String getLabelExpirationDate() {
        return mLabelDateFormat.format(expirationDate);
    }

    public String getRequestExpirationDate() {
        if (expirationDate == null) {
            return null;
        }
        return API_DATE_FORMAT.format(expirationDate);
    }

}

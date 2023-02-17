package model.uploaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class GenericUploader {
    private File document_name;

    public GenericUploader(File document_name) {
        this.document_name = document_name;
    }

    public void accessDocument() throws IOException, FileNotFoundException {
        BufferedReader text_input = new BufferedReader(new FileReader(document_name));

        String line = text_input.readLine();
        while (line != null) {
            String[] elemsLine = line.split(";");
            putEntry(elemsLine);
            line = text_input.readLine();
        }
        text_input.close();
    }

    public abstract void putEntry(String[] elems);
}
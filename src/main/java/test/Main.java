package test;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Load, Get and modified a text field
        PDDocument pDDocument = null;
        try {
            pDDocument = PDDocument.load(new File("pdfbox\\example\\example.pdf"));
            PDAcroForm acroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDTextField field = (PDTextField) acroForm.getField("textbox1");

            field.setValue("Test");


            List<PDField> fields = acroForm.getFields();
            acroForm.flatten(fields, true);


            acroForm.setNeedAppearances(false);

            pDDocument.save("pdfbox\\example\\example-out.pdf");


            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

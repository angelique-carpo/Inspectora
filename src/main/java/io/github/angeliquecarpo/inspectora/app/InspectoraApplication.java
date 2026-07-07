package io.github.angeliquecarpo.inspectora.app;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class InspectoraApplication {
    public static void main(String[] args){
        System.out.println("Starting Inspectora...");
        Connection connection = Jsoup.connect("https://www.alamaras.gr/");//τύπος μεταβλητής όνομα μεταβλητής = μέθοδος που δημιουργεί το αντικείμενο
        Document document = null;//τύπος μεταβλητής όνομα μεταβλητής = αποτέλεσμα της μεθόδου
        try {
            document = connection.get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Title: [" + document.title() + "]");
    }
}

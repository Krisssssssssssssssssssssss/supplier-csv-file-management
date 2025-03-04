package com.hcm.TabelleBewertungsvergleich;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class TabellenGenerator {


    public static void main(String[] args) {

        String pfadInputCSV = "Bewertungstabelle\\resources\\LieferantenDaten.csv";
        File csvFileLieferanten = new File(pfadInputCSV);
        ArrayList<Lieferant> alleLieferanten = CSVImporter.getLieferantenFromCSV(csvFileLieferanten);

        //Extracting names for the first row
        String nameOfAllSuppliers = "";
        boolean firstLine = true;
        for (Lieferant lieferant : alleLieferanten) {
            if (firstLine) {
                firstLine = false;
                nameOfAllSuppliers += lieferant.getLieferantenBezeichnung().toString();
                continue;
            }
            nameOfAllSuppliers += ", " + lieferant.getLieferantenBezeichnung().toString();
        }
        try {
            generateTable(alleLieferanten, "Bewertungstabelle\\resources\\Output.csv", nameOfAllSuppliers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    private static void generateTable(ArrayList<Lieferant> alleLieferanten, String outputPfad, String nameOfAllSuppliers) throws FileNotFoundException, UnsupportedEncodingException {


        PrintWriter csvFileOutputTabelle = new PrintWriter(outputPfad, "UTF-8");
        //Point 4
        csvFileOutputTabelle.println(nameOfAllSuppliers);
        csvFileOutputTabelle.println("LieferantenBezeichnung; LfNR; Bew Kat 1; Bew Kat 2; Bew Kat 3; Gesamtbewertung");


        for (Lieferant lieferant : alleLieferanten) {

            HashMap<String, String> outputValues = new HashMap<>();

            outputValues.put("LieferantenBezeichnung", lieferant.getLieferantenBezeichnung());
            outputValues.put("LfNR", lieferant.getLfNR());
            outputValues.put("Bew Kat 1", lieferant.getBewKat1().toString());
            outputValues.put("Bew Kat 2", lieferant.getBewKat2().toString());
            outputValues.put("Bew Kat 3", lieferant.getBewKat3().toString());
            outputValues.put("Bew Kat 4", lieferant.getBewKat4().toString());
            outputValues.put("Bew Kat 5", lieferant.getBewKat5().toString());
            outputValues.put("Gesamtbewertung", calcGesamtBewertung(lieferant));

            csvFileOutputTabelle.printf("%s; %s; %s; %s; %s; %s\n",outputValues.get("LieferantenBezeichnung"),outputValues.get("LfNR"), outputValues.get("Bew Kat 1"),outputValues.get("Bew Kat 2"),outputValues.get("Bew Kat 3"),outputValues.get("Gesamtbewertung"));
        }

        csvFileOutputTabelle.close();

    }

    private static String calcGesamtBewertung(Lieferant lieferant) {

        int gesamtPunkte = lieferant.getBewKat1() + lieferant.getBewKat2() + lieferant.getBewKat3();

        if (gesamtPunkte >= 61) {
            return "sehr gut";
        } else if (gesamtPunkte >= 51) {
            return "gut";
        } else if (gesamtPunkte >= 41) {
            return "OK";
        } else {
            return "schlecht";
        }
    }


}

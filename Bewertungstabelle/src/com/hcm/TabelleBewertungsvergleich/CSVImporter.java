package com.hcm.TabelleBewertungsvergleich;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CSVImporter {

    public static ArrayList<Lieferant> getLieferantenFromCSV(File csvImportFileLieferanten) {

        System.out.println("Import Datei: " + csvImportFileLieferanten.getName() + " exists: " + csvImportFileLieferanten.exists());

        String line = "";

        BufferedReader reader = null;

        ArrayList<Lieferant> lieferanten = new ArrayList<>();

        boolean firstLine = true;

        try {

            reader = new BufferedReader(new InputStreamReader(new FileInputStream(csvImportFileLieferanten), "UTF-8"));

            while ((line = reader.readLine()) != null) {

                if (firstLine) {
                    firstLine = false;
                    continue;
                }


                String[] lieferantenInformationenSplittedLine = line.split(";", -1);
                //I am filtering the suppliers here instead of where it was so that I can extract the names and write them in the first line to satisfy point 4
                if(!lieferantenInformationenSplittedLine[2].trim().equalsIgnoreCase("zugelassen") && !lieferantenInformationenSplittedLine[2].trim().equalsIgnoreCase("archiviert")){
                    continue;
                }

                lieferanten.add(new Lieferant(lieferantenInformationenSplittedLine[0].trim(), lieferantenInformationenSplittedLine[1].trim(), lieferantenInformationenSplittedLine[2].trim(), Integer.parseInt(lieferantenInformationenSplittedLine[3].trim()), Integer.parseInt(lieferantenInformationenSplittedLine[4].trim()), Integer.parseInt(lieferantenInformationenSplittedLine[5].trim()), Integer.parseInt(lieferantenInformationenSplittedLine[6].trim()), Integer.parseInt(lieferantenInformationenSplittedLine[7].trim()), lieferantenInformationenSplittedLine[8].trim(), lieferantenInformationenSplittedLine[9].trim(), lieferantenInformationenSplittedLine[10].trim(), lieferantenInformationenSplittedLine[11].trim()));

            }


        } catch (Exception e) {
            System.err.println("Fehler beim CSV-Import!");
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                System.err.println("Fehler beim CSV-Import!");
            }
        }
        return lieferanten;
    }
    //Suggestion static that was mentioned in the README.md
    public static ArrayList<String> getSupplierGroup(File csvFileSuppliers) {
        ArrayList<String> warengruppenList = new ArrayList<>();
        String line = "";
        BufferedReader reader = null;
        boolean firstLine = true;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFileSuppliers), "UTF-8"));

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] warengruppeInfo = line.split(";", -1);
                warengruppenList.add(warengruppeInfo[1].trim());
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        return warengruppenList;
    }
}

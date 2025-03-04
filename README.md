# Requirements Description

- The customer wanted to make a more detailed list of its suppliers by adding factors 4 and 5.
- A commodity group was also being added. For now it is manually typed in.
- The customer also did not want to have all of the suppliers displayed in the output file, but rather the ones that are either approved or archived.
- All the filtered suppliers are being displayed first at the top of the file.

 Improvement suggestions for the customer:
- A commodity group can be added by using the static method added in the CSVImporter and then running a check to see if the name of the commodity group is included in the name of the supplier or else add the commodity group of "Sonstiges"
- A relational database could be created and an interface for the custumer to do CRUD operations through an admin panel through an API.
- Also, an in-between solution might be an endpoint that will take an inserted file, workout the same logic in a service, and return a downloadable csv file

Time needed:
45 min
---

# Anforderungen Beschreibung

- Der Kunde wollte eine detailliertere Liste seiner Lieferanten erstellen, indem die Faktoren 4 und 5 hinzugefügt wurden.
- Eine Warengruppe wurde ebenfalls hinzugefügt.
- Der Kunde wollte auch nicht, dass alle Lieferanten in der Ausgabedatei angezeigt werden, sondern nur diejenigen, die entweder genehmigt oder archiviert sind.
- Außerdem werden alle gefilterten Lieferanten zuerst am Anfang der Datei angezeigt.

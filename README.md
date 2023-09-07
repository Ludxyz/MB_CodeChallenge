# MB_CodeChallenge



To test the code, java has to be installed and can be run with `'java -jar mergeIntervall.jar'`


##Wie ist die Laufzeit Ihres Programms?

Die Laufzeitkomplexität des Programms beträgt O(n * log(n)) und kann nicht weiter optimiert werden. Die tatsächliche Laufzeit hängt auch von der Hardware ab. Die Tests wurden auf einem Computer mit einem Intel Core i7 10700 Prozessor mit 2,95 GHz und 16 GB Arbeitsspeicher durchgeführt.

Es wurde eine Testdurchführung sowohl mit der Verarbeitung von Strings als auch ohne durchgeführt. Die Werte der Intervalle wurden zufällig generiert, und bei jedem Durchlauf wurden 100.000 Intervalle verarbeitet. Um große Schwankungen in einzelnen Durchläufen auszugleichen, wurden immer 1000 Durchläufe durchgeführt, und der Durchschnitt wurde berechnet.

Die durchschnittliche Zeit für das Mergen mit der Verarbeitung von Strings betrug 75 ms.

Das Mergen ohne die Verarbeitung von Strings dauerte durchschnittlich 20 ms.

Eine Optimierung bestand darin, die Sortierung zu parallelisieren. Dadurch konnte die Zeit bei gleicher Datenmenge auf 50 ms bzw. 4 ms reduziert werden.


##Wie kann die Robustheit sichergestellt werden, vor allem auch mit Hinblick auf sehr große Eingaben ?

Die Robustheit des Programms wurde sichergestellt durch die Überprüfung auf korrekte Werte und die Bereitstellung aussagekräftiger Fehlermeldungen. Bei Eingabefehlern wird das Programm abgebrochen, und es muss mit den richtigen Werten im korrekten Format erneut ausgeführt werden.

Die Größe der Eingabewerte ist auf den Bereich der ganzen Zahlen (Integer) beschränkt. Die Anzahl der zu mergenden Intervalle ist durch die Hardware und den Speicherplatzverbrauch begrenzt, sofern Zeit keine Rolle spielt.

##Wie verhält sich der Speicherverbrauch ihres Programms ?


Es wurde versucht, den Speicherverbrauch zu reduzieren, indem der Einsatz von temporären Variablen minimiert und effiziente Container verwendet wurden. Während der Laufzeittests wurde der tatsächlich verwendete Speicher gemessen, und der Wert stieg auf 780 MB an.


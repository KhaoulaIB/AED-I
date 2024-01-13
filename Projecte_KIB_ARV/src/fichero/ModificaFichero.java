/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fichero;

import java.io.*;
import java.util.Arrays;

import org.apache.commons.csv.*;

/**
 * Clase que modifica el fichero para poder ser leído y que cada línea pueda ser
 * un objeto de la clase ElementMotxilla.
 *
 * @author KIB & ARV
 */
public class ModificaFichero {

    /**
     * El ficheroColumnas contiene solo las 4 líneas que pasarán a ser objeto y
     * ficheroModificado limpia las líneas inservibles.
     *
     * @param args
     */
    public static void main(String[] args) {
        //Columnas que deseas mantener del fichero
        int[] colDeseadas = {0, 10, 3, 8};
        String ficheroOriginal = "fifa_players.csv";
        String ficheroModificado = "ficheroColumnas.csv";
        columnasCSV(ficheroOriginal, ficheroModificado, colDeseadas);

        ficheroOriginal = ficheroModificado;
        ficheroModificado = "ficheroModificado.csv";
        limpiarCSV(ficheroOriginal, ficheroModificado);
    }

    /**
     * Método para convertir el fichero descargado de Kaggle en un fichero donde
     * solo estén presentes las columnas que pasarán a ser atributos de la clase
     * ElementMotxilla. Para utilizar este método nos hemos descargado la
     * librería "commons-csv-1.10.0.jar", que nos permite coger solo las
     * columnas que deseamos.
     *
     * @enlace https://commons.apache.org/csv/download_csv.cgi
     *
     * @param ficheroOriginal fichero de entrada
     * @param ficheroModificado fichero de salida
     * @param colDeseadas array con las columnas que deseamos mantener en el nuevo
     * fichero
     */
    private static void columnasCSV(String ficheroOriginal, String ficheroModificado, int[] colDeseadas) {
        try {
            //Abrir enlaces
            BufferedReader br = new BufferedReader(new FileReader(ficheroOriginal));
            BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroModificado));
            CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT);
            CSVPrinter csvPrinter = new CSVPrinter(bw, CSVFormat.DEFAULT);
            //Escribir en el fichero las nuevas columnas
            for (CSVRecord csvRecord : csvParser) {
                StringBuilder row = new StringBuilder();
                for (int columna : colDeseadas) {
                    if (row.length() > 0) {
                        row.append(",");
                    }
                    row.append(csvRecord.get(columna));
                }
                csvPrinter.printRecord(row.toString());
            }
            //Cerrar enlaces
            csvParser.close();
            csvPrinter.close();
            br.close();
            bw.close();
            System.out.println("Archivo reducido correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Crea un nuevo fichero que no contiene las líneas inservibles del antiguo
     * fichero para crear los elementos de la clase ElementMotxilla.
     *
     * @param ficheroOriginal fichero de entrada
     * @param ficheroModificado fichero de salida
     */
    private static void limpiarCSV(String ficheroOriginal, String ficheroModificado) {
        try {
            //Abrir enlaces
            BufferedReader br = new BufferedReader(new FileReader(ficheroOriginal));
            BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroModificado));
            br.readLine();
            //Primera linea contiene títulos de las columnas. Pasamos a la siguiente.
            String linea = br.readLine();
            while (linea != null) {
                String[] sep = linea.split(",");
                //Eliminar las comillas que aparecen al principio y al final de cada línea
                sep[0] = sep[0].replace("\"", "").trim();
                sep[sep.length - 1] = sep[sep.length - 1].replace("\"", "").trim();
                //Mirar si la línea tiene valores no nulos y solo los que necesitamos
                if (lineaValidaCSV(sep)) {
                    bw.write(String.join(",", sep));
                    bw.newLine();
                }
                linea = br.readLine();
            }
            //Cerrar enlaces
            br.close();
            bw.close();
            System.out.println("Archivo limpiado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que comprueba si la línea contiene valores no nulos y contiene 4
     * datos separados por ",".
     *
     * @param sep array de strings que contienen los datos que tiene cada línea
     * del fichero
     * @return true si la línea es válida, false en caso contrario.
     */
    private static boolean lineaValidaCSV(String[] sep) {
        for (String s : sep) {
            if (s.isEmpty()) {
                return false;
            }
        }
        return sep.length == 4;
    }

}

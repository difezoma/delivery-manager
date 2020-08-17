package co.com.diegozornosa.delivery.manager.utils;

import co.com.diegozornosa.delivery.manager.exceptions.DeliveryException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileUtils {

    private TextFileUtils() {
    }

    public static List<String[]> readTextFile(String filePath, String regex) throws DeliveryException {
        File file = new File(filePath);
        List<String[]> textArrayList = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String textLine;
            textArrayList = new ArrayList<>();
            while ((textLine = bufferedReader.readLine()) != null) {
                textArrayList.add(textLine.split(regex));
            }
        } catch (IOException e) {
            throw new DeliveryException("Ha ocurrido un error leyendo el archivo. ".concat(e.getMessage()));
        }
        return textArrayList;
    }

    public static void writeTextFile(String filePath, String fileName, String text) throws DeliveryException {
        File file = new File(filePath.concat(fileName));
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            throw new DeliveryException("Ha ocurrido un error creando el archivo de reporte. ".concat(e.getMessage()));
        }
    }

}

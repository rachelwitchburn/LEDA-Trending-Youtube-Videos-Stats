import models.Video;

import java.io.*;
import java.util.Scanner;

public class Utils {
    public static DynamicArray<String> readCSV(String path) {
        try {
            var file = new FileReader(path);
            var lines = new DynamicArray<String>();

            var scanner = new Scanner(file);
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                lines.add(line);
            }

            scanner.close();
            file.close();
            return lines;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException e) {
            System.out.println("Erro ao fechar o arquivo");
        }

        return null;
    }

    static boolean writeCSV(String path, DynamicArray<String> lines) {
        try {
            var file = new FileWriter(path);
            var writer = new BufferedWriter(file);

            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }

            writer.close();
            file.close();
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo");
        }
        return false;
    }
}

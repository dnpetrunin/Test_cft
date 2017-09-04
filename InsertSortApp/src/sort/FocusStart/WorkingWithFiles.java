package sort.FocusStart;

import java.io.*;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

class WorkingWithFiles {
    ArrayIns<?> readFile(String fileName, String typeName) throws IOException { //считывание из файла
        ArrayIns<?> arrayIns = null;
        try {
            try {
                List<String> stringList = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
                if (typeName.equals(InsertSortApp.sortingStrings)) { //считывание строк
                    arrayIns = new ArrayIns<>(stringList.toArray());
                } else if (typeName.equals(InsertSortApp.sortingIntegers)) { //считывание чисел
                    try {
                        Integer[] data = new Integer[stringList.size()];
                        for (int x = 0; x < stringList.size(); x++) {
                            data[x] = Integer.parseInt(stringList.get(x));
                        }
                        arrayIns = new ArrayIns<>(data);
                    } catch (NumberFormatException e) {
                        System.out.println("Несовпадение типов данных в файле и флага типа");
                        System.exit(0);
                    }
                }
            }catch (MalformedInputException e) {
                System.out.println("Неверная кодировка во входном файле. Требуется UTF_8");
                System.exit(0);
            }
        } catch (NoSuchFileException e) {
            System.out.println("Неверное имя файла");
            System.exit(0);
        }
        return arrayIns;
    }

    static void write(String fileName, String text) { //запись в файл
        try {
            try (PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile())) {
                out.print(text);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

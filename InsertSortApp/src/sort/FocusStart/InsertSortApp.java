package sort.FocusStart;

import java.io.IOException;

public class InsertSortApp {
    public static void main(String[] args) throws IOException {
        argsTest(args);
        String fileInputName = args[0];
        String fileOutputName = args[1];
        String typeFlag = args[2];
        String sortFlag = args[3];
        test(typeFlag, sortFlag);
        WorkingWithFiles workingWithFiles = new WorkingWithFiles ();
        ArrayIns textInFile = workingWithFiles.readFile(fileInputName, typeFlag);
        textInFile.insertionSort(typeFlag, sortFlag);
        WorkingWithFiles.write(fileOutputName, textInFile.getData());
    }

    private static  void argsTest(String[] args) { //проверка количества аргументов
        if (args.length != 4) {
            System.out.println("Неверное количество передаваемых аргументов");
            System.exit(0);
        }
    }
    private static void test(String args3, String args4) { //проверка аргументов
        if (!args3.equals(WorkingWithFiles.sortingIntegers) && !args3.equals(WorkingWithFiles.sortingStrings)) {
            System.out.println("Некорректный флаг для типов данных");
            System.exit(0);
        }
        if (!args4.equals(WorkingWithFiles.ascendingSort) && !args4.equals(WorkingWithFiles.descendingSort)) {
            System.out.println("Некорректный флаг для сортировки");
            System.exit(0);
        }
    }
}

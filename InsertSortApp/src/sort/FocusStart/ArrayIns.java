package sort.FocusStart;


class ArrayIns <T> {
    private T[] array;

    ArrayIns(T[] _array) {
        this.array = _array;
    } //конструктор

    String getData() //геттер
    {
        String data = "";
        for (int j = 0; j < array.length; j++) {
            data += array[j] + "\r\n";
        }
        return data;
    }

    void insertionSort(String typeFlag, String sortFlag) { //сортировка
        int in, out;
        for (out = 1; out < array.length; out++) {
            T temp = array[out];
            in = out;
            if (typeFlag.equals(InsertSortApp.sortingStrings)) { //сортировка для строк
                if (sortFlag.equals(InsertSortApp.ascendingSort)) { //по возрастанию
                    while (in > 0 && array[in - 1].toString().compareTo(temp.toString()) >= 0) {
                        array[in] = array[in - 1];
                        --in;
                    }
                } else if (sortFlag.equals(InsertSortApp.descendingSort)) { //по убыванию
                    while (in > 0 && array[in - 1].toString().compareTo(temp.toString()) <= 0) {
                        array[in] = array[in - 1];
                        --in;
                    }
                }

                } else if (typeFlag.equals(InsertSortApp.sortingIntegers)) { //сортировка для чисел
                try {
                    if (sortFlag.equals(InsertSortApp.ascendingSort)) { //по возрастанию
                        while (in > 0 && (Integer) array[in - 1] >= (Integer) temp) {
                            array[in] = array[in - 1];
                            --in;
                        }
                    } else if (sortFlag.equals(InsertSortApp.descendingSort)) { //по убыванию
                        while (in > 0 && (Integer) array[in - 1] <= (Integer) temp) {
                            array[in] = array[in - 1];
                            --in;
                        }
                    }
                } catch (NullPointerException e) {
                    System.out.println("NullPointerException. Некорректный флаг для типов данных.");
                    System.exit(0);
                }
            }
            array[in] = temp;
        }
    }
}
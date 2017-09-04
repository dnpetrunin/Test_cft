package sort.FocusStart;


class ArrayIns <T> {
    private T[] array;

    ArrayIns(T[] _array) {
        this.array = _array;
    } //конструктор

    String getData() //геттер
    {
        StringBuilder data = new StringBuilder();
        for (T anArray : array) {
            data.append(anArray).append("\r\n");
        }
        return data.toString();
    }

    void insertionSort(String typeFlag, String sortFlag) { //сортировка
        int in, out;
        for (out = 1; out < array.length; out++) {
            T temp = array[out];
            in = out;
            if (typeFlag.equals(WorkingWithFiles.sortingStrings)) { //сортировка для строк
                if (sortFlag.equals(WorkingWithFiles.ascendingSort)) { //по возрастанию
                    while (in > 0 && array[in - 1].toString().compareTo(temp.toString()) >= 0) {
                        array[in] = array[in - 1];
                        --in;
                    }
                } else if (sortFlag.equals(WorkingWithFiles.descendingSort)) { //по убыванию
                    while (in > 0 && array[in - 1].toString().compareTo(temp.toString()) <= 0) {
                        array[in] = array[in - 1];
                        --in;
                    }
                }

                } else if (typeFlag.equals(WorkingWithFiles.sortingIntegers)) { //сортировка для чисел
                try {
                    if (sortFlag.equals(WorkingWithFiles.ascendingSort)) { //по возрастанию
                        while (in > 0 && (Integer) array[in - 1] >= (Integer) temp) {
                            array[in] = array[in - 1];
                            --in;
                        }
                    } else if (sortFlag.equals(WorkingWithFiles.descendingSort)) { //по убыванию
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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<String> logMessages = new ArrayList<>(); // лист для записи лог сообщений
        String OSType = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        if (OSType.contains("win")) {
            System.out.println("Программа будет установлена в папку C:Games. Убедитесь что она создана.");
        } else {
            System.out.println("Программа работает только под системой Windows. Запустите программу под Windows");
        }
        ArrayList<String> paths = new ArrayList<>();    // Лист для папок
        boolean result;
        paths.add("C://Games//");
        paths.add("C://Games//src//");
        paths.add("C://Games//res//");
        paths.add("C://Games//savegames//");
        paths.add("C://Games//temp//");
        paths.add("C://Games//temp//temp.txt");
        paths.add("C://Games//src//main//");
        paths.add("C://Games//src//main//main.java");
        paths.add("C://Games//src//main//Utils.java");
        paths.add("C://Games//src//test//");
        paths.add("C://Games//res//drawables//");
        paths.add("C://Games//res//vectors//");
        paths.add("C://Games//res//icons//");
        for (int i = 0; i < paths.size(); i++) {
            try {
                File dir = new File(paths.get(i));
                if (i == 0) {   // проверка создания директории для установки
                    if (!dir.isDirectory() && dir.exists()) {
                        System.out.println("Папка для установки не создана");
                        System.out.println(("Пожалуйста создайте папку для установки C:Games"));
                        break;
                    } else {
                        continue;
                    }
                }
                if (paths.get(i).contains(".")) {   // Для файлов используется другой метод, здесь вычленяем файлы
                    result = dir.createNewFile();
                }
                else {
                    result = dir.mkdir();
                }
                logMessages.add("Результат создания " + paths.get(i) + " = " + result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                logMessages.add(e.getMessage());
            }

        }
        StringBuilder builder = new StringBuilder();
        for (String k : logMessages) {
            System.out.println(k);
            builder.append(k +"\n");
        }

        FileWriter temp = new FileWriter("C://Games//temp//temp.txt");
        temp.write(builder.toString());
        temp.close();

        System.out.println("\nЛог файл доступен здесь: C:/Games/temp/temp.txt");
    }
}

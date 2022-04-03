package progect;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Выберете предмет работы: Работа со строкой(1) Работа с файлом(2)");
        String subject = scanner2.nextLine();
        if (subject.equalsIgnoreCase("1")) {

            System.out.println("[A шифрование] [J расшифровка],[B брутфорс] пожалуйста, выберите один");
            String work = scanner2.nextLine();// Получить строку этой строки
            switch (work){
                case  ("A" ): // Определяем, равны ли переменные s1 и A, и игнорируем размер
                System.out.println("Пожалуйста, введите простой текст:");
                Scanner scanner = new Scanner(System.in);
                String string = scanner.nextLine();
                System.out.println("Пожалуйста, введите ключ:");
                Scanner scanner1 = new Scanner(System.in);
                int key = scanner1.nextInt();// Преобразовать следующий элемент ввода в int
                encrypt(string, key);// Вызываем метод шифрования
                    break;

                case  ("J") :
                System.out.println("Пожалуйста, введите зашифрованный текст:");
                Scanner sc = new Scanner(System.in);
                    string = sc.nextLine();
                System.out.println("Пожалуйста, введите ключ:");
                Scanner sc1 = new Scanner(System.in);
                    key = sc1.nextInt();
                decrypt(string, key);// Вызываем метод шифрования
                    break;

                case  ("B") :
                System.out.println("Пожалуйста, введите зашифрованный текст:");
                    string = scanner2.nextLine();
                System.out.println("Давайте подберем ключ,если ключ правильный, введите [ok]");
                boolean fin = true;
                while (fin) {

                    sc1 = new Scanner(System.in);
                    String key1 = sc1.nextLine();
                    if (key1.equalsIgnoreCase("ok")) {
                        System.out.println("Ключ подобран верно!");
                        fin = false;
                        break;
                    }
                    System.out.println(brutForse(string, Integer.parseInt(key1)));

                }
                break;
            }
        } else if (subject.equalsIgnoreCase("2")) {
            System.out.println("Введите  путь к файлу");
            String path = scanner2.nextLine();

            String list = String.valueOf(Files.readAllLines(Path.of(path)));

            File mainFile = new File(path);

            System.out.println("[A шифрование] [J расшифровка],[B брут форс],[S поиск по фрагменту строки] - пожалуйста, выберите один");
            String work = scanner2.nextLine();// Получить строку этой строки
            switch (work){
                case ("A") :// Определяем, равны ли переменные s1 и A, и игнорируем размер

                System.out.println("Пожалуйста, введите ключ:");
                Scanner scanner1 = new Scanner(System.in);
                int key = scanner1.nextInt();// Преобразовать следующий элемент ввода в int

                Path path2 = Path.of("D:/directory");
                    Files.deleteIfExists(Paths.get("D:/directory//decryptedCopyOfText.txt"));
                boolean created = Files.isDirectory(path2);

                if (!created) {
                    Files.createDirectory(Path.of("D://directory"));
                }

                File endFile = new File("D:/directory//decryptedCopyOfText.txt");

                Path ff = Paths.get(String.valueOf(mainFile));

                Files.writeString(ff, decrypt(String.valueOf(list),key),  StandardCharsets.UTF_8);
                copyFileUsingChannel(mainFile,endFile);
                    System.out.println(Path.of(String.valueOf(endFile)));
                break;
            case ("J"):
                System.out.println("Пожалуйста, введите ключ:");
                Scanner scanner = new Scanner(System.in);
                 key = scanner.nextInt();

                 path2 = Path.of("C://directory");

                 created = Files.isDirectory(path2);
                Files.deleteIfExists(Paths.get("D:/directory//encryptedCopyOfText.txt"));

                if (!created) {
                    Files.createDirectory(Path.of("D://directory"));
                }

                 endFile = new File("D:/directory//encryptedCopyOfText.txt");

                 ff = Paths.get(String.valueOf(mainFile));

                Files.writeString(ff, encrypt(String.valueOf(list),key),  StandardCharsets.UTF_8);
                copyFileUsingChannel(mainFile,endFile);
                System.out.println(Path.of(String.valueOf(endFile)));
                break;
                case ("B") :

                System.out.println("Давайте подберем ключ(введите число)");
                boolean fin = true;
                    path2 = Path.of("C://directory");

                    created = Files.isDirectory(path2);
                    Files.deleteIfExists(Paths.get("D:/directory//brutForcedCopyOfText.txt"));

                    if (!created) {
                        Files.createDirectory(Path.of("D://directory"));
                    }

                    endFile = new File("D:/directory//brutForcedCopyOfText.txt");

                    ff = Paths.get(String.valueOf(mainFile));
                while (fin) {
                    String strYes = "Да";
                    Scanner sca = new Scanner(System.in);
                    Scanner stringScanner = new Scanner(System.in);
                    key = sca.nextInt();
                    System.out.println(brutForse(String.valueOf(list), key));
                    System.out.println("Текст расшифрован?");
                    String stringKey = stringScanner.nextLine();
                    if (strYes.equalsIgnoreCase(stringKey)) {
                        System.out.println("Ключ подобран верно!");

                        Files.writeString(ff, brutForse(String.valueOf(list),key),  StandardCharsets.UTF_8);
                        copyFileUsingChannel(mainFile,endFile);
                        System.out.println(Path.of(String.valueOf(endFile)));
                        fin = true;
                        break;
                    } else {
                        System.out.println("Давайте попробуем еще");
                    }
                }
                break;
                case ("S"):
                    int keyi = 1;
                    System.out.println("Давайте попробуем расшифровать тект зная часть текста");
                    fin = true;
                    path2 = Path.of("C://directory");

                    created = Files.isDirectory(path2);
                    Files.deleteIfExists(Paths.get("D:/directory//brutForcedMechanicalCopyOfText.txt"));

                    if (!created) {
                        Files.createDirectory(Path.of("D://directory"));
                    }

                    endFile = new File("D:/directory//brutForcedMechanicalCopyOfText.txt");
                    Scanner scanner3 = new Scanner(System.in);
                    String pieceOfText = scanner3.nextLine();

                    ff = Paths.get(String.valueOf(mainFile));
                        for (int i = 0; i < 29; i++) {

                            if (brutForse(list, keyi).contains(pieceOfText)) {
                                System.out.println("Шифр взломан!");

                                Files.writeString(ff, brutForse(list,keyi),  StandardCharsets.UTF_8);
                                copyFileUsingChannel(mainFile,endFile);
                                System.out.println(Path.of(String.valueOf(endFile)));
                                break;
                            } else {
                                keyi++;
                                i++;
                            }
                        }
                    break;
                    }


            }
        }


    private static String encrypt(String text, int key) {
        int k = Integer.parseInt("-" + key);
        String string = "";
        for (int i = 0; i < text.length(); i++) {
            char simbol = text.charAt(i);
            if (simbol >= 'a' && simbol <= 'z')
            {
                simbol += k % 26;
                if (simbol < 'a')
                    simbol += 26;
                if (simbol > 'z')
                    simbol -= 26;// направо
            } else if (simbol >= 'A' && simbol <= 'Z')
            {
                simbol += k % 26;
                if (simbol < 'A')
                    simbol += 26;
                if (simbol > 'Z')
                    simbol -= 26;
            }
            string += simbol;
        }
        System.out.println(text + "После расшифровки:" + string);
        return string;
    }


    private static String decrypt(String text, int key) {
        String string = "";
        for (int i = 0; i < text.length(); i++) {
            char simbol = text.charAt(i);
            if (simbol >= 'a' && simbol <= 'z')
            {
                simbol += key % 26;
                if (simbol < 'a')
                    simbol += 26;
                if (simbol > 'z')
                    simbol -= 26;
            } else if (simbol >= 'A' && simbol <= 'Z')
            {
                simbol += key % 26;
                if (simbol < 'A')
                    simbol += 26;
                if (simbol > 'Z')
                    simbol -= 26;
            }
            string += simbol;
        }
        System.out.println(text + "После шифрования:" + string);
        return string;
    }

    private static String brutForse(String text, int key) {
        int k = Integer.parseInt("-" + key);
        String string = "";
        for (int i = 0; i < text.length(); i++) {
            char simbol = text.charAt(i);
            if (simbol >= 'a' && simbol <= 'z') {
                simbol += k % 26;
                if (simbol < 'a')
                    simbol += 26;
                if (simbol > 'z')
                    simbol -= 26;
            } else if (simbol >= 'A' && simbol <= 'Z') {
                simbol += k % 26;
                if (simbol < 'A')
                    simbol += 26;
                if (simbol > 'Z')
                    simbol -= 26;
            }
            string += simbol;
        }
        System.out.println(text + "После расшифровки:" + string);
        return string;
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;

             is = new FileInputStream(source);
             os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

            is.close();
            os.close();

    }
    private static void copyFileUsingChannel(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        }finally{
            sourceChannel.close();
            destChannel.close();
        }
    }
}
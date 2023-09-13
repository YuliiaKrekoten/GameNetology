import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File games = new File("C:/Users/Admin/IdeaProjects/GameNetology/Games");
        games.mkdirs();

        String[] folders = {"srs", "res", "saveGames", "srs/test", "res/drawables",
                "res/vectors", "res/icons"};
        for (String folder : folders) {
            File dir = new File(games, folder);
            dir.mkdirs();
            if (dir.exists()) {
                System.out.println("Папка " + dir.getName() + " успешно создана!");
            } else {
                System.out.println("Ошибка при создании папки " + dir.getName() + "!");
            }
        }
        File main = new File("games/srs/main");
        main.mkdirs();

        String[] files = {"Main.java", "Utils.java"};
        for (String file : files) {
            File newFile = new File(main, file);
            try {
                if (newFile.createNewFile()) {
                    System.out.println("Файл " + newFile.getName() + " успешно создан!");
                } else {
                    System.out.println("Ошибка при создании файла " + newFile.getName() + "!");
                }
            } catch (IOException e) {
                System.out.println("Ошибка при создании файла " + newFile.getName() + "!");
                e.printStackTrace();
            }
        }
        File temp = new File("Games/temp/temp.txt");
        temp.mkdirs();
        try {
            if (!temp.exists()) {
                temp.createNewFile(); // Создаем файл, если он не существует
                System.out.println("Файл успешно создан: " + temp.getAbsolutePath());
            } else {
                System.out.println("Файл уже существует: " + temp.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder log = new StringBuilder();
        log.append("Создана папка Games c директориями  src, res, savegames, temp\n");
        log.append("В каталоге src создано две директории: main, test\n");
        log.append("В каталог res создано три директории: drawables, vectors, icons\n");
        log.append("В подкаталоге main создайно два файла: Main.java, Utils.java\n");
        log.append("В директории temp создан файл temp.txt\n");
        String text = log.toString();
        try {
            FileWriter writer = new FileWriter("temp.txt");
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        GameProgress onePlayer = new GameProgress(100, 5, 10, 50.5);
        GameProgress twoPlayer = new GameProgress(80, 3, 8, 40.7);
        GameProgress threePlayer = new GameProgress(70, 12, 7, 35.5);

        GameProgress.saveGame("C:/Users/Admin/IdeaProjects/GameNetology/Games/saveGames/saveGame.dat",onePlayer);
        GameProgress.saveGame("C:/Users/Admin/IdeaProjects/GameNetology/Games/saveGames/saveGame.dat1",twoPlayer);
        GameProgress.saveGame("C:/Users/Admin/IdeaProjects/GameNetology/Games/saveGames/saveGame.dat2",threePlayer);

       GameProgress.zipFile("C:/Users/Admin/IdeaProjects/GameNetology/Games/saveGames/saveGame.zip",
               List.of("C:/Users/Admin/IdeaProjects/GameNetology/Games/saveGames/saveGame.dat",
                       "C:/Users/Admin/IdeaProjects/GameNetology/Games/saveGames/saveGame.dat1",
                       "C:/Users/Admin/IdeaProjects/GameNetology/Games/saveGames/saveGame.dat2"));



    }


    }



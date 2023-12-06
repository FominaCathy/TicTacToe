package org.project.Backup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Класс содержит метод, создающий резервную копию всех файлов в директории во вновь созданную папку ./backup
 */
public class Backup {
    private static String DIRBKP;

    /**
     * копирует все папки и файлы в директорию, имя которой уканано.
     * если папки для бекапа уже существует - бекап не создается
     *
     * @param path      - путь к папке, которую нужно скопировать в папку для бэкапа
     * @param dirBackup - название директории для бэкапа
     */

    public static void create(String path, String dirBackup){
        //TODO краво, но как правильно - не знаю

        if (DIRBKP == null) {
            File bkp = new File(dirBackup);
            if (!bkp.exists()) {
                bkp.mkdir();
                DIRBKP = dirBackup;
                backup(path, dirBackup);
            } else {
                System.out.println("указанная директория для бекапа уже существует. Бэкап невозможен");
            }

        }


    }


    private static void backup(String path, String dirBackup) {
         File tree = new File(path);
        File[] listFiles = tree.listFiles();
        for (File item : listFiles) {
            if (!(item.getName().equals(DIRBKP)) && !(item.getName().equals(".git")) && (item.isDirectory())) {
                File bkDir = new File(dirBackup + "/" + item.getName());
                bkDir.mkdir();
                backup(String.format("%s/%s/", path, item.getName()), (dirBackup + "/" + item.getName()));
            } else if (item.isFile()) {
                copyFiles(item, new File(dirBackup, item.getName()));
            }
        }
    }



    private static void copyFiles(File donor, File recipe) {
        try (FileOutputStream outputStream = new FileOutputStream(recipe)) {
            try (FileInputStream inputStream = new FileInputStream(donor)) {
                int ch;
                while ((ch = inputStream.read()) != -1) {
                    outputStream.write(ch);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



}

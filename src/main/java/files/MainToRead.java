package files;

import lombok.SneakyThrows;

import java.io.*;

/**
 * @author Evgeny Borisov
 */
public class MainToRead {
    @SneakyThrows
    public static void main(String[] args) {
        File file = new File("c:\\temp\\data\\humans.obj");

        FileInputStream fos = new FileInputStream(file);
        ObjectInputStream oos = new ObjectInputStream(fos);
        Human o = (Human) oos.readObject();
        System.out.println("o = " + o);




    }


    public void addToFile(File file, String data) {
        if (file.exists()) {
            try {
                new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }









}








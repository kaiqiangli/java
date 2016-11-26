package com.serialize.test;

import java.io.*;

/**
 * @author likaiqiang
 * @description
 * @create 2016-11-26 下午2:23
 **/
public class FileTest {
    public static void main(String[] args) {
        String path = "/Users/likaiqiang";

        File file = new File(path);

        if(file.isDirectory()) {
            String [] dirContents = file.list();
            for(String content : dirContents) {
                System.out.println(content);
            }
        }

        saveFile();

        readFile();
    }

    public static void saveFile() {
        try {

            //get resource path
            String path = FileTest.class.getClassLoader().getResource("").getPath();
            File file = new File(path + "/save.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("使用缓冲区写文件");
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try {
            String path = FileTest.class.getClassLoader().getResource("").getPath() + "/save.txt";
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;

            while((line = bufferedReader.readLine()) != null ){
                System.out.println(line);
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

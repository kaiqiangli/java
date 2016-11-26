package com.serialize.test;

import java.io.*;

/**
 * @author likaiqiang
 * @description 对象序列化后写入与读取
 * @create 2016-11-24 下午11:02
 **/
public class User implements Serializable {

    private transient String name;

    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public static void main(String[] args) {
        writeFile();

        File file = new File("user.txt");
        readFile(file);
    }

    /**
     * 对象序列化写文件
     */
    private static void writeFile() {

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("user.txt");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(new User("username", "password"));

            //关闭输出流
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 序列化文件中读取
     * @param file
     */
    private static void readFile(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            User user = (User) object;
            System.out.println(user.toString());

            //关闭输入流
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

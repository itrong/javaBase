package com.singer.io;

import java.io.*;

/**
 * 流范例
 *
 * @author lujianrong
 */
public class IODemo {


    /**
     * 字节流：
     * InputStream
     * OutputStream
     * FileInputStream
     * FileOutputStream
     * BufferedInputStream
     * BufferedOutputStream
     * 字符流：
     * Writer
     * Reader
     * FileReader
     * FileWriter
     * BufferedReader
     * BufferedWriter
     */
    static String filestr = "E:\\tmp\\123.txt";
    static String filestr2 = "E:\\tmp\\456.txt";
    static File file = new File(filestr);
    static File file2 = new File(filestr2);


    /**
     * 字符流无缓存
     */
    static void testReadAndWriter() throws IOException {

        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter(file2);
        int ch = 0;//字符流读取的是字符，用int存储
        while ((ch = fileReader.read()) != -1) {
            fileWriter.write(ch);
        }
        fileReader.close();
        fileWriter.close();
    }

    /**
     * 字符缓存流
     */
    static void testReadAndWriter2() throws IOException {

        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter(file2);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();


    }

    /**
     * 字节流无缓存
     */
    static void testInputAndOutPutStream() throws IOException {

        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file2);
        int ch = 0;//字符流读取的是字符，用int存储
        while ((ch = inputStream.read()) != -1) {
            outputStream.write(ch);
        }
        inputStream.close();
        outputStream.close();
    }

    /**
     * 字节缓存流
     */
    static void testInputAndOutPutStream2() throws IOException {

        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file2);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        byte[] arr = new byte[100];
        while ((bufferedInputStream.read(arr)) != -1) {
            bufferedOutputStream.write(arr);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();

    }

    /**
     * 转换流：
     * InputStreamReader ：字节到字符的桥梁。解码。
     * OutputStreamWriter：字符到字节的桥梁。编码。
     */
    static void testStreamReader() throws IOException {

        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file2);

        //字节流 转字符流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();

    }


    public static void main(String[] args) {
        try {
            testStreamReader();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

package com.example.test4.service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public static String inputFile = "src/main/java/com/example/test4/file/input.txt";
    public static String searchFile = "src/main/java/com/example/test4/file/search.txt";
    public static Integer lengthArray = 1000000;

    public static void writeArrayToFile(String fileName,int[] arr){
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.append(String.valueOf(arr[0]));
            for(int i = 1; i < arr.length; i++){
                if(i % 10 == 0){
                    writer.append("\n").append(String.valueOf(arr[i]));
                }else{
                    writer.append(" ").append(String.valueOf(arr[i]));
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static List<Integer> readSearchFile(String fileName){
        List<Integer> list = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = bf.readLine()) != null){
                String[] strings = line.split(" ");
                for(String str :  strings){
                    try{
                        list.add(Integer.valueOf(str));
                    }catch (Exception ex){
                        continue;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int[] readArrayToFile(String fileName){
        List<Integer> list = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = bf.readLine()) != null){
                String[] strings = line.split(" ");
                for(String str :  strings){
                    try{
                        list.add(Integer.valueOf(str));
                    }catch (Exception ex){
                        continue;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int length = list.size();
        int[] arr = new int[length];
        for(int i = 0; i < length;i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

}

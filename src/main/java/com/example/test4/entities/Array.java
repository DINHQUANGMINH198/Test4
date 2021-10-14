package com.example.test4.entities;

public class Array {
    private int[] array;
    private int length;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Array(int[] array, int length) {
        this.array = array;
        this.length = length;
    }
    public Array() {
    }
    public int get(int index){
        return array[index];
    }
    public void print(){
        System.out.print(array[0] + " ");
        for (int i = 1; i < length;i++){
            if(i%10==0){
                System.out.println();
            }
            System.out.print(array[i] + " ");
        }
    }



}

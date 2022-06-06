package com.dataStructures;

import java.io.*;

/**
 * 稀疏数组
 * @author 91491
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        int[][] chessArr1=new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        System.out.println("原始的二维数组:");
        for (int[] row :chessArr1){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        int sum=0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("稀疏数组");
        //创建稀疏数组
        int[][] sparseArr=new int[sum+1][3];
        sparseArr[0][0]=chessArr1.length;
        sparseArr[0][1]=chessArr1[0].length;
        sparseArr[0][2]=sum;
        int count=0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        int[][] oldArr=new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            oldArr[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        System.out.println("原始二维数组");
        for (int[] ints : oldArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
        System.out.println("将稀疏数组写入到文件中");
        FileOutputStream fileOutputStream=new FileOutputStream(new File("chess.txt"));
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
               fileOutputStream.write((String.valueOf(anInt)+",").getBytes());

            }
            fileOutputStream.write("\n".getBytes());
        }
        fileOutputStream.close();
        System.out.println("-----------");
        System.out.println("读取稀疏数组");
        BufferedReader bufferedReader=new BufferedReader(new FileReader("chess.txt"));
        int[][] chessRestore=null;
        String line=null;
        String row=null;
        String col=null;
        String val=null;
        int c=0;
        while ((line=bufferedReader.readLine())!=null){
            c++;
            String[] strings = line.split(",");
            if (c==1){
                row=strings[0];
                col=strings[1];
                chessRestore=new int[Integer.parseInt(row)][Integer.parseInt(col)];
            }
            else {
                row=strings[0];
                col=strings[1];
                val=strings[2];
                chessRestore[Integer.parseInt(row)][Integer.parseInt(col)]=Integer.parseInt(val);
            }
        }
        for (int[] ints : chessRestore) {
            for (int anInt : ints) {
                System.out.printf(anInt+"\t");
            }
            System.out.println();
        }
    }
}

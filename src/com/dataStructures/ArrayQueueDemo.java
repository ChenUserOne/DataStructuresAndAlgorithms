package com.dataStructures;

import java.util.Scanner;

/**
 * 队列
 * @author 91491
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建队列
        ArrayQueue queue = new ArrayQueue(3);
        //接收键盘输入
        char key=' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):获取数据");
            System.out.println("h(head):查看队列头的数据");
             key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数:");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = queue.getQueue();
                        System.out.printf("取出的数据%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("取出的头数据%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }

        }
        System.out.println("程序退出");
    }
    static class ArrayQueue{
        //数组最大容量
        private int maxSize;
        //队列头
        private int front;
        //队列尾
        private int rear;
        //存储数据,模拟数据
        private int[] arr;

        //创建队列构造器
        public ArrayQueue(int arrMaxSize){
            maxSize=arrMaxSize;
            arr=new int[arrMaxSize];
            //指向队列头部,指向队列头的前一个位置
            front=-1;
            //指向队列尾部,指向队列尾的数据
            rear=-1;
        }
        //判断队列是否满
        public boolean isFull(){
            return rear==maxSize-1;
        }
        //判断队列是否为空
        public boolean isEmpty(){
            return rear==front;
        }
        //添加数据到队列,入队列
        public void addQueue(int n){
            //判断队列是否满
            if(isFull()){
                System.out.println("队列满，不能加入数据");
                return;
            }
            rear++;
            arr[rear]=n;
        }
        //获取数据,出队列
        public int getQueue(){
            //判断队列是否为空
            if (isEmpty()){
                throw new RuntimeException("队列空，不能取数据");
            }
            front++;
            return arr[front];
        }
        //显示队列的所有数据
        public void showQueue(){
            //判断是否为空
            if (isEmpty()){
                System.out.println("队列空的，没有数据~~");
                return;
            }
            for (int i = 0; i <arr.length; i++) {
                System.out.printf("arr[%d]=%d\n",i,arr[i]);
            }
        }
        //显示队列的头数据,不是取数据
        public int headQueue(){
            //判断是否为空
            if (isEmpty()){
                throw new RuntimeException("队列空的，没有数据~~");
            }
            return arr[front+1];
        }
    }
}

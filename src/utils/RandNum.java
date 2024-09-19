package utils;

import java.util.Random;

public final class RandNum {
    private RandNum(){}

    public static String randNum(int digitNum){
        StringBuilder stringBuilder = new StringBuilder();
        Random rand = new Random();

        for(int i = 0; i < digitNum; i++)
            stringBuilder.append(rand.nextInt(10));

        return stringBuilder.toString();
    }

    public static String randNum(int digitNum, String start){
        StringBuilder stringBuilder = new StringBuilder();
        Random rand = new Random();

        for(int i = 0; i < digitNum; i++)
            stringBuilder.append(rand.nextInt(10));

        return stringBuilder.insert(0, start).toString();
    }

    public static String randNum(int digitNum, String start, String end){
        StringBuilder stringBuilder = new StringBuilder();
        Random rand = new Random();

        for(int i = 0; i < digitNum; i++)
            stringBuilder.append(rand.nextInt(10));

        return stringBuilder.insert(0, start).append(end).toString();
    }

}

package com.ques.interviewquestions;

import java.io.*;
import java.util.*;
public class Snowflake {
    public void run(){
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("f");
        list.add("f");
        System.out.println(toolchanger(list, 0,"f"));
    }
    public static int toolchanger(List<String> tools, int startIndex, String target){
        int foundAt = tools.indexOf(target);
        int foundAtReverse = tools.lastIndexOf(target);
        int len = tools.size();
        int result = 0;
        if(foundAt==foundAtReverse){
            if(foundAt>startIndex){
                int way1 = foundAt-startIndex;
                int way2 = startIndex+len-foundAt;
                result = (way1<way2)? way1:way2;
            }else if(foundAt<startIndex) {
                int way1 = startIndex - foundAt;
                int way2 = len - startIndex + foundAt;
                result = (way1 < way2) ? way1 : way2;
            }
        }else{

            if(foundAt>startIndex){
                int way1 = foundAt-startIndex;
                int way2 = startIndex+len-foundAt;
                result = (way1<way2)? way1:way2;
            }
            if(foundAt<startIndex) {
                int way1 = startIndex - foundAt;
                int way2 = len - startIndex + foundAt;
                result = (way1 < way2) ? way1 : way2;
            }
            int curr_min=Integer.MAX_VALUE;
            if(foundAtReverse>startIndex){
                int way1 = foundAtReverse-startIndex;
                int way2 = startIndex+len-foundAtReverse;
                curr_min = (way1<way2)? way1:way2;
            }
            if(foundAtReverse<startIndex) {
                int way1 = startIndex - foundAtReverse;
                int way2 = len - startIndex + foundAtReverse;
                curr_min = (way1 < way2) ? way1 : way2;
            }
            result = (result<curr_min)?result:curr_min;
        }

        return result;
    }
}
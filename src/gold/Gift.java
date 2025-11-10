package lv2;

import java.io.*;
import java.util.*;

class Gift {
  public int solution(String[] friends, String[] gifts) {
    int[][] num = new int[50][50];
    int[] result = new int[50];
    int[] chart = new int[50];

    for(int i = 0; i < gifts.length; i++){
      StringTokenizer st = new StringTokenizer(gifts[i]);
      String from = st.nextToken();
      String to = st.nextToken();

      int f = 0;
      int t = 0;
      for(int j = 0; j < friends.length; j++){
        if(friends[j].equals(from)){
          f = j;
        }
        else if(friends[j].equals(to)){
          t = j;
        }
      }
      num[f][t] += 1;
    }

    for(int i = 0; i < friends.length; i++){
      int totalGive = 0;
      for(int j = 0; j < friends.length; j++){
        totalGive += num[i][j];
      }
      chart[i] = totalGive;
    }

    for(int i = 0; i < friends.length; i++){
      int totalGet = 0;
      for(int j = 0; j < friends.length; j++){
        totalGet += num[j][i];
      }
      chart[i] -= totalGet;
    }

    int max = 0;
    for(int i = 0; i < friends.length; i++){
      for(int j = 0; j < friends.length; j++){
        if(i == j) continue;

        if(num[i][j] != 0 || num[j][i] != 0){
          if(num[i][j] == num[j][i]){
            if(chart[i] < chart[j]){
              result[j] += 1;
            } else if(chart[i] > chart[j]){
              result[i] += 1;
            }
          }
          else{
            if(num[i][j] > num[j][i]){
              result[i] += 1;
            } else{
              result[j] += 1;
            }
          }
        } else{
          if(chart[i] < chart[j]){
            result[j] += 1;
          } else if(chart[i] > chart[j]){
            result[i] += 1;
          }
        }
      }
    }

    int answer = 0;
    for(int i = 0; i < friends.length; i++){
      answer = Math.max(answer, result[i] / 2);
    }
    return answer;
  }
}
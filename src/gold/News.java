package lv2;

import java.util.*;

class News {
  public int solution(String str1, String str2) {
    List<String> s1 = new ArrayList<>();
    List<String> s2 = new ArrayList<>();

    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    for (int i = 0; i < str1.length() - 1; i++) {
      char a = str1.charAt(i);
      char b = str1.charAt(i + 1);
      if (Character.isLetter(a) && Character.isLetter(b)) {
        s1.add("" + a + b);
      }
    }

    for (int i = 0; i < str2.length() - 1; i++) {
      char a = str2.charAt(i);
      char b = str2.charAt(i + 1);
      if (Character.isLetter(a) && Character.isLetter(b)) {
        s2.add("" + a + b);
      }
    }

    // 교집합
    List<String> intersection = new ArrayList<>();
    List<String> copy = new ArrayList<>(s2);

    for (String word : s1) {
      if (copy.contains(word)) {
        intersection.add(word);
        copy.remove(word);
      }
    }

    // 합집합
    int unionSize = s1.size() + s2.size() - intersection.size();

    // 자카드 유사도
    double jaccard = 0;
    if (unionSize == 0) {
      jaccard = 1;
    } else {
      jaccard = (double) intersection.size() / unionSize;
    }

    return (int) (jaccard * 65536);
  }
}


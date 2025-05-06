package bronze;


import java.io.*;
import java.util.*;

public class P2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int []card=new int[n];
        for(int i=0;i<n;i++) {
            card[i]=Integer.parseInt(st.nextToken());
        }
        int size=n*(n-1)*(n-2);
        int max=0;
        int result=0;

        for(int i=0;i<n-2;i++) {
            for(int j=i+1;j<n-1;j++) {
                for(int k=j+1;k<n;k++) {
                    result=card[i]+card[j]+card[k];
                    if(result==m) {
                        max=result;
                        break;
                    }
                    else if(result>max&&result<m)
                        max=result;
                }
            }
        }
        System.out.println(max);



    }

}



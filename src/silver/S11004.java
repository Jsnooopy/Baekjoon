package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, N - 1, K - 1);
        System.out.println(arr[K - 1]);
    }

    static void quickSort(int[] arr, int S, int E, int K) {
        if (S < E) {
            int pivot = partition(arr, S, E);
            if (pivot == K) {
                return;
            } else if (K < pivot) {
                quickSort(arr, S, pivot - 1, K);
            } else {
                quickSort(arr, pivot + 1, E, K);
            }
        }
    }

    static int partition(int[] arr, int S, int E) {
        if (S + 1 == E) {
            if (arr[S] > arr[E]) {
                swap(arr, S, E);
            }
            return E;
        }

        int M = (S + E) / 2;
        swap(arr, S, M);
        int pivot = arr[S];
        int i = S + 1, j = E;
        while (i <= j) {
            while (j >= S + 1 && pivot < arr[j]) {
                j--;
            }
            while (i <= E && pivot > arr[i]) {
                i++;
            }
            if (i <= j) {
                swap(arr, i++, j--);
            }
        }

        arr[S] = arr[j];
        arr[j] = pivot;
        return j;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

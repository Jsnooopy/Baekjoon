package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1991 {
    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insert(head, root, left, right);
        }

        pre(head);
        System.out.println();

        in(head);
        System.out.println();

        post(head);
        System.out.println();
    }

    static void pre(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        pre(node.left);
        pre(node.right);
    }

    static void in(Node node) {
        if (node == null) {
            return;
        }
        in(node.left);
        System.out.print(node.value);
        in(node.right);
    }

    static void post(Node node) {
        if (node == null) {
            return;
        }
        post(node.left);
        post(node.right);
        System.out.print(node.value);
    }

    static class Node {
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static void insert(Node temp, char root, char left, char right) {
        if (temp.value == root) {
            temp.left = (left == '.' ? null : new Node(left, null, null));
            temp.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            if (temp.left != null) {
                insert(temp.left, root, left, right);
            }
            if (temp.right != null) {
                insert(temp.right, root, left, right);
            }
        }
    }
}

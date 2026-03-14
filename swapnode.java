import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Node {
    int index;
    Node left;
    Node right;

    Node(int index) {
        this.index = index;
        this.left = null;
        this.right = null;
    }
}

class Result {

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        int n = indexes.size();
        Node[] nodes = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < n; i++) {
            int leftIndex = indexes.get(i).get(0);
            int rightIndex = indexes.get(i).get(1);

            if (leftIndex != -1) {
                nodes[i + 1].left = nodes[leftIndex];
            }
            if (rightIndex != -1) {
                nodes[i + 1].right = nodes[rightIndex];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int k : queries) {
            swapDepth(nodes[1], 1, k);
            List<Integer> resultDepth = new ArrayList<>();
            inorder(nodes[1], resultDepth);
            result.add(resultDepth);
        }
        return result;
    }

    private static void inorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.index);
        inorder(root.right, result);
    }

    private static void swapDepth(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level % k == 0) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        swapDepth(root.left, level + 1, k);
        swapDepth(root.right, level + 1, k);
    }
}
  

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> result = Result.swapNodes(indexes, queries);

        result.stream()
            .map(
                r -> r.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
            )
            .map(r -> r + "\n")
            .collect(toList())
            .forEach(e -> {
                try {
                    bufferedWriter.write(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

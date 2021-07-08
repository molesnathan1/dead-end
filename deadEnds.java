import java.util.*;
import java.io.*;

class deadEnds {

    static void writeDeadEnds(int arr[], int N) {

        int[] b = new int[arr[N - 1] + 1];

        for (int i = 0; i < N; i++) {
            b[arr[i]] = 1;
        }

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("deadEndOutput.txt"));
            for (int i = 0; i <= arr[N - 1]; i++) {
                if (b[i] == 0) {
                    out.write(i + "\n");
                }
            }
            out.close();
            System.out.println("File created successfully");
        } catch (IOException e) {
            System.out.println("An error occurred with creating the file.");
            e.printStackTrace();
        }
    }


static ArrayList<Integer> readNodes(String filename) {
    ArrayList<Integer> nodesFound = new ArrayList<Integer>();
    int lastNum = -1;

    try{
        FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null)   {
                String[] tokens = strLine.split(" ");
                int curNum = Integer.parseInt(tokens[0]);
                if (curNum != lastNum) {
                    nodesFound.add(curNum);
                    lastNum = curNum;
                }
            }    
        in.close();
    } catch (Exception e){
        System.err.println("Error: " + e.getMessage());
    }
    return nodesFound;
}

    public static void main(String[] args) {
        String filename = "wiki-topcats.txt";
        int arr[] = readNodes(filename).stream().mapToInt(i -> i).toArray();
        int N = arr.length;
        //System.out.println(readNodes(filename));
        writeDeadEnds(arr, N);
    }
}
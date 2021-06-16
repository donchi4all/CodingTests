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



class Result {

    /*
     * Complete the 'minimizeBias' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY ratings as parameter.
     */

    public static int minimizeBias(List<Integer> ratings) {
    // Write your code here
    int sumOfInt = 0;
    int lengthOfArray = ratings.size();
    Collections.sort(ratings);
    
    for(int i = 0; i<lengthOfArray-1; i +=2){
        int difference = ratings.get(i+1)-ratings.get(i);
        sumOfInt+=difference;
    }
    return sumOfInt;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int ratingsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ratings = IntStream.range(0, ratingsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimizeBias(ratings);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

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

    public static List<String> funWithAnagrams(List<String> text) {
    // Write your code here
    List<String> res = new ArrayList<String>();
    if(text.size()<=1){
        return text;
    }
    
    Set<String> store = new HashSet<>();
    for(int i=0; i<text.size(); i++){
        String firstString = text.get(i);
        char[] characters= firstString.toCharArray();
        Arrays.sort(characters);
        String newString = new String(characters);
        
        if(!store.contains(newString)){
            store.add(newString);
            res.add(firstString);
        }
    }
        Collections.sort(res);
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int textCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> text = IntStream.range(0, textCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.funWithAnagrams(text);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

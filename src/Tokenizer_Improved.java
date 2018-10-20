import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

import org.tartarus.snowball.SnowballStemmer;
import org.tartarus.snowball.ext.*;

public class Tokenizer_Improved {
    private Set<String> stopwords = new HashSet<>();
    private Set<String> allTokens = new HashSet<>();

    public Tokenizer_Improved() throws FileNotFoundException {
        listStopWords();
    }

    public Set<String> getAllTokens() {
        return allTokens;
    }

    public Set<String> tokenize(String[] test){
        SnowballStemmer stemmer= new englishStemmer();
        Set<String> tokenList = new HashSet<>();
        int count=0;
        for (String s: test){
            //System.out.println(s);
            s=s.replaceAll("[^a-zA-Z0-9 ]", "");
            stemmer.setCurrent(s);
            stemmer.stem();
            s= stemmer.getCurrent();
            if(s.length()>=3 && !stopwords.contains(s)){
                tokenList.add(s.toLowerCase());
                allTokens.add(s.toLowerCase());
                count+=1;
            }
        }
        //System.out.println("Improved: "+count + " words");
        return tokenList;
    }
    public void listStopWords() throws FileNotFoundException {
        File f= new File("stopwords.txt");

        Scanner sc = new Scanner(f);
        while (sc.hasNext()){
            stopwords.add(sc.next());
        }

    }



}

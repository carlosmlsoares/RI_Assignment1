import org.tartarus.snowball.SnowballStemmer;
import org.tartarus.snowball.ext.englishStemmer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Tokenizer_Improved2 {
    private Set<String> stopwords = new HashSet<>();

    public Tokenizer_Improved2() throws FileNotFoundException {
        listStopWords();
    }

    public Set<String> tokenize(String text){
        SnowballStemmer stemmer= new englishStemmer();
        Set<String> tokenList = new HashSet<>();
        int count=0;
        text=text.replaceAll("[^a-zA-Z0-9]", "");

        String[] initial= text.split(" ");

        for (String s: initial){
            stemmer.setCurrent(s);
            stemmer.stem();
            s= stemmer.getCurrent();
            if(s.length()>=3 && !stopwords.contains(s)){
                tokenList.add(s.toLowerCase());
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.tsv.*;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class TSVParser extends DocumentParser {

    private Tokenizer_Improved tokenizer;

    public TSVParser(String filename) {
        super(filename);
    }

    public void setTokenizer(Tokenizer_Improved tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Override
    public void readFile() throws IOException {
        PrintWriter writer = new PrintWriter("tokens.txt", "UTF-8");
        Scanner sc = new Scanner(new File(filename));
        sc.nextLine();

        while(sc.hasNextLine()){
            String line= sc.nextLine();
            String[] doc=line.split("\t");

            String content = doc[5]+" "+doc[12]+" "+doc[13];
            String[] toTokenize=content.split(" ");
            writer.println(++contador+":"+tokenizer.tokenize(toTokenize));
        }
        writer.close();

        Map <String,Map<String,Integer>> invertedIndex= new HashMap<>();

        sc.close();
        for (String s:tokenizer.getAllTokens()){

            sc= new Scanner(new File("tokens.txt"));
            Map<String,Integer> temp=new HashMap<>();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splitedLine = line.split(":");
                String docID = splitedLine[0];
                String second = splitedLine[1].replaceAll("[^a-zA-Z0-9 ]", "");

                ArrayList<String> tokens = new ArrayList<>(Arrays.asList(second.split(" ")));
                if (tokens.contains(s)) {
                    if (!temp.containsKey(docID)) {
                        temp.put(docID, 1);
                    } else {
                        System.out.println("incremented");
                        int cont=temp.get(docID);
                        System.out.println(cont);
                        temp.put(docID,cont);
                    }
                }
                invertedIndex.put(s,temp);

            }

        }



    for (String token: invertedIndex.keySet()){
            System.out.println(token + " -> "+invertedIndex.get(token) );
    }



}
}

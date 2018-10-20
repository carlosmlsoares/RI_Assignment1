/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Pedro
 */
public class TestFile {
    public static void main(String[] args) throws FileNotFoundException {
        DocumentParser doc = new TSVParser(("sample_us.tsv"));
        //DocumentParser doc = new TSVParser(("sample_us_edited.tsv"));
        //DocumentParser doc = new TSVParser(("amazon_reviews_us_Watches_v1_00.tsv"));
        Tokenizer_Improved tokenizer=new Tokenizer_Improved();
        ((TSVParser) doc).setTokenizer(tokenizer);

        try {
            doc.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Pedro
 */
public abstract class DocumentParser {
    protected Map<Integer, Set<String>> docs;
    protected int contador;
    protected String filename;

    public DocumentParser(String filename) {
        contador=0;
        docs = new HashMap<>();
        this.filename = filename;
    }
    
    public abstract void readFile() throws IOException;
    
}

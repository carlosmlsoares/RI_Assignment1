import java.util.ArrayList;

public class Tokenizer {


    public Tokenizer(){

    }
    public ArrayList<String> tokenize(String text){
        ArrayList<String> tokenList = new ArrayList<>();
        int count=0;
        String[] initial= text.split("[\\s]+");
        for (String s: initial){
            if(s.length()>=3  && !isNumeric(s) && !tokenList.contains(s)){
                tokenList.add(s.toLowerCase());
                count+=1;
            }
        }
        System.out.println("Normal: "+count + " words");

        return tokenList;
    }


    public  boolean isNumeric(String str)
    {
        try{
            double aux = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe){return false;}

        return true;
    }



}

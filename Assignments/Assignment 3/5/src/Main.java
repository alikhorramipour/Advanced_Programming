import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int lines = 0, words = 0, chars = 0;
        Scanner inputStream = new Scanner(System.in);
        ArrayList str = new ArrayList<String>();
        Iterator<String> it = str.iterator();
        String input;
        for(int i = 0; true; i++){
            input = inputStream.nextLine();
            if(input.isEmpty())   break;
            str.add(input);
        }
        lines = str.size();
        words = str.size();
        for(int i = 0; i < str.size(); i++){
            String stringTemp = str.get(i).toString();
            char[] charTemp = stringTemp.toCharArray();
            chars += charTemp.length;
            for(int j = 0; j < charTemp.length; j++){
                if(charTemp[j] == ' '){
                    chars --;
                    words ++;
                }
            }
        }
        boolean[] printingElements = {false, false, false};
        for(int i = 0; i < args.length; i++){
            input = args[0];
            if (input.equals("-l") || input.equals("--lines"))  printingElements[0] = true;
            if (input.equals("-w") || input.equals("--words"))  printingElements[1] = true;
            if (input.equals("-c") || input.equals("--chars"))  printingElements[2] = true;
        }
        if ( (printingElements[0] == printingElements[1]) && (printingElements[1] == printingElements[2]) && (printingElements[0] == false) )
            System.out.println(lines + " " + words + " " + chars);
        else if ( (printingElements[0] == true) )
            System.out.print(lines);
        else if ( (printingElements[1] == true) )
            System.out.print(words);
        else if ( (printingElements[2] == true) )
            System.out.print(chars);
    }
}

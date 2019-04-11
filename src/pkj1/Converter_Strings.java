package pkj1;

import java.util.ArrayList;

public class Converter_Strings extends files {

    String stringConverter(String A){
        String temp = new String();
        ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
        AList = ReadFile("users.txt");
//        System.out.println(A);
        for (int i = 0; i < AList.size();i++)
        {
            if (AList.get(i).get(0).equals(A))
            {
                temp=AList.get(i).get(2);

            }
        }
        System.out.println(temp);
        return temp;
    }

}

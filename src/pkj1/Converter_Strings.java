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
    String stringConverter_Driver(String A){
        String temp = new String();
        if (A.equals("Ahmed"))
            temp = "0";
        else if (A.equals("Shawky"))
            temp = "1";
        else if (A.equals("Mohamed"))
            temp = "2";
        else if (A.equals("Yassa"))
            temp = "3";
        return temp;
    }

}

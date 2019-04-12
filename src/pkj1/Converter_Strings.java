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
       // System.out.println(temp);
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
    String stringConverter_Driver1(String A){
        String temp = new String();
        if (A.equals("0"))
            temp = "Ahmed";
        else if (A.equals("1"))
            temp = "Shawky";
        else if (A.equals("2"))
            temp = "Mohamed";
        else if (A.equals("3"))
            temp = "Yassa";
        return temp;
    }
    String search_Driver_from_file(String From,String To,String Vechile,String Price,String Seats){
        String fileName = "Trips.txt";
        ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
        String temp=null;
        AList = ReadFile(fileName);
        for (int i = 0; i < AList.size();i++)
        { if(AList.get(i).get(0).equals(From)&&AList.get(i).get(1).equals(To)&&AList.get(i).get(2).equals(Vechile)&&AList.get(i).get(3).equals(Price)&&AList.get(i).get(4).equals(Seats))
            temp = AList.get(i).get(5);
        }
        return stringConverter_Driver1(temp);
    }
    String search_Driver_from_file1(String From,String To,String Vechile,String Price,String Seats){
        String fileName = "Trips_external.txt";
        ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
        String temp=null;
        AList = ReadFile(fileName);
        for (int i = 0; i < AList.size();i++)
        { if(AList.get(i).get(0).equals(From)&&AList.get(i).get(1).equals(To)&&AList.get(i).get(2).equals(Vechile)&&AList.get(i).get(3).equals(Price)&&AList.get(i).get(4).equals(Seats))
            temp = AList.get(i).get(5);
        }
        return stringConverter_Driver1(temp);
    }


}

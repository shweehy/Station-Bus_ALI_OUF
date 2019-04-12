package pkj1;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;

public class Add_User extends Check_Login {
    ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
    public void OverWrite(String fileName,String Name,String Pass) throws Exception {
        FileWriter fileWriter = new FileWriter(fileName,true);
        AList = ReadFile(fileName);
        int i = Integer.parseInt(AList.get(AList.size()-1).get(2));
        i++;
        fileWriter.write("\n"+Name+","+Pass+","+i);
        fileWriter.close();
    }
    public void Add_trip(String To,String From,String Vechile,String Price,String Seats,String fileName,String Driver) {
//            String fileName = "Trips.txt";
        try {
            FileWriter fileWriter = new FileWriter(fileName,true);
            fileWriter.write("\n"+To+","+From+","+Vechile+","+Price+","+Seats+","+Driver);
            fileWriter.close();
        }
        catch (Exception e){

        }

    }
    void Delete_Item(String From,String To,String Vechile,String Price,String Seats,String fileName){
//        String fileName = "Trips.txt";
        ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
        AList = ReadFile(fileName);
        for (int i = 0; i < AList.size();i++)
        { if(AList.get(i).get(0).equals(From)&&AList.get(i).get(1).equals(To)&&AList.get(i).get(2).equals(Vechile)&&AList.get(i).get(3).equals(Price)&&AList.get(i).get(4).equals(Seats))
                AList.remove(i);

        }
        try {
            FileWriter fileWriter = new FileWriter(fileName, false) ;
            for (int i = 0; i < AList.size(); i++) {
                for(int j =0; j<AList.get(i).size();j++) {

                    fileWriter.write(AList.get(i).get(j)+",");


                }
                if (i!=AList.size()-1)
                fileWriter.write("\n");

            }
            fileWriter.close();


        }
        catch (Exception e){
            System.out.println("Eror1111r");
        }

    }

    public void Add_trip1(String To,String From,String Vechile,String Price,String Seats,String Id,String Driver,String fileName) {
//            String fileName = "Trips.txt";
        try {
            FileWriter fileWriter = new FileWriter(fileName,true);
            fileWriter.write("\n"+To+","+From+","+Vechile+","+Price+","+Seats+","+Id+","+Driver);
            fileWriter.close();
        }
        catch (Exception e){

        }

    }
    void Delete_Item_Reserved(String From,String To,String Vechile,String Price,String Seats,String User,String fileName){
        //String fileName = "Reserved.txt";
        ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
        Converter_Strings xo = new Converter_Strings();

        AList = ReadFile(fileName);
        for (int i = 0; i < AList.size();i++)
        { if(AList.get(i).get(0).equals(From)&&AList.get(i).get(1).equals(To)&&AList.get(i).get(2).equals(Vechile)&&AList.get(i).get(3).equals(Price)&&AList.get(i).get(4).equals(Seats)&&AList.get(i).get(5).equals(xo.stringConverter(User)))
        {AList.remove(i);
        break;
        }
        }
        try {
            FileWriter fileWriter = new FileWriter(fileName, false) ;
            for (int i = 0; i < AList.size(); i++) {
                for(int j =0; j<AList.get(i).size();j++) {

                    fileWriter.write(AList.get(i).get(j)+",");


                }
                if (i!=AList.size()-1)
                    fileWriter.write("\n");

            }
            fileWriter.close();


        }
        catch (Exception e){
            System.out.println("Eror1111r");
        }

    }
    void Seats(String From,String To,String Vechile,String Price,String Seats/*,String User*/,String fileName){
        //String fileName = "Reserved.txt";
        ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
            int i;
        int a;
        AList = ReadFile(fileName);
        for (i= 0; i < AList.size();i++)
        { if(AList.get(i).get(0).equals(From)&&AList.get(i).get(1).equals(To)&&AList.get(i).get(2).equals(Vechile)/*&&AList.get(i).get(3).equals(Price)&&AList.get(i).get(4).equals(Seats)*/)
        {
            break;
        }

        }
         a = Integer.parseInt(AList.get(i).get(4));
        a--;
        AList.get(i).remove(4) ;
        AList.get(i).add(4, String.valueOf(a)) ;


        try {
            FileWriter fileWriter = new FileWriter(fileName, false) ;
            for (int k= 0; k < AList.size(); k++) {
                for(int j =0; j<AList.get(k).size();j++) {

                    fileWriter.write(AList.get(k).get(j)+",");


                }
                if (k!=AList.size()-1)
                    fileWriter.write("\n");

            }
            fileWriter.close();


        }
        catch (Exception e){
            System.out.println("Eror1111r");
        }
    }
    void Seats_add(String From,String To,String Vechile/*,String PriceString Seats*/,String fileName){
        //String fileName = "Reserved.txt";
        ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
        int i;
        int a;
        AList = ReadFile(fileName);
        for (i= 0; i < AList.size();i++)
        { if(AList.get(i).get(0).equals(From)&&AList.get(i).get(1).equals(To)&&AList.get(i).get(2).equals(Vechile)/*&&AList.get(i).get(3).equals(Price)&&AList.get(i).get(4).equals(Seats)*/)
        {
            break;
        }

        }
        a = Integer.parseInt(AList.get(i).get(4));
        a++;
        AList.get(i).remove(4) ;
        AList.get(i).add(4, String.valueOf(a)) ;


        try {
            FileWriter fileWriter = new FileWriter(fileName, false) ;
            for (int k= 0; k < AList.size(); k++) {
                for(int j =0; j<AList.get(k).size();j++) {

                    fileWriter.write(AList.get(k).get(j)+",");


                }
                if (k!=AList.size()-1)
                    fileWriter.write("\n");

            }
            fileWriter.close();


        }
        catch (Exception e){
            System.out.println("Eror1111r");
        }
    }
}

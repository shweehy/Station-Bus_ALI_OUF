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
    public void Add_trip(String To,String From,String Vechile,String Price,String Seats) {
            String fileName = "Trips.txt";
        try {
            FileWriter fileWriter = new FileWriter(fileName,true);
            fileWriter.write("\n"+To+","+From+","+Vechile+","+Price+","+Seats);
            fileWriter.close();
        }
        catch (Exception e){

        }

    }
    void Delete_Item(String From,String To,String Vechile,String Price,String Seats){
        String fileName = "Trips.txt";
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



}

package pkj1;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;


abstract public class files implements Filess_Interface{
//    public void OverWrite(String fileName) throws Exception {
//        FileWriter fileWriter = new FileWriter(fileName,true);
//        fileWriter.write("\n"+"Ahmed,123,14");
//        fileWriter.close();
//    }


    public ArrayList ReadFile(String fileName) {
        ArrayList<ArrayList<String>> AList =
                new ArrayList<ArrayList<String>>();

        String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader =new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String REGEX = "[,\n]+";
                Pattern pattern = Pattern.compile(REGEX);
                int limit = 0;
                String tmp[] = pattern.split(line,limit);
                ArrayList<String> A = new ArrayList<String>();
                for (int i = 0; i < tmp.length; i++ ) {

                    A.add(tmp[i]);
                }
                AList.add(A);
            }

            // Always close files.
            bufferedReader.close();

        } catch (Exception ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        return AList;
    }
//    void deleteInFIles(String fileName,int index){
//        ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
//        AList = ReadFile(fileName);
//        AList.remove(index);
//        try {
//            FileWriter fileWriter = new FileWriter(fileName, false) ;
//                for (int i = 0; i < AList.size(); i++) {
//                    for(int j =0; j<AList.get(i).size();j++) {
//
//                            fileWriter.write(AList.get(i).get(j)+",");
//
//                    }
//                    fileWriter.write("\n");
//                }
//                fileWriter.close();
//
//
//        }
//        catch (Exception e){
//            System.out.println("Eror1111r");
//        }
//    }
  public LinkedList Searched (String fileName, String Name){

      LinkedList<Integer> object = new LinkedList<Integer>();

      ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
        AList = ReadFile(fileName);
      int Searched_index []=new int[AList.size()];

        for(int i =0; i < AList.size();i++)
        {
            if (AList.get(i).get(0).equals(Name))
                object.add(i);

        }


      return object;
  }
    public String Searched_iD (String fileName,String id){
        boolean f1=false;
        ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
        String Searched = new String();
        AList = ReadFile(fileName);

        for (int i = 0; i < AList.size();i++)
        {   if (AList.get(i).get(2).equals(id)){
            Searched= AList.get(i).get(0);
            f1=true;
        }

        }
        if (f1==false) {
            Searched = "not found";
        }
        return Searched;

    }

}
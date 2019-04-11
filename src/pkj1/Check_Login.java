package pkj1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Check_Login extends files{
    int id;

    public int getId() {
        return id;
    }

    int CheckAbility(String fileName, String Name, String Pass){
         LinkedList<Integer> object = new LinkedList<Integer>();
         object = super.Searched(fileName,Name);
         if(object.size()==0)
             return -1;
         else if(object.size()==1)
         {
             ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
             AList = ReadFile(fileName);
             if((AList.get(object.get(0)).get(0).equals(Name))&&(AList.get(object.get(0)).get(1).equals(Pass)))
             {
                 id= Integer.parseInt(AList.get(object.get(0)).get(2));
                 return 1;
             }
             else
                 return -2;
         }
         else {
             ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
             AList = ReadFile(fileName);
             for (int i = 0 ; i<object.size();i++){
                 if((AList.get(object.get(i)).get(0).equals(Name))&&(AList.get(object.get(i)).get(1).equals(Pass)))
                     return 1;
             }

         }
         return -2 ;
    }

}

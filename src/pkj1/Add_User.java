package pkj1;

import java.io.FileWriter;
import java.util.ArrayList;

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


}

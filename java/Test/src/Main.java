import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try{

            File file = new File("ddl.sql");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";

            String tableName = "";

            String unique = "";
            String seq = "";

            String ddl = "";

            String alter = "";
            String create = "";
            String pk = "";

            boolean plag = false;
            int pkPlag = 0;

            // 1. 파일 객체 생성
            File newFile = new File("newDDL.txt");

            // 2. 파일 존재여부 체크 및 생성
            if (!newFile.exists()) {
                newFile.createNewFile();
            }

            // 3. Buffer를 사용해서 File에 write할 수 있는 BufferedWriter 생성
            FileWriter fw = new FileWriter(newFile);
            BufferedWriter writer = new BufferedWriter(fw);

            while((line = bufReader.readLine()) != null){
                String alterTemp = "";
                String createTemp = "";

                if(line.contains("PRIMARY KEY")){
                    String pkTemp = "";

                    String[] split = line.split(" ");
                    for(int i = 0; i < split.length; i++) {
                        // ALTER TABLE
                        if(split[i].equals("ALTER") && split[i+1].equals("TABLE")){
                            split[i+2] = "TIBERO." + split[i+2];

                        }
                    }

                    pkTemp += "\n-----------------------------------------" + tableName + " PK SETTING" + "-----------------------------------------\n";
                    pkTemp += String.join(" ", split);
                    pkTemp += "\n" + bufReader.readLine();
                    pkTemp += "\n" + bufReader.readLine() + "\n";
                    pk += pkTemp;

                    continue;
                }


                String[] split = line.split(" ");
                for(int i = 0; i < split.length; i++) {

                    // Table 이름
                    if(split[i].equals("CREATE") && split[i+1].equals("TABLE")){
                        tableName = split[i+2].substring(1, split[i+2].length()-1);
                        split[i+2] = "TIBERO." + split[i+2];

                        createTemp += "\n-----------------------------------------" + "CREATE " + tableName + "-----------------------------------------\n";
                        alterTemp = "";
                        plag = false;
                    }

                    // COMMENT TIBERO 명시
                    if(split[i].equals("COMMENT") && split[i+1].equals("ON") && split[i+2].equals("COLUMN")){
                        split[i+3] = "TIBERO." + split[i+3];
                    }

                    if(split[i].equals("ALTER")) {
                        createTemp = "";
                        plag = true;
                        alterTemp += "\n-----------------------------------------" + tableName + " FK SETTING" + "-----------------------------------------\n";
                    }

                    // ALTER TABLE
                    if(split[i].equals("ALTER") && split[i+1].equals("TABLE")){
                        split[i+2] = "TIBERO." + split[i+2];

                    }

                    // REFERENCES
                    if(split[i].equals("REFERENCES")){
                        split[i+1] = "TIBERO." + split[i+1];
                    }

                    // SEQUENCE 추가
                    if(i < split.length-1 && split[i].equals("IS") && split[i+1].equals("\'SEQUENCE\';")){
                        System.out.println(tableName);
                        seq += "\nCREATE SEQUENCE TIBERO.\"" + tableName + "_SEQ\" INCREMENT BY 1 START WITH 1 ORDER;";
                    }


                    if(plag) {
                        alterTemp += split[i] + " ";
                    }

                    if(!plag) {
                        createTemp += split[i] + " ";
                    }

                }
                if(createTemp.length() >= 1) {
                    create += "\n" + createTemp;
                }
                if(alterTemp.length() >= 1) {
                    alter += "\n" + alterTemp;
                }

            }

            ddl += create;
            ddl += pk;
            ddl += alter;
            ddl += "\n-----------------------------------------" + "SEQUENCE SETTING " + "-----------------------------------------\n";
            ddl += seq;

            System.out.println("+++++++++++++++++++++++++++");
            System.out.println(ddl);


            // 4. 파일에 쓰기
            writer.write(ddl);
            // 5. BufferedWriter close
            writer.close();


            bufReader.close();
        }catch (FileNotFoundException e) {
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
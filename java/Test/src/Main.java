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

            File file = new File("temp.sql");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";

            String tableName = "-1";

            String unique = "";
            String seq = "";

            String ddl = "";

            String alter = "";
            String create = "";
            String pk = "";

            String tempTableName = "-2";

            String tableComment = "\n\n\n-----------------------------------------" + "TABLE COMMENT" + "-----------------------------------------\n";

            boolean plag = false;
            int pkPlag = 0;

            // 1. 파일 객체 생성
            File newFile = new File("ddl.sql");

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
                            split[i+2] = "FINTECH." + split[i+2];

                        }
                    }

                    pkTemp += "\n-----------------------------------------" + tableName + " PK SETTING" + "-----------------------------------------\n";
                    pkTemp += String.join(" ", split) + "\n";
                    while(true){
                        line = bufReader.readLine();
                        pkTemp += line + "\n";
                        if(line.contains(");")){
                            break;
                        }
                    }
                    pk += pkTemp;

                    continue;
                }


                String[] split = line.split(" ");
                for(int i = 0; i < split.length; i++) {

                    // Table 이름
                    if(split[i].equals("CREATE") && split[i+1].equals("TABLE")){
                        tempTableName = split[i+2].substring(1, split[i+2].length()-1);
                        split[i+2] = "FINTECH." + split[i+2];

                        createTemp += "\n-----------------------------------------" + "CREATE " + tempTableName + "-----------------------------------------\n";
                        alterTemp = "";
                        plag = false;
                    }

                    if(!tempTableName.equals(tableName) && !tempTableName.equals("-2")) {
                        tableComment += "\nCOMMENT ON TABLE FINTECH.\"" +  tempTableName + "\" IS \'TABLE COMMENT 작성\';";
                        tableName = tempTableName;
                    }

                    // COMMENT FINTECH 명시
                    if(split[i].equals("COMMENT") && split[i+1].equals("ON") && split[i+2].equals("COLUMN")){
                        split[i+3] = "FINTECH." + split[i+3];
                    }

                    if(split[i].equals("ALTER")) {
                        createTemp = "";
                        plag = true;
                        alterTemp += "\n-----------------------------------------" + tempTableName + " FK SETTING" + "-----------------------------------------\n";
                    }

                    // ALTER TABLE
                    if(split[i].equals("ALTER") && split[i+1].equals("TABLE")){
                        split[i+2] = "FINTECH." + split[i+2];

                    }

                    // REFERENCES
                    if(split[i].equals("REFERENCES")){
                        split[i+1] = "FINTECH." + split[i+1];
                    }

                    // SEQUENCE 추가
                    if(i < split.length-1 && split[i].equals("IS") && split[i+1].equals("\'SEQUENCE\';")){
                        seq += "\nCREATE SEQUENCE FINTECH.\"" + tempTableName + "_SEQ\" INCREMENT BY 1 START WITH 1 ORDER;";
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
            ddl += tableComment;

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
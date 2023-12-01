import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Alter {
    public static void main(String[] args) {
        try{

            File file = new File("table.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            String alterTemp = "";
            String triger = "";


            // 1. 파일 객체 생성
            File newFile = new File("alter.sql");

            File newTriggerFile = new File("trigger.sql");

            // 2. 파일 존재여부 체크 및 생성
            if (!newFile.exists()) {
                newFile.createNewFile();
            }

            if (!newTriggerFile.exists()) {
                newTriggerFile.createNewFile();
            }

            // 3. Buffer를 사용해서 File에 write할 수 있는 BufferedWriter 생성
            FileWriter fw = new FileWriter(newFile);
            BufferedWriter writer = new BufferedWriter(fw);

            FileWriter triggerFw = new FileWriter(newTriggerFile);
            BufferedWriter triggerWriter = new BufferedWriter(triggerFw);

            while((line = bufReader.readLine()) != null) {

                alterTemp += "\nALTER TABLE FINTECH.\"" + line
                    + "\" MODIFY (CREATED_AT DEFAULT CURRENT_TIMESTAMP AT TIME ZONE 'Asia/Seoul');";
                alterTemp += "\nALTER TABLE FINTECH.\"" + line
                    + "\" MODIFY (UPDATED_AT DEFAULT CURRENT_TIMESTAMP AT TIME ZONE 'Asia/Seoul');\n";

                triger +=
                    "\nCREATE TRIGGER FINTECH." + line + "_UPDATED_AT_TRIGGER\n"
                        + "BEFORE UPDATE ON FINTECH." + line + "\n"
                        + "    FOR EACH ROW\n"
                        + "BEGIN\n"
                        + "    :NEW.UPDATED_AT := CURRENT_TIMESTAMP AT TIME ZONE 'Asia/Seoul';\n"
                        + "END;\n";

                File updateTriggerFile = new File(line + "UPDATED_AT_TRIGGER.sql");
                FileWriter updateTriggerFW = new FileWriter(updateTriggerFile);
                BufferedWriter updateTriggerWriter = new BufferedWriter(updateTriggerFW);

                String tempUpdatedAtTrigger = "\nCREATE TRIGGER FINTECH." + line + "_UPDATED_AT_TRIGGER\n"
                    + "BEFORE UPDATE ON FINTECH." + line + "\n"
                    + "    FOR EACH ROW\n"
                    + "BEGIN\n"
                    + "    :NEW.UPDATED_AT := CURRENT_TIMESTAMP AT TIME ZONE 'Asia/Seoul';\n"
                    + "END;\n";

                updateTriggerWriter.write(tempUpdatedAtTrigger);
                updateTriggerWriter.close();

            }

            System.out.println(alterTemp);
            System.out.println(triger);




            // 4. 파일에 쓰기
            writer.write(alterTemp);
            triggerWriter.write(triger);
            // 5. BufferedWriter close
            writer.close();
            triggerWriter.close();


            bufReader.close();
        }catch (FileNotFoundException e) {
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}

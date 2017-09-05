package bao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import bean.*;
import dao.*;

class backUpFrame {
    boolean backUp(){
        java.util.List<person> list = personDao.queryAll();
        try{
            FileWriter fw = new FileWriter("E:\\IdeaProjects\\myAddressBook\\联系人备份.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            int i = 0;
            bw.write("姓名\t手机号码\t邮箱");
            bw.newLine();
            while(i < list.size()) {
                bw.write(list.get(i).getName() + "\t" + list.get(i).getPhone() + "\t" + list.get(i).getMail());
                bw.newLine();
                i++;
            }
            bw.flush();
            bw.close();
            fw.close();
            return true;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

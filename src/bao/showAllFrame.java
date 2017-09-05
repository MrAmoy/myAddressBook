package bao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import bean.*;
import dao.*;

public class showAllFrame extends JFrame implements ActionListener {
    showAllFrame(){
        setTitle("显示所有记录");
        JTable tb;

        java.util.List<person> list = personDao.queryAll();
        Object[][] tbData = new Object[list.size()][3];
        for(int i = 0; i < list.size();i++){
            person p = list.get(i);
            tbData[i][0] = p.getName();
            tbData[i][1] = p.getPhone();
            tbData[i][2] = p.getMail();
        }
        Object[] columnTitle = {"姓名","手机号码","邮箱"};
        tb = new JTable(tbData,columnTitle);
        add(new JScrollPane(tb));

        validate();
        setBounds(730, 370, 450, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){

    }
}

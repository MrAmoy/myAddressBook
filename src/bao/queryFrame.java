package bao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.*;
import bean.*;

public class queryFrame extends JFrame implements ActionListener {
    private JLabel lb1,lb2,lb3;
    private JTextField text1,text2,text3;
    private JButton bt1,bt2;
    queryFrame() {
        setTitle("查询记录");
        setLayout(new GridLayout(4,2,4,2));
        lb1 = new JLabel("请输入要查找人的姓名：");
        add(lb1);
        text1 = new JTextField();
        add(text1);
        lb2 = new JLabel("该联系人的电话号码是：");
        add(lb2);
        text2 = new JTextField();
        add(text2);
        lb3 = new JLabel("该联系人的电子邮箱是：");
        add(lb3);
        text3 = new JTextField();
        add(text3);
        bt1 = new JButton("查找");
        add(bt1);
        bt2 = new JButton("清空");
        add(bt2);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        validate();
        setBounds(750, 400, 450, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("查找")){
            queryPerson(text1.getText());
        }
        else if(cmd.equals("清空")){
            text1.setText("");
            text2.setText("");
            text3.setText("");
        }
    }
    private void queryPerson(String name) {
        java.util.List<person> list = personDao.queryAll();
        for(person p: list) {
            if(p.getName().equals(name)){
                text2.setText(p.getPhone());
                text3.setText(p.getMail());
                break;
            }
            text2.setText("没有此联系人电话号码！");
            text3.setText("没有此联系人电子邮箱！");
        }
    }
}

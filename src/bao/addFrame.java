package bao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import bean.*;
import dao.*;

public class addFrame extends JFrame implements ActionListener {
    private JLabel lb1,lb2,lb3;
    private JTextField text1,text2,text3;
    private JButton bt1,bt2;
    addFrame() {
        setTitle("添加记录");
        setLayout(new GridLayout(4,2,4,2));
        lb1 = new JLabel("请输入联系人姓名：");
        add(lb1);
        text1 = new JTextField();
        add(text1);
        lb2 = new JLabel("请输入联系人电话号码：");
        add(lb2);
        text2 = new JTextField();
        add(text2);
        lb3 = new JLabel("请输入联系人电子邮箱：");
        add(lb3);
        text3 = new JTextField();
        add(text3);
        bt1 = new JButton("添加");
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
        if(cmd.equals("添加")){
            addPerson(new person(text1.getText(),text2.getText(),text3.getText()));
        }
        else if(cmd.equals("清空")){
            text1.setText("");
            text2.setText("");
            text3.setText("");
        }
    }
    private void addPerson(person p) {
        if(personDao.insert(p)){
            JOptionPane.showMessageDialog(null,"已添加！","提示",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,"添加失败！","提示",JOptionPane.ERROR_MESSAGE);
        }
    }
}

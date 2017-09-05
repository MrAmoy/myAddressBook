package bao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import bean.*;
import dao.*;

public class deleteFrame extends JFrame implements ActionListener {
    private JLabel lb1;
    private JTextField text1;
    private JButton bt1,bt2;
    deleteFrame() {
        setTitle("删除记录");
        setLayout(new GridLayout(2,2,4,4));
        lb1 = new JLabel("请输入要删除的联系人姓名：");
        add(lb1);
        text1 = new JTextField();
        add(text1);
        bt1 = new JButton("删除");
        add(bt1);
        bt2 = new JButton("清空");
        add(bt2);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        validate();
        setBounds(750, 400, 400, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("删除")){
            deletePerson(new person(text1.getText()));
        }
        else if(cmd.equals("清空")){
            text1.setText("");
        }
    }
    private void deletePerson(person p) {
        if(personDao.delete(p)){
            JOptionPane.showMessageDialog(null,"已删除！","提示",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,"没有找到要删除的联系人！","提示",JOptionPane.ERROR_MESSAGE);
        }
    }
}

package bao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import bean.*;
import dao.*;

public class deleteFrame extends JFrame implements ActionListener {
    private JTextField text1;

    deleteFrame() {
        setTitle("删除记录");
        setLayout(new GridLayout(2,2,4,4));
        JLabel lb1 = new JLabel("请输入要删除的联系人姓名：", JLabel.CENTER);
        lb1.setFont(new Font("微软雅黑",Font.PLAIN,14));
        add(lb1);
        text1 = new JTextField();
        text1.setFont(new Font("微软雅黑",Font.PLAIN,14));
        add(text1);
        JButton bt1 = new JButton("删除");
        bt1.setFont(new Font("微软雅黑",Font.PLAIN,16));
        add(bt1);
        JButton bt2 = new JButton("清空");
        bt2.setFont(new Font("微软雅黑",Font.PLAIN,16));
        add(bt2);
        //为两个按钮添加事件监听
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        //为删除按钮添加按键监听器
        text1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                deletePerson();
            }
        });
        // 初始化窗口
        validate();
        setBounds(750, 400, 400, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("删除")){
            deletePerson();
        }
        else if(cmd.equals("清空")){
            text1.setText("");
        }
    }
    private void deletePerson() {
        person p = new person(text1.getText());
        if(personDao.delete(p)){
            JOptionPane.showMessageDialog(null,"删除成功！","提示",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,"没有找到要删除的联系人！","提示",JOptionPane.ERROR_MESSAGE);
        }
    }
}

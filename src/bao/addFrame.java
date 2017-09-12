package bao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import bean.*;
import dao.*;

public class addFrame extends JFrame implements ActionListener {
    private JTextField text1,text2,text3;

    addFrame() {
        setTitle("添加记录");
        setLayout(new GridLayout(4,2,4,2));
        JLabel lb1 = new JLabel("请输入联系人姓名：", JLabel.CENTER);
        lb1.setFont(new Font("微软雅黑",Font.PLAIN,14));
        add(lb1);
        text1 = new JTextField();
        text1.setFont(new Font("微软雅黑",Font.PLAIN,14));
        add(text1);
        JLabel lb2 = new JLabel("请输入联系人电话号码：", JLabel.CENTER);
        lb2.setFont(new Font("微软雅黑",Font.PLAIN,14));
        add(lb2);
        text2 = new JTextField();
        text2.setFont(new Font("微软雅黑",Font.PLAIN,14));
        add(text2);
        JLabel lb3 = new JLabel("请输入联系人电子邮箱：", JLabel.CENTER);
        lb3.setFont(new Font("微软雅黑",Font.PLAIN,14));
        add(lb3);
        text3 = new JTextField();
        text3.setFont(new Font("微软雅黑",Font.PLAIN,14));
        add(text3);
        JButton bt1 = new JButton("添加");
        bt1.setFont(new Font("微软雅黑",Font.PLAIN,16));
        add(bt1);
        JButton bt2 = new JButton("清空");
        bt2.setFont(new Font("微软雅黑",Font.PLAIN,16));
        add(bt2);
        //添加事件监听
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        //为3个文本框按钮添加按键监听器
        text1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    addPerson();
            }
        });
        text2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    addPerson();
            }
        });
        text3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    addPerson();
            }
        });
        //初始化窗口
        validate();
        setBounds(750, 400, 470, 230);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("添加")) {
            addPerson();
        } else if(cmd.equals("清空")){
            text1.setText("");
            text2.setText("");
            text3.setText("");
        } else if(cmd.equals("取消")) {
            setVisible(false);
        }
    }
    private void addPerson() {
        person p;
        if(text1.getText().equals("") || text2.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"请至少输入联系人姓名和电话号码！","提示",JOptionPane.INFORMATION_MESSAGE);
        } else {
            p = new person(text1.getText(), text2.getText(), text3.getText());
            if(personDao.insert(p)) {
                JOptionPane.showMessageDialog(null, "已添加！", "提示", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null,"添加失败！","提示",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

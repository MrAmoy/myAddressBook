package bao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import dao.*;
import bean.*;

public class queryFrame extends JFrame implements ActionListener {
    private JTextField text1;
    private JLabel lb1,lb2,lb3,lb4,lb5,lb6;

    queryFrame() {
        setTitle("查询记录");
        setLayout(new BorderLayout()/*new GridLayout(4,2,4,2)*/);

        JLabel lb = new JLabel("请输入要查找人的姓名：", JLabel.CENTER);
        lb.setFont(new Font("微软雅黑",Font.PLAIN,14));

        text1 = new JTextField(10);
        text1.setFont(new Font("微软雅黑",Font.PLAIN,16));

        JButton bt1 = new JButton("查找");
        bt1.setFont(new Font("微软雅黑",Font.PLAIN,16));
        bt1.setPreferredSize(new Dimension(100,40));

        JPanel jp1 = new JPanel();
        jp1.add(lb);
        jp1.add(text1);
        jp1.add(bt1);
        add(jp1,BorderLayout.NORTH);

        lb1 = new JLabel("", JLabel.CENTER);
        lb1.setFont(new Font("微软雅黑",Font.PLAIN,14));

        lb2 = new JLabel("", JLabel.CENTER);
        lb2.setFont(new Font("微软雅黑",Font.PLAIN,14));

        lb3 = new JLabel("",JLabel.CENTER);
        lb3.setFont(new Font("微软雅黑",Font.PLAIN,14));

        lb4 = new JLabel("",JLabel.CENTER);
        lb4.setFont(new Font("微软雅黑",Font.PLAIN,14));

        lb5 = new JLabel("",JLabel.CENTER);
        lb5.setFont(new Font("微软雅黑",Font.PLAIN,14));

        lb6 = new JLabel(  "",JLabel.CENTER);
        lb6.setFont(new Font("微软雅黑",Font.PLAIN,14));

        JPanel jp2 = new JPanel();
        jp2.setLayout(new GridLayout(2,3));
        jp2.add(lb1);
        jp2.add(lb2);
        jp2.add(lb3);
        jp2.add(lb4);
        jp2.add(lb5);
        jp2.add(lb6);

        add(jp2,BorderLayout.CENTER);

        JButton bt2 = new JButton("清空");
        bt2.setFont(new Font("微软雅黑",Font.PLAIN,16));
        bt2.setPreferredSize(new Dimension(100,40));

        JButton bt3 = new JButton("关闭");
        bt3.setFont(new Font("微软雅黑",Font.PLAIN,16));
        bt3.setPreferredSize(new Dimension(100,40));

        JPanel jp3 = new JPanel();
        jp3.add(bt2);
        jp3.add(bt3);
        add(jp3,BorderLayout.SOUTH);

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);

        text1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    queryPerson(text1.getText());
                }
            }
        });

        validate();
        setBounds(700, 440, 500, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("查找")) {
            queryPerson(text1.getText());
        }
        else if(cmd.equals("清空")){
            text1.setText("");
            lb1.setText("");
            lb2.setText("");
            lb3.setText("");
            lb4.setText("");
            lb5.setText("");
            lb6.setText("");
        } else if(cmd.equals("关闭")){
            setVisible(false);
        }
    }
    private void queryPerson(String name) {
        //整数a用于判断是否查询到信息，0否，1是
        int a = 0;
        List<person> list = personDao.queryAll();
        for(person p: list) {
            if(p.getName().equals(name)){
                lb1.setText("姓名");
                lb2.setText("电话号码");
                lb3.setText("电子邮箱");
                lb4.setForeground(new Color(0,0,255));
                lb5.setForeground(new Color(0,0,255));
                lb6.setForeground(new Color(0,0,255));
                lb4.setText(p.getPhone());
                lb5.setText(p.getMail());
                lb6.setText(p.getMail());
                a = 1;
                break;
            }
        }
        if(name.equals("")) {
            JOptionPane.showMessageDialog(null,"请输入姓名！","提示",JOptionPane.INFORMATION_MESSAGE);
        } else if(a == 0) {
            JOptionPane.showMessageDialog(null,"没有此联系人！","提示",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

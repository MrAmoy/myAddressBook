package bao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import bean.*;
import dao.*;

public class delete2Frame extends JFrame implements ActionListener {

    private JTextField jtf;
    private java.util.List<person> list;
    private JLabel lb1,lb2,lb3,lb4,lb5,lb6;

    delete2Frame() {
        setTitle("删除记录");
        setLayout(new BorderLayout(30,5));
        //标签
        JLabel lb = new JLabel("输入要删除的联系人姓名：",JLabel.CENTER);
        lb.setFont(new Font("微软雅黑",Font.PLAIN,14));
        //文本框
        jtf = new JTextField(10);
        jtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    queryPerson(jtf.getText());
                }
            }
        });
        jtf.setFont(new Font("微软雅黑",Font.PLAIN,16));
        //查找按钮
        JButton bt1 = new JButton("查找");
        bt1.setFont(new Font("微软雅黑",Font.PLAIN,16));
        bt1.setPreferredSize(new Dimension(100,40));
        JPanel jp1 = new JPanel();
        jp1.add(lb);
        jp1.add(jtf);
        jp1.add(bt1);
        add(jp1,BorderLayout.NORTH);

        JPanel jpcenter = new JPanel();
        jpcenter.setLayout(new GridLayout(2,3));
        lb1 = new JLabel("",JLabel.CENTER);
        lb2 = new JLabel("",JLabel.CENTER);
        lb3 = new JLabel("",JLabel.CENTER);
        lb4 = new JLabel("",JLabel.CENTER);
        lb4.setForeground(new Color(0,0,255));
        lb5 = new JLabel("",JLabel.CENTER);
        lb5.setForeground(new Color(0,0,255));
        lb6 = new JLabel("",JLabel.CENTER);
        lb6.setForeground(new Color(0,0,255));
        jpcenter.add(lb1);
        jpcenter.add(lb2);
        jpcenter.add(lb3);
        jpcenter.add(lb4);
        jpcenter.add(lb5);
        jpcenter.add(lb6);
        add(jpcenter,BorderLayout.CENTER);

        JButton bt3 = new JButton("删除");
        bt3.setFont(new Font("微软雅黑",Font.PLAIN,16));
        bt3.setForeground(Color.red);
        bt3.setPreferredSize(new Dimension(100,40));
        JButton bt2 = new JButton("清空");
        bt2.setFont(new Font("微软雅黑",Font.PLAIN,16));
        bt2.setPreferredSize(new Dimension(100,40));
        JButton bt4 = new JButton("取消");
        bt4.setFont(new Font("微软雅黑",Font.PLAIN,16));
        bt4.setPreferredSize(new Dimension(100,40));
        JPanel jp2 = new JPanel();
        jp2.add(bt3);
        jp2.add(bt2);
        jp2.add(bt4);
        add(jp2,BorderLayout.SOUTH);

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);

        validate();
        setBounds(750, 400, 480, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("查找")) {
            queryPerson(jtf.getText());
        } else if(cmd.equals("删除")) {
            if(queryPerson(jtf.getText()) == 1) {
                deletePerson(jtf.getText());
            }
        } else if (cmd.equals("清空")) {
            jtf.setText("");
            lb1.setText("");
            lb2.setText("");
            lb3.setText("");
            lb4.setText("");
            lb5.setText("");
            lb6.setText("");
        } else if(cmd.equals("取消")) {
            this.setVisible(false);
        }
    }
    private int queryPerson(String name) {
        int a = 0;
        list = personDao.queryAll();
        for(person p: list) {
            if(p.getName().equals(name)) {
                lb1.setText("姓名");
                lb2.setText("电话");
                lb3.setText("邮箱");
                lb4.setText(p.getName());
                lb5.setText(p.getPhone());
                lb6.setText(p.getMail());
                a=1;
                break;
            }
        }
        if(name.equals("")) {
            JOptionPane.showMessageDialog(null,"请输入姓名！","提示",JOptionPane.INFORMATION_MESSAGE);
        } else if(a == 0) {
            JOptionPane.showMessageDialog(null,"没有此联系人！","提示",JOptionPane.INFORMATION_MESSAGE);
        }
        return a;
    }
    private void deletePerson(String name) {
        int m = JOptionPane.showConfirmDialog(null,"确认要删除吗？","提示",JOptionPane.YES_NO_OPTION);
        if(m == JOptionPane.YES_OPTION) {
            person p = new person(jtf.getText());
            if (personDao.delete(p)) {
                JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                /*jtf.setText("");
                lb1.setText("");
                lb2.setText("");
                lb3.setText("");
                lb4.setText("");
                lb5.setText("");
                lb6.setText("");*/
            } else {
                JOptionPane.showMessageDialog(null, "没有找到要删除的联系人！", "提示", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

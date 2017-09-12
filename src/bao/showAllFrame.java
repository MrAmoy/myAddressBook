package bao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bean.*;
import dao.*;

public class showAllFrame extends JFrame implements ActionListener {
    showAllFrame(){
        setTitle("显示所有记录");
        setLayout(new BorderLayout());
        JTable tb;
        try {
            java.util.List<person> list = personDao.queryAll();
            Object[][] tbData = new Object[list.size()][3];
            for (int i = 0; i < list.size(); i++) {
                person p = list.get(i);
                tbData[i][0] = p.getName();
                tbData[i][1] = p.getPhone();
                tbData[i][2] = p.getMail();
            }
            Object[] columnTitle = {"姓名", "手机号码", "邮箱"};
            tb = new JTable(tbData, columnTitle);
            tb.setFont(new Font("微软雅黑", Font.PLAIN, 14));
            tb.setRowHeight(30);
            tb.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
            add(new JScrollPane(tb),BorderLayout.CENTER);
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
        JButton bt = new JButton("关闭窗口");
        bt.setFont(new Font("微软雅黑",Font.PLAIN,16));
        bt.setPreferredSize(new Dimension(100,40));
        JPanel jp = new JPanel();
        jp.add(bt);
        add(jp,BorderLayout.SOUTH);

        bt.addActionListener(this);

        validate();
        setBounds(670, 370, 550, 320);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("关闭窗口")) {
            this.setVisible(false);
        }
    }
}

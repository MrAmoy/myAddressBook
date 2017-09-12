package bao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class mainFrame extends JFrame implements ActionListener {
    private JMenuBar mb;

    mainFrame(String title) {
        setTitle(title);
        //把菜单条添加到窗口中
        mb = new JMenuBar();
        JMenu style = new JMenu("外观风格");
        style.setFont(new Font("微软雅黑",Font.PLAIN,14));
        //菜单项："Metal风格"
        JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal风格");
        metalItem.setFont(new Font("微软雅黑",Font.PLAIN,14));
        metalItem.addActionListener(this);
        //菜单项："Nimbus风格"
        JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus风格");
        nimbusItem.setFont(new Font("微软雅黑",Font.PLAIN,14));
        nimbusItem.addActionListener(this);
        //菜单项："Windows风格"
        JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows风格");
        windowsItem.setFont(new Font("微软雅黑",Font.PLAIN,14));
        windowsItem.addActionListener(this);
        //菜单项："Windows经典风格"
        JRadioButtonMenuItem classicItem = new JRadioButtonMenuItem("Windows经典风格");
        classicItem.setFont(new Font("微软雅黑",Font.PLAIN,14));
        classicItem.addActionListener(this);
        //菜单项："Motif风格"
        JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif风格");
        motifItem.setFont(new Font("微软雅黑",Font.PLAIN,14));
        motifItem.addActionListener(this);
        ButtonGroup styleGroup = new ButtonGroup();
        styleGroup.add(metalItem);
        styleGroup.add(nimbusItem);
        styleGroup.add(windowsItem);
        styleGroup.add(classicItem);
        styleGroup.add(motifItem);
        //把菜单项添加到菜单
        style.add(metalItem);
        style.add(nimbusItem);
        style.add(windowsItem);
        style.add(classicItem);
        style.add(motifItem);
        //把菜单添加到菜单条
        mb.add(style);
        //设置容器的菜单条
        setJMenuBar(mb);
        //设置容器布局为Grid布局
        setLayout(new GridLayout(3, 2, 6, 4));
        JButton bt1 = new JButton("查询记录");
        bt1.setFont(new Font("微软雅黑",Font.PLAIN,20));
        add(bt1);
        JButton bt2 = new JButton("显示所有记录");
        bt2.setFont(new Font("微软雅黑",Font.PLAIN,20));
        add(bt2);
        JButton bt3 = new JButton("添加记录");
        bt3.setFont(new Font("微软雅黑",Font.PLAIN,20));
        add(bt3);
        JButton bt4 = new JButton("删除记录");
        bt4.setFont(new Font("微软雅黑",Font.PLAIN,20));
        add(bt4);
        JButton bt5 = new JButton("备份文件");
        bt5.setFont(new Font("微软雅黑",Font.PLAIN,20));
        add(bt5);
        JButton bt6 = new JButton("退出");
        bt6.setFont(new Font("微软雅黑",Font.PLAIN,20));
        add(bt6);

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        bt5.addActionListener(this);
        bt6.addActionListener(this);

        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            // 更新主窗口内顶级容器以及内部所有组件的UI
            SwingUtilities.updateComponentTreeUI(this.getContentPane());
            // 更新menubar菜单条以及内部所有组件的UI
            SwingUtilities.updateComponentTreeUI(mb);
        }catch (Exception e){
            e.printStackTrace();
        }
        validate();
        setBounds(630, 330, 600, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            switch (e.getActionCommand()) {
                case "Metal风格":
                    changeStyle(1);
                    break;
                case "Nimbus风格":
                    changeStyle(2);
                    break;
                case "Windows风格":
                    changeStyle(3);
                    break;
                case "Windows经典风格":
                    changeStyle(4);
                    break;
                case "Motif风格":
                    changeStyle(5);
                    break;
                case "查询记录":
                    new queryFrame();
                    break;
                case "显示所有记录":
                    new showAllFrame();
                    break;
                case "添加记录":
                    new addFrame();
                    break;
                case "删除记录":
                    new delete2Frame();
                    break;
                case "备份文件":
                    if(new backUpFrame().backUp()) {
                        JOptionPane.showMessageDialog(null,
                                "已备份至E:\\IdeaProjects\\myAddressBook\\联系人备份.txt",
                                "提示",JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "备份失败！",
                                "提示",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "退出":
                    System.exit(0);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void changeStyle(int flavor) throws Exception {
        switch (flavor) {
            // 设置Metal风格
            case 1:
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                break;
            // 设置Nimbus风格
            case 2:
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                break;
            // 设置Windows风格
            case 3:
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            // 设置Windows经典风格
            case 4:
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                break;
            // 设置Motif风格
            case 5:
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                break;
        }
        // 更新主窗口内顶级容器以及内部所有组件的UI
        SwingUtilities.updateComponentTreeUI(this.getContentPane());
        // 更新menubar菜单条以及内部所有组件的UI
        SwingUtilities.updateComponentTreeUI(mb);
    }
}


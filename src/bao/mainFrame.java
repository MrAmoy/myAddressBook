package bao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class mainFrame extends JFrame implements ActionListener {
    private JMenuBar menubar;
    private JMenu style;
    private ButtonGroup styleGroup;
    private JRadioButtonMenuItem metalItem, nimbusItem, windowsItem, classicItem, motifItem;
    private JButton bt1, bt2, bt3, bt4, bt5, bt6;

    mainFrame(String title) {
        setTitle(title);
        //把菜单条添加到窗口中
        menubar = new JMenuBar();
        style = new JMenu("外观风格");
        //菜单项："Metal风格"
        metalItem = new JRadioButtonMenuItem("Metal风格");
        metalItem.addActionListener(this);
        //菜单项："Nimbus风格"
        nimbusItem = new JRadioButtonMenuItem("Nimbus风格");
        nimbusItem.addActionListener(this);
        //菜单项："Windows风格"
        windowsItem = new JRadioButtonMenuItem("Windows风格");
        windowsItem.addActionListener(this);
        //菜单项："Windows经典风格"
        classicItem = new JRadioButtonMenuItem("Windows经典风格");
        classicItem.addActionListener(this);
        //菜单项："Motif风格"
        motifItem = new JRadioButtonMenuItem("Motif风格");
        motifItem.addActionListener(this);
        //添加到组
        styleGroup = new ButtonGroup();
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
        menubar.add(style);
        //设置容器的菜单条
        setJMenuBar(menubar);
        //设置容器布局为Grid布局
        setLayout(new GridLayout(3, 2, 6, 4));
        bt1 = new JButton("查询记录");
        add(bt1);
        bt2 = new JButton("显示所有记录");
        add(bt2);
        bt3 = new JButton("添加记录");
        add(bt3);
        bt4 = new JButton("删除记录");
        add(bt4);
        bt5 = new JButton("备份文件");
        add(bt5);
        bt6 = new JButton("退出");
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
            SwingUtilities.updateComponentTreeUI(menubar);
        }catch (Exception e){
            e.printStackTrace();
        }
        validate();
        setBounds(700, 350, 500, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                    new deleteFrame();
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
        SwingUtilities.updateComponentTreeUI(menubar);
    }
}


package  GUI;
import GUI.CustomerInfoManage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanInfoDel extends JPanel implements ActionListener {
    private JLabel Label_Title;
    private JLabel Label_ID_Del;
    private JButton Btn_Del;
    private JButton Btn_Close;
    private JTextField Tf_Id_Del;

    CustomerInfoManage CIFrame;

    public PanInfoDel(CustomerInfoManage parent)  {
        CIFrame = parent;
        InitGUI();
    }

    private void InitGUI()  {
        setLayout(null);
        setBounds(0,0,480,320);


        Label_Title = new JLabel("고객삭제");
        Label_Title.setBounds(0,0,480,40);
        Label_Title.setHorizontalAlignment(JLabel.CENTER);
        add(Label_Title);

        Label_ID_Del = new JLabel("ID");
        Label_ID_Del.setBounds(0,120,100,20);
        Label_ID_Del.setHorizontalAlignment(JLabel.CENTER);
        add(Label_ID_Del);

        Tf_Id_Del = new JTextField();
        Tf_Id_Del.setBounds(100,120,350,20);
        Tf_Id_Del.setEditable(true);
        add(Tf_Id_Del);

        Btn_Del = new JButton("삭제");
        Btn_Del.setBounds(100,250,70,20);
        Btn_Del.addActionListener(this);
        add(Btn_Del);

        Btn_Close = new JButton("취소");
        Btn_Close.setBounds(250,250,70,20);
        Btn_Close.addActionListener(this);
        add(Btn_Close);
    }
    public void actionPerformed(ActionEvent e)  {
        if (e.getSource() == Btn_Del)   {
            info_delete();
            this.setVisible(false);
            CIFrame.display("삭제");
        }
        if (e.getSource() == Btn_Close) {
            this.setVisible(false);
            CIFrame.display("인포메인");
        }
    }
    public void info_delete()  {

    }
}

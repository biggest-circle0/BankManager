package  GUI;
import GUI.CustomerInfoManage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanInfoRet extends JPanel implements ActionListener {
    private JLabel Label_Title;
    private JLabel Label_ID_Ret;
    private JLabel Label_PW_Ret;
    private JButton Btn_Ret;
    private JButton Btn_Close;
    private JTextField Tf_Id_Ret;
    private JTextField Tf_PW_Ret;
    CustomerInfoManage CIFrame;

    public PanInfoRet(CustomerInfoManage parent)  {
        CIFrame = parent;
        InitGUI();
    }

    private void InitGUI()  {
        setLayout(null);
        setBounds(0,0,480,320);


        Label_Title = new JLabel("고객정보수정");
        Label_Title.setBounds(0,0,480,40);
        Label_Title.setHorizontalAlignment(JLabel.CENTER);
        add(Label_Title);

        Label_ID_Ret = new JLabel("ID");
        Label_ID_Ret.setBounds(0,120,100,20);
        Label_ID_Ret.setHorizontalAlignment(JLabel.CENTER);
        add(Label_ID_Ret);

        Label_PW_Ret = new JLabel("PassWord");
        Label_PW_Ret.setBounds(0,150,100,20);
        Label_PW_Ret.setHorizontalAlignment(JLabel.CENTER);
        add(Label_PW_Ret);

        Tf_Id_Ret = new JTextField();
        Tf_Id_Ret.setBounds(100,120,350,20);
        Tf_Id_Ret.setEditable(true);
        add(Tf_Id_Ret);

        Tf_PW_Ret = new JTextField();
        Tf_PW_Ret.setBounds(100,150,350,20);
        Tf_PW_Ret.setEditable(true);
        add(Tf_PW_Ret);

        Btn_Ret = new JButton("수정");
        Btn_Ret.setBounds(100,250,70,20);
        Btn_Ret.addActionListener(this);
        add(Btn_Ret);

        Btn_Close = new JButton("취소");
        Btn_Close.setBounds(250,250,70,20);
        Btn_Close.addActionListener(this);
        add(Btn_Close);
    }
    public void actionPerformed(ActionEvent e)  {
        if (e.getSource() == Btn_Ret)   {
            info_retouch();
            this.setVisible(false);
            CIFrame.display("수정");
        }
        if (e.getSource() == Btn_Close) {
            this.setVisible(false);
            CIFrame.display("인포메인");
        }
    }
    public void info_retouch()  {

    }
}

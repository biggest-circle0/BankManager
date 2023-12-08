package  GUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerInfoManage
        extends JPanel
        implements ActionListener {
    private JLabel Label_Title;
    private JButton Btn_Addition;
    private JButton Btn_Delete;
    private JButton Btn_Retouch;
    private JButton Btn_Close;

    PanInfoAdd Pan_Addition;
    PanInfoDel Pan_Delete;
    PanInfoRet Pan_Retouch;
    ManagerMain MainFrame;
    public CustomerInfoManage(ManagerMain parent)   {
        MainFrame = parent;
        InitGUI();
    }

    private void InitGUI()  {
        setLayout(null);
        setBounds(0,0,480,320);

        Label_Title = new JLabel("고객관리");
        Label_Title.setBounds(0,0,480,40);
        Label_Title.setHorizontalAlignment(JLabel.CENTER);
        add(Label_Title);

        Btn_Addition = new JButton("추가");
        Btn_Addition.setBounds(0,60,70,20);
        Btn_Addition.addActionListener(this);
        add(Btn_Addition);

        Btn_Delete = new JButton("삭제");
        Btn_Delete.setBounds(0,130,70,20);
        Btn_Delete.addActionListener(this);
        add(Btn_Delete);

        Btn_Retouch = new JButton("수정");
        Btn_Retouch.setBounds(0,200,70,20);
        Btn_Retouch.addActionListener(this);
        add(Btn_Retouch);

        Btn_Close = new JButton("취소");
        Btn_Close.setBounds(0,250,70,20);
        Btn_Close.addActionListener(this);
        add(Btn_Close);

        Pan_Addition = new PanInfoAdd(this);
        add(Pan_Addition);
        Pan_Addition.setVisible(false);

        Pan_Delete = new PanInfoDel(this);
        add(Pan_Delete);
        Pan_Delete.setVisible(false);

        Pan_Retouch = new PanInfoRet(this);
        add(Pan_Retouch);
        Pan_Retouch.setVisible(false);
    }

    public void actionPerformed(ActionEvent e)  {
        if (e.getSource() == Btn_Addition)  {
            display("추가");
        }
        if (e.getSource() == Btn_Delete)    {
            display("삭제");
        }
        if (e.getSource() == Btn_Retouch)  {
            display("수정");
        }
        if (e.getSource() == Btn_Close) {
            display("메인");
        }
    }

    public void display(String viewname)   {
        if (viewname.equals("추가") == true)  {
            this.setFrameUI(false);
            Pan_Addition.setVisible(true);
        }
        if (viewname.equals("삭제") == true)  {
            this.setFrameUI(false);
            Pan_Delete.setVisible(true);
        }
        if (viewname.equals("수정") == true)  {
            this.setFrameUI(false);
            Pan_Retouch.setVisible(true);
        }
        if (viewname.equals("인포메인") == true)    {
            setFrameUI(true);
        }
        if (viewname.equals("메인") == true)  {
            this.setVisible(false);
            MainFrame.display("Main");
        }
    }

    void setFrameUI(boolean bOn)   {
        if (bOn == true)    {
            Label_Title.setVisible(true);
            Btn_Addition.setVisible(true);
            Btn_Delete.setVisible(true);
            Btn_Retouch.setVisible(true);
            Btn_Close.setVisible(true);
        }
        else {
            Label_Title.setVisible(false);
            Btn_Addition.setVisible(false);
            Btn_Delete.setVisible(false);
            Btn_Retouch.setVisible(false);
            Btn_Close.setVisible(false);
        }
    }
}

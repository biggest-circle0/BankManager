package  GUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerAccountManage extends JPanel implements ActionListener {
    private JButton add_acc;
    private JButton del_acc;
    private JButton Btn_Close;
    private PanAccAdd ManagerAccAdd;
    private PanAccDel ManagerAccDel;

    ManagerMain MainFrame;

    public CustomerAccountManage(ManagerMain parent){
        MainFrame = parent;
        InitGui();
    }


    private void InitGui(){
        setLayout(null);
        setBounds(0,0,480,320);

        add_acc = new JButton("추가");
        del_acc = new JButton("삭제");
        Btn_Close = new JButton("취소");

        add_acc.setBounds(0,70,100,20);              /*바꿔야됨*/
        del_acc.setBounds(100,70,100,20);
        Btn_Close.setBounds(200, 70, 100, 20);

        add_acc.addActionListener(this);
        del_acc.addActionListener(this);
        Btn_Close.addActionListener(this);


        add(add_acc);
        add(del_acc);
        add(Btn_Close);

        ManagerAccAdd = new PanAccAdd(this);
        add(ManagerAccAdd);
        ManagerAccAdd.setVisible(false);

        ManagerAccDel = new PanAccDel(this);
        add(ManagerAccDel);
        ManagerAccDel.setVisible(false);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == add_acc)
        {
            display("ManagerAcc_add");

        } else if (e.getSource() == del_acc) {
            display("ManagerAcc_del");

        } else if (e.getSource() == Btn_Close)  {
            display("Main");
        }
    }
    public void display(String viewName) {
        if (viewName.equals("ManagerAcc_del")){
            SetFrameUI(false);
            ManagerAccDel.setVisible(true);
        } else if (viewName.equals("ManagerAcc_add")) {
            SetFrameUI(false);
            ManagerAccAdd.setVisible(true);
        } else if (viewName.equals("AccountMain"))  {
            SetFrameUI(true);
        } else if (viewName.equals("Main")) {
            this.setVisible(false);
            MainFrame.display("Main");
        }
    }

    void SetFrameUI(Boolean bOn) {
        if (bOn==true){
            add_acc.setVisible(true);
            del_acc.setVisible(true);
            Btn_Close.setVisible(true);
        } else if (bOn==false) {
            add_acc.setVisible(false);
            del_acc.setVisible(false);
            Btn_Close.setVisible(false);

        }

    }
}
/*각각 버튼에 해당하는 페이지 보여주기*/

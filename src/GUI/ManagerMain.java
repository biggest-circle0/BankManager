package  GUI;
import GUI.CustomerAccountManage;
import GUI.CustomerInfoManage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ManagerMain extends JFrame implements ActionListener{
    private JButton Btn_CI;
    private JButton Btn_CA;
    private JButton Btn_Login;
    CustomerInfoManage CIManage;
    CustomerAccountManage CAManage;
    PanLogin Pan_Login;

    private Socket clientSocket;
    private ObjectInputStream readObj;
    private ObjectOutputStream writeObj;


    public static String adminId;

    public ManagerMain() throws IOException{
        InitGUI();
        initialize();
        setVisible(true);
    }

    public void initialize() throws IOException {
//        clientSocket = new Socket("localhost", 9000);
//        System.out.println("서버에 연결되었습니다");
//        writeObj = new ObjectOutputStream(clientSocket.getOutputStream());
//        readObj = new ObjectInputStream(clientSocket.getInputStream());
    }

    private void InitGUI()  {
        setLayout(null);
        //  setLayout(new FlowLayout());

        setTitle("Manager GUI");
        setBounds(0, 0, 480, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Btn_CI = new JButton("고객관리");
        Btn_CI.setBounds(0, 60, 100, 70); // 정확한 위치 조정필요
        Btn_CI.addActionListener(this);
        add(Btn_CI);

        Btn_CA = new JButton("계좌관리");
        Btn_CA.setBounds(0, 130, 100, 70); // 정확한 위치 조정필요
        Btn_CA.addActionListener(this);
        add(Btn_CA);

        Btn_Login = new JButton("로그인");
        Btn_Login.setBounds(0, 200, 100, 70);
        Btn_Login.addActionListener(this);
        add(Btn_Login);

        CIManage = new CustomerInfoManage(this);
        add(CIManage);
        CIManage.setVisible(false);

        CAManage = new CustomerAccountManage(this);
        add(CAManage);
        CAManage.setVisible(false);

        Pan_Login = new PanLogin(this);
        add(Pan_Login);
        Pan_Login.setVisible(false);
    }

    public void actionPerformed(ActionEvent e)  {
        if (e.getSource() == Btn_CI) {
            display("CI");
        } else if (e.getSource() == Btn_CA) {
            display("CA");
        } else if (e.getSource() == Btn_Login)  {
            display("Login");
        }
    }

    public void display(String viewName)   {
        /*if (adminId == null) {
            if(viewName.equals("Login") != true && viewName.equals("Main") != true)
            {
                JOptionPane.showMessageDialog(null, "접근권한이 없습니다. 로그인하세요.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }*/
        if (viewName.equals("CI"))  {
            this.setFrameUI(false);
            CIManage.setVisible(true);
        }
        if (viewName.equals("CA"))  {
            this.setFrameUI(false);
            CAManage.setVisible(true);
        }
        if (viewName.equals("Login"))   {
            this.setFrameUI(false);
            Pan_Login.setVisible(true);
        }
        if (viewName.equals("Main"))    {
            setFrameUI(true);
        }
    }

    void setFrameUI(boolean BOn)    {
        if (BOn == true)    {
            Btn_Login.setVisible(true);
            Btn_CA.setVisible(true);
            Btn_CI.setVisible(true);
        } else {
            Btn_Login.setVisible(false);
            Btn_CA.setVisible(false);
            Btn_CI.setVisible(false);
        }
    }

    public static void main(String[] args) throws IOException {
        ManagerMain mm = new ManagerMain();
    }
}

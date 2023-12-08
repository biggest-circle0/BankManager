package  GUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanInfoAdd extends JPanel implements ActionListener {
    private JLabel Label_Title;
    private JLabel Label_ID_Add;
    private JLabel Label_PW_Add;
    private JButton Btn_Add;
    private JButton Btn_Close;
    private JTextField Tf_Id_Add;
    private JTextField Tf_PW_Add;

    private JLabel Label_Name;
    private JLabel Label_AccType;
    private JLabel Label_AccNum;

    private JTextField Tf_Name;
    private JTextField Tf_AccNum;

    private JRadioButton AccType_Checking;
    private JRadioButton AccType_Saving;
    private ButtonGroup AccTypeButtonGroup;
    CustomerInfoManage CIFrame;

    public PanInfoAdd(CustomerInfoManage parent)  {
        CIFrame = parent;
        InitGUI();
    }

    private void InitGUI()  {
        setLayout(null);
        setBounds(0, 0, 480, 320);

        Label_Title = new JLabel("고객 추가");
        Label_Title.setBounds(0, 0, 480, 40);
        Label_Title.setHorizontalAlignment(JLabel.CENTER);
        add(Label_Title);

        Label_Name = new JLabel("이름");
        Label_Name.setBounds(20, 50, 50, 20);
        add(Label_Name);

        Tf_Name = new JTextField();
        Tf_Name.setBounds(80, 50, 150, 20);
        add(Tf_Name);

        Label_AccType = new JLabel("계좌 종류");
        Label_AccType.setBounds(20, 80, 70, 20);
        add(Label_AccType);

        AccType_Checking = new JRadioButton("예금 계좌");
        AccType_Checking.setBounds(100, 80, 100, 20);
        add(AccType_Checking);

        AccType_Saving = new JRadioButton("저축 계좌");
        AccType_Saving.setBounds(200, 80, 100, 20);
        add(AccType_Saving);

        AccTypeButtonGroup = new ButtonGroup();
        AccTypeButtonGroup.add(AccType_Checking);
        AccTypeButtonGroup.add(AccType_Saving);

        Label_AccNum = new JLabel("계좌 번호");
        Label_AccNum.setBounds(20, 110, 70, 20);
        add(Label_AccNum);

        Tf_AccNum = new JTextField();
        Tf_AccNum.setBounds(100, 110, 150, 20);
        add(Tf_AccNum);

        Label_ID_Add = new JLabel("ID");
        Label_ID_Add.setBounds(20, 140, 70, 20);
        Label_ID_Add.setHorizontalAlignment(JLabel.CENTER);
        add(Label_ID_Add);

        Tf_Id_Add = new JTextField();
        Tf_Id_Add.setBounds(100, 140, 150, 20);
        Tf_Id_Add.setEditable(true);
        add(Tf_Id_Add);

        Label_PW_Add = new JLabel("PassWord");
        Label_PW_Add.setBounds(20, 170, 70, 20);
        Label_PW_Add.setHorizontalAlignment(JLabel.CENTER);
        add(Label_PW_Add);

        Tf_PW_Add = new JTextField();
        Tf_PW_Add.setBounds(100, 170, 150, 20);
        Tf_PW_Add.setEditable(true);
        add(Tf_PW_Add);

        Btn_Add = new JButton("추가");
        Btn_Add.setBounds(100, 200, 70, 20);
        Btn_Add.addActionListener(this);
        add(Btn_Add);

        Btn_Close = new JButton("취소");
        Btn_Close.setBounds(200, 200, 70, 20);
        Btn_Close.addActionListener(this);
        add(Btn_Close);

    }
    public void actionPerformed(ActionEvent e)  {
        if (e.getSource() == Btn_Add)   {
            info_add();
            this.setVisible(false);
            CIFrame.display("추가");
        }
        if (e.getSource() == Btn_Close) {
            this.setVisible(false);
            CIFrame.display("인포메인");
        }
    }
    public void info_add()  {

    }
}

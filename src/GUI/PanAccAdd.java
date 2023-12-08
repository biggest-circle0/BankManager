package  GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanAccAdd extends JPanel implements ActionListener {
    JLabel acc_CustomerName; // 고객 이름
    JLabel acc_kind;// 계좌 유형
    JLabel acc_num;// 계좌 번호

    JButton acc_create_btn;
    JButton acc_cancel_btn;

    JTextField acc_CustomerName_tf;
    JTextField acc_kind_tf;
    JTextField acc_num_tf;


    CustomerAccountManage manageraccmain;

    private void InitGui() {
        setLayout(new GridLayout(4, 2));
        setBounds(0, 0, 480, 320);

        acc_CustomerName = new JLabel("고객 이름");
        acc_kind = new JLabel("계좌 종류");
        acc_num = new JLabel("계좌 번호");

        acc_create_btn = new JButton("생성");
        acc_cancel_btn = new JButton("취소");

        acc_create_btn.addActionListener(this);
        acc_cancel_btn.addActionListener(this);

        acc_CustomerName_tf = new JTextField(15);
        acc_kind_tf = new JTextField(15);
        acc_num_tf = new JTextField(15);


        add(acc_CustomerName);
        add(acc_CustomerName_tf);
        add(acc_kind);
        add(acc_kind_tf);
        add(acc_num);
        add(acc_num_tf);
        add(acc_create_btn);
        add(acc_cancel_btn);


    }
    public PanAccAdd(CustomerAccountManage parent){
        manageraccmain = parent;
        InitGui();
    }





    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if(source==acc_create_btn){
            /*사용자 추가에 사용할 변수*/
            String input_CustomerName = acc_CustomerName_tf.getText();
            String input_AccKind = acc_kind_tf.getText();
            int input_AccNum = Integer.parseInt(acc_num_tf.getText());

            /*각각 textfield에서 가져와서 서버에 넣는 기능 구현해야됨*/
            /*삭제 동작을 더 수행할 가능성이 있으므로 ManagerAcc_add 패널을 setVisible(false)하지 않는다.*/


        } else if (source == acc_cancel_btn) {
            /* ManagerAccMain 보여주기 */
            this.setVisible(false);
            manageraccmain.SetFrameUI(true);
        }
    }
}


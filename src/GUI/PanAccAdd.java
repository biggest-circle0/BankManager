package  GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanAccAdd extends JPanel implements ActionListener {
    JLabel acc_CustomerName; // �� �̸�
    JLabel acc_kind;// ���� ����
    JLabel acc_num;// ���� ��ȣ

    JButton acc_create_btn;
    JButton acc_cancel_btn;

    JTextField acc_CustomerName_tf;
    JTextField acc_kind_tf;
    JTextField acc_num_tf;


    CustomerAccountManage manageraccmain;

    private void InitGui() {
        setLayout(new GridLayout(4, 2));
        setBounds(0, 0, 480, 320);

        acc_CustomerName = new JLabel("�� �̸�");
        acc_kind = new JLabel("���� ����");
        acc_num = new JLabel("���� ��ȣ");

        acc_create_btn = new JButton("����");
        acc_cancel_btn = new JButton("���");

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
            /*����� �߰��� ����� ����*/
            String input_CustomerName = acc_CustomerName_tf.getText();
            String input_AccKind = acc_kind_tf.getText();
            int input_AccNum = Integer.parseInt(acc_num_tf.getText());

            /*���� textfield���� �����ͼ� ������ �ִ� ��� �����ؾߵ�*/
            /*���� ������ �� ������ ���ɼ��� �����Ƿ� ManagerAcc_add �г��� setVisible(false)���� �ʴ´�.*/


        } else if (source == acc_cancel_btn) {
            /* ManagerAccMain �����ֱ� */
            this.setVisible(false);
            manageraccmain.SetFrameUI(true);
        }
    }
}


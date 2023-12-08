package  GUI;
import GUI.CustomerAccountManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanAccDel extends JPanel implements ActionListener {
    JLabel acc_del;
    JTextField acc_num_del;
    JButton del_btn;
    JButton delcancel_btn;
    CustomerAccountManage manageraccmain;


    public PanAccDel(CustomerAccountManage parent){
        manageraccmain = parent;
        InitGui();
    }

    private void InitGui(){
        setLayout(new GridLayout(2,2));
        setBounds(0,0,480,320);

        acc_del = new JLabel("�����Ͻ� ���� ��ȣ :");
        acc_num_del = new JTextField(15);
        del_btn = new JButton("����");
        delcancel_btn = new JButton("���");

        del_btn.addActionListener(this);
        delcancel_btn.addActionListener(this);

        add(acc_del);
        add(acc_num_del);
        add(del_btn);
        add(delcancel_btn);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if(source == del_btn){
            double input_acc_num = Integer.parseInt(acc_num_del.getText());
            /*�������� �����ϴ� ���� �ʿ���*/
        }
        else if (source == delcancel_btn) {
            /*ManagerAccMain �����ֱ�*/
            this.setVisible(false);
            manageraccmain.SetFrameUI(true);
        }
    }
}

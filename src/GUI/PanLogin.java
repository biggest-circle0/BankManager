package  GUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanLogin extends JPanel implements ActionListener {
    private JTextField id_tf;
    private JLabel id_lb;
    private JTextField pw_tf;
    private JLabel pw_lb;
    private JButton login;
    private JButton cancel;

    ManagerMain managermain;


    public PanLogin(ManagerMain parent){
        managermain = parent;
        InitGUI();
    }


    private void InitGUI(){
        setLayout(null);


        setBounds(0,0,480,320);

        id_tf = new JTextField();
        id_lb = new JLabel("ID");
        pw_tf = new JTextField();
        pw_lb = new JLabel("PW");
        login = new JButton("Log In");
        cancel = new JButton("Cancel");

        id_tf.setBounds(100,60,350,20);
        id_lb.setBounds(0,60,100,20);
        pw_tf.setBounds(100,100,350,20);
        pw_lb.setBounds(0,100,100,20);
        login.setBounds(100,250,90,20);
        cancel.setBounds(250,250,90,20);


        add(id_lb);
        add(id_tf);
        add(pw_lb);
        add(pw_tf);
        add(login);
        add(cancel);


        login.addActionListener(this);
        cancel.addActionListener(this);

    }


    void SetFrameUI(Boolean bOn) {
        if (bOn==true){
            id_tf.setVisible(true);
            id_lb.setVisible(true);
            pw_tf.setVisible(true);
            pw_lb.setVisible(true);
            login.setVisible(true);
            cancel.setVisible(true);

        } else if (bOn == false) {
            id_tf.setVisible(false);
            id_lb.setVisible(false);
            pw_tf.setVisible(false);
            pw_lb.setVisible(false);
            login.setVisible(false);
            cancel.setVisible(false);
        }

    }


    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == login){
            String id = id_tf.getText();
            String pw = pw_tf.getText();
        } else if (e.getSource() == cancel){
            this.setVisible(false);
            managermain.setFrameUI(true);

        }

    }
}

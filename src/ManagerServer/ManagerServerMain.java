package ManagerServer;

import GUI.ManagerMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ManagerServerMain extends JFrame implements ActionListener {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectInputStream readObj;
    private ObjectOutputStream writeObj;

    JButton Server_Control;
    JButton Text_reset;
    JTextArea ServerLog;

    private ArrayList<Customer> CustomerList;

//    �������� ���еǴ� (���̵� ��й�ȣ) ManagerList.txt������ �о�ͼ� Map�� �ִ� ���? >> �Ŵ��� ������.
//    client�� ��쿡�� Client��� Ŭ������ ���� �� ��ü ��ü�� ArrayList�� �ִ� ����� ������ ����.

//    TODO: �Ŵ����� �߰��ϴ� ��ɵ� ����� ������ >> �Ѵٸ� ~~ �Ŵ��� GUI���� �Ŵ��� �߰� ��ư�� �����

    public ManagerServerMain() throws IOException{
        InitGUI();
        initialize();
    }

    public void InitGUI(){
        setTitle("Manager Server");
        setLayout(null);
        setBounds(0, 0, 480, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Server_Control = new JButton("���� ����");
        Server_Control.setBounds(100,250,70,20);
        Server_Control.addActionListener(this);
        add(Server_Control);

        Text_reset = new JButton("�ؽ�Ʈ �ʱ�ȭ");
        Text_reset.setBounds(250,250,70,20);
        Text_reset.addActionListener(this);
        add(Text_reset);

        ServerLog = new JTextArea();
        ServerLog.setEditable(false);
        ServerLog.setBounds(10,10,450,220);
        add(ServerLog);

        setVisible(true);





    }

    public void initialize() throws IOException {
        addMSG("������ �������Դϴ�.");

        CustomerList = new ArrayList<>();
        String File_CustomerList = "CustomerList.txt";
        BufferedReader en = new BufferedReader(new FileReader(File_CustomerList));

        String line;
        int a = 0;
//            ���پ� �о�ͼ� �Ľ��� �߰��� ã�� ���� ��������.
        while((line = en.readLine()) != null){



            StringTokenizer stk = new StringTokenizer(line,"/");

            String Customer_name = stk.nextToken();
            long Customer_Account = Long.parseLong(stk.nextToken());
            String Account_Type = stk.nextToken();
            String Customer_ID = stk.nextToken();
            String Customer_PW = stk.nextToken();

            CustomerList.add(new Customer(Customer_name,Customer_Account,Account_Type,Customer_ID,Customer_PW));

//            for (Customer c : CustomerList){
//                System.out.println(c.toString());
//            }
            }

        serverSocket = new ServerSocket(9000);
        clientSocket = serverSocket.accept();
        addMSG("Socket�� ����");
        writeObj = new ObjectOutputStream(clientSocket.getOutputStream());
        readObj = new ObjectInputStream(clientSocket.getInputStream());

        addMSG("���� ���� �Ϸ� . . . ");
        }


// �ʿ����� �𸣰����� ������ ���� �޼��� (���̵�� ��й�ȣ ã��)
    public String getPW(String ID){
        String pw = null;

        for (Customer Customer : CustomerList){
            if (Customer.getCustomer_ID().equals(ID)){
                pw = Customer.getCustomer_Password();
            }
        }
        return pw;
    }

// ID�� �ְ� PassWord�� �����ϴ� �޼��� (��й�ȣ ���� �޼���)
    public void setPW(String ID, String PASSWORD){
        int i=0;
        for (Customer Customer : CustomerList){
            if (Customer.getCustomer_ID().equals(ID)){

                String name = Customer.getCustomer_name();
                long accountNum = Customer.getCustomer_Account();
                String accountType = Customer.getAccount_Type();

                CustomerList.set(i, new Customer(name,accountNum,accountType,ID,PASSWORD));
                break;
            }
            i++;
        }

    }


// ID ������ �ߺ� ���θ� Ȯ���ϴ� �޼���
// true�� �ߺ��Ǵ� ���� �ִ� ID��
// �⺻���� false�̰�, ��ġ�� ���� �־�߸� true�� ��ȯ�ϰԵ�
    public boolean isDuplicated(String ID){
        boolean isdu = false;
        for (Customer customer : CustomerList){
            if (customer.getCustomer_ID().equals(ID)){
                isdu = true;
                break;
            }
        }return isdu;
    }


//TODO : ����ڸ� �߰��ϴ� �޼���
// - ������� �ؾ����� ���� �ʿ� (�߰� gui�� ������ �ʿ������� �𸣰���.)
    public void addCustomer(Customer newCustomer){}
//        CustomerList.add(new Customer())



    public void addMSG(String msg){
        ServerLog.append(msg+"\n");
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }




public static void main(String[] args) throws IOException{
    ManagerServerMain m = new ManagerServerMain();




//
//    for (Customer Customer : m.CustomerList){
//        System.out.println(Customer.toString());
//        System.out.println();
//    }
//
//    System.out.println("��й�ȣ ã�� ��� :"+ m.getPW("eodjns"));

    }
}


/*
Bank GUI ��ü�� ���ľ��� �ʿ䰡 ����.
*/


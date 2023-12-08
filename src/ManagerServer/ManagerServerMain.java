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

//    공백으로 구분되는 (아이디 비밀번호) ManagerList.txt파일을 읽어와서 Map에 넣는 방식? >> 매니저 기준임.
//    client의 경우에는 Client라는 클래스를 만들어서 그 객체 자체를 ArrayList에 넣는 방식이 적절해 보임.

//    TODO: 매니저를 추가하는 기능도 만들면 좋을듯 >> 한다면 ~~ 매니저 GUI에서 매니저 추가 버튼도 만들것

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

        Server_Control = new JButton("서버 중지");
        Server_Control.setBounds(100,250,70,20);
        Server_Control.addActionListener(this);
        add(Server_Control);

        Text_reset = new JButton("텍스트 초기화");
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
        addMSG("서버를 생성중입니다.");

        CustomerList = new ArrayList<>();
        String File_CustomerList = "CustomerList.txt";
        BufferedReader en = new BufferedReader(new FileReader(File_CustomerList));

        String line;
        int a = 0;
//            한줄씩 읽어와서 파싱함 중고차 찾기 과제 참고했음.
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
        addMSG("Socket에 연결");
        writeObj = new ObjectOutputStream(clientSocket.getOutputStream());
        readObj = new ObjectInputStream(clientSocket.getInputStream());

        addMSG("서버 생성 완료 . . . ");
        }


// 필요할진 모르겠지만 시험삼아 만들어본 메서드 (아이디로 비밀번호 찾기)
    public String getPW(String ID){
        String pw = null;

        for (Customer Customer : CustomerList){
            if (Customer.getCustomer_ID().equals(ID)){
                pw = Customer.getCustomer_Password();
            }
        }
        return pw;
    }

// ID를 넣고 PassWord를 수정하는 메서드 (비밀번호 변경 메서드)
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


// ID 생성시 중복 여부를 확인하는 메서드
// true면 중복되는 것이 있는 ID임
// 기본값이 false이고, 겹치는 것이 있어야만 true로 반환하게됨
    public boolean isDuplicated(String ID){
        boolean isdu = false;
        for (Customer customer : CustomerList){
            if (customer.getCustomer_ID().equals(ID)){
                isdu = true;
                break;
            }
        }return isdu;
    }


//TODO : 사용자를 추가하는 메서드
// - 어떤식으로 해야할지 논의 필요 (추가 gui도 수정이 필요할지도 모르겠음.)
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
//    System.out.println("비밀번호 찾기 결과 :"+ m.getPW("eodjns"));

    }
}


/*
Bank GUI 자체도 고쳐야할 필요가 있음.
*/


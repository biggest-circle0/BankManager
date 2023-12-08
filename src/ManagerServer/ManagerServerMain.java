package ManagerServer;

import GUI.ManagerMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ManagerServerMain extends JFrame implements ActionListener {
//    private ServerSocket serverSocket;
//    private Socket clientSocket;
//    private ObjectInputStream readObj;
//    private ObjectOutputStream writeObj;

    private static AsynchronousChannelGroup channelGroup;
    private static AsynchronousServerSocketChannel serverSocketChannel;

    JButton Server_Control;
    JButton Text_reset;
    JTextArea ServerLog;

    private ArrayList<Customer> CustomerList;

//    공백으로 구분되는 (아이디 비밀번호) ManagerList.txt파일을 읽어와서 Map에 넣는 방식? >> 매니저 기준임.
//    client의 경우에는 Client라는 클래스를 만들어서 그 객체 자체를 ArrayList에 넣는 방식이 적절해 보임.

//    TODO: 매니저를 추가하는 기능도 만들면 좋을듯 >> 한다면 ~~ 매니저 GUI에서 매니저 추가 버튼도 만들것

    public ManagerServerMain() throws IOException{
        InitGUI();
        startServer();
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

//        serverSocket = new ServerSocket(9000);
//        clientSocket = serverSocket.accept();
//        addMSG("Socket에 연결");
//        writeObj = new ObjectOutputStream(clientSocket.getOutputStream());
//        readObj = new ObjectInputStream(clientSocket.getInputStream());



        addMSG("서버 생성 완료 . . . ");
        }

//        server
public void startServer()
{
    try
    {
        channelGroup = AsynchronousChannelGroup.withFixedThreadPool(Runtime.getRuntime().availableProcessors(), Executors.defaultThreadFactory());
        serverSocketChannel = AsynchronousServerSocketChannel.open(channelGroup);
        serverSocketChannel.bind(new InetSocketAddress(5001));
        SwingUtilities.invokeLater(() ->
        {
            addMSG("서버 시작");
            Server_Control.setText("정지");
        });
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>()
        {
            @Override
            public void completed(AsynchronousSocketChannel socketChannel, Void attachment)
            {
                try
                {
                    addMSG(socketChannel.getRemoteAddress() + " 접속");
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

//                Client client = new Client(socketChannel, ServerMain.this, customerList);
//                clientList.add(client);
//                SwingUtilities.invokeLater(() -> Label_UserCount_2.setText(String.valueOf(clientList.size())));
//                serverSocketChannel.accept(null, this);
            }

            @Override
            public void failed(Throwable exc, Void attachment)
            {
                if (serverSocketChannel.isOpen())
                {
                    stopServer();
                }
            }
        });
    }
    catch (IOException e)
    {
        if (serverSocketChannel.isOpen())
        {
            stopServer();
        }
    }
}


    public void stopServer()
    {
//        clientList.clear();
        if (channelGroup != null && !channelGroup.isShutdown())
        {
            try
            {
                channelGroup.shutdownNow();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                SwingUtilities.invokeLater(() ->
                {
                    addMSG("서버 정지");
                    Server_Control.setText("시작");
                });
            }
        }
    }

//    @Override
//    public void removeClient(Client client)
//    {
//        clientList.remove(client);
//        addMsg(client + "제거됨");
//        // 현재 접속자수 업데이트
//        SwingUtilities.invokeLater(() -> Label_UserCount_2.setText(String.valueOf(clientList.size())));
//    }



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
        Object source = e.getSource();
        if (source.equals(Server_Control)){
            if (Server_Control.getText().equals("정지")){
                Server_Control.setText("시작");
                startServer();
            }else if (Server_Control.getText().equals("시작")){
                Server_Control.setText("정지");
                stopServer();

            }
        }
        if (source == Text_reset){
            ServerLog.setText("");
            addMSG("텍스트 창이 초기화 되었습니다.");
        }

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


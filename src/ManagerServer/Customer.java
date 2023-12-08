package ManagerServer;

public class Customer {
    private String Customer_name;
    private long Customer_Account;
    private String Account_type;
    private String Customer_ID;
    private String Customer_Password;

    public Customer(String name, long Account, String AccountType, String CustomerID, String CustomerPassword){
        this.Customer_name = name;
        this.Customer_Account = Account;
        this.Account_type = AccountType;
        this.Customer_ID = CustomerID;
        this.Customer_Password = CustomerPassword;
    }
    public String getCustomer_name(){return Customer_name;}
    public String getCustomer_ID(){return Customer_ID;}
    public String getCustomer_Password(){return Customer_Password;}
    public long getCustomer_Account(){return Customer_Account;}
    public String getAccount_Type(){return Account_type;}


    public String toString(){return "이름 : " + Customer_name + "\n계좌 번호: " + Customer_Account
                +"\n계좌 종류: " + Account_type + "\nID : " + Customer_ID +
                "\nPW: " + Customer_Password ;}




}

package online_Shopping;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.LineBorder;

public interface objects {
    
    String path="src\\Images\\";
    final String custName = new String();
    final String custNumber = new String();
    public String custAddress = new String();
    public JButton accountButton = new JButton(new ImageIcon(path+"account.png"));     //Button to Open logIn and My account panel
    public JTextField searchField = new JTextField("Search");    //TextField to search Item
    public JButton searchButton = new JButton(new ImageIcon(path+"search.png"));   //Button to search Items
    public JButton bagButton = new JButton(new ImageIcon(path+"kart.png"));     //Button to Open My Cart Panel 
    public JLabel nameLabel1 = new JLabel("UY");       //Label for App name
    public JLabel nameLabel2 = new JLabel("kart");      //Label for App name
    public JLabel track=new JLabel(new ImageIcon(path+"track.png"));
    public JLabel easy=new JLabel(new ImageIcon(path+"easy.jpg"));
    public JLabel fast=new JLabel(new ImageIcon(path+"fast.png"));
    public JButton helpButton=new JButton(new ImageIcon(path+"about.png"));       //Button to Open about Panel
   
    String catg[] = {"Category","Women","Men","Kids","Mobile & TV","Furniture","Books"};
    public JPanel headerPanel = new JPanel();       //header Panel of main Panel of App
    public JComboBox menuButton = new JComboBox(catg);      //Button to Open categories for products
    public JPanel flashPanel = new JPanel();        //Panel to add Advertisizing Images (Panel in Main Panel)
    public JLabel flashImages = new JLabel();       //Label for add Advertisizing Images (Label in flash Panel)
    public JPanel p[][] = new JPanel[1][2];         //Panel to add Buttons for Products with some Offer (Panels in Main Panel)
    public JButton pb[][] = new JButton[1][2];      //Buttons on p[][] Panels for Products with some Offer
    public JLabel pl[][] = new JLabel[1][2];        //Labes on p[][] Panels to show Offers on Products
    
    JPanel animation = new JPanel();
    
    JPanel f1 = new JPanel();               //Main Panel
    JPanel background = new JPanel();       //Panel for other windows like account panel,logIn panel,About Panel,etc
    JPanel logInPanel = new JPanel();       //Panel for LogIn
    JPanel signUpPanel = new JPanel();      //Panel for Signing In
    JPanel helpPanel = new JPanel();        //Panel for About App details
    JLabel iconLabel = new JLabel(new ImageIcon(path+"applogo.png"));
    JButton backButton = new JButton(new ImageIcon(path+"back.png"));       //Button to go to previous Panel
    
    StringBuilder uname = new StringBuilder();
    StringBuilder uaddress = new StringBuilder();
    StringBuilder unumber = new StringBuilder();
    StringBuilder pri = new StringBuilder();
    StringBuilder d = new StringBuilder();
    StringBuilder div = new StringBuilder();
    StringBuilder pid = new StringBuilder();
    StringBuilder prod = new StringBuilder();
    
    //menu()Objects
        JButton productsCatogery[] = new JButton[5];
        JLabel catogery[] = new JLabel[4];
    
    //logIn() Objects
        JTextField usernameField = new JTextField("Mobile Number");
        JPasswordField passwordField1 = new JPasswordField("Password");   
        JButton logInButton = new JButton("LogIn");        
        JButton createAccount = new JButton("Create Account");      //Button to move to signUp Panel
        JLabel logo = new JLabel();        
        JLabel text = new JLabel("New User?");
        JLabel copy=new JLabel();
        JLabel design=new JLabel("Designed By");
        JLabel name=new JLabel("Tushar Gautam & Sourav Bhardwaj");
        JLabel about=new JLabel();
    
    //signUp() Objects       
        JTextField detailsField[] = new JTextField[2];
        JPasswordField passwordField[] = new JPasswordField[2];    
        JButton signUpButton = new JButton("SignUp");          
    
    //account() Objects
        JLabel usernameLabel = new JLabel();
        JLabel userNumberLabel = new JLabel();
        JPanel accountPanel = new JPanel();
        JButton logOutButton = new JButton("LogOut");
        JButton settings = new JButton("Settings");
        
    //settings() Objects
        JPanel settingsPanel = new JPanel();
        JTextArea editName = new JTextArea();
        JTextArea editAddress = new JTextArea();
        JButton editButton[] = new JButton[2];
        JLabel el[] = new JLabel[2];
        
    //product() Objects
        JPanel productsPanel = new JPanel();
        JPanel productHeader = new JPanel();
        JButton products[] = new JButton[4];
        JLabel nothingFound = new JLabel();
        JTextArea productsDetails[] = new JTextArea[4];
        String[] id = new String[4];
        StringBuilder dis = new StringBuilder();
        
    //buy() Objects
        JPanel buyPanel = new JPanel();
        JTextArea custDetails = new JTextArea();
        JTextArea prodDetails = new JTextArea();
        JTextArea priceDetails = new JTextArea();
        JLabel mode = new JLabel("Mode: Cash on Dilevery");
        JButton placeOrder = new JButton("Place Order");
        
    //showProducts() Objects
        JPanel showPanel = new JPanel();
        JLabel bigImage = new JLabel();
        JButton smallImages[] = new JButton[4];
        JTextArea details = new JTextArea();
        JButton buyNow = new JButton("BUY");
        JButton addtokart = new JButton("Add to Kart");
        StringBuilder folderName = new StringBuilder();
        
    //help() Objects
       public JLabel t=new JLabel("Track your order");
       public JLabel e=new JLabel("Easy Returns");
       public JLabel F=new JLabel("Faster Delievery");
        
    //Fonts and Borders   
    LineBorder lineBorder = new LineBorder(Color.white,2, true); 
    LineBorder lb = new LineBorder(Color.black,1, true); 
    LineBorder backButtonBorder = new LineBorder(new Color(15,37,71),2,true);
    LineBorder lb1 = new LineBorder(Color.black,2,true);
    LineBorder bborder = new LineBorder(new Color(15,37,71),2, true);    
    Font headerFont1 = new Font("verdana", Font.BOLD, 20);
    Font headerFont2 = new Font("segoe print", Font.HANGING_BASELINE, 20);
    Font animationFont1 = new Font("verdana", Font.BOLD, 25);
    Font animationFont2 = new Font("segoe print", Font.HANGING_BASELINE, 25);
    Font myFont = new Font("Ravie", Font.ITALIC, 8);
    Font textFont = new Font("vijiya", Font.PLAIN, 15);
    Font f=new Font("Algerian",Font.PLAIN,25);
    
}
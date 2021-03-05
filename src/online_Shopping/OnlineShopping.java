package online_Shopping;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.*;

public class OnlineShopping extends Frame implements ActionListener, objects {

    int x = 350, y = 600;
    int k = 1;
    StringBuilder flag = new StringBuilder();
    StringBuilder ps = new StringBuilder();
    boolean log = false;
    boolean en1 = false;
    boolean en2 = false;
    int counter = 0;

    OnlineShopping() {
        setSize(x, y);
        setTitle("BUY kart");

        setIconImage(Toolkit.getDefaultToolkit().getImage(path + "applogo.png"));
        setLocation(500, 50);
        setResizable(false);
        setBackground(new Color(15, 37, 71));
        animation.setBackground(new Color(15, 37, 71));
        animation.setLayout(null);
        iconLabel.setBounds(84, 240, 50, 50);
        animation.add(iconLabel);
        nameLabel1.setFont(animationFont1);
        nameLabel2.setFont(animationFont2);
        nameLabel2.setForeground(Color.white);
        nameLabel1.setForeground(Color.white);
        nameLabel1.setBounds(130, 240, 100, 50);
        nameLabel2.setBounds(167, 240, 100, 50);
        animation.add(nameLabel1);
        animation.add(nameLabel2);

        add(animation);

        setVisible(true);
        delay(1000);
        animation.setVisible(false);

        f1.setLayout(null);
        flag.replace(0, flag.length(), "");
        flag.append("1");
        iconLabel.setBounds(4, 0, 50, 50);
        f1.add(iconLabel);

        logo.setForeground(Color.white);
        logo.setBounds(50, 30, 350, 45);
        logo.setFont(f);

        background.setLayout(null);
        background.setBackground(new Color(15, 37, 71));

        logInPanel.setBounds(0, 100, 350, 400);
        logInPanel.setLayout(null);

        signUpPanel.setBounds(0, 100, 350, 400);
        signUpPanel.setLayout(null);

        helpPanel.setBounds(0, 100, 350, 400);
        helpPanel.setLayout(null);

        accountPanel.setBounds(0, 150, 350, 600);
        accountPanel.setLayout(null);

        settingsPanel.setBounds(0, 150, 350, 600);
        settingsPanel.setLayout(null);

        editButton[0] = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + "edit.png")));
        editButton[1] = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + "edit.png")));
        editButton[0].setBorderPainted(false);
        editButton[1].setBorderPainted(false);
        editButton[0].setBackground(Color.white);
        editButton[1].setBackground(Color.white);
        editButton[0].setBounds(269, 59, 40, 40);
        editButton[1].setBounds(269, 59, 40, 40);
        editButton[0].addActionListener(this);
        editButton[1].addActionListener(this);

        backButton.setBounds(10, 25, 40, 50);
        backButton.setBorder(backButtonBorder);
        backButton.addActionListener(this);
        backButton.setBackground(new Color(15, 37, 71));

        showPanel.setBounds(0, 100, 350, 500);
        showPanel.setLayout(null);

        bigImage.setBounds(10, 15, 240, 250);
        showPanel.add(bigImage);

        for (int i = 0; i < 4; i++) {
            smallImages[i] = new JButton();
            smallImages[i].setBackground(Color.white);
            smallImages[i].setBounds(265, 10 + (i * 65), 60, 60);
            smallImages[i].addActionListener(this);
            showPanel.add(smallImages[i]);
        }

        details.setBounds(10, 275, 315, 140);
        details.enable(false);
        showPanel.add(details);
        buyNow.setBounds(10, 425, 160, 35);
        buyNow.setBorderPainted(false);
        buyNow.setBackground(new Color(15, 37, 71));
        buyNow.setForeground(Color.white);

        addtokart.setBounds(165, 425, 160, 35);
        addtokart.setBorderPainted(false);
        addtokart.setBackground(new Color(15, 37, 71));
        addtokart.setForeground(Color.white);

        showPanel.add(buyNow);
        showPanel.add(addtokart);
        addtokart.addActionListener(this);

        productsPanel.setLayout(null);
        productsPanel.add(productHeader);

        productHeader.setBounds(0, 0, 350, 100);
        productHeader.setLayout(null);
        productHeader.setBackground(new Color(15, 37, 71));

        //Setting Buy Now Panel
        buyPanel.setLayout(null);
        buyPanel.setBounds(0, 100, 350, 500);
        custDetails.setEnabled(false);
        custDetails.setBounds(10, 10, 320, 100);
        prodDetails.setEnabled(false);
        prodDetails.setBounds(10, 120, 320, 150);
        priceDetails.setEnabled(false);
        priceDetails.setBounds(10, 280, 320, 100);
        mode.setBounds(20, 400, 200, 50);
        placeOrder.setBounds(200, 400, 110, 50);
        placeOrder.setBorderPainted(false);
        placeOrder.setBackground(new Color(15, 37, 71));
        placeOrder.setForeground(Color.white);

        buyPanel.add(mode);
        buyPanel.add(placeOrder);
        buyPanel.add(priceDetails);
        buyPanel.add(custDetails);
        buyPanel.add(prodDetails);
        placeOrder.addActionListener(this);
        //Setting Buy Now Panel ends

        //Setting Menu Panel
        productsCatogery[0] = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + "women.png")));
        productsCatogery[1] = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + "men.png")));
        productsCatogery[2] = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + "kids.png")));
        productsCatogery[3] = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + "electronics.png")));
        productsCatogery[4] = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + "book.png")));

        for (int i = 0; i < 5; i++) {

            productsCatogery[i].setBounds(12 + (i * 60), 105, 60, 40);
            productsCatogery[i].setBackground(new Color(15, 37, 71));
            productsCatogery[i].setBorder(backButtonBorder);

            productsCatogery[i].setForeground(Color.white);
            productsCatogery[i].addActionListener(this);
            headerPanel.add(productsCatogery[i]);
        }
        //Setting Menu Panel ends

        //Setting Product Panel
        nothingFound.setBounds(50, 200, 200, 200);
        for (int i = 0; i < 4; i++) {
            products[i] = new JButton();
            productsDetails[i] = new JTextArea();
            productsDetails[i].setDisabledTextColor(Color.BLACK);
            products[i].setBackground(Color.white);
            products[i].setBorder(lb);
            products[i].setBounds(10, 110 + i + (i * 100), 100, 100);
            products[i].addActionListener(this);

            productsDetails[i].setBounds(110, 110 + i + (i * 100), 215, 100);
            productsDetails[i].enable(false);

            productsPanel.add(productsDetails[i]);
            productsPanel.add(products[i]);

            products[i].setVisible(false);
            productsDetails[i].setVisible(false);

        }
        buyNow.addActionListener(this);
        //Setting ProductPanel ends

        flashImages.setBounds(13, 180, x - 25, 220);
        add(flashImages);

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 2; j++) {

                pl[i][j] = new JLabel();
                pl[i][j].setBounds(5, 170, 180, 20);
                pb[i][j] = new JButton(new ImageIcon(path + "panel" + (i + 1) + (j + 1) + ".jpg"));
                pb[i][j].setBounds(8, 10, 145, 160);
                pb[i][j].setBorder(lineBorder);

                p[i][j] = new JPanel();
                p[i][j].setBounds(10 + (161 * j) + (j * 2), 380 + (i * 200) + (i * 2), 161, 200);
                p[i][j].setBackground(Color.white);
                p[i][j].setLayout(null);
                p[i][j].add(pb[i][j]);
                p[i][j].add(pl[i][j]);
                f1.add(p[i][j]);
            }
        }

        pl[0][0].setText(" 40% Discount");
        pl[0][1].setText(" Under 1999");

        headerPanel.setBounds(0, 0, x - 5, 150);
        headerPanel.setBackground(new Color(15, 37, 71));
        headerPanel.setLayout(null);

        nameLabel1.setBounds(50, 0, 100, 50);
        nameLabel2.setBounds(87, 0, 100, 50);

        accountButton.setBounds(250, 0, 40, 40);
        accountButton.setBackground(new Color(15, 37, 71));
        accountButton.setBorder(backButtonBorder);
        accountButton.addActionListener(this);

        bagButton.setBounds(210, 0, 40, 40);
        bagButton.setBackground(new Color(15, 37, 71));
        bagButton.addActionListener(this);
        bagButton.setBorder(backButtonBorder);

        searchField.setBounds(18, 63, 270, 30);
        searchField.setBorder(lineBorder);
        searchField.addActionListener(this);

        searchButton.setBounds(288, 60, 35, 35);
        searchButton.setBackground(new Color(15, 37, 71));
        searchButton.addActionListener(this);
        searchButton.setBorder(backButtonBorder);

        helpButton.setBounds(290, 0, 40, 40);
        helpButton.setBorder(backButtonBorder);
        helpButton.setBackground(new Color(15, 37, 71));

        helpButton.addActionListener(this);
        logInButton.addActionListener(this);
        createAccount.addActionListener(this);
        signUpButton.addActionListener(this);
        logOutButton.addActionListener(this);
        settings.addActionListener(this);

        headerPanel.add(nameLabel1);
        headerPanel.add(nameLabel2);
        headerPanel.add(accountButton);
        headerPanel.add(searchField);
        headerPanel.add(searchButton);
        headerPanel.add(menuButton);
        headerPanel.add(bagButton);
        headerPanel.add(helpButton);

        searchField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if ("Search".equals(searchField.getText())) {
                    searchField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        f1.add(headerPanel);
        f1.add(flashPanel);
        add(f1);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        //Code for Changing Images in flashPanel
        while (true) {

            ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + k + ".jpg"));
            Image img = icon.getImage().getScaledInstance(flashImages.getWidth(), flashImages.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newicon = new ImageIcon(img);
            flashImages.setIcon(newicon);
            k++;
            if (k > 6) {
                k = 1;
            }
            delay(1500);
        }
        //Code for Changing Images in flashPanel ends

    }

    void delay(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException er) {
            System.out.println(er);
        }
    }

    public static void main(String[] args) {
        new OnlineShopping().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        usernameLabel.setVisible(false);
        userNumberLabel.setVisible(false);
        if (e.getSource() == helpButton) {
            flashImages.setVisible(false);
            signUpPanel.setVisible(false);
            logInPanel.setVisible(false);
            accountPanel.setVisible(false);
            buyPanel.setVisible(false);
            showPanel.setVisible(false);
            settingsPanel.setVisible(false);
            productsPanel.setVisible(false);
            f1.setVisible(false);
            help();
            background.setVisible(true);
            helpPanel.setVisible(true);
        } else if (e.getSource() == accountButton) {
            flashImages.setVisible(false);
            signUpPanel.setVisible(false);
            helpPanel.setVisible(false);
            buyPanel.setVisible(false);
            showPanel.setVisible(false);
            settingsPanel.setVisible(false);
            productsPanel.setVisible(false);
            f1.setVisible(false);
            if (log == false) {
                accountPanel.setVisible(false);
                logIn();
                background.setVisible(true);
                logInPanel.setVisible(true);
            } else {
                logInPanel.setVisible(true);
                account();
                background.setVisible(true);
                accountPanel.setVisible(true);
            }
        } else if (e.getSource() == createAccount) {
            flashImages.setVisible(false);
            logInPanel.setVisible(false);
            helpPanel.setVisible(false);
            accountPanel.setVisible(false);
            buyPanel.setVisible(false);
            showPanel.setVisible(false);
            settingsPanel.setVisible(false);
            productsPanel.setVisible(false);
            f1.setVisible(false);

            background.setVisible(true);
            background.add(signUpPanel);
            signUpPanel.setVisible(true);
            signUp();

        } else if (e.getSource() == bagButton) {
            flashImages.setVisible(false);
            signUpPanel.setVisible(false);
            helpPanel.setVisible(false);
            accountPanel.setVisible(false);
            buyPanel.setVisible(false);
            showPanel.setVisible(false);
            settingsPanel.setVisible(false);
            f1.setVisible(false);
            if (log == false) {
                productsPanel.setVisible(false);
                logIn();
                logInPanel.setVisible(true);
                background.setVisible(true);
            } else {
                background.setVisible(false);
                productsPanel.setVisible(true);
                kart();
            }
        } else if (e.getSource() == logOutButton) {

            usernameField.setText("Mobile Number");
            passwordField1.setText("Password");

            usernameLabel.setText("");
            userNumberLabel.setText("");
            uname.replace(0, uname.length(), "");
            uaddress.replace(0, uaddress.length(), "");
            unumber.replace(0, unumber.length(), "");

            background.setVisible(false);
            signUpPanel.setVisible(false);
            logInPanel.setVisible(false);
            helpPanel.setVisible(false);
            accountPanel.setVisible(false);
            buyPanel.setVisible(false);
            showPanel.setVisible(false);
            settingsPanel.setVisible(false);
            productsPanel.setVisible(false);
            f1.setVisible(true);
            flashImages.setVisible(true);
            log = false;

        } else if (e.getSource() == settings) {
            accountPanel.setVisible(false);
            flashImages.setVisible(false);
            signUpPanel.setVisible(false);
            logInPanel.setVisible(false);
            helpPanel.setVisible(false);
            accountPanel.setVisible(false);
            buyPanel.setVisible(false);
            showPanel.setVisible(false);
            productsPanel.setVisible(false);
            f1.setVisible(false);
            settings();
            background.setVisible(true);
            background.add(settingsPanel);
            settingsPanel.setVisible(true);
        } else if (e.getSource() == backButton) {
            dis.replace(0, dis.length(), "");
            pid.replace(0, pid.length(), "");
            prod.replace(0, prod.length(), "");
            pri.replace(0, pri.length(), "");
            d.replace(0, d.length(), "");
            div.replace(0, div.length(), "");
            for (int i = 0; i < 4; i++) {
                productsPanel.remove(products[i]);
                productsPanel.remove(productsDetails[i]);
                productsPanel.remove(nothingFound);
                accountPanel.remove(nothingFound);
            }
            if (null != flag.toString()) {
                switch (flag.toString()) {
                    case "2":
                        background.setVisible(false);
                        logInPanel.setVisible(false);
                        productsPanel.setVisible(false);
                        f1.setVisible(true);
                        flashImages.setVisible(true);
                        if (log == true) {
                            flashImages.setVisible(true);
                            flag.replace(0, flag.length(), "");
                            flag.append("1");
                        } else {
                            flag.replace(0, flag.length(), "");
                            flag.append("4");
                        }
                        break;
                    case "3":
                        background.setVisible(false);
                        productsPanel.setVisible(false);
                        f1.setVisible(true);
                        flashImages.setVisible(true);
                        flag.replace(0, flag.length(), "");
                        flag.append("1");
                        for (int i = 0; i < 4; i++) {
                            productsPanel.remove(products[i]);
                            productsPanel.remove(productsDetails[i]);
                            productsPanel.remove(nothingFound);
                            accountPanel.remove(nothingFound);
                        }
                        break;
                    case "4":
                        background.setVisible(false);
                        logInPanel.setVisible(false);
                        f1.setVisible(true);
                        flashImages.setVisible(true);
                        flag.replace(0, flag.length(), "");
                        flag.append("1");
                        break;
                    case "5":
                        logIn();
                        logInPanel.setVisible(true);
                        signUpPanel.setVisible(false);
                        flag.replace(0, flag.length(), "");
                        flag.append("4");
                        break;
                    case "6":
                        settingsPanel.setVisible(false);
                        account();
                        accountPanel.setVisible(true);
                        flag.replace(0, flag.length(), "");
                        flag.append("7");
                        break;
                    case "7":
                        background.setVisible(false);
                        accountPanel.setVisible(false);
                        f1.setVisible(true);
                        flashImages.setVisible(true);
                        flag.replace(0, flag.length(), "");
                        flag.append("1");
                        break;
                    case "8":
                        helpPanel.setVisible(false);
                        background.setVisible(false);
                        f1.setVisible(true);
                        flashImages.setVisible(true);
                        flag.replace(0, flag.length(), "");
                        flag.append("1");
                        break;
                    case "9":
                        background.setVisible(false);
                        productsPanel.setVisible(true);
                        product();
                        flag.replace(0, flag.length(), "");
                        flag.append("3");
                        break;
                    case "10":
                        buyPanel.setVisible(false);
                        showPanel.setVisible(true);
                        showProducts(Integer.parseInt(ps.toString()));
                        background.setVisible(true);
                        break;
                    default:
                        break;
                }
            }

        } else if (e.getSource() == logInButton) {
            search();
            if (log == true) {
                account();
                background.setVisible(true);
                accountPanel.setVisible(true);

                flag.replace(0, flag.length(), "");
                flag.append("3");
            }

        } else if (e.getSource() == signUpButton) {

            addtoDatabase();

            if (log == true) {
                account();
                background.setVisible(true);
                accountPanel.setVisible(true);

                flag.replace(0, flag.length(), "");
                flag.append("3");
            }
        } else if (e.getSource() == searchButton && (!"".equals(searchField.getText()) && !"search".equalsIgnoreCase(searchField.getText()))) {
            counter = 0;
            logo.setText(searchField.getText());
            f1.setVisible(false);
            background.setVisible(false);
            flashImages.setVisible(false);
            product();
            productsPanel.setVisible(true);
        } else if (e.getSource() == buyNow) {
            showPanel.setVisible(false);
            buy();
            background.add(buyPanel);
            buyPanel.setVisible(true);
        } else if (e.getSource() == placeOrder) {

            if (log == true) {
                if ("NULL".equalsIgnoreCase(uaddress.toString())) {
                    JOptionPane.showMessageDialog(null, "Please Fill Address in settings");
                } else {
                    buyPanel.setVisible(false);
                    productadd("a");
                    account();
                    logo.setText("My Account");
                    background.add(logo);
                    accountPanel.remove(nothingFound);
                    JOptionPane.showMessageDialog(null, "Your Order is Place :)");
                    accountPanel.setVisible(true);
                    flag.replace(0, flag.length(), "");
                    flag.append("7");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Log In!");
            }
        } else if (e.getSource() == addtokart) {

            if (log == true) {
                productadd("k");
                JOptionPane.showMessageDialog(null, "Item Added to kart :)");
                for (int i = 0; i < 4; i++) {
                    productsPanel.remove(products[i]);
                    productsPanel.remove(productsDetails[i]);
                    productsPanel.remove(nothingFound);
                    accountPanel.remove(nothingFound);
                }

                flashImages.setVisible(false);
                signUpPanel.setVisible(false);
                helpPanel.setVisible(false);
                accountPanel.setVisible(false);
                buyPanel.setVisible(false);
                showPanel.setVisible(false);
                settingsPanel.setVisible(false);
                f1.setVisible(false);
                background.setVisible(false);
                productsPanel.setVisible(true);
                kart();
            } else {
                JOptionPane.showMessageDialog(null, "Please Log In!");
            }

        } else if (e.getSource() == editButton[0]) {
            if (en1 == false) {
                editName.enable(true);
                editButton[0].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + "save.png")));
                en1 = true;
            } else {
                editName.enable(false);
                editButton[0].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + "edit.png")));
                updateFields(1);
                en1 = false;
            }
        } else if (e.getSource() == editButton[1]) {
            if (en2 == false) {
                editAddress.enable(true);
                editButton[1].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + "save.png")));
                en2 = true;
            } else {
                editAddress.enable(false);
                editButton[1].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + "edit.png")));
                updateFields(2);
                en2 = false;
            }
        }

        //showProducts Slection
        for (int i = 0; i < 4; i++) {
            if (e.getSource() == products[i]) {
                productsPanel.setVisible(false);
                ps.replace(0, ps.length(), "");
                ps.append(i);
                showProducts(i);
                background.setVisible(true);
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (e.getSource() == smallImages[i]) {
                ImageIcon icon2 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + folderName + "\\" + (i + 1) + ".jpeg"));
                Image img2 = icon2.getImage().getScaledInstance(bigImage.getWidth(), bigImage.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newicon2 = new ImageIcon(img2);
                bigImage.setIcon(newicon2);
            }
        }

        //menu button selection
        for (int i = 0; i < 6; i++) {
            if (e.getSource() == productsCatogery[i]) {
                flashImages.setVisible(false);
                counter = i + 1;
                f1.setVisible(false);
                background.setVisible(false);
                product();
                productsPanel.setVisible(true);
            }
        }

        throw new UnsupportedOperationException("Not supported yet.");
    }

    //Functions for Other Panels
    //buy()
    void buy() {
        flag.replace(0, flag.length(), "");
        flag.append("10");
        custDetails.setDisabledTextColor(Color.BLACK);
        custDetails.setText("Name: " + uname + "\nMobile Number: " + unumber + "\nAddress:\n" + uaddress);
        prodDetails.setDisabledTextColor(Color.BLACK);
        prodDetails.setText(dis.toString());

        float pri1 = Float.parseFloat(pri.toString());
        float d1 = Float.parseFloat(d.toString());
        float div1 = Float.parseFloat(div.toString());

        float total = pri1 - (pri1 * (d1 / 100)) + div1;
        priceDetails.setDisabledTextColor(Color.BLACK);
        priceDetails.setText("Price:" + pri + "\nDiscount:" + d + "%\nDilevery Charges:" + div + "\nTotal:" + String.valueOf(total));

    }

    //buy() ends
    void updateFields(int k) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt;
            ResultSet rs;
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buykart", "root", "jarvisk21")) {
                stmt = con.createStatement();
                rs = stmt.executeQuery("Select * from accounts");
                if (k == 1) {
                    String sql = "update accounts set name = '" + editName.getText() + "' where number = '" + unumber + "';";
                    int roweffected = stmt.executeUpdate(sql);
                    uname.replace(0, uname.length(), "");
                    uname.append(editName.getText());
                    usernameLabel.setText(uname.toString());

                } else {
                    String sql = "update accounts set address = '" + editAddress.getText() + "' where number = '" + unumber + "';";
                    int roweffected = stmt.executeUpdate(sql);
                    uaddress.replace(0, uaddress.length(), "");
                    uaddress.append(editAddress.getText());
                }
            }
            stmt.close();
            rs.close();

        } catch (HeadlessException | ClassNotFoundException | SQLException e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage());
            System.out.println(e1);
        }
    }
    //buy() ends

    //kart()
    void kart() {
        flag.replace(0, flag.length(), "");
        flag.append("2");
        add(productsPanel);
        productsPanel.setVisible(true);
        productHeader.setVisible(true);
        productHeader.add(backButton);
        logo.setText("MY Kart");
        productHeader.add(logo);
        kartbuyies("k");
    }
    //kart() ends

    //kart&buyies()
    void kartbuyies(String k) {

        int m = 0;
        String item = "";
        String item1 = "";
        int count = 1;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt;
            ResultSet rs;
            try (Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/buykart", "root", "jarvisk21")) {
                String sql = "Select * from " + k + unumber + ";";
                stmt = con.createStatement();
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    count = 0;
                    ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + rs.getString(1) + "\\1.jpeg"));
                    Image img = icon.getImage().getScaledInstance(products[m].getWidth(), products[m].getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newicon = new ImageIcon(img);

                    if ("k".equals(k)) {
                        products[m].setBounds(10, 110 + m + (m * 100), 100, 100);
                        productsDetails[m].setBounds(110, 110 + m + (m * 100), 215, 100);

                        productsPanel.add(productsDetails[m]);
                        productsPanel.add(products[m]);
                    } else {
                        products[m].setBounds(10, 10 + m + (m * 100), 100, 100);
                        productsDetails[m].setBounds(110, 10 + m + (m * 100), 215, 100);

                        accountPanel.add(productsDetails[m]);
                        accountPanel.add(products[m]);
                    }

                    productsDetails[m].setText(rs.getString(2) + "\nPrice: " + rs.getInt(3) + "\n" + rs.getString(4));
                    id[m] = rs.getString(1);
                    products[m].setIcon(newicon);
                    products[m].setVisible(true);
                    productsDetails[m].setVisible(true);

                    m++;
                    if (m == 5) {
                        m = 0;
                    }
                }
                if (count == 1) {
                    ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + "emptycart.png"));
                    Image img = icon.getImage().getScaledInstance(nothingFound.getWidth(), nothingFound.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newicon = new ImageIcon(img);
                    nothingFound.setIcon(newicon);

                    if ("k".equals(k)) {
                        nothingFound.setBounds(50, 200, 200, 200);
                        productsPanel.add(nothingFound);
                    } else {
                        nothingFound.setBounds(50, 100, 200, 200);
                        accountPanel.add(nothingFound);
                    }
                }
            }
            stmt.close();
            rs.close();

        } catch (ClassNotFoundException | SQLException e1) {

        }
    }
    //

    //productadd()
    void productadd(String k) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt;
            ResultSet rs;
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buykart", "root", "jarvisk21")) {
                stmt = con.createStatement();
                rs = stmt.executeQuery("Select * from " + k + unumber);
                if (k.equals("k")) {
                    String sql = "Insert into " + k + unumber + " (pcart,pname,pprice,pdate) values('" + pid + "','" + prod + "'," + Integer.parseInt(pri.toString()) + ",'" + LocalDate.now() + "');";
                    int roweffected = stmt.executeUpdate(sql);
                } else {

                    String sql = "Insert into " + k + unumber + " (pbuy,pname,pprice,pdate) values('" + pid + "','" + prod + "'," + Integer.parseInt(pri.toString()) + ",'" + LocalDate.now() + "');";
                    int roweffected = stmt.executeUpdate(sql);
                }
            }
            stmt.close();
            rs.close();

        } catch (HeadlessException | ClassNotFoundException | SQLException e1) {

        }
    }
    //productadd() ends

    //showProducts()
    void showProducts(int m) {

        folderName.replace(0, folderName.length(), id[m]);
        flag.replace(0, flag.length(), "");
        flag.append("9");

        add(background);
        background.add(backButton);
        background.add(showPanel);
        showPanel.setVisible(true);
        accountPanel.setVisible(false);
        helpPanel.setVisible(false);

        ImageIcon icon1 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + id[m] + "\\1.jpeg"));
        Image img = icon1.getImage().getScaledInstance(bigImage.getWidth(), bigImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newicon1 = new ImageIcon(img);
        bigImage.setIcon(newicon1);

        for (int i = 0; i < 4; i++) {
            ImageIcon icon2 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + id[m] + "\\" + (i + 1) + ".jpeg"));
            Image img2 = icon2.getImage().getScaledInstance(smallImages[i].getWidth(), smallImages[i].getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newicon2 = new ImageIcon(img2);
            smallImages[i].setIcon(newicon2);
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt;
            ResultSet rs;
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buykart", "root", "jarvisk21")) {
                stmt = con.createStatement();
                rs = stmt.executeQuery("Select * from products");
                while (rs.next()) {
                    String chk = rs.getString(1);

                    if (chk.equals(id[m])) {
                        pid.append(rs.getString(1));
                        prod.append(rs.getString(2));
                        pri.append(rs.getInt(7));
                        d.append(rs.getInt(8));
                        div.append(rs.getInt(9));
                        dis.append(rs.getString(11));
                    }
                }
            }
            stmt.close();
            rs.close();

        } catch (HeadlessException | ClassNotFoundException | SQLException e1) {

        }
        details.setDisabledTextColor(Color.BLACK);
        details.setText("\n" + prod + "\nPrice: " + pri + "\nDiscount: " + d + "%\nDelivery Charges: " + div + "\nDescription:\n" + dis.toString());
        logo.setText("" + prod);
        background.add(logo);
    }
    //showProducts() ends

    //product()
    void product() {

        flag.replace(0, flag.length(), "");
        flag.append("3");
        add(productsPanel);
        productsPanel.setVisible(true);
        productHeader.setVisible(true);
        productHeader.add(backButton);

        String catog;
        String item;
        int n = 1, m = 0;

        switch (counter) {

            case 1:
                logo.setText("Women Wear");
                catog = "women";
                break;

            case 2:
                logo.setText("Men Wear");
                catog = "men";
                break;

            case 3:
                logo.setText("Kids Wear");
                catog = "kids";
                break;

            case 4:
                logo.setText("Electronics");
                catog = "electronics";
                break;

            case 5:
                logo.setText("Books");
                catog = "book";
                break;

            case 6:
                logo.setText("Books");
                catog = "book";
                break;

            default:
                catog = searchField.getText();
                break;
        }
        productHeader.add(logo);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt;
            ResultSet rs;
            try (Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/buykart", "root", "jarvisk21")) {
                String sql = "Select * from products";
                stmt = con.createStatement();
                rs = stmt.executeQuery(sql);
                while (rs.next()) {

                    while (n < 10) {
                        item = rs.getString(n);
                        n++;

                        if (item.equalsIgnoreCase(catog)) {

                            id[m] = rs.getString(1);

                            ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(path + id[m] + "\\1.jpeg"));
                            Image img = icon.getImage().getScaledInstance(products[m].getWidth(), products[m].getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon newicon = new ImageIcon(img);

                            products[m].setBounds(10, 110 + m + (m * 100), 100, 100);
                            productsDetails[m].setBounds(110, 110 + m + (m * 100), 215, 100);

                            productsDetails[m].setText("\n" + rs.getString(2) + "\nPrice: " + rs.getInt(7) + "\nDiscount: " + rs.getInt(8) + "%");
                            productsDetails[m].setForeground(Color.black);
                            productsDetails[m].enable(false);

                            products[m].setIcon(newicon);
                            products[m].setVisible(true);
                            productsDetails[m].setVisible(true);
                            productsPanel.add(productsDetails[m]);
                            productsPanel.add(products[m]);
                            m++;
                            if (m == 5) {
                                m = 0;
                            }
                            break;
                        }
                    }
                    n = 1;
                }
            }
            stmt.close();
            rs.close();

        } catch (ClassNotFoundException | SQLException e1) {

        }

    }
    //product() ends

    //logIn()
    void logIn() {

        logo.setText("LogIn");
        background.add(logo);
        flag.replace(0, flag.length(), "");
        flag.append("4");
        background.add(backButton);

        usernameField.setBounds(70, 120, 200, 30);
        usernameField.setBackground(new Color(224, 224, 224));
        usernameField.setBorder(lb1);

        passwordField1.setBounds(70, 170, 200, 30);
        passwordField1.setBorder(lb1);
        passwordField1.setBackground(new Color(224, 224, 224));
        passwordField1.setEchoChar((char) 0);

        logInButton.setBounds(135, 230, 60, 30);
        logInButton.setBackground(new Color(229, 204, 255));
        logInButton.setBorder(lb1);
        logInButton.addActionListener(this);

        text.setBounds(x - 100, 300, x, 30);
        createAccount.setBounds(x - 120, 330, 100, 30);
        createAccount.setBorder(lb1);
        createAccount.setBackground(new Color(229, 204, 255));

        usernameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if ("".equals(passwordField1.getText())) {
                    passwordField1.setText("Password");
                    passwordField1.setEchoChar((char) 0);
                }

                if ("Mobile Number".equals(usernameField.getText())) {
                    usernameField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        passwordField1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                passwordField1.setEchoChar('*');
                if ("".equals(usernameField.getText())) {
                    usernameField.setText("Mobile Number");
                }

                if ("Password".equals(passwordField1.getText())) {
                    passwordField1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        logInPanel.add(usernameField);
        logInPanel.add(passwordField1);
        logInPanel.add(logInButton);
        logInPanel.add(text);
        logInPanel.add(createAccount);

        add(background);
        background.add(logInPanel);
        logInPanel.setVisible(true);
        accountPanel.setVisible(false);
        helpPanel.setVisible(false);

    }
    //logIn() Ends

    //signUp()
    void signUp() {

        logo.setText("SignUp");
        flag.replace(0, flag.length(), "");
        flag.append("5");

        background.add(logo);
        background.add(backButton);

        detailsField[0] = new JTextField("Name");
        detailsField[1] = new JTextField("Mobile Number");

        passwordField[0] = new JPasswordField("Password");
        passwordField[1] = new JPasswordField("Password");

        for (int i = 0; i < 2; i++) {

            detailsField[i].setBounds(70, 80 + (i * 50), 200, 30);
            detailsField[i].setBackground(new Color(192, 192, 192));
            detailsField[i].setBorder(lb1);

            signUpPanel.add(detailsField[i]);
        }

        for (int i = 0; i < 2; i++) {

            passwordField[i].setBounds(70, 180 + (i * 50), 200, 30);
            passwordField[i].setBackground(new Color(192, 192, 192));
            passwordField[i].setBorder(lb1);
            passwordField[i].setEchoChar((char) 0);
            signUpPanel.add(passwordField[i]);
        }

        detailsField[0].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if ("".equals(detailsField[1].getText())) {
                    detailsField[1].setText("Mobile Number");
                } else if ("".equals(passwordField[0].getText())) {
                    passwordField[0].setText("Password");
                    passwordField[0].setEchoChar((char) 0);
                } else if ("".equals(passwordField[1].getText())) {
                    passwordField[1].setText("Password");
                    passwordField[1].setEchoChar((char) 0);
                }

                if ("Name".equals(detailsField[0].getText())) {
                    detailsField[0].setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        detailsField[1].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if ("".equals(passwordField[0].getText())) {
                    passwordField[0].setText("Password");
                    passwordField[0].setEchoChar((char) 0);
                } else if ("".equals(detailsField[0].getText())) {
                    detailsField[0].setText("Name");
                } else if ("".equals(passwordField[1].getText())) {
                    passwordField[1].setText("Password");
                    passwordField[1].setEchoChar((char) 0);
                }

                if ("Mobile Number".equals(detailsField[1].getText())) {
                    detailsField[1].setText("");
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        passwordField[0].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                passwordField[0].setEchoChar('*');
                if ("".equals(detailsField[0].getText())) {
                    detailsField[0].setText("Name");
                } else if ("".equals(detailsField[1].getText())) {
                    detailsField[1].setText("Mobile Number");
                } else if ("".equals(passwordField[1].getText())) {
                    passwordField[1].setText("Password");
                    passwordField[1].setEchoChar((char) 0);
                }

                if ("Password".equals(passwordField[0].getText())) {
                    passwordField[0].setText("");
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        passwordField[1].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                passwordField[1].setEchoChar('*');
                if ("".equals(detailsField[0].getText())) {
                    detailsField[0].setText("Name");
                } else if ("".equals(detailsField[1].getText())) {
                    detailsField[1].setText("Mobile Number");
                } else if ("".equals(passwordField[0].getText())) {
                    passwordField[0].setText("Password");
                    passwordField[0].setEchoChar((char) 0);
                }

                if ("Password".equals(passwordField[1].getText())) {
                    passwordField[1].setText("");
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        signUpButton.setBounds(135, 290, 60, 30);
        signUpButton.setBackground(new Color(229, 204, 255));
        signUpButton.setBorder(lb1);

        signUpPanel.add(signUpButton);
        logInPanel.setVisible(false);
        signUpPanel.setVisible(true);

    }
    //signUp() Ends

    //settings()
    void settings() {
        flag.replace(0, flag.length(), "");
        flag.append("6");
        el[0] = new JLabel("Name:");
        el[0].setBounds(15, 10, 330, 30);

        el[1] = new JLabel("Address:");
        el[1].setBounds(15, 150, 330, 30);

        editName.setBounds(10, 40, 310, 100);
        editName.setDisabledTextColor(Color.BLACK);
        editAddress.setBounds(10, 180, 310, 100);
        editAddress.setDisabledTextColor(Color.BLACK);

        editName.setText(uname.toString());
        editAddress.setText(uaddress.toString());

        settingsPanel.add(editName);
        settingsPanel.add(editAddress);
        settingsPanel.add(el[0]);
        settingsPanel.add(el[1]);
        editName.setText(uname.toString());
        editAddress.setText(uaddress.toString());
        editName.add(editButton[0]);
        editAddress.add(editButton[1]);
        editName.enable(false);
        editAddress.enable(false);

    }
    //settings() ends

    //account()
    void account() {
        logo.setText("MY Account");
        background.add(logo);
        background.add(backButton);
        flag.replace(0, flag.length(), "");
        flag.append("7");

        usernameLabel.setBounds(10, 100, 300, 20);
        usernameLabel.setForeground(Color.white);
        usernameLabel.setFont(textFont);
        usernameLabel.setVisible(true);

        userNumberLabel.setBounds(10, 120, 300, 20);
        userNumberLabel.setForeground(Color.white);
        userNumberLabel.setFont(textFont);
        userNumberLabel.setVisible(true);

        background.add(usernameLabel);
        background.add(userNumberLabel);

        settings.setBounds(0, 340, 350, 40);
        settings.setBorderPainted(false);
        settings.setBackground(new Color(15, 37, 71));
        settings.setForeground(Color.white);
        logOutButton.setBounds(0, 380, 350, 40);
        logOutButton.setBorderPainted(false);
        logOutButton.setBackground(new Color(15, 37, 71));
        logOutButton.setForeground(Color.white);
        accountPanel.add(settings);
        accountPanel.add(logOutButton);

        add(background);
        background.add(accountPanel);
        logInPanel.setVisible(false);
        helpPanel.setVisible(false);
        signUpPanel.setVisible(false);
        accountPanel.setVisible(true);
        kartbuyies("a");
    }
    //account() ends

    //help()
    void help() {

        flag.replace(0, flag.length(), "");
        flag.append("8");
        logo.setText("ABOUT");
        background.add(logo);

        track.setBounds(50, 10, 70, 70);
        easy.setBounds(220, 10, 70, 70);
        fast.setBounds(140, 130, 70, 70);
        about.setBounds(70, 260, 200, 50);
        about.setText("<html>This is an online shopping app which is coded in java<br>created under no violation of laws</html>");
        about.setForeground(new Color(144, 146, 150));
        t.setBounds(40, 40, 100, 100);
        t.setForeground(new Color(64, 67, 71));
        e.setBounds(220, 40, 100, 100);
        e.setForeground(new Color(64, 67, 71));
        F.setBounds(130, 160, 100, 100);
        F.setForeground(new Color(64, 67, 71));
        copy.setText("@Copyright 2017");
        copy.setBounds(105, 310, 100, 50);
        copy.setForeground(new Color(144, 146, 150));

        design.setBounds(120, 330, 100, 50);
        design.setForeground(new Color(144, 146, 150));
        name.setBounds(65, 350, 200, 50);
        name.setForeground(new Color(144, 146, 150));

        helpPanel.add(about);
        helpPanel.add(track);
        helpPanel.add(easy);
        helpPanel.add(fast);
        helpPanel.add(t);
        helpPanel.add(e);
        helpPanel.add(F);
        helpPanel.add(copy);
        helpPanel.add(design);
        helpPanel.add(name);

        add(background);
        background.add(helpPanel);
        background.add(backButton);
        accountPanel.setVisible(false);
        logInPanel.setVisible(false);
        helpPanel.setVisible(true);

    }
    //help() ends

    //search()
    void search() {

        String cnumber = usernameField.getText();
        String cpass = passwordField1.getText();
        String cname;
        String caddress;
        String num;
        String pass;
        int count = 1;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt;
            ResultSet rs;
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buykart", "root", "jarvisk21")) {
                stmt = con.createStatement();
                rs = stmt.executeQuery("Select * from accounts");
                while (rs.next()) {
                    num = rs.getString(2);
                    pass = rs.getString(3);
                    caddress = rs.getString(4);

                    if (cnumber.equals(num) && cpass.equals(pass)) {
                        count = 0;
                        num = rs.getString(2);
                        cname = rs.getString(1);
                        usernameLabel.setText(cname);
                        userNumberLabel.setText(num);
                        uname.append(cname);
                        unumber.append(num);
                        uaddress.append(caddress);
                        log = true;
                        break;
                    }

                }
                if (count == 1) {
                    JOptionPane.showMessageDialog(null, "Mobile Number Not Registered yet OR Wrong Password");
                }
            }
            stmt.close();
            rs.close();

        } catch (HeadlessException | ClassNotFoundException | SQLException e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage());
            System.out.println("database error" + e1);
        }

    }
    //search() ends

    //addtoDatabase()
    void addtoDatabase() {

        String cname = detailsField[0].getText();
        String cnumber = detailsField[1].getText();
        String cpassword = passwordField[0].getText();
        String caddress = "";
        String num = "";
        int count = 1;

        if ("name".equalsIgnoreCase(cname)) {
            JOptionPane.showMessageDialog(null, "Use Different Name");
        } else if ("Mobile number".equalsIgnoreCase(cnumber) || cnumber.length() < 10 || cnumber.length() > 10) {
            JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
        } else if ("password".equalsIgnoreCase(cpassword)) {
            JOptionPane.showMessageDialog(null, "Use Different Password");
        } else if ("".equalsIgnoreCase(cname) || "".equalsIgnoreCase(cnumber) || "".equalsIgnoreCase(cpassword)) {
            JOptionPane.showMessageDialog(null, "Please Fill all the Fields");
        } else if (!cpassword.equals(passwordField[1].getText())) {
            JOptionPane.showMessageDialog(null, "Password Doesn't Match");
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Statement stmt;
                ResultSet rs;
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buykart", "root", "jarvisk21")) {
                    stmt = con.createStatement();
                    rs = stmt.executeQuery("Select * from accounts");
                    while (rs.next()) {
                        num = rs.getString(2);
                        caddress = rs.getString(4);
                        if (cnumber.equals(num)) {
                            count = 0;
                            JOptionPane.showMessageDialog(null, "Mobile Number Already Used");
                            break;
                        }

                    }
                    if (count == 1) {

                        String strSQL = "INSERT INTO accounts (name,number,password) VALUES('" + cname + "','" + (cnumber) + "','" + (cpassword) + "');";
                        String strSQL1 = "create table a" + cnumber + "(pbuy varchar(10),pname varchar(50),pprice  int,pdate varchar(20));";
                        String strSQL2 = "create table k" + cnumber + "(pcart varchar(10),pname varchar(50),pprice  int,pdate varchar(20));";
                        int roweffected = stmt.executeUpdate(strSQL);
                        log = true;
                        usernameLabel.setText(cname);
                        userNumberLabel.setText(cnumber);
                        uname.append(cname);
                        unumber.append(num);
                        uaddress.append(caddress);
                        int roweffected1 = stmt.executeUpdate(strSQL1);
                        int roweffected2 = stmt.executeUpdate(strSQL2);

                    }
                }
                stmt.close();
                rs.close();

            } catch (HeadlessException | ClassNotFoundException | SQLException e1) {
                JOptionPane.showMessageDialog(this, e1.getMessage());
                System.out.println(e1);
            }

        }
        detailsField[0].setText("Name");
        detailsField[1].setText("Mobile Number");
        passwordField[0].setText("Password");
        passwordField[1].setText("Password");

    }
    //addtoDatabase() Ends

}

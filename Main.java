
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    boolean nightmode = false;
    // panels
    JPanel modeSelect = new JPanel();

    // customer panels
    JPanel customerHome = new JPanel();
    JPanel menu = new JPanel();
    JPanel basket = new JPanel();

    // admin panels
    JPanel adminHome = new JPanel();
    JPanel viewProducts = new JPanel();
    JPanel sales = new JPanel();
    JPanel stock = new JPanel();
    JPanel report = new JPanel();
    JPanel delivery = new JPanel();
    JPanel login = new JPanel();

    JLabel loginHeading = new JLabel("Login");
    JLabel customerHeading = new JLabel("Home");
    JLabel adminHomeHeading = new JLabel("Home");
    JLabel viewProductsHeading = new JLabel("View Products");
    JLabel deliveryHeading = new JLabel("Delivery");
    JLabel stockHeading = new JLabel("Stock Levels");
    JLabel salesHeading = new JLabel("Sales");
    JLabel basketHeading = new JLabel("Basket");
    JLabel menuHeading = new JLabel("Menu");
    JLabel modeSelectHeading = new JLabel("Select Mode");
    JLabel reportHeading = new JLabel("Generate Report");

    JLabel usernameLbl = new JLabel("Username");
    JLabel passwordLbl = new JLabel("Password");

    Font heading = new Font("Arial", Font.PLAIN, 40); // custom font for headings
    Font textArea = new Font("Courier New", Font.PLAIN, 30); // custom font for text areas

    JFrame frame = new JFrame();
    private Basket b = new Basket(0, 0, 0, 0, 0);
    private Delivery d = new Delivery(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    JTextArea displaySales = new JTextArea();
    JTextArea displayReport = new JTextArea();

    ///essential stock components
    ImageIcon flour = new ImageIcon("images/flour.png");
    JLabel flourLbl = new JLabel(flour);
    JButton flourStock = new JButton("Stock Level: ");
    JButton moreFlour = new JButton("Add to Delivery");

    ImageIcon sausage = new ImageIcon("images/sausage.png");
    JLabel sausageLbl = new JLabel(sausage);
    JButton pepperoniStock = new JButton("Stock Level: " + d.getSausage());
    JButton morePepperoni = new JButton("Add to Delivery");

    ImageIcon basil = new ImageIcon("images/basil.png");
    JLabel basilLbl = new JLabel(basil);
    JButton basilStock = new JButton("Stock Level: " + d.getBasil());
    JButton moreBasil = new JButton("Add to Delivery");

    ImageIcon pineapple = new ImageIcon("images/pineapple.png");
    JLabel pineappleLbl = new JLabel(pineapple);
    JButton pineappleStock = new JButton("Stock Level: " + d.getPineappleTotal());
    JButton morePineapple = new JButton("Add to Delivery");

    ImageIcon ham = new ImageIcon("images/ham.png");
    JLabel hamLbl = new JLabel(ham);
    JButton hamStock = new JButton("Stock Level: " + d.getHam());
    JButton moreHam = new JButton("Add to Delivery");

    ImageIcon chickenBreast = new ImageIcon("images/chickenBreast.png");
    JLabel chickenBreastLbl = new JLabel(chickenBreast);
    JButton chickenStock = new JButton("Stock Level: " + d.getChickenBreast());
    JButton moreChicken = new JButton("Add to Delivery");

    ImageIcon tomatoes = new ImageIcon("images/tomatoes.png");
    JLabel tomatoesLbl = new JLabel(tomatoes);
    JButton tomatoStock = new JButton("Stock Level: " + d.getTomatoes());
    JButton moreTomatoes = new JButton("Add to Delivery");

    ImageIcon mozzarella = new ImageIcon("images/mozzarella.png");
    JLabel mozzarellaLbl = new JLabel(mozzarella);
    JButton mozzarellaStock = new JButton("Stock Level: " + d.getMozzarella());
    JButton moreMozzarella = new JButton("Add to Delivery");

    ImageIcon olive = new ImageIcon("images/olive.png");
    JLabel oliveLbl = new JLabel(olive);
    JButton oliveStock = new JButton("Stock Level: " + d.getOlive());
    JButton moreOlive = new JButton("Add to Delivery");

    ImageIcon garlicSupply = new ImageIcon("images/garlicSupply.png");
    JLabel garlicSupplyLbl = new JLabel(garlicSupply);
    JButton garlicStock = new JButton("Stock Level: " + d.getGarlicStock());
    JButton moreGarlic = new JButton("Add to Delivery");

    public static void main(String args[]) {
        Main m = new Main();

        m.main();
    }

    public void main() {
        JOptionPane.showMessageDialog(null, "Loading Components...Please click 'ok' to enter.", "Loading",
                JOptionPane.INFORMATION_MESSAGE);
        frame.setVisible(true);

        try {
            // applies look and feel to user interface
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        JFrame frame = new JFrame();

        JButton nightMode = new JButton("Toggle Night Mode");

        ///initialisation of JFrame
        frame.setSize(1500, 1500);
        frame.setLocation(0, 0);
        frame.setResizable(false);
        frame.setVisible(false);
        frame.setLayout(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initialisation of basket panel
        basket.setSize(1500, 1500);
        basket.setLocation(0, 0);
        basket.setBackground(Color.LIGHT_GRAY);
        basket.setLayout(null);
        basket.setVisible(false);
        // basket components
        JButton exitBasket = new JButton("Back");

        JButton submitOrder = new JButton("Submit Order");
        JScrollPane scrollPane = new JScrollPane(b.viewBasket, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // initialisation of basket components
        b.viewBasket.setSize(600, 300);
        b.viewBasket.setLocation(400, 200);
        b.viewBasket.setEditable(false);
        b.viewBasket.setFont(textArea);
        b.viewBasket.setLineWrap(true);

        scrollPane.setSize(600, 300); // <<< Set size of scrollPane
        scrollPane.setLocation(400, 200); // <<< Set location of scrollPane

        basket.add(scrollPane);

        basketHeading.setSize(400, 75);
        basketHeading.setLocation(650, 0);
        basketHeading.setFont(heading);
        basket.add(basketHeading);

        // takes the user from the basket screen to home screen
        exitBasket.setSize(300, 75);
        exitBasket.setLocation(0, 0);
        exitBasket.setBackground(Color.RED);
        exitBasket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                basket.setVisible(false);
                customerHome.setVisible(true);
            }
        });
        basket.add(exitBasket);

        // processes the users order
        // saves to sales.txt file
        submitOrder.setSize(250, 75);
        submitOrder.setLocation(575, 500);
        submitOrder.setBackground(Color.ORANGE);
        submitOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String forename = JOptionPane.showInputDialog(null, "Please enter your forename");
                String surname = JOptionPane.showInputDialog(null, "Please enter your surname");

                if (forename == null || surname == null) {
                    JOptionPane.showMessageDialog(null, "Order cancelled.");
                    return;
                }

                forename = forename.trim();
                surname = surname.trim();

                if (forename.isEmpty() || surname.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: One or both fields were left empty. Please try again.");
                    return;
                }

                if (!forename.matches("[a-zA-Z\\s'-]+") || !surname.matches("[a-zA-Z\\s'-]+")) {
                    JOptionPane.showMessageDialog(null,
                            "Error: Names may only contain letters, spaces, apostrophes, and hyphens.");
                    return;
                }

                b.setName(forename, surname);

                if (b.isBasketEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Your basket is empty. Please add at least one item before placing an order.");
                    return;
                }

                try (BufferedWriter bw = new BufferedWriter(new FileWriter("sales.txt", true))) {
                    bw.write("Customer Name: " + b.getName());
                    bw.newLine();

                    String[] basketLines = b.viewBasket.getText().split("\\n");
                    for (String item : basketLines) {
                        bw.write(item);
                        bw.newLine();
                    }
                    bw.newLine();

                    JOptionPane.showMessageDialog(null,
                            "Your order was successfully processed! Your order will be ready for collection in 30-50 minutes.");
                    b.viewBasket.setText("");
                    basket.setVisible(false);
                    customerHome.setVisible(true);
                    b.clearBasket();
                    b.clearName();

                    b.setChicken();
                    b.setMargherita();
                    b.setPepperoni();
                    b.setGarlic();
                    b.setHawaiian();

                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(null, "Failed to write to file.");
                }

                // reads the sales.txt file and then copies the contents to the sales text area
                // where the admin can see
                try (BufferedReader br = new BufferedReader(new FileReader("sales.txt"))) {
                    String line = br.readLine();
                    displaySales.setText("");
                    while (line != null) {
                        displaySales.append(line + "\n");
                        line = br.readLine();
                    }
                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(null, "Failed to read from file.");
                }
            }
        });

        basket.add(submitOrder);

        frame.add(basket);

        // initialisation of menu panel
        menu.setSize(1500, 1500);
        menu.setLocation(0, 0);
        menu.setBackground(Color.LIGHT_GRAY);
        menu.setVisible(false);
        menu.setLayout(null);

        // menu panel components
        JButton exitMenu = new JButton("Back");

        ImageIcon pepperoni2 = new ImageIcon("images/pepperoni.png");
        JLabel pepperoni2Lbl = new JLabel(pepperoni2);

        ImageIcon margherita2 = new ImageIcon("images/margherita.png");
        JLabel margherita2Lbl = new JLabel(margherita2);

        ImageIcon hawaiian2 = new ImageIcon("images/hawaiian.png");
        JLabel hawaiian2Lbl = new JLabel(hawaiian2);

        ImageIcon garlic2 = new ImageIcon("images/garlic.png");
        JLabel garlic2Lbl = new JLabel(garlic2);

        ImageIcon chicken2 = new ImageIcon("images/chicken.png");
        JLabel chicken2Lbl = new JLabel(chicken2);

        JButton addPepperoni2 = new JButton("Add to Order");
        JButton addMargherita2 = new JButton("Add to Order");
        JButton addHawaiian2 = new JButton("Add to Order");
        JButton addGarlic2 = new JButton("Add to Order");
        JButton addChicken2 = new JButton("Add to Order");

        // product description text boxes
        JTextArea pepperoniDescription = new JTextArea();
        JTextArea margheritaDescription = new JTextArea();
        JTextArea hawaiianDescription = new JTextArea();
        JTextArea garlicDescription = new JTextArea();
        JTextArea chickenDescription = new JTextArea();

        // initialisation of menu components
        pepperoniDescription.setSize(200, 200);
        pepperoniDescription.setLocation(100, 400);
        pepperoniDescription.setEditable(false);
        pepperoniDescription.setText(
                "Product: Pepperoni Pizza \n Price: £10 \n Ingredients: \n Pepperoni, Mozzarella, Olive Oil, \n Flour");
        menu.add(pepperoniDescription);

        margheritaDescription.setSize(200, 200);
        margheritaDescription.setLocation(350, 400);
        margheritaDescription.setEditable(false);
        margheritaDescription.setText(
                "Product: Margherita Pizza \n Price: £10 \n Ingredients: \n Mozzarella, Basil, Flour, \n Olive Oil");
        menu.add(margheritaDescription);

        hawaiianDescription.setSize(200, 200);
        hawaiianDescription.setLocation(600, 400);
        hawaiianDescription.setEditable(false);
        hawaiianDescription.setText(
                "Product: Hawaiian Pizza \n Price: £10 \n Ingredients: \n Ham, Pineapple, Mozzarella, \n Flour, Olive Oil");
        menu.add(hawaiianDescription);

        garlicDescription.setSize(200, 200);
        garlicDescription.setLocation(850, 400);
        garlicDescription.setEditable(false);
        garlicDescription.setText(
                "Product: Garlic Bread Pizza \n Price: £10 \n Ingredients: \n Garlic, Olive Oil, Mozzarella, \n Basil, Flour ");
        menu.add(garlicDescription);

        chickenDescription.setSize(200, 200);
        chickenDescription.setLocation(1100, 400);
        chickenDescription.setEditable(false);
        chickenDescription.setText(
                "Product: Chicken Pizza \n Price: £10 \n Ingredients: \n Pepperoni, Mozzarella, Flour, \n Olive Oil");
        menu.add(chickenDescription);

        addPepperoni2.setSize(200, 50);
        addPepperoni2.setLocation(100, 600);
        addPepperoni2.setBackground(Color.GREEN);
        addPepperoni2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.addPepperoni();
                b.setPepperoni();
                b.addToBasket();
            }
        });
        menu.add(addPepperoni2);

        //margherita button
        addMargherita2.setSize(200, 50);
        addMargherita2.setLocation(350, 600);
        addMargherita2.setBackground(Color.GREEN);
        addMargherita2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.addMargherita();
                b.setMargherita();
                b.addToBasket();
            }
        });
        menu.add(addMargherita2);

        //hawaiian button
        addHawaiian2.setSize(200, 50);
        addHawaiian2.setLocation(600, 600);
        addHawaiian2.setBackground(Color.GREEN);
        addHawaiian2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.addHawaiian();
                b.setHawaiian();
                b.addToBasket();
            }
        });
        menu.add(addHawaiian2);

        //garlic button
        addGarlic2.setSize(200, 50);
        addGarlic2.setLocation(850, 600);
        addGarlic2.setBackground(Color.GREEN);
        addGarlic2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.addGarlic();
                b.setGarlic();
                b.addToBasket();
            }
        });
        menu.add(addGarlic2);

        //chicken button
        addChicken2.setSize(200, 50);
        addChicken2.setLocation(1100, 600);
        addChicken2.setBackground(Color.GREEN);
        addChicken2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.addChicken();
                b.setChicken();
                b.addToBasket();
            }
        });
        menu.add(addChicken2);

        viewProducts.setSize(1500, 1500);
        viewProducts.setLocation(0, 0);
        viewProducts.setLayout(null);
        viewProducts.setVisible(false);
        viewProducts.setBackground(Color.LIGHT_GRAY);

        //initialisation of viewProducts components
        chicken2Lbl.setSize(200, 200);
        chicken2Lbl.setLocation(1100, 200);
        menu.add(chicken2Lbl);

        garlic2Lbl.setSize(200, 200);
        garlic2Lbl.setLocation(850, 200);
        menu.add(garlic2Lbl);

        margherita2Lbl.setSize(200, 200);
        margherita2Lbl.setLocation(350, 200);
        menu.add(margherita2Lbl);

        hawaiian2Lbl.setSize(200, 200);
        hawaiian2Lbl.setLocation(600, 200);
        menu.add(hawaiian2Lbl);

        pepperoni2Lbl.setLocation(100, 200);
        pepperoni2Lbl.setSize(200, 200);
        menu.add(pepperoni2Lbl);

        menuHeading.setSize(500, 75);
        menuHeading.setLocation(600, 0);
        menuHeading.setFont(heading);
        menu.add(menuHeading);

        exitMenu.setSize(250, 75);
        exitMenu.setLocation(0, 0);
        exitMenu.setBackground(Color.RED);
        exitMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                customerHome.setVisible(true);

            }
        });
        menu.add(exitMenu);

        frame.add(menu);

        //initialisation of modeSelect panel
        modeSelect.setSize(1500, 1500);
        modeSelect.setLocation(0, 0);
        modeSelect.setBackground(Color.LIGHT_GRAY);
        modeSelect.setLayout(null);
        modeSelect.setVisible(true);

        //modeSelect components

        JButton customerMode = new JButton("Customer");
        JButton adminMode = new JButton("Admin");

        nightMode.setSize(200, 50);
        nightMode.setLocation(0, 0);
        nightMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nightmode == false) {
                    loginHeading.setForeground(Color.WHITE);
                    customerHeading.setForeground(Color.WHITE);
                    salesHeading.setForeground(Color.WHITE);
                    deliveryHeading.setForeground(Color.WHITE);
                    adminHomeHeading.setForeground(Color.WHITE);
                    stockHeading.setForeground(Color.WHITE);
                    reportHeading.setForeground(Color.WHITE);
                    menuHeading.setForeground(Color.WHITE);
                    modeSelectHeading.setForeground(Color.WHITE);
                    basketHeading.setForeground(Color.WHITE);
                    usernameLbl.setForeground(Color.WHITE);
                    passwordLbl.setForeground(Color.WHITE);
                    viewProductsHeading.setForeground(Color.WHITE);

                    //set all screens (panels) to dark gray
                    menu.setBackground(Color.DARK_GRAY);
                    customerHome.setBackground(Color.DARK_GRAY);
                    basket.setBackground(Color.DARK_GRAY);
                    delivery.setBackground(Color.DARK_GRAY);
                    adminHome.setBackground(Color.DARK_GRAY);
                    stock.setBackground(Color.DARK_GRAY);
                    report.setBackground(Color.DARK_GRAY);
                    sales.setBackground(Color.DARK_GRAY);
                    modeSelect.setBackground(Color.DARK_GRAY);
                    login.setBackground(Color.DARK_GRAY);
                    viewProducts.setBackground(Color.DARK_GRAY);
                    nightmode = true;
                } else if (nightmode == true) {
                    loginHeading.setForeground(Color.BLACK);
                    customerHeading.setForeground(Color.BLACK);
                    salesHeading.setForeground(Color.BLACK);
                    deliveryHeading.setForeground(Color.BLACK);
                    adminHomeHeading.setForeground(Color.BLACK);
                    stockHeading.setForeground(Color.BLACK);
                    reportHeading.setForeground(Color.BLACK);
                    menuHeading.setForeground(Color.BLACK);
                    modeSelectHeading.setForeground(Color.BLACK);
                    basketHeading.setForeground(Color.BLACK);
                    usernameLbl.setForeground(Color.BLACK);
                    passwordLbl.setForeground(Color.BLACK);
                    viewProductsHeading.setForeground(Color.BLACK);

                    //set all screens (panels) to light gray
                    menu.setBackground(Color.LIGHT_GRAY);
                    customerHome.setBackground(Color.LIGHT_GRAY);
                    basket.setBackground(Color.LIGHT_GRAY);
                    delivery.setBackground(Color.LIGHT_GRAY);
                    adminHome.setBackground(Color.LIGHT_GRAY);
                    stock.setBackground(Color.LIGHT_GRAY);
                    report.setBackground(Color.LIGHT_GRAY);
                    sales.setBackground(Color.LIGHT_GRAY);
                    modeSelect.setBackground(Color.LIGHT_GRAY);
                    login.setBackground(Color.LIGHT_GRAY);
                    viewProducts.setBackground(Color.LIGHT_GRAY);

                    nightmode = false;

                }

            }
        });
        modeSelect.add(nightMode);

        modeSelectHeading.setLocation(600, 0);
        modeSelectHeading.setSize(400, 100);
        modeSelectHeading.setFont(heading);
        modeSelect.add(modeSelectHeading);

        customerMode.setSize(400, 500);
        customerMode.setLocation(300, 200);
        customerMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeSelect.setVisible(false);
                customerHome.setVisible(true);
            }
        });
        modeSelect.add(customerMode);

        adminMode.setSize(400, 500);
        adminMode.setLocation(800, 200);
        adminMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeSelect.setVisible(false);
                login.setVisible(true);

            }

        });
        modeSelect.add(adminMode);

        frame.add(modeSelect);

        //initialisation of login panel
        login.setSize(1500, 1500);
        login.setLocation(0, 0);
        login.setLayout(null);
        login.setVisible(false);
        login.setBackground(Color.LIGHT_GRAY);

        //login panel components

        JTextField username = new JTextField();

        JPasswordField password = new JPasswordField();

        JButton submitDetails = new JButton("Enter");
        JButton exitLogin = new JButton("Back");

        JButton tempLogin = new JButton("skip login");

        // initialisation of login panel components
        loginHeading.setSize(400, 75);
        loginHeading.setLocation(700, 200);
        loginHeading.setFont(heading);
        login.add(loginHeading);

        username.setSize(400, 75);
        username.setLocation(600, 400);
        username.setFont(textArea);
        login.add(username);

        usernameLbl.setSize(300, 75);
        usernameLbl.setLocation(400, 400);
        usernameLbl.setFont(heading);
        login.add(usernameLbl);

        password.setSize(400, 75);
        password.setLocation(600, 500);
        password.setFont(textArea);
        login.add(password);

        passwordLbl.setSize(300, 75);
        passwordLbl.setLocation(400, 500);
        passwordLbl.setFont(heading);
        login.add(passwordLbl);

        submitDetails.setSize(300, 75);
        submitDetails.setLocation(650, 600);
        submitDetails.setBackground(Color.YELLOW);
        submitDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = username.getText();
                String enteredPassword = new String(password.getPassword());

                //validate login credentials
                if ("admin123".equals(enteredUsername) && "123".equals(enteredPassword)) {
                    JOptionPane.showMessageDialog(frame, "Login successful! Welcome Admin.");
                    login.setVisible(false);
                    adminHome.setVisible(true);

                    d.initiateStock();
                    //flour
                    flourStock.setText("Stock Level: " + d.getFlour());
                    if (d.getFlour() > 5) {
                        flourStock.setBackground(Color.GREEN);
                    } else if (d.getFlour() > 1) {
                        flourStock.setBackground(Color.YELLOW);
                    } else {
                        flourStock.setBackground(Color.RED);
                    }

                    //olive
                    oliveStock.setText("Stock Level: " + d.getOlive());
                    if (d.getOlive() > 5) {
                        oliveStock.setBackground(Color.GREEN);
                    } else if (d.getOlive() > 1) {
                        oliveStock.setBackground(Color.YELLOW);
                    } else {
                        oliveStock.setBackground(Color.RED);
                    }

                    //sausage
                    pepperoniStock.setText("Stock Level: " + d.getSausage());
                    if (d.getSausage() > 5) {
                        pepperoniStock.setBackground(Color.GREEN);
                    } else if (d.getSausage() > 1) {
                        pepperoniStock.setBackground(Color.YELLOW);
                    } else {
                        pepperoniStock.setBackground(Color.RED);
                    }

                    //mozzarella
                    mozzarellaStock.setText("Stock Level: " + d.getMozzarella());
                    if (d.getMozzarella() > 5) {
                        mozzarellaStock.setBackground(Color.GREEN);
                    } else if (d.getMozzarella() > 1) {
                        mozzarellaStock.setBackground(Color.YELLOW);
                    } else {
                        mozzarellaStock.setBackground(Color.RED);
                    }

                    // garlic
                    garlicStock.setText("Stock Level: " + d.getGarlicStock());
                    if (d.getGarlicStock() > 5) {
                        garlicStock.setBackground(Color.GREEN);
                    } else if (d.getGarlicStock() > 1) {
                        garlicStock.setBackground(Color.YELLOW);
                    } else {
                        garlicStock.setBackground(Color.RED);
                    }

                    //basil
                    basilStock.setText("Stock Level: " + d.getBasil());
                    if (d.getBasil() > 5) {
                        basilStock.setBackground(Color.GREEN);
                    } else if (d.getBasil() > 1) {
                        basilStock.setBackground(Color.YELLOW);
                    } else {
                        basilStock.setBackground(Color.RED);
                    }

                    //pineapple
                    pineappleStock.setText("Stock Level: " + d.getPineappleTotal());
                    if (d.getPineappleTotal() > 5) {
                        pineappleStock.setBackground(Color.GREEN);
                    } else if (d.getPineappleTotal() > 1) {
                        pineappleStock.setBackground(Color.YELLOW);
                    } else {
                        pineappleStock.setBackground(Color.RED);
                    }

                    //ham
                    hamStock.setText("Stock Level: " + d.getHam());
                    if (d.getHam() > 5) {
                        hamStock.setBackground(Color.GREEN);
                    } else if (d.getHam() > 1) {
                        hamStock.setBackground(Color.YELLOW);
                    } else {
                        hamStock.setBackground(Color.RED);
                    }

                    // chicken breast
                    chickenStock.setText("Stock Level: " + d.getChickenBreast());
                    if (d.getChickenBreast() > 5) {
                        chickenStock.setBackground(Color.GREEN);
                    } else if (d.getChickenBreast() > 1) {
                        chickenStock.setBackground(Color.YELLOW);
                    } else {
                        chickenStock.setBackground(Color.RED);
                    }

                    //tomatoes
                    tomatoStock.setText("Stock Level: " + d.getTomatoes());
                    if (d.getTomatoes() > 5) {
                        tomatoStock.setBackground(Color.GREEN);
                    } else if (d.getTomatoes() > 1) {
                        tomatoStock.setBackground(Color.YELLOW);
                    } else {
                        tomatoStock.setBackground(Color.RED);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password.");
                }
            }
        });
        login.add(submitDetails);

        exitLogin.setSize(300, 75);
        exitLogin.setLocation(0, 0);
        exitLogin.setBackground(Color.RED);
        exitLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                modeSelect.setVisible(true);
            }
        });

        login.add(exitLogin);

        tempLogin.setSize(300, 75);
        tempLogin.setLocation(1000, 600);
        tempLogin.setBackground(Color.ORANGE);
        tempLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                adminHome.setVisible(true);
            }
        });

        frame.add(login);

        //initialisation of customerHome panel
        customerHome.setSize(1500, 1500);
        customerHome.setLocation(0, 0);
        customerHome.setLayout(null);
        customerHome.setBackground(Color.LIGHT_GRAY);
        customerHome.setVisible(false);

        // customerHome components

        JButton toMenu = new JButton("Menu");
        JButton toBasket = new JButton("Basket");
        JButton leaveHome = new JButton("Back");

        //initialisation of customerHome components
        customerHeading.setSize(300, 75);
        customerHeading.setLocation(600, 0);
        customerHeading.setFont(heading);
        customerHome.add(customerHeading);

        leaveHome.setSize(300, 75);
        leaveHome.setLocation(0, 0);
        leaveHome.setBackground(Color.RED);
        leaveHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int choice = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit the order portal? - the contents of your basket will be cleared on exit ",
                        "Exit",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Returning to mode selection screen");
                    customerHome.setVisible(false);
                    modeSelect.setVisible(true);

                    frame.revalidate();
                    frame.repaint();

                } else {
                }
            }
        });
        customerHome.add(leaveHome);

        toMenu.setSize(500, 150);
        toMenu.setLocation(400, 300);
        toMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(true);
                customerHome.setVisible(false);

            }
        });
        customerHome.add(toMenu);

        toBasket.setSize(500, 150);
        toBasket.setLocation(400, 500);
        toBasket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerHome.setVisible(false);
                basket.setVisible(true);
            }
        });
        customerHome.add(toBasket);

        frame.add(customerHome);

        //initialisations of 'adminHome' panel
        adminHome.setSize(1500, 1500);
        adminHome.setLocation(0, 0);
        adminHome.setBackground(Color.LIGHT_GRAY);
        adminHome.setVisible(false);
        adminHome.setLayout(null);

        //adminHome panel components

        JButton toviewProducts = new JButton("View Products");
        JButton toStock = new JButton("View Stock Levels");
        JButton toSales = new JButton("View Sales");
        JButton toReport = new JButton("Generate a report");
        JButton exitAdminHome = new JButton("Back");

        //initialisation of adminHome panel componenets

        exitAdminHome.setSize(300, 75);
        exitAdminHome.setLocation(0, 0);
        exitAdminHome.setBackground(Color.RED);
        exitAdminHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminHome.setVisible(false);
                modeSelect.setVisible(true);
            }
        });
        adminHome.add(exitAdminHome);

        adminHomeHeading.setSize(300, 75);
        adminHomeHeading.setLocation(600, 0);
        adminHomeHeading.setFont(heading);
        adminHome.add(adminHomeHeading);

        toviewProducts.setSize(400, 100);
        toviewProducts.setLocation(450, 225);
        toviewProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminHome.setVisible(false);
                viewProducts.setVisible(true);

            }
        });
        adminHome.add(toviewProducts);

        toStock.setSize(400, 100);
        toStock.setLocation(450, 350);
        toStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminHome.setVisible(false);
                stock.setVisible(true);

            }

        });
        adminHome.add(toStock);

        toSales.setSize(400, 100);
        toSales.setLocation(450, 475);
        toSales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminHome.setVisible(false);
                sales.setVisible(true);
                try (BufferedReader br = new BufferedReader(new FileReader("sales.txt"))) {

                    String line = br.readLine();
                    displaySales.setText("");
                    while (line != null) {
                        displaySales.append(line + "\n");
                        line = br.readLine();
                    }

                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(null, "Failed to read file");
                }
            }

        });
        adminHome.add(toSales);

        toReport.setSize(400, 100);
        toReport.setLocation(450, 600);
        toReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminHome.setVisible(false);
                report.setVisible(true);
            }
        });
        adminHome.add(toReport);

        frame.add(adminHome);

        //viewProducts panel components
        JButton exitviewProducts = new JButton("Back");

        ImageIcon pepperoni = new ImageIcon("images/pepperoni.png");
        JLabel pepperoniLbl = new JLabel(pepperoni);
        JTextArea pepperoniDesc = new JTextArea();

        ImageIcon margherita = new ImageIcon("images/margherita.png");
        JLabel margheritaLbl = new JLabel(margherita);
        JTextArea margheritaDesc = new JTextArea();

        ImageIcon hawaiian = new ImageIcon("images/hawaiian.png");
        JLabel hawaiianLbl = new JLabel(hawaiian);
        JTextArea hawaiianDesc = new JTextArea();

        ImageIcon garlic = new ImageIcon("images/garlic.png");
        JLabel garlicLbl = new JLabel(garlic);
        JTextArea garlicDesc = new JTextArea();

        ImageIcon chicken = new ImageIcon("images/chicken.png");
        JLabel chickenLbl = new JLabel(chicken);
        JTextArea chickenDesc = new JTextArea();

        // initialisation of viewProducts panel
        viewProducts.setSize(1500, 1500);
        viewProducts.setLocation(0, 0);
        viewProducts.setLayout(null);
        viewProducts.setVisible(false);
        viewProducts.setBackground(Color.LIGHT_GRAY);

        //initialisation of viewProducts components
        chickenLbl.setSize(200, 200);
        chickenLbl.setLocation(1100, 200);
        viewProducts.add(chickenLbl);

        chickenDesc.setSize(200, 200);
        chickenDesc.setLocation(1100, 400);
        chickenDesc.setEditable(false);
        chickenDesc.setText(
                "Product: Chicken Pizza \n Price: £10 \nIngredients: \n Pepperoni, Mozzarella, Flour, \n Olive Oil");
        viewProducts.add(chickenDesc);

        garlicLbl.setSize(200, 200);
        garlicLbl.setLocation(850, 200);
        viewProducts.add(garlicLbl);

        garlicDesc.setSize(200, 200);
        garlicDesc.setLocation(850, 400);
        garlicDesc.setText(
                "Product: Garlic Bread Pizza \n Price: £10 \n Ingredients: \n Garlic, Olive Oil, Mozzarella, \n Basil, Flour ");
        garlicDesc.setEditable(false);
        viewProducts.add(garlicDesc);

        margheritaLbl.setSize(200, 200);
        margheritaLbl.setLocation(350, 200);
        viewProducts.add(margheritaLbl);

        margheritaDesc.setSize(200, 200);
        margheritaDesc.setLocation(350, 400);
        margheritaDesc.setEditable(false);
        margheritaDesc.setText(
                "Product: Margherita Pizza \n Price: £10 \n Ingredients: \n Mozzarella, Basil, Flour, \n Olive Oil");
        viewProducts.add(margheritaDesc);

        hawaiianLbl.setSize(200, 200);
        hawaiianLbl.setLocation(600, 200);
        viewProducts.add(hawaiianLbl);

        hawaiianDesc.setSize(200, 200);
        hawaiianDesc.setLocation(600, 400);
        hawaiianDesc.setEditable(false);
        hawaiianDesc.setText(
                "Product: Hawaiian Pizza \n Price: £10 \n Ingredients: \n Ham, Pineapple, Mozzarella, \n Flour, Olive Oil");
        viewProducts.add(hawaiianDesc);

        pepperoniLbl.setLocation(100, 200);
        pepperoniLbl.setSize(200, 200);
        viewProducts.add(pepperoniLbl);

        pepperoniDesc.setSize(200, 200);
        pepperoniDesc.setLocation(100, 400);
        pepperoniDesc.setText(
                "Product: Pepperoni Pizza \n Price: £10 \n Ingredients: \n Pepperoni, Mozzarella, Olive Oil, \n Flour");
        pepperoniDesc.setEditable(false);
        viewProducts.add(pepperoniDesc);

        viewProductsHeading.setSize(500, 75);
        viewProductsHeading.setLocation(600, 0);
        viewProductsHeading.setFont(heading);
        viewProducts.add(viewProductsHeading);

        exitviewProducts.setSize(250, 75);
        exitviewProducts.setLocation(0, 0);
        exitviewProducts.setBackground(Color.RED);
        exitviewProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewProducts.setVisible(false);
                adminHome.setVisible(true);

                frame.revalidate();
                frame.repaint();

            }
        });
        viewProducts.add(exitviewProducts);

        frame.add(viewProducts); // keep here

        //initialisation of delivery panel
        delivery.setSize(1500, 1500);
        delivery.setLocation(0, 0);
        delivery.setLayout(null);
        delivery.setBackground(Color.LIGHT_GRAY);
        delivery.setVisible(false);

        //delivery panel components

        JButton exitDelivery = new JButton("Back");

        JButton confirmOrder = new JButton("Confirm Order");

        //initialisation of delivery components

        exitDelivery.setSize(200, 75);
        exitDelivery.setLocation(0, 0);
        exitDelivery.setBackground(Color.RED);
        exitDelivery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delivery.setVisible(false);
                stock.setVisible(true);
            }
        });
        delivery.add(exitDelivery);

        deliveryHeading.setSize(300, 75);
        deliveryHeading.setLocation(650, 0);
        deliveryHeading.setFont(heading);
        delivery.add(deliveryHeading);

        d.viewOrder.setSize(800, 500);
        d.viewOrder.setLocation(350, 100);
        d.viewOrder.setEditable(false);
        d.viewOrder.setFont(textArea);
        delivery.add(d.viewOrder);

        confirmOrder.setSize(250, 75);
        confirmOrder.setLocation(630, 650);
        confirmOrder.setBackground(Color.ORANGE);
        confirmOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!d.viewOrder.getText().equals("")) {

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("adminDeliveries.txt", true))) {
                        bw.write(d.viewOrder.getText());
                        bw.newLine();
                    } catch (IOException exc) {
                        JOptionPane.showMessageDialog(null, "Failed to write to file");
                    }

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("stockQuantities.txt", false))) {

                        bw.write(String.valueOf(d.getFlour()));
                        bw.newLine();
                        bw.write(String.valueOf(d.getOlive()));
                        bw.newLine();
                        bw.write(String.valueOf(d.getSausage()));
                        bw.newLine();
                        bw.write(String.valueOf(d.getBasil()));
                        bw.newLine();
                        bw.write(String.valueOf(d.getTomatoes()));
                        bw.newLine();
                        bw.write(String.valueOf(d.getGarlicStock()));
                        bw.newLine();
                        bw.write(String.valueOf(d.getPineappleTotal()));
                        bw.newLine();
                        bw.write(String.valueOf(d.getHam()));
                        bw.newLine();
                        bw.write(String.valueOf(d.getChickenBreast()));
                        bw.newLine();
                        bw.write(String.valueOf(d.getMozzarella()));

                    } catch (IOException exc) {
                        JOptionPane.showMessageDialog(null, "Failed to write file");
                    }

                    JOptionPane.showMessageDialog(null,
                            "Your order was successful! Your delivery is scheduled to arrive soon.");
                    delivery.setVisible(false);
                    stock.setVisible(true);
                    d.viewOrder.setText("");
                    d.clearDelivery();
                    d.clearDeliveryTotal();

                    try { // adds a 2.5 second delay to simulate delivery time
                        Thread.sleep(2500);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }

                    //flour
                    flourStock.setText("Stock Level: " + d.getFlour());
                    if (d.getFlour() > 5) {
                        flourStock.setBackground(Color.GREEN);
                    } else if (d.getFlour() > 1) {
                        flourStock.setBackground(Color.YELLOW);
                    } else {
                        flourStock.setBackground(Color.RED);
                    }

                    //olive oil
                    oliveStock.setText("Stock Level: " + d.getOlive());
                    if (d.getOlive() > 5) {
                        oliveStock.setBackground(Color.GREEN);
                    } else if (d.getOlive() > 1) {
                        oliveStock.setBackground(Color.YELLOW);
                    } else {
                        oliveStock.setBackground(Color.RED);
                    }

                    //sausage/pepperoni
                    pepperoniStock.setText("Stock Level: " + d.getSausage());
                    if (d.getSausage() > 5) {
                        pepperoniStock.setBackground(Color.GREEN);
                    } else if (d.getSausage() > 1) {
                        pepperoniStock.setBackground(Color.YELLOW);
                    } else {
                        pepperoniStock.setBackground(Color.RED);
                    }

                    // Mozzarella
                    mozzarellaStock.setText("Stock Level: " + d.getMozzarella());
                    if (d.getMozzarella() > 5) {
                        mozzarellaStock.setBackground(Color.GREEN);
                    } else if (d.getMozzarella() > 1) {
                        mozzarellaStock.setBackground(Color.YELLOW);
                    } else {
                        mozzarellaStock.setBackground(Color.RED);
                    }

                    //garlic
                    garlicStock.setText("Stock Level: " + d.getGarlicStock());
                    if (d.getGarlicStock() > 5) {
                        garlicStock.setBackground(Color.GREEN);
                    } else if (d.getGarlicStock() > 1) {
                        garlicStock.setBackground(Color.YELLOW);
                    } else {
                        garlicStock.setBackground(Color.RED);
                    }

                    //basil
                    basilStock.setText("Stock Level: " + d.getBasil());
                    if (d.getBasil() > 5) {
                        basilStock.setBackground(Color.GREEN);
                    } else if (d.getBasil() > 1) {
                        basilStock.setBackground(Color.YELLOW);
                    } else {
                        basilStock.setBackground(Color.RED);
                    }

                    //pinapple
                    pineappleStock.setText("Stock Level: " + d.getPineappleTotal());
                    if (d.getPineappleTotal() > 5) {
                        pineappleStock.setBackground(Color.GREEN);
                    } else if (d.getPineappleTotal() > 1) {
                        pineappleStock.setBackground(Color.YELLOW);
                    } else {
                        pineappleStock.setBackground(Color.RED);
                    }

                    //ham
                    hamStock.setText("Stock Level: " + d.getHam());
                    if (d.getHam() > 5) {
                        hamStock.setBackground(Color.GREEN);
                    } else if (d.getHam() > 1) {
                        hamStock.setBackground(Color.YELLOW);
                    } else {
                        hamStock.setBackground(Color.RED);
                    }

                    //chicken Breast
                    chickenStock.setText( "Stock Level: " + d.getChickenBreast());
                    if (d.getChickenBreast() > 5) {
                        chickenStock.setBackground(Color.GREEN);
                    } else if (d.getChickenBreast() > 1) {
                        chickenStock.setBackground(Color.YELLOW);
                    } else {
                        chickenStock.setBackground(Color.RED);
                    }

                    //tomatoes
                    tomatoStock.setText("Stock Level: " + d.getTomatoes());
                    if (d.getTomatoes() > 5) {
                        tomatoStock.setBackground(Color.GREEN);
                    } else if (d.getTomatoes() > 1) {
                        tomatoStock.setBackground(Color.YELLOW);
                    } else {
                        tomatoStock.setBackground(Color.RED);
                    }

                    JOptionPane.showMessageDialog(null,
                            "Your delivery has arrived and your ingedients supply has been restocked!");
                    d.viewOrder.setText("");

                }

            }
        });
        delivery.add(confirmOrder);

        frame.add(delivery);

        //initialisation of stock panel
        stock.setSize(1500, 1500);
        stock.setLocation(0, 0);
        stock.setLayout(null);
        stock.setBackground(Color.LIGHT_GRAY);
        stock.setVisible(false);

        //stock panel components

        JButton toDeliveryScreen = new JButton("View Order");

        JButton exitStock = new JButton("Back");
        JButton scheduleDelivery = new JButton("Schedule Delivery");

        // initialisation of stock components

        toDeliveryScreen.setSize(250, 75);
        toDeliveryScreen.setLocation(575, 700);
        toDeliveryScreen.setBackground(Color.ORANGE);
        toDeliveryScreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.addToDelivery();
                delivery.setVisible(true);
                stock.setVisible(false);
            }
        });
        stock.add(toDeliveryScreen);

        flourStock.setLocation(100, 100);
        flourStock.setSize(200, 25);
        flourStock.setBackground(Color.RED);
        flourStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // removes button click effect
            }
        });
        stock.add(flourStock);

        moreFlour.setLocation(100, 325);
        moreFlour.setSize(200, 50);
        moreFlour.setBackground(Color.GREEN);
        moreFlour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                d.addFlour();
                d.setFlourTotal();
                JOptionPane.showMessageDialog(null, "Flour added to delivery order");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        });
        stock.add(moreFlour);

        pepperoniStock.setLocation(600, 100);
        pepperoniStock.setSize(200, 25);
        pepperoniStock.setBackground(Color.RED);
        pepperoniStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // removes button click effect
            }
        });
        stock.add(pepperoniStock);

        morePepperoni.setLocation(600, 325);
        morePepperoni.setSize(200, 50);
        morePepperoni.setBackground(Color.GREEN);
        morePepperoni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.addSausage();
                d.setSausageTotal();
                JOptionPane.showMessageDialog(null, "Pepperoni added to delivery order");
            }
        });
        stock.add(morePepperoni);

        oliveStock.setSize(200, 25);
        oliveStock.setLocation(350, 100);
        oliveStock.setBackground(Color.RED);
        oliveStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // removes button click effect
            }
        });
        stock.add(oliveStock);

        moreOlive.setSize(200, 50);
        moreOlive.setLocation(350, 325);
        moreOlive.setBackground(Color.GREEN);
        moreOlive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.addOlive();
                d.setOliveTotal();
                JOptionPane.showMessageDialog(null, "Olive oil added to delivery order");
            }
        });
        stock.add(moreOlive);

        basilStock.setSize(200, 25);
        basilStock.setLocation(850, 100);
        basilStock.setBackground(Color.RED);
        basilStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // removes button click effect
            }
        });
        stock.add(basilStock);

        moreBasil.setSize(200, 50);
        moreBasil.setLocation(850, 325);
        moreBasil.setBackground(Color.GREEN);
        moreBasil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.addBasil();
                d.setBasilTotal();
                JOptionPane.showMessageDialog(null, "Basil added to delivery order");
            }
        });
        stock.add(moreBasil);

        tomatoStock.setSize(200, 25);
        tomatoStock.setLocation(1100, 100);
        tomatoStock.setBackground(Color.RED);
        tomatoStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // removes button click effect
            }
        });
        stock.add(tomatoStock);

        moreTomatoes.setSize(200, 50);
        moreTomatoes.setLocation(1100, 325);
        moreTomatoes.setBackground(Color.GREEN);
        moreTomatoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.addTomatoes();
                d.setTomatoesTotal();
                JOptionPane.showMessageDialog(null, "Tomaotes added to delivery order");
            }
        });
        stock.add(moreTomatoes);

        garlicStock.setSize(200, 25);
        garlicStock.setLocation(100, 425);
        garlicStock.setBackground(Color.RED);
        garlicStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // removes button click effect
            }
        });
        stock.add(garlicStock);

        moreGarlic.setSize(200, 50);
        moreGarlic.setLocation(100, 650);
        moreGarlic.setBackground(Color.GREEN);
        moreGarlic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.addGarlic();
                d.setGarlicStockTotal();
                JOptionPane.showMessageDialog(null, "Garlic added to delivery order");
            }
        });
        stock.add(moreGarlic);

        pineappleStock.setSize(200, 25);
        pineappleStock.setLocation(350, 425);
        pineappleStock.setBackground(Color.RED);
        pineappleStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // removes button click effect
            }
        });
        stock.add(pineappleStock);

        morePineapple.setSize(200, 50);
        morePineapple.setLocation(350, 650);
        morePineapple.setBackground(Color.GREEN);
        morePineapple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.addPineapple();
                d.setPineappleTotal();
                JOptionPane.showMessageDialog(null, "Pineapple added to delivery order");
            }
        });
        stock.add(morePineapple);

        hamStock.setSize(200, 25);
        hamStock.setLocation(600, 425);
        hamStock.setBackground(Color.RED);
        hamStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // removes button click effect
            }
        });
        stock.add(hamStock);

        moreHam.setSize(200, 50);
        moreHam.setLocation(600, 650);
        moreHam.setBackground(Color.GREEN);
        moreHam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.addHam();
                d.setHamTotal();
                JOptionPane.showMessageDialog(null, "Ham added to delivery order");
            }
        });
        stock.add(moreHam);

        chickenStock.setSize(200, 25);
        chickenStock.setLocation(850, 425);
        chickenStock.setBackground(Color.RED);
        chickenStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // removes button click effect
            }
        });
        stock.add(chickenStock);

        moreChicken.setSize(200, 50);
        moreChicken.setLocation(850, 650);
        moreChicken.setBackground(Color.GREEN);
        moreChicken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.addChickenBreast();
                d.setChickenBreastTotal();
                JOptionPane.showMessageDialog(null, "Chicken added to delivery order");
            }
        });
        stock.add(moreChicken);

        mozzarellaStock.setSize(200, 25);
        mozzarellaStock.setLocation(1100, 425);
        mozzarellaStock.setBackground(Color.RED);
        mozzarellaStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // removes button click effect
            }
        });
        stock.add(mozzarellaStock);

        moreMozzarella.setSize(200, 50);
        moreMozzarella.setLocation(1100, 650);
        moreMozzarella.setBackground(Color.GREEN);
        moreMozzarella.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.addMozzarella();
                d.setMozzarellaTotal();
                JOptionPane.showMessageDialog(null, "Mozzarella added to delivery order" + d.getMozzarella());
            }

        });
        stock.add(moreMozzarella);

        flourLbl.setLocation(100, 125);
        flourLbl.setSize(200, 200);
        stock.add(flourLbl);

        oliveLbl.setLocation(350, 125);
        oliveLbl.setSize(200, 200);
        stock.add(oliveLbl);

        sausageLbl.setSize(200, 200);
        sausageLbl.setLocation(600, 125);
        stock.add(sausageLbl);

        basilLbl.setSize(200, 200);
        basilLbl.setLocation(850, 125);
        stock.add(basilLbl);

        tomatoesLbl.setSize(200, 200);
        tomatoesLbl.setLocation(1100, 125);
        stock.add(tomatoesLbl);

        garlicSupplyLbl.setSize(200, 200);
        garlicSupplyLbl.setLocation(100, 450);
        stock.add(garlicSupplyLbl);

        pineappleLbl.setSize(200, 200);
        pineappleLbl.setLocation(350, 450);
        stock.add(pineappleLbl);

        hamLbl.setSize(200, 200);
        hamLbl.setLocation(600, 450);
        stock.add(hamLbl);

        chickenBreastLbl.setSize(200, 200);
        chickenBreastLbl.setLocation(850, 450);
        stock.add(chickenBreastLbl);

        mozzarellaLbl.setSize(200, 200);
        mozzarellaLbl.setLocation(1100, 450);
        stock.add(mozzarellaLbl);

        stockHeading.setSize(500, 100);
        stockHeading.setLocation(600, 0);
        stockHeading.setFont(heading);
        stock.add(stockHeading);

        exitStock.setSize(300, 75);
        exitStock.setLocation(0, 0);
        exitStock.setBackground(Color.RED);
        exitStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stock.setVisible(false);
                adminHome.setVisible(true);
            }
        });
        stock.add(exitStock);

        scheduleDelivery.setSize(250, 75);
        scheduleDelivery.setLocation(600, 600);
        scheduleDelivery.setBackground(Color.ORANGE);
        scheduleDelivery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        frame.add(stock);

        // initialisation of sales panel
        sales.setSize(1500, 1500);
        sales.setLocation(0, 0);
        sales.setLayout(null);
        sales.setBackground(Color.LIGHT_GRAY);
        sales.setVisible(false);

        // sales panel components

        JButton exitSales = new JButton("Back");
        JScrollPane salesScroll = new JScrollPane(displaySales, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // initialisation of sales components
        displaySales.setSize(1000, 600);
        displaySales.setLocation(200, 100);
        displaySales.setEditable(false);
        displaySales.setLineWrap(true);
        displaySales.setFont(textArea);

        salesScroll.setLocation(300, 100);
        salesScroll.setSize(1000, 600);
        sales.add(salesScroll);

        salesHeading.setSize(500, 75);
        salesHeading.setLocation(600, 0);
        salesHeading.setFont(heading);
        sales.add(salesHeading);

        exitSales.setSize(300, 75);
        exitSales.setLocation(0, 0);
        exitSales.setBackground(Color.RED);
        exitSales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sales.setVisible(false);
                adminHome.setVisible(true);

                frame.revalidate();
                frame.repaint();
            }
        });
        sales.add(exitSales);

        frame.add(sales); // keep here

        // initialisation of report panel
        report.setSize(1500, 1500);
        report.setLocation(0, 0);
        report.setLayout(null);
        report.setVisible(false);
        report.setBackground(Color.LIGHT_GRAY);

        // report panel components

        JButton exitReport = new JButton("Back");
        JButton generate = new JButton("Generate");

        // initialisation of report components
        generate.setSize(250, 75);
        generate.setLocation(600, 675);
        generate.setBackground(Color.GREEN);
        generate.addActionListener(new ActionListener() {
            @Override
            //applies text to the display report text area
            public void actionPerformed(ActionEvent e) {
                displayReport.setText("");
                displayReport.append("Current Stock  \n");
                displayReport.append("Flour Stock: " + d.getFlour() + "\n");
                displayReport.append("Olive Oil Stock: " + d.getOlive() + "\n");
                displayReport.append("Pepperoni Stock: " + d.getSausage() + "\n");
                displayReport.append("Basil Stock: " + d.getBasil() + "\n");
                displayReport.append("Tomatoes Stock: " + d.getTomatoes() + "\n");
                displayReport.append("Garlic Stock: " + d.getGarlicStock() + "\n");
                displayReport.append("Pineapple Stock: " + d.getPineappleTotal() + "\n");
                displayReport.append("Ham Stock: " + d.getHam() + "\n");
                displayReport.append("Chicken Stock: " + d.getChickenBreast() + "\n");
                displayReport.append("Mozzarella Stock: " + d.getMozzarella() + "\n \n");

                displayReport.append("Financial \n");

                int totalSales = 0;

                try (BufferedReader br = new BufferedReader(new FileReader("sales.txt"))) {
                    //reads the sales.txt file
                    //adds up each value after £
                    //finds total amount made from sales

                    String line = br.readLine();

                    while (line != null) {
                        displaySales.append(line + "\n");

                        if (line.contains("Sale Amount: £")) {
                            try {
                                String amountStr = line.replace("Sale Amount: £", "").trim();
                                int sale = Integer.parseInt(amountStr);
                                totalSales += sale;
                            } catch (NumberFormatException exc) {

                            }
                        }

                        line = br.readLine();
                    }

                    displayReport.append("Total Recieved from Orders: £" + totalSales);

                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(null, "Failed to read file");
                }

                int totalDeliveries = 0;

                try (BufferedReader br = new BufferedReader(new FileReader("adminDeliveries.txt"))) {
                    //goes through admindeliveries.txt file 
                    //adds up each value after£
                    //finds the total amount spent on resupplying stock
                    String line;

                    while ((line = br.readLine()) != null) { // read line at the start of each loop
                        if (line.startsWith("Total Cost: £")) {
                            try {
                                String amountStr = line.replace("Total Cost: £", "").trim();
                                int deliveryCost = Integer.parseInt(amountStr);
                                totalDeliveries += deliveryCost;
                            } catch (NumberFormatException ex) {
                                // Ignore or handle invalid format
                            }
                        }
                    }

                    displayReport.append("\nTotal Spent on Supplies: £" + totalDeliveries);

                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(null, "Failed to read adminDeliveries.txt");
                }

            }
        });
        report.add(generate);

        displayReport.setSize(850, 600);
        displayReport.setLocation(350, 55);
        displayReport.setEditable(false);
        displayReport.setFont(textArea);
        report.add(displayReport);

        reportHeading.setSize(500, 75);
        reportHeading.setLocation(600, 0);
        reportHeading.setFont(heading);
        report.add(reportHeading);

        exitReport.setSize(300, 75);
        exitReport.setLocation(0, 0);
        exitReport.setBackground(Color.RED);
        exitReport.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                report.setVisible(false);
                adminHome.setVisible(true);

            }
        });
        report.add(exitReport);

        frame.add(report);
        frame.setVisible(true);

    }

}
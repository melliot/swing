package db.operation;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Details extends JPanel {
    private final static String URL = "jdbc:mysql://localhost:3306/javatest";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    public Details(){

        Dimension dimension = getPreferredSize();
        dimension.width = 300;
        dimension.height = 120;

        setPreferredSize(dimension);
        setBorder(BorderFactory.createTitledBorder("Registration user"));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel nameFieldLabel = new JLabel("Login: ");
        JLabel passwordFieldLabel = new JLabel("Password: ");

        final JTextField nameField = new JTextField(15);
        final JTextField passwordField = new JTextField(15);

        JButton confirmButton = new JButton("Confirm");

        gridBagConstraints.anchor = GridBagConstraints.LINE_END;

        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 2;

        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 20;
        add(nameFieldLabel, gridBagConstraints);

        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 30;
        add(nameField, gridBagConstraints);

        gridBagConstraints.gridx = 40;
        gridBagConstraints.gridy = 50;
        add(passwordFieldLabel, gridBagConstraints);

        gridBagConstraints.gridx = 60;
        gridBagConstraints.gridy = 70;
        add(passwordField, gridBagConstraints);

        add(confirmButton, gridBagConstraints);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String names = nameField.getText();
                String password = passwordField.getText();
                System.out.println(names + " " + password);

                try {
                    Driver driver = new FabricMySQLDriver();
                    DriverManager.registerDriver(driver);
                } catch (SQLException ex) {
                    System.out.println("Connect failed");
                }

                try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    Statement statement = connection.createStatement();) {
                    statement.execute("INSERT INTO users (name, email) VALUES ('" + names + "','" + password + "')");

                } catch (SQLException exx) {
                    exx.printStackTrace();
                }
            }
        });
    }
}

package View;

import Controller.Controller;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private Model model;
    private JButton sendButton;
    private JTextField nameField;
    private JPasswordField passwordField;

    private LoginListener loginListener;
    public View(Model model){
        this.model = model;
        nameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        sendButton = new JButton("Send");



        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor  = GridBagConstraints.LAST_LINE_END;
        gc.gridx = 1;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(100,0,2,10);
        gc.fill = GridBagConstraints.NONE;
        add(new JLabel("Name "), gc);

        gc.anchor = GridBagConstraints.LAST_LINE_START;
        gc.gridx = 2;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(100,0,0,10);
        gc.fill = GridBagConstraints.NONE;
        add(nameField,gc);

        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 1;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,10);
        gc.fill = GridBagConstraints.NONE;
        add(new JLabel("Password "), gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 2;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.fill = GridBagConstraints.NONE;
        add(passwordField,gc);

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 2;
        gc.gridy = 3;
        gc.weightx = 1;
        gc.weighty = 100;
        gc.fill = GridBagConstraints.NONE;
        add(sendButton,gc);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name  = String.valueOf(nameField.getText());
                String password = String.valueOf(passwordField.getPassword());

                fireLoginEvent(new LoginFormEvent(name,password));

            }
            public void fireLoginEvent(LoginFormEvent event){
                if (loginListener != null){
                    loginListener.loginPerformed(event);
                }
            }
        });


        gc.fill = GridBagConstraints.NONE;
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);


    }

    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    }

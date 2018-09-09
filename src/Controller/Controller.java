package Controller;

import Model.Model;
import View.View;
import View.LoginListener;
import View.LoginFormEvent;

public class Controller implements LoginListener {


    public Controller(View view, Model model) {
    }

    @Override
    public void loginPerformed(LoginFormEvent event) {
        System.out.println("login event received " +event.getName() +": "+ event.getPassword());
    }
}

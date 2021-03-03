package com.comunidad.SwingSpringMysql;

import com.comunidad.SwingSpringMysql.login.view.LoginSpringMysql;

/**
*
* @author Santiago
*/
public class App {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginSpringMysql().setVisible(true);
            }
        });
    }
}
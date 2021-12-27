package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import model.Mail;


public class MailListReaderBD {
    public List<Mail> read() {
        List<Mail> mailList = new ArrayList<Mail>();
        Connection connection = null;
        String url = "jdbc:sqlite:mail.db";
        String select = "SELECT * FROM direcc_email";
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(select);
            
            while (rs.next()) {
                String line = rs.getString("direccion");
                if (Mail.isMail(line));
                    mailList.add(new Mail(line));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mailList;
    }
}

package by.kursy.model.logic;


import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

public class ByKursyDimapotyakovJDBC {

    public static String test() {

        String s = "";
        String url = "jdbc:mysql://127.0.0.1:3306/db_carrantal";
        String login = "root";
        String password = "2406870rid";
        String sql = "";
        String rent = "SELECT c.name, passport, phone, b.name, color, price FROM"
                + " rent r inner join client c on r.id_client = c.id_client"
                + " inner join auto a on r.id_car = a.id_auto"
                + " inner join car_brand b on a.id_brand = b.id_brand";

        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(rent);
            List<Rent> renta = new ArrayList<Rent>();
            
            while (result.next()) {
                Rent r = new Rent();
                r.setName(result.getString("name"));
                r.setPassport(result.getString("passport"));
                r.setPhone(result.getString("phone"));
                r.setColor(result.getString("color"));
                r.setPrice(result.getInt("price"));
                   renta.add(r);
            }
            for (Rent r : renta){
                s += r + "<br/>";
            }
        } catch (ClassNotFoundException exception) {
            System.out.println(exception);

        } catch (SQLException exception) {
            System.out.println(exception);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    System.out.println(exception);

                }

            }
        }
        
        return s;
    }
    
    
    public static void main(String[] args) {
        System.out.println(test());
    }
}

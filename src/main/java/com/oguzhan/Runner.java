package com.oguzhan;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Runner {
    public static void main(String[] args) throws ClassNotFoundException {

        try {
            // Öncelikle sürücüye ihtiyacım var...
            Driver.class.forName("org.postgresql.Driver");
            // Sürücüyü yöneterek bir bağlantı oluşturmasını sağlamalıyım...
            // Nereye bağlanacaksın ? URL
            // Kim bağlanıyor ? USER
            // Parolası nedir ? PASSWORD
            // Bir bağlantı için gerekli bilgiler --> 1- IP Adresi, 2- Port numarası, 3- Database adı
            // Ancak bunu ConnectionString olarak yazmalısınız. --> jdbc:postgresql://host:port/database
            String URL = "jdbc:postgresql://localhost:5432/SatisDB";
            String user  = "postgres";
            String password = "root";
            Connection connection = DriverManager.getConnection(URL,user,password);
            // Drivera kayıt yapması için emir vermeliyim..
            String SQL = "insert into tblmusteri (ad,soyad) values ('Bahar', 'Tunç')";
            PreparedStatement pst = connection.prepareCall(SQL);
            // Verilen emrin uygulanması için işlem yapmalıyım...
            pst.executeUpdate();
            // Emrin veritabanına uygulanmasını onaylamalıyım...
            // connection.commit();
            // Açmış olduğumuz bağlantımızı kapatmalıyım...
            connection.close();
        } catch (Exception exception){
            System.out.println("Hata: " +exception);
        }

    }
}

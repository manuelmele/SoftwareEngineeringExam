/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.dbsimplemanager;

import java.sql.*;



public class DBManager {

    public static void main(String[] args) throws Exception {
        
        System.out.println(args[0]);

        Class.forName("org.sqlite.JDBC");
        Connection conn
                = DriverManager.getConnection("jdbc:sqlite:"+args[0]);
        Statement stat = conn.createStatement();

        if (args[1].equals("create")) {
            stat.executeUpdate("drop table if exists teams;");
            stat.executeUpdate("create table teams (teamid, name, coach);");
            
            stat.executeUpdate("drop table if exists matches;");
            stat.executeUpdate("create table matches (id, date, result, homeTeam, visTeam);");
            
            for (int i = 1; i < 20; i++) {
                PreparedStatement prep = conn.prepareStatement(
                        "insert into teams values (?, ?, ?);");
                prep.setString(1, "" + i);
                prep.setString(2, "Team" + i);
                prep.setString(3, "Coach" + i) ;
                prep.addBatch();
                conn.setAutoCommit(false);
                prep.executeBatch();
                conn.setAutoCommit(true);
            }
            
            for (int i = 1; i < 11; i++) {
                PreparedStatement prep = conn.prepareStatement(
                        "insert into matches values (?, ?, ?, ?, ?);");
                prep.setString(1, "" + i);
                prep.setString(2, "2020/" +(12 -i) + "/" + (30 - i));
                prep.setString(3, "0:1") ;
                prep.setString(4, "" + i);
                prep.setString(5, "" + (20 -i));
                prep.addBatch();
                conn.setAutoCommit(false);
                prep.executeBatch();
                conn.setAutoCommit(true);
            }
        } else {
            ResultSet rs = stat.executeQuery("select * from teams;");
            while (rs.next()) {
                System.out.print("Team = " + rs.getString("teamId") + " is : ");
                System.out.println(rs.getString("name"));
            }
            rs.close();
        }
        conn.close();
    }
}

package com.Heather;

import java.sql.*;
import java.util.*;

public class Main {
    static final String JDBC_DRIVER = "jdbc:mysql://localhost:3306/";
    static final String DB_CONNECTION_URL = "cube";

    static final String USER = "root";
    static final String PASSWORD = "itecitec";

    public static void main(String[] args) throws SQLException {
	// write your code here
        try{
            Class.forName(JDBC_DRIVER);
        }catch(ClassNotFoundException cnfe){
            System.out.println("Can't instantiate driver; check settings");
            System.exit(-1);
        }
        Connection connect=DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
        Statement state=connect.createStatement();

        state.execute("CREATE TABLE if NOT EXISTS Songs (SongID PRIMARY, Title VARCHAR (100), Composer VARCHAR (50), Genre VARCHAR (50), Style VARCHAR (50), Lyrics BOOLEAN, BookID INT, AlbumID int)");
        state.execute("CREATE TABLE if NOT EXISTS Print (BookID PRIMARY, TimeSignature VARCHAR (5), KeySignature VARCHAR (5), FirstPage VARCHAR (4), TotalPages DOUBLE, Location VARCHAR ())");
    }
}

package com.Heather;

import java.sql.*;
import java.util.*;

public class Main {
    static final String JDBC_DRIVER = "jdbc:mysql://localhost:3306/";
    static final String DB_CONNECTION_URL = "music";

    static final String USER = "Heather";
    static final String PASSWORD = "ashlynn8";

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

        state.execute("CREATE TABLE if NOT EXISTS Songs (SongID PRIMARY, Title VARCHAR (100), Composer VARCHAR (50), Genre VARCHAR (50), Style VARCHAR (50), Lyrics BOOLEAN, Format VARCHAR (10), ContainerID int)"); //ContainerID is either a BookID or an AlbumID, or "none" for loose papers
        state.execute("CREATE TABLE if NOT EXISTS Papers (PapersID PRIMARY, Box BOOLEAN, Location VARCHAR (15))");
        state.execute("CREATE TABLE if NOT EXISTS Book (BookID PRIMARY, Name VARCHAR (100), TimeSignature VARCHAR (5), KeySignature VARCHAR (5), FirstPage VARCHAR (4), TotalPages DOUBLE, Location VARCHAR (15))");//books, pamphlets, loose sheets
        state.execute("CREATE TABLE if NOT EXISTS Audio (AlbumID PRIMARY, Album VARCHAR (100), Artist VARCHAR (50), Location VARCHAR (15))");
    }
}

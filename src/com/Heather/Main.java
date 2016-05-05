package com.Heather;

import java.sql.*;
import java.util.*;

public class Main {
    static final String JDBC_DRIVER = "jdbc:mysql://localhost:3306/";
    static final String DB_CONNECTION_URL = "Music";

    static final String USER = "Heather";
    static final String PASSWORD = "ashlynn8";

    static Connection connect=null;
    static Statement statement=null;
    static ArrayList<String> tableNames=new ArrayList<>();
    static HashMap<String, Double> testData;
    static PreparedStatement searcher=null;
    static PreparedStatement newAlbum=null;
    static PreparedStatement newSong=null;
    static PreparedStatement newBook=null;
    static PreparedStatement newPapers=null;


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


        try{
            setup();
            //set prepared statement for search x
            String seSolver = "SELECT * FROM ? WHERE ? = ?";
            searcher = connect.prepareStatement(seSolver);
            //new Album
            String nAlbum= "INSERT INTO Album VALUES(?,?,?)";//Album, Artist, Location
            newAlbum=connect.prepareStatement(nAlbum);
            //new Song
            String nSong= "INSERT INTO Song VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";//Title, Composer, Genre, Style, Time, Key, First Page, Duration, Lyrics, Range, Book/Album, Format, Instrument
            newSong=connect.prepareStatement(nSong);
            //new Book
            String nBook= "INSERT INTO Book VALUES(?,?,?)";//title, ISBN, Location
            newBook=connect.prepareStatement(nBook);
            //new Papers
            String nPapers= "INSERT INTO Papers VALUES(?,?,?)";//title, ISBN, Location
            newPapers=connect.prepareStatement(nPapers);

        }catch(SQLException se){
            se.printStackTrace();
        }

    }


    public static boolean setup(){//setup the database and connection
        tableNames.add("Songs");
        tableNames.add("Papers");
        tableNames.add("Books");
        tableNames.add("Audio");
        try {
            Class.forName(JDBC_DRIVER);

        }catch(ClassNotFoundException cnfe){
            System.out.println("Can't instantiate driver class; check you have drives and classpath configured correctly?");
            cnfe.printStackTrace();
            System.exit(-1);
        }

        try {
            connect = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
            statement = connect.createStatement();
            boolean tableExists=false;
            for (String tableName:tableNames) {
                String checkTablePresentQuery = "SHOW TABLES LIKE '" + tableName + "'";
                ResultSet tablesRS = statement.executeQuery(checkTablePresentQuery);
                if (tablesRS.next()) {
                    tableExists = true;
                }


                if (!tableExists) {
                    //make new table
                    if (tableName.equalsIgnoreCase("Songs")){
                        //Title, Composer, Genre, Style, Time, Key, First Page, Duration, Lyrics, Range, Book/Album, Format, Instrument
                        String newTable = "CREATE TABLE if NOT EXISTS Songs (SongID int IDENTITY(1,1) PRIMARY KEY (SongID), Title VARCHAR (100) NOT NULL, Composer VARCHAR (50), Genre VARCHAR (50), Style VARCHAR (50), TimeSignature VARCHAR (5), KeySignature VARCHAR (5), FirstPage VARCHAR (4), Duration DOUBLE, Lyrics BOOLEAN NOT NULL, Range BOOLEAN NOT NULL, ContainerID int, Format VARCHAR (10)NOT NULL, Instrument VARCHAR (50),"; //ContainerID is either a BookID or an AlbumID, or "none" for loose papers
                        statement.executeUpdate(newTable);
                    }else if (tableName.equalsIgnoreCase("Books")) {
                        String newTable = "CREATE TABLE if NOT EXISTS Book (BookID int IDENTITY(1,1) PRIMARY KEY (BookID), Name VARCHAR (100), Location VARCHAR (15))";
                        statement.executeUpdate(newTable);
                    }else if (tableName.equalsIgnoreCase("Album")){
                        String newTable ="CREATE TABLE if NOT EXISTS Audio (AlbumID int IDENTITY(1,1) PRIMARY KEY (AlbumID), Album VARCHAR (100), Artist VARCHAR (50), Location VARCHAR (15)";
                        statement.executeUpdate(newTable);
                    }else{//Papers
                        String newTable ="CREATE TABLE if NOT EXISTS Papers (PapersID int IDENTITY(1,1) PRIMARY KEY (PapersID), Box BOOLEAN, Location VARCHAR (15))";
                        statement.executeUpdate(newTable);

                    }
                }
            }
            return true;

        }catch(SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    public static void addTestData(){
        try{
            //store test data
            testData=new HashMap<>();
            testData.put("Cubestormer II robot",5.270);
            testData.put("Fakhri Raihaan (using his feet)", 27.93);
            testData.put("Ruxin Liu (age 3)", 99.33);
            testData.put("Mats Valk (human record holder)", 6.27);

            //add test data to table
            for(String s:testData.keySet()) {//s is each name in test data
               // searcher.setString(1, s); //TODO change to fit format of searcher
                ResultSet searchR = searcher.executeQuery();//look for an entry with this name
                int count=0;
                while (searchR.next()){
                    count++;
                }
                if (count==0) {//if there is no entry, add it TODO change data to match actual format of tables.
                    newSong.setString(1, s);
                    newSong.setDouble(2, testData.get(s));
                    newSong.executeUpdate();
                }
            }
        }catch (SQLException se){
            System.out.println("failed to add test data "+se);
        }
    }
}

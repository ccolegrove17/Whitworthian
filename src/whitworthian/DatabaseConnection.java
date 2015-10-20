/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whitworthian;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ccolegrove17
 */
public class DatabaseConnection {

    Connection conn = null;

    public DatabaseConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://cs1/whitworthian", "ccolegrove", "whitworthian1");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ResultSet executeQuery(String stSQL) {
        try {
            PreparedStatement stmt = conn.prepareStatement(stSQL);
            return stmt.executeQuery();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void executeUpdate(String stSQL) {
        try {
            PreparedStatement stmt = conn.prepareStatement(stSQL);
            System.out.println(stmt.executeUpdate());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public ResultSet Search(String searchBy, String searchTerm) {
        
        String stSQL = "";
        
        switch(searchBy){
            case "Date Published":
                stSQL = formatQuery("Date_Pub", searchTerm);
                break;
            case "Title":
                stSQL = formatQuery("Title", searchTerm);
                break;
            case "Keyword":
                break;
            case "Tag":
                break;
            case "Category":
                break;
            case "Author":
                stSQL = formatQuery("Author", searchTerm);
                break;
        }
        return executeQuery(stSQL);
    }
    
    public String formatQuery(String searchBy, String searchTerm){
        String[] searchTerms = searchTerm.split(" ");
        searchTerm = "";
        for (int i = 0; i < searchTerms.length; i++) {
            if (i != 0) {
                searchTerm += " AND " + searchBy + " LIKE ";
            }
            searchTerm += "'%" + searchTerms[i] + "%'";
        }
        String stSQL = "";
        stSQL = "SELECT * FROM Articles WHERE " + searchBy + " LIKE " + searchTerm + ";";
        return stSQL;
    }
    
    public void keywordSearch(String searchTerms) {

    }
    
    public void addWordsToDatabase(ResultSet results){
        
    }
    
}



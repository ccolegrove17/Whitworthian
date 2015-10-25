/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whitworthian;

import java.sql.*;

/**
 *
 * @author ccolegrove17
 */
public class DatabaseConnection {

    Connection conn = null;
    PreparedStatement stmt = null;

    public DatabaseConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://cs1/whitworthian", "ccolegrove", "whitworthian1");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ResultSet executeQuery(String stSQL) {
        try {
            System.out.println(stSQL);
            stmt = conn.prepareStatement(stSQL);
            return stmt.executeQuery();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void close() {
        try {
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int executeUpdate(String stSQL) {
        System.out.println(stSQL);
        try {
            PreparedStatement stmt = conn.prepareStatement(stSQL, Statement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            int auto_id = rs.getInt(1);
            return auto_id;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

    public ResultSet Search(String searchBy, String searchTerm) {

        String stSQL = "";

        switch (searchBy) {
            case "Date Published":
                stSQL = formatQuery("Date_Pub", searchTerm);
                break;
            case "Title":
                stSQL = formatQuery("Title", searchTerm);
                break;
            case "Keyword":
                stSQL = formatQuery("Keyword", searchTerm);
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

    public String formatQuery(String searchBy, String searchTerm) {
        String[] searchTerms = searchTerm.split(" ");
        searchTerm = "";
        String stSQL = "";

        if (searchBy.equals("Author")) {
            for (int i = 0; i < searchTerms.length; i++) {
                if (i != 0) {//if it's not the first time
                    searchTerm += " AND ";
                }//every time
                searchTerm += "(E.Fname LIKE '%" + searchTerms[i] + "%' OR E.Lname LIKE '%" + searchTerms[i] + "%')";
            }
            stSQL = "SELECT * FROM Articles A INNER JOIN Employees E ON A.Employee_ID = E.ID WHERE " + searchTerm + ";";

        } else if (searchBy.equals("Keyword")) {

            for (int i = 0; i < searchTerms.length; i++) {
                if (i != 0) {
                    searchTerm += " OR Word = ";
                }
                searchTerm += "'" + searchTerms[i] + "'";
            }
            stSQL = "SELECT * FROM (SELECT A.* FROM ARTICLES A INNER JOIN (SELECT * FROM Words INNER JOIN contentwords ON Words.ID = contentwords.Word_ID WHERE Word = " + searchTerm + " group by Article_ID having count(*) = " + searchTerms.length + ") X ON A.ID = X.Article_ID"
                    + ") Q INNER JOIN Employees E ON Q.Employee_ID = E.ID UNION DISTINCT SELECT * FROM (SELECT A.* FROM ARTICLES A INNER JOIN (SELECT * FROM Words INNER JOIN authorwords ON Words.ID = authorwords.Word_ID WHERE Word = " + searchTerm + " group by Article_ID having count(*) = " + searchTerms.length + ") X ON A.ID = X.Article_ID"
                    + ") Q INNER JOIN Employees E ON Q.Employee_ID = E.ID UNION DISTINCT SELECT * FROM (SELECT A.* FROM ARTICLES A INNER JOIN (SELECT * FROM Words INNER JOIN titlewords ON Words.ID = titlewords.Word_ID WHERE Word = " + searchTerm + " group by Article_ID having count(*) = " + searchTerms.length + ") X ON A.ID = X.Article_ID) Q INNER JOIN Employees E ON Q.Employee_ID = E.ID";
            //stSQL = "SELECT * FROM (SELECT A.* FROM ARTICLES A INNER JOIN (SELECT * FROM Words INNER JOIN contentwords ON Words.ID = contentwords.Word_ID WHERE Word = " + searchTerm + " group by Article_ID having count(*) = 2) X ON A.ID = X.Article_ID) Q INNER JOIN Employees E ON Q.Employee_ID = E.ID;";
//            
//            stSQL = "SELECT * FROM Articles A INNER JOIN Employees E On A.Employee_ID = E.ID WHERE A.ID IN (SELECT ConW.Article_ID FROM contentwords ConW, (SELECT ID FROM words WHERE Word LIKE " + searchTerm + ") as X WHERE ConW.Word_ID = X.ID UNION DISTINCT "
//                    + "SELECT TiW.Article_ID FROM titlewords TiW, (SELECT ID FROM words WHERE Word LIKE " + searchTerm + ") as X WHERE TiW.Word_ID = X.ID UNION DISTINCT "
//                    + "SELECT AuW.Article_ID FROM authorwords AuW, (SELECT ID FROM words WHERE Word LIKE " + searchTerm + ") as X WHERE AuW.Word_ID = X.ID);";
        } else {
            for (int i = 0; i < searchTerms.length; i++) {
                if (i != 0) {
                    searchTerm += " AND " + searchBy + " LIKE ";
                }
                searchTerm += "'%" + searchTerms[i] + "%'";
            }
            stSQL = "SELECT * FROM Articles A INNER JOIN Employees E ON A.Employee_ID = E.ID WHERE " + searchBy + " LIKE " + searchTerm + ";";
        }
        return stSQL;

    }
}

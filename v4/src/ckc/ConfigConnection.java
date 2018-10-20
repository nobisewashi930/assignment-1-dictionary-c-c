
package ckc;

import java.sql.*;

/**
 *
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 */
public class ConfigConnection {

    /**
     * Connect to the dictionaryE_V.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/Lenovo/Desktop/1234/src/database/dictionaryE_V.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * select all rows in the dictionary table
     */
    public Dictionary selectAll(Dictionary dict){
        String sql = "SELECT word, detail FROM dictionary";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                Word newWord = new Word(rs.getString("word"),rs.getString("detail"));
                dict.addWordToDictionary(newWord);
                System.out.println(
                        rs.getString("word") + "\t" +
                        rs.getString("detail"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dict;
    }

    /**
     * tim kiem tu truc truc tiep trong database
     */
    public Dictionary searchInDb(String str){
        Dictionary dict = new Dictionary();
        String sql = "SELECT word, detail FROM dictionary WHERE word LIKE '" + str + "%' limit 20";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                Word newWord = new Word(rs.getString("word"),rs.getString("detail"));
                dict.addWordToDictionary(newWord);
                System.out.println(
                        rs.getString("word") + "\t" +
                                rs.getString("detail"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dict;
    }

    public void insert(String word, String detail){
        String sql = "INSERT INTO dictionary(word,detail) VALUES(?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, word);
            pstmt.setString(2, detail);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Update data of dictionary by word
     *
     * @param word
     * @param detail
     */
    public void update(String word, String detail) {
        String sql = "UPDATE dictionary SET "
                + "detail = ? "
                + "WHERE word = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, word);
            pstmt.setString(2, detail);

            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Delete a dictionary specified by the word
     *
     * @param word
     */
    public void delete(String word) {
        String sql = "DELETE FROM dictionary WHERE word = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, word);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}





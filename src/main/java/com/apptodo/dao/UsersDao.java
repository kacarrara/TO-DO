package com.apptodo.dao;
 
import java.sql.SQLException;

import com.apptodo.utils.ConexaoApi;

public class UsersDao {
    public final int id;
    public final String username;
    public final String password;
    public final String userFirstName;
    public final String email;

    private UsersDao(int id, String username, String password, String userFirstName, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userFirstName = userFirstName;
        this.email = email;
    }
    
    private static UsersDao makeDao(ConexaoApi capi) throws SQLException {
        return new UsersDao(capi.getInt("id"), capi.getString("username"), capi.getString("keypass"), capi.getString("userFirstName"), capi.getString("email"));
    }
    
    public static UsersDao getLogin(String username, String password) {
        try {
            ConexaoApi conexao = new ConexaoApi();
            conexao.setQuery("select * from users where username = ? and keypass = ?");
            conexao.setString(1, username);
            conexao.setString(2, password);
            conexao.executeQuery();
            if(conexao.next()) 
                return makeDao(conexao);
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misclases;

/**
 *
 * @author Asus
 */
public class Usuario extends Persona {
    private String Username;
    private String Password;
    
    public Usuario(String email, String celular, String direccion, String col, int  zp, String name, String apeP, String apeM, String username, String pass){
        super(email, celular, direccion, col, zp, name, apeP, apeM);
        this.Username = username;
        this.Password = pass;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}

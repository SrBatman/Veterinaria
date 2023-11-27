/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misclases;

/**
 *
 * @author Asus
 */
public class Contacto {
    private String Email;
    private String Celular;
    private String HousePhone;
    
    public Contacto (String email, String celular){
        this.Email = email;
        this.Celular = celular;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getHousePhone() {
        return HousePhone;
    }

    public void setHousePhone(String HousePhone) {
        this.HousePhone = HousePhone;
    }
    
    
    
}

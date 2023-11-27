/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misclases;

/**
 *
 * @author Asus
 */
public class Cliente extends Persona {
    
    int ClienteId;
    String HomePhone;
    
    public Cliente(String email, String celular, String direccion, String col, int  zp, String name, String apeP, String apeM, int id, String homephone){
        super( email, celular, direccion, col, zp, name, apeP, apeM);
        this.ClienteId = id;
        this.HomePhone = homephone;
    }

    public int getClienteId() {
        return ClienteId;
    }

    public void setClienteId(int ClienteId) {
        this.ClienteId = ClienteId;
    }

    public String getHomePhone() {
        return HomePhone;
    }

    public void setHomePhone(String HomePhone) {
        this.HomePhone = HomePhone;
    }
    
     public String showData(){
//        String str = "\n=========Datos=========\nID cliente: " + this.getClienteId() 
//                + "\nNombre: " + this.getName() + 
//                "\nApellidos: " + 
//                this.getLastNameP() + " " + 
//                this.getLastNameM() + "\nDireccion: " + 
//                this.getDireccion() + ", Col:" + this.getColonia()+ " " + this.getZipCode() + 
//                "\nEmail: " + this.getEmail() +
//                "\nTel Celular: " + this.getCelular() +
//                "\nTel Casa: " + this.getHomePhone();
//        return str;
return new StringBuilder()
        .append("\n========= Datos del Cliente =========")
        .append("\n• ID cliente: ").append(this.getClienteId())
        .append("\n• Nombre: ").append(this.getName())
        .append("\n• Apellidos: ").append(this.getLastNameP()).append(" ").append(this.getLastNameM())
        .append("\n• Dirección: ").append(this.getDireccion()).append(", Col:").append(this.getColonia()).append(" ").append(this.getZipCode())
        .append("\n• Email: ").append(this.getEmail())
        .append("\n• Teléfono Celular: ").append(this.getCelular())
        .append("\n• Teléfono de Casa: ").append(this.getHomePhone())
        .append("\n====================\n")
        .toString();
    }
    
    
}

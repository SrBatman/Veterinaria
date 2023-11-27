/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misclases;

/**
 *
 * @author Asus
 */
public class Empleado extends Usuario {
    
    private int EmployeeId;
    private String Puesto;
    
    public Empleado (String email, String celular, String direccion, String col, int  zp, String name, String apeP, String apeM, String username, String pass,int id, String rol){
        super( email, celular, direccion, col, zp, name, apeP, apeM, username, pass);
        this.EmployeeId = id;
        this.Puesto = rol;
      
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }
    
    public String showData(){
//        String str = "\n=========Datos=========\nID empleado: " + this.getEmployeeId() 
//                + "\nNombre: " + this.getName() + 
//                "\nApellidos: " + 
//                this.getLastNameP() + " " + 
//                this.getLastNameM() + "\nDireccion: " + 
//                this.getDireccion() + ", Col:" + this.getColonia()+ " " + this.getZipCode() + 
//                "\nEmail: " + this.getEmail() +
//                "\nTelefono: " + this.getCelular() +
//                "\nPuesto/Cargo: " + this.getPuesto()+
//                "\n====================\n\n\n" +
//                 "Credenciales \n====================\nUsuario: " + this.getUsername() +
//                "\nContraseña: " + this.getPassword() + "\n====================\n"; 
//        return str;
 return new StringBuilder()
        .append("\n========= Datos del Empleado =========")
        .append("\n• ID empleado: ").append(this.getEmployeeId())
        .append("\n• Nombre: ").append(this.getName())
        .append("\n• Apellidos: ").append(this.getLastNameP()).append(" ").append(this.getLastNameM())
        .append("\n• Dirección: ").append(this.getDireccion()).append(", Col:").append(this.getColonia()).append(" ").append(this.getZipCode())
        .append("\n• Email: ").append(this.getEmail())
        .append("\n• Teléfono: ").append(this.getCelular())
        .append("\n• Puesto/Cargo: ").append(this.getPuesto())
        .append("\n\n========= Credenciales =========")
        .append("\n• Usuario: ").append(this.getUsername())
        .append("\n• Contraseña: ").append(this.getPassword())
        .append("\n====================\n")
        .toString();
    }
    
    
}

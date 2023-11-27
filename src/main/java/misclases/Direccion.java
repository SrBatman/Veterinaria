/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misclases;

/**
 *
 * @author Asus
 */
public class Direccion extends Contacto {
    private String Direccion;
    private String Colonia;
    private int ZipCode;
    
    public Direccion (String email, String celular, String direccion, String col, int zp){
        super(email, celular);
        this.Direccion = direccion;
        this.Colonia = col;
        this.ZipCode = zp;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public int getZipCode() {
        return ZipCode;
    }

    public void setZipCode(int ZipCode) {
        this.ZipCode = ZipCode;
    }
    
    public void setZipCode(String ZipCode) {
        this.ZipCode = Integer.valueOf(ZipCode);
    }
    
}

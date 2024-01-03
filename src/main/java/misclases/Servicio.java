/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misclases;

/**
 *
 * @author Asus
 */
public class Servicio {
    private String tipo;
    private float precio;
    private int ServiceId;
    
    
    public Servicio(){
        tipo = "";
        precio = 0.0f;
        ServiceId = 0;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public boolean setPrecio(String precio) {
        try {
            this.precio = Float.parseFloat(precio);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
        
    }
    
    public int getServiceId() {
        return ServiceId;
    }

    public void setServiceId(int ServiceId) {
        this.ServiceId = ServiceId;
    }
    
    public String showData(){
        return new StringBuilder()
        .append("\n========= Datos del Servicio =========")
        .append("\n• ID servicio: ").append(this.getServiceId())
        .append("\n• Servicio: ").append(this.getTipo())
        .append("\n• Precio: $").append(this.getPrecio())
        .append("\n====================\n")
        .toString();
    }
}

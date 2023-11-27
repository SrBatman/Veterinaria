package misclases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Descuento {
    
    private int Porcentaje;
    private int Cantidad;
     private int DiscountId;

    public int getDiscountId() {
        return DiscountId;
    }

    public void setDiscountId(int DiscountId) {
        this.DiscountId = DiscountId;
    }
    
    public Descuento(){
        Porcentaje = 0;
        Cantidad = 0;
    }
    
    public int getPorcentaje() {
        return Porcentaje;
    }
    
    public boolean setPorcentaje(String porcentaje){
        try {
            this.Porcentaje = Integer.parseInt(porcentaje);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public void setPorcentaje(int Porcentaje) {
        this.Porcentaje = Porcentaje;
    }

    public int getCantidad() {
        return Cantidad;
    }
    
    public boolean setCantidad(String cantidad){      
        try {
            this.Cantidad = Integer.parseInt(cantidad);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    public String showData(){
        return new StringBuilder()
        .append("\n========= Datos del Descuento =========")
        .append("\n• ID descuento: ").append(this.getDiscountId())
        .append("\n• Porcentaje de descuento: ").append(this.getPorcentaje()).append("%")
        .append("\n• Cantidad de mascotas requeridas: ").append(this.getCantidad())
        .append("\n====================\n")
        .toString();
    }
    
}

package misclases;

import java.util.Date;

public class Factura {
    private int FacturaId;
    private Date Fecha;
    private double Total;
    Cliente client;
    Mascota pet;
    Servicio service;
    Descuento discount;
    
    
    public Factura(){
        FacturaId = 0;
        Fecha = new Date();
        Total = 0;
        discount = null;
    }
    
        public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Mascota getPet() {
        return pet;
    }

    public void setPet(Mascota pet) {
        this.pet = pet;
    }

    public Servicio getService() {
        return service;
    }

    public void setService(Servicio service) {
        this.service = service;
    }

    public Descuento getDiscount() {
        return discount;
    }

    public void setDiscount(Descuento discount) {
        this.discount = discount;
    }

    public int getFacturaId() {
        return FacturaId;
    }

    public void setFacturaId(int FacturaId) {
        this.FacturaId = FacturaId;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
    
    
    
}

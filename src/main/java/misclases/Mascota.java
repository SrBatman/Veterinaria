/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misclases;

/**
 *
 * @author Asus
 */
public class Mascota {
    private int PetId;
    private String Nombre;
    private String Especie;
    private String Raza;
    private int Edad;
    private float Peso;
    private String Sexo;
    private String Estatus;
    private Cliente owner;


        
    public Mascota(){
        PetId = 0;
        Nombre = "";
        Especie = "";
        Raza = "";
        Edad = 0;
        Peso = 0;
        Sexo = "";
        Estatus = "";
        owner = null;
        
    }

    public int getPetId() {
        return PetId;
    }

    public void setPetId(int PetId) {
        this.PetId = PetId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String Especie) {
        this.Especie = Especie;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String Raza) {
        this.Raza = Raza;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }
    
    public boolean setEdad(String Edad) {
       try {
           this.Edad = Integer.parseInt(Edad);
           return true;
        } catch(NumberFormatException e){
            return false;
        }
        
    }

    public float getPeso() {
        return Peso;
    }

    public void setPeso(float Peso) {
        this.Peso = Peso;
    }
    
    public boolean setPeso(String Peso) {
        try {
            this.Peso = Float.parseFloat(Peso);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
    }
    
    
    public Cliente getOwner() {
        return owner;
    }

    public void setOwner(Cliente owner) {
        this.owner = owner;
    }
    
    
     public String showData(){
return new StringBuilder()
        .append("\n========= Datos de la mascota =========")
        .append("\n• ID mascota: ").append(this.getPetId())
        .append("\n• Nombre: ").append(this.getNombre())
        .append("\n• Especie: ").append(this.getEspecie())
        .append("\n• Raza: ").append(this.getRaza())
        .append("\n• Edad: ").append(this.getEdad())
        .append("\n• Peso: ").append(this.getPeso()).append("Kg")
        .append("\n• Sexo: ").append(this.getSexo())
        .append("\n====================\n")
        .append(this.getOwner().showData().replace("Cliente", "Dueño"))
        .toString();
    }

    

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misclases;

/**
 *
 * @author Asus
 */
public class Persona extends Direccion {
    private String Name;
    private String LastNameM;
    private String LastNameP;
    
    public Persona (String email, String celular, String direccion, String col, int zp, String name, String apeP, String apeM){
        super(email, celular, direccion, col, zp);
        this.Name = name.toUpperCase().replace(" ", "").replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");;
        this.LastNameM = apeM.toUpperCase().replace(" ", "").replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");;
        this.LastNameP = apeP.toUpperCase().replace(" ", "").replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name.toUpperCase().replace(" ", "").replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }

    public String getLastNameM() {
        return LastNameM;
    }

    public void setLastNameM(String lastNameM) {
        this.LastNameM = lastNameM.toUpperCase().toUpperCase().replace(" ", "").replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }

    public String getLastNameP() {
        return LastNameP;
    }

    public void setLastNameP(String lastNameP) {
        this.LastNameP = lastNameP.toUpperCase().replace(" ", "").replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }

}

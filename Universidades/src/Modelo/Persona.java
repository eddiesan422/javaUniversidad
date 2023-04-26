
package Modelo;

import javax.swing.JOptionPane;


public class Persona extends Cargo{
   protected String Nombre;
   protected int Codigo;
   

    public Persona() {
    }

    public Persona(String Nombre, int Codigo) {
        this.Nombre = Nombre;
        this.Codigo = Codigo;
        
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

   

    @Override
    public void Cargos() {
         JOptionPane.showMessageDialog(null,"Su cargo es: ");
    }

    @Override
    public String toString() {
        return "Persona{" + "Nombre=" + Nombre + ", Codigo=" + Codigo + '}';
    }
    
}


package Modelo;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Estudiante extends Persona implements Materias {
    protected String Carrera;
    protected int CantMaterias;
    protected int ValorMatricula;
  
  

    public Estudiante() {
    }

    public Estudiante(  String Nombre, int Codigo, String Carrera,int CantMaterias) {
        super(Nombre, Codigo);
        this.Carrera = Carrera;
        this.CantMaterias = CantMaterias;
        
    }
    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    public int getCantMaterias() {
        return CantMaterias;
    }

    public void setCantMaterias(int CantMaterias) {
        this.CantMaterias = CantMaterias;
    }

    public int getValorMatricula() {
        return ValorMatricula;
    }

    public void setValorMatricula(int ValorMatricula) {
        this.ValorMatricula = ValorMatricula;
    }

    @Override
    public int Valor() {
       ValorMatricula= CantMaterias*ValorMateria;
       return ValorMatricula;
    }
   
    @Override
    public void Cargos() {
         JOptionPane.showMessageDialog(null,"Su cargo es estudiante ");
    }

    @Override
    public String toString() {
        return "\nNombre: " +Nombre+"\nCodigo: "+Codigo+  "\nCarrera: " + Carrera + "\nCantMaterias: " + CantMaterias ;
    }

   
    
}

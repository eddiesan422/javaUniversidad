
package Modelo;

import javax.swing.JOptionPane;


public class Trabajador extends Persona implements Sueldo{
    protected int HrsTrabajadas;
   static protected final int ValorHora = 40000;
    protected int Salario;
    protected String Cargo;

    public Trabajador() {
    }

    public Trabajador(String Nombre, int Codigo,String Cargo,int HrsTrabajadas ) {
        super(Nombre, Codigo);
        this.HrsTrabajadas = HrsTrabajadas;
        
        this.Salario = Salario;
        this.Cargo = Cargo;
    }

    public int getHrsTrabajadas() {
        return HrsTrabajadas;
    }

    public void setHrsTrabajadas(int HrsTrabajadas) {
        this.HrsTrabajadas = HrsTrabajadas;
    }

    public int getValorHora() {
        return ValorHora;
    }

   

    public int getSalario() {
        return Salario;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public void setSalario(int Salario) {
        this.Salario = Salario;
    }

    @Override
    public int CalcularSueldo() {
      Salario = HrsTrabajadas*ValorHora;
      return Salario;
    }
       
   

    @Override
    public String toString() {
        return "\nNombre: " +Nombre+"\nCodigo: "+Codigo + "\nCargo: " + Cargo+ "\nHrsTrabajadas: " + HrsTrabajadas  ;
    }
    
}

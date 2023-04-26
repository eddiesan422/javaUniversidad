
package Controlador;

import Modelo.*;
import Vista.FormularioEstudiante;
import Vista.FormularioPrincipal;
import Vista.FormularioTrabajador;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class Control implements ActionListener{
   FormularioPrincipal objFrmPrincipal;        
   FormularioEstudiante  objFrmEstudiante; 
   FormularioTrabajador  objFrmTrabajador; 
   Estudiante objEstudiante; 
   Trabajador objTrabajador = new Trabajador ();
         ArrayList<Estudiante> DatosEstudiante = new ArrayList<Estudiante>();
         ArrayList<Trabajador> DatosTrabajador = new ArrayList<Trabajador>();
         
    public Control(){
         this.objFrmPrincipal = new FormularioPrincipal();
         this.objFrmEstudiante=  new FormularioEstudiante ();
         this.objFrmTrabajador = new FormularioTrabajador ();
         
         objFrmPrincipal.getBtnSeleccionarEstudiante().addActionListener(this);
         objFrmPrincipal.getBtnSeleccionarTrabajador().addActionListener(this);
         objFrmEstudiante.getBtnGenerarPago().addActionListener(this);
         objFrmEstudiante.getBtnLimpiarTabla().addActionListener(this);
         objFrmEstudiante.getBtnVolver().addActionListener(this);
         objFrmTrabajador.getBtnCalcularSalario().addActionListener(this);
         objFrmTrabajador.getBtnVolver().addActionListener(this);
         objFrmTrabajador.getBtnLimpiarTabla().addActionListener(this);
           
    }

  
    public void iniciar(){
        objFrmPrincipal.setTitle("Proyecto universidad");
        objFrmPrincipal.setLocationRelativeTo(null);
        objFrmPrincipal.setVisible(true);
        
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==objFrmTrabajador.getBtnCalcularSalario()) {
            try{
            this.objTrabajador = new Trabajador(
            objFrmTrabajador.getTxtNombre().getText(),
            Integer.parseInt(objFrmTrabajador.getTxtCodigo().getText()),
            objFrmTrabajador.getTxtCargo().getText(),
            Integer.parseInt(objFrmTrabajador.getTxtHorasTrabajadas().getText())
            );
            objTrabajador.setNombre(objFrmTrabajador.getTxtNombre().getText());
            objTrabajador.setCodigo(Integer.parseInt(objFrmTrabajador.getTxtCodigo().getText()));
            objTrabajador.setCargo(objFrmTrabajador.getTxtCargo().getText());
            objTrabajador.setHrsTrabajadas(Integer.parseInt(objFrmTrabajador.getTxtHorasTrabajadas().getText()));
            DatosTrabajador.add(objTrabajador);
            JOptionPane.showMessageDialog(null,"Los datos son: "+ objTrabajador.toString());
            }catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null,"Por favor ingrese los datos correctamente");
            }
            
                          iniciarControles(objFrmTrabajador.getJpnRegistro1().getComponents());
                          iniciarControles(objFrmTrabajador.getJpnRegistro2().getComponents());
           if (e.getSource()==objFrmTrabajador.getBtnCalcularSalario()){
             iniciarTabla(objFrmTrabajador.getTablaSalario());
               DefaultTableModel plantilla2 = (DefaultTableModel) objFrmTrabajador.getTablaSalario().getModel();
               for (Trabajador trabajador : DatosTrabajador) {
                   plantilla2.addRow(new Object[]{trabajador.getNombre(),trabajador.getCodigo(),
                       trabajador.getCargo(), trabajador.getHrsTrabajadas(), trabajador.CalcularSueldo()});
               }
              
           }
        }
        if (e.getSource()==objFrmPrincipal.getBtnSeleccionarEstudiante()) {
                   objFrmEstudiante.setVisible(true);
                   this.objFrmPrincipal.dispose();
         
            
        }
        if (e.getSource()== objFrmPrincipal.getBtnSeleccionarTrabajador()) {
             objFrmTrabajador.setVisible(true);
                   this.objFrmPrincipal.dispose();
        }
        if (e.getSource()== objFrmEstudiante.getBtnVolver()) {
            objFrmPrincipal.setVisible(true);
            this.objFrmEstudiante.dispose();
        }
        if (e.getSource()== objFrmTrabajador.getBtnVolver()) {
            objFrmPrincipal.setVisible(true);
            this.objFrmTrabajador.dispose();
        }
        if (e.getSource()==objFrmEstudiante.getBtnGenerarPago()) {
            try{
              this.objEstudiante= new Estudiante(
            objFrmEstudiante.getTxtNombre().getText(),
            Integer.parseInt(objFrmEstudiante.getTxtCodigo().getText()),
            objFrmEstudiante.getTxtCarrera().getText(),
            Integer.parseInt(objFrmEstudiante.getTxtCantidadMaterias().getText())
                    );
           objEstudiante.setNombre(objFrmEstudiante.getTxtNombre().getText());
           objEstudiante.setCarrera(objFrmEstudiante.getTxtCarrera().getText());
           objEstudiante.setCodigo(Integer.parseInt(objFrmEstudiante.getTxtCodigo().getText()));
           objEstudiante.setCantMaterias(Integer.parseInt(objFrmEstudiante.getTxtCantidadMaterias().getText()));
           DatosEstudiante.add(objEstudiante);
            JOptionPane.showMessageDialog(null,"Los datos son: "+ objEstudiante.toString());}catch(NumberFormatException nfe){
               JOptionPane.showMessageDialog(null,"Por favor ingrese los datos correctamente");
           }
           
              iniciarControles(objFrmEstudiante.getJpnRegistro().getComponents());
           if (e.getSource()==objFrmEstudiante.getBtnGenerarPago()){
             iniciarTabla(objFrmEstudiante.getTablaMatricula());
               DefaultTableModel plantilla = (DefaultTableModel) objFrmEstudiante.getTablaMatricula().getModel();
               for (Estudiante estudiante : DatosEstudiante) {
                   plantilla.addRow(new Object[]{estudiante.getNombre(),estudiante.getCodigo(),
                       estudiante.getCarrera(), estudiante.getCantMaterias(), estudiante.Valor()});
               }
              
           }
           
        }
        
        
        if (e.getSource()==objFrmEstudiante.getBtnLimpiarTabla()) {
            Clear_Table1(objFrmEstudiante.getTablaMatricula());
        }
        if (e.getSource()==objFrmTrabajador.getBtnLimpiarTabla()) {
             Clear_Table2(objFrmTrabajador.getTablaSalario());
        }
        
    }
    public void iniciarControles (Component[] controles){
                   for (Object control : controles) {
            if (control instanceof JTextField){
                ((JTextField) control).setText("");
            }
        }
               }
    public void iniciarTabla(JTable tabla){
         DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
         int tam=plantilla.getRowCount();
         for (int i = tam-1; i >= 0; i--) {
             plantilla.removeRow(i);
            
        }
    }
   private void Clear_Table1(JTable tabla){
       DefaultTableModel plantilla=(DefaultTableModel)tabla.getModel();
for (int i = 0; i < plantilla.getRowCount(); i++) {
plantilla.removeRow(i);
i-=1;
}
}
 public void Clear_Table2(JTable tabla){
        
             
         DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount()-1;
        for (int i = a; i >= 0; i--) {          
        plantilla.removeRow(plantilla.getRowCount()-1);
        }
    
    }
}

package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentasVista extends JFrame{
    JButton btnRegresar;
    //Creamos Tabla
    public DefaultTableModel datamodel;
    private Object [] datos;
    JTable tabladatos = new JTable();
    JPanel paneldatos = new JPanel(); 
    
public VentasVista(){
    
      super ("Módulo de Ventas");
        setSize (1000,680);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // el botón de cerrar sesión
        setVisible(true);
        setLayout(null);
        setResizable(false);
        
        // ATRIBUTOS DE LOS BOTONES
        
             btnRegresar= new JButton("Regresar");
        btnRegresar.setBounds(790,70,140,38);
        btnRegresar.setFont(new Font ("Calibri", 0,16));
        btnRegresar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnRegresar) {

                    setVisible(false);
                }
    }
        });
//        btnMenu.setBackground(new Color(212, 212, 212));
        add (btnRegresar);
    
    //Ingresamos elementos de la tabla
    datamodel = new DefaultTableModel();
    tabladatos = new JTable(datamodel);
    datos = new Object [8];
    datos[0] = "Id de venta";
    datos[1] = "Fecha de venta";
    datos[2] = "Nombre del ciente";
    datos[3] = "Nombre del Producto";
    datos[4] = "Precio del Producto";
    datos[5] = "Cantidad del Producto";
    datos[6] = "Valor de subtotal";
    datos[7] = "Valor total";
    
    datamodel.setColumnIdentifiers(datos);
//    tabladatos.setBackground(new Color(135, 206, 235));
//    paneldatos.setBackground(new Color(135, 206, 235));
    JScrollPane scroolpndatos = new JScrollPane(tabladatos);
    scroolpndatos.setBounds(30, 130, 900, 350);
//    paneldatos.setBounds(0, 0, 999, 990);
    add(scroolpndatos);
    add(paneldatos);
    show();
    JLabel imagen1 = new JLabel();
        imagen1.setIcon(new ImageIcon(getClass().getResource("/imagenes/fondo.png")));
        imagen1.setBounds(0, 25, 1400, 655);
        getContentPane().add(imagen1);

        setVisible(true);
        this.repaint();

    
}

    
public static void main (String[] args){  // DECLARAMOS EL METODO PRINCIPAL DE LA CLASE
    VentasVista vista = new VentasVista();
    
    
}

   
    
}

package Vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.awt.event.WindowAdapter;
import java.text.ParseException;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


//awt hay acciones
import javax.swing.*;

public class ventas extends JFrame implements ActionListener, KeyListener {

    static DecimalFormat d = new DecimalFormat("0.00");
    static VentasVista tablaventas = new VentasVista();
    static Negocio.Calculos calcular = new Negocio.Calculos();
    //Campos
    JLabel lblModuloVentas;
    JLabel lblObligatorios;
    JLabel lblIdventa;
    JTextField txtIdventa;
    JLabel lblFechadeventa;
    JLabel lblNombrelcliente;
    JTextField txtNombrelcliente;
    JLabel lblNombreproducto;
    JTextField txtNombreproducto;
    JLabel lblPrecioproducto;
    JTextField txtPrecioproducto;
    JLabel lblCantidad;
    JTextField txtCantidad;
    JLabel lblValorsubtotal;
    JTextField txtValorsubtotal;
    JLabel lblValortotal;
    JTextField txtValortotal;
    JDateChooser fechaventa;
    //Botones
    JButton btnCrear;
    JButton btnModificar;
    JButton btnBuscar;
    JButton btnEliminar;
    JButton btnLimpiar;
    JButton btnVistaPrevia;
    // botonesmodulos
    SimpleDateFormat Formato = new SimpleDateFormat("dd-MM-yyyy");

    public ventas() {
        super("Módulo de ventas ");
        setSize(1000, 680);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // el botón de cerrar sesión
        setVisible(true);
        setLayout(null);
        setResizable(false);

        this.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                tablaventas.setAlwaysOnTop(false);
            }
        });


        // etiquetas

        lblModuloVentas = new JLabel("MÓDULO VENTAS");
        lblModuloVentas.setForeground(Color.blue);
        lblModuloVentas.setBounds(470, 180, 490, 25);
        lblModuloVentas.setFont(new Font("Calibri", Font.BOLD, 17));
        add(lblModuloVentas);

        fechaventa = new JDateChooser();
        fechaventa.setBounds(320, 280, 210, 25);
        add(fechaventa);


        lblObligatorios = new JLabel("Todos los campos marcados con (*) son obligatorios");
        lblObligatorios.setForeground(Color.BLACK);
        lblObligatorios.setBounds(180, 460, 500, 25);
        lblObligatorios.setFont(new Font("Calibri", Font.BOLD, 17));
        add(lblObligatorios);



        lblIdventa = new JLabel("Id venta *");
        lblIdventa.setForeground(Color.BLACK);
        lblIdventa.setBounds(180, 220, 210, 25);
        lblIdventa.setFont(new Font("Calibri", Font.BOLD, 14));
        add(lblIdventa);

        lblFechadeventa = new JLabel("Fecha de venta *");
        lblFechadeventa.setForeground(Color.BLACK);
        lblFechadeventa.setBounds(180, 280, 210, 25);
        lblFechadeventa.setFont(new Font("Calibri", Font.BOLD, 14));
        add(lblFechadeventa);


        lblNombrelcliente = new JLabel("Nombre del cliente *");
        lblNombrelcliente.setForeground(Color.BLACK);
        lblNombrelcliente.setBounds(180, 340, 210, 25);
        lblNombrelcliente.setFont(new Font("Calibri", Font.BOLD, 14));
        add(lblNombrelcliente);

        lblNombreproducto = new JLabel("Nombre del producto*");
        lblNombreproducto.setForeground(Color.BLACK);
        lblNombreproducto.setBounds(180, 400, 210, 25);
        lblNombreproducto.setFont(new Font("Calibri", Font.BOLD, 14));
        add(lblNombreproducto);


        lblPrecioproducto = new JLabel("Precio del producto *");
        lblPrecioproducto.setForeground(Color.BLACK);
        lblPrecioproducto.setBounds(580, 220, 210, 25);
        lblPrecioproducto.setFont(new Font("Calibri", Font.BOLD, 14));
        add(lblPrecioproducto);

        lblCantidad = new JLabel("Cantidad *");
        lblCantidad.setForeground(Color.BLACK);
        lblCantidad.setBounds(580, 280, 210, 25);
        lblCantidad.setFont(new Font("Calibri", Font.BOLD, 14));
        add(lblCantidad);


        lblValorsubtotal = new JLabel("Valor subtotal*");
        lblValorsubtotal.setForeground(Color.BLACK);
        lblValorsubtotal.setBounds(580, 340, 210, 25);
        lblValorsubtotal.setFont(new Font("Calibri", Font.BOLD, 14));
        add(lblValorsubtotal);


        lblValortotal = new JLabel("Valor total *");
        lblValortotal.setForeground(Color.BLACK);
        lblValortotal.setBounds(580, 400, 210, 25);
        lblValortotal.setFont(new Font("Calibri", Font.BOLD, 14));
        add(lblValortotal);


        //Cajas de texto


        txtIdventa = new JTextField("");
        txtIdventa.setFont(new Font("Calibri", 0, 14));
        txtIdventa.setToolTipText("Ingrese Id del producto");
        txtIdventa.setBounds(320, 220, 210, 25);
        add(txtIdventa);





        txtNombrelcliente = new JTextField("");
        txtNombrelcliente.setFont(new Font("Calibri", 0, 14));
        txtNombrelcliente.setToolTipText("Ingrese nombre del cliente");
        txtNombrelcliente.setBounds(320, 340, 210, 25);
        add(txtNombrelcliente);



        txtNombreproducto = new JTextField("");
        txtNombreproducto.setFont(new Font("Calibri", 0, 14));
        txtNombreproducto.setToolTipText("Ingrese nombre del producto ");
        txtNombreproducto.setBounds(320, 400, 210, 25);
        add(txtNombreproducto);



        txtPrecioproducto = new JTextField("");
        txtPrecioproducto.setFont(new Font("Calibri", 0, 14));
        txtPrecioproducto.setToolTipText("Ingrese el precio del producto ");
        txtPrecioproducto.setBounds(705, 220, 210, 25);
        add(txtPrecioproducto);

        txtCantidad = new JTextField("");
        txtCantidad.setFont(new Font("Calibri", 0, 14));
        txtCantidad.setToolTipText("Ingrese el precio del producto ");
        txtCantidad.setBounds(705, 280, 210, 25);
        add(txtCantidad);


        txtValorsubtotal = new JTextField("");
        txtValorsubtotal.setFont(new Font("Calibri", 0, 14));
        txtValorsubtotal.setToolTipText("Ingrese el valor subtotal ");
        txtValorsubtotal.setBounds(705, 340, 210, 25);
        add(txtValorsubtotal);
        txtValorsubtotal.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {

                if (txtValorsubtotal.getText().equals("")) {
                    System.runFinalization();
                } else {
                    String valor = txtValorsubtotal.getText();
                    double inicial = Double.parseDouble(valor);
                    String valorFinal = d.format(calcular.valor(inicial));
                    txtValortotal.setText(valorFinal);
                }
            }
        });

        txtValortotal = new JTextField("");
        txtValortotal.setFont(new Font("calibri", 0, 14));
        txtValortotal.setBounds(705, 400, 210, 25);
        add(txtValortotal);

        //botones

        btnCrear = new JButton("Crear");
        btnCrear.setBounds(150, 500, 120, 30);
        btnCrear.setFont(new Font("Calibri", 0, 14));
        btnCrear.setBackground(new Color(220, 240, 255));
        add(btnCrear);

        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(280, 500, 120, 30);
        btnModificar.setFont(new Font("Calibri", 0, 14));
        btnModificar.setBackground(new Color(220, 240, 255));
        add(btnModificar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(410, 500, 120, 30);
        btnBuscar.setFont(new Font("Calibri", 0, 14));
        btnBuscar.setBackground(new Color(220, 240, 255));
        add(btnBuscar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(540, 500, 120, 30);
        btnEliminar.setFont(new Font("Calibri", 0, 14));
        btnEliminar.setBackground(new Color(220, 240, 255));
        add(btnEliminar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(670, 500, 120, 30);
        btnLimpiar.setFont(new Font("Calibri", 0, 14));
        btnLimpiar.setBackground(new Color(220, 240, 255));
        btnLimpiar.addActionListener(this);
        add(btnLimpiar);

        btnVistaPrevia = new JButton("VistaPrevia");
        btnVistaPrevia.setBounds(800, 500, 120, 30);
        btnVistaPrevia.setFont(new Font("Calibri", 0, 14));
        btnVistaPrevia.setBackground(new Color(220, 240, 255));
        btnVistaPrevia.addActionListener(this);
        add(btnVistaPrevia);
        btnVistaPrevia.addActionListener(this);




        //botones del menù

        this.repaint();

        // esto tambien para la validacion
        btnBuscar.addActionListener(this);
        btnCrear.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnModificar.addActionListener(this);
        txtIdventa.addKeyListener(this);
        txtNombrelcliente.addKeyListener(this);
        txtNombreproducto.addKeyListener(this);
        txtPrecioproducto.addKeyListener(this);
        txtCantidad.addKeyListener(this);
        txtValorsubtotal.addKeyListener(this);
        txtValortotal.addKeyListener(this);



        // fondo
        JLabel imagen1 = new JLabel();
        imagen1.setIcon(new ImageIcon(getClass().getResource("/imagenes/quizas.png")));
        imagen1.setBounds(0, 25, 1400, 655);
        getContentPane().add(imagen1);

        setVisible(true);
        this.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnLimpiar) {
            limpiar();
        }

        if (e.getSource() == btnVistaPrevia) {
            tablaventas.show();
            tablaventas.setAlwaysOnTop(true);
        }
        if (e.getSource() == btnCrear) {
            //Preguntamos si la accion ocurrio en el Boton Crear y si fue en el boton crear hace lo siguiente...

            Object[] opciones = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(rootPane, "¿En realidad desea guardar la venta?", "Mensaje de Confirmacion",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                if ("".equals(txtIdventa.getText())) {//pregunta de que si vacio es lo mismo que tiene el campo
                    JOptionPane.showMessageDialog(null, "Ingrese el Id de venta");
                } //                    else if ("".equals(txtFechadeventa.getText())){//pregunta de que si vacio es lo mismo que tiene el campo
                //                            JOptionPane.showMessageDialog(null,"Ingrese la fecha de venta");
                //                    }
                else if ("".equals(txtNombrelcliente.getText())) {//pregunta de que si vacio es lo mismo que tiene el campo
                    JOptionPane.showMessageDialog(null, "Ingrese la cedula del cliente");
                } else if ("".equals(txtNombreproducto.getText())) {//pregunta de que si vacio es lo mismo que tiene el campo
                    JOptionPane.showMessageDialog(null, "Ingrese el nombre del producto");
                } else if ("".equals(txtPrecioproducto.getText())) {//pregunta de que si vacio es lo mismo que tiene el campo
                    JOptionPane.showMessageDialog(null, "Ingrese el precio del producto");
                } else if ("".equals(txtCantidad.getText())) {//pregunta de que si vacio es lo mismo que tiene el campo
                    JOptionPane.showMessageDialog(null, "Ingrese la cantidad del producto");
                } else if ("".equals(txtValorsubtotal.getText())) {//pregunta de que si vacio es lo mismo que tiene el campo
                    JOptionPane.showMessageDialog(null, "Ingrese el valor  subtotal ");

                } else {
                    crear();
                }

            }


        }
        // estamos  indicando  que si el codigo ingresado es = a uno ya guardado lo traiga a pantalla

        if (e.getSource() == btnBuscar) {
            String datobusqueda = JOptionPane.showInputDialog("Ingrese el Id a buscar", "Id");
            if (datobusqueda == "" || datobusqueda == "Id") {
                System.runFinalization();
            }
            Date fecha = null;
            int busq = 0; // contaddor es el encargado de llevar el numero de vueltas hasta que encuentre el dato que se necesita.
            for (int j = 0; j < tablaventas.datamodel.getRowCount(); j++) {

                if (tablaventas.datamodel.getValueAt(j, 0).equals(datobusqueda)) {
                    txtIdventa.setText(tablaventas.datamodel.getValueAt(j, 0).toString());
                    try {
                        fecha = Formato.parse(tablaventas.datamodel.getValueAt(j, 1).toString());

                    } catch (Exception ex) {
                    }

                    fechaventa.setDate(fecha);
                    busq = 1;
                    btnCrear.disable();
                }

                txtNombrelcliente.setText(tablaventas.datamodel.getValueAt(j, 2).toString());
                txtNombreproducto.setText(tablaventas.datamodel.getValueAt(j, 3).toString());
                txtPrecioproducto.setText(tablaventas.datamodel.getValueAt(j, 4).toString());
                txtCantidad.setText(tablaventas.datamodel.getValueAt(j, 5).toString());
                txtValorsubtotal.setText(tablaventas.datamodel.getValueAt(j, 6).toString());
                txtValortotal.setText(tablaventas.datamodel.getValueAt(j, 7).toString());
                busq = 1;
                btnCrear.setEnabled(false);
            }

            if (busq == 0) {
                JOptionPane.showMessageDialog(null, "Venta no existe", "Consulta", JOptionPane.DEFAULT_OPTION);
            }
        }

        if (e.getSource() == btnEliminar) {
            if (txtIdventa.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese Id de venta", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            for (int i = 0; i < tablaventas.datamodel.getRowCount(); i++) {
                if (txtIdventa.getText().equals(tablaventas.datamodel.getValueAt(i, 0))) {
                    tablaventas.datamodel.removeRow(i);
                    JOptionPane.showMessageDialog(null, "La venta ha sido eliminada satisfactoriamente", "Consulta", JOptionPane.INFORMATION_MESSAGE);

                    limpiar();
                }

            }
        }
        if (e.getSource() == btnModificar) {
            for (int i = 0; i < tablaventas.datamodel.getRowCount(); i++) {
                if (txtIdventa.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ingrese código de venta", "Información", JOptionPane.INFORMATION_MESSAGE);
                    System.runFinalization();
                }
                for (int j = 0; j < tablaventas.datamodel.getRowCount(); j++) {

                    tablaventas.datamodel.setValueAt(txtIdventa.getText(), i, 0);
                    tablaventas.datamodel.setValueAt(txtNombrelcliente.getText(), i, 1);
                    tablaventas.datamodel.setValueAt(txtNombreproducto.getText(), i, 2);
                    tablaventas.datamodel.setValueAt(txtPrecioproducto.getText(), i, 3);
                    tablaventas.datamodel.setValueAt(txtCantidad.getText(), i, 4);
                    tablaventas.datamodel.setValueAt(txtValorsubtotal.getText(), i, 5);
                    tablaventas.datamodel.setValueAt(txtValortotal.getText(), i, 6);

                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

        if(e.getSource()==txtNombrelcliente){
    int limite=20;
                if (txtNombrelcliente.getText().length()==limite){
                e.consume();
                JOptionPane.showMessageDialog(null,"El número máximo de digitos es 20");
            }
 

        if (e.getSource() == txtNombrelcliente) {
          
            char c;
            c = e.getKeyChar();
            if (!(c < '0' || c > '9')) {
                e.consume();
                JOptionPane.showMessageDialog(null, "Solo se pueden ingresar letras ", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }
}
        if(e.getSource()==txtNombreproducto){
    int limite=20;
                if (txtNombreproducto.getText().length()==limite){
                e.consume();
                JOptionPane.showMessageDialog(null,"El número máximo de digitos es 20");
            }
 

        if (e.getSource() == txtNombreproducto) {
          
            char c;
            c = e.getKeyChar();
            if (!(c < '0' || c > '9')) {
                e.consume();
                JOptionPane.showMessageDialog(null, "Solo se pueden ingresar letras ", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }
}

            if (e.getSource() == txtIdventa) {
            int limite = 15;
            if (txtIdventa.getText().length() == limite) {
                e.consume();
                JOptionPane.showMessageDialog(null, "El número máximo de digitos es 15");
            }
            int k = (int) e.getKeyChar();
            if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {

                e.consume();
                JOptionPane.showMessageDialog(null, "Solo se pueden ingresar n\u00fameros ", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == txtPrecioproducto) {
            int limite = 20;
            if (txtPrecioproducto.getText().length() == limite) {
                e.consume();
                JOptionPane.showMessageDialog(null, "El número máximo de digitos es 20");
            }
            int k = (int) e.getKeyChar();
            if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {

                e.consume();
                JOptionPane.showMessageDialog(null, "Solo se pueden ingresar n\u00fameros ", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }



        if (e.getSource() == txtCantidad) {
            int limite = 15;
            if (txtCantidad.getText().length() == limite) {
                e.consume();
                JOptionPane.showMessageDialog(null, "El número máximo de digitos es 15");
            }
            int k = (int) e.getKeyChar();
            if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {

                e.consume();
                JOptionPane.showMessageDialog(null, "Solo se pueden ingresar n\u00fameros ", "Advertencia", JOptionPane.ERROR_MESSAGE);

            }
        }

        if (e.getSource() == txtValorsubtotal) {
            int limite = 15;
            if (txtValorsubtotal.getText().length() == limite) {
                e.consume();
                JOptionPane.showMessageDialog(null, "El número máximo de digitos es 15");
            }
            int k = (int) e.getKeyChar();
            if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {

                e.consume();
                JOptionPane.showMessageDialog(null, "Solo se pueden ingresar n\u00fameros ", "Advertencia", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == txtValortotal) {
            int limite = 15;
            if (txtValortotal.getText().length() == limite) {
                e.consume();
                JOptionPane.showMessageDialog(null, "El número máximo de digitos es 15");
            }
            int k = (int) e.getKeyChar();
            if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {

                e.consume();
                JOptionPane.showMessageDialog(null, "Solo se pueden ingresar n\u00fameros ", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }

        }


    }

    public void limpiar() {
        txtIdventa.setText("");
        txtNombrelcliente.setText("");
        txtNombreproducto.setText("");
        txtPrecioproducto.setText("");
        txtCantidad.setText("");
        txtValorsubtotal.setText("");
        txtValortotal.setText("");
        fechaventa.setDate(null);


        btnCrear.setEnabled(true);
    }

    public void crear() {

        Object[] fila = new Object[7];// estamos dandole propiedaes a la tabla
        fila[0] = txtIdventa.getText();
        if (fechaventa.getDate() == null) {
            fila[1] = "";
        } else {
            fila[1] = Formato.format(fechaventa.getDate());
        }



        fila[2] = txtNombrelcliente.getText();
        fila[3] = txtNombreproducto.getText();
        fila[4] = txtPrecioproducto.getText();
        fila[5] = txtCantidad.getText();
        fila[6] = txtValorsubtotal.getText();
        fila[7] = txtValortotal.getText();
        //llamando la informacion a la tabla le estamos dando posicion
        tablaventas.datamodel.addRow(fila);

        JOptionPane.showMessageDialog(null, "Venta ha sido creada", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {

        //construción del metodo
        tablaventas.show();
        ventas v = new ventas();

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

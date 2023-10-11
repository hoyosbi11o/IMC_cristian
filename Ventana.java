

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Ventana extends JFrame implements ActionListener{

    JPanel Panel;
    JLabel titulo,nombre,altura,peso,resul;
    JTextField c1,c2,c3;
    JButton boton1,boton2;

    Procesos miproceso;
    public Ventana() {
        miproceso = new Procesos();
        setTitle("Calculadora de IMC");
        setSize(600,450);
        setLocationRelativeTo(null);
        IniciarComponentes();
    }

    public void IniciarComponentes() {
        Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBackground(Color.gray);

        titulo = new JLabel();
        titulo.setText("SISTEMA DE IMC");
        titulo.setBounds(160, 30, 600, 60);
        titulo.setFont(new Font("Arial",Font.ITALIC,30));

        nombre = new JLabel();
        nombre.setText("Nombre");
        nombre.setBounds(260, 20, 50, 200);

        c1 = new JTextField();
        c1.setBounds(210, 130, 160, 30);

        altura = new JLabel();
        altura.setText("Estatura");
        altura.setBounds(260, 160, 200, 30);

        c2 = new JTextField();
        c2.setBounds(210, 190, 160, 30);

        peso= new JLabel();
        peso.setText("Peso");
        peso.setBounds(270, 220, 200, 30);

        c3 = new JTextField();
        c3.setBounds(210, 250, 160, 30);

        resul= new JLabel();
        resul.setText("IMC:");
        resul.setBounds(30,360 , 600, 30);

        boton1 = new JButton();
        boton1.setText("Calcular");
        boton1.setBounds(100, 300, 150, 30);
        boton1.addActionListener(this);

        boton2 = new JButton();
        boton2.setText("Limpiar");
        boton2.setBounds(330, 300, 150, 30);
        boton2.addActionListener(this);


        add(resul);
        add(boton2);
        add(boton1);
        add(c3);
        add(peso);
        add(c2);
        add(altura);
        add(c1);
        add(nombre);
        add(titulo);
        add(Panel);
    }

    public void calcular() {
        String nombre=c1.getText();
        double altura=Double.parseDouble(c2.getText());
        double peso=Double.parseDouble(c3.getText());

        double imc = miproceso.calcularIMC(altura, peso);
        String resultadoIMC = miproceso.evaluarIMC(imc);

        if(imc < 18.5) {
            resul.setText("Hola "+nombre+ " IMC:"+imc+ " Usted esta en bajo peso");
            resul.setForeground(Color.red);
        } else if (imc >= 18.5 && imc < 24.9) {
            resul.setText("Hola "+nombre+ " IMC: "+imc+ " Usted esta en peso saludable");
            resul.setForeground(Color.red);
        } else if (imc >= 25 && imc < 29.9) {
            resul.setText("Hola "+nombre+ " IMC: "+imc+ " Usted esta en sobre peso");
            resul.setForeground(Color.red);
        } else {
            resul.setText("Hola "+nombre+ " IMC: "+imc+ " Usted esta obeso");
            resul.setForeground(Color.red);
        }

        resul.setBackground(Color.black);
    }



    public void Limpiar() {
        c1.setText("");
        c2.setText("");
        c3.setText("");
        resul.setText("IMC:");
        resul.setBackground(Color.black);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1) {
            System.out.println("Calculando");
            calcular();
        }else if(e.getSource()==boton2) {
            System.out.println("Limpiar");
            Limpiar();
        }

    }



}
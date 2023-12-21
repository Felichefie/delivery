package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Guidistancia {
        static ArrayList<String> a;

        public Guidistancia() {
                JFrame frame = new JFrame("Guidistancia");
                JLabel l_origen = new JLabel("Origen");
                JTextField txt_origen = new JTextField("CiudadUniversitaria,Morelia,Mexico");
                JLabel l_destino = new JLabel("Destino");
                JTextField txt_destino = new JTextField("Uruapan,Mexico");
                JLabel l_datos = new JLabel("Tiempo y Distancia del Pedido");
                JLabel l_recomendacion = new JLabel("Favor de solamente ingresar comas; sin acentos,espacio o ñ");
                JLabel l_distancia = new JLabel("Distancia");
                JLabel l_tiempo = new JLabel("Tiempo");
                JTextField txt_tiempo = new JTextField();
                JTextField txt_distancia = new JTextField();

                JButton btn_calcular = new JButton("Calcular");
                JButton btn_cancelar = new JButton("Cancelar");

                l_origen.setBounds(20, 20, 100, 30);
                txt_origen.setBounds(20, 60, 100, 30);
                l_destino.setBounds(20, 100, 100, 30);
                txt_destino.setBounds(20, 140, 100, 30);
                l_recomendacion.setBounds(20, 180, 500, 70);
                btn_calcular.setBounds(20, 260, 100, 30);
                btn_cancelar.setBounds(150, 260, 100, 30);
                l_datos.setBounds(20, 300, 400, 30);
                l_distancia.setBounds(20, 340, 100, 30);
                txt_distancia.setBounds(20, 380, 100, 30);
                l_tiempo.setBounds(20, 420, 100, 30);
                txt_tiempo.setBounds(20, 460, 100, 30);

                btn_calcular.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                ConnectionMain c = new ConnectionMain(txt_origen.getText(), txt_destino.getText());
                                c.gettime();
                                c.getd();
                                txt_distancia.setText(c.getd());
                                txt_tiempo.setText(c.gettime());
                        }
                });

                btn_cancelar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                frame.dispose();
                        }
                });

                frame.setLayout(new BorderLayout());

                JButton btn_realizarPedido = new JButton("REALIZAR PEDIDO");
                btn_realizarPedido.setPreferredSize(new Dimension(300, 60));
                btn_realizarPedido.setBackground(new Color(7, 164, 121));
                btn_realizarPedido.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
                btn_realizarPedido.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
                btn_realizarPedido.setForeground(Color.WHITE);
                btn_realizarPedido.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                // Get text from fields
                                String tiempo = txt_tiempo.getText();
                                String distancia = txt_distancia.getText();

                                // Check if fields are empty
                                if (tiempo.isEmpty() || distancia.isEmpty()) {
                                        JOptionPane.showMessageDialog(frame, "Calcula el tiempo y distancia");
                                } else {
                                        JOptionPane.showMessageDialog(frame, "Compra exitosa");
                                        frame.dispose();
                                }
                        }
                });

                frame.add(btn_realizarPedido, BorderLayout.SOUTH);

                frame.add(l_destino);
                frame.add(l_origen);
                frame.add(l_datos);
                frame.add(l_recomendacion);
                frame.add(txt_destino);
                frame.add(txt_distancia);
                frame.add(txt_tiempo);
                frame.add(txt_origen);
                frame.add(btn_calcular);
                frame.add(btn_cancelar);
                frame.add(l_distancia);
                frame.add(l_tiempo);

                frame.setSize(600, 600);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
        }
}

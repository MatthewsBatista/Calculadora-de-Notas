package calculadoranotas;

import javax.swing.*;
import java.awt.*;

public class CalculadoraNotas extends JFrame {

    private JTextField txtNombre, txtMatricula, txtCarrera,
            txtP1, txtP2, txtP3, txtP4;
    private JButton btnCalcular;
    private JLabel lblNota, lblEstado;

    public CalculadoraNotas() {
        setTitle("Calculadora de Notas");
        setSize(450, 520);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 2, 10, 10));

        // Fondo y márgenes
        getContentPane().setBackground(new Color(235, 242, 250));
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Crear componentes
        txtNombre = new JTextField();
        txtMatricula = new JTextField();
        txtCarrera = new JTextField();
        txtP1 = new JTextField();
        txtP2 = new JTextField();
        txtP3 = new JTextField();
        txtP4 = new JTextField();
        btnCalcular = new JButton("Calcular Resultado");
        lblNota = new JLabel("Nota total: --");
        lblEstado = new JLabel(" ");

        // Estilo de los campos de texto
        JTextField[] campos = {txtNombre, txtMatricula, txtCarrera, txtP1, txtP2, txtP3, txtP4};
        for (JTextField campo : campos) {
            campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        }

        // Estilo del botón
        btnCalcular.setBackground(new Color(30, 90, 160));
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCalcular.setFocusPainted(false);
        btnCalcular.setOpaque(true);
        btnCalcular.setBorderPainted(false);

        // Estilo de las etiquetas de resultado
        lblNota.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNota.setHorizontalAlignment(SwingConstants.CENTER);
        lblEstado.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblEstado.setHorizontalAlignment(SwingConstants.CENTER);

        // Agregar a la ventana
        add(crearEtiqueta("Nombre completo:"));
        add(txtNombre);
        add(crearEtiqueta("Matrícula:"));
        add(txtMatricula);
        add(crearEtiqueta("Carrera:"));
        add(txtCarrera);
        add(crearEtiqueta("Prácticas (0-40):"));
        add(txtP1);
        add(crearEtiqueta("Parciales (0-20):"));
        add(txtP2);
        add(crearEtiqueta("Asignaciones (0-20):"));
        add(txtP3);
        add(crearEtiqueta("Examen Final (0-20):"));
        add(txtP4);
        add(new JLabel(""));
        add(btnCalcular);
        add(lblNota);
        add(lblEstado);

        btnCalcular.addActionListener(e -> calcularResultado());
    }

    // Crea una etiqueta con estilo
    private JLabel crearEtiqueta(String texto) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lbl.setForeground(new Color(40, 40, 40));
        lbl.setHorizontalAlignment(SwingConstants.RIGHT);
        return lbl;
    }

    private void calcularResultado() {
        // 1. Validar que los datos personales no estén vacíos
        if (txtNombre.getText().trim().isEmpty()
                || txtMatricula.getText().trim().isEmpty()
                || txtCarrera.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete nombre, matrícula y carrera.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // 2. Leer y validar cada nota
            double practicas = leerNota(txtP1, "Prácticas", 40);
            double parciales = leerNota(txtP2, "Parciales", 20);
            double asignaciones = leerNota(txtP3, "Asignaciones", 20);
            double examen = leerNota(txtP4, "Examen Final", 20);

            // 3. Sumar
            double total = practicas + parciales + asignaciones + examen;
            lblNota.setText("Nota total: " + total + " / 100");

            // 4. Aprobado o reprobado
            if (total >= 60) {
                lblEstado.setText("APROBADO");
                lblEstado.setForeground(new Color(0, 130, 0));
            } else {
                lblEstado.setText("REPROBADO");
                lblEstado.setForeground(Color.RED);
            }
        } catch (IllegalArgumentException ex) {
            lblNota.setText("Nota total: --");
            lblEstado.setText(" ");
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Lee un campo, valida que sea número y que esté entre 0 y el máximo
    private double leerNota(JTextField campo, String nombre, double maximo) {
        String texto = campo.getText().trim();
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("El campo " + nombre + " no puede estar vacío.");
        }
        double valor;
        try {
            valor = Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El campo " + nombre + " debe ser un número.");
        }
        if (valor < 0 || valor > maximo) {
            throw new IllegalArgumentException(
                    "El campo " + nombre + " debe estar entre 0 y " + (int) maximo + ".");
        }
        return valor;
    }

    public static void main(String[] args) {
        CalculadoraNotas ventana = new CalculadoraNotas();
        ventana.setVisible(true);
    }
}

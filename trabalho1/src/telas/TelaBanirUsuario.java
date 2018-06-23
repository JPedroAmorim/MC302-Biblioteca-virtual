package telas;

import trabalho1.SistemaExcecao;
import trabalho1.Usuario;
import trabalho1.UsuarioAdmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaBanirUsuario extends JFrame {

    JFrame janelaBanirUsuario;
    JPanel painelBanirUsuario;
    JButton botaoConfirmar;
    JTextField usuarioBanido;
    JLabel perguntaUsuario;

    public TelaBanirUsuario() {



    }

    public static void main(String[] args){
        new TelaBanirUsuario();
    }
}

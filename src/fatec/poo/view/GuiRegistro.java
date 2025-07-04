/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.view;

import fatec.poo.control.DaoHospede;
import fatec.poo.control.DaoQuarto;
import fatec.poo.control.DaoRecepcionista;
import fatec.poo.control.DaoRegistro;
import fatec.poo.control.PreparaConexao;
import fatec.poo.model.Hospede;
import fatec.poo.model.Quarto;
import fatec.poo.model.Recepcionista;
import fatec.poo.model.Registro;
import fatec.poo.utils.Helper;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Thalles
 */
public class GuiRegistro extends javax.swing.JFrame {

    /**
     * Creates new form GuiRegistro
     */
    public GuiRegistro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtRegistroFuncional = new javax.swing.JTextField();
        txtCpfHospede = new javax.swing.JFormattedTextField();
        txtNQjuarto = new javax.swing.JTextField();
        txtDataEntrada = new javax.swing.JFormattedTextField();
        txtDataSaida = new javax.swing.JFormattedTextField();
        btnConsultar = new javax.swing.JButton();
        btnConsultarRecepcionista = new javax.swing.JButton();
        btnConsultarHospede = new javax.swing.JButton();
        btnConsultarSituacaoQuarto = new javax.swing.JButton();
        btnReservar = new javax.swing.JButton();
        btnLiberar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblNomeHospede = new javax.swing.JLabel();
        lblNomeRecepcionista = new javax.swing.JLabel();
        lblSituacaoQuarto = new javax.swing.JLabel();
        lblValorHospedagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro Hospedagem");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Código");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText("Registro Funcional");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText("CPF Hóspede");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText("Nº.Quarto");
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText("Data Entrada");
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText("Data Saída");
        jLabel6.setName("lblDataSaida"); // NOI18N

        jLabel7.setText("Valor Hospedagem");

        jLabel8.setText("Situação");

        txtCodigo.setName("Codigo"); // NOI18N

        txtRegistroFuncional.setEnabled(false);
        txtRegistroFuncional.setName("Registro Funcional"); // NOI18N

        try {
            txtCpfHospede.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpfHospede.setEnabled(false);
        txtCpfHospede.setName("Cpf Hospede"); // NOI18N

        txtNQjuarto.setEnabled(false);
        txtNQjuarto.setName("Nº Quarto"); // NOI18N

        try {
            txtDataEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataEntrada.setEnabled(false);
        txtDataEntrada.setName("Data Entrada"); // NOI18N

        try {
            txtDataSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataSaida.setEnabled(false);
        txtDataSaida.setName("Data Saida"); // NOI18N

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/pesq.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnConsultarRecepcionista.setText("...");
        btnConsultarRecepcionista.setEnabled(false);
        btnConsultarRecepcionista.setName("btnConsultarRecepcionista"); // NOI18N
        btnConsultarRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarRecepcionistaActionPerformed(evt);
            }
        });

        btnConsultarHospede.setText("...");
        btnConsultarHospede.setEnabled(false);
        btnConsultarHospede.setName("btnConsultarHospede"); // NOI18N
        btnConsultarHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarHospedeActionPerformed(evt);
            }
        });

        btnConsultarSituacaoQuarto.setText("...");
        btnConsultarSituacaoQuarto.setEnabled(false);
        btnConsultarSituacaoQuarto.setName("btnConsultarSituacaoQuarto"); // NOI18N
        btnConsultarSituacaoQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarSituacaoQuartoActionPerformed(evt);
            }
        });

        btnReservar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/add.png"))); // NOI18N
        btnReservar.setText("Reservar");
        btnReservar.setEnabled(false);
        btnReservar.setName("btnReservar"); // NOI18N
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        btnLiberar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/rem.png"))); // NOI18N
        btnLiberar.setText("Liberar");
        btnLiberar.setEnabled(false);
        btnLiberar.setName("btnLiberar"); // NOI18N
        btnLiberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiberarActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/exit.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setName("btnSair"); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lblNomeHospede.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblNomeHospede.setPreferredSize(new java.awt.Dimension(6, 20));

        lblNomeRecepcionista.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblNomeRecepcionista.setPreferredSize(new java.awt.Dimension(6, 20));

        lblSituacaoQuarto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblSituacaoQuarto.setPreferredSize(new java.awt.Dimension(6, 20));

        lblValorHospedagem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblValorHospedagem.setPreferredSize(new java.awt.Dimension(6, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDataSaida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addComponent(txtDataEntrada, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblValorHospedagem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(txtRegistroFuncional, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNQjuarto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCpfHospede, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultarRecepcionista)
                            .addComponent(jLabel8)
                            .addComponent(btnConsultarHospede))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLiberar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblNomeRecepcionista, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNomeHospede, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btnConsultarSituacaoQuarto)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblSituacaoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtRegistroFuncional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultarRecepcionista))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtCpfHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnConsultarHospede))
                            .addComponent(lblNomeHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblNomeRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtNQjuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(btnConsultarSituacaoQuarto))
                    .addComponent(lblSituacaoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lblValorHospedagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReservar)
                    .addComponent(btnLiberar)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private String converterParaISO(String dataBR) {
    try {
        java.time.format.DateTimeFormatter formatoBR = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        java.time.LocalDate data = java.time.LocalDate.parse(dataBR, formatoBR);
        return data.toString(); // formato ISO: yyyy-MM-dd
    } catch (Exception e) {
        return null;
    }
}

    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        prepCon = new PreparaConexao("",""); //Usuário e senha                            
        prepCon.setDriver("net.ucanaccess.jdbc.UcanaccessDriver");
        prepCon.setConnectionString("jdbc:ucanaccess://C:\\\\Users\\\\ericd\\\\Documents\\\\Projects\\\\Fatec\\\\POO\\\\Trabalhos\\\\prjPOOEricThalles\\\\src\\\\fatec\\\\poo\\\\basededados\\\\prjPOOBD.accdb");
        daoRegistro = new DaoRegistro(prepCon.abrirConexao());

        if (daoRegistro == null) {
             JOptionPane.showMessageDialog(this, "Erro na conexão com o banco!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        if(!Helper.isValidInteger(txtCodigo))return;
        int codigoRegistro = Integer.parseInt(txtCodigo.getText().trim());
        
         registro = daoRegistro.consultar(codigoRegistro);
        
         if (registro != null) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            txtDataEntrada.setText(registro.getDataEntrada().format(dtf));
            if(registro.getDataSaida() != null){
                txtDataSaida.setText(registro.getDataSaida().format(dtf));
            }
            
            txtCpfHospede.setText(registro.getHospede().getCpf());
            lblNomeHospede.setText(registro.getHospede().getNome());
            txtNQjuarto.setText(Integer.toString(registro.getQuarto().getNumero()));
            lblSituacaoQuarto.setText(registro.getQuarto().getSituacao()? "Ocupado" : "Disponível");
            txtRegistroFuncional.setText(Integer.toString(registro.getRecepcionista().getRegFunc()));
            lblNomeRecepcionista.setText(registro.getRecepcionista().getNome());
            lblValorHospedagem.setText(String.format("%.2f", registro.getValorHospedagem()));

            if (registro.getDataSaida() == null) {
                txtDataSaida.setEnabled(true);
                btnLiberar.setEnabled(true);
                txtDataSaida.requestFocus();
            } else {
                txtDataSaida.setText(registro.getDataSaida().toString());
            }
            
            txtCodigo.setEnabled(false);
            btnConsultar.setEnabled(false);
            btnReservar.setEnabled(false);
        } else {
            btnConsultar.setEnabled(false);
            txtCodigo.setEnabled(false);
            txtRegistroFuncional.setEnabled(true);
            btnConsultarRecepcionista.setEnabled(true);
            txtRegistroFuncional.requestFocus();
        }
        
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnConsultarRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarRecepcionistaActionPerformed
        if(!Helper.isValidInteger(txtRegistroFuncional))return;
        int regFunc = Integer.parseInt(txtRegistroFuncional.getText().trim());
        
        try {
            DaoRecepcionista daoRecep = new DaoRecepcionista(prepCon.abrirConexao());
            recep = daoRecep.consultar(regFunc);
            
             if (recep != null) {
                lblNomeRecepcionista.setText(recep.getNome());
                txtRegistroFuncional.setEnabled(false);
                btnConsultarRecepcionista.setEnabled(false);
                txtCpfHospede.setEnabled(true);
                btnConsultarHospede.setEnabled(true);
                txtCpfHospede.requestFocus();
                
            } else {
                JOptionPane.showMessageDialog(this, "Recepcionista não cadastrado.");
                lblNomeRecepcionista.setText("");
                txtRegistroFuncional.requestFocus();
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código inválido.");
            lblNomeRecepcionista.setText("");
            txtRegistroFuncional.requestFocus();
        }
        
        
    }//GEN-LAST:event_btnConsultarRecepcionistaActionPerformed

    private void btnConsultarHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarHospedeActionPerformed
       if (!Hospede.validarCPF(txtCpfHospede.getText())) {
            JOptionPane.showMessageDialog(null, "CPF inválido");
            txtCpfHospede.requestFocus();
            return;
        }
        DaoHospede daoHospede = new DaoHospede(prepCon.abrirConexao());
        hospede = daoHospede.consultar(Hospede.limparCPF(txtCpfHospede.getText()));
        
        if (hospede != null) {
            lblNomeHospede.setText(hospede.getNome());
            txtCpfHospede.setEnabled(false);
            btnConsultarHospede.setEnabled(false);
            txtNQjuarto.setEnabled(true);
            btnConsultarSituacaoQuarto.setEnabled(true);
            txtNQjuarto.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Hóspede não cadastrado.");
            lblNomeHospede.setText("");
        }
        
        
    }//GEN-LAST:event_btnConsultarHospedeActionPerformed

    private void btnConsultarSituacaoQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarSituacaoQuartoActionPerformed
        if(!Helper.isValidInteger(txtNQjuarto))return;
        int numero = Integer.parseInt(txtNQjuarto.getText().trim());
        
         try {
            
            DaoQuarto daoQuarto = new DaoQuarto(prepCon.abrirConexao());
            quarto = daoQuarto.consultar(numero);

            if (quarto != null) { 
                if (quarto.getSituacao()) { 
                    JOptionPane.showMessageDialog(this, "Quarto Ocupado.");
                    lblSituacaoQuarto.setText("Ocupado");
                    txtNQjuarto.requestFocus();
                } else {
                    lblSituacaoQuarto.setText("Disponível");
                    txtNQjuarto.setEnabled(false);
                    btnConsultarSituacaoQuarto.setEnabled(false);
                    txtDataEntrada.setEnabled(true);
                    txtDataEntrada.requestFocus();
                    btnReservar.setEnabled(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Quarto não cadastrado.");
                lblSituacaoQuarto.setText("");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Número de quarto inválido.");
            lblSituacaoQuarto.setText("");
        }
        
        
        
    }//GEN-LAST:event_btnConsultarSituacaoQuartoActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        String dataStr = converterParaISO(txtDataEntrada.getText().trim());
        if (dataStr == null) {
            JOptionPane.showMessageDialog(this, "Data de entrada inválida.\nUse o formato: DD/MM/AAAA", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            txtDataEntrada.requestFocus();
            return;
        }

        
        if(!Helper.isValidInteger(txtCodigo))return;
        int codigoRegistro = Integer.parseInt(txtCodigo.getText().trim());
        LocalDate dataEntrada = LocalDate.parse(dataStr);
        
        registro = new Registro(codigoRegistro, dataEntrada, recep);
        
        registro.setHospede(hospede);
        registro.setQuarto(quarto);
        
        quarto.reservar();
        
        DaoQuarto daoQuarto = new DaoQuarto(prepCon.abrirConexao());
        daoQuarto.alterar(quarto);
        
        daoRegistro.reservar(registro);
        
        JOptionPane.showMessageDialog(this, "Reserva efetuada com sucesso!");
        
        txtCodigo.setText("");
        txtRegistroFuncional.setText("");
        txtCpfHospede.setText("");
        txtNQjuarto.setText("");
        txtDataEntrada.setText("");
        txtDataSaida.setText("");
        lblNomeRecepcionista.setText("");
        lblNomeHospede.setText("");
        lblSituacaoQuarto.setText("");
        lblValorHospedagem.setText("");

        txtRegistroFuncional.setEnabled(false);
        txtCpfHospede.setEnabled(false);
        txtNQjuarto.setEnabled(false);
        txtDataEntrada.setEnabled(false);
        txtDataSaida.setEnabled(false);
        btnConsultarRecepcionista.setEnabled(false);
        btnConsultarHospede.setEnabled(false);
        btnConsultarSituacaoQuarto.setEnabled(false);
        btnReservar.setEnabled(false);
        btnLiberar.setEnabled(false);
        btnConsultar.setEnabled(true);
        txtCodigo.setEnabled(true);
        txtCodigo.requestFocus();
        
    }//GEN-LAST:event_btnReservarActionPerformed

    private void btnLiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiberarActionPerformed
        String dataStr = converterParaISO(txtDataSaida.getText().trim());
        if (dataStr == null) {
            JOptionPane.showMessageDialog(this, "Data de saida inválida.\nUse o formato: DD/MM/AAAA", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            txtDataEntrada.requestFocus();
            return;
        }
        
        LocalDate dataSaida = LocalDate.parse(dataStr);
        
        if (dataSaida.isBefore(registro.getDataEntrada())) {
            JOptionPane.showMessageDialog(this, "A data de saída não pode ser anterior à data de entrada!", "Data inválida", JOptionPane.ERROR_MESSAGE);
            txtDataSaida.requestFocus();
            return;
        }
        registro.setDataSaida(dataSaida);

        double valor = registro.liberarQuarto();
        daoRegistro.liberar(registro);
        DaoQuarto daoQuarto = new DaoQuarto(prepCon.abrirConexao());
        daoQuarto.alterar(registro.getQuarto());

        lblValorHospedagem.setText(String.format("%.2f", valor));
        txtDataSaida.setEnabled(false);
        btnLiberar.setEnabled(false);
        lblSituacaoQuarto.setText("Disponível");
        
        
    }//GEN-LAST:event_btnLiberarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnConsultarHospede;
    private javax.swing.JButton btnConsultarRecepcionista;
    private javax.swing.JButton btnConsultarSituacaoQuarto;
    private javax.swing.JButton btnLiberar;
    private javax.swing.JButton btnReservar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblNomeHospede;
    private javax.swing.JLabel lblNomeRecepcionista;
    private javax.swing.JLabel lblSituacaoQuarto;
    private javax.swing.JLabel lblValorHospedagem;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtCpfHospede;
    private javax.swing.JFormattedTextField txtDataEntrada;
    private javax.swing.JFormattedTextField txtDataSaida;
    private javax.swing.JTextField txtNQjuarto;
    private javax.swing.JTextField txtRegistroFuncional;
    // End of variables declaration//GEN-END:variables
    private PreparaConexao prepCon = null;
    private DaoRegistro daoRegistro = null;
    private Registro registro = null;
    private Recepcionista recep = null;
    private Hospede hospede = null;
    private Quarto quarto = null;
}

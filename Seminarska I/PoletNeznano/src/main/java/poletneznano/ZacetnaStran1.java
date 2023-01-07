/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package poletneznano;

import com.toedter.calendar.JDayChooser;
import java.awt.Color;
import java.awt.Component;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author anjabrelih
 */
public class ZacetnaStran1 extends javax.swing.JFrame {
    
    Poizvedba poizvedba;

    
   /**
     * Creates new form ZacetnaStran1
     */
    public ZacetnaStran1() {
        initComponents();
    }
    
    public void setPoizvedba(Poizvedba poizvedba){
        this.poizvedba=poizvedba;
        
        if(poizvedba.getAirportA() != null){
            txtAirA.setText(poizvedba.getAirportA());
            txtAirB.setText(poizvedba.getAirportB());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        airPanel = new javax.swing.JPanel();
        txtAirB = new javax.swing.JTextField();
        txtAirA = new javax.swing.JTextField();
        noPassPanel = new javax.swing.JPanel();
        noChild = new javax.swing.JSpinner();
        noAdult = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnArrAirport = new javax.swing.JRadioButton();
        btnDepAirport = new javax.swing.JRadioButton();
        datePanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnDateDep = new javax.swing.JRadioButton();
        dateDep = new com.toedter.calendar.JDateChooser();
        dateRet = new com.toedter.calendar.JDateChooser();
        returnPanel = new javax.swing.JPanel();
        btnReturn = new javax.swing.JRadioButton();
        onewayPanel = new javax.swing.JPanel();
        btnOneway = new javax.swing.JRadioButton();
        btnIskanje = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(957, 736));

        background.setBackground(new java.awt.Color(255, 255, 255));

        titlePanel.setBackground(new java.awt.Color(0, 204, 204));

        title.setFont(new java.awt.Font("Myanmar Sangam MN", 1, 26)); // NOI18N
        title.setText("Polet v neznano");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(title)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        txtAirB.setBackground(new java.awt.Color(204, 255, 255));
        txtAirB.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N

        txtAirA.setBackground(new java.awt.Color(204, 255, 255));
        txtAirA.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        txtAirA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAirAActionPerformed(evt);
            }
        });

        noPassPanel.setBackground(new java.awt.Color(255, 255, 255));
        noPassPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        noPassPanel.setPreferredSize(new java.awt.Dimension(127, 64));

        noChild.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        noChild.setModel(new javax.swing.SpinnerNumberModel(0, 0, 9, 1));

        noAdult.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        noAdult.setModel(new javax.swing.SpinnerNumberModel(1, 0, 10, 1));
        noAdult.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        jLabel4.setText("15+ let");

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        jLabel5.setText("0-15 let");

        javax.swing.GroupLayout noPassPanelLayout = new javax.swing.GroupLayout(noPassPanel);
        noPassPanel.setLayout(noPassPanelLayout);
        noPassPanelLayout.setHorizontalGroup(
            noPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noPassPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(noAdult, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(noPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(noChild, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        noPassPanelLayout.setVerticalGroup(
            noPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noPassPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noAdult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        jLabel1.setText("Letališče odhoda");

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        jLabel2.setText("Letališče prihoda");

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        jLabel3.setText("Potniki");

        btnArrAirport.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnArrAirport.setText("išči tudi bližnja letališča");
        btnArrAirport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArrAirportActionPerformed(evt);
            }
        });

        btnDepAirport.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnDepAirport.setText("išči tudi bližnja letališča");
        btnDepAirport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepAirportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout airPanelLayout = new javax.swing.GroupLayout(airPanel);
        airPanel.setLayout(airPanelLayout);
        airPanelLayout.setHorizontalGroup(
            airPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, airPanelLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(airPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAirA, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnDepAirport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(airPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnArrAirport)
                    .addGroup(airPanelLayout.createSequentialGroup()
                        .addGroup(airPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAirB, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(airPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(noPassPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(80, 80, 80))
        );
        airPanelLayout.setVerticalGroup(
            airPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, airPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(airPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(airPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(airPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(noPassPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(airPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAirB, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAirA, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(airPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArrAirport)
                    .addComponent(btnDepAirport))
                .addGap(26, 26, 26))
        );

        datePanel.setPreferredSize(new java.awt.Dimension(779, 180));

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        jLabel6.setText("Datum odhoda");

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        jLabel7.setText("Datum prihoda");

        btnDateDep.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnDateDep.setText("določi obdobje");
        btnDateDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateDepActionPerformed(evt);
            }
        });

        dateDep.setBackground(new java.awt.Color(204, 255, 255));
        dateDep.setDateFormatString("dd MMM yyyy");
        dateDep.setFont(new java.awt.Font("Montserrat", 1, 15)); // NOI18N
        dateDep.setMaxSelectableDate(new java.util.Date(253370764894000L));
        dateDep.setMinSelectableDate(new java.util.Date(-62135769506000L));

        dateRet.setBackground(new java.awt.Color(204, 255, 255));
        dateRet.setDateFormatString("dd MMM yyyy");
        dateRet.setFont(new java.awt.Font("Montserrat", 1, 15)); // NOI18N
        dateRet.setMaxSelectableDate(new java.util.Date(253370764894000L));
        dateRet.setMinSelectableDate(new java.util.Date(-62135769506000L));

        javax.swing.GroupLayout datePanelLayout = new javax.swing.GroupLayout(datePanel);
        datePanel.setLayout(datePanelLayout);
        datePanelLayout.setHorizontalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePanelLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datePanelLayout.createSequentialGroup()
                        .addComponent(dateDep, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateRet, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(datePanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(179, 179, 179))
                    .addGroup(datePanelLayout.createSequentialGroup()
                        .addComponent(btnDateDep)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        datePanelLayout.setVerticalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateDep, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateRet, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnDateDep)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        btnReturn.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        btnReturn.setSelected(true);
        btnReturn.setText("Povratno");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout returnPanelLayout = new javax.swing.GroupLayout(returnPanel);
        returnPanel.setLayout(returnPanelLayout);
        returnPanelLayout.setHorizontalGroup(
            returnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(returnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReturn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        returnPanelLayout.setVerticalGroup(
            returnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, returnPanelLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(btnReturn))
        );

        onewayPanel.setBackground(new java.awt.Color(255, 255, 255));

        btnOneway.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        btnOneway.setText("Enosmerno");
        btnOneway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnewayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout onewayPanelLayout = new javax.swing.GroupLayout(onewayPanel);
        onewayPanel.setLayout(onewayPanelLayout);
        onewayPanelLayout.setHorizontalGroup(
            onewayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(onewayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOneway)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        onewayPanelLayout.setVerticalGroup(
            onewayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, onewayPanelLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(btnOneway))
        );

        btnIskanje.setBackground(new java.awt.Color(0, 204, 204));
        btnIskanje.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btnIskanje.setText("Iskanje");
        btnIskanje.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIskanje.setMaximumSize(new java.awt.Dimension(120, 40));
        btnIskanje.setMinimumSize(new java.awt.Dimension(100, 30));
        btnIskanje.setSize(new java.awt.Dimension(120, 40));
        btnIskanje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIskanjeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(returnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(onewayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(datePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(airPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnIskanje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(airPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(onewayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(datePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnIskanje, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(957, 669));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnArrAirportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArrAirportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnArrAirportActionPerformed

    private void btnDepAirportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepAirportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDepAirportActionPerformed

    private void txtAirAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAirAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAirAActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnOnewayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOnewayActionPerformed
        // TODO add your handling code here:
        
        // ENOSMEREN LET
        String airportA=txtAirA.getText();
        String airportB=txtAirB.getText();
        
        Poizvedba poizvedba = new Poizvedba(airportA, airportB, null, null, null, null);
        
        
        ZacetnaStran2 n = new ZacetnaStran2();
        n.setVisible(true);
        n.setPoizvedba(poizvedba);
        this.dispose();
    }//GEN-LAST:event_btnOnewayActionPerformed

    private void btnDateDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateDepActionPerformed
        // TODO add your handling code here:
        // DOLOCI OBDOBJE
        String airportA=txtAirA.getText();
        String airportB=txtAirB.getText();
        
        Poizvedba poizvedba = new Poizvedba(airportA, airportB, null, null, null, null);
                
        ZacetnaStran1_1 n = new ZacetnaStran1_1();
        n.setVisible(true);
        n.setPoizvedba(poizvedba);
        this.dispose();
    }//GEN-LAST:event_btnDateDepActionPerformed

    private void btnIskanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIskanjeActionPerformed
        // TODO add your handling code here:
        // NAPREJ

        String airportA=txtAirA.getText();
        String airportB=txtAirB.getText();
        
        
        
        if(airportA.isEmpty() || airportB.isEmpty() || dateRet.getDate() == null || dateDep.getDate() == null){
            if(airportA.isEmpty()){
                // set bg to light red
                txtAirA.setBackground(new Color(255, 204, 203));
            } else{
                // set bg back to normal
                txtAirA.setBackground(new Color(204,255,255));
            }
                
            if(airportB.isEmpty()){
                // set bg to light red
                txtAirB.setBackground(new Color(255, 204, 203));
            }
            else{
                // set bg back to normal
                txtAirB.setBackground(new Color(204,255,255));
            }
            if(dateRet.getDate() == null){
                // set bg to light red
                dateRet.setBackground(new Color(255, 204, 203));
            }
            else{
                // set bg back to normal
                dateRet.setBackground(new Color(204,255,255));
            }
            if(dateDep.getDate() == null){
                // set bg to light red
                dateDep.setBackground(new Color(255, 204, 203));
            }
            else{
                // set bg back to normal
                dateDep.setBackground(new Color(204,255,255));
            }
            
            JOptionPane.showMessageDialog(null, "Prosim izpolnite vsa polja.", "Opozorilo",JOptionPane.WARNING_MESSAGE);
            
            
        }
        else{
                       
            Date dateA = dateDep.getDate();
            Date dateB = dateRet.getDate();
            
            String strDateA = DateFormat.getDateInstance().format(dateA);
            String strDateB = DateFormat.getDateInstance().format(dateB);
            String strDateA1 = null;
            String strDateB1 = null;
            
            Poizvedba poizvedba = new Poizvedba(airportA, airportB, strDateA, strDateB, strDateA1, strDateB1);
            
            LetalskeKarte n = new LetalskeKarte();
           
            n.setVisible(true);
            n.setPoizvedba(poizvedba);
            this.dispose();
        }

                
        
    }//GEN-LAST:event_btnIskanjeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ZacetnaStran1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ZacetnaStran1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ZacetnaStran1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ZacetnaStran1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ZacetnaStran1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel airPanel;
    private javax.swing.JPanel background;
    private javax.swing.JRadioButton btnArrAirport;
    private javax.swing.JRadioButton btnDateDep;
    private javax.swing.JRadioButton btnDepAirport;
    private javax.swing.JButton btnIskanje;
    private javax.swing.JRadioButton btnOneway;
    private javax.swing.JRadioButton btnReturn;
    private javax.swing.JPanel contentPanel;
    private com.toedter.calendar.JDateChooser dateDep;
    private javax.swing.JPanel datePanel;
    private com.toedter.calendar.JDateChooser dateRet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSpinner noAdult;
    private javax.swing.JSpinner noChild;
    private javax.swing.JPanel noPassPanel;
    private javax.swing.JPanel onewayPanel;
    private javax.swing.JPanel returnPanel;
    private javax.swing.JLabel title;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JTextField txtAirA;
    private javax.swing.JTextField txtAirB;
    // End of variables declaration//GEN-END:variables
}

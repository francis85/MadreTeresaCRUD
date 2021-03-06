package utilidades;

import madreteresacrud.SociosABM;
import madreteresacrud.floresVida.SociosFVABM;
import madreteresacrud.floresVida.SociosFlorVida;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author francis
 */
public class BuscarAdherente extends javax.swing.JDialog {

    /**
     * Creates new form BuscarAdherente
     */
    private SociosABM s;
    public BuscarAdherente(java.awt.Frame parent, boolean modal, SociosABM s) {
        super(parent, modal);
        initComponents();
        this.s=s;
        setBusqueda();
        this.setLocationRelativeTo(null);
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
        jCBBusqueda = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Adherente:");

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(37, 37, 37)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jCBBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCBBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[] socios = jCBBusqueda.getSelectedItem().toString().split("=");
        SociosFlorVida soc = getSocio(Integer.valueOf(socios[1].toString().trim()));
        set(soc);
        this.hide();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void setBusqueda() {
        SociosFVABM socios = new SociosFVABM();
        java.util.Collection listaSocios = socios.getListaSocios();
        SociosFlorVida soc;
        for (Object socio : listaSocios) {
            soc = (SociosFlorVida) socio;
            jCBBusqueda.addItem(soc.getApellido().trim() + " " + soc.getNombre().trim() + " -> N° Adherente=" + soc.getIdSocio());
        }
        AutoCompleteDecorator.decorate(this.jCBBusqueda);
    }

    private SociosFlorVida getSocio(int nroSocio) {
        SociosFVABM socios = new SociosFVABM();
        SociosFlorVida soc = socios.getSocio(nroSocio);

        return soc;
    }
    private void set(SociosFlorVida s){
         this.s.setApellidoField(s.getApellido());
         this.s.setNombreField(s.getNombre());
         this.s.setDocumentoField(String.valueOf(s.getDni()));
         this.s.setCuilField(s.getCuil());
         this.s.setjCBSexo(s.getSexo());
         this.s.setjCBLocalididad(s.getLocalidad().toString());
         this.s.setDireccionField(s.getDireccion());
         this.s.setEmailField(s.getEmail());
         this.s.setTelefonoField(s.getTelefono());
         this.s.setCelularField(s.getCelular());
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jCBBusqueda;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

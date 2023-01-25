
package interfaz_servidor;

import recursos_compartidos.Recepcion;
import recursos_compartidos.SalaDescanso;
import recursos_compartidos.SalaObservacion;
import recursos_compartidos.SalaVacunacion;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * En esta interfaz se va actualizando la informacion de todas las
 * salas del hospital recibidas como parametro en el constructor
 * @author David
 */
public class Interfaz_1 extends javax.swing.JFrame {
    private Recepcion recepcion;
    private SalaVacunacion salaVacunacion;
    private SalaObservacion salaObservacion;
    private SalaDescanso salaDescanso;
    public Interfaz_1(Recepcion recepcion,SalaVacunacion salaVacunacion,SalaObservacion salaObservacion,SalaDescanso salaDescanso){
        initComponents();
        this.salaDescanso=salaDescanso;
        this.salaObservacion=salaObservacion;
        this.salaVacunacion=salaVacunacion;
        this.recepcion=recepcion;
    }
    public void actualizarDescanso(){
        Saladescanso.setText(salaDescanso.getIdsDescanso().toString());
        
        if(salaDescanso.getIdsDescanso().contains("A1"))
            A1_ID.setText("");
        else
            A1_ID.setText("A1");
        if(salaDescanso.getIdsDescanso().contains("A2"))
            A2_ID.setText("");
        else
            A2_ID.setText("A2");
    }
    public void actualizarVacunacion(){
        ArrayList<String> idSanitarios= salaVacunacion.getIDSanitarios();
        ArrayList<String> idPacientes= salaVacunacion.getIDPacientes();
        VacunasDisponibles.setText(salaVacunacion.getVacunasDisponibles());
        for(int i=0;i<10;i++){
            switch(i){
                case 0:
                    Puesto1.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                case 1:
                    Puesto2.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                case 2:
                    Puesto3.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                case 3:
                    Puesto4.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                case 4:
                    Puesto5.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                case 5:
                    Puesto6.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                case 6:
                    Puesto7.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                case 7:
                    Puesto8.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                case 8:
                    Puesto9.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                case 9:
                    Puesto10.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                    
            }
        }
    }
    public void actualizarObservacion(){
        ArrayList<String> idSanitarios= salaObservacion.getSanitariosAtendiendoReaccion();
        ArrayList<String> idPacientes= salaObservacion.getPacientesEnObservacion();
        
        
        for(int i=0;i<20;i++){
            switch(i){
                case 0:
                    Obs1.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                case 1:
                    Obs2.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                case 2:
                    Obs3.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                case 3:
                    Obs4.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                case 4:
                    Obs5.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                case 5:
                    Obs6.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                case 6:
                    Obs7.setText(idPacientes.get(i)+" | "+idSanitarios.get(i));
                    break;
                case 7:
                    Obs8.setText(idPacientes.get(i) + " | " + idSanitarios.get(i));
                    break;
                case 8:
                    Obs9.setText(idPacientes.get(i) + " | " + idSanitarios.get(i));
                    break;
                case 9:
                    Obs10.setText(idPacientes.get(i) + " | " + idSanitarios.get(i));
                    break;
                case 10:
                    Obs11.setText(idPacientes.get(i) + " | " + idSanitarios.get(i));
                    break;
                case 11:
                    Obs12.setText(idPacientes.get(i) + " | " + idSanitarios.get(i));
                    break;
                case 12:
                    Obs13.setText(idPacientes.get(i) + " | " + idSanitarios.get(i));
                    break;
                case 13:
                    Obs14.setText(idPacientes.get(i) + " | " + idSanitarios.get(i));
                    break;
                case 14:
                    Obs15.setText(idPacientes.get(i) + " | " + idSanitarios.get(i));
                    break;
                case 15:
                    Obs16.setText(idPacientes.get(i) + " | " + idSanitarios.get(i));
                    break;
                case 16:
                    Obs17.setText(idPacientes.get(i) + " | " + idSanitarios.get(i));
                    break;
                case 17:
                    Obs18.setText(idPacientes.get(i) + " | " + idSanitarios.get(i));
                    break;
                case 18:
                    Obs19.setText(idPacientes.get(i) + " | " + idSanitarios.get(i));
                    break;
                case 19:
                    Obs20.setText(idPacientes.get(i) + " | " + idSanitarios.get(i));
                    break;
                    
            }
        }
    }
    public void actualizarRecepcion(){
        Cola.setText(recepcion.getColaIDs().toString());
        PacienteID.setText(recepcion.getIdPacienteDentro());
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Recepcion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Cola = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        A1_ID = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        PacienteID = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SalaVacunacion = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Puesto1 = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Puesto2 = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Puesto3 = new javax.swing.JTextPane();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Puesto4 = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Puesto5 = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        Puesto6 = new javax.swing.JTextPane();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        Puesto7 = new javax.swing.JTextPane();
        jScrollPane13 = new javax.swing.JScrollPane();
        Puesto8 = new javax.swing.JTextPane();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        Puesto9 = new javax.swing.JTextPane();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        Puesto10 = new javax.swing.JTextPane();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        A2_ID = new javax.swing.JTextPane();
        jScrollPane17 = new javax.swing.JScrollPane();
        VacunasDisponibles = new javax.swing.JTextPane();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        SalaObservacion = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane38 = new javax.swing.JScrollPane();
        Obs1 = new javax.swing.JTextPane();
        jScrollPane39 = new javax.swing.JScrollPane();
        Obs2 = new javax.swing.JTextPane();
        jScrollPane40 = new javax.swing.JScrollPane();
        Obs3 = new javax.swing.JTextPane();
        jScrollPane41 = new javax.swing.JScrollPane();
        Obs4 = new javax.swing.JTextPane();
        jScrollPane42 = new javax.swing.JScrollPane();
        Obs5 = new javax.swing.JTextPane();
        jScrollPane43 = new javax.swing.JScrollPane();
        Obs6 = new javax.swing.JTextPane();
        jScrollPane44 = new javax.swing.JScrollPane();
        Obs7 = new javax.swing.JTextPane();
        jScrollPane45 = new javax.swing.JScrollPane();
        Obs8 = new javax.swing.JTextPane();
        jScrollPane46 = new javax.swing.JScrollPane();
        Obs9 = new javax.swing.JTextPane();
        jScrollPane47 = new javax.swing.JScrollPane();
        Obs10 = new javax.swing.JTextPane();
        jScrollPane48 = new javax.swing.JScrollPane();
        Obs11 = new javax.swing.JTextPane();
        jScrollPane49 = new javax.swing.JScrollPane();
        Obs12 = new javax.swing.JTextPane();
        jScrollPane50 = new javax.swing.JScrollPane();
        Obs13 = new javax.swing.JTextPane();
        jScrollPane51 = new javax.swing.JScrollPane();
        Obs14 = new javax.swing.JTextPane();
        jScrollPane52 = new javax.swing.JScrollPane();
        Obs15 = new javax.swing.JTextPane();
        jScrollPane53 = new javax.swing.JScrollPane();
        Obs16 = new javax.swing.JTextPane();
        jScrollPane54 = new javax.swing.JScrollPane();
        Obs17 = new javax.swing.JTextPane();
        jScrollPane55 = new javax.swing.JScrollPane();
        Obs20 = new javax.swing.JTextPane();
        jScrollPane56 = new javax.swing.JScrollPane();
        Obs18 = new javax.swing.JTextPane();
        jScrollPane57 = new javax.swing.JScrollPane();
        Obs19 = new javax.swing.JTextPane();
        jLabel39 = new javax.swing.JLabel();
        SalaDescanso = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Saladescanso = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Recepcion.setBackground(new java.awt.Color(220, 220, 220));
        Recepcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("RECEPCION");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cola de espera");

        Cola.setEditable(false);
        Cola.setColumns(20);
        Cola.setRows(5);
        jScrollPane1.setViewportView(Cola);

        A1_ID.setEditable(false);
        jScrollPane2.setViewportView(A1_ID);

        PacienteID.setEditable(false);
        jScrollPane3.setViewportView(PacienteID);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Paciente");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Auxiliar");

        javax.swing.GroupLayout RecepcionLayout = new javax.swing.GroupLayout(Recepcion);
        Recepcion.setLayout(RecepcionLayout);
        RecepcionLayout.setHorizontalGroup(
            RecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RecepcionLayout.createSequentialGroup()
                .addGroup(RecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RecepcionLayout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addGroup(RecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(RecepcionLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RecepcionLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel3)
                        .addGap(108, 108, 108)
                        .addGroup(RecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(RecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RecepcionLayout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(461, Short.MAX_VALUE)))
        );
        RecepcionLayout.setVerticalGroup(
            RecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RecepcionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(RecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(2, 2, 2)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(RecepcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RecepcionLayout.createSequentialGroup()
                    .addContainerGap(191, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33)))
        );

        SalaVacunacion.setBackground(new java.awt.Color(220, 220, 220));
        SalaVacunacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SalaVacunacion.setPreferredSize(new java.awt.Dimension(1600, 320));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Puesto 1");

        Puesto1.setEditable(false);
        jScrollPane6.setViewportView(Puesto1);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Puesto 2");

        Puesto2.setEditable(false);
        jScrollPane7.setViewportView(Puesto2);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Puesto 3");

        Puesto3.setEditable(false);
        jScrollPane8.setViewportView(Puesto3);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Puesto 4");

        Puesto4.setEditable(false);
        jScrollPane9.setViewportView(Puesto4);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Puesto 5");

        Puesto5.setEditable(false);
        jScrollPane10.setViewportView(Puesto5);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Puesto 6");

        Puesto6.setEditable(false);
        jScrollPane11.setViewportView(Puesto6);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Puesto 7");

        Puesto7.setEditable(false);
        jScrollPane12.setViewportView(Puesto7);

        Puesto8.setEditable(false);
        jScrollPane13.setViewportView(Puesto8);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Puesto 8");

        Puesto9.setEditable(false);
        jScrollPane14.setViewportView(Puesto9);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Puesto 9");

        Puesto10.setEditable(false);
        jScrollPane15.setViewportView(Puesto10);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Puesto 10");

        A2_ID.setEditable(false);
        jScrollPane16.setViewportView(A2_ID);

        VacunasDisponibles.setEditable(false);
        jScrollPane17.setViewportView(VacunasDisponibles);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Auxiliar");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Vacunas disponibles");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel18.setText("SALA DE VACUNACION");

        javax.swing.GroupLayout SalaVacunacionLayout = new javax.swing.GroupLayout(SalaVacunacion);
        SalaVacunacion.setLayout(SalaVacunacionLayout);
        SalaVacunacionLayout.setHorizontalGroup(
            SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalaVacunacionLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SalaVacunacionLayout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SalaVacunacionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)))
                        .addGap(251, 251, 251))
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SalaVacunacionLayout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addComponent(jScrollPane17)
                                .addGap(251, 251, 251))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SalaVacunacionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addGap(231, 231, 231))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SalaVacunacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(453, 453, 453))
        );
        SalaVacunacionLayout.setVerticalGroup(
            SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalaVacunacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(33, 33, 33)
                .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SalaVacunacionLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SalaVacunacionLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SalaVacunacionLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SalaVacunacionLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SalaVacunacionLayout.createSequentialGroup()
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        SalaObservacion.setBackground(new java.awt.Color(220, 220, 220));
        SalaObservacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Puesto 1");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Puesto 2");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Puesto 3");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Puesto 4");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Puesto 5");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Puesto 6");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Puesto 7");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Puesto 8");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Puesto 9");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Puesto 10");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Puesto 11");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Puesto 12");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Puesto 13");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Puesto 14");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Puesto 15");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Puesto 16");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Puesto 17");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Puesto 18");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Puesto 19");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Puesto 20");

        Obs1.setEditable(false);
        jScrollPane38.setViewportView(Obs1);

        Obs2.setEditable(false);
        jScrollPane39.setViewportView(Obs2);

        Obs3.setEditable(false);
        jScrollPane40.setViewportView(Obs3);

        Obs4.setEditable(false);
        jScrollPane41.setViewportView(Obs4);

        Obs5.setEditable(false);
        jScrollPane42.setViewportView(Obs5);

        Obs6.setEditable(false);
        jScrollPane43.setViewportView(Obs6);

        Obs7.setEditable(false);
        jScrollPane44.setViewportView(Obs7);

        Obs8.setEditable(false);
        jScrollPane45.setViewportView(Obs8);

        Obs9.setEditable(false);
        jScrollPane46.setViewportView(Obs9);

        Obs10.setEditable(false);
        jScrollPane47.setViewportView(Obs10);

        Obs11.setEditable(false);
        jScrollPane48.setViewportView(Obs11);

        Obs12.setEditable(false);
        jScrollPane49.setViewportView(Obs12);

        Obs13.setEditable(false);
        jScrollPane50.setViewportView(Obs13);

        Obs14.setEditable(false);
        jScrollPane51.setViewportView(Obs14);

        Obs15.setEditable(false);
        jScrollPane52.setViewportView(Obs15);

        Obs16.setEditable(false);
        jScrollPane53.setViewportView(Obs16);

        Obs17.setEditable(false);
        jScrollPane54.setViewportView(Obs17);

        Obs20.setEditable(false);
        jScrollPane55.setViewportView(Obs20);

        Obs18.setEditable(false);
        jScrollPane56.setViewportView(Obs18);

        Obs19.setEditable(false);
        jScrollPane57.setViewportView(Obs19);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel39.setText("SALA DE OBSERVACION");

        javax.swing.GroupLayout SalaObservacionLayout = new javax.swing.GroupLayout(SalaObservacion);
        SalaObservacion.setLayout(SalaObservacionLayout);
        SalaObservacionLayout.setHorizontalGroup(
            SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalaObservacionLayout.createSequentialGroup()
                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SalaObservacionLayout.createSequentialGroup()
                        .addGap(950, 950, 950)
                        .addComponent(jScrollPane57, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SalaObservacionLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SalaObservacionLayout.createSequentialGroup()
                                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane48, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane38, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel29))
                                .addGap(32, 32, 32)
                                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SalaObservacionLayout.createSequentialGroup()
                                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane39, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane49, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane40, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane50, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(SalaObservacionLayout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel31)))
                                .addGap(32, 32, 32)
                                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SalaObservacionLayout.createSequentialGroup()
                                        .addComponent(jLabel32)
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel33)
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel34)
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel35)
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel36)
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel37)
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel38))
                                    .addGroup(SalaObservacionLayout.createSequentialGroup()
                                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane41, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane51, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane42, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane52, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane43, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane53, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane44, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane54, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(SalaObservacionLayout.createSequentialGroup()
                                                .addComponent(jScrollPane45, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32)
                                                .addComponent(jScrollPane46, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32)
                                                .addComponent(jScrollPane47, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(SalaObservacionLayout.createSequentialGroup()
                                                .addComponent(jScrollPane56, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane55, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1))))))
                            .addGroup(SalaObservacionLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel20)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel21)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel22)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel23)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel24)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel25)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel26)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel27)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel28)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SalaObservacionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addGap(493, 493, 493))
        );
        SalaObservacionLayout.setVerticalGroup(
            SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalaObservacionLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        SalaDescanso.setBackground(new java.awt.Color(220, 220, 220));
        SalaDescanso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("SALA DE DESCANSO");

        Saladescanso.setEditable(false);
        Saladescanso.setColumns(20);
        Saladescanso.setRows(5);
        jScrollPane4.setViewportView(Saladescanso);

        javax.swing.GroupLayout SalaDescansoLayout = new javax.swing.GroupLayout(SalaDescanso);
        SalaDescanso.setLayout(SalaDescansoLayout);
        SalaDescansoLayout.setHorizontalGroup(
            SalaDescansoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalaDescansoLayout.createSequentialGroup()
                .addGroup(SalaDescansoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SalaDescansoLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel5))
                    .addGroup(SalaDescansoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SalaDescansoLayout.setVerticalGroup(
            SalaDescansoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalaDescansoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Recepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SalaDescanso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(SalaObservacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SalaVacunacion, javax.swing.GroupLayout.DEFAULT_SIZE, 1172, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Recepcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SalaDescanso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addComponent(SalaVacunacion, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SalaObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane A1_ID;
    private javax.swing.JTextPane A2_ID;
    private javax.swing.JTextArea Cola;
    private javax.swing.JTextPane Obs1;
    private javax.swing.JTextPane Obs10;
    private javax.swing.JTextPane Obs11;
    private javax.swing.JTextPane Obs12;
    private javax.swing.JTextPane Obs13;
    private javax.swing.JTextPane Obs14;
    private javax.swing.JTextPane Obs15;
    private javax.swing.JTextPane Obs16;
    private javax.swing.JTextPane Obs17;
    private javax.swing.JTextPane Obs18;
    private javax.swing.JTextPane Obs19;
    private javax.swing.JTextPane Obs2;
    private javax.swing.JTextPane Obs20;
    private javax.swing.JTextPane Obs3;
    private javax.swing.JTextPane Obs4;
    private javax.swing.JTextPane Obs5;
    private javax.swing.JTextPane Obs6;
    private javax.swing.JTextPane Obs7;
    private javax.swing.JTextPane Obs8;
    private javax.swing.JTextPane Obs9;
    private javax.swing.JTextPane PacienteID;
    private javax.swing.JTextPane Puesto1;
    private javax.swing.JTextPane Puesto10;
    private javax.swing.JTextPane Puesto2;
    private javax.swing.JTextPane Puesto3;
    private javax.swing.JTextPane Puesto4;
    private javax.swing.JTextPane Puesto5;
    private javax.swing.JTextPane Puesto6;
    private javax.swing.JTextPane Puesto7;
    private javax.swing.JTextPane Puesto8;
    private javax.swing.JTextPane Puesto9;
    private javax.swing.JPanel Recepcion;
    private javax.swing.JPanel SalaDescanso;
    private javax.swing.JPanel SalaObservacion;
    private javax.swing.JPanel SalaVacunacion;
    private javax.swing.JTextArea Saladescanso;
    private javax.swing.JTextPane VacunasDisponibles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane40;
    private javax.swing.JScrollPane jScrollPane41;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane43;
    private javax.swing.JScrollPane jScrollPane44;
    private javax.swing.JScrollPane jScrollPane45;
    private javax.swing.JScrollPane jScrollPane46;
    private javax.swing.JScrollPane jScrollPane47;
    private javax.swing.JScrollPane jScrollPane48;
    private javax.swing.JScrollPane jScrollPane49;
    private javax.swing.JScrollPane jScrollPane50;
    private javax.swing.JScrollPane jScrollPane51;
    private javax.swing.JScrollPane jScrollPane52;
    private javax.swing.JScrollPane jScrollPane53;
    private javax.swing.JScrollPane jScrollPane54;
    private javax.swing.JScrollPane jScrollPane55;
    private javax.swing.JScrollPane jScrollPane56;
    private javax.swing.JScrollPane jScrollPane57;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
}

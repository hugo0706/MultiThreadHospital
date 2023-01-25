
package mvc_cliente;

import mvc_cliente.I_Interfaz;
import mvc_cliente.Controlador;
import java.util.ArrayList;

/**
 * Esta clase incluye métodos para actualizar la interfaz y para habilitar y
 * deshabilitar los botones
 * los puestos
 * @author David
 */
public class Interfaz_2 extends javax.swing.JFrame implements I_Interfaz  {
    
    private Controlador controlador;
    
    public Interfaz_2() {
        initComponents();
    }
    
    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }
    
    @Override
    public void hacerVisible() {
        this.setVisible(true);
    }

    @Override
    public void actualizar(ArrayList<ArrayList<Object>> informacionHospital) {
        
        
        //RECEPCION
        String pacienteEnRecepcion = (String)informacionHospital.get(0).get(0);
        PacienteID.setText(pacienteEnRecepcion);
        //PacienteID.setText(pacienteEnRecepcion);
        ArrayList<Object> colaRecepcion = informacionHospital.get(1);
        Cola.setText(colaRecepcion.toString());
  
        
        
        //SALA VACUNACION
        String vacunasDisponibles= (String)informacionHospital.get(2).get(0);
        ArrayList<Object> pacientesVacunacion = informacionHospital.get(3);
        ArrayList<Object> sanitariosVacunacion = informacionHospital.get(4);
        VacunasDisponibles.setText(vacunasDisponibles) ;
 
        for(int i=0;i<10;i++){
            switch(i){
                case 0:
                    Puesto1.setText(pacientesVacunacion.get(i)+" | "+sanitariosVacunacion.get(i));
                    break;
                case 1:
                    Puesto2.setText(pacientesVacunacion.get(i)+" | "+sanitariosVacunacion.get(i));
                    break;
                case 2:
                    Puesto3.setText(pacientesVacunacion.get(i)+" | "+sanitariosVacunacion.get(i));
                    break;
                case 3:
                    Puesto4.setText(pacientesVacunacion.get(i)+" | "+sanitariosVacunacion.get(i));
                    break;
                case 4:
                    Puesto5.setText(pacientesVacunacion.get(i)+" | "+sanitariosVacunacion.get(i));
                    break;
                case 5:
                    Puesto6.setText(pacientesVacunacion.get(i)+" | "+sanitariosVacunacion.get(i));
                    break;
                case 6:
                    Puesto7.setText(pacientesVacunacion.get(i)+" | "+sanitariosVacunacion.get(i));
                    break;
                case 7:
                    Puesto8.setText(pacientesVacunacion.get(i)+" | "+sanitariosVacunacion.get(i));
                    break;
                case 8:
                    Puesto9.setText(pacientesVacunacion.get(i)+" | "+sanitariosVacunacion.get(i));
                    break;
                case 9:
                    Puesto10.setText(pacientesVacunacion.get(i)+" | "+sanitariosVacunacion.get(i));
                    break;
                    
            }
        }
                
        //Paceintes en puestos de observacion
        ArrayList<Object> idPacientes = informacionHospital.get(5);
        //Sanitarios en puestos de observacion
        ArrayList<Object> idSanitarios = informacionHospital.get(6);
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
            
        //Personas en sala de descanso
        ArrayList<Object> personasDescansando = informacionHospital.get(7);
        Saladescanso.setText(personasDescansando.toString());
        if(personasDescansando.contains("A1"))
            A1_ID.setText("");
        else
            A1_ID.setText("A1");
        if(personasDescansando.contains("A2"))
            A2_ID.setText("");
        else
            A2_ID.setText("A2");
        
    }
    }
    
    public void inicializarEventos() {
        Cerrar1.setActionCommand("CERRAR1");
        Cerrar1.addActionListener(controlador);

        Cerrar2.setActionCommand("CERRAR2");
        Cerrar2.addActionListener(controlador);

        Cerrar3.setActionCommand("CERRAR3");
        Cerrar3.addActionListener(controlador);

        Cerrar4.setActionCommand("CERRAR4");
        Cerrar4.addActionListener(controlador);

        Cerrar5.setActionCommand("CERRAR5");
        Cerrar5.addActionListener(controlador);

        Cerrar6.setActionCommand("CERRAR6");
        Cerrar6.addActionListener(controlador);

        Cerrar7.setActionCommand("CERRAR7");
        Cerrar7.addActionListener(controlador);

        Cerrar8.setActionCommand("CERRAR8");
        Cerrar8.addActionListener(controlador);

        Cerrar9.setActionCommand("CERRAR9");
        Cerrar9.addActionListener(controlador);

        Cerrar10.setActionCommand("CERRAR10");
        Cerrar10.addActionListener(controlador);

    }
    
    @Override
    public void deshabilitarBoton(String e) {
        int boton = Integer.parseInt(e.substring(6));
        
        switch(boton) {
            case 1:
                Cerrar1.setEnabled(false);
                break;
            case 2:
                Cerrar2.setEnabled(false);
                break;
            case 3:
                Cerrar3.setEnabled(false);
                break;
            case 4:
                Cerrar4.setEnabled(false);
                break;
            case 5:
                Cerrar5.setEnabled(false);
                break;
            case 6:
                Cerrar6.setEnabled(false);
                break;
            case 7:
                Cerrar7.setEnabled(false);
                break;
            case 8:
                Cerrar8.setEnabled(false);
                break;
            case 9:
                Cerrar9.setEnabled(false);
                break;
            case 10:
                Cerrar10.setEnabled(false);
                break;                             
        }
    }
    
    @Override
    public void habilitarBoton(Integer boton) {
        switch(boton) {
            case 1:
                Cerrar1.setEnabled(true);
                break;
            case 2:
                Cerrar2.setEnabled(true);
                break;
            case 3:
                Cerrar3.setEnabled(true);
                break;
            case 4:
                Cerrar4.setEnabled(true);
                break;
            case 5:
                Cerrar5.setEnabled(true);
                break;
            case 6:
                Cerrar6.setEnabled(true);
                break;
            case 7:
                Cerrar7.setEnabled(true);
                break;
            case 8:
                Cerrar8.setEnabled(true);
                break;
            case 9:
                Cerrar9.setEnabled(true);
                break;
            case 10:
                Cerrar10.setEnabled(true);
                break;                             
        }
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
        Cerrar1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Puesto2 = new javax.swing.JTextPane();
        Cerrar2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Puesto3 = new javax.swing.JTextPane();
        Cerrar3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Puesto4 = new javax.swing.JTextPane();
        Cerrar4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Puesto5 = new javax.swing.JTextPane();
        Cerrar5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        Puesto6 = new javax.swing.JTextPane();
        Cerrar6 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        Puesto7 = new javax.swing.JTextPane();
        Cerrar7 = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        Puesto8 = new javax.swing.JTextPane();
        Cerrar8 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        Puesto9 = new javax.swing.JTextPane();
        Cerrar9 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        Puesto10 = new javax.swing.JTextPane();
        jLabel15 = new javax.swing.JLabel();
        Cerrar10 = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        A2_ID = new javax.swing.JTextPane();
        jScrollPane17 = new javax.swing.JScrollPane();
        VacunasDisponibles = new javax.swing.JTextPane();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        SalaObservacion = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        Obs11 = new javax.swing.JTextPane();
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
        jScrollPane19 = new javax.swing.JScrollPane();
        Obs1 = new javax.swing.JTextPane();
        jScrollPane20 = new javax.swing.JScrollPane();
        Obs2 = new javax.swing.JTextPane();
        jScrollPane21 = new javax.swing.JScrollPane();
        Obs3 = new javax.swing.JTextPane();
        jScrollPane22 = new javax.swing.JScrollPane();
        Obs4 = new javax.swing.JTextPane();
        jScrollPane23 = new javax.swing.JScrollPane();
        Obs5 = new javax.swing.JTextPane();
        jScrollPane24 = new javax.swing.JScrollPane();
        Obs6 = new javax.swing.JTextPane();
        jScrollPane25 = new javax.swing.JScrollPane();
        Obs7 = new javax.swing.JTextPane();
        jScrollPane26 = new javax.swing.JScrollPane();
        Obs8 = new javax.swing.JTextPane();
        jScrollPane27 = new javax.swing.JScrollPane();
        Obs9 = new javax.swing.JTextPane();
        jScrollPane28 = new javax.swing.JScrollPane();
        Obs10 = new javax.swing.JTextPane();
        jScrollPane29 = new javax.swing.JScrollPane();
        Obs12 = new javax.swing.JTextPane();
        jScrollPane30 = new javax.swing.JScrollPane();
        Obs13 = new javax.swing.JTextPane();
        jScrollPane31 = new javax.swing.JScrollPane();
        Obs14 = new javax.swing.JTextPane();
        jScrollPane32 = new javax.swing.JScrollPane();
        Obs15 = new javax.swing.JTextPane();
        jScrollPane33 = new javax.swing.JScrollPane();
        Obs16 = new javax.swing.JTextPane();
        jScrollPane34 = new javax.swing.JScrollPane();
        Obs17 = new javax.swing.JTextPane();
        jScrollPane35 = new javax.swing.JScrollPane();
        Obs18 = new javax.swing.JTextPane();
        jScrollPane36 = new javax.swing.JScrollPane();
        Obs19 = new javax.swing.JTextPane();
        jScrollPane37 = new javax.swing.JScrollPane();
        Obs20 = new javax.swing.JTextPane();
        jLabel39 = new javax.swing.JLabel();
        SalaDescanso = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Saladescanso = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 900));

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

        Cerrar1.setText("Cerrar");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Puesto 2");

        Puesto2.setEditable(false);
        jScrollPane7.setViewportView(Puesto2);

        Cerrar2.setText("Cerrar");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Puesto 3");

        Puesto3.setEditable(false);
        jScrollPane8.setViewportView(Puesto3);

        Cerrar3.setText("Cerrar");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Puesto 4");

        Puesto4.setEditable(false);
        jScrollPane9.setViewportView(Puesto4);

        Cerrar4.setText("Cerrar");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Puesto 5");

        Puesto5.setEditable(false);
        jScrollPane10.setViewportView(Puesto5);

        Cerrar5.setText("Cerrar");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Puesto 6");

        Puesto6.setEditable(false);
        jScrollPane11.setViewportView(Puesto6);

        Cerrar6.setText("Cerrar");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Puesto 7");

        Puesto7.setEditable(false);
        jScrollPane12.setViewportView(Puesto7);

        Cerrar7.setText("Cerrar");

        Puesto8.setEditable(false);
        jScrollPane13.setViewportView(Puesto8);

        Cerrar8.setText("Cerrar");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Puesto 8");

        Puesto9.setEditable(false);
        jScrollPane14.setViewportView(Puesto9);

        Cerrar9.setText("Cerrar");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Puesto 9");

        Puesto10.setEditable(false);
        jScrollPane15.setViewportView(Puesto10);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Puesto 10");

        Cerrar10.setText("Cerrar");

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
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane6)
                            .addComponent(Cerrar1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane7)
                            .addComponent(Cerrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane8)
                            .addComponent(Cerrar3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane9)
                            .addComponent(Cerrar4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane10)
                            .addComponent(Cerrar5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SalaVacunacionLayout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SalaVacunacionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)))
                        .addGap(251, 251, 251))
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane11)
                            .addComponent(Cerrar6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane12)
                            .addComponent(Cerrar7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13)
                            .addComponent(jScrollPane13)
                            .addComponent(Cerrar8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14)
                            .addComponent(jScrollPane14)
                            .addComponent(Cerrar9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15)
                            .addComponent(jScrollPane15)
                            .addComponent(Cerrar10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cerrar5))
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cerrar4))
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cerrar3))
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cerrar2))
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cerrar1)))
                .addGap(18, 18, 18)
                .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cerrar6))
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cerrar7))
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cerrar8))
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cerrar9))
                    .addGroup(SalaVacunacionLayout.createSequentialGroup()
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SalaVacunacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cerrar10)))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        SalaObservacion.setBackground(new java.awt.Color(220, 220, 220));
        SalaObservacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Obs11.setEditable(false);
        jScrollPane18.setViewportView(Obs11);

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
        jScrollPane19.setViewportView(Obs1);

        Obs2.setEditable(false);
        jScrollPane20.setViewportView(Obs2);

        Obs3.setEditable(false);
        jScrollPane21.setViewportView(Obs3);

        Obs4.setEditable(false);
        jScrollPane22.setViewportView(Obs4);

        Obs5.setEditable(false);
        jScrollPane23.setViewportView(Obs5);

        Obs6.setEditable(false);
        jScrollPane24.setViewportView(Obs6);

        Obs7.setEditable(false);
        jScrollPane25.setViewportView(Obs7);

        Obs8.setEditable(false);
        jScrollPane26.setViewportView(Obs8);

        Obs9.setEditable(false);
        jScrollPane27.setViewportView(Obs9);

        Obs10.setEditable(false);
        jScrollPane28.setViewportView(Obs10);

        Obs12.setEditable(false);
        jScrollPane29.setViewportView(Obs12);

        Obs13.setEditable(false);
        jScrollPane30.setViewportView(Obs13);

        Obs14.setEditable(false);
        jScrollPane31.setViewportView(Obs14);

        Obs15.setEditable(false);
        jScrollPane32.setViewportView(Obs15);

        Obs16.setEditable(false);
        jScrollPane33.setViewportView(Obs16);

        Obs17.setEditable(false);
        jScrollPane34.setViewportView(Obs17);

        Obs18.setEditable(false);
        jScrollPane35.setViewportView(Obs18);

        Obs19.setEditable(false);
        jScrollPane36.setViewportView(Obs19);

        Obs20.setEditable(false);
        jScrollPane37.setViewportView(Obs20);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel39.setText("SALA DE OBSERVACION");

        javax.swing.GroupLayout SalaObservacionLayout = new javax.swing.GroupLayout(SalaObservacion);
        SalaObservacion.setLayout(SalaObservacionLayout);
        SalaObservacionLayout.setHorizontalGroup(
            SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalaObservacionLayout.createSequentialGroup()
                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SalaObservacionLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(SalaObservacionLayout.createSequentialGroup()
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SalaObservacionLayout.createSequentialGroup()
                                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SalaObservacionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SalaObservacionLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane35, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane36, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(SalaObservacionLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(SalaObservacionLayout.createSequentialGroup()
                                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel29))
                                .addGap(60, 60, 60)
                                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel30))
                                .addGap(60, 60, 60)
                                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel31))
                                .addGap(60, 60, 60)
                                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel32))
                                .addGap(60, 60, 60)
                                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel33))
                                .addGap(60, 60, 60)
                                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel34)))
                            .addGroup(SalaObservacionLayout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addGap(7, 7, 7)))
                        .addGap(60, 60, 60)
                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel35))
                        .addGap(60, 60, 60)
                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel36))
                        .addGap(60, 60, 60)
                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)))
                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SalaObservacionLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel28))))
                .addGap(22, 22, 22))
        );
        SalaObservacionLayout.setVerticalGroup(
            SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalaObservacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addGap(13, 13, 13)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(jLabel30))
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
                    .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SalaObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(SalaVacunacion, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE))
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
    private javax.swing.JButton Cerrar1;
    private javax.swing.JButton Cerrar10;
    private javax.swing.JButton Cerrar2;
    private javax.swing.JButton Cerrar3;
    private javax.swing.JButton Cerrar4;
    private javax.swing.JButton Cerrar5;
    private javax.swing.JButton Cerrar6;
    private javax.swing.JButton Cerrar7;
    private javax.swing.JButton Cerrar8;
    private javax.swing.JButton Cerrar9;
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
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables




}

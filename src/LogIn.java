/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LogIn.java
 *
 * Created on Aug 12, 2010, 10:10:41 PM
 */

/**
 *
 * @author megha
 */
import java.sql.*;
public class LogIn extends javax.swing.JFrame {

    /** Creates new form LogIn */
    public LogIn() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        loginBTN = new javax.swing.JButton();
        regLBL = new javax.swing.JLabel();
        InvalidLBL = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log In");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36));
        jLabel2.setForeground(new java.awt.Color(153, 0, 153));
        jLabel2.setText("WELCOME TO COOL QUIZ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));
        jLabel2.getAccessibleContext().setAccessibleParent(this);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel3.setForeground(new java.awt.Color(153, 0, 153));
        jLabel3.setText("LOG IN TO CONTINUE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 160, -1));
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 160, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Log In ID");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        loginBTN.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        loginBTN.setFont(new java.awt.Font("Tahoma", 1, 16));
        loginBTN.setForeground(new java.awt.Color(102, 0, 102));
        loginBTN.setText("Log In");
        loginBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 255), new java.awt.Color(255, 204, 255), new java.awt.Color(153, 0, 153), new java.awt.Color(153, 0, 153)));
        loginBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBTNActionPerformed(evt);
            }
        });
        getContentPane().add(loginBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 90, 40));

        regLBL.setFont(new java.awt.Font("Tahoma", 1, 14));
        regLBL.setForeground(new java.awt.Color(153, 0, 153));
        regLBL.setText("Not Yet a Member.. Click here to register");
        regLBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regLBLMouseClicked(evt);
            }
        });
        getContentPane().add(regLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 290, -1));

        InvalidLBL.setFont(new java.awt.Font("Tahoma", 1, 12));
        InvalidLBL.setForeground(new java.awt.Color(153, 0, 153));
        getContentPane().add(InvalidLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 180, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBTNActionPerformed
        InvalidLBL.setText("");
        String PWord = new String(Password.getPassword());
        String Id = ID.getText();
        String str = null;
        Statement stmt=null;
        ResultSet rs = null;
        try   {
          /*  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String database ="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=ELearning.mdb;";
            Connection conn = DriverManager.getConnection(database, "", ""); */
            Class.forName("java.sql.Driver");
            String database = "jdbc:mysql://localhost:3306/quizdb";
            Connection conn = DriverManager.getConnection(database, "root", "mukesh");
            stmt = conn.createStatement();

            stmt = conn.createStatement();
            String sql = "select * from LogIn where ID = '" + Id + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            str = rs.getString("Password");
            if(str.equals(PWord))
            {
                 Menu m = new Menu(Id);
                  m.setVisible(true);
                 this.setVisible(false);
            }
            else
            {
                 InvalidLBL.setText("Incorrect ID or Password");
            }
        } catch (Exception e) { InvalidLBL.setText("Incorrect ID or Password");}
}//GEN-LAST:event_loginBTNActionPerformed

    private void regLBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regLBLMouseClicked
        Register r = new Register();
        r.setVisible(true);
        this.setVisible(false);
}//GEN-LAST:event_regLBLMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JLabel InvalidLBL;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton loginBTN;
    private javax.swing.JLabel regLBL;
    // End of variables declaration//GEN-END:variables

}

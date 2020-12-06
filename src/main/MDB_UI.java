/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ksharm38
 */
public class MDB_UI extends javax.swing.JFrame {
    String movieSelectionBasis ="";
    String searchType = "";
    public  JTable table;
    OntologyTest ontology = new OntologyTest();
    /**
     * Creates new form MDB_UI
     */
    public MDB_UI() {
        initComponents();
        jButton1.setEnabled(true);
        jTextField1.setEnabled(false);
       // jTextField1.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
       

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Movie Management System");

        jLabel2.setText("Select Category ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Genre", "Action", "Adventure", "Animation", "Comedy", "Horror", "Crime", "Drama", "Biography", "Western", "Fantasy", "Thriller" }));
        jComboBox1.setName("cb_genre"); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
                movieSelectionBasis = jComboBox1.getSelectedItem().toString();;
                searchType = "Genre";
                if(!movieSelectionBasis.contains("Select") ) {
               
                //JOptionPane.showMessageDialog(rootPane, movieSelectionBasis);
                List<Movie> movieList = ontology.searchByGenre(movieSelectionBasis);
            	if(movieList.size() == 0) JOptionPane.showMessageDialog(rootPane, "No search results for selected criteria");
            	else {
            		System.out.println(movieList.size());
                	//Object[] objects = movieList.toArray(); 
            		displayTable(movieList);
            	}
                }
            	
                
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Country", "USA", "India", "Korea", "China", "France", "Germany", "Italy" }));
        jComboBox2.setName("cb_country"); // NOI18N
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
                
                movieSelectionBasis = jComboBox2.getSelectedItem().toString();
                
                if(!movieSelectionBasis.contains("Select") )
                		
                {searchType = "Country";
                List<Movie> movieList = ontology.searchByCountry(movieSelectionBasis);
                if(movieList.size() == 0) JOptionPane.showMessageDialog(rootPane, "No search results for selected criteria");
            	else {
            		displayTable(movieList);
                	

                	 
            	}
            	}
                
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Year", "1920-1925", "1926-1930", "1931-1935", "1936-1940", "2011-2015", "2016-2020" }));
        jComboBox3.setName("cb_year"); // NOI18N
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
                movieSelectionBasis = jComboBox3.getSelectedItem().toString();
                if(!movieSelectionBasis.contains("Select") ) {
                searchType = "Year";
                
                List<Movie> movieList = ontology.searchByYear(movieSelectionBasis);
                if(movieList.size() == 0) JOptionPane.showMessageDialog(rootPane, "No search results for selected criteria");
            	else {
            		displayTable(movieList);
                 	
            	}
            }
            }
        });

        jLabel3.setText("Search ");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Movie Details Title");
        jRadioButton1.setName("rb_title"); // NOI18N
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
                
                searchType = "Title";
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Movie Details Actor");
        jRadioButton2.setName("rb_actor"); // NOI18N
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
                searchType = "actor";
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Movie Details Director");
        jRadioButton3.setName("rb_director"); // NOI18N
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
                searchType = "director";
            }
        });
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Actor Details By Actor Name");
        jRadioButton4.setName("rb_ActorDetails"); // NOI18N
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
                searchType = "ActorDetails";
            }
        });

        jButton1.setText("Search");
        jButton1.setName("btn_search"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
                List<Movie> movieList;
                switch( searchType) {
               
                case "Title":
                	
                	movieSelectionBasis = jTextField1.getText().toString();
                	movieList= ontology.searchByTitle(movieSelectionBasis);
                	if(movieList.size() == 0) JOptionPane.showMessageDialog(rootPane, "No search results for selected criteria");
                	else {
                		displayTable(movieList);
                	}
                	break;
                case "actor":
                	movieSelectionBasis = jTextField1.getText().toString();
                	movieList= ontology.searchByActor(movieSelectionBasis);
                	if(movieList.size() == 0) JOptionPane.showMessageDialog(rootPane, "No search results for selected criteria");
                	else {
                		displayTable(movieList);
                     	
                	}
                	break;
                case "director":
                	movieSelectionBasis = jTextField1.getText().toString();
                	movieList= ontology.searchByDirector(movieSelectionBasis);
                	if(movieList.size() == 0) JOptionPane.showMessageDialog(rootPane, "No search results for selected criteria");
                	else {
                		displayTable(movieList);
                     	
                	}
                	break;
                case "ActorDetails":
                	movieSelectionBasis = jTextField1.getText().toString();
                	String details = ontology.searchActorDetails(movieSelectionBasis);
                	
                	//String _details = "Full Name : " + details[0] + "DOB : " + details[1] + "Bio : " + details[2];
                	 
                	
                	JOptionPane.showMessageDialog(rootPane, details);
                	
                	break;
                
                }
                
              
                
                
                
               
            }
        });

        jButton2.setText("Reset");
        jButton2.setName("btn_reset"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Exit");
        jButton3.setName("btn_exit"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*Note: Select only one category at a time*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jRadioButton1)
                                    .addGap(30, 30, 30)
                                    .addComponent(jRadioButton2)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRadioButton3)
                                    .addGap(5, 5, 5)
                                    .addComponent(jRadioButton4)))
                            
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(100, 100, 100)
                                        .addComponent(jButton2)
                                        .addGap(83, 83, 83)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel4)))))))
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(29, 29, 29)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(162, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jTextField1.setEnabled(true);
       jButton1.setEnabled(true);
       movieSelectionBasis= jRadioButton1.getText();
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jButton1.setEnabled(true);
         jTextField1.setEnabled(true);
          movieSelectionBasis= jRadioButton1.getText();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        jTextField1.setText("");
        jTextField1.setEnabled(false);
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jButton1.setEnabled(false);
        movieSelectionBasis="";
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	try{
    		String txtSearchBy =  jTextField1.getText();
//    		
    		
}   
catch(Exception ex)
{
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
         jButton1.setEnabled(true);
          jTextField1.setEnabled(true);
           movieSelectionBasis= jRadioButton1.getText();
    }//GEN-LAST:event_jRadioButton3ActionPerformed
    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        jButton1.setEnabled(true);
         jTextField1.setEnabled(true);
          movieSelectionBasis= jRadioButton1.getText();
   }
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
            java.util.logging.Logger.getLogger(MDB_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDB_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDB_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDB_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDB_UI().setVisible(true);
            }
        });
    }

    
    public void displayTable(JTable _table) {
    	 JFrame tframe = new JFrame();
    	 
         
         
         tframe.add(_table);
         tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         tframe.setTitle("Results for the query");
         tframe.setSize(1000, 1000); 
         tframe.setLayout(null); 
         tframe.setVisible(true); 
         tframe.pack();
         
    }
    public void displayTable(List<Movie> movieList) {
    	String col[] = {"ID","MOVIE TITLE","YEAR", "ACTOR", "DIRECTOR", "GENRE", "COUNTRY", "LANGUAGE", "RATING"};

   	 String[][] data = new String [movieList.size()][9];
   	 
    	for(int i =0 ;i < movieList.size(); i++) {
    		Movie movie = movieList.get(i); 
   		
    		String[] objs = {movie.id, movie.title, movie.year, movie.actor, movie.director, movie.genre, movie.country, movie.language,  movie.avgRating};

    		
    		
    		
    		data[i] = objs;
    		


    	}
    	 int[] columnsWidth = {
                60, 100, 60, 120, 120, 100, 90, 90, 60
            };
    	
    	
    	 
    
    	 
    	 	JTable jt=new JTable(data,col); 
    	 	int i = 0;
    	 	for (int width : columnsWidth) {
               TableColumn column = jt.getColumnModel().getColumn(i++);
               column.setMinWidth(width);
               column.setMaxWidth(width);
               column.setPreferredWidth(width);
           }
    	    //jt.setBounds(30,40,1000,1000);   
    	  
    	   
    	    jt.setRowHeight(40);
    	    
    	    
    	    JScrollPane sp=new JScrollPane(jt); 
    	    sp.setPreferredSize(new Dimension(800, 600));
    	    JOptionPane.showMessageDialog(rootPane, sp);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField jTextField1;
    private JTable table1;
    // End of variables declaration//GEN-END:variables
}

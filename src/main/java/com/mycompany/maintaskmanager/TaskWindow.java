/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.maintaskmanager;


import com.mycompany.maintaskmanager.Task.Status;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
/**
 *
 * @author aitda
 */
/**
 * Represents a user interface window for creating or editing tasks.
 * Extends `JFrame` and provides functionality for managing tasks in the task database.
 * The window can operate in two modes:
 * - **Creation Mode**: When adding a new task.
 * - **Edit Mode**: When modifying an existing task.
 */
public class TaskWindow extends javax.swing.JFrame {

    /** Callback interface to notify the main window that new data has been added. */
    private DataAdded dataAdded;

    /** Indicates whether the current window is in edit mode. */
    private Boolean edit = false;

    /** The task being edited, if the window is in edit mode. Null for task creation. */
    private Task task;

    /** URL to the SQLite database where tasks are stored. */
    private final String url = "jdbc:sqlite:C:/datab/database.db";

    /**
     * Creates a new TaskWindow for adding a task.
     * This constructor initializes the window in creation mode, where the user can define a new task.
     *
     * @param _dataAdded the callback interface used to notify that data has been added or modified.
     */
    public TaskWindow(DataAdded _dataAdded) {
        this.dataAdded = _dataAdded;
        initComponents();
    }

    /**
     * Creates a new TaskWindow for editing an existing task.
     * This constructor initializes the window in edit mode, where the user can modify the given task's details.
     *
     * @param _dataAdded the callback interface used to notify that data has been added or modified.
     * @param _edit indicates that the window should operate in edit mode.
     * @param _task the task to be edited. This task's details are loaded into the window for modification.
     */
    public TaskWindow(DataAdded _dataAdded, Boolean _edit, Task _task) {
        this.task = _task;
        this.edit = _edit;
        this.dataAdded = _dataAdded;
        initComponents();
        loadEdit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NameField = new javax.swing.JTextField();
        DescriptionField = new javax.swing.JTextField();
        ImportanceComboBox = new javax.swing.JComboBox<>();
        NameLabel = new javax.swing.JLabel();
        DescriptionLabel = new javax.swing.JLabel();
        LimitDateChoser = new com.toedter.calendar.JDateChooser();
        LimitDateLabel = new javax.swing.JLabel();
        ImportanceLabel = new javax.swing.JLabel();
        SubmitButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        TypeComboBox = new javax.swing.JComboBox<>();
        TypeLabel = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });

        DescriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescriptionFieldActionPerformed(evt);
            }
        });

        ImportanceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unimportant", "Important", "VeryImportant" }));
        ImportanceComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportanceComboBoxActionPerformed(evt);
            }
        });

        NameLabel.setText("Name");

        DescriptionLabel.setText("Description");

        LimitDateLabel.setText("Limit Date");

        ImportanceLabel.setText("Importance");

        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        TypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hobby", "Work" }));

        TypeLabel.setText("Type");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(LimitDateChoser, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(SubmitButton)
                        .addGap(18, 18, 18)
                        .addComponent(CancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(NameLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(LimitDateLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(DescriptionLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(DescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImportanceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ImportanceLabel)
                            .addComponent(TypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(NameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(DescriptionLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ImportanceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ImportanceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(TypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addComponent(LimitDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LimitDateChoser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SubmitButton)
                        .addComponent(CancelButton)))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ImportanceComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportanceComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImportanceComboBoxActionPerformed

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldActionPerformed

    private void DescriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescriptionFieldActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_CancelButtonActionPerformed

   /**
 * Loads the details of the task into the form fields for editing.
 * This method is used when the TaskWindow is initialized in edit mode.
 * It populates the UI components with the current task attributes, including name, description,
 * importance, type, and limit date (if available).
 */
private void loadEdit() {
    if (task != null) {
        // Set the task name in the NameField
        NameField.setText(task.getTaskName());

        // Set the task description in the DescriptionField
        DescriptionField.setText(task.getTaskDescription());

        // Set the importance dropdown to the task's current importance
        ImportanceComboBox.setSelectedItem(task.getTaskImportance());

        // Set the type dropdown to the task's current type
        TypeComboBox.setSelectedItem(task.getTaskType());

        // If the task has a limit date, set it in the LimitDateChooser
        if (task.getTaskLimitDate() != null) {
            LimitDateChoser.setDate(java.sql.Date.valueOf(task.getTaskLimitDate()));
        }
    }
}
 

/**
 * Handles the action performed when the "Submit" button is clicked.
 * - If the form is in creation mode (edit == false), inserts a new task into the database.
 * - If the form is in edit mode (edit == true), updates the existing task in the database.
 *
 * @param evt the ActionEvent triggered by clicking the Submit button.
 */
    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        if (!edit) { // Creation mode
        // Ensure the NameField is not empty before proceeding
        if (NameField.getText().equals("")) {
            System.out.println("Task name cannot be empty.");
        } else {
            // SQL statement to insert a new task into the database
            String insertSQL = "INSERT INTO task(name, description, importance, status, type, creation_date, limit_date) VALUES(?, ?, ?, ?, ?, ?, ?)";

            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

                // Set task attributes to be saved in the database
                pstmt.setString(1, NameField.getText());
                pstmt.setString(2, DescriptionField.getText().isEmpty() ? null : DescriptionField.getText());
                pstmt.setString(3, ImportanceComboBox.getSelectedItem().toString());
                pstmt.setString(4, Status.PENDING.toString());
                pstmt.setString(5, TypeComboBox.getSelectedItem().toString());
                pstmt.setString(6, LocalDate.now().toString());

                // If no limit date is chosen, set it to null
                if (LimitDateChoser.getDate() == null) {
                    pstmt.setString(7, null);
                } else {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDate = formatter.format(LimitDateChoser.getDate());
                    pstmt.setString(7, formattedDate);
                }

                // Execute the insertion and notify listeners
                pstmt.executeUpdate();
                dataAdded.onDataAdded();

                System.out.println("Data inserted successfully.");
            } catch (Exception e) {
                System.out.println("Error inserting task: " + e.getMessage());
            }
        }
    } else if (edit) { // Edit mode
        // SQL statement to update the existing task in the database
        String updateSQL = "UPDATE task SET name = ?, description = ?, importance = ?, status = ?, type = ?, creation_date = ?, limit_date = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            // Update the task's attributes in the database
            pstmt.setString(1, NameField.getText());
            pstmt.setString(2, DescriptionField.getText().isEmpty() ? null : DescriptionField.getText());
            pstmt.setString(3, ImportanceComboBox.getSelectedItem().toString());
            pstmt.setString(4, Status.PENDING.toString());
            pstmt.setString(5, TypeComboBox.getSelectedItem().toString());
            pstmt.setString(6, LocalDate.now().toString());

            // If no limit date is chosen, set it to null
            if (LimitDateChoser.getDate() == null) {
                pstmt.setString(7, null);
            } else {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = formatter.format(LimitDateChoser.getDate());
                pstmt.setString(7, formattedDate);
            }

            // Bind the task ID to the prepared statement
            pstmt.setString(8, String.valueOf(task.getId()));

            // Execute the update and notify listeners
            pstmt.executeUpdate();
            dataAdded.onDataAdded();

            System.out.println("Data updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating task: " + e.getMessage());
        }
    }

    // Close the TaskWindow after saving changes
    this.setVisible(false);
    }//GEN-LAST:event_SubmitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField DescriptionField;
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JComboBox<String> ImportanceComboBox;
    private javax.swing.JLabel ImportanceLabel;
    private com.toedter.calendar.JDateChooser LimitDateChoser;
    private javax.swing.JLabel LimitDateLabel;
    private javax.swing.JTextField NameField;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JComboBox<String> TypeComboBox;
    private java.awt.Label TypeLabel;
    // End of variables declaration//GEN-END:variables
}

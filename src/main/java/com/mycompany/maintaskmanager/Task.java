/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maintaskmanager;

import java.time.LocalDate;

/**
 *
 * @author aitda
 */
public class Task {

    
    public enum taskType{
    HOBBY,
    WORK
}
    
    public enum Importance{
        UNIMPORTANT,
        IMPORTANT,
        VERYIMPORTANT
}
    
    public enum Status{
        PENDING,
        FINISHED
    }
    
    
    private int id;
    private String name,description;
    private Importance TaskImportance;
    private taskType Task_Type;
    private Status taskStatus;
    private LocalDate TaskLimitDate;
    private final LocalDate TaskCreationDate;
    
    public Task(int _id,String _name, String _description, Importance _TaskImportance, taskType _taskType,Status _taskStatus,LocalDate _taskLimitDate)
    {
        id = _id;
        name = _name;
        description = _description;
        TaskImportance = _TaskImportance;
        Task_Type = _taskType;
        taskStatus = _taskStatus;
        TaskLimitDate = _taskLimitDate;
        TaskCreationDate = LocalDate.now();
    }
    
    
    
     public Task(int _id,String _name, String _description, Importance _TaskImportance, taskType _taskType, Status _taskStatus)
    {
        id = _id;
        name = _name;
        description = _description;
        TaskImportance = _TaskImportance;
        Task_Type = _taskType;
        TaskLimitDate = null;
        taskStatus = _taskStatus;
        TaskCreationDate = LocalDate.now();
    }
    
     /*
    *Getter method for the Task's id
     *@return the Task's id
    */
     public int getId(){
         return id;
     }
     
    
     
     /*
    *Getter method for the limit date
     *@return the Task's Name
    */
    public String getTaskName(){
        return name;
    }
    
    /*
    *Getter method for the limit date
    *@return the Task's Description
    */
    public String getTaskDescription(){
        return description;
    }
    
    /*
    *Gtter method for the limit date
    *@return the Task's Importance
    */
    public Importance getTaskImportance(){
        return TaskImportance;
    }
    
    /*
    *Getter method for the limit date
    *@return the Task's Type
    */
    public taskType getTaskType(){
        return Task_Type;
    }
    
    /*
    *Gtter method for the limit date
    *@return the Task's Status
    */
    public Status getTaskStatus(){
        return taskStatus;
    }
    
    /*
    *Getter method for the limit date
    *@return the Creation Date
    */
    public LocalDate getTaskCreationDate(){
        return TaskCreationDate;
    }
    
    /*
    *Getter method for the limit date
    *@return the limit date
    */
    public LocalDate getTaskLimitDate(){
        return TaskLimitDate;
    }
    
    
    /*
    *Setter method for the Task's name
    */
    public void setTasktName(String _name){
        name = _name;
    }
    
    /*
    *Setter method for the Task's description
    */
    public void setTaskDescription(String _description){
        description = _description;
    }
    
    /*
    *Setter method for the Task's importance
    */
    public void setTaskImportance(Importance _TaskImportance){
        TaskImportance = _TaskImportance;
    }
    
    /*
    *Setter method for the Task's type
    */
    public void setTaskType(taskType _taskType){
        Task_Type = _taskType;
    }
    
    /*
    *Setter method for the Task's status
    */
    public void setTaskStatus(Status _taskStatus){
        taskStatus = _taskStatus;
    }
    
    /*
    *Setter method for the limit date
    */
    public void setTaskLimitDate(LocalDate _limitDate){
        TaskLimitDate = _limitDate;
    }
    
   
}

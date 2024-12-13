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
    
    //Task(int,String,String,Importance,taskType,Status)
    
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
    
     public int getId(){
         return id;
     }
     
    
     
    public String getTaskName(){
        return name;
    }
    
    public String getTaskDescription(){
        return description;
    }
    
    public Importance getTaskImportance(){
        return TaskImportance;
    }
    
    public taskType getTaskType(){
        return Task_Type;
    }
    
    public Status getTaskStatus(){
        return taskStatus;
    }
    
    public LocalDate getTaskCreationDate(){
        return TaskCreationDate;
    }
    
    public LocalDate getTaskLimitDate(){
        return TaskLimitDate;
    }
    
    
    public void setTasktName(String _name){
        name = _name;
    }
    
    public void setTaskDescription(String _description){
        description = _description;
    }
    
    public void setTaskImportance(Importance _TaskImportance){
        TaskImportance = _TaskImportance;
    }
    
    public void setTaskType(taskType _taskType){
        Task_Type = _taskType;
    }
    
    public void setTaskStatus(Status _taskStatus){
        taskStatus = _taskStatus;
    }
    
    public void setTaskLimitDate(LocalDate _limitDate){
        TaskLimitDate = _limitDate;
    }
    
   
}

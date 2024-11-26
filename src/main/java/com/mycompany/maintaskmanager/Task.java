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
    enum type{
    Hobby,
    Work
}
    
    enum Importance{
        Unimportant,
        Important,
        VeryImportant
}
    
    private String name,description;
    private Importance TaskImportance;
    private type TaskType;
    private LocalDate TaskLimitDate;
    private final LocalDate TaskCreationDate;
    
    public Task(String _name, String _description, Importance _TaskImportance, type _taskType,LocalDate _taskLimitDate)
    {
        name = _name;
        description = _description;
        TaskImportance = _TaskImportance;
        TaskType = _taskType;
        TaskLimitDate = _taskLimitDate;
        TaskCreationDate = LocalDate.now();
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
    
    public type getTaskType(){
        return TaskType;
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
    
    public void setTaskType(type _taskType){
        TaskType = _taskType;
    }
    
    public void setTaskLimitDate(LocalDate _limitDate){
        TaskLimitDate = _limitDate;
    }
}

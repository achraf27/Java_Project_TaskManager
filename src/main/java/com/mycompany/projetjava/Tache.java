/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetjava;

/**
 *
 * @author aitda
 */

import java.time.LocalDate;

public class Tache {
    
    enum Type{
        Travail,
        Loisir
    }
    
    String nom,description;
    LocalDate date_debut = LocalDate.now();
    LocalDate date_fin;
    Type importance;
    
}

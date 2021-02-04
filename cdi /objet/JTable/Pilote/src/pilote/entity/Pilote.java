/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pilote.entity;

import java.awt.Color;

/**
 *
 * @author install
 */
public class Pilote {
    private int numero;
    private String nom;
    private String prenom;
    private Boolean vire;
    private Color couleurCheveux;

    public Color getCouleurCheveux() {
        return couleurCheveux;
    }

    public void setCouleurCheveux(Color couleurCheveux) {
        this.couleurCheveux = couleurCheveux;
    }

    public Pilote(int pnumero, String pnom, String pprenom, Boolean pvire)
    {
        this.numero = pnumero;
        this.nom = pnom;
        this.prenom = pprenom;
        this.vire = pvire;
        this.couleurCheveux = Color.PINK;
    }
    
    
    public Boolean getVire() {
        return vire;
    }

    public void setVire(Boolean pvire) {
        this.vire = pvire;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}

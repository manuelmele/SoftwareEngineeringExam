/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.jsonclient;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 *
 * @author studente
 */
@JacksonXmlRootElement(localName = "Match")
public class Match {

    private int id;
    private String result;
    private String date;
    private String homeTeam;
    private String visTeam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getVisTeam() {
        return visTeam;
    }

    public void setVisTeam(String visTeam) {
        this.visTeam = visTeam;
    }
    


    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Match) && (id == ((Match) obj).getId());
    }
    
    @Override
    public String toString(){
        return "match " + id + " date " + date + " result " + result;
    }
}

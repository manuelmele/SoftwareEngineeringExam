/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.complexrestservice;

/**
 *
 * @author studente
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/matches")
public class MatchesRepository {

    private Connection conn;
    
    public void setConnection(String pos) {
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MatchesRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn
                    = DriverManager.getConnection("jdbc:sqlite:"+pos);
        } catch (SQLException ex) {
            Logger.getLogger(MatchesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    @Path("all")
    @Produces("application/json")

    public List<Match> getMatches() {
        List<Match> matches =  new ArrayList<Match>();
        PreparedStatement stat = null;
        Match fl = null;
        try {
            stat = conn.prepareStatement("select * from matches");
        
        ResultSet rs = stat.executeQuery();
        while (rs.next()) {
            fl = new Match();
            fl.setId(Integer.parseInt(rs.getString("id")));
            fl.setResult(rs.getString("result"));
            fl.setDate(rs.getString("date"));
            fl.setHomeTeam(rs.getString("homeTeam"));
            fl.setVisTeam(rs.getString("visTeam"));
            matches.add(fl);
            Logger.getLogger(MatchesRepository.class.getName()).log(Level.INFO, "Accessed : " + fl);
        }
        rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MatchesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return matches;   
    }
    
    
    @GET
    @Path("{matchId}")
    @Produces("application/json")

    public Match getMatch(@PathParam("matchId") int matchId) {
        return findById(matchId);
    }

    private Match findById(int id) {
        
        PreparedStatement stat = null;
        Match fl = null;
        try {
            stat = conn.prepareStatement("select * from matches where id = ?");
            stat.setString(1, String.valueOf(id));
        
        ResultSet rs = stat.executeQuery();
        if (rs.next()) {
            fl = new Match();
            fl.setId(Integer.parseInt(rs.getString("id")));
            fl.setResult(rs.getString("result"));
            fl.setDate(rs.getString("date"));
            fl.setHomeTeam(rs.getString("homeTeam"));
            fl.setVisTeam(rs.getString("visTeam"));
            Logger.getLogger(MatchesRepository.class.getName()).log(Level.INFO, "Accessed : " + fl);
        }
        rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MatchesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fl;   
    }
    
    @GET
    @Path("teams/{teamId}")
    @Produces("application/json")

    public Team getTeam(@PathParam("teamId") int teamId) {
        return findTeamById(teamId);
    }

    private Team findTeamById(int id) {        
        PreparedStatement stat = null;
        Team fl = null;
        try {
            stat = conn.prepareStatement("select * from teams where teamId = ?");
            stat.setString(1, String.valueOf(id));
        
        ResultSet rs = stat.executeQuery();
        if (rs.next()) {
            fl = new Team();
            fl.setId(Integer.parseInt(rs.getString("teamId")));
            fl.setName(rs.getString("name"));
            fl.setCoach(rs.getString("coach"));
            Logger.getLogger(MatchesRepository.class.getName()).log(Level.INFO, "Accessed : " + fl);
        }
        rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MatchesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fl; 
    }
    
}

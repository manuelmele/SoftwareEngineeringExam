/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.jsonclient;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import java.util.ArrayList;
import soapwsclient.generated.*;
/**
 *
 * @author studente
 */
public class Client {

    private static final String BASE_URL = "http://localhost:8000/matches/";
    private static CloseableHttpClient client;

    public static void main(String[] args) throws IOException {
        client = HttpClients.createDefault();
        BufferedReader reader;
        String answer;
        
        addingSellers();
        
        while(true){
            System.out.println("Possible commands are 'show matches', 'match details' and 'delivery date'");
            
            // Enter data using BufferReader
            reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine
            answer = reader.readLine();
            
            ObjectMapper mapper;
            URL url;
            InputStream input;
            
            switch (answer){ // List all matches
                
                case "show matches":
                    // Example GET
                    mapper = new ObjectMapper();
                    url = new URL(BASE_URL + "all");

                    input = url.openStream();

                    List<Match> matches = (List<Match>) mapper.readValue(input, new TypeReference<List<Match>>() {
                    });
                    for (Match match : matches) {
                        System.out.println(match);
                    }
                    break;
                case "match details":
                    System.out.println("Write match id");

                    // Enter data using BufferReader
                    reader = new BufferedReader(
                            new InputStreamReader(System.in));

                    // Reading data using readLine
                    String idMatch = reader.readLine();
                    
                    // GET Match
                    mapper = new ObjectMapper();
                    url = new URL(BASE_URL + idMatch);

                    input = url.openStream();

                    Match match = (Match) mapper.readValue(input, new TypeReference<Match>() {
                    });
                    System.out.println(match);
                    
                    // GET homeTeam
                    mapper = new ObjectMapper();
                    url = new URL(BASE_URL + "teams/" + match.getHomeTeam());

                    input = url.openStream();

                    Team team = (Team) mapper.readValue(input, new TypeReference<Team>() {
                    });
                    System.out.println("Home team: "+ team);
                    
                    // GET visTeam
                    mapper = new ObjectMapper();
                    url = new URL(BASE_URL + "teams/" + match.getVisTeam());

                    input = url.openStream();

                    team = (Team) mapper.readValue(input, new TypeReference<Team>() {
                    });
                    System.out.println("Vis team: "+ team);
                    
                    // GET sellers
                    
                    
                    System.out.println("Sellers of Match: " + idMatch);
                    List<SellerEntry> result = Client.getSellers(idMatch).getEntry();
                    for (int i = 0; i < result.size(); i++) {
                        Seller seller = ((SellerEntry) result.get(i)).getSeller();
                        System.out.println("Seller name: "+ seller.getName() + " price: "+ seller.getPrice());
                    }
                    break;
                case "delivery date":
                    System.out.println("Write matche id: ");

                    // Enter data using BufferReader
                    reader = new BufferedReader(
                            new InputStreamReader(System.in));

                    // Reading data using readLine
                    String id = reader.readLine();
                    
                    System.out.println("Write seller: ");

                    // Enter data using BufferReader
                    reader = new BufferedReader(
                            new InputStreamReader(System.in));

                    // Reading data using readLine
                    String sellerName = reader.readLine();
                    
                    System.out.println("Seller of Match: " + id);
                    result = Client.getSellers(id).getEntry();
                    for (int i = 0; i < result.size(); i++) {
                        Seller seller = ((SellerEntry) result.get(i)).getSeller();
                        if(seller.getName().equals(sellerName)){
                            System.out.println("Seller name: "+ seller.getName() + " delivery date: "+ seller.getDate());   
                        }
                    }
                    break;
            }
        }
    }
    
    private static SellerMap getSellers(String arg0) {
        WSImplService service = new WSImplService();
        WSInterface port = service.getWSImplPort();
        return port.getSellers(arg0);
    }

    private static void addSeller(Seller arg0) {
        WSImplService service = new WSImplService();
        WSInterface port = service.getWSImplPort();
        port.addSeller(arg0);
    }
    
    private static void addingSellers(){
        for (int i = 1; i < 11; i++) {
            Seller s1 = new Seller();
            s1.setName("FIFA");
            s1.setDate("2019/02/03");
            s1.setPrice("23");
            s1.setMatchId(""+i);
            Client.addSeller(s1);
        }
        for (int i = 1; i < 11; i++) {
            Seller s1 = new Seller();
            s1.setName("Unofficial Partner");
            s1.setDate("2019/02/01");
            s1.setPrice("23");
            s1.setMatchId(""+i);
            Client.addSeller(s1);
        }
    }
}

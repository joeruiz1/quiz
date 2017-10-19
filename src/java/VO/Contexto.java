 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author LabingXEON
 */
public class Contexto {
    private  int id ;
    private String link; 
    private int  idM;

    public Contexto(int id, String link, int idM) {
        this.id = id;
        this.link = link;
        this.idM = idM;
    }

    public Contexto(){   }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getIdM() {
        return idM;
    }

    public void setIdM(int idM) {
        this.idM = idM;
    }
    
}

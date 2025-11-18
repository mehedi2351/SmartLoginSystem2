package com.example.smartloginsystem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Admin {

    private StringProperty studentid;
    private StringProperty techerid;
    private StringProperty tittleid;
    private StringProperty desid;
    private StringProperty reactid;
    private StringProperty viewid;
    private StringProperty acid;

    public Admin(String studentid, String techerid, String tittleid,
                 String desid, String reactid, String viewid, String acid) {

        this.studentid = new SimpleStringProperty(studentid);
        this.techerid = new SimpleStringProperty(techerid);
        this.tittleid = new SimpleStringProperty(tittleid);
        this.desid = new SimpleStringProperty(desid);
        this.reactid = new SimpleStringProperty(reactid);
        this.viewid = new SimpleStringProperty(viewid);
        this.acid = new SimpleStringProperty(acid);
    }

    public String getStudentid() { return studentid.get(); }
    public String getTecherid() { return techerid.get(); }
    public String getTittleid() { return tittleid.get(); }
    public String getDesid() { return desid.get(); }
    public String getReactid() { return reactid.get(); }
    public String getViewid() { return viewid.get(); }
    public String getAcid() { return acid.get(); }
}

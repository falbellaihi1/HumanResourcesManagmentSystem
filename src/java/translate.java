/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author falbellaihi
 */
@ManagedBean
@SessionScoped
public class translate {
    
    private String ArEmp = "الرقم الوظيفي";
    private String EnEmp = "Employee Number";

    public String getArEmp() {
        return ArEmp;
    }

    public void setArEmp(String ArEmp) {
        this.ArEmp = ArEmp;
    }

    public String getEnEmp() {
        return EnEmp;
    }

    public void setEnEmp(String EnEmp) {
        this.EnEmp = EnEmp;
    }

   

}

package appgestiondesstagiairesetapprentis;

import API.ConnectionDB;
import VIEWS.Authentification;

public class AppGestionDesStagiairesEtApprentis {

    public static void main(String[] args) {
       
        ConnectionDB cdb = new ConnectionDB();
        cdb.connectionToDb();
        Authentification authentification = new Authentification(null, true,cdb.getConnection());
       
    }
    }
    
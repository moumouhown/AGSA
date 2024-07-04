package MODELS;

public class Utilisateur {
    String userID;
    String motPasse;
    String typeUtilisateur;
    
    public Utilisateur(String userID, String motPasse, String typeCompte)
    {
        this.userID = userID;
        this.motPasse  =motPasse;
        this.typeUtilisateur = typeCompte;
    }

    public String getUserID() {
        return userID;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public String getTypeUtilisateur() {
        return typeUtilisateur;
    }
    
    
    
    
}

<td><img src="./images/<%=photo %>" /></td>

String res="<select name=\"" + nomSelect + "\"><option></option>";

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page_Resultat</title>
    </head>
    <body>
        <%@ page import="Convert.*" %>
        <%  // Conversion de la devise
            Double result = 0.0;
            String montantDepart = request.getParameter( "monnaieDepart" );
            String montantArrivee = request.getParameter( "monnaieArrivee" );
            Double montant = Double.parseDouble(request.getParameter( "montant") );
            Double result = Convertisseur.convertir( montantDepart, montantArrivee, montant );
        %>
    </body>
</html>



     Double montant = Double.parseDouble(request.getParameter( "montant") );
http://prevert.upmf-grenoble.fr/Prog/Java/swing/JFrame.html
http://www.inpg.fr/jsp/fiche_actualite.jsp?CODE=1194449044900&LANGUE=0
http://www.objetdirect.com/html/espacetechno/tatamidemo.html
http://cgi.ebay.com/Fragmented-Images-Peru-Oil-painting_W0QQitemZ7405832953QQihZ008QQcategoryZ20137QQcmdZViewItem#ebayphotohosting
enum Colorie
{
	JAUNE, VERT, BLEU, ROUGE, ORANGE, MAUVE
};
public class Main
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Colorie c = saisieColorie();
		System.out.println(c);

	}

	public static Colorie saisieColorie()
	{
		String s;
		Colorie col = null;
		boolean ok = true;
		do
		{
			System.out.print("Couleur : ");
			for(Colorie c : Colorie.values())
			{
				System.out.print(c+" ");

			}
			System.out.println();
			System.out.print("donnez votre couleur : ");
			
			s = Lire.S().toUpperCase();
			try
			{
				col = Colorie.valueOf(s);
				ok = true;
			}
			catch (Exception e)
			{
				ok = false;
			}
		} while (!ok);
		return col;
	}

}

package PackArt;

import java.sql.*;
import java.util.*;
/*
 * Catalogue.java
 * Created on 27 novembre 2007, 12:02
 */

public class Catalogue {
    private Vector m_Articles = null;
    private ArticleBdd m_articleBdd = null;
    
    /** Creates a new instance of Catalogue */
    public Catalogue() {
    }

    public void lire() {
        ArticleBdd m_articleBdd = null;
        // Connexion a la base de donnees si il a lieu
        if ( m_articleBdd == null ) {
                 m_articleBdd = new ArticleBdd();
                 m_Articles = new Vector();
        }
        try {
		ResultSet resultats = m_articleBdd.lireCat();
                while ( resultats.next() ) {
			ajouter( resultats );
                }
	} catch ( SQLException e ) { }
    }

    private void ajouter( ResultSet resultats ) throws SQLException  {
        Article article = new Article();
        article.setM_StringReference( resultats.getString("referenceart") );
        article.setM_StringTitre( resultats.getString("titre") );
        article.setM_StringAuteur( resultats.getString("auteur") );
        article.setM_StringPhoto( resultats.getString("photo") );
        article.setM_StringPrix( resultats.getString("prix") );
        m_Articles.add( article );
         
    }

    public Vector getM_Articles() {
        return m_Articles;
    }

    public void setM_Articles(Vector m_Articles) {
        this.m_Articles = m_Articles;
    }
    
}
 Ing�nieur de d�veloppement JAVA/J2EE H/F    	Grenoble  	  ALTECA   	03/12/2007
ALTECA, soci�t� de service en informatique de 250 collaborateurs, s'est impos�e depuis sa cr�ation en 1996, en tant qu'acteur de r�f�rence aupr�s de ses partenaires, les grands comptes de l'industrie, de la grande distribution, des services organismes publics et de pr�voyance. ..


�f�rence :  	 7320187-2030-6276
Date de publication : 	03/12/2007
Soci�t� : 	ALTECA
Voir toutes les offres de cette soci�t�
Lieu : 	Grenoble
Salaire : 	Selon exp�rience
Exp�rience : 	Exp�riment�
Postuler � cette offre
Sauvegarder cette offre

ALTECA, soci�t� de service en informatique de 250 collaborateurs, s'est impos�e depuis sa cr�ation en 1996, en tant qu'acteur de r�f�rence aupr�s de ses partenaires, les grands comptes de l'industrie, de la grande distribution, des services organismes publics et de pr�voyance. ALTECA poursuit sa croissance en 2007 gr�ce � son implantation au niveau national (Lyon, Paris, Lille, Grenoble, Dijon, Le Creusot, Clermont-Ferrand, Nantes et Metz) tout en restant fid�le � son coeur de m�tier : l'informatique de gestion.

Pour accompagner ce d�veloppement, nous renfor�ons nos �quipes de l'agence grenobloise.

Sous la conduite du Directeur d'agence, vous intervenez sur des projets de d�veloppement d'applications Power Builder Sybase SQL/serveur pour un client Grand Compte.

De formation Bac+4/ 5 en Informatique, vous avez une exp�rience de 2 ans minimum en tant que Ing�nieur de D�veloppement Power Builder Sybase SQL/serveur.

Autonome et adaptable, vous �tes dot� de bonnes capacit�s relationnelles, et saurez vous int�grer ais�ment � une �quipe. Si vous souhaitez int�grer une structure o� le facteur humain est pr�pond�rant, envoyez nous rapidement votre candidature.

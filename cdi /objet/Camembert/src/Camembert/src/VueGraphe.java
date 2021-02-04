import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//Fichier : PanelCamembert.java
//Auteur : abonnenc
//Date : 27 juin 2011
//Role du fichier
public class VueGraphe extends Panel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8128768537270331543L;
	private PanelTitre pTitre;
	private PanelLegende pLegende;
	private Graphe pGraphe;
	private DonneeGraphe donnees;
	
	public VueGraphe(DonneeGraphe d)
	{
		donnees = d;	
		
		EcChangeDonnees dL = new EcChangeDonnees();
		donnees.addDonneesListener(dL);
		
		setLayout(new BorderLayout(10,20));
		pLegende = new PanelLegende(d);
		pTitre = new PanelTitre();
	}

	public void setTitre(String l)
	{
		pTitre.setTitre (l);
	}
	
	public void setType(TypeGraphe type)
	{
		remove(pGraphe);
		if (type == TypeGraphe.camembert)
			pGraphe = new CamembertGraphe(donnees);
		else //histogramme
			pGraphe = new HistogrammeGraphe(donnees);

		add(pGraphe, BorderLayout.CENTER);
		validate();
	}
	
	public Graphe creerPanelGraphe()
	{
		String [] type = {"camembert", "histogramme"};
		JComboBox jc = new JComboBox(type);

		if (donnees.getType() == TypeGraphe.camembert)	
		{
			pGraphe = new CamembertGraphe(donnees);
			jc.setSelectedIndex(0);
		}
		else //histogramme
		{
			pGraphe = new HistogrammeGraphe(donnees);
			jc.setSelectedIndex(0);
		}
		
		jc.setSize(100, 50);
		Ecouteur ec = new Ecouteur();
		jc.addActionListener(ec);
		JPanel jp = new JPanel();
		jp.setBackground(Color.white);
		jp.setLayout(new BorderLayout(10, 5));
		jp.add(pLegende);
		jp.add(jc, BorderLayout.SOUTH);
		add(pGraphe, BorderLayout.CENTER);
		add(pTitre, BorderLayout.SOUTH);
		add(jp, BorderLayout.EAST);
		pLegende.update(donnees);
		return pGraphe;
	}
	
	class EcChangeDonnees implements DonneesListener
	{

		@Override
		public void donneesChanged(DonneesEvent ce)
		{
			if ((pGraphe != null)&&(pLegende!=null))
			{
				pGraphe.update(((DonneeGraphe)ce.getSource()));
				pLegende.update(((DonneeGraphe)ce.getSource()));
			}
		}
		
	}
	
	class Ecouteur implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
	        JComboBox cb = (JComboBox)e.getSource();
	        String strType = (String)cb.getSelectedItem();
	        if (strType.equalsIgnoreCase("camembert"))
	        	setType(TypeGraphe.camembert);
	        else if (strType.equalsIgnoreCase("histogramme"))
	        	setType(TypeGraphe.histogramme);
	        
	    }
	}
}

use airlinair
go
alter PROCEDURE phil AS
begin
select* From PILOTE
end



go
ALTER PROCEDURE paramin ( @nom TypeNom) AS
begin
select* From PILOTE
where NomPilote = @nom
end

GO
alter PROCEDURE paramout @prenom TypePrenom OUTPUT 
AS
begin
select @prenom = PrenomPilote
From PILOTE
where NomPilote = 'Gainsbourg'
end


GO
alter PROCEDURE paramout @prenom TypePrenom OUTPUT 
AS
begin
select PrenomPilote from PILOTE
where PrenomPilote = @prenom 
select @prenom = PrenomPilote
from	PILOTE
where NomPilote = 'Gainsbourg'
end



GO
alter PROCEDURE paramout @prenom TypePrenom OUTPUT 
AS
begin
select PrenomPilote from PILOTE
where PrenomPilote = @prenom 
select @prenom = PrenomPilote
from	PILOTE
where NomPilote = 'Gainsbourg'
end




GO
alter PROCEDURE paramresult @prenom TypePrenom
AS
begin
select* from PILOTE
where PrenomPilote = @prenom 
select*  
from	PILOTE
end


GO
alter PROCEDURE param2in1retour @nom TypeNom, @prenom TypePrenom
as 
begin
update PILOTE set PrenomPilote = @prenom
where Nompilote = @nom
return 9
end
execute param2in1retour Gainsbourg, Serge




go






alter FUNCTION fn_HeuresDeVol (@NPilote TypeNom ,@PPilote TypeNom,@numsemaine int) 
returns int 
as
begin
  declare @retour int;
  if @NPilote is null or @PPilote is null
  begin
       set  @retour = -1;
  end
  else if  not exists ( select * from PILOTE where NomPilote = @NPilote and PrenomPilote = @PPilote )
  begin
      set @retour = -2;
  end
  else
  begin  
     select @retour = SUM (DATEDIFF ( hh, VOL.Hdépart, VOL.Harrivée))  
     from VOL
       join AFFECTATION on AFFECTATION.NumVol = VOL.NumVol
       join PILOTE on AFFECTATION.IdPilote = PILOTE.IdPilote
       where DATEPART (ww,DateVol) = @numsemaine and
       PILOTE.NomPilote = @NPilote and PILOTE.PrenomPilote = @PPilote;
       
       set @retour = 0;    
  end
  return @retour;
end
   
  go         
  
  
  -- Main programme de test 
 select  'resultat', dbo.fn_HeuresDeVol(null, 'titi', 14);
 
 select  'resultat', dbo.fn_HeuresDeVol('toto', 'titi', 14);
 
 select  'resultat', dbo.fn_HeuresDeVol('Gainsbourg', 'serge', 14);
 
 
  
 
  -- code retour
 
           -- 2: pilote n"exciste pas Erreur: 'pilote inexistant'
           -- 1: paramètre omis: erreur :'Idpilote non defini'
           -- 0: pilote existe ok
   -- sortie : @message: contient le message d'erreur           
  
  go     
       
  alter PROC planning_perso @Idpilote TypeIdPilote, @message varchar(50)  output
  as
	declare @retour int;
 
 -- verifier que les paramètres ne sont pas nuls
 
    if @Idpilote is null
    begin
        set @retour = 1; 
        set @message= 'Idpilote non defini';
    end
    else
    begin
     begin try
   		if not exists ( select Idpilote from PILOTE where Idpilote = @Idpilote)
 	    begin
		   set @retour = 2;
		   set @message = 'pilote inexistant';	                    
		end	      
		else
	    begin
			  select  VOL.NumVol as'NumVol', VOL.AeroportDept as 'De', VOL.AeroportArr as 'vers', DateVol as 'partant',
				  DATENAME(hh, Harrivée)+'H00' as ' le'	    
			  from PILOTE, AFFECTATION,VOL
			  where PILOTE.IdPilote = AFFECTATION.IdPilote and AFFECTATION.NumVol = VOL.NumVol
				  and PILOTE.IdPilote =  @Idpilote;
			   
			set @retour = 0;
			set @message = 'ok';      
		end	     
     end try
     begin catch
        set @retour = 3;
        set @message = 'Exception ' + ERROR_MESSAGE();
     end catch 
   end
   return @retour;    
  go    
     
     
     
      
     
      
      -- DTD Development Test Driven
  -- Main programme de test 
 declare @msg varchar(255)
 execute planning_perso 1, @msg output
 print @msg
 
 execute planning_perso 100, @msg output
 print @msg
 
 
 execute planning_perso null, @msg output
 print @msg
 
 
 
 --exo 50/1
 
 -- code retour
 
           -- -1: pilote inexistant
           --  0: succès
          
  
  go     
       
ALTER PROCEDURE HEUREDEVOLS @Idpilote TypeIdPilote, @NPilote TypeNom ,@PPilote TypeNom,@numsemaine int, @somme_heure int  output
  as
  begin
  declare @retour_erreur int;
  
  if @NPilote is null or @PPilote is null
  begin
      set  @retour_erreur = -1;
  end

  ELSE if  not exists ( select NomPilote,PrenomPilote from PILOTE where NomPilote = @NPilote and PrenomPilote = @PPilote )
    begin
       set @retour_erreur = -2;
    end
     else
      begin try 
       begin
         select @somme_heure = SUM (DATEDIFF ( hh, VOL.Hdépart, VOL.Harrivée))  
         from VOL
         join AFFECTATION on AFFECTATION.NumVol = VOL.NumVol
         join PILOTE on AFFECTATION.IdPilote = PILOTE.IdPilote
         where DATEPART (ww,DateVol) = @numsemaine and
         PILOTE.NomPilote = @NPilote and PILOTE.PrenomPilote = @PPilote;
      
         set @retour_erreur = 0;
        end 
       end try  
 
  begin catch
      set @retour_erreur = -3;
  end catch 
  end
 return @retour_erreur;
go

-- Main programme de test 

 declare  @retour_erreur int
 declare @somme_heure int 
 
 execute  @retour_erreur = dbo.HEUREDEVOLS 8,'Fayolle', 'Marc', 14,  @somme_heure output                

select  @retour_erreur,@somme_heure





 
 --2/
 
 go
 

alter PROCEDURE  ObjectifHebdomadaire  @Idpilote TypeIdPilote, @NPilote TypeNom ,@PPilote TypeNom, @numsemaine int, @heure_demandées int 
as
begin
 declare @message varchar(250);
 declare @somme_heure int;
 declare @retour_erreur int;
 execute @retour_erreur = HEUREDEVOLS  @Idpilote , @NPilote, @PPilote, @numsemaine , @somme_heure output 
 
    if @retour_erreur = -1
    begin     
        set @message= 'Idpilote non defini';
    end 
    else if  @retour_erreur = -2            
 	    begin
		 set @message = 'pilote inexistant';	                    
        end	
     else 
     begin  
	    if  @retour_erreur = 0
	      begin
	       set @message = 'ok';	
	       /* 
	       @Idpilote + ' ', @NPilote +' ' ,@PPilote +' ', @numsemaine, + ' ' 
	       */
	      end                   	
        if  @somme_heure >= @heure_demandées
		begin 
			set @message = 'objectif atteint';
		end
		 else 
		 begin
			set @message = ' objectif non atteint';
		 end
     end     
      select @Idpilote, @NPilote ,@PPilote, @numsemaine, @message , @heure_demandées, @retour_erreur 
     end 
      
   
   go    
    
 
 -- Main programme de test 
 
 
 execute  ObjectifHebdomadaire   1, 'lolo', 'serge', 14, 9          

 
 
execute  ObjectifHebdomadaire   1, 'gainsbourg', 'serge', 14,   7          

 go
 
 
-- exo 51

go
alter procedure VerifPilote  @Idpilote TypeIdPilote, @NumVol TypeNumVol , @date TypeDate, @message varchar, @affectation bit output
 
 as 
 begin 
   declare @retour_erreur int;
   declare @h_départ int;
   declare @h_arrivée int;
   
   if @IdPilote is null or @numvol is null
   begin
      set  @retour_erreur = -1;
      set  @message = 'Parametre non defini'; 
     
   end

   	else if not exists ( select * from PILOTE, AFFECTATION 
   		                where PILOTE.IdPilote = @IdPilote and AFFECTATION.NumVol = @NumVol)
        begin
           set @retour_erreur = -2;
           set  @message = 'Parametre inexistant'; 
         end
       else
       begin   
         select @h_départ = Hdépart, @h_arrivée = Harrivée  from VOL
                where NumVol = @NumVol;
         
         if not exists ( select IdPilote from PILOTE
                
         
         
         
                          
         
       
  end
         
       
         
         
         
         
         
       



 go
 

 
 -- Main programme de test 
 
 declare @message varchar(250)
 execute   VerifPilote   1, IT100, '6avril 2001',  @message, 0        
print @message
 
 
 
 
 
 
 
			 
  
  
  
 
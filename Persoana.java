package proiectpi2;
public class Persoana {
//public final String ID;
	public final String sEmail;
	public final String sAutori;
	public final String sTitlu;
	public final String sAfiliere;
	
	Persoana( final String sEmail, final String sAutori, final String sTitlu, final String sAfiliere){
//	this.ID=ID;
		this.sEmail = sEmail;
		this.sAutori = sAutori;
		this.sTitlu = sTitlu;
                this.sAfiliere=sAfiliere;
		
	}
	
        @Override
        public String toString() {
	
	return this.sEmail+" "+this.sAutori+" "+this.sTitlu;
}
String getEmail() {return this.sEmail;}
String getAutori() {return this.sAutori;}
String getTitlu() {return this.sTitlu;}
String getAfiliere() {return this.sAfiliere;}


	
}

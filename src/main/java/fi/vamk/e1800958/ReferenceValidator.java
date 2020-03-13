package fi.vamk.e1800958;

public class ReferenceValidator {
	private String invoice;
	private String mutiplier;
	public ReferenceValidator(String invoice, String mutiplier) {
		super();
		this.invoice = invoice;
		this.mutiplier = mutiplier;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getMutiplier() {
		return mutiplier;
	}
	public void setMutiplier(String mutiplier) {
		this.mutiplier = mutiplier;
	}
	
	
	public boolean checkInput() {
		if (this.invoice==null || this.mutiplier==null) return false;
		if (!(this.invoice.length() > 2 && this.invoice.length() < 19) || this.invoice.length() != this.mutiplier.length()) return false;
		if (this.invoice.matches("[0-9]+") && this.mutiplier.matches("[0-9]+")) return true;
		return false;
	}
	
	public String calculation() {
		int res=0;
		
		for (int i = 0; i < this.invoice.length(); i++) {
			res+= Character.getNumericValue(this.invoice.charAt(i)) * Character.getNumericValue(this.mutiplier.charAt(i));
		}
		return String.valueOf(res);
	}
	
	public String getCheckingNumber(String a) {
		int a_convert= Integer.parseInt(a);
		return String.valueOf((a_convert/10+1)*10-a_convert);
	}
	
	public String groupedNumber(String a){
		
		String res="";
		for (int i = a.length()-1; i >=0 ; i--) {
			res= a.charAt(i)+res;
			if ((a.length()-i)% 5==0) {
				res=" "+res;
			}
		}
		return res;
	}
		
	
		
	public String getReferenceNumber() {
		
		if (! this.checkInput()) return null;
		
		String calculationNumber=this.calculation();
		String checkNumber=this.getCheckingNumber(calculationNumber);
		String referenceNumber=this.invoice+ checkNumber;
		return this.groupedNumber(referenceNumber);
	}
	
	public int getLengthReferenceNumber() {
		
		if ( this.getReferenceNumber()==null) return 0;
		
		String calculationNumber=this.calculation();
		String checkNumber=this.getCheckingNumber(calculationNumber);
		String referenceNumber=this.invoice+ checkNumber;
		return referenceNumber.length();
	}
	
	
	

}

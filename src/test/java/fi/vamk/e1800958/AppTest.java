package fi.vamk.e1800958;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	
	public boolean groupOf5(ReferenceValidator referenceValidator) {
		String referenceNumber= referenceValidator.getReferenceNumber() ;
		if (referenceNumber == null) return false;
		String[] splitedNumber=referenceNumber.split(" ");
		
		if(splitedNumber[0].length() > 5 ) return false;
		else if (splitedNumber.length ==1) return true;
		else
		{
			for (int i = 1; i < splitedNumber.length; i++) {
				if(splitedNumber[i].length() !=5) return false;
			}
			return true;
		}
		
	}
	
	
	public boolean containNumberAndSpace(ReferenceValidator referenceValidator) {
		String referenceNumber= referenceValidator.getReferenceNumber() ;
		if (referenceNumber == null) return false;
		
		for (int i = 0; i < referenceNumber.length(); i++) {
			if (!(!Character.isDigit(referenceNumber.charAt(i)) || referenceNumber.charAt(i)!=' ')) return false;
		}
		return true;
		
	}
	
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    
    @Test
    public void TestLengthReferenceNumberGreaterThan3()
    {
    	
        assertEquals(new ReferenceValidator("123", "137").getLengthReferenceNumber() > 3, true);
        assertEquals(new ReferenceValidator("123456789012345678", "123456789012345678").getLengthReferenceNumber() >3, true);
        assertEquals(new ReferenceValidator("123", "123456789012345").getLengthReferenceNumber() >3, false);
        assertEquals(new ReferenceValidator("1234567890123456787", "1234567890123456787").getLengthReferenceNumber() > 3, false);
    }
    
    @Test
    public void TestLengthReferenceNumberLessThan20()
    {
    	
        assertEquals(new ReferenceValidator("123", "137").getLengthReferenceNumber() <20 , true);
        assertEquals(new ReferenceValidator("123456789012345678", "123456789012345678").getLengthReferenceNumber() <20, true);
        assertEquals(new ReferenceValidator("123", "123456789012345").getLengthReferenceNumber()<20 , true);
        assertEquals(new ReferenceValidator("1234567890123456787", "1234567890123456787").getLengthReferenceNumber() < 20, true);
    }
    
    
    @Test
    public void TestGroupOf5()
    {
    	
        assertEquals(groupOf5(new ReferenceValidator("123", "137")), true);
        assertEquals(groupOf5(new ReferenceValidator("123456789012345678", "123456789012345678")), true);
        assertEquals(groupOf5(new ReferenceValidator("123", "123456789012345")), false);
        assertEquals(groupOf5(new ReferenceValidator("1234567890123456787", "1234567890123456787")), false);
    }
    
    @Test
    public void TestNumberAndSpace()
    {
    	
        assertEquals(containNumberAndSpace(new ReferenceValidator("123", "137")), true);
        assertEquals(containNumberAndSpace(new ReferenceValidator("123456789012345678", "123456789012345678")), true);
        assertEquals(containNumberAndSpace(new ReferenceValidator("123", "123456789012345")), false);
        assertEquals(containNumberAndSpace(new ReferenceValidator("1234567890123456787", "1234567890123456787")), false);
    }
    
    @Test
    public void TestReferenceNumber()
    {
    	
        assertEquals(new ReferenceValidator("123", "137").getReferenceNumber() , "1232");
        assertEquals(new ReferenceValidator("123456789012345678", "123456789012345678").getReferenceNumber(), "1234 56789 01234 56781");
        assertEquals(new ReferenceValidator("123", "123456789012345").getReferenceNumber(), null);
        assertEquals(new ReferenceValidator("1234567890123456787", "1234567890123456787").getReferenceNumber(), null);
    }
}

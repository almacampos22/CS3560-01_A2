/**
 * 	@author Alma Campos
 * 	CS3560-01
 * 	Assignment 2
 */


public class SystemEntry {
	
	private String displayName;
	
	public SystemEntry()
	{
		
	}

	public SystemEntry(String id)
	{
		displayName = id;
	}
	
	public void setDisplayName(String id)
	{
	    displayName = id;	
	}
	public String getDisplayName() 
	{
		return displayName;
	}
	
	public String toString()
	{
		return getDisplayName();
	}
	
}

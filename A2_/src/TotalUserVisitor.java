/**
 * 	@author Alma Campos
 * 	CS3560-01
 * 	Assignment 2
 */


public class TotalUserVisitor implements AdminVisitor{

	@Override
	public int visitAdminControlPanel(AdminControlPanel instance) {
		
		return instance.getUserTotal();
	}

}

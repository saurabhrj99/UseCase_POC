package com.incture.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Session Bean implementation class InvokeBudgetServiceBean
 */
@Stateless
@LocalBean
public class InvokeBudgetServiceBean implements InvokeBudgetServiceBeanLocal {

    /**
     * Default constructor. 
     */
    public InvokeBudgetServiceBean() {
        // TODO Auto-generated constructor stub
    }

    private static final String PERSISTENCE_UNIT_NAME = "PurchaseOrderEJB";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	EntityManager em = factory.createEntityManager();

	/*//INVOKE AS WebService
	public String validateBudget(Integer availableBudget, Integer calculatedAmount) {
		return validateWithinBudget(availableBudget, calculatedAmount);
	}*/
    
}

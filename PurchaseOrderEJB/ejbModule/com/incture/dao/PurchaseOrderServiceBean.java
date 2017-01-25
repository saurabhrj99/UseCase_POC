package com.incture.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.incture.dto.HeaderDto;
import com.incture.dto.ItemDto;
import com.incture.entity.HeaderDo;
import com.incture.entity.ItemDo;

/**
 * Session Bean implementation class PurchaseOrderServiceBean
 */
@Stateless
@LocalBean
public class PurchaseOrderServiceBean implements PurchaseOrderServiceBeanLocal {

    /**
     * Default constructor. 
     */
    public PurchaseOrderServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    private static final String PERSISTENCE_UNIT_NAME = "PurchaseOrderEJB";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	EntityManager em = factory.createEntityManager();

    
    @SuppressWarnings("rawtypes")
	public void createPurchaseOrder(HeaderDto headerDto) {

    	HeaderDo headerDo = new HeaderDo();
    	ItemDo itemDo = new ItemDo();
    	
		try{
			if((headerDto.getRequestId()!= null)){
				headerDo.setRequestId(headerDto.getRequestId());
			}
			headerDo.setVendorId(headerDto.getVendorId());
			headerDo.setPurchaseOrganization(headerDto.getPurchaseOrganization());
			headerDo.setPlant(headerDto.getPlant());
			headerDo.setAvailableBudget(headerDto.getAvailableBudget());
			headerDo.setCreatedBy(headerDto.getCreatedBy());
			headerDo.setCreatedOn(headerDto.getCreatedOn());
			//headerDo.setPurchaseOrderNo(headerDto.getPurchaseOrderNo());
			
			for (Iterator iterator = headerDto.getItemDtos().iterator(); iterator.hasNext();) {
				
				ItemDto itemDto = (ItemDto) iterator.next();
				
				itemDo.setItemNo(itemDto.getItemNo());
				itemDo.setMaterialNo(itemDto.getMaterialNo());
				itemDo.setMaterialDesc(itemDto.getMaterialDesc());
				itemDo.setCost(itemDto.getCost());
				itemDo.setUnit(itemDto.getUnit());
				itemDo.setTotalCost(itemDto.getTotalCost());
				itemDo.setRequestId(itemDto.getRequestId());
				
			}
			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(headerDo);
			em.persist(itemDo);
			tx.commit();
			
		}catch(Exception e){
			System.out.println("Exception :- "+ e.getMessage());
		}
	}
    
    @SuppressWarnings("unchecked")
	public HeaderDto getPurchaseOrder(String requestId) {
    	
		HeaderDto hdto = new HeaderDto();
		List<ItemDto> idtos = new ArrayList<ItemDto>();

		Query q = em.createQuery("SELECT h FROM HeaderDo h WHERE h.requestId=?1");
		q.setParameter(1, requestId);
		
		Query q1 = em.createQuery("SELECT i FROM ItemDo i WHERE i.requestId=?1");
		q1.setParameter(1, requestId);
		
		List<HeaderDo> list = q.getResultList();
		for (HeaderDo hdo : list) {
			
			hdto.setVendorId(hdo.getVendorId());
			hdto.setPurchaseOrganization(hdo.getPurchaseOrganization());
			hdto.setPlant(hdo.getPlant());
			hdto.setAvailableBudget(hdo.getAvailableBudget());
			hdto.setCreatedBy(hdo.getCreatedBy());
			hdto.setCreatedOn(hdo.getCreatedOn());
			//hdto.setPurchaseOrderNo(hdo.getPurchaseOrderNo());
		}
		
		List<ItemDo> list1 = q1.getResultList();
		for (ItemDo ido : list1) {
			
			ItemDto idto = new ItemDto();
			
			idto.setItemNo(ido.getItemNo());
			idto.setMaterialNo(ido.getMaterialNo());
			idto.setMaterialDesc(ido.getMaterialDesc());
			idto.setCost(ido.getCost());
			idto.setUnit(ido.getUnit());
			idto.setTotalCost(ido.getTotalCost());
			idto.setRequestId(ido.getRequestId());
			
			idtos.add(idto);
		}
		hdto.setItemDtos(idtos);
		
		return hdto;
	}
    
    @SuppressWarnings("unchecked")
	public Integer calculatingPoTotalAmount(String requestId) {
    	
		Integer calculatedAmount;
		Integer cost=0;
		Integer unit=0;
		
		Query q = em.createQuery("SELECT i.cost, sum(i.unit) FROM ItemDo i WHERE i.requestId=?1");
		q.setParameter(1, requestId);
		
		List<ItemDo> list = q.getResultList();
		for (ItemDo ido : list) {
			
			unit = ido.getUnit();
			cost = ido.getCost();
		}
		
		calculatedAmount = cost*unit;
		return calculatedAmount;
	}
    
    
    
    
    
    public int updatePONumber(String requestId) {

		int numOfRowsAffected = 0;
		
		String poNumber = null;
		
		Query q = em.createQuery("UPDATE HeaderDo h SET h.purchaseOrderNo=?2 WHERE h.requestId=?1");
		q.setParameter(1, requestId);
		q.setParameter(2, poNumber);
		
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			numOfRowsAffected = q.executeUpdate();
			tx.commit();
			
		}catch(Exception e){
			System.out.println("Exception:- "+ e.getMessage());
		}
		
		return numOfRowsAffected;
	}
    

}

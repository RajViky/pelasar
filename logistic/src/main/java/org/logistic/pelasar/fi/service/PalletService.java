package org.logistic.pelasar.fi.service;

import org.logistic.pelasar.fi.dao.PalletDao;
import org.logistic.pelasar.fi.model.Pallet;

public class PalletService {

	private PalletDao palletDao = new PalletDao();
	
	public PalletService(){
	}
	
	public Pallet addPallet(Pallet pallet) {
		palletDao.savePallet(pallet);		
		return palletDao.getPalletById(pallet.getId());
	}
	
	public Pallet updatePallet(Pallet pallet){
		if(pallet.getId() <= 0){
			return null;
		}
		palletDao.updatePallet(pallet);
		return pallet;
	}
	
	public void removePallet(long id)	{
		palletDao.removePallet(id);
	}
}

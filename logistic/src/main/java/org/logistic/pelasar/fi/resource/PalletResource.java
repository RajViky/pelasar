package org.logistic.pelasar.fi.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.logistic.pelasar.fi.dao.PalletDao;
import org.logistic.pelasar.fi.model.Pallet;
import org.logistic.pelasar.fi.service.PalletService;

@Path("/pallet")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PalletResource {
	
	private PalletDao palletDao = new PalletDao();
	PalletService palletService = new PalletService();
	
	@GET
	@Path("/{palletId}")
	public Pallet getPalletById(@PathParam("palletId") long id) {
		return palletDao.getPalletById(id);
	}
	
	@GET
	@Path("/all")
	public List<Pallet> getPallets() {
		return palletDao.getAllPallets();
	}
	
	@POST
	public Pallet postPallet(Pallet pallet) {
		return palletService.addPallet(pallet);
	}
	
	@PUT
	@Path("/{palletId}")
	public Pallet updatePallet(@PathParam("palletId") long id,Pallet pallet) {
		pallet.setId(id);
		return palletService.updatePallet(pallet);
	}
	
	@DELETE
	@Path("/{palletId}")
	public void deletePallet(@PathParam("palletId") long id) {
		palletService.removePallet(id);
	}
}
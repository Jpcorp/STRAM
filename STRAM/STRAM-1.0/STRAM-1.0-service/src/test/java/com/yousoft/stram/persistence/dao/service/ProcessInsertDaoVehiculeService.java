package com.yousoft.stram.persistence.dao.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.yousoft.stram.domain.BrandsVehicule;
import com.yousoft.stram.domain.ColorsVehicule;
import com.yousoft.stram.domain.DetailsOwners;
import com.yousoft.stram.domain.ModelsVehicule;
import com.yousoft.stram.domain.OwnersVehicule;
import com.yousoft.stram.domain.StatusVehicule;
import com.yousoft.stram.domain.TypesVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;
import com.yousoft.stram.service.utils.ApplicationUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/data-config.xml" })
public class ProcessInsertDaoVehiculeService {

	@Autowired
	BrandsVehiculeService brandsVehiculeService;
	
	@Autowired
	TypesVehiculeService typesVehiculeService;
	
	@Autowired
	ModelsVehiculeService modelsVehiculeService;
	
	@Autowired
	ColorsVehiculeService colorsVehiculeService;
	
	@Autowired
	StatusVehiculeService statusVehiculeService;
	
	@Autowired
	OwnersVehiculeService ownersVehiculeService;
	
	@Autowired(required=true)
	DetailsOwnersVehiculeService detailsOwnersVehiculeService;
	
	@Autowired
	VehiculeService vehiculeService;

	public Vehicule vehicule;

	@Before
	public void setUp() throws Exception {
		vehicule = new Vehicule();
		vehicule.setModelsVehicule(getModelsVehicule());
		vehicule.setColorsVehicule(getColorVehicule());
		vehicule.setStatusVehicule(getStatusVehicule());
		vehicule.setDetailsOwners(getDetailsOwners(vehicule));
		vehicule.setNmrChasis("KPS1503");
		vehicule.setNmrMotor("KSP1236945k");
		vehicule.setNmrPoliza("PLZ123456");
		vehicule.setPatente("DX-CH-94");
		vehicule.setPvr("PVR");
		vehicule.setVenPoliza(ApplicationUtils.convertStringToDate(new Date()));
		vehicule.setCombustible("Bencina");
		vehicule.setYear("2015");
	}

	@After
	public void tearDown() throws Exception {

	}

	private DetailsOwners getDetailsOwners(Vehicule vehicule) {
		DetailsOwners result = new DetailsOwners();
		result.setCdgPatente(vehicule.getPatente());
		result.setFechAdquisicion(new Date());
		result.setNmro(123456789);
		result.setRepertorio("repertorio1");
		result.setOwnersVehicule(getOwnersVehicule());
		return result;
	}

	private OwnersVehicule getOwnersVehicule() {
		OwnersVehicule result = new OwnersVehicule();
		result.setRun("16743635-8");
		result.setComuna("Maipu");
		result.setDireccion("Direccion");
		result.setName("Juan Pablo Guinart");
		result.setNmroDireccion(381);
		result.setPhone("+56983790532");
		result.setRegion("RM");
		result.setTlfHouse("56223175869");
		return result;
	}

	private StatusVehicule getStatusVehicule() {
		StatusVehicule result = new StatusVehicule();
		result.setName("INGRESADO_STRAM");
		return result;
	}

	private ColorsVehicule getColorVehicule() {
		ColorsVehicule result = new ColorsVehicule();
		result.setName("Plomo grafito");
		return result;
	}

	private ModelsVehicule getModelsVehicule() {
		ModelsVehicule modelsVehicule = new ModelsVehicule();
		modelsVehicule.setName("RIO 5");
		modelsVehicule.setBrandsVehicule(getBrandsVehicule());
		modelsVehicule.setTypesVehicule(getTypesVehicule());
		return modelsVehicule;
	}

	private TypesVehicule getTypesVehicule() {
		TypesVehicule result = new TypesVehicule();
		result.setName("Automovil");
		result.setFechEntry(new Date());
		return result;
	}

	private BrandsVehicule getBrandsVehicule() {
		BrandsVehicule result = new BrandsVehicule();
		result.setName("KIA");
		return result;
	}

	@Test
	public void insertVehiculeByService() {
		BrandsVehicule brandsVehicule;
		TypesVehicule  typesVehicule;
		ModelsVehicule modelsVehicule;
		ColorsVehicule colorsVehicule;
		StatusVehicule statusVehicule;
		DetailsOwners detailsOwners;
		OwnersVehicule ownersVehicule;
		try {
			brandsVehicule = brandsVehiculeService.getBrandsVehiculeByName(vehicule);
			
			typesVehicule = typesVehiculeService.getTypesVehiculeByName(vehicule);
			
			modelsVehicule = modelsVehiculeService.getModelsVehiculeByName(vehicule);
			modelsVehicule.setBrandsVehicule(brandsVehicule);
			modelsVehicule.setTypesVehicule(typesVehicule);
			vehicule.setModelsVehicule(modelsVehicule);
			
			colorsVehicule = colorsVehiculeService.getColorsVehiculeByName(vehicule);
			vehicule.setColorsVehicule(colorsVehicule);
			
			statusVehicule = statusVehiculeService.getStatusById(vehicule);
			vehicule.setStatusVehicule(statusVehicule);
			
			detailsOwners = detailsOwnersVehiculeService.findByRun(vehicule);
			ownersVehicule = ownersVehiculeService.getOwnersVehiculeByRun(vehicule);
			
			detailsOwners.setOwnersVehicule(ownersVehicule);
			vehicule.setDetailsOwners(detailsOwners);
			
			vehicule = vehiculeService.getVehiculePatente(vehicule);
						
			
		} catch (StramException e) {
			e.printStackTrace();
		}

		assertNotNull(vehicule);
	}

}

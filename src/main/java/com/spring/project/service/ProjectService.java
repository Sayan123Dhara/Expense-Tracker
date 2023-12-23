package com.spring.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.dao.AccSaleRepository;
import com.spring.project.dao.CourierRepo;
import com.spring.project.dao.EMIRepo;
import com.spring.project.dao.ExpensesRepo;
import com.spring.project.dao.PhoneSaleRepository;
import com.spring.project.dao.UserRepository;
import com.spring.project.entity.AccSale;
import com.spring.project.entity.Courier;
import com.spring.project.entity.EMI;
import com.spring.project.entity.Expenses;
import com.spring.project.entity.Phonesale;

@Service
public class ProjectService {

    private final AccSaleRepository accSaleRepository;
    private final CourierRepo courierRepo;
    private final EMIRepo emiRepo;
    private final PhoneSaleRepository phoneSaleRepository;
    private final ExpensesRepo expensesRepo;
    private final UserRepository userRepository;
    

    @Autowired
    public ProjectService(
            AccSaleRepository accSaleRepository,
            CourierRepo courierRepo,
            EMIRepo emiRepo,
            PhoneSaleRepository phoneSaleRepository,
            ExpensesRepo expensesRepo,
            UserRepository userRepository
    ) {
        this.accSaleRepository = accSaleRepository;
        this.courierRepo = courierRepo;
        this.emiRepo = emiRepo;
        this.phoneSaleRepository = phoneSaleRepository;
        this.expensesRepo = expensesRepo;
        this.userRepository = userRepository;
    }
    

    public void addAccSale(AccSale accSale) {
        accSaleRepository.save(accSale);
    }

    public void addPhoneSale(Phonesale phoneSale) {
        phoneSaleRepository.save(phoneSale);
    }

    public void addCourier(Courier courier) {
        courierRepo.save(courier);
    }

    public void addEMI(EMI emi) {
        emiRepo.save(emi);
    }

    public void addExpenses(Expenses expenses) {
        expensesRepo.save(expenses);
    }

    

    public List<Courier> getCouriersfilter(String userId) {
        // Assuming Courier entity has a username field
        return courierRepo.findByUsername(userId);
    }
    
    public List<Courier> getCouriers() {
        // Assuming Courier entity has a username field
        return courierRepo.findAll();
    }
    

    

    public List<Expenses> getExpenses() {
        return expensesRepo.findAll();
    }



	public List<EMI> getEMI() {
		// TODO Auto-generated method stub
		return emiRepo.findAll();
	}


	public List<Phonesale> getPhoneSales(String userId) {
		// TODO Auto-generated method stub
		return phoneSaleRepository.findByUsername(userId);
	}


	public List<Phonesale> getPhoneSales() {
		// TODO Auto-generated method stub
		return phoneSaleRepository.findAll();
	}


	public List<AccSale> getAccSalesByUserId(String userId) {
		// TODO Auto-generated method stub
		return accSaleRepository.findByUsername(userId);
	}


	public List<AccSale> getAccSales() {
		// TODO Auto-generated method stub
		return accSaleRepository.findAll();
	}


	public List<Expenses> getExpenses(String userId) {
		// TODO Auto-generated method stub
		return expensesRepo.findByUsername(userId);
	}


	public List<EMI> getEMIs(String userId) {
		// TODO Auto-generated method stub
		return emiRepo.findByUsername(userId);
	}
	
	
	
	
		
}

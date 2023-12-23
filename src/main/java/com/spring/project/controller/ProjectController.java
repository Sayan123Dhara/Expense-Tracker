package com.spring.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.auth.Role;
import com.spring.auth.User;
import com.spring.config.UserInfoUserDetails;
import com.spring.project.dao.UserRepository;
import com.spring.project.entity.AccSale;
import com.spring.project.entity.Courier;
import com.spring.project.entity.EMI;
import com.spring.project.entity.Expenses;
import com.spring.project.entity.Phonesale;
import com.spring.project.service.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	

	@Autowired
	private UserRepository userRepository;
	

	@PostMapping("/accsales")
    public ResponseEntity<String> addAccSale(@RequestBody AccSale accSale,
            @AuthenticationPrincipal UserInfoUserDetails userDetails) {
        String name = userDetails.getUsername();
        Optional<User> user = userRepository.findByUserName(name);

        // Anyone can add data
        accSale.setUser(name);
        projectService.addAccSale(accSale);
        return new ResponseEntity<>("AccSale added successfully", HttpStatus.CREATED);
    }
	
	@PostMapping("/phonesales")
    public ResponseEntity<String> addPhoneSale(@RequestBody Phonesale phoneSale,
            @AuthenticationPrincipal UserInfoUserDetails userDetails) {
        String name = userDetails.getUsername();
        Optional<User> user = userRepository.findByUserName(name);

        // Anyone can add data
        phoneSale.setUser(name);
        projectService.addPhoneSale(phoneSale);
        return new ResponseEntity<>("PhoneSale added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/couriers")
    public ResponseEntity<String> addCourier(@RequestBody Courier courier,
            @AuthenticationPrincipal UserInfoUserDetails userDetails) {
        String name = userDetails.getUsername();
        Optional<User> user = userRepository.findByUserName(name);

        // Anyone can add data
        courier.setUser(name);
        projectService.addCourier(courier);
        return new ResponseEntity<>("Courier added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/emis")
    public ResponseEntity<String> addEMI(@RequestBody EMI emi,
            @AuthenticationPrincipal UserInfoUserDetails userDetails) {
        String name = userDetails.getUsername();
        Optional<User> user = userRepository.findByUserName(name);

        // Anyone can add data
        emi.setUser(name);
        projectService.addEMI(emi);
        return new ResponseEntity<>("EMI added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/expenses")
    public ResponseEntity<String> addExpenses(@RequestBody Expenses expenses,
            @AuthenticationPrincipal UserInfoUserDetails userDetails) {
        String name = userDetails.getUsername();
        Optional<User> user = userRepository.findByUserName(name);

        // Anyone can add data
        expenses.setUser(name);
        projectService.addExpenses(expenses);
        return new ResponseEntity<>("Expenses added successfully", HttpStatus.CREATED);
    }

    // GET mappings
    @GetMapping("/accsales")
    public ResponseEntity<List<AccSale>> getAccSales(
            @AuthenticationPrincipal UserInfoUserDetails userDetails) {
        String name = userDetails.getUsername();
        Optional<User> user = userRepository.findByUserName(name);

        // Check user role
        if (user.isPresent()) {
            Role userRole = user.get().getRole();
            List<AccSale> accSales;

            if (userRole == Role.CASHIER || userRole == Role.MANAGER) {
                // Cashier and Manager can only get their own data
                accSales = projectService.getAccSalesByUserId(user.get().getUserId());
            } else {
                // Owner can get all data
                accSales = projectService.getAccSales();
            }

            return new ResponseEntity<>(accSales, HttpStatus.OK);
        } else {
            // Unauthorized access
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
    @GetMapping("/phonesales")
    public ResponseEntity<List<Phonesale>> getPhoneSales(
            @AuthenticationPrincipal UserInfoUserDetails userDetails) {
        String name = userDetails.getUsername();
        Optional<User> user = userRepository.findByUserName(name);

        // Check user role
        if (user.isPresent()) {
            Role userRole = user.get().getRole();
            List<Phonesale> phoneSales;

            if (userRole == Role.CASHIER || userRole == Role.MANAGER) {
                // Cashier and Manager can only get their own data
                phoneSales = projectService.getPhoneSales(user.get().getUserId());
            } else {
                // Owner can get all data
                phoneSales = projectService.getPhoneSales();
            }

            return new ResponseEntity<>(phoneSales, HttpStatus.OK);
        } else {
            // Unauthorized access
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/couriers")
    public ResponseEntity<List<Courier>> getCouriers(
            @AuthenticationPrincipal UserInfoUserDetails userDetails) {
        String name = userDetails.getUsername();
        Optional<User> user = userRepository.findByUserName(name);

        // Check user role
        if (user.isPresent()) {
            Role userRole = user.get().getRole();
            List<Courier> couriers;

            if (userRole == Role.CASHIER || userRole == Role.MANAGER) {
                // Cashier and Manager can only get their own data
                couriers = projectService.getCouriersfilter(user.get().getUserId());
            } else {
                // Owner can get all data
                couriers = projectService.getCouriers();
            }

            return new ResponseEntity<>(couriers, HttpStatus.OK);
        } else {
            // Unauthorized access
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/emis")
    public ResponseEntity<List<EMI>> getEMIs(
            @AuthenticationPrincipal UserInfoUserDetails userDetails) {
        String name = userDetails.getUsername();
        Optional<User> user = userRepository.findByUserName(name);

        // Check user role
        if (user.isPresent()) {
            Role userRole = user.get().getRole();
            List<EMI> emis;

            if (userRole == Role.CASHIER || userRole == Role.MANAGER) {
                // Cashier and Manager can only get their own data
                emis = projectService.getEMIs(user.get().getUserId());
            } else {
                // Owner can get all data
                emis = projectService.getEMI();
            }

            return new ResponseEntity<>(emis, HttpStatus.OK);
        } else {
            // Unauthorized access
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
    
    
    

    @GetMapping("/expenses")
    public ResponseEntity<List<Expenses>> getExpenses(
            @AuthenticationPrincipal UserInfoUserDetails userDetails) {
        String name = userDetails.getUsername();
        Optional<User> user = userRepository.findByUserName(name);

        // Check user role
        if (user.isPresent()) {
            Role userRole = user.get().getRole();
            List<Expenses> expensesList;

            if (userRole == Role.CASHIER || userRole == Role.MANAGER) {
                // Cashier and Manager can only get their own data
                expensesList = projectService.getExpenses(user.get().getUserId());
            } else {
                // Owner can get all data
                expensesList = projectService.getExpenses();
            }

            return new ResponseEntity<>(expensesList, HttpStatus.OK);
        } else {
            // Unauthorized access
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}

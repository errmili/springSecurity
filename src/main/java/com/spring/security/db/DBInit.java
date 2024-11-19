package com.spring.security.db;


import com.spring.security.dao.AuthoritiesRepository;
import com.spring.security.dao.UserRepository;
import com.spring.security.model.Authorities;
import com.spring.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class DBInit implements CommandLineRunner {

    private UserRepository userRepository;

    private AuthoritiesRepository authoritiesRepository;

    private PasswordEncoder passwordEncoder;

    public DBInit() {
        // Constructeur par défaut requis par Spring
    }
    @Autowired
    public DBInit(UserRepository userRepository,AuthoritiesRepository authoritiesRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public DBInit(UserRepository userRepository, AuthoritiesRepository authoritiesRepository) {
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.userRepository.deleteAll();
//
//        User admin = new User();
//        admin.setUsername("ahmed");
//        admin.setPassword("ahmed123");
//        admin.setAge("20");
//        admin.setAddress("alex");
//        admin.setActive(1);
//
//        admin.setRoles(roleRepository.findAll());
//        admin.setAuthorities(authoritiesRepository.findAll());
//        userRepository.save(admin);
//        //////////////////////////////////////////////////////////////////////////////////////////////////////
//        User manager = new User();
//        manager.setUsername("yassir");
//        manager.setPassword("yassir123");
//        manager.setAge("29");
//        manager.setAddress("aswak");
//        manager.setActive(1);
//
//        Role managerRole1 = roleRepository.findById(2L).get();
//        Role managerRole2 = roleRepository.findById(3L).get();
//        //Authorities managerAuthorities1 = authoritiesRepository.findById(2L).get();
//        //Authorities managerAuthorities2 = authoritiesRepository.findById(3L).get();
//
//        manager.getRoles().add(managerRole1);
//        manager.getRoles().add(managerRole2);
//        //manager.getAuthorities().add(managerAuthorities1);
//        //manager.getAuthorities().add(managerAuthorities2);
//
//        userRepository.save(manager);
//
//// Création d'un autre utilisateur avec un rôle et une autorité
//        User user = new User();
//        user.setUsername("karim");
//        user.setPassword("karim123");
//        user.setAge("30");
//        user.setAddress("Ouj");
//        user.setActive(1);
//
//        Role userRole1 = roleRepository.findById(3L).get();
//        //Authorities userAuthorities1 = authoritiesRepository.findById(3L).get();
//
//        user.getRoles().add(userRole1);
//        //user.getAuthorities().add(userAuthorities1);
//
//        userRepository.save(user);
//    }




//    private PasswordEncoder passwordEncoder;
//
//    public DBInit(UserRepository userRepository, AuthoritiesRepository authoritiesRepository) {
//        this.userRepository = userRepository;
//        this.authoritiesRepository = authoritiesRepository;
//    }
//    @Override
//    public void run(String... args) throws Exception {
//        /*this.userRepository.deleteAll();
//        User admin = new User("ahmed",passwordEncoder.encode("ahmed123"),"20","alex",1);
//        admin.setAuthorities(this.authoritiesRepository.findAll());
//        userRepository.save(admin);
//        /////////////////////////////////////////////////////////////////////////
//        User manger = new User("yaser",passwordEncoder.encode("yaser123"),"20","alex",1);
//        Authorities mangerAuthorities1 = authoritiesRepository.findById(2L).get();
//        Authorities mangerAuthorities2 = authoritiesRepository.findById(3L).get();
//        Authorities mangerAuthorities3 = authoritiesRepository.findById(5L).get();
//        Authorities mangerAuthorities4 = authoritiesRepository.findById(6L).get();
//        manger.getAuthorities().add(mangerAuthorities1);
//        manger.getAuthorities().add(mangerAuthorities2);
//        manger.getAuthorities().add(mangerAuthorities3);
//        manger.getAuthorities().add(mangerAuthorities4);
//        userRepository.save(manger);
//        /////////////////////////////////////////////////////////////////////////
//        User user = new User("karim",passwordEncoder.encode("karim123"),"20","alex",1);
//        Authorities userAuthorities1 = authoritiesRepository.findById(3L).get();
//        Authorities userAuthorities2 = authoritiesRepository.findById(6L).get();
//        user.getAuthorities().add(userAuthorities2);
//        userRepository.save(user);*/

 /*       this.userRepository.deleteAll();

        //User admin = new User("ahmed", passwordEncoder.encode("ahmed123"), "20", "alex", 1);
        User admin = new User();
        admin.setUsername("ahmed");
        admin.setPassword(passwordEncoder.encode("ahmed123")); // Mot de passe encodé
        admin.setAge("20");
        admin.setAddress("alex");
        admin.setActive(1);
        admin.setAuthorities(this.authoritiesRepository.findAll());
        userRepository.save(admin);

        //User manger = new User("yaser",passwordEncoder.encode("yaser123"),"20","alex",1);
        // Initialisation avec un constructeur vide
        User manger = new User();

        // Définition des attributs avec les setters
        manger.setUsername("yaser");
        manger.setPassword(passwordEncoder.encode("yaser123")); // Mot de passe encodé
        manger.setAge("20");
        manger.setAddress("alex");
        manger.setActive(1);

        Authorities mangerAuthorities1 = authoritiesRepository.findById(2L).get();
        Authorities mangerAuthorities2 = authoritiesRepository.findById(3L).get();
        Authorities mangerAuthorities3 = authoritiesRepository.findById(5L).get();
        Authorities mangerAuthorities4 = authoritiesRepository.findById(6L).get();

        manger.getAuthorities().add(mangerAuthorities1);
        manger.getAuthorities().add(mangerAuthorities2);
        manger.getAuthorities().add(mangerAuthorities3);
        manger.getAuthorities().add(mangerAuthorities4);
        userRepository.save(manger);

        /////////////////////////////////////////////////////////////////////////

        //User user = new User("karim",passwordEncoder.encode("karim123"),"20","alex",1);
        // Initialisation avec un constructeur vide
        User user = new User();

        // Définition des attributs avec les setters
        user.setUsername("karim");
        user.setPassword(passwordEncoder.encode("karim123")); // Mot de passe encodé
        user.setAge("20");
        user.setAddress("alex");
        user.setActive(1);
        Authorities userAuthorities1 = authoritiesRepository.findById(3L).get();
        Authorities userAuthorities2 = authoritiesRepository.findById(6L).get();

        user.getAuthorities().add(userAuthorities2);
        user.getAuthorities().add(userAuthorities1);
        userRepository.save(user);*/
    }
}

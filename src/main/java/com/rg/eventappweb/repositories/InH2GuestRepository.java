//package com.rg.eventappweb.repositories;
//
//import com.rg.eventappweb.models.Guest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class InH2GuestRepository implements GuestRepository{
//
//    //@Autowired
//    private JpaGuestRepository repository;
//
//    @Override
//    public void save(Guest guest) {
//        repository.save(guest);
//    }
//
//    @Override
//    public Guest findById(String id) {
//        Optional<Guest> guest = repository.findById(id);
//        //TODO : THROW EXCEPTION IF GUEST NOT FOUND
//        return guest.orElse(new Guest());
//    }
//
//    @Override
//    public List<Guest> findAll() {
//        return null;
//    }
//}

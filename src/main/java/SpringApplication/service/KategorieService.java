package SpringApplication.service;

import SpringApplication.model.Kategorie;
import SpringApplication.repositories.KategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class KategorieService {

    @Autowired
    private KategorieRepository kategorieRepository;

    public Iterable<Kategorie> getAll () {
        return kategorieRepository.findAll();
    }

    public void addKategorie(Kategorie kategorie) {
        kategorieRepository.save(kategorie);
    }

}

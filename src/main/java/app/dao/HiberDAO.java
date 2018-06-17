package app.dao;

import app.models.Footwear;
import app.models.Headwear;
import app.models.Outerwear;
import app.models.Underwear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Random;

@Repository
public class HiberDAO {

    @PersistenceContext
    EntityManager em;

    private Random r = new Random();
    private String lastStatus;


    @Transactional
    public List<Headwear> getAllHeadwears(){
        List<Headwear> headwearList = em.createQuery("select h from Headwear h ",Headwear.class).getResultList();
        return headwearList;
    }
    @Transactional
    public Headwear addHeadwear(String color, String name){
         Headwear headwear = new Headwear(color, name);
         em.persist(headwear);
         return headwear;
    }


    @Transactional
    public List<Footwear> getAllFootwears(){
        List<Footwear> footwearList = em.createQuery("select f from Footwear f ",Footwear.class).getResultList();
        return footwearList;
    }
    @Transactional
    public Footwear addFootwear(String color, String name){
        Footwear footwear = new Footwear(color, name);
        em.persist(footwear);
        return footwear;
    }

    @Transactional
    public List<Outerwear> getAllOuterwears(){
        List<Outerwear> outerwearList = em.createQuery("select o from Outerwear o ",Outerwear.class).getResultList();
        return outerwearList;
    }
    @Transactional
    public Outerwear addOuterwear(String color, String name){
        Outerwear outerwear = new Outerwear(color, name);
        em.persist(outerwear);
        return outerwear;
    }

    @Transactional
    public List<Underwear> getAllUnderwears(){
        List<Underwear> underwearList = em.createQuery("select u from Underwear u ",Underwear.class).getResultList();
        return underwearList;
    }
    @Transactional
    public Underwear addUnderwear(String color, String name){
        Underwear underwear = new Underwear(color, name);
        em.persist(underwear);
        return underwear;
    }

    @Transactional
    public void init(){
        Footwear footwear = new Footwear("Белые", "Кросовки");
        Headwear headwear = new Headwear("Белая", "Кепка");
        Outerwear outerwear = new Outerwear("Белая", "Блузка");
        Underwear underwear = new Underwear("Белые", "Шорты");

        em.persist(footwear);
        em.persist(headwear);
        em.persist(outerwear);
        em.persist(underwear);

        footwear = new Footwear("Черные", "Туфли");
        outerwear = new Outerwear("Черная", "Футболка");
        underwear = new Underwear("Черная", "Юбка");

        em.persist(footwear);
        em.persist(outerwear);
        em.persist(underwear);


    }


}

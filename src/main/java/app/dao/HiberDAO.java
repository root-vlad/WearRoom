package app.dao;

import app.models.*;
import app.service.Fashion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Inheritance;
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
    public UserWear getUser(String username){
        UserWear userWear = em.createQuery("select u from UserWear u where u.name=?1", UserWear.class)
                .setParameter(1,username)
                .getResultList()
                .get(0);
        return userWear;
    }

    @Transactional
    public List<Color> getAllColors(){
        List<Color> colorList = em.createQuery("select c from Color c", Color.class)
                .getResultList();
        return colorList;
    }
    @Transactional
    public Color addColor(String colorName){
        Color color = new Color(colorName);
        em.persist(color);
        return color;
    }

    @Transactional
    public List<Headwear> getAllHeadwears(){
        List<Headwear> headwearList = em.createQuery("select h from Headwear h ",Headwear.class)
                .getResultList();
        return headwearList;
    }
    public List<Headwear> getAllHeadwearsCurrentUser(String username) {
        UserWear userWear = getUser(username);
        List<Headwear> headwearList = em.createQuery("select h from Headwear h where h.user.id=?1",Headwear.class)
                .setParameter(1, userWear.getId())
                .getResultList();
        return headwearList;
    }
    @Transactional
    public Headwear addHeadwear(String color, String name, String username){
        UserWear userWear = getUser(username);
        Headwear headwear = new Headwear(color, name, userWear);
        userWear.addWears(headwear);
        em.persist(headwear);
        return headwear;
    }

    @Transactional
    public List<Footwear> getAllFootwears(){
        List<Footwear> footwearList = em.createQuery("select f from Footwear f ",Footwear.class).getResultList();
        return footwearList;
    }
    public List<Footwear> getAllFootwearsCurrentUser(String username) {
        UserWear userWear = getUser(username);
        List<Footwear> footwearList = em.createQuery("select f from Footwear f where f.user.id=?1",Footwear.class)
                .setParameter(1, userWear.getId())
                .getResultList();
        return footwearList;
    }
    @Transactional
    public Footwear addFootwear(String color, String name, String username){
        UserWear userWear = getUser(username);
        Footwear footwear = new Footwear(color, name, userWear);
        userWear.addWears(footwear);
        em.persist(footwear);
        return footwear;
    }

    @Transactional
    public List<Outerwear> getAllOuterwears(){
        List<Outerwear> outerwearList = em.createQuery("select o from Outerwear o ",Outerwear.class).getResultList();
        return outerwearList;
    }
    public List<Outerwear> getAllOuterwearsCurrentUser(String username) {
        UserWear userWear = getUser(username);
        List<Outerwear> outerwearList = em.createQuery("select o from Outerwear o where o.user.id=?1",Outerwear.class)
                .setParameter(1, userWear.getId())
                .getResultList();
        return outerwearList;
    }
    @Transactional
    public Outerwear addOuterwear(String color, String name, String username){
        UserWear userWear = getUser(username);
        Outerwear outerwear = new Outerwear(color, name, userWear);
        userWear.addWears(outerwear);
        em.persist(outerwear);
        return outerwear;
    }

    @Transactional
    public List<Underwear> getAllUnderwears(){
        List<Underwear> underwearList = em.createQuery("select u from Underwear u ",Underwear.class).getResultList();
        return underwearList;
    }
    public List<Underwear> getAllUnderwearsCurrentUser(String username) {
        UserWear userWear = getUser(username);
        List<Underwear> underwearList = em.createQuery("select u from Underwear u where u.user.id=?1",Underwear.class)
                .setParameter(1, userWear.getId())
                .getResultList();
        return underwearList;
    }
    @Transactional
    public Underwear addUnderwear(String color, String name, String username){
        UserWear userWear = getUser(username);
        Underwear underwear = new Underwear(color, name, userWear);
        userWear.addWears(underwear);
        em.persist(underwear);
        return underwear;
    }

    @Transactional
    public void init(){
//        Wear footwear = new Footwear("Белые", "Кросовки");
//        Wear headwear = new Headwear("Белая", "Кепка");
//        Wear outerwear = new Outerwear("Белая", "Блузка");
//        Wear underwear = new Underwear("Белые", "Шорты");

//        em.persist(new UserWear("admin"));
//        em.persist(new UserWear("user1"));
//        em.persist(new UserWear("user2"));


        Fashion fashion = new Fashion();
        fashion.getFashionColors().forEach(color -> em.persist(color));

//        em.persist(footwear);
//        em.persist(headwear);
//        em.persist(outerwear);
//        em.persist(underwear);


//
//        footwear = new Footwear("Черные", "Туфли");
//        outerwear = new Outerwear("Черная", "Футболка");
//        underwear = new Underwear("Черная", "Юбка");
////
//        em.persist(footwear);
//        em.persist(outerwear);
//        em.persist(underwear);
    }


}

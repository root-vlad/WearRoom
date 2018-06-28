package app.service;

import app.dao.HiberDAO;
import app.models.Footwear;
import app.models.Headwear;
import app.models.Outerwear;
import app.models.Underwear;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.HttpURLConnection.*;
import java.util.stream.Collectors;

public class Fashion {

    static Logger logger = LoggerFactory.getLogger(Fashion.class);
//    private final Pattern pattern = Pattern.compile("(\\d Модный )(\\S+)(цвет: )");

    public Set<String> getFashionColors(){
       // if (true) return Collections.singleton("желтый");
        String url = "https://lookcolor.ru/cvet-v-mode/modnye-cveta-vesna-leto-2018/";
        Pattern pattern = Pattern.compile("(.*Модный )(\\S+)( цвет: .*)");
        Matcher matcher;
        Set<String> fashionColors = new HashSet<String>();
        try {
            URL myUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                matcher = pattern.matcher(inputLine);
                if (matcher.find()){
                    System.out.println(matcher.group(2));
                    fashionColors.add(matcher.group(2));
                }
            }
            in.close();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
           // e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
            //e.printStackTrace();
        }
        return fashionColors;
    }

//    public static void main(String[] args) {
//        getFashionColors();
//
//    }

    public List<Footwear> getFashionFootwears(HiberDAO dao) {
        List<Footwear> fashionFootwears = dao.getAllFootwears();
        logger.info("Getting colors (HTTP)...");
        Set<String> fashionColors = getFashionColors();
        logger.info(fashionColors.toString());
        //logger.info(fashionFootwears.toString());
        fashionFootwears =  fashionFootwears.
                stream().
//                filter(footwear -> fashionColors.contains(footwear.getColor())).
                filter(footwear -> fashionColors.contains(footwear.getColor())).
                collect(Collectors.toList());
        return fashionFootwears;
//        return dao.getAllFootwears().
//                stream().
//                filter(footwear -> getFashionColors().contains(footwear.getColor())).
//                collect(Collectors.toList());
    }

    public List<Headwear> getFashionHeadwears(HiberDAO dao) {
        List<Headwear> fashionHeadwears = dao.getAllHeadwears();
        Set<String> fashionColors = getFashionColors();
        return fashionHeadwears.
                stream().
                filter(headwear -> fashionColors.contains(headwear.getColor())).
                collect(Collectors.toList());
    }

    public List<Outerwear> getFashionOuterwears(HiberDAO dao) {
        List<Outerwear> fashionOuterwears = dao.getAllOuterwears();
        return fashionOuterwears.
                stream().
                filter(outerwear -> getFashionColors().contains(outerwear.getColor())).
                collect(Collectors.toList());
    }

    public List<Underwear> getFashionUnderwears(HiberDAO dao) {
        return dao.getAllUnderwears().
                stream().
                filter(underwear -> getFashionColors().contains(underwear.getColor())).
                collect(Collectors.toList());
    }
}

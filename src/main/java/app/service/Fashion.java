package app.service;

import app.dao.HiberDAO;
import app.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public List<Footwear> getFashionFootwears(HiberDAO dao, String username) {
        List<Footwear> fashionFootwears = dao.getAllFootwearsCurrentUser(username);
        Set<Color> fashionColors = new HashSet<>();
        Set<String> fashionColorNames = new HashSet<>();
        fashionColors.addAll(dao.getAllColors());
        fashionColors.forEach(fashionColor -> {
            fashionColorNames.add(fashionColor.getColor());
        });
        fashionFootwears =  fashionFootwears.
                stream().
                filter(footwear -> fashionColorNames.contains(footwear.getColor())).
                collect(Collectors.toList());
        return fashionFootwears;
    }

    public List<Headwear> getFashionHeadwears(HiberDAO dao, String username) {
        List<Headwear> fashionHeadwears = dao.getAllHeadwearsCurrentUser(username);
        Set<Color> fashionColors = new HashSet<>();
        fashionColors.addAll(dao.getAllColors());
        Set<String> fashionColorNames = new HashSet<>();
        fashionColors.forEach(fashionColor -> {
            fashionColorNames.add(fashionColor.getColor());
        });
        return fashionHeadwears.
                stream().
                filter(headwear -> fashionColorNames.contains(headwear.getColor())).
                collect(Collectors.toList());
    }

    public List<Outerwear> getFashionOuterwears(HiberDAO dao, String username) {
        List<Outerwear> fashionOuterwears = dao.getAllOuterwearsCurrentUser(username);
        Set<Color> fashionColors = new HashSet<>();
        Set<String> fashionColorNames = new HashSet<>();
        fashionColors.addAll(dao.getAllColors());
        fashionColors.forEach(fashionColor -> {
            fashionColorNames.add(fashionColor.getColor());
        });
        return fashionOuterwears.
                stream().
                filter(outerwear -> fashionColorNames.
                        contains(outerwear.getColor())).
                collect(Collectors.toList());
    }

    public List<Underwear> getFashionUnderwears(HiberDAO dao, String username) {
        Set<Color> fashionColors = new HashSet<>();
        Set<String> fashionColorNames = new HashSet<>();
        fashionColors.addAll(dao.getAllColors());
        fashionColors.forEach(fashionColor -> {
            fashionColorNames.add(fashionColor.getColor());
        });
        return dao.getAllUnderwearsCurrentUser(username).
                stream().
                filter(underwear -> fashionColorNames.contains(underwear.getColor())).
                collect(Collectors.toList());
    }
}

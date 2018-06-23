package app.service;

import app.dao.HiberDAO;
import app.models.Footwear;
import app.models.Headwear;
import app.models.Outerwear;
import app.models.Underwear;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.HttpURLConnection.*;
import java.util.stream.Collectors;

public class Fashion {
//    private final String url = "https://lookcolor.ru/cvet-v-mode/modnye-cveta-vesna-leto-2018/";
//    private final Pattern pattern = Pattern.compile("(\\d Модный )(\\S+)(цвет: )");

    public Set<String> getFashionColors(){
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
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fashionColors;
    }

//    public static void main(String[] args) {
//        getFashionColors();
//
//    }

    public List<Footwear> getFashionFootwears(HiberDAO dao) {
        List<Footwear> fashionFootwears = dao.getAllFootwears();
        Set<String> fashionColors = getFashionColors();
        fashionFootwears =  fashionFootwears.
                stream().
//                filter(footwear -> fashionColors.contains(footwear.getColor())).
                filter(footwear -> fashionColors.contains("желтый")).
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

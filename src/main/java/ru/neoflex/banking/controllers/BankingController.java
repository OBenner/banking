package ru.neoflex.banking.controllers;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import jdk.nashorn.api.scripting.URLReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.neoflex.banking.model.Currency;
import ru.neoflex.banking.model.User;
import ru.neoflex.banking.service.SpringSecurityUserContext;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class BankingController {


    @Autowired
    JdbcUserDetailsManager jdbcUserDetailsManager;
    @Autowired
    SpringSecurityUserContext context;
//	@RequestMapping("/")
//	public ModelAndView log() {
//		return new ModelAndView("redirect:/welcome");
//	}

    @RequestMapping("/")
    public String log() {
        return "index";
    }

    @RequestMapping("/welcome")
    public ModelAndView firstPage() {
        return new ModelAndView("welcome");
    }

    @RequestMapping("/accessdenied")
    public ModelAndView accessdenied() {
        return new ModelAndView("access-denied");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("registration", "user", new User());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView processRegister(@ModelAttribute("user") User userObject, Model model, String errors) {
        System.out.println("register");
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(userObject.getRole()));
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(userObject.getUsername(), userObject.getPassword(), authorities);
        jdbcUserDetailsManager.createUser(user);
        return new ModelAndView("redirect:/login");
    }


    @RequestMapping(value = "/info")
    public String userInfo(Model model) {

        User user = context.getCurrentUser();
        model.addAttribute("username", user.getUsername());
        model.addAttribute("phone", user.getPhone());
        model.addAttribute("email", user.getEmail());
        System.out.println("ALLOOOOOOO");
        System.out.println(user.getUsername());
        System.out.println(user.getPhone());
        System.out.println(user.getEmail());

        return "/info";
    }

    //	@RequestMapping("/login")
//	public String login(Model model, String error, String logout) {
//		System.out.println("Login in controller");
//		if (error != null)
//			model.addAttribute("errorMsg", "Your username and password are invalid.");
//
//		if (logout != null)
//			model.addAttribute("msg", "You have been logged out successfully.");
//
//		return "login";
//	}
//
    @RequestMapping("/logout")
    public ModelAndView logout() {
        return new ModelAndView("index");
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false)
                                String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {

        if (error != null) {
            model.addAttribute("error", "Invalid username and password");
        }

        if (logout != null) {
            model.addAttribute("msg", "You have been logged out successfully");
        }

        return "login";
    }


    @RequestMapping("/currency")
    public String getCurrencyList(Model model) throws IOException {


        ObjectReader mapper = new ObjectMapper().readerFor(JsonNode.class);
        JsonNode rootNode = mapper.readValue(new URLReader(new URL("https://www.cbr-xml-daily.ru/daily_json.js")));

        List<Currency> currencyList = new ArrayList<>();
        JsonNode nameNode = rootNode.get("Valute");
        for (JsonNode child : nameNode) {
            Currency currency = new Currency();
            currency.setСode(child.get("CharCode").asText());
            currency.setValue(child.get("Value").doubleValue());
            currency.setNominal(child.get("Nominal").asLong());
            currency.setName(child.get("Name").textValue());

            currencyList.add(currency);

        }

        //currencyList.forEach(l -> System.out.println(l));
        model.addAttribute(currencyList);
        return "currency";
    }
}

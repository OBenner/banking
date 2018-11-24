package ru.neoflex.banking.controllers;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import jdk.nashorn.api.scripting.URLReader;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.neoflex.banking.model.Account;
import ru.neoflex.banking.model.Currency;
import ru.neoflex.banking.model.CurrencyEnum;
import ru.neoflex.banking.model.User;
import ru.neoflex.banking.service.AccountService;
import ru.neoflex.banking.service.CurrencyService;
import ru.neoflex.banking.service.UserService;

import java.io.*;
import java.net.URL;
import java.util.*;

@Controller
public class BankingController {


    @Autowired
    JdbcUserDetailsManager jdbcUserDetailsManager;
    @Autowired
    UserService context;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private AccountService accountService;

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
        List<Account> accounts = accountService.getAccounts(user.getUsername());
        System.out.println(accounts);
        model.addAttribute("user", user);
        model.addAttribute("accounts", accounts);


        return "/info";
    }

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
    public String getCurrencyList(Model model) {
        List<Currency> currencyList = currencyService.getCurrencyFromApi();
        //currencyList.forEach(l -> System.out.println(l));
        model.addAttribute(currencyList);

        return "currency";
    }


    @RequestMapping(value = "/createAcc", method = RequestMethod.GET)
    public ModelAndView createAcc() {
        return new ModelAndView("createAcc", "accCode", CurrencyEnum.values());
    }

    @RequestMapping(value = "/createAcc", method = RequestMethod.POST)
    public ModelAndView processCreateAcc(@ModelAttribute("accCode") CurrencyEnum accCode, Model model, String errors) {
        User user = context.getCurrentUser();
        System.out.println("user " + user.getUsername());
        System.out.println("code " + accCode.name());
        accountService.createAccount(user.getUsername(), accCode.name());
        return new ModelAndView("redirect:/info");
    }

    //TODO
    @RequestMapping(value = "/buyCurrency", method = RequestMethod.GET)
    public ModelAndView buyCurrency() {
        List<Currency> currencyList = currencyService.getCurrencyFromApi();
        return new ModelAndView("createAcc", "accCode", CurrencyEnum.values());
    }

}

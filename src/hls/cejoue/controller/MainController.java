package hls.cejoue.controller;
import hls.cejoue.dto.*;
import hls.cejoue.model.Depense;
import hls.cejoue.model.Mtoken;
import hls.cejoue.model.Recette;
import hls.cejoue.model.User;
import hls.cejoue.service.*;
import hls.cejoue.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.tags.MessageTag;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by hossiel on 16/06/2016.
 */
@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    private MyUserDetailsService userService;

    @Autowired
    private DepenseService depenseService;

    @Autowired
    private RecetteService recetteService;
    @Autowired
    private DepenseAndRecetteService depenseAndRecetteService;

    @Autowired
    private MyMtokenDetailsService myMtokenDetailsService;

    @RequestMapping(value = "test")
    public ModelAndView  gotoHometest(@RequestParam(value ="m",defaultValue="mi", required = false) String m, @RequestParam(value ="test",defaultValue="hello", required = false) String test) {
        ModelAndView model= new ModelAndView();
        System.out.println(test);
        System.out.println(m);
        model.addObject("debug", " test = "+ test);
        if (test != null) {
            model.addObject("test", " non null!");
        }else {
            model.addObject("test", " null!");
        }
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "")
    public ModelAndView  gotoHome() {
        ModelAndView model= new ModelAndView();

        model.setViewName("redirect:/login");
        return model;
    }

    @RequestMapping(value = "login" ,method = RequestMethod.GET)
    public ModelAndView  gotoLogin(HttpServletResponse response, HttpServletRequest request, String fooCookie, @RequestParam(required = false, name ="msg" )String message1) {

        ModelAndView model= new ModelAndView();
        Cookie[] cookies = request.getCookies();
        Map<String,String> mappedCookies= Util.CookiestoMap(cookies);

        String message ="Veuillez vous connecter ";
        String target= "login";
        if(message1!=null) {
            if (message1.contentEquals("KO")) {
                message = "identifiants incorrects, veuillez essayer à nouveau";
            }
        }


        NewUserDto user = new NewUserDto();
        // set User default value
        user.setNom("");

        model.addObject("userForm", user);
        model.addObject("msg", message);
        model.setViewName(target);

        return model;
    }


    @RequestMapping(value = "login", method = { RequestMethod.POST })
    public ModelAndView  checkLogin(HttpServletResponse response, HttpServletRequest request,@ModelAttribute("userForm") NewUserDto user) {
        ModelAndView model= new ModelAndView();
        String message="";
        String target ="redirect:/login";
        NewUserDto user1 = null;
        String userID= "";
        String jsessionid= null;
        Cookie[] cookies = request.getCookies();
        MtokenDto mtokenDto=null;
        Mtoken mtoken=null;
        Map<String,String> mappedCookies= Util.CookiestoMap(cookies);
        if(userService.checkUser(user.getUsername(),user.getPassword())){
            target ="redirect:/add-recette";
            user1 =new NewUserDto( userService.findByUserName(user.getUsername()));
            if(mappedCookies!=null){
                if (mappedCookies.containsKey("JSESSIONID")){
                    jsessionid = mappedCookies.get("JSESSIONID");
                }
            }
            userID=user1.getUsername();
            mtoken= myMtokenDetailsService.createMtoken(userID,jsessionid);
            mtokenDto = new MtokenDto(mtoken);
            Cookie mtokenidCookie= new Cookie("MTOKENID",mtokenDto.getId());
            Cookie usernameCookie= new Cookie("USERNAME",mtokenDto.getUsername());
            response.addCookie(mtokenidCookie);
            response.addCookie(usernameCookie);
            message="OK";

        }
        else{
            message= "KO";

        }
        model.addObject("msg",message);
        model.addObject("userID",userID);
        model.setViewName(target);
        return model;
    }

// USER CONTROLLERS
    @RequestMapping(value = "addusers",method = RequestMethod.GET)
    public ModelAndView  gotouserform( )
    {


        ModelAndView model= new ModelAndView();


        NewUserDto user = new NewUserDto();
        // set User default value
        user.setNom("Dupuis");
        user.setPrenom("Jacques");
        user.setUsername("DupuisJacques82");
        user.setEmail("test@gmail.com");
        user.setPassword("mpd");
        user.setMatchingPassword("mpd");
        model.addObject("userForm", user);
        model.setViewName("addusers");

        return model;
    }

    @RequestMapping(value = "sendusers",method = { RequestMethod.POST })
    public ModelAndView  addUsers(@ModelAttribute("userForm")  NewUserDto sendeduser )
    {


        ModelAndView model= new ModelAndView();
        String message ="ok";
        // set default value
        message=sendeduser.getNom();
        User saveduser= userService.createUser(sendeduser);
        NewUserDto saveduserDto=new NewUserDto(saveduser);
        if(saveduser!=null) {
            model.addObject("userForm", saveduserDto);
            model.addObject("msg", message);
        } else
        {
            model.addObject("userForm", null);
            message ="Problème lors de la creation";
            model.addObject("msg", message);
        }
        model.setViewName("showuser");


        return model;
    }

    @RequestMapping(value = "showAllUsers")
    public ModelAndView  showAllUsers() {
        ModelAndView model= new ModelAndView();
        List<User> userlist= new ArrayList<>();
        String message ="ok";
        List<NewUserDto> userDtolist= new ArrayList<>();
        userlist=userService.getAllUsers();
        int i=0;
        if(userlist!=null) {
            for (i = 0; i < userlist.size(); i++) {
                userDtolist.add(new NewUserDto(userlist.get(i)));
            }
            model.addObject("userList", userDtolist);
            message=" Il y a "+userDtolist.size()+ " utilisateur(s) créé(s)";
        }else{
            userDtolist=null;
            message="Aucun utilisateur trouvé";

        }
        model.addObject("userList", userDtolist);
        model.addObject("msg", message);
        model.setViewName("showAllUsers");
        return model;
    }


    // DEPENSE CONTROLLERS
    @RequestMapping(value = "add-depense",method = RequestMethod.GET)
    public ModelAndView  gotodepenseform( HttpServletRequest request )
    {
        String message="";
        Cookie[] cookies = request.getCookies();
        DepenseDto depenseP = new DepenseDto();
        DepenseDto depenseM = new DepenseDto();
        DepenseDto depenseA = new DepenseDto();
        String target ="";
        String currentUser ="inconnue";
        ModelAndView model= new ModelAndView();
        Map<String, String> mappedCookies = Util.CookiestoMap(cookies);
        if (Util.cookieIsValid(cookies, myMtokenDetailsService, userService)){

            currentUser=userService.findByUserName(myMtokenDetailsService.findById(mappedCookies.get("MTOKENID")).getUsername()).getUsername();
            // set default value dépense Plantation
            depenseP.setType(DepenseDto.DPLANTATION);
            depenseP.setDateSoumission(new Date());
            depenseP.setRapporteur(currentUser);
            depenseP.setEmetteur(currentUser);
            depenseP.setMontant(0);
            depenseP.setCommentaire("RAS");

            // set default value dépense Maison
            depenseM.setType(DepenseDto.DMAISON);
            depenseM.setRapporteur(currentUser);
            depenseM.setDateSoumission(new Date());
            depenseM.setEmetteur(currentUser);
            depenseM.setMontant(0);
            depenseM.setCommentaire("RAS");


            // set default value dépense Autres
            depenseA.setType(DepenseDto.DAUTRES);
            depenseA.setRapporteur(currentUser);
            depenseA.setDateSoumission(new Date());
            depenseA.setEmetteur(currentUser);
            depenseA.setMontant(0);
            depenseA.setCommentaire("RAS");

            message="Bienvenue Mr "+currentUser+".";

            target="add-depense";

            model.addObject("depenseAForm",depenseA );
            model.addObject("depensePForm",depenseP );
            model.addObject("depenseMForm",depenseM );

        }else{
            message="KO";
            target="redirect:/login";
        }

        model.addObject("msg",message );

      //  model.setViewName("add-depense");
        model.setViewName(target);


        return model;
    }

    @RequestMapping(value = {"sendDepenseP"},method = { RequestMethod.POST })
    public ModelAndView  sendDepenseP (@ModelAttribute("depensePForm")  DepenseDto sendedDepense )
    {


        ModelAndView model= new ModelAndView();
        String message ="ok";

        message=""+sendedDepense.getId();
        Depense savedDepense= depenseService.createDepense(sendedDepense);
        DepenseDto savedDepenseDto=new DepenseDto(savedDepense);
        if(savedDepense!=null) {
            model.addObject("depenseForm", savedDepenseDto);
            model.addObject("msg", message);
        } else
        {
            model.addObject("depenseForm", null);
            message ="Problème lors de la creation";
            model.addObject("msg", message);
        }
        model.setViewName("showdepense");
        // send Depense Plantation
        return model;
    }

    @RequestMapping(value = {"sendDepenseM"},method = { RequestMethod.POST })
    public ModelAndView  sendDepenseR (@ModelAttribute("depenseMForm")  DepenseDto sendedDepense )
    {


        ModelAndView model= new ModelAndView();
        String message ="ok";
        message=""+sendedDepense.getId();
        Depense savedDepense= depenseService.createDepense(sendedDepense);
        DepenseDto savedDepenseDto=new DepenseDto(savedDepense);
        if(savedDepense!=null) {
            model.addObject("depenseForm", savedDepenseDto);
            model.addObject("msg", message);
        } else
        {
            model.addObject("depenseForm", null);
            message ="Problème lors de la creation";
            model.addObject("msg", message);
        }
        model.setViewName("showdepense");
// send depense Maison
        return model;
    }

    @RequestMapping(value = {"sendDepenseA"},method = { RequestMethod.POST })
    public ModelAndView  sendDepenseA (@ModelAttribute("depenseAForm")  DepenseDto sendedDepense )
    {


        ModelAndView model= new ModelAndView();
        String message ="ok";

        message=""+sendedDepense.getId();
        Depense savedDepense= depenseService.createDepense(sendedDepense);
        DepenseDto savedDepenseDto=new DepenseDto(savedDepense);
        if(savedDepense!=null) {
            model.addObject("depenseForm", savedDepenseDto);
            model.addObject("msg", message);
        } else
        {
            model.addObject("depenseForm", null);
            message ="Problème lors de la creation";
            model.addObject("msg", message);
        }
        model.setViewName("showdepense");
// send Depense Autres
        return model;
    }

    @RequestMapping(value = "showAllDepenses")
    public ModelAndView  showAllDepenses() {
        ModelAndView model= new ModelAndView();
        List<Depense> depenselist= new ArrayList<>();
        String message ="ok";
        List<DepenseDto> depenseDtolist= new ArrayList<>();
        depenselist=depenseService.getAllDepenses();
        int i=0;
        if(depenselist!=null) {
            for (i = 0; i < depenselist.size(); i++) {
                depenseDtolist.add(new DepenseDto(depenselist.get(i)));
            }
            model.addObject("depenseList", depenseDtolist);
            message=" Il y a "+depenseDtolist.size()+ " Depense(s) créée(s)";
        }else{
            depenseDtolist=null;
            message="Aucun depense trouvé";

        }
        model.addObject("depenseList", depenseDtolist);
        model.addObject("msg", message);
        model.setViewName("showAllDepenses");
        return model;
    }




    // RECETTE CONTROLLERS
    @RequestMapping(value = "add-recette",method = RequestMethod.GET)
    public ModelAndView  gotorecetteform(HttpServletRequest request)
    {


        String message="";
        Cookie[] cookies = request.getCookies();

        RecetteDto recetteC = new RecetteDto();
        RecetteDto recetteM = new RecetteDto();
        RecetteDto recetteA = new RecetteDto();
        String target ="";
        String currentUser ="";
        ModelAndView model= new ModelAndView();
        Map<String, String> mappedCookies = Util.CookiestoMap(cookies);
        if (Util.cookieIsValid(cookies, myMtokenDetailsService, userService)) {

            currentUser=userService.findByUserName(myMtokenDetailsService.findById(mappedCookies.get("MTOKENID")).getUsername()).getUsername();


            // set default value recette Coupe
            recetteC.setType(RecetteDto.RCOUPE);
            recetteC.setDateSoumission(new Date());
            recetteC.setRapporteur(currentUser);
            recetteC.setPercepteur(currentUser);
            recetteC.setEmetteur("Inconnu");

            recetteC.setRecetteBrut(0);
            ;
            recetteC.setRecetteNet(0);
            recetteC.setCharge(0);
            recetteC.setTonnage(0);
            recetteC.setCommentaire("RAS");


            // set default value dépense Maison
            recetteM.setType(RecetteDto.RLOYER);
            recetteM.setRapporteur(currentUser);
            recetteM.setPercepteur(currentUser);
            recetteM.setEmetteur("Inconnu");
            recetteM.setDateSoumission(new Date());
            recetteM.setRecetteBrut(0);
            ;
            recetteM.setRecetteNet(0);
            recetteM.setCharge(0);
            recetteM.setTonnage(0);
            recetteM.setCommentaire("RAS");

            // set default value dépense Autres
            recetteA.setType(RecetteDto.RAUTRES);
            recetteA.setRapporteur(currentUser);
            recetteA.setPercepteur(currentUser);
            recetteA.setEmetteur("Inconnu");
            recetteA.setDateSoumission(new Date());
            System.out.println(recetteA.getDateSoumission());


            recetteA.setRecetteBrut(0);
            recetteA.setRecetteNet(0);
            recetteA.setCharge(0);
            recetteA.setTonnage(0);
            recetteA.setCommentaire("RAS");


            model.addObject("recetteCForm", recetteC);
            model.addObject("recetteLForm", recetteM);
            model.addObject("recetteAForm", recetteA);
            target ="add-recette";
            message="Bienvenue Mr "+currentUser+".";
        }else{
            message="KO";
            target="redirect:/login";
        }
        model.addObject("msg",message );
        model.setViewName(target);


        return model;
    }

    @RequestMapping(value = {"/sendRecetteC"},method = { RequestMethod.POST })
    public ModelAndView  sendRecetteC(@ModelAttribute("recetteCForm")  RecetteDto sendedRecette )
    {


        ModelAndView model= new ModelAndView();
        String message ="ok";
        System.out.println(sendedRecette.getDateEffective());
        System.out.println(sendedRecette.getRecetteBrut());
        Recette savedRecette= recetteService.createRecette(sendedRecette);
        message=""+savedRecette.getId();
        RecetteDto savedRecetteDto=new RecetteDto(savedRecette);
        if(savedRecette!=null) {
            model.addObject("recetteForm", savedRecetteDto);
            model.addObject("msg", message);
        } else
        {
            model.addObject("recetteForm", null);
            message ="Problème lors de la creation";
            model.addObject("msg", message);
        }
        model.setViewName("showrecette");

        return model;
    }

    @RequestMapping(value = {"/sendRecetteL"},method = { RequestMethod.POST })
    public ModelAndView  sendRecetteM (@ModelAttribute("recetteLForm")  RecetteDto sendedRecette )
    {


        ModelAndView model= new ModelAndView();
        String message ="ok";
        System.out.println(sendedRecette.getDateEffective());
        Recette savedRecette= recetteService.createRecette(sendedRecette);
        message=""+savedRecette.getId();
        RecetteDto savedRecetteDto=new RecetteDto(savedRecette);
        if(savedRecette!=null) {
            model.addObject("recetteForm", savedRecetteDto);
            model.addObject("msg", message);
        } else
        {
            model.addObject("recetteForm", null);
            message ="Problème lors de la creation";
            model.addObject("msg", message);
        }
        model.setViewName("showrecette");

        return model;
    }

    @RequestMapping(value = {"sendRecetteA"},method = { RequestMethod.POST })
    public ModelAndView  sendRecetteA (@ModelAttribute("recetteAForm")  RecetteDto sendedRecette )
    {


        ModelAndView model= new ModelAndView();
        String message ="ok";
        System.out.println(sendedRecette.getDateEffective());
        Recette savedRecette= recetteService.createRecette(sendedRecette);
        message=""+savedRecette.getId();
        RecetteDto savedRecetteDto=new RecetteDto(savedRecette);
        if(savedRecette!=null) {
            model.addObject("recetteForm", savedRecetteDto);
            model.addObject("msg", message);
        } else
        {
            model.addObject("recetteForm", null);
            message ="Problème lors de la creation";
            model.addObject("msg", message);
        }
        model.setViewName("showrecette");

        return model;
    }

    @RequestMapping(value = "showAllRecettes")
    public ModelAndView  showAllRecettes() {
        ModelAndView model= new ModelAndView();
        List<Recette> recettelist= new ArrayList<>();
        String message ="ok";
        List<RecetteDto> recetteDtolist= new ArrayList<>();
        recettelist=recetteService.getAllRecettes();
        int i=0;
        if(recettelist!=null) {
            for (i = 0; i < recettelist.size(); i++) {
                recetteDtolist.add(new RecetteDto(recettelist.get(i)));
            }
            model.addObject("recetteList", recetteDtolist);
            message=" Il y a "+recetteDtolist.size()+ " Recette(s) créée(s)";
        }else{
            recetteDtolist=null;
            message="Aucun recette trouvé";

        }
        model.addObject("recetteList", recetteDtolist);
        model.addObject("msg", message);
        model.setViewName("showAllRecettes");
        return model;
    }

//  DEPENSES AND RECETTES CONTROLLERS

    @RequestMapping(value = "show60DepenseAndRecettes")
    public ModelAndView  showAllDepenseAndRecettes( HttpServletRequest request) {
        ModelAndView model= new ModelAndView();
        List<DepenseAndRecetteDto> recetteAndDepenseList= null;
        String message ="";
        String target ="";

        Cookie[] cookies = request.getCookies();
        if (Util.cookieIsValid(cookies, myMtokenDetailsService, userService)) {
            message = "Aucune recettes ni depense trouvée";
            recetteAndDepenseList = depenseAndRecetteService.get60();
            if (recetteAndDepenseList != null) {
                message = recetteAndDepenseList.size() + " élement(s) trouvé(s) et trié(s) par date de soummission (recettes et depenses confondues)";
                recetteAndDepenseList = DepenseAndRecetteDto.sortByCreationDate(recetteAndDepenseList);

            }
            target = "showALLDepenseAndRecettes";
            model.addObject("recetteAndDepenseList", recetteAndDepenseList);
        }else{
            message="KO";
            target="redirect:/login";
        }
        model.addObject("msg", message);
        model.setViewName(target);
        return model;
    }


    @RequestMapping(value = "logout")
    public ModelAndView  Logout(HttpServletResponse response) {
        ModelAndView model= new ModelAndView();
        Cookie mtokenidCookie= new Cookie("MTOKENID","");
        Cookie usernameCookie= new Cookie("USERNAME","");
        response.addCookie(mtokenidCookie);
        response.addCookie(usernameCookie);
        model.setViewName("redirect:/login");
        return model;
    }

// TEST CONTROLLERS

    @RequestMapping(value = "test")
    public ModelAndView  test() {
        ModelAndView model= new ModelAndView();
        model.setViewName("redirect:/test2");
        return model;
    }

    @RequestMapping(value = "test2")
    public ModelAndView  test2() {
        ModelAndView model= new ModelAndView();
        model.setViewName("home");
        return model;
    }


}


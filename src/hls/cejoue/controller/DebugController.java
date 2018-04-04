package hls.cejoue.controller;

import hls.cejoue.dto.DepenseAndRecetteDto;
import hls.cejoue.dto.DepenseDto;
import hls.cejoue.dto.NewUserDto;
import hls.cejoue.dto.RecetteDto;
import hls.cejoue.model.Depense;
import hls.cejoue.model.Recette;
import hls.cejoue.model.User;
import hls.cejoue.service.DepenseAndRecetteService;
import hls.cejoue.service.DepenseService;
import hls.cejoue.service.MyUserDetailsService;
import hls.cejoue.service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by hossiel on 16/06/2016.
 */
@Controller
@RequestMapping(value = "/Debug/")
public class DebugController {

    @Autowired
    private MyUserDetailsService userService;

    @Autowired
    private DepenseService depenseService;

    @Autowired
    private RecetteService recetteService;
    @Autowired
    private DepenseAndRecetteService depenseAndRecetteService;



    @RequestMapping(value = "")
    public ModelAndView  gotoHome() {
        ModelAndView model= new ModelAndView();

        model.setViewName("redirect:/Debug/add-recette");
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
        model.setViewName("/Debug/addusers");

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
        model.setViewName("/Debug/showuser");


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
        model.setViewName("/Debug/showAllUsers");
        return model;
    }


    // DEPENSE CONTROLLERS
    @RequestMapping(value = "add-depense",method = RequestMethod.GET)
    public ModelAndView  gotodepenseform( )
    {


        ModelAndView model= new ModelAndView();


        DepenseDto depenseP = new DepenseDto();
        // set default value dépense Plantation
        depenseP.setType(DepenseDto.DPLANTATION);
        depenseP.setDateSoumission(new Date());
        depenseP.setRapporteur("Inconnu");
        depenseP.setEmetteur("Inconnu");
        depenseP.setMontant(0) ;
        depenseP.setCommentaire("RAS");

        DepenseDto depenseM = new DepenseDto();
        // set default value dépense Maison
        depenseM.setType(DepenseDto.DMAISON);
        depenseM.setRapporteur("Inconnu");
        depenseM.setDateSoumission(new Date());
        depenseM.setEmetteur("Inconnu");
        depenseM.setMontant(0);
        depenseM.setCommentaire("RAS");

        DepenseDto depenseA = new DepenseDto();
        // set default value dépense Autres
        depenseA.setType(DepenseDto.DAUTRES);
        depenseA.setRapporteur("Inconnu");
        depenseA.setDateSoumission(new Date());
        depenseA.setEmetteur("Inconnu");
        depenseA.setMontant(0);
        depenseA.setCommentaire("RAS");


        model.addObject("depenseAForm",depenseA );
        model.addObject("depensePForm",depenseP );
        model.addObject("depenseMForm",depenseM );

        model.setViewName("/Debug/add-depense");


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
        model.setViewName("/Debug/showdepense");
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
        model.setViewName("/Debug/showdepense");
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
        model.setViewName("/Debug/showdepense");
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
        model.setViewName("/Debug/showAllDepenses");
        return model;
    }




    // RECETTE CONTROLLERS
    @RequestMapping(value = "add-recette",method = RequestMethod.GET)
    public ModelAndView  gotorecetteform( )
    {


        ModelAndView model= new ModelAndView();


        RecetteDto recetteC = new RecetteDto();
        // set default value recette Coupe
        recetteC.setType(RecetteDto.RCOUPE);
        recetteC.setDateSoumission(new Date());
        recetteC.setRapporteur("Inconnu");
        recetteC.setPercepteur("Inconnu");
        recetteC.setEmetteur("Inconnu");

        recetteC.setRecetteBrut(0);;
        recetteC.setRecetteNet(0);
        recetteC.setCharge(0);
        recetteC.setTonnage(0);
        recetteC.setCommentaire("RAS");

        RecetteDto recetteM = new RecetteDto();
        // set default value dépense Maison
        recetteM.setType(RecetteDto.RLOYER);
        recetteM.setRapporteur("Inconnu");
        recetteM.setPercepteur("Inconnu");
        recetteM.setEmetteur("Inconnu");
        recetteM.setDateSoumission(new Date());
        recetteM.setRecetteBrut(0);;
        recetteM.setRecetteNet(0);
        recetteM.setCharge(0);
        recetteM.setTonnage(0);
        recetteM.setCommentaire("RAS");

        RecetteDto recetteA = new RecetteDto();
        // set default value dépense Autres
        recetteA.setType(RecetteDto.RAUTRES);
        recetteA.setRapporteur("Inconnu");
        recetteA.setPercepteur("Inconnu");
        recetteA.setEmetteur("Inconnu");
        recetteA.setDateSoumission(new Date());
        System.out.println(recetteA.getDateSoumission());


        recetteA.setRecetteBrut(0);;
        recetteA.setRecetteNet(0);
        recetteA.setCharge(0);
        recetteA.setTonnage(0);
        recetteA.setCommentaire("RAS");


        model.addObject("recetteCForm",recetteC );
        model.addObject("recetteLForm",recetteM );
        model.addObject("recetteAForm",recetteA );
        model.setViewName("/Debug/add-recette");


        return model;
    }

    @RequestMapping(value = {"sendRecetteC"},method = { RequestMethod.POST })
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
        model.setViewName("/Debug/showrecette");

        return model;
    }

    @RequestMapping(value = {"sendRecetteL"},method = { RequestMethod.POST })
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
        model.setViewName("/Debug/showrecette");

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
        model.setViewName("/Debug/showrecette");

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
        model.setViewName("/Debug/showAllRecettes");
        return model;
    }

//  DEPENSES AND RECETTES CONTROLLERS

    @RequestMapping(value = "show60DepenseAndRecettes")
    public ModelAndView  showAllDepenseAndRecettes() {
        ModelAndView model= new ModelAndView();
        List<DepenseAndRecetteDto> recetteAndDepenseList= null;
        String message ="Aucune recettes ni depense trouvée";
        recetteAndDepenseList=depenseAndRecetteService.get60();
        if(recetteAndDepenseList!=null) {
            message =recetteAndDepenseList.size()+" élement(s) trouvé(s) et trié(s) par date de soummission (recettes et depenses confondues)";
            recetteAndDepenseList = DepenseAndRecetteDto.sortByCreationDate(recetteAndDepenseList);

        }
        model.addObject("recetteAndDepenseList", recetteAndDepenseList);
        model.addObject("msg", message);
        model.setViewName("/Debug/showALLDepenseAndRecettes");
        return model;
    }



}


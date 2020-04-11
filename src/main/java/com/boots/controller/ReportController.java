package com.boots.controller;

import com.boots.model.ReportUserModel;
import com.boots.model.ReportWordModel;
import com.boots.service.ReportService;
import com.boots.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.ReportAsSingleViolation;
import java.util.List;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/report")
public class ReportController {

    ReportService reportService;
    UserService userService;

    @GetMapping
    public String findAllUsersGamesNative(Model model){
        if(userService.checkRole("ROLE_ADMIN")) {
            model.addAttribute("allUsersGames", reportService.findAllUsersGames());
            model.addAttribute("isAdmin", true);
        }
        else if (userService.checkRole("ROLE_USER")) {
            model.addAttribute("allUsersGames", reportService.findUserGamesByCurrentUser());
            model.addAttribute("isAdmin", false);
        }
        return "report";
    }

    @GetMapping("/reportDetails/{gameId}")
    public String findAllGameAttemptsByGameId(Model model, @PathVariable("gameId") Long gameId){

        model.addAttribute("allGameAttempts", reportService.findAllGameAttemptsByGameId(gameId));
        model.addAttribute("gameId", gameId);
        return "reportDetails";
    }


}

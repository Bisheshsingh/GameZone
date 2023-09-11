package com.example.games.HLD.WelcomePage;

import com.example.games.Constants.Constant;
import com.example.games.LLD.WelcomePage.Activity.PageUpdate;
import com.example.games.Models.WebPageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController implements WebPageController {
    @Autowired
    private PageUpdate pageUpdate;

    @GetMapping(value = "/")
    public String welcomePage(Model model) {
        model = pageUpdate.update(model);

        return Constant.PageInfos.MAIN_WELCOME_PAGE.getPageName();
    }
}

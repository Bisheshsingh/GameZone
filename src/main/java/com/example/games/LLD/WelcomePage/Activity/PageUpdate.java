package com.example.games.LLD.WelcomePage.Activity;

import com.example.games.HLD.WelcomePage.Attributes;
import com.example.games.LLD.WelcomePage.Models.API;
import com.example.games.Models.UpdateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class PageUpdate implements UpdateData<Model> {
    @Autowired
    private API api;

    @Override
    public Model update(Model model) {
        model.addAttribute(Attributes.GAME_LIST, api.getGamesList());

        return model;
    }
}

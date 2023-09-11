package com.example.games.LLD.WelcomePage.Models;

import com.example.games.Models.PageInfo;
import lombok.Data;

@Data
public class GamePageInfo {
    private final String gameName;
    private final String gameIcon;
    private final PageInfo pageInfo;
}

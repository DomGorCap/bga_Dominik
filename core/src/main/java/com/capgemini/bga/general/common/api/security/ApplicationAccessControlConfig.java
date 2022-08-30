package com.capgemini.bga.general.common.api.security;

import com.devonfw.module.security.common.base.accesscontrol.AccessControlConfig;

import javax.inject.Named;

/**
 * Example of {@link AccessControlConfig} that used for testing.
 */
@Named
public class ApplicationAccessControlConfig extends AccessControlConfig {

    public static final String APP_ID = "bga";
    public static final String GROUP_ADMIN = "Admin";
    private static final String PREFIX = APP_ID + ".";
    public static final String PERMISSION_FIND_GAME = PREFIX + "FindGame";
    public static final String PERMISSION_FIND_GAMES = PREFIX + "FindGames";
    public static final String PERMISSION_SAVE_GAME = PREFIX + "SaveGame";
    public static final String PERMISSION_DELETE_GAME = PREFIX + "DeleteGame";
    public static final String PERMISSION_FIND_GAMEPLAY = PREFIX + "FindGamePlay";
    public static final String PERMISSION_FIND_GAMEPLAYS = PREFIX + "FindGamePlays";
    public static final String PERMISSION_SAVE_GAMEPLAY = PREFIX + "SaveGamePlay";
    public static final String PERMISSION_DELETE_GAMEPLAY = PREFIX + "DeleteGamePlay";
    public static final String PERMISSION_FIND_PLAYER = PREFIX + "FindPlayer";
    public static final String PERMISSION_FIND_PLAYERS = PREFIX + "FindPlayers";
    public static final String PERMISSION_SAVE_PLAYER = PREFIX + "SavePlayer";
    public static final String PERMISSION_DELETE_PLAYER = PREFIX + "DeletePlayer";

    /**
     * The constructor.
     */
    public ApplicationAccessControlConfig() {

        super();
        group(GROUP_ADMIN, PERMISSION_FIND_GAME, PERMISSION_FIND_GAMES, PERMISSION_SAVE_GAME, PERMISSION_DELETE_GAME, PERMISSION_FIND_GAMEPLAY,
                PERMISSION_FIND_GAMEPLAYS, PERMISSION_SAVE_GAMEPLAY, PERMISSION_DELETE_GAMEPLAY, PERMISSION_FIND_PLAYER, PERMISSION_FIND_PLAYERS,
                PERMISSION_SAVE_PLAYER, PERMISSION_DELETE_PLAYER);
    }

}
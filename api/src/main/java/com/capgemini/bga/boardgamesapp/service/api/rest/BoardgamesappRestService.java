package com.capgemini.bga.boardgamesapp.service.api.rest;

import com.capgemini.bga.boardgamesapp.logic.api.Boardgamesapp;
import com.capgemini.bga.boardgamesapp.logic.api.to.*;
import org.springframework.data.domain.Page;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Boardgamesapp}.
 */
@Path("/boardgamesapp/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface BoardgamesappRestService {

    /**
     * Delegates to {@link Boardgamesapp#findGame}.
     *
     * @param id the ID of the {@link GameEto}
     * @return the {@link GameEto}
     */
    @GET
    @Path("/game/{id}/")
    public GameEto getGame(@PathParam("id") long id);

    /**
     * Delegates to {@link Boardgamesapp#saveGame}.
     *
     * @param game the {@link GameEto} to be saved
     * @return the recently created {@link GameEto}
     */
    @POST
    @Path("/game/")
    public GameEto saveGame(GameEto game);

    /**
     * Delegates to {@link Boardgamesapp#deleteGame}.
     *
     * @param id ID of the {@link GameEto} to be deleted
     */
    @DELETE
    @Path("/game/{id}/")
    public void deleteGame(@PathParam("id") long id);

    /**
     * Delegates to {@link Boardgamesapp#findGameEtos}.
     *
     * @param searchCriteriaTo the pagination and search criteria to be used for finding games.
     * @return the {@link Page list} of matching {@link GameEto}s.
     */
    @Path("/game/search")
    @POST
    public Page<GameEto> findGames(GameSearchCriteriaTo searchCriteriaTo);

    /**
     * Delegates to {@link Boardgamesapp#findGamePlay}.
     *
     * @param id the ID of the {@link GamePlayEto}
     * @return the {@link GamePlayEto}
     */
    @GET
    @Path("/gameplay/{id}/")
    public GamePlayEto getGamePlay(@PathParam("id") long id);

    /**
     * Delegates to {@link Boardgamesapp#saveGamePlay}.
     *
     * @param gameplay the {@link GamePlayEto} to be saved
     * @return the recently created {@link GamePlayEto}
     */
    @POST
    @Path("/gameplay/")
    public GamePlayEto saveGamePlay(GamePlayEto gameplay);

    /**
     * Delegates to {@link Boardgamesapp#deleteGamePlay}.
     *
     * @param id ID of the {@link GamePlayEto} to be deleted
     */
    @DELETE
    @Path("/gameplay/{id}/")
    public void deleteGamePlay(@PathParam("id") long id);

    /**
     * Delegates to {@link Boardgamesapp#findGamePlayEtos}.
     *
     * @param searchCriteriaTo the pagination and search criteria to be used for finding gameplays.
     * @return the {@link Page list} of matching {@link GamePlayEto}s.
     */
    @Path("/gameplay/search")
    @POST
    public Page<GamePlayEto> findGamePlays(GamePlaySearchCriteriaTo searchCriteriaTo);

    /**
     * Delegates to {@link Boardgamesapp#findPlayer}.
     *
     * @param id the ID of the {@link PlayerEto}
     * @return the {@link PlayerEto}
     */
    @GET
    @Path("/player/{id}/")
    public PlayerEto getPlayer(@PathParam("id") long id);

    /**
     * Delegates to {@link Boardgamesapp#savePlayer}.
     *
     * @param player the {@link PlayerEto} to be saved
     * @return the recently created {@link PlayerEto}
     */
    @POST
    @Path("/player/")
    public PlayerEto savePlayer(PlayerEto player);

    /**
     * Delegates to {@link Boardgamesapp#deletePlayer}.
     *
     * @param id ID of the {@link PlayerEto} to be deleted
     */
    @DELETE
    @Path("/player/{id}/")
    public void deletePlayer(@PathParam("id") long id);

    /**
     * Delegates to {@link Boardgamesapp#findPlayerEtos}.
     *
     * @param searchCriteriaTo the pagination and search criteria to be used for finding players.
     * @return the {@link Page list} of matching {@link PlayerEto}s.
     */
    @Path("/player/search")
    @POST
    public Page<PlayerEto> findPlayers(PlayerSearchCriteriaTo searchCriteriaTo);

    /**
     * Delegates to {@link Boardgamesapp#getGamesWithCostInRange}.
     *
     * @param min minimal cost of the games to find.
     * @param max maximal cost of the games to find.
     * @return the {@link Page list} of matching {@link GameEto}s.
     */
    @Path("/query/2/{min}/{max}")
    @GET
    public Page<GameEto> getGamesWithCostInRange(@PathParam("min") BigDecimal min, @PathParam("max") BigDecimal max);
}

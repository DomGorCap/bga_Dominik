package com.capgemini.bga.boardgamesapp.dataaccess.api.repo;

import com.capgemini.bga.boardgamesapp.dataaccess.api.PlayerEntity;
import com.capgemini.bga.boardgamesapp.logic.api.to.PlayerSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.util.Iterator;

import static com.querydsl.core.alias.Alias.$;

/**
 * {@link DefaultRepository} for {@link PlayerEntity}
 */
public interface PlayerRepository extends DefaultRepository<PlayerEntity> {

    /**
     * @param criteria the {@link PlayerSearchCriteriaTo} with the criteria to search.
     * @return the {@link Page} of the {@link PlayerEntity} objects that matched the search. If no pageable is set, it
     * will return a unique page with all the objects that matched the search.
     */
    default Page<PlayerEntity> findByCriteria(PlayerSearchCriteriaTo criteria) {

        PlayerEntity alias = newDslAlias();
        JPAQuery<PlayerEntity> query = newDslQuery(alias);

        String name = criteria.getName();
        if (name != null && !name.isEmpty()) {
            QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
        }
        if (criteria.getPageable() == null) {
            criteria.setPageable(PageRequest.of(0, Integer.MAX_VALUE));
        } else {
            addOrderBy(query, alias, criteria.getPageable().getSort());
        }

        return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
    }

    /**
     * Add sorting to the given query on the given alias
     *
     * @param query to add sorting to
     * @param alias to retrieve columns from for sorting
     * @param sort  specification of sorting
     */
    public default void addOrderBy(JPAQuery<PlayerEntity> query, PlayerEntity alias, Sort sort) {

        if (sort != null && sort.isSorted()) {
            Iterator<Order> it = sort.iterator();
            while (it.hasNext()) {
                Order next = it.next();
                switch (next.getProperty()) {
                    case "name":
                        if (next.isAscending()) {
                            query.orderBy($(alias.getName()).asc());
                        } else {
                            query.orderBy($(alias.getName()).desc());
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
                }
            }
        }
    }

}
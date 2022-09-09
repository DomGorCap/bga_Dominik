package com.capgemini.bga.boardgamesapp.dataaccess.api.repo;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GameEntity;
import com.capgemini.bga.boardgamesapp.logic.api.to.GameSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import static com.querydsl.core.alias.Alias.$;
import static com.querydsl.core.alias.Alias.alias;

/**
 * {@link DefaultRepository} for {@link GameEntity}
 */
public interface GameRepository extends DefaultRepository<GameEntity>, CustomGameRepository {

    List<GameEntity> findByCostGreaterThan(BigDecimal min);

    /**
     * @param
     * @return the {@link Page} of the {@link GameEntity} objects that matched the search.
     */
    default Page<GameEntity> dslQuery() {

        GameEntity alias = newDslAlias();
        JPAQuery<GameEntity> query = newDslQuery(alias);

        return QueryUtil.get().findPaginated(PageRequest.of(0, Integer.MAX_VALUE), query, true);
    }

    /**
     * @param criteria the {@link GameSearchCriteriaTo} with the criteria to search.
     * @return the {@link Page} of the {@link GameEntity} objects that matched the search. If no pageable is set, it will
     * return a unique page with all the objects that matched the search.
     */
    default Page<GameEntity> findByCriteria(GameSearchCriteriaTo criteria) {

        GameEntity alias = newDslAlias();
        JPAQuery<GameEntity> query = newDslQuery(alias);

        String name = criteria.getName();
        if (name != null && !name.isEmpty()) {
            QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
        }
        BigDecimal cost = criteria.getCost();
        if (cost != null) {
            query.where($(alias.getCost()).eq(cost));
        }
        BigDecimal complexity = criteria.getComplexity();
        if (complexity != null) {
            query.where($(alias.getComplexity()).eq(complexity));
        }
        Boolean extension = criteria.getExtension();
        if (extension != null) {
            query.where($(alias.isExtension()).eq(extension));
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
    public default void addOrderBy(JPAQuery<GameEntity> query, GameEntity alias, Sort sort) {

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
                    case "cost":
                        if (next.isAscending()) {
                            query.orderBy($(alias.getCost()).asc());
                        } else {
                            query.orderBy($(alias.getCost()).desc());
                        }
                        break;
                    case "complexity":
                        if (next.isAscending()) {
                            query.orderBy($(alias.getComplexity()).asc());
                        } else {
                            query.orderBy($(alias.getComplexity()).desc());
                        }
                        break;
                    case "extension":
                        if (next.isAscending()) {
                            query.orderBy($(alias.isExtension()).asc());
                        } else {
                            query.orderBy($(alias.isExtension()).desc());
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
                }
            }
        }
    }

}
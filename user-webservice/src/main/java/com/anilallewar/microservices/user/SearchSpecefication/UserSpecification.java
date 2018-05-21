package com.anilallewar.microservices.user.SearchSpecefication;

import com.anilallewar.microservices.user.userpojos.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
public class UserSpecification implements Specification<User> {

    private final SearchCriteria searchCriteria;


    public UserSpecification(SearchCriteria searchCriteria)
    {
        this.searchCriteria=searchCriteria;
    }


    @Override
    public Predicate toPredicate
            (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        if (searchCriteria.getOperation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(
                    root.<String> get(searchCriteria.getKey()), searchCriteria.getValue().toString());
        }
        else if (searchCriteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(
                    root.<String> get(searchCriteria.getKey()), searchCriteria.getValue().toString());
        }
        else if (searchCriteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(searchCriteria.getKey()).getJavaType() == String.class) {
                return builder.like(
                        root.<String>get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%");
            } else {
                return builder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
            }
        }
        return null;
    }
    }

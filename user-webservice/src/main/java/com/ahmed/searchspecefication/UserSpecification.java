package com.ahmed.searchspecefication;

import com.ahmed.entities.User;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification implements Specification<User> {

  private final SearchCriteria searchCriteria;

  public UserSpecification(SearchCriteria searchCriteria) {

    this.searchCriteria = searchCriteria;
  }

  @Override
  public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

    return builder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
  }
}

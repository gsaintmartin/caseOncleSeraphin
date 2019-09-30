package caseoncleseraphin.dao;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import caseoncleseraphin.model.Category;

@Repository
@Transactional
public class CategoryJpaRepository extends AbstractJpaRepository<Category> {

    public CategoryJpaRepository() {
        super(Category.class);
    }

    public Category findOneById(Long id) {
        String qlString = "from Category cat where cat.id = :id";
        TypedQuery<Category> query = entityManager.createQuery(qlString, Category.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }
}

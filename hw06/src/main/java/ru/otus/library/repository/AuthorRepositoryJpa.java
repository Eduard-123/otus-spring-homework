package ru.otus.library.repository;

import org.springframework.stereotype.Repository;
import ru.otus.library.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorRepositoryJpa implements AuthorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Author> getAll() {
        TypedQuery<Author> query = em.createQuery("select e from Author e", Author.class);
        return query.getResultList();
    }
}

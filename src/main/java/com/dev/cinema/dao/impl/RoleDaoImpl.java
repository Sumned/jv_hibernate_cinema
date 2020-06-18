package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.RoleDao;
import com.dev.cinema.exceptions.DataProcessingException;
import com.dev.cinema.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    private final SessionFactory sessionFactory;

    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role add(Role role) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
            return role;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert role's entity", e);
        } finally {
            session.close();
        }

    }

    @Override
    public Role getByName(String roleName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Role> query = session
                    .createQuery("from Role r "
                            + " where r.roleName =: roleName", Role.class);
            query.setParameter("roleName", Role.RoleName.valueOf(roleName));
            return query.uniqueResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find role by name", e);
        }
    }
}

/*
 * Copyright 2019 rawdog.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.clownfish.clownfish.dbrepository;

import io.clownfish.clownfish.daointerface.CfStylesheetDAO;
import io.clownfish.clownfish.dbentities.CfStylesheet;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rawdog
 */
public class CfStylesheetDAOImpl implements CfStylesheetDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public CfStylesheetDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<CfStylesheet> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery query = (TypedQuery) session.getNamedQuery("CfTemplate.findAll");
        List<CfStylesheet> cftempaltelist = query.getResultList();
        return cftempaltelist;
    }

    @Override
    public boolean create(CfStylesheet entity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(entity);
        return true;
    }

    @Override
    public boolean delete(CfStylesheet entity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(entity);
        return true;
    }

    @Override
    public boolean edit(CfStylesheet entity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(entity);
        return true;
    }

    @Override
    public CfStylesheet findById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery query = (TypedQuery) session.getNamedQuery("CfStylesheet.findById");
        query.setParameter("id", id);
        CfStylesheet cfstylesheet = (CfStylesheet) query.getSingleResult();
        return cfstylesheet;
    }

    @Override
    public CfStylesheet findByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery query = (TypedQuery) session.getNamedQuery("CfStylesheet.findByName");
        query.setParameter("name", name);
        CfStylesheet cfstylesheet = (CfStylesheet) query.getSingleResult();
        return cfstylesheet;
    }
}

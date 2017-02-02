/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import EntityBeans.exceptions.SadResignrequestarchive;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import query.exceptions.NonexistentEntityException;

/**
 *
 * @author Falbe
 */
public class SadResignrequestarchiveController implements Serializable {

    public SadResignrequestarchiveController() {
       emf =Persistence.createEntityManagerFactory("PlantaloguePU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SadResignrequestarchive sadResignrequestarchive) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sadResignrequestarchive);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SadResignrequestarchive sadResignrequestarchive) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sadResignrequestarchive = em.merge(sadResignrequestarchive);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sadResignrequestarchive.getId();
                if (findSadResignrequestarchive(id) == null) {
                    throw new NonexistentEntityException("The sadResignrequestarchive with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SadResignrequestarchive sadResignrequestarchive;
            try {
                sadResignrequestarchive = em.getReference(SadResignrequestarchive.class, id);
                sadResignrequestarchive.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sadResignrequestarchive with id " + id + " no longer exists.", enfe);
            }
            em.remove(sadResignrequestarchive);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SadResignrequestarchive> findSadResignrequestarchiveEntities() {
        return findSadResignrequestarchiveEntities(true, -1, -1);
    }

    public List<SadResignrequestarchive> findSadResignrequestarchiveEntities(int maxResults, int firstResult) {
        return findSadResignrequestarchiveEntities(false, maxResults, firstResult);
    }

    private List<SadResignrequestarchive> findSadResignrequestarchiveEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SadResignrequestarchive.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public SadResignrequestarchive findSadResignrequestarchive(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SadResignrequestarchive.class, id);
        } finally {
            em.close();
        }
    }

    public int getSadResignrequestarchiveCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SadResignrequestarchive> rt = cq.from(SadResignrequestarchive.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

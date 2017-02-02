/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import EntityBeans.exceptions.SajResignrequestarchive;
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
public class SajResignrequestarchiveController implements Serializable {

    public SajResignrequestarchiveController() {
      emf =Persistence.createEntityManagerFactory("PlantaloguePU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SajResignrequestarchive sajResignrequestarchive) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sajResignrequestarchive);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SajResignrequestarchive sajResignrequestarchive) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sajResignrequestarchive = em.merge(sajResignrequestarchive);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sajResignrequestarchive.getId();
                if (findSajResignrequestarchive(id) == null) {
                    throw new NonexistentEntityException("The sajResignrequestarchive with id " + id + " no longer exists.");
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
            SajResignrequestarchive sajResignrequestarchive;
            try {
                sajResignrequestarchive = em.getReference(SajResignrequestarchive.class, id);
                sajResignrequestarchive.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sajResignrequestarchive with id " + id + " no longer exists.", enfe);
            }
            em.remove(sajResignrequestarchive);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SajResignrequestarchive> findSajResignrequestarchiveEntities() {
        return findSajResignrequestarchiveEntities(true, -1, -1);
    }

    public List<SajResignrequestarchive> findSajResignrequestarchiveEntities(int maxResults, int firstResult) {
        return findSajResignrequestarchiveEntities(false, maxResults, firstResult);
    }

    private List<SajResignrequestarchive> findSajResignrequestarchiveEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SajResignrequestarchive.class));
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

    public SajResignrequestarchive findSajResignrequestarchive(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SajResignrequestarchive.class, id);
        } finally {
            em.close();
        }
    }

    public int getSajResignrequestarchiveCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SajResignrequestarchive> rt = cq.from(SajResignrequestarchive.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

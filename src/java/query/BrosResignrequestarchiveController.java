/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import EntityBeans.exceptions.BrosResignrequestarchive;
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
public class BrosResignrequestarchiveController implements Serializable {

    public BrosResignrequestarchiveController() {
        emf =Persistence.createEntityManagerFactory("PlantaloguePU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BrosResignrequestarchive brosResignrequestarchive) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(brosResignrequestarchive);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BrosResignrequestarchive brosResignrequestarchive) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            brosResignrequestarchive = em.merge(brosResignrequestarchive);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = brosResignrequestarchive.getId();
                if (findBrosResignrequestarchive(id) == null) {
                    throw new NonexistentEntityException("The brosResignrequestarchive with id " + id + " no longer exists.");
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
            BrosResignrequestarchive brosResignrequestarchive;
            try {
                brosResignrequestarchive = em.getReference(BrosResignrequestarchive.class, id);
                brosResignrequestarchive.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The brosResignrequestarchive with id " + id + " no longer exists.", enfe);
            }
            em.remove(brosResignrequestarchive);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BrosResignrequestarchive> findBrosResignrequestarchiveEntities() {
        return findBrosResignrequestarchiveEntities(true, -1, -1);
    }

    public List<BrosResignrequestarchive> findBrosResignrequestarchiveEntities(int maxResults, int firstResult) {
        return findBrosResignrequestarchiveEntities(false, maxResults, firstResult);
    }

    private List<BrosResignrequestarchive> findBrosResignrequestarchiveEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BrosResignrequestarchive.class));
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

    public BrosResignrequestarchive findBrosResignrequestarchive(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BrosResignrequestarchive.class, id);
        } finally {
            em.close();
        }
    }

    public int getBrosResignrequestarchiveCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BrosResignrequestarchive> rt = cq.from(BrosResignrequestarchive.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

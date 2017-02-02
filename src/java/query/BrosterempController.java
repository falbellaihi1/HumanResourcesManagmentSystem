/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import EntityBeans.exceptions.Brosteremp;
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
public class BrosterempController implements Serializable {

    public BrosterempController() {
        emf =Persistence.createEntityManagerFactory("PlantaloguePU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Brosteremp brosteremp) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(brosteremp);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Brosteremp brosteremp) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            brosteremp = em.merge(brosteremp);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = brosteremp.getId();
                if (findBrosteremp(id) == null) {
                    throw new NonexistentEntityException("The brosteremp with id " + id + " no longer exists.");
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
            Brosteremp brosteremp;
            try {
                brosteremp = em.getReference(Brosteremp.class, id);
                brosteremp.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The brosteremp with id " + id + " no longer exists.", enfe);
            }
            em.remove(brosteremp);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Brosteremp> findBrosterempEntities() {
        return findBrosterempEntities(true, -1, -1);
    }

    public List<Brosteremp> findBrosterempEntities(int maxResults, int firstResult) {
        return findBrosterempEntities(false, maxResults, firstResult);
    }

    private List<Brosteremp> findBrosterempEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Brosteremp.class));
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

    public Brosteremp findBrosteremp(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Brosteremp.class, id);
        } finally {
            em.close();
        }
    }

    public int getBrosterempCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Brosteremp> rt = cq.from(Brosteremp.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

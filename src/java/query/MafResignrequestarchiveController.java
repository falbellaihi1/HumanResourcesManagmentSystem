/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import EntityBeans.exceptions.MafResignrequestarchive;
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
public class MafResignrequestarchiveController implements Serializable {

    public MafResignrequestarchiveController() {
        emf =Persistence.createEntityManagerFactory("PlantaloguePU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MafResignrequestarchive mafResignrequestarchive) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mafResignrequestarchive);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MafResignrequestarchive mafResignrequestarchive) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mafResignrequestarchive = em.merge(mafResignrequestarchive);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mafResignrequestarchive.getId();
                if (findMafResignrequestarchive(id) == null) {
                    throw new NonexistentEntityException("The mafResignrequestarchive with id " + id + " no longer exists.");
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
            MafResignrequestarchive mafResignrequestarchive;
            try {
                mafResignrequestarchive = em.getReference(MafResignrequestarchive.class, id);
                mafResignrequestarchive.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mafResignrequestarchive with id " + id + " no longer exists.", enfe);
            }
            em.remove(mafResignrequestarchive);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MafResignrequestarchive> findMafResignrequestarchiveEntities() {
        return findMafResignrequestarchiveEntities(true, -1, -1);
    }

    public List<MafResignrequestarchive> findMafResignrequestarchiveEntities(int maxResults, int firstResult) {
        return findMafResignrequestarchiveEntities(false, maxResults, firstResult);
    }

    private List<MafResignrequestarchive> findMafResignrequestarchiveEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MafResignrequestarchive.class));
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

    public MafResignrequestarchive findMafResignrequestarchive(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MafResignrequestarchive.class, id);
        } finally {
            em.close();
        }
    }

    public int getMafResignrequestarchiveCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MafResignrequestarchive> rt = cq.from(MafResignrequestarchive.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

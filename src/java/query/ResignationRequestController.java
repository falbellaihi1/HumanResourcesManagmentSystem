/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import EntityBeans.ResignationRequest;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import EntityBeans.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import query.exceptions.NonexistentEntityException;

/**
 *
 * @author Falbe
 */
public class ResignationRequestController implements Serializable {

    public ResignationRequestController() {
        this.emf = Persistence.createEntityManagerFactory("PlantaloguePU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ResignationRequest resignationRequest) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users userID = resignationRequest.getUserID();
            if (userID != null) {
                userID = em.getReference(userID.getClass(), userID.getId());
                resignationRequest.setUserID(userID);
            }
            em.persist(resignationRequest);
            if (userID != null) {
                userID.getResignationRequestCollection().add(resignationRequest);
                userID = em.merge(userID);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ResignationRequest resignationRequest) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ResignationRequest persistentResignationRequest = em.find(ResignationRequest.class, resignationRequest.getId());
            Users userIDOld = persistentResignationRequest.getUserID();
            Users userIDNew = resignationRequest.getUserID();
            if (userIDNew != null) {
                userIDNew = em.getReference(userIDNew.getClass(), userIDNew.getId());
                resignationRequest.setUserID(userIDNew);
            }
            resignationRequest = em.merge(resignationRequest);
            if (userIDOld != null && !userIDOld.equals(userIDNew)) {
                userIDOld.getResignationRequestCollection().remove(resignationRequest);
                userIDOld = em.merge(userIDOld);
            }
            if (userIDNew != null && !userIDNew.equals(userIDOld)) {
                userIDNew.getResignationRequestCollection().add(resignationRequest);
                userIDNew = em.merge(userIDNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = resignationRequest.getId();
                if (findResignationRequest(id) == null) {
                    throw new NonexistentEntityException("The resignationRequest with id " + id + " no longer exists.");
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
            ResignationRequest resignationRequest;
            try {
                resignationRequest = em.getReference(ResignationRequest.class, id);
                resignationRequest.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The resignationRequest with id " + id + " no longer exists.", enfe);
            }
            Users userID = resignationRequest.getUserID();
            if (userID != null) {
                userID.getResignationRequestCollection().remove(resignationRequest);
                userID = em.merge(userID);
            }
            em.remove(resignationRequest);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ResignationRequest> findResignationRequestEntities() {
        return findResignationRequestEntities(true, -1, -1);
    }

    public List<ResignationRequest> findResignationRequestEntities(int maxResults, int firstResult) {
        return findResignationRequestEntities(false, maxResults, firstResult);
    }

    private List<ResignationRequest> findResignationRequestEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ResignationRequest.class));
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

    public ResignationRequest findResignationRequest(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ResignationRequest.class, id);
        } finally {
            em.close();
        }
    }

    public int getResignationRequestCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ResignationRequest> rt = cq.from(ResignationRequest.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

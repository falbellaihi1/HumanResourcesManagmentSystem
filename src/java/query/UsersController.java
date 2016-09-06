/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import EntityBeans.ResignationRequest;
import EntityBeans.Users;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import query.exceptions.IllegalOrphanException;
import query.exceptions.NonexistentEntityException;

/**
 *
 * @author Falbe
 */
public class UsersController implements Serializable {

    public UsersController() {
        this.emf = Persistence.createEntityManagerFactory("PlantaloguePU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Users users) {
        if (users.getResignationRequestCollection() == null) {
            users.setResignationRequestCollection(new ArrayList<ResignationRequest>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<ResignationRequest> attachedResignationRequestCollection = new ArrayList<ResignationRequest>();
            for (ResignationRequest resignationRequestCollectionResignationRequestToAttach : users.getResignationRequestCollection()) {
                resignationRequestCollectionResignationRequestToAttach = em.getReference(resignationRequestCollectionResignationRequestToAttach.getClass(), resignationRequestCollectionResignationRequestToAttach.getId());
                attachedResignationRequestCollection.add(resignationRequestCollectionResignationRequestToAttach);
            }
            users.setResignationRequestCollection(attachedResignationRequestCollection);
            em.persist(users);
            for (ResignationRequest resignationRequestCollectionResignationRequest : users.getResignationRequestCollection()) {
                Users oldUserIDOfResignationRequestCollectionResignationRequest = resignationRequestCollectionResignationRequest.getUserID();
                resignationRequestCollectionResignationRequest.setUserID(users);
                resignationRequestCollectionResignationRequest = em.merge(resignationRequestCollectionResignationRequest);
                if (oldUserIDOfResignationRequestCollectionResignationRequest != null) {
                    oldUserIDOfResignationRequestCollectionResignationRequest.getResignationRequestCollection().remove(resignationRequestCollectionResignationRequest);
                    oldUserIDOfResignationRequestCollectionResignationRequest = em.merge(oldUserIDOfResignationRequestCollectionResignationRequest);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Users users) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users persistentUsers = em.find(Users.class, users.getId());
            Collection<ResignationRequest> resignationRequestCollectionOld = persistentUsers.getResignationRequestCollection();
            Collection<ResignationRequest> resignationRequestCollectionNew = users.getResignationRequestCollection();
            List<String> illegalOrphanMessages = null;
            for (ResignationRequest resignationRequestCollectionOldResignationRequest : resignationRequestCollectionOld) {
                if (!resignationRequestCollectionNew.contains(resignationRequestCollectionOldResignationRequest)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ResignationRequest " + resignationRequestCollectionOldResignationRequest + " since its userID field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<ResignationRequest> attachedResignationRequestCollectionNew = new ArrayList<ResignationRequest>();
            for (ResignationRequest resignationRequestCollectionNewResignationRequestToAttach : resignationRequestCollectionNew) {
                resignationRequestCollectionNewResignationRequestToAttach = em.getReference(resignationRequestCollectionNewResignationRequestToAttach.getClass(), resignationRequestCollectionNewResignationRequestToAttach.getId());
                attachedResignationRequestCollectionNew.add(resignationRequestCollectionNewResignationRequestToAttach);
            }
            resignationRequestCollectionNew = attachedResignationRequestCollectionNew;
            users.setResignationRequestCollection(resignationRequestCollectionNew);
            users = em.merge(users);
            for (ResignationRequest resignationRequestCollectionNewResignationRequest : resignationRequestCollectionNew) {
                if (!resignationRequestCollectionOld.contains(resignationRequestCollectionNewResignationRequest)) {
                    Users oldUserIDOfResignationRequestCollectionNewResignationRequest = resignationRequestCollectionNewResignationRequest.getUserID();
                    resignationRequestCollectionNewResignationRequest.setUserID(users);
                    resignationRequestCollectionNewResignationRequest = em.merge(resignationRequestCollectionNewResignationRequest);
                    if (oldUserIDOfResignationRequestCollectionNewResignationRequest != null && !oldUserIDOfResignationRequestCollectionNewResignationRequest.equals(users)) {
                        oldUserIDOfResignationRequestCollectionNewResignationRequest.getResignationRequestCollection().remove(resignationRequestCollectionNewResignationRequest);
                        oldUserIDOfResignationRequestCollectionNewResignationRequest = em.merge(oldUserIDOfResignationRequestCollectionNewResignationRequest);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = users.getId();
                if (findUsers(id) == null) {
                    throw new NonexistentEntityException("The users with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users users;
            try {
                users = em.getReference(Users.class, id);
                users.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The users with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ResignationRequest> resignationRequestCollectionOrphanCheck = users.getResignationRequestCollection();
            for (ResignationRequest resignationRequestCollectionOrphanCheckResignationRequest : resignationRequestCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Users (" + users + ") cannot be destroyed since the ResignationRequest " + resignationRequestCollectionOrphanCheckResignationRequest + " in its resignationRequestCollection field has a non-nullable userID field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(users);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Users> findUsersEntities() {
        return findUsersEntities(true, -1, -1);
    }

    public List<Users> findUsersEntities(int maxResults, int firstResult) {
        return findUsersEntities(false, maxResults, firstResult);
    }

    private List<Users> findUsersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Users.class));
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

    public Users findUsers(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Users.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Users> rt = cq.from(Users.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
    
    
    
    
     public Users login(String username, String password, int t)
   {
       try
       {
            EntityManager em = getEntityManager();
           Users loginUser=em.createNamedQuery("Users.findByUsernameAndPassword", Users.class).setParameter("username", username).setParameter("password", password).setParameter("type", t).getSingleResult();
           if(loginUser==null)
               return null;
            return loginUser;
       }
       catch (Exception e)
       {
            return null;
       }
       
   
      
   }
     public void logout (String username){
         EntityManager em = getEntityManager();
         em.remove(em);
     }

    public Users findU(String value) {
        try
       {
           EntityManager em = getEntityManager();
           Users user=em.createNamedQuery("Users.findByUsername", Users.class).setParameter("username", value).getSingleResult();
           if(user==null)
               return null;
            return user;
       }
       catch (Exception e)
       {
            return null;
       }
    }
     
    
    
}

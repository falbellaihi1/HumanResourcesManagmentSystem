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
import EntityBeans.Labels;
import EntityBeans.Plants;
import EntityBeans.Tasks;
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
public class PlantsController implements Serializable {

    public PlantsController() {
         this.emf = Persistence.createEntityManagerFactory("PlantaloguePU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Plants plants) {
        if (plants.getTasksCollection() == null) {
            plants.setTasksCollection(new ArrayList<Tasks>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Labels labels = plants.getLabels();
            if (labels != null) {
                labels = em.getReference(labels.getClass(), labels.getPlantID());
                plants.setLabels(labels);
            }
            Collection<Tasks> attachedTasksCollection = new ArrayList<Tasks>();
            for (Tasks tasksCollectionTasksToAttach : plants.getTasksCollection()) {
                tasksCollectionTasksToAttach = em.getReference(tasksCollectionTasksToAttach.getClass(), tasksCollectionTasksToAttach.getTaskID());
                attachedTasksCollection.add(tasksCollectionTasksToAttach);
            }
            plants.setTasksCollection(attachedTasksCollection);
            em.persist(plants);
            if (labels != null) {
                Plants oldPlantsOfLabels = labels.getPlants();
                if (oldPlantsOfLabels != null) {
                    oldPlantsOfLabels.setLabels(null);
                    oldPlantsOfLabels = em.merge(oldPlantsOfLabels);
                }
                labels.setPlants(plants);
                labels = em.merge(labels);
            }
            for (Tasks tasksCollectionTasks : plants.getTasksCollection()) {
                Plants oldPlantIDOfTasksCollectionTasks = tasksCollectionTasks.getPlantID();
                tasksCollectionTasks.setPlantID(plants);
                tasksCollectionTasks = em.merge(tasksCollectionTasks);
                if (oldPlantIDOfTasksCollectionTasks != null) {
                    oldPlantIDOfTasksCollectionTasks.getTasksCollection().remove(tasksCollectionTasks);
                    oldPlantIDOfTasksCollectionTasks = em.merge(oldPlantIDOfTasksCollectionTasks);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Plants plants) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Plants persistentPlants = em.find(Plants.class, plants.getPlantID());
            Labels labelsOld = persistentPlants.getLabels();
            Labels labelsNew = plants.getLabels();
            Collection<Tasks> tasksCollectionOld = persistentPlants.getTasksCollection();
            Collection<Tasks> tasksCollectionNew = plants.getTasksCollection();
            List<String> illegalOrphanMessages = null;
            if (labelsOld != null && !labelsOld.equals(labelsNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Labels " + labelsOld + " since its plants field is not nullable.");
            }
            for (Tasks tasksCollectionOldTasks : tasksCollectionOld) {
                if (!tasksCollectionNew.contains(tasksCollectionOldTasks)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Tasks " + tasksCollectionOldTasks + " since its plantID field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (labelsNew != null) {
                labelsNew = em.getReference(labelsNew.getClass(), labelsNew.getPlantID());
                plants.setLabels(labelsNew);
            }
            Collection<Tasks> attachedTasksCollectionNew = new ArrayList<Tasks>();
            for (Tasks tasksCollectionNewTasksToAttach : tasksCollectionNew) {
                tasksCollectionNewTasksToAttach = em.getReference(tasksCollectionNewTasksToAttach.getClass(), tasksCollectionNewTasksToAttach.getTaskID());
                attachedTasksCollectionNew.add(tasksCollectionNewTasksToAttach);
            }
            tasksCollectionNew = attachedTasksCollectionNew;
            plants.setTasksCollection(tasksCollectionNew);
            plants = em.merge(plants);
            if (labelsNew != null && !labelsNew.equals(labelsOld)) {
                Plants oldPlantsOfLabels = labelsNew.getPlants();
                if (oldPlantsOfLabels != null) {
                    oldPlantsOfLabels.setLabels(null);
                    oldPlantsOfLabels = em.merge(oldPlantsOfLabels);
                }
                labelsNew.setPlants(plants);
                labelsNew = em.merge(labelsNew);
            }
            for (Tasks tasksCollectionNewTasks : tasksCollectionNew) {
                if (!tasksCollectionOld.contains(tasksCollectionNewTasks)) {
                    Plants oldPlantIDOfTasksCollectionNewTasks = tasksCollectionNewTasks.getPlantID();
                    tasksCollectionNewTasks.setPlantID(plants);
                    tasksCollectionNewTasks = em.merge(tasksCollectionNewTasks);
                    if (oldPlantIDOfTasksCollectionNewTasks != null && !oldPlantIDOfTasksCollectionNewTasks.equals(plants)) {
                        oldPlantIDOfTasksCollectionNewTasks.getTasksCollection().remove(tasksCollectionNewTasks);
                        oldPlantIDOfTasksCollectionNewTasks = em.merge(oldPlantIDOfTasksCollectionNewTasks);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = plants.getPlantID();
                if (findPlants(id) == null) {
                    throw new NonexistentEntityException("The plants with id " + id + " no longer exists.");
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
            Plants plants;
            try {
                plants = em.getReference(Plants.class, id);
                plants.getPlantID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The plants with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Labels labelsOrphanCheck = plants.getLabels();
            if (labelsOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Plants (" + plants + ") cannot be destroyed since the Labels " + labelsOrphanCheck + " in its labels field has a non-nullable plants field.");
            }
            Collection<Tasks> tasksCollectionOrphanCheck = plants.getTasksCollection();
            for (Tasks tasksCollectionOrphanCheckTasks : tasksCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Plants (" + plants + ") cannot be destroyed since the Tasks " + tasksCollectionOrphanCheckTasks + " in its tasksCollection field has a non-nullable plantID field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(plants);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Plants> findPlantsEntities() {
        return findPlantsEntities(true, -1, -1);
    }

    public List<Plants> findPlantsEntities(int maxResults, int firstResult) {
        return findPlantsEntities(false, maxResults, firstResult);
    }

    private List<Plants> findPlantsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Plants.class));
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

    public Plants findPlants(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Plants.class, id);
        } finally {
            em.close();
        }
    }

    public int getPlantsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Plants> rt = cq.from(Plants.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

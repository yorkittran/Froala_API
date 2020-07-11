/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhtt.dtos.service;

import anhtt.dtos.Products;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Yorkit Tran
 */
@Stateless
@Path("anhtt.dtos.products")
public class ProductsFacadeREST extends AbstractFacade<Products> {

    @PersistenceContext(unitName = "Froala_APIPU")
    private EntityManager em;

    public ProductsFacadeREST() {
        super(Products.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Products entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Products entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Products find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Products> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Products> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
//
//    @GET
//    @Path("findByCategories")
//    @Produces(MediaType.APPLICATION_XML)
//    public List<Products> findByCategories(@QueryParam("categoriesArray") String categoriesArray, @QueryParam("offset") String offset, @QueryParam("limit") String limit) {
//        TypedQuery query = em.createNamedQuery("Products.findByCategories", Products.class);
//        query.setParameter("categoriesArray", categoriesArray);
//        query.setParameter("offset", Integer.parseInt(offset));
//        query.setParameter("limit", Integer.parseInt(limit));
//        return (List<Products>) query.getResultList();
//    }
//    
    @GET
    @Path("/findByCategories/{categoriesArray}/{offset}/{limit}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Products> findByCategories(@PathParam("categoriesArray") String categoriesArray, @PathParam("offset") String offset, @PathParam("limit") String limit) {
        List<Products> result = null;
        result = (List<Products>) getEntityManager()
                .createQuery("SELECT p FROM Products p WHERE p.categoryId IN (1,2,3)")
                .setParameter("categoriesArray", categoriesArray)
//                .setParameter("offset", offset)
//                .setParameter("limit", limit)
                .getResultList();
        return result;
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}

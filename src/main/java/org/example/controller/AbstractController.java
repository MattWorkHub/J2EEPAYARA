package org.example.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.example.dto.AbstractDto;
import org.example.entity.AbstractEntity;
import org.example.service.AbstractServiceImplementation;

import java.util.List;

public abstract class AbstractController<T extends AbstractEntity<ID>, D extends AbstractDto<ID>, ID> {

    @Inject
    protected AbstractServiceImplementation<T, D, ID> service;

    public AbstractController(AbstractServiceImplementation<T, D, ID> service) {
        this.service = service;
    }

    public AbstractController() {
    }

    protected abstract ID parseId(String idStr);

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") String idStr) {
        ID id = parseId(idStr);
        D dto = service.findById(id);
        if (dto != null) {
            return Response.ok(dto).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    public Response findAll() {
        List<D> dtos = service.findAll();
        return Response.ok(dtos).build();
    }


    @POST
    public Response create(D dto) {
        D savedEntity = service.save(dto);
        return Response.ok(savedEntity).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String idStr, D dto) {
        ID id = parseId(idStr);
        D updatedEntity = service.update(id, dto);
        return Response.ok(updatedEntity).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String idStr) {
        ID id = parseId(idStr);
        service.delete(id);
        return Response.noContent().build();
    }
}

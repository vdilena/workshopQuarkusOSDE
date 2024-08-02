package org.acme;


import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {
	
	@Inject
	PersonRepository personRepository;

	@GET
    public List<Person> list() {
        return personRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Person get(Long id) {
        return personRepository.findById(id);
    }

    @POST
    @Transactional
    public Response create(Person person) {
    	
		personRepository.persist(person);
        return Response.created(URI.create("/persons/" + person.getId())).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Person update(Long id, Person person) {
        Person personFound = personRepository.findById(id);
        if(personFound == null) {
            throw new NotFoundException();
        }

        return person;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(Long id) {
        Person person = personRepository.findById(id);
        if(person == null) {
            throw new NotFoundException();
        }
        personRepository.delete(person);
    }

    @GET
    @Path("/search/{name}")
    public Person search(String name) {
        return personRepository.findByName(name);
    }

}

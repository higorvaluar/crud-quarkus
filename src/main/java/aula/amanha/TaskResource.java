package aula.amanha;

import java.util.List;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {
    @GET
    public List<Task> getAllTasks() {
        return Task.listAll();
    }

    @GET
    @Path("/{id}")
    public Task getTask(@PathParam("id") Long id) {
        return Task.findById(id);
    }

    @POST
    @Transactional
    public Response createTask(Task task) {
        task.persist();
        return Response.status(Response.Status.CREATED).entity(task).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateTask(@PathParam("id") Long id, Task updateTask) {
        Task task = Task.findById(id);
        if (task == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        task.title = updateTask.title;
        task.description = updateTask.description;
        task.completed = updateTask.completed;
        return Response.ok(task).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteTask(@PathParam("id") Long id) {
        Task task = Task.findById(id);
        if (task == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        task.delete();
        return Response.noContent().build();
    }
}

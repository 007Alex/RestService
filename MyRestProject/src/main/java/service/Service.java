package service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("")
public class Service {

    static Map<String,Note> hash_map = new HashMap<String,Note>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Note> getIt() {

        Set<Map.Entry<String, Note>> set = hash_map.entrySet();
        List<Note> result = new ArrayList<Note>();

        for (Map.Entry<String, Note> cur : set) {
            result.add(cur.getValue());
        }

        return result;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Note postIt(@QueryParam("title") String title,@QueryParam("text") String text)
    {
        Note obj = new Note(title,text);
        while(hash_map.containsKey(obj.id))
            obj.NewRandomID();
        hash_map.put(obj.id,obj);
        return hash_map.get(obj.id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public ProcessingRequestResult updateIt(@QueryParam("id") String id, @QueryParam("title") String title,@QueryParam("text") String text)
    {
        if(!hash_map.containsKey(id))
            return ProcessingRequestResult.BadResult("Note does not exist");
        Note obj = hash_map.get(id);
        obj.title = title;
        obj.text = text;
        obj.ResetUpdateTime();
        return ProcessingRequestResult.GoodResult("Done");
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public ProcessingRequestResult updateIt(@QueryParam("id") String id)
    {
        if(!hash_map.containsKey(id))
            return ProcessingRequestResult.BadResult("Note does not exist");
        hash_map.remove(id);
        return ProcessingRequestResult.GoodResult("Done");
    }
}

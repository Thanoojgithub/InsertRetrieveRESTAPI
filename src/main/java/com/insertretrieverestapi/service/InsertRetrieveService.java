package com.insertretrieverestapi.service;

import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

import com.insertretrieverestapi.vo.Element;

public interface InsertRetrieveService {

	@POST
	@Path("/insert/{str}")
	@Description(value = "Resource", target = DocTarget.RESOURCE)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	public void insert(@PathParam(value = "str") String str);

	@GET
	@Path("/retrieve")
	@Description(value = "Resource", target = DocTarget.RESOURCE)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	public List<Entry<String, Element>> retrieve();

}

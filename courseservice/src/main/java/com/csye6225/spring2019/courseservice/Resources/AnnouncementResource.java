package com.csye6225.spring2019.courseservice.Resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.csye6225.spring2019.courseservice.Services.AnnouncementService;
import com.csye6225.spring2019.courseservice.datamodel.Announcement;

@Path("announcements")
public class AnnouncementResource {
	AnnouncementService announcementService = new AnnouncementService();

	@GET
	public List<Announcement> getAllAnnouncements() {
		return announcementService.getAllAnnouncements();
	}

	// ... webapi/announcements/1
	@GET
	@Path("/{announcementId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Announcement getAnnouncement(@PathParam("announcementId") String announcementId) {
		return announcementService.getAnnouncement(announcementId);
	}

	@DELETE
	@Path("/{announcementId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Announcement deleteAnnouncement(@PathParam("announcementId") String announcementId) {
		return announcementService.deleteAnnouncement(announcementId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Announcement addAnnouncement(Announcement announcement) {
		return announcementService.addAnnouncement(announcement);
	}

	@PUT
	@Path("/{announcementId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Announcement updateAnnouncement(@PathParam("announcementId") String announcementId,
			Announcement announcement) {
		return announcementService.updateAnnouncementInformation(announcementId, announcement);
	}
}

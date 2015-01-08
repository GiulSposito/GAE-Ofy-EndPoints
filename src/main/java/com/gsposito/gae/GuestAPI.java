package com.gsposito.gae;

import java.util.List;
import static com.gsposito.gae.ObjectifyAppServices.ofy;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(name = "guestApi",
     version = "v1",
     namespace = @ApiNamespace(ownerDomain = "gae.gsposito.com",
                                ownerName = "gae.gsposito.com",
                                packagePath=""))

public class GuestAPI {
	
    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getAllGuests")
    public List<Guest> getAllGuests() {
    	return ofy().load().type(Guest.class).list();
    }
    
    @ApiMethod(name = "addGuest", httpMethod = "post")
    public Guest addGuest(Guest guest){
    	ofy().save().entity(guest).now();
    	return guest;
    }
	
	
}

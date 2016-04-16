/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Roomtype;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sessionbean.RoomtypeFacadeLocal;

/**
 *
 * @author Willi
 */
public class RoomtypeStub {
    RoomtypeFacadeLocal roomtypeFacade = lookupRoomtypeFacadeLocal();

    private RoomtypeFacadeLocal lookupRoomtypeFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (RoomtypeFacadeLocal) c.lookup("java:global/ProjectHotel/ProjectHotel-ejb/RoomtypeFacade!sessionbean.RoomtypeFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Roomtype roomtype) {
        roomtypeFacade.create(roomtype);
    }

    public void edit(Roomtype roomtype) {
        roomtypeFacade.edit(roomtype);
    }

    public void remove(Roomtype roomtype) {
        roomtypeFacade.remove(roomtype);
    }

    public Roomtype find(Object id) {
        return roomtypeFacade.find(id);
    }

    public List<Roomtype> findAll() {
        return roomtypeFacade.findAll();
    }

    public List<Roomtype> findRange(int[] range) {
        return roomtypeFacade.findRange(range);
    }

    public int count() {
        return roomtypeFacade.count();
    }

    public List<Roomtype> findByPeople(int people) {
        return roomtypeFacade.findByPeople(people);
    }

    public List<Roomtype> findByRoomTyoe(String type) {
        return roomtypeFacade.findByRoomTyoe(type);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Roomtype;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Willi
 */
@Local
public interface RoomtypeFacadeLocal {

    void create(Roomtype roomtype);

    void edit(Roomtype roomtype);

    void remove(Roomtype roomtype);

    Roomtype find(Object id);

    List<Roomtype> findAll();

    List<Roomtype> findRange(int[] range);

    int count();
    
    List<Roomtype> findByPeople(int people);
    
    List<Roomtype> findByRoomTyoe(String type);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Promotion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sessionbean.PromotionFacadeLocal;

/**
 *
 * @author Willi
 */
public class PromotionStub {
    PromotionFacadeLocal promotionFacade = lookupPromotionFacadeLocal();

    private PromotionFacadeLocal lookupPromotionFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (PromotionFacadeLocal) c.lookup("java:global/ProjectHotel/ProjectHotel-ejb/PromotionFacade!sessionbean.PromotionFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Promotion promotion) {
        promotionFacade.create(promotion);
    }

    public void edit(Promotion promotion) {
        promotionFacade.edit(promotion);
    }

    public void remove(Promotion promotion) {
        promotionFacade.remove(promotion);
    }

    public Promotion find(Object id) {
        return promotionFacade.find(id);
    }

    public List<Promotion> findAll() {
        return promotionFacade.findAll();
    }

    public List<Promotion> findRange(int[] range) {
        return promotionFacade.findRange(range);
    }

    public int count() {
        return promotionFacade.count();
    }
    
}

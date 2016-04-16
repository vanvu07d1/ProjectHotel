/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Promotion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import stub.PromotionStub;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class PromtionManagedBean {

    private Promotion promotion;
    private Promotion selectPromotion;
    private List<Promotion> listPromotion;
    private Date currentDate;

    /**
     * Creates a new instance of PromtionManagedBean
     */
    public PromtionManagedBean() {
        promotion = new Promotion();
        listPromotion = new ArrayList<Promotion>();
        currentDate = new Date();
    }

    public Integer getPromotionId() {
        return promotion.getPromotionId();
    }

    public void setPromotionId(Integer promotionId) {
        promotion.setPromotionId(promotionId);
    }

    public String getPromotionName() {
        return promotion.getPromotionName();
    }

    public void setPromotionName(String promotionName) {
        promotion.setPromotionName(promotionName);
    }

    public Date getStarDate() {
        return promotion.getStarDate();
    }

    public void setStarDate(Date starDate) {
        promotion.setStarDate(starDate);
    }

    public Date getEndDate() {
        return promotion.getEndDate();
    }

    public void setEndDate(Date endDate) {
        promotion.setEndDate(endDate);
    }

    public String getDescription() {
        return promotion.getDescription();
    }

    public void setDescription(String description) {
        promotion.setDescription(description);
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Promotion getSelectPromotion() {
        return selectPromotion;
    }

    public void setSelectPromotion(Promotion selectPromotion) {
        this.selectPromotion = selectPromotion;
    }

    public List<Promotion> getListPromotion() {
        return listPromotion;
    }

    public void setListPromotion(List<Promotion> listPromotion) {
        this.listPromotion = listPromotion;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public void addPromotion() {
        try {
            PromotionStub promotionStub = new PromotionStub();
            Promotion newPromotion = new Promotion();
            newPromotion.setPromotionName(promotion.getPromotionName());
            newPromotion.setDescription(promotion.getDescription());
            newPromotion.setStarDate(promotion.getStarDate());
            newPromotion.setEndDate(promotion.getEndDate());
            promotionStub.create(newPromotion);
            promotion = new Promotion();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Promotion editPromotion(int id) {
        try {
            PromotionStub promotionStub = new PromotionStub();
            promotion = promotionStub.find(id);
            return promotion;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void edit() {
        try {
            PromotionStub promotionStub = new PromotionStub();
            promotionStub.edit(promotion);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Promotion> findAllPromotion() {
        try {
            PromotionStub promotionStub = new PromotionStub();
            return promotionStub.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void deletePromotion(int id) {
        try {
            PromotionStub promotionStub = new PromotionStub();
            promotion = promotionStub.find(id);
            promotionStub.remove(promotion);
            promotion = new Promotion();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

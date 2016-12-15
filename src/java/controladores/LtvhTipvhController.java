package controladores;

import entidades.LtvhTipvh;
import controladores.util.JsfUtil;
import controladores.util.JsfUtil.PersistAction;
import sesiones.LtvhTipvhFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("ltvhTipvhController")
@SessionScoped
public class LtvhTipvhController implements Serializable {

    @EJB
    private sesiones.LtvhTipvhFacade ejbFacade;
    private List<LtvhTipvh> items = null;
    private LtvhTipvh selected;

    public LtvhTipvhController() {
    }

    public LtvhTipvh getSelected() {
        return selected;
    }

    public void setSelected(LtvhTipvh selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private LtvhTipvhFacade getFacade() {
        return ejbFacade;
    }

    public LtvhTipvh prepareCreate() {
        selected = new LtvhTipvh();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("LtvhTipvhCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("LtvhTipvhUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("LtvhTipvhDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<LtvhTipvh> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public LtvhTipvh getLtvhTipvh(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<LtvhTipvh> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<LtvhTipvh> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = LtvhTipvh.class)
    public static class LtvhTipvhControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LtvhTipvhController controller = (LtvhTipvhController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ltvhTipvhController");
            return controller.getLtvhTipvh(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }

        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof LtvhTipvh) {
                LtvhTipvh o = (LtvhTipvh) object;
                return getStringKey(o.getTvhCodigo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), LtvhTipvh.class.getName()});
                return null;
            }
        }

    }

}

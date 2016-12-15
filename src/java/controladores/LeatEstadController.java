package controladores;

import entidades.LeatEstad;
import controladores.util.JsfUtil;
import controladores.util.JsfUtil.PersistAction;
import sesiones.LeatEstadFacade;

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

@Named("leatEstadController")
@SessionScoped
public class LeatEstadController implements Serializable {

    @EJB
    private sesiones.LeatEstadFacade ejbFacade;
    private List<LeatEstad> items = null;
    private LeatEstad selected;

    public LeatEstadController() {
    }

    public LeatEstad getSelected() {
        return selected;
    }

    public void setSelected(LeatEstad selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getLeatEstadPK().setCnaCodigo(selected.getLcnaCndar().getCnaCodigo().toBigInteger());
    }

    protected void initializeEmbeddableKey() {
        selected.setLeatEstadPK(new entidades.LeatEstadPK());
    }

    private LeatEstadFacade getFacade() {
        return ejbFacade;
    }

    public LeatEstad prepareCreate() {
        selected = new LeatEstad();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("LeatEstadCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("LeatEstadUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("LeatEstadDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<LeatEstad> getItems() {
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

    public LeatEstad getLeatEstad(entidades.LeatEstadPK id) {
        return getFacade().find(id);
    }

    public List<LeatEstad> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<LeatEstad> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = LeatEstad.class)
    public static class LeatEstadControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LeatEstadController controller = (LeatEstadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "leatEstadController");
            return controller.getLeatEstad(getKey(value));
        }

        entidades.LeatEstadPK getKey(String value) {
            entidades.LeatEstadPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entidades.LeatEstadPK();
           // key.setCnaCodigo(values[0]);
           // key.setEatCodigo(values[1]);
            return key;
        }

        String getStringKey(entidades.LeatEstadPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCnaCodigo());
            sb.append(SEPARATOR);
            sb.append(value.getEatCodigo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof LeatEstad) {
                LeatEstad o = (LeatEstad) object;
                return getStringKey(o.getLeatEstadPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), LeatEstad.class.getName()});
                return null;
            }
        }

    }

}

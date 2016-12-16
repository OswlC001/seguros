package controladores;

import entidades.LaseAseguradora;
import controladores.util.JsfUtil;
import controladores.util.JsfUtil.PersistAction;
import sesiones.LaseAseguradoraFacade;

import java.io.Serializable;
import java.math.BigDecimal;
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

@Named("aseguradora")
@SessionScoped
public class Aseguradora implements Serializable {

    @EJB
    private sesiones.LaseAseguradoraFacade ejbFacade;
    private List<LaseAseguradora> items = null;
    private LaseAseguradora selected;
    private boolean verTabla;

    public Aseguradora() {
        nuevo();
    }

    public LaseAseguradora getSelected() {
        if (selected == null) {
            selected = new LaseAseguradora();
        }
        return selected;
    }

    public void setSelected(LaseAseguradora selected) {
        this.selected = selected;
    }

    public boolean isVerTabla() {
        return verTabla;
    }

    public void setVerTabla(boolean verTabla) {
        this.verTabla = verTabla;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    public void cerrar() {
        verTabla = false;
    }

    private LaseAseguradoraFacade getFacade() {
        return ejbFacade;
    }

    public void nuevo() {
        verTabla = false;
        selected = new LaseAseguradora();
    }

    public void guardar() {
        persist(PersistAction.CREATE, "Registro guardado correctamente");
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void buscar() {
        verTabla = true;
    }

    public void actualizar() {
        persist(PersistAction.UPDATE, "Registro actualizado correctamente");
    }

    public void eliminar() {
        persist(PersistAction.DELETE, "Registro eliminado correctamente");
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<LaseAseguradora> getItems() {
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

    public LaseAseguradora getLaseAseguradora(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<LaseAseguradora> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<LaseAseguradora> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = LaseAseguradora.class)
    public static class LaseAseguradoraControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            Aseguradora controller = (Aseguradora) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "aseguradora");
            return controller.getLaseAseguradora(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            System.out.println("value ---- " + value);
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
            if (object instanceof LaseAseguradora) {
                LaseAseguradora o = (LaseAseguradora) object;
                return getStringKey(o.getAseCodigo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), LaseAseguradora.class.getName()});
                return null;
            }
        }

    }

}

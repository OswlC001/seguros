package controladores;

import entidades.LasgAsegurados;
import controladores.util.JsfUtil;
import controladores.util.JsfUtil.PersistAction;
import entidades.LvehVehic;
import sesiones.LasgAseguradosFacade;

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
import javax.faces.event.ValueChangeEvent;
import sesiones.LvehVehicFacade;

@Named("asegurados")
@SessionScoped
public class Asegurados implements Serializable {

    @EJB
    private LvehVehicFacade lvehVehicFacade;

    @EJB
    private sesiones.LasgAseguradosFacade ejbFacade;

    private List<LasgAsegurados> items = null;
    private LasgAsegurados selected;
    private boolean verTabla;

    public Asegurados() {
        nuevo();
    }

    public LasgAsegurados getSelected() {
        if (selected == null) {
            selected = new LasgAsegurados();
        }

        if (selected.getVehCodigo() == null) {
            LvehVehic v = new LvehVehic();
            v.setVehPlaca("");
            selected.setVehCodigo(v);
        }
        return selected;
    }

    public void setSelected(LasgAsegurados selected) {
        this.selected = selected;
    }

    public boolean isVerTabla() {
        return verTabla;
    }

    public void setVerTabla(boolean verTabla) {
        this.verTabla = verTabla;
    }

    public void cerrar() {
        verTabla = false;
    }

    public void buscarVehiculo(ValueChangeEvent event) {
        if (event.getNewValue() != null) {
            String placa_ = event.getNewValue().toString();
            LvehVehic vehiculo = lvehVehicFacade.findByCampo("vehPlaca", placa_);
            if (vehiculo != null && selected != null) {
                selected.setVehCodigo(vehiculo);
            }
        }
    }

    public void buscar() {
        verTabla = true;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private LasgAseguradosFacade getFacade() {
        return ejbFacade;
    }

    public void nuevo() {
        verTabla = false;
        selected = new LasgAsegurados();
    }

    public void excluir() {
        guardar();
    }

    public void incluir() {
        guardar();
    }

    public void guardar() {
        persist(PersistAction.CREATE, "Registro guardado correctamente");
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
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

    public List<LasgAsegurados> getItems() {
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

    public LasgAsegurados getLasgAsegurados(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<LasgAsegurados> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<LasgAsegurados> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = LasgAsegurados.class)
    public static class LasgAseguradosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            Asegurados controller = (Asegurados) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "asegurados");
            return controller.getLasgAsegurados(getKey(value));
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
            if (object instanceof LasgAsegurados) {
                LasgAsegurados o = (LasgAsegurados) object;
                return getStringKey(o.getAsgCodigo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), LasgAsegurados.class.getName()});
                return null;
            }
        }

    }

}

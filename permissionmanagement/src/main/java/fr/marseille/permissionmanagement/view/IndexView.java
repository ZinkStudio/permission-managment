package fr.marseille.permissionmanagement.view;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class IndexView.
 */
@ManagedBean
@SessionScoped
public class IndexView implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long          serialVersionUID = 1L;

    /** The locale code. */
    private String                     localeCode;

    /** The countries. */
    private static Map<String, Object> countries;

    static {
        countries = new LinkedHashMap<String, Object>();
        countries.put("English", Locale.ENGLISH); // label, value
        countries.put("French", Locale.FRENCH);
    }

    /**
     * Gets the countries in map.
     *
     * @return the countries in map
     */
    public Map<String, Object> getCountriesInMap() {
        return countries;
    }

    /**
     * Gets the locale code.
     *
     * @return the locale code
     */
    public String getLocaleCode() {
        return localeCode;
    }

    /**
     * Sets the locale code.
     *
     * @param localeCode the new locale code
     */
    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    /**
     * Country locale code changed.
     *
     * @param e the e
     */
    // value change event listener
    public void countryLocaleCodeChanged(ValueChangeEvent e) {

        String newLocaleValue = e.getNewValue().toString();

        // loop country map to compare the locale code
        for (Map.Entry<String, Object> entry : countries.entrySet()) {

            if (entry.getValue().toString().equals(newLocaleValue)) {

                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());

            }
        }
    }
}

package org.wicketstuff.selectize;

import org.apache.wicket.request.resource.CssResourceReference;

public class SelectizeCssResourceReference extends CssResourceReference {

    private static final long serialVersionUID = 1L;

    public enum Theme {
	/**
	 * none theme
	 */
	NONE,
	/**
	 * defaul theme
	 */
	DEFAULT,
	/**
	 * Legacy theme
	 */
	LEGACY,
	/**
	 * Theme for bootstrap 2
	 */
	BOOTSTRAP2,
	/**
	 * Theme for bootstrap 3
	 */
	BOOTSTRAP3
    }

    /**
     * Singleton instance of this reference
     */
    private static SelectizeCssResourceReference INSTANCE = null;

    /**
     * @return the single instance of the resource reference
     */
    public static SelectizeCssResourceReference instance(Theme theme) {
	if (INSTANCE == null) {
	    switch (theme) {
	    case DEFAULT:
		INSTANCE = new SelectizeCssResourceReference("res/selectize/css/selectize.default.css");
		break;
	    case LEGACY:
		INSTANCE = new SelectizeCssResourceReference("res/selectize/css/selectize.legacy.css");
		break;
	    case BOOTSTRAP2:
		INSTANCE = new SelectizeCssResourceReference("res/selectize/css/selectize.bootstrap2.css");
		break;
	    case BOOTSTRAP3:
		INSTANCE = new SelectizeCssResourceReference("res/selectize/css/selectize.bootstrap3.css");
		break;
	    case NONE:
	    default:
		INSTANCE = new SelectizeCssResourceReference("res/selectize/css/selectize.css");
		break;
	    }
	}
	return INSTANCE;
    }

    /**
     * Private constructor.
     */
    private SelectizeCssResourceReference(String path) {
	super(SelectizeCssResourceReference.class, path);
    }
}
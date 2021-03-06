package com.vaadin.addon.charts.client;

/*-
 * #%L
 * Vaadin Charts Addon
 * %%
 * Copyright (C) 2012 - 2019 Vaadin Ltd
 * %%
 * This program is available under Commercial Vaadin Add-On License 3.0
 * (CVALv3).
 *
 * See the file licensing.txt distributed with this software for more
 * information about licensing.
 *
 * You should have received a copy of the CVALv3 along with this program.
 * If not, see <https://vaadin.com/license/cval-3>.
 * #L%
 */

import com.google.gwt.core.client.GWT;

/** Helper to load the JavaScripts required by Highcharts */
public class HighchartsScriptLoader {

  private static final HighchartsScriptLoader INSTANCE = GWT.create(HighchartsScriptLoader.class);

  private static boolean injected;

  /**
   * Highchart related widgets and GWT overlays should ensure scripts are injected in the host page
   * using this method.
   */
  public static void ensureInjected() {
    if (!injected) {
      INSTANCE.injectResources();
      injected = true;
    }
  }

  protected void injectResources() {
    // Inject highcharts only if not already injected
    if (!hasHighcharts()) {
      inject(HighchartResources.INSTANCE.highstock().getText());
      inject(HighchartResources.INSTANCE.highchartsWorkarounds().getText());
    }
    // Load heatmap before treemap
    if (!hasHeatmap()) {
      inject(HighchartResources.INSTANCE.heatmap().getText());
    }
    // Inject highchartsmore only if not already injected
    if (!hasHighchartsMore()) {
      inject(HighchartResources.INSTANCE.highchartsMore().getText());
    }
    // Inject other resources only if not already injected
    if (!hasExtraImports()) {
      inject(HighchartResources.INSTANCE.noData().getText());
      inject(HighchartResources.INSTANCE.funnel().getText());
      inject(HighchartResources.INSTANCE.exporting().getText());
      inject(HighchartResources.INSTANCE.offlineExporting().getText());
      inject(HighchartResources.INSTANCE.defaultTheme().getText());
      inject(HighchartResources.INSTANCE.highcharts3d().getText());
      inject(HighchartResources.INSTANCE.solidGauge().getText());
      inject(HighchartResources.INSTANCE.treemap().getText());
      inject(HighchartResources.INSTANCE.drilldown().getText());
      inject(HighchartResources.INSTANCE.highchartsDrilldownWorkarounds().getText());
    }
  }

  protected static native boolean hasHighcharts() /*-{
        if($wnd.Highcharts)
            return true;
        return false;
    }-*/;

  protected static native boolean hasHeatmap() /*-{
        if($wnd.Highcharts.seriesTypes.heatmap)
            return true;
        return false;
    }-*/;

  /**
   * Funnel should be enough to check that extra modules are missing
   *
   * @return true if other imports were loaded
   */
  protected static native boolean hasExtraImports() /*-{
        if($wnd.Highcharts.seriesTypes.funnel)
            return true;
        return false;
    }-*/;

  protected static native boolean hasHighchartsMore() /*-{
        if($wnd.Highcharts.seriesTypes.bubble)
            return true;
        return false;
    }-*/;

  protected static native void inject(String script) /*-{
        $wnd.eval(script);
    }-*/;
}

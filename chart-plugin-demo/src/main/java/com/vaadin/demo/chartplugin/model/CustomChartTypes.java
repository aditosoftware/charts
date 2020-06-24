package com.vaadin.demo.chartplugin.model;

import com.vaadin.addon.charts.model.ChartType;

/**
 * Adds Map chart type. 'map' refers to Highcharts Map plugin.</br> Link between this type and the
 * plugin is created by <code>Highcharts.seriesTypes.map</code> series type.
 */
public class CustomChartTypes extends ChartType {

  public static final ChartType MAP = new CustomChartTypes("map");

  protected CustomChartTypes(String type) {
    super(type);
  }
}

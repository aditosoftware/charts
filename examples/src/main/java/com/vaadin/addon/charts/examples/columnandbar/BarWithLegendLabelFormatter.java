package com.vaadin.addon.charts.examples.columnandbar;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.examples.SkipFromDemo;
import com.vaadin.addon.charts.model.*;
import com.vaadin.ui.Component;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@SkipFromDemo
public class BarWithLegendLabelFormatter extends AbstractVaadinChartExample {

  @Override
  public String getDescription() {
    return "Basic bar with legend label formatter";
  }

  @Override
  protected Component getChart() {
    Chart chart = new Chart(ChartType.BAR);

    Configuration conf = chart.getConfiguration();

    conf.setTitle("Historic World Population by Region");
    conf.setSubTitle("Source: Wikipedia.org");

    Legend legend = new Legend();
    legend.setLabelFormatter("function() { return this.name + ' (click to hide)'; }");
    conf.setLegend(legend);

    List<Series> series = new ArrayList<Series>();
    series.add(new ListSeries("Year 1800", 107, 31, 635, 203, 2));
    series.add(new ListSeries("Year 1900", 133, 156, 947, 408, 6));
    series.add(new ListSeries("Year 2008", 973, 914, 4054, 732, 34));
    conf.setSeries(series);

    return chart;
  }
}

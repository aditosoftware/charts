package com.vaadin.addon.charts.examples.lineandscatter;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.model.*;
import com.vaadin.ui.Component;

public class LogarithmicAxis extends AbstractVaadinChartExample {

  @Override
  public String getDescription() {
    return "Logarithmic Axis";
  }

  @Override
  protected Component getChart() {
    Chart chart = new Chart();
    chart.setHeight("450px");
    chart.setWidth("100%");

    Configuration configuration = chart.getConfiguration();
    configuration.getTitle().setText("Logarithmic axis demo");

    configuration.getxAxis().setTickInterval(1);

    YAxis yAxis = configuration.getyAxis();
    yAxis.setType(AxisType.LOGARITHMIC);
    yAxis.setMinorTickInterval("0.1");

    configuration.getTooltip().setHeaderFormat("<b>{series.name}</b><br />");
    configuration.getTooltip().setPointFormat("x = {point.x}, y = {point.y}");
    PlotOptionsLine plotOptions = new PlotOptionsLine();
    plotOptions.setPointStart(1);
    configuration.setPlotOptions(plotOptions);

    ListSeries ls = new ListSeries(1, 2, 4, 8, 16, 32, 64, 128, 256, 512);
    configuration.setSeries(ls);

    chart.drawChart(configuration);
    return chart;
  }
}

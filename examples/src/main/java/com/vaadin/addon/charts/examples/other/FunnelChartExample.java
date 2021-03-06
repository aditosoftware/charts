package com.vaadin.addon.charts.examples.other;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.model.*;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class FunnelChartExample extends AbstractVaadinChartExample {

  @Override
  public String getDescription() {
    return "Funnel chart example";
  }

  @Override
  protected Component getChart() {
    DataSeries dataSeries = new DataSeries("Unique users");
    dataSeries.add(new DataSeriesItem("Website visits", 15654));
    dataSeries.add(new DataSeriesItem("Downloads", 4064));
    dataSeries.add(new DataSeriesItem("Requested price list", 1987));
    dataSeries.add(new DataSeriesItem("Invoice sent", 976));
    dataSeries.add(new DataSeriesItem("Finalized", 846));

    Chart chart = new Chart();

    Configuration conf = chart.getConfiguration();

    conf.setTitle("Sales funnel");
    conf.getLegend().setEnabled(false);

    PlotOptionsFunnel options = new PlotOptionsFunnel();
    options.setReversed(false);
    options.setNeckWidth("30%");
    options.setNeckHeight("30%");

    options.setWidth("70%");

    DataLabelsFunnel dataLabels = new DataLabelsFunnel();
    dataLabels.setFormat("<b>{point.name}</b> ({point.y:,.0f})");
    options.setDataLabels(dataLabels);

    dataSeries.setPlotOptions(options);
    conf.addSeries(dataSeries);

    return chart;
  }
}

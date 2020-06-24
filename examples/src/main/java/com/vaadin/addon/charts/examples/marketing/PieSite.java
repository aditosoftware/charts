package com.vaadin.addon.charts.examples.marketing;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.examples.SkipFromDemo;
import com.vaadin.addon.charts.model.*;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
@SkipFromDemo
public class PieSite extends AbstractVaadinChartExample {

  @Override
  public String getDescription() {
    return "Pie demo used in charts site";
  }

  @Override
  protected Component getChart() {
    Chart chart = new Chart(ChartType.PIE);

    Configuration conf = chart.getConfiguration();

    conf.setTitle("Revenue by industry");
    conf.setSubTitle("2015");

    Tooltip tooltip = conf.getTooltip();
    tooltip.setPointFormat("<b>{point.percentage:.1f}%</b>");

    PlotOptionsPie plotOptions = new PlotOptionsPie();
    plotOptions.setAllowPointSelect(true);
    plotOptions.setCursor(Cursor.POINTER);
    plotOptions.setShowInLegend(true);
    DataLabels dataLabels = plotOptions.getDataLabels();
    dataLabels.setEnabled(true);
    dataLabels.setFormat("{point.name}: {point.y:.1f} M€");
    conf.setPlotOptions(plotOptions);

    DataSeries series = new DataSeries("Revenue");
    series.add(new DataSeriesItem("Aerospace", 90.0));
    series.add(new DataSeriesItem("Medical", 53.6));
    series.add(new DataSeriesItem("Agriculture", 25.6));
    series.add(new DataSeriesItem("Automotive", 17.0));
    series.add(new DataSeriesItem("Consumers", 12.4));
    series.add(new DataSeriesItem("Subsidies", 1.4));
    conf.setSeries(series);

    return chart;
  }
}

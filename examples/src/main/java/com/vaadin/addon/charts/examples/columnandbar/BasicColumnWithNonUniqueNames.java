package com.vaadin.addon.charts.examples.columnandbar;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.ui.Component;

public class BasicColumnWithNonUniqueNames extends AbstractVaadinChartExample {

  @Override
  public String getDescription() {
    return "Basic column";
  }

  @Override
  protected Component getChart() {
    Chart chart = new Chart(ChartType.COLUMN);

    Configuration conf = chart.getConfiguration();

    conf.setTitle("Monthly Average Rainfall");
    conf.setSubTitle("Source: WorldClimate.com");

    conf.getxAxis().setType(AxisType.CATEGORY);
    conf.getxAxis().setUniqueNames(false);

    conf.getyAxis().setUniqueNames(false);
    conf.getyAxis().setMin(0);
    conf.getyAxis().setTitle("Rainfall (mm)");

    Legend legend = new Legend();
    legend.setLayout(LayoutDirection.VERTICAL);
    legend.setBackgroundColor(new SolidColor("#FFFFFF"));
    legend.setAlign(HorizontalAlign.LEFT);
    legend.setVerticalAlign(VerticalAlign.TOP);
    legend.setX(100);
    legend.setY(70);
    legend.setFloating(true);
    legend.setShadow(true);
    conf.setLegend(legend);

    Tooltip tooltip = new Tooltip();
    tooltip.setFormatter("this.x +': '+ this.y +' mm'");
    conf.setTooltip(tooltip);

    PlotOptionsColumn plot = new PlotOptionsColumn();
    plot.setPointPadding(0.2);
    plot.setBorderWidth(0);

    conf.addSeries(new DataSeries(new DataSeriesItem("New", 5), new DataSeriesItem("New", 1)));
    /*        conf.addSeries(
            new ListSeries(
                    "New York",
                    83.6,
                    78.8,
                    98.5,
                    93.4,
                    106.0,
                    84.5,
                    105.0,
                    104.3,
                    91.2,
                    83.5,
                    106.6,
                    92.3));
    conf.addSeries(
            new ListSeries(
                    "London", 48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2));
    conf.addSeries(
            new ListSeries(
                    "Berlin", 42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1));*/

    chart.drawChart(conf);
    return chart;
  }
}

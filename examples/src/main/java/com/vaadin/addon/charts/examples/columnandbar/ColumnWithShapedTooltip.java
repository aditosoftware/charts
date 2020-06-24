package com.vaadin.addon.charts.examples.columnandbar;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.examples.SkipFromDemo;
import com.vaadin.addon.charts.model.*;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
@SkipFromDemo
public class ColumnWithShapedTooltip extends AbstractVaadinChartExample {

  @Override
  public String getDescription() {
    return "Stacked Column with circular labels";
  }

  @Override
  protected Component getChart() {
    Chart chart = new Chart(ChartType.COLUMN);
    chart.setId("chart");

    Configuration conf = chart.getConfiguration();

    conf.setTitle(new Title("Stacked column chart"));

    XAxis xAxis = new XAxis();
    xAxis.setCategories(new String[] {"Apples", "Oranges", "Pears", "Grapes", "Bananas"});
    conf.addxAxis(xAxis);

    YAxis yAxis = new YAxis();
    yAxis.setMin(0);
    yAxis.setTitle(new AxisTitle("Total fruit consumption"));
    conf.addyAxis(yAxis);

    PlotOptionsColumn plotOptions = new PlotOptionsColumn();
    plotOptions.setStacking(Stacking.NORMAL);

    conf.setPlotOptions(plotOptions);

    Tooltip tooltip = new Tooltip();
    tooltip.setFormatter(
        "function() { return '<b>'+ this.x +'</b><br/>"
            + "'+this.series.name +': '+ this.y +'<br/>'+'Total: '+ this.point.stackTotal;}");
    tooltip.setShape(Shape.CIRCLE);
    conf.setTooltip(tooltip);

    conf.addSeries(new ListSeries("John", new Number[] {5, 3, 4, 7, 2}));
    conf.addSeries(new ListSeries("Jane", new Number[] {2, 2, 3, 2, 1}));
    conf.addSeries(new ListSeries("Joe", new Number[] {3, 4, 4, 2, 5}));

    chart.drawChart(conf);
    return chart;
  }
}

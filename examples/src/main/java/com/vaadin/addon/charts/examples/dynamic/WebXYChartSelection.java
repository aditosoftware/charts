package com.vaadin.addon.charts.examples.dynamic;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.ChartSelectionEvent;
import com.vaadin.addon.charts.ChartSelectionListener;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.model.*;
import com.vaadin.ui.Component;

import java.util.Random;

public class WebXYChartSelection extends AbstractVaadinChartExample {

  @Override
  public String getDescription() {
    return "Selection listener using both x and y values";
  }

  @Override
  protected Component getChart() {

    return createScatterChart();
  }

  private Chart createScatterChart() {
    final Chart scatterChart = new Chart(ChartType.SCATTER);
    scatterChart.setId("chart");
    scatterChart.getConfiguration().getChart().setZoomType(ZoomType.XY);
    scatterChart.getConfiguration().disableCredits();
    scatterChart.getConfiguration().setTitle("Selections as area ranges");
    scatterChart
        .getConfiguration()
        .setSubTitle(
            "Drag with mouse to make selections. Click the legend items to toggle visibility.");

    PlotOptionsScatter scatterOptions = new PlotOptionsScatter();
    scatterOptions.setAnimation(false);
    scatterOptions.setPointStart(1);
    DataSeries series = new DataSeries();
    series.setPlotOptions(scatterOptions);
    series.setName("Original");

    Random random = new Random(0);

    for (int i = 0; i < 20; i++) {
      DataSeriesItem dsi = new DataSeriesItem();
      dsi.setY(random.nextInt(10));
      dsi.setX(random.nextInt(10));
      series.add(dsi);
    }

    scatterChart.getConfiguration().addSeries(series);

    scatterChart.addChartSelectionListener(
        new ChartSelectionListener() {

          @Override
          public void onSelection(ChartSelectionEvent event) {
            double xStart = event.getSelectionStart();
            double xEnd = event.getSelectionEnd();
            double yStart = event.getValueStart();
            double yEnd = event.getValueEnd();

            Number[][] data = new Number[][] {{xStart, yStart, yEnd}, {xEnd, yStart, yEnd}};

            PlotOptionsArearange areaRangePlot = new PlotOptionsArearange();
            areaRangePlot.setFillOpacity(0.1f);
            areaRangePlot.setLineWidth(0);

            RangeSeries selectionSeries = new RangeSeries("Selection", data);

            selectionSeries.setPlotOptions(areaRangePlot);
            scatterChart.getConfiguration().addSeries(selectionSeries);
            scatterChart.drawChart();
            areaRangePlot.setAnimation(false);
          }
        });

    scatterChart.drawChart();
    return scatterChart;
  }
}

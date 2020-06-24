package com.vaadin.addon.charts.examples.pointclickevent;

import com.vaadin.addon.charts.*;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.examples.SkipFromDemo;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SkipFromDemo
public abstract class AbstractPointClickCoordinatesChart extends AbstractVaadinChartExample {

  private Label lastAction = new Label();
  private ChartType type;

  public AbstractPointClickCoordinatesChart(ChartType type) {
    super();
    this.type = type;
  }

  @Override
  public String getDescription() {
    return "Point click coordinates for " + type.toString();
  }

  @Override
  protected Component getChart() {
    Label spaceLabel =
        new Label("Extra space to make sure coordinates are absolute, not relative.");
    spaceLabel.setHeight("100px");

    VerticalLayout verticalLayout = new VerticalLayout();
    verticalLayout.addComponent(spaceLabel);
    verticalLayout.addComponent(createChart());
    verticalLayout.addComponent(lastAction);
    return verticalLayout;
  }

  protected Chart createChart() {
    Chart chart = new Chart(type);
    chart.setWidth("900px");
    chart.setHeight("450px");
    chart.addPointClickListener(
        new PointClickListener() {
          @Override
          public void onClick(PointClickEvent event) {
            lastAction.setValue(
                "PointClickEvent: absoluteX: "
                    + event.getAbsoluteX()
                    + " - absoluteY: "
                    + event.getAbsoluteY());
          }
        });
    chart.addChartClickListener(
        new ChartClickListener() {

          @Override
          public void onClick(ChartClickEvent event) {
            lastAction.setValue(
                "ChartClickEvent: absoluteX: "
                    + event.getAbsoluteX()
                    + " - absoluteY: "
                    + event.getAbsoluteY());
          }
        });
    addSeries(chart.getConfiguration());
    return chart;
  }

  protected abstract void addSeries(Configuration conf);
}

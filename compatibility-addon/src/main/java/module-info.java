module com.vaadin.v7.addon.charts {
  requires com.vaadin.addon.charts;
  requires com.fasterxml.jackson.core;
  requires com.fasterxml.jackson.databind;
  requires vaadin.compatibility.server;

  exports com.vaadin.v7.addon.charts.model;
  exports com.vaadin.v7.addon.charts.model.serializers;
}

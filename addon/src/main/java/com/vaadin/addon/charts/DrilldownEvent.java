package com.vaadin.addon.charts;

/*-
 * #%L
 * Vaadin Charts Addon
 * %%
 * Copyright (C) 2012 - 2019 Vaadin Ltd
 * %%
 * This program is available under Commercial Vaadin Add-On License 3.0
 * (CVALv3).
 *
 * See the file licensing.txt distributed with this software for more
 * information about licensing.
 *
 * You should have received a copy of the CVALv3 along with this program.
 * If not, see <https://vaadin.com/license/cval-3>.
 * #L%
 */

import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;

import java.io.Serializable;
import java.util.List;

/** The DrilldownEvent class stores information on click events in drilldown points */
public class DrilldownEvent implements Serializable {
  private final boolean isCategory;
  private final DataSeries series;
  private final DataSeriesItem item;
  private final List<DataSeriesItem> items;

  /**
   * Construct a ChartDrilldownEvent
   *
   * @param source
   * @param series
   */
  public DrilldownEvent (
      Chart source, boolean isCategory, DataSeries series, DataSeriesItem item, List<DataSeriesItem> items) {
    this.isCategory = isCategory;
    this.series = series;
    this.item = item;
    this.items = items;
  }

  public boolean isCategory() {
    return this.isCategory;
  }

  public DataSeries getSeries () {
    return series;
  }

  public DataSeriesItem getItem() {
    return item;
  }

  public List<DataSeriesItem> getItems() {
    return items;
  }
}

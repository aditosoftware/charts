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
import java.util.EventObject;
import java.util.List;

/**
 * Represents the drilldown event. This class stores all required information to process the
 * drilldown event on the server-side.
 *
 * <p>This event represents a drilldown event on a category label or on a point. There are differs
 * between them: When clicked on a category label, the {@link this#items} property is set. In
 * addition, the {@link this#item} property holds the first item on the category. When clicked on a
 * single item, only {@link this#item} is set with the clicked point.
 */
public class DrilldownEvent extends EventObject implements Serializable {
  private final boolean isCategory;
  private final DataSeries series;
  private final DataSeriesItem item;
  private final List<DataSeriesItem> items;

  public DrilldownEvent(
      Chart source,
      boolean isCategory,
      DataSeries series,
      DataSeriesItem item,
      List<DataSeriesItem> items) {
    super(source);
    this.source = source;
    this.isCategory = isCategory;
    this.series = series;
    this.item = item;
    this.items = items;
  }

  /**
   * Will return if this event represents a click on a category label.
   *
   * @return If the event is based on a click on a category label.
   */
  public boolean isCategory() {
    return this.isCategory;
  }

  /**
   * Will return the {@link DataSeries} which contains the clicked item. This will just return the
   * DataSeries for the single {@link this#getItem()}.
   *
   * @return The associated DataSeries to {@link this#getItem()}.
   */
  public DataSeries getSeries() {
    return series;
  }

  /**
   * Will return the single {@link DataSeriesItem} which differs when clicked on a category label or
   * point. See class documentation for more information.
   *
   * @return The clicked item of the first item of the clicked category.
   */
  public DataSeriesItem getItem() {
    return item;
  }

  /**
   * Will return all {@link DataSeriesItem} from the clicked category. If this event represents a
   * point click, this will just return null.
   *
   * @return List of all items from the clicked category.
   */
  public List<DataSeriesItem> getItems() {
    return items;
  }
}

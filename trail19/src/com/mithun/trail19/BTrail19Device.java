/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

package com.mithun.trail19;

import java.util.List;
import java.util.ArrayList;

import javax.baja.driver.util.BPollFrequency;
import javax.baja.naming.BOrd;
import javax.baja.ndriver.BNDevice;
import javax.baja.ndriver.poll.BINPollable;
import javax.baja.ndriver.util.SfUtil;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.security.dashboard.*;
import javax.baja.status.BStatus;
import javax.baja.sys.*;

import com.mithun.trail19.point.*;

/**
 * BTrail19Device models a single device
 *
 * @author mithun on 27 May 2025
 */
@NiagaraType
@NiagaraProperty(
  name = "pollFrequency",
  type = "BPollFrequency",
  defaultValue = "BPollFrequency.normal"
)
// Add facet to include following in auto manager view
@NiagaraProperty(
  name = "status",
  type = "BStatus",
  defaultValue = "BStatus.ok",
  flags = Flags.TRANSIENT | Flags.READONLY | Flags.SUMMARY | Flags.DEFAULT_ON_CLONE,
  facets = @Facet("SfUtil.incl(SfUtil.MGR_EDIT_READONLY)"),
  override = true
)
@NiagaraProperty(
  name = "points",
  type = "BTrail19PointDeviceExt",
  defaultValue = "new BTrail19PointDeviceExt()"
)
public class BTrail19Device
  extends BNDevice
  implements BINPollable, BISecurityDashboardProviderAgent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.mithun.trail19.BTrail19Device(2953050616)1.0$ @*/
/* Generated Tue May 27 15:03:53 EDT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "pollFrequency"

  /**
   * Slot for the {@code pollFrequency} property.
   * @see #getPollFrequency
   * @see #setPollFrequency
   */
  public static final Property pollFrequency = newProperty(0, BPollFrequency.normal, null);

  /**
   * Get the {@code pollFrequency} property.
   * @see #pollFrequency
   */
  public BPollFrequency getPollFrequency() { return (BPollFrequency)get(pollFrequency); }

  /**
   * Set the {@code pollFrequency} property.
   * @see #pollFrequency
   */
  public void setPollFrequency(BPollFrequency v) { set(pollFrequency, v, null); }

  //endregion Property "pollFrequency"

  //region Property "status"

  /**
   * Slot for the {@code status} property.
   *  Add facet to include following in auto manager view
   * @see #getStatus
   * @see #setStatus
   */
  public static final Property status = newProperty(Flags.TRANSIENT | Flags.READONLY | Flags.SUMMARY | Flags.DEFAULT_ON_CLONE, BStatus.ok, SfUtil.incl(SfUtil.MGR_EDIT_READONLY));

  //endregion Property "status"

  //region Property "points"

  /**
   * Slot for the {@code points} property.
   * @see #getPoints
   * @see #setPoints
   */
  public static final Property points = newProperty(0, new BTrail19PointDeviceExt(), null);

  /**
   * Get the {@code points} property.
   * @see #points
   */
  public BTrail19PointDeviceExt getPoints() { return (BTrail19PointDeviceExt)get(points); }

  /**
   * Set the {@code points} property.
   * @see #points
   */
  public void setPoints(BTrail19PointDeviceExt v) { set(points, v, null); }

  //endregion Property "points"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrail19Device.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

////////////////////////////////////////////////////////////////
// Overrides
////////////////////////////////////////////////////////////////

  /**
   * Returns the network type that the device runs on.
   *
   * @return Type object representing the network
   */
  @Override
  public Type getNetworkType()
  {
    return BTrail19Network.TYPE;
  }

  /**
   * Override started
   */
  @Override
  public void started()
    throws Exception
  {
    super.started();

    // register device with poll scheduler
    getTrail19Network().getPollScheduler().subscribe(this);
  }

  /**
   * Override stopped
   */
  @Override
  public void stopped()
    throws Exception
  {
    // unregister device with poll scheduler
    getTrail19Network().getPollScheduler().unsubscribe(this);
    super.stopped();
  }

////////////////////////////////////////////////////////////////
// Implementation
////////////////////////////////////////////////////////////////

  /**
   *
   */
  public void doPing()
  {
    // TODO - add ping implementation
    // if()
    pingOk();
    // else
    //  pingFail("not receiving response from device ");
  }

////////////////////////////////////////////////////////////////
// Polling support
////////////////////////////////////////////////////////////////

  /**
   * The poll() callback method called from BPollScheduler
   * when it is time to poll this object.
   */
  public void doPoll()
  {
    // TODO add poll support
  }

////////////////////////////////////////////////////////////////
// Security Dashboard
////////////////////////////////////////////////////////////////

  /**
   * Returns the header for the security dashboard card.
   *
   * @param cx user context
   */
  @Override
  public LexiconFormatInfo getSecurityDashboardSectionHeader(Context cx)
  {
    return LexiconFormatInfo.make(TYPE, "BTrail19Device.securityDashboard.title", BString.make("BTrail19Device.securityDashboard"), BString.make(this.getDisplayName(cx)));
  }

  /**
   * Returns the BOrd to link to when the user clicks on the security dashboard card.
   */
  @Override
  public BOrd getSecurityDashboardSectionHyperlinkOrd()
  {
    return getNavOrd().relativizeToSession();
  }

  /**
   * Returns the version of the security dashboard items.
   */
  @Override
  public int getSecurityDashboardItemsVersion()
  {
    // TODO - Update this version when the security dashboard items change.
    return SECURITY_DASHBOARD_ITEMS_VERSION;
  }

  /**
   * Returns the list of security dashboard items.
   * Here you can add any security issues with the driver that require user attention.
   * Items can be of three types: Info, Warning, and Alert.
   *
   * @param cx user context
   */
  @Override
  public List<SecurityDashboardItem> getSecurityDashboardItems(Context cx)
  {
    List<SecurityDashboardItem> items = new ArrayList<>();
    // TODO - add device level security items to the dashboard
    // Info item to show non critic security status
    /** items.add(SecurityDashboardItem.makeInfo(
     TYPE,
     "BTrail19Device.securityDashboard.info",
     "BTrail19Device.securityDashboard.info.description"
     )); **/

    // Warning item to show critical security status
    /**
     if ("Warrants a Warning".equals(deviceState))
     {
     items.add(SecurityDashboardItem.makeWarning(
     TYPE,
     "BTrail19Device.securityDashboard.warningType1.title",
     "BTrail19Device.securityDashboard.warningType1.description"
     ));
     }
     else
     {
     items.add(SecurityDashboardItem.makeOk(
     TYPE,
     "BTrail19Device.securityDashboard.warningType1.title",
     "BTrail19Device.securityDashboard.warningType1.description"
     ));
     }
     **/

    // Alert item to show critical security status
    /**
     if ("Alert condition".equals(deviceState))
     {
     items.add(SecurityDashboardItem.makeAlert(
     TYPE,
     "BTrail19Device.securityDashboard.alertType1.title",
     "BTrail19Device.securityDashboard.alertType1.description"
     ));
     }
     else
     {
     items.add(SecurityDashboardItem.makeOk(
     TYPE,
     "BTrail19Device.securityDashboard.alertType1.title",
     "BTrail19Device.securityDashboard.alertType1.description"
     ));
     }
     **/

    return items;
  }

////////////////////////////////////////////////////////////////
// Utilities
////////////////////////////////////////////////////////////////

  /**
   * Get the network cast to a BTrail19Network.
   *
   * @return network as a BTrail19Network.
   */
  public final BTrail19Network getTrail19Network()
  {
    return (BTrail19Network) getNetwork();
  }

  private static final int SECURITY_DASHBOARD_ITEMS_VERSION = 1;
}

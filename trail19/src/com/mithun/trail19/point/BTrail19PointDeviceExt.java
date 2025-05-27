/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

package com.mithun.trail19.point;

import javax.baja.ndriver.discover.*;
import javax.baja.ndriver.point.*;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

import com.mithun.trail19.*;

/**
 * BTrail19PointDeviceExt is a container for trail19 proxy points.
 *
 * @author mithun on 27 May 2025
 */
@NiagaraType
@NiagaraProperty(
  name = "discoveryPreferences",
  type = "BTrail19PointDiscoveryPreferences",
  defaultValue = "new BTrail19PointDiscoveryPreferences()",
  override = true
)
public class BTrail19PointDeviceExt
  extends BNPointDeviceExt
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.mithun.trail19.point.BTrail19PointDeviceExt(2998155637)1.0$ @*/
/* Generated Tue May 27 14:40:23 EDT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "discoveryPreferences"

  /**
   * Slot for the {@code discoveryPreferences} property.
   * @see #getDiscoveryPreferences
   * @see #setDiscoveryPreferences
   */
  public static final Property discoveryPreferences = newProperty(0, new BTrail19PointDiscoveryPreferences(), null);

  //endregion Property "discoveryPreferences"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrail19PointDeviceExt.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

////////////////////////////////////////////////////////////////
// Access
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

  /**
   * Get the device cast to a BTrail19Device.
   *
   * @return device as a BTrail19Device.
   */
  public final BTrail19Device getTrail19Device()
  {
    return (BTrail19Device) getDevice();
  }

////////////////////////////////////////////////////////////////
// PointDeviceExt
////////////////////////////////////////////////////////////////

  /**
   * @return the Device type.
   */
  public Type getDeviceType()
  {
    return BTrail19Device.TYPE;
  }

  /**
   * @return the PointFolder type.
   */
  public Type getPointFolderType()
  {
    return BTrail19PointFolder.TYPE;
  }

  /**
   * @return the ProxyExt type.
   */
  public Type getProxyExtType()
  {
    return BTrail19ProxyExt.TYPE;
  }

////////////////////////////////////////////////////////////////
//BINDiscoveryHost
////////////////////////////////////////////////////////////////

  /**
   * Call back for discoveryJob to get an array of discovery objects.
   * Override point for driver specific discovery.
   */
  public BINDiscoveryObject[] getDiscoveryObjects(BNDiscoveryPreferences prefs)
    throws Exception
  {
    //
    // TODO  get array of discovery objects
    //
//    Array<??> a = new Array<>(??.class);
//    for(??)
//     a.add(new BTrail19PointDiscoveryLeaf(??));
//    return a.trim();
    return null;
  }
}

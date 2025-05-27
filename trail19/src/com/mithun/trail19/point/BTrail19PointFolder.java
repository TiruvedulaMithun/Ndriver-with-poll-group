/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

package com.mithun.trail19.point;

import javax.baja.ndriver.point.BNPointFolder;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;


import com.mithun.trail19.*;

/**
 * BTrail19PointFolder
 *
 * @author   mithun on 27 May 2025
 */
@NiagaraType
public class BTrail19PointFolder
  extends BNPointFolder
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.mithun.trail19.point.BTrail19PointFolder(2979906276)1.0$ @*/
/* Generated Tue May 27 15:03:53 EDT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrail19PointFolder.class);

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
}

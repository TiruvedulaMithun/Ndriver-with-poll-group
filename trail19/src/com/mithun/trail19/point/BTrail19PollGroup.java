/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

package com.mithun.trail19.point;

import javax.baja.driver.util.BPollFrequency;
import javax.baja.ndriver.point.BNProxyExt;
import javax.baja.ndriver.poll.BINPollable;
import javax.baja.ndriver.poll.BNPollGroup;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import com.mithun.trail19.*;

/**
 * BTrail19ProxyExt
 *
 * @author mithun on 27 May 2025
 */
@NiagaraType
public class BTrail19PollGroup
  extends BNPollGroup
  implements BINPollable
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.mithun.trail19.point.BTrail19PollGroup(2979906276)1.0$ @*/
/* Generated Tue May 27 15:03:53 EDT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrail19PollGroup.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  /**
   * This overriden function should call the getSubscribedProxyExts method
   * and update each registered + subscribed proxy extension with the new data.
   */
  public void doPoll ()
  {
    BNProxyExt[] proxyExts = getSubscribedProxyExts();
    // TODO add code to poll the group of proxy extensions
  }

  @Override
  public BPollFrequency getPollFrequency ()
  {
    return BPollFrequency.DEFAULT;
  }
}

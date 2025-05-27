/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

package com.mithun.trail19.comm;

import java.io.InputStream;

import javax.baja.ndriver.comm.LinkMessage;
import javax.baja.util.ICoalesceable;

/**
 * Trail19SerialLinkMessage streams data to and from a byte array representation.
 *
 * @author mithun on 27 May 2025
 */
public class Trail19SerialLinkMessage
  extends LinkMessage
{
  public Trail19SerialLinkMessage(int maxLen)
  {
    super(maxLen);
  }

  /**
   * Get byte data from inputStream.
   *
   * @return true if complete message received
   */
  public boolean receive(InputStream in)
    throws Exception
  {
    //
    // TODO add code to detect beginning and end of message in serial stream.
    //
    // read characters from stream
    // after start byte detected write following bytes to buffer[] until
    //  end of message
    return false;
  }

////////////////////////////////////////////////////////////////
// Handle outgoing messages
////////////////////////////////////////////////////////////////

// TODO customize handling of outgoing messages if needed
//  /** Translate data from app message to link message representation */
//  public boolean setMessage(NMessage msg)
//    throws Exception
//  {
//
//  }

  /**
   * Get the key which may be used to index this coalesceable
   * in hash maps.  This key must implement hashCode() and equals()
   * according to the coalescing semanatics.
   */
  @Override
  public Object getCoalesceKey()
  {
    // TODO if the message can coalesce, return a unique key to coalesce the message
    return this;
  }

  /**
   * Coalesce this instance with the specified object and return
   * the result (typically this or c).  If using a CoalesceQueue,
   * this object is always the first enqueued object and c is the
   * new object being enqueued.
   *
   * @param c
   */
  @Override
  public ICoalesceable coalesce(ICoalesceable c)
  {
    // TODO if the message can coalesce, determine the final coalesced message
    return c;
  }
}

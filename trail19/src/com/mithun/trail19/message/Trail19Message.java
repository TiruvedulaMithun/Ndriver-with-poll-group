/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

package com.mithun.trail19.message;

import java.io.*;

import javax.baja.ndriver.comm.*;
import javax.baja.ndriver.datatypes.*;
import javax.baja.ndriver.io.TypedInputStream;
import javax.baja.util.ICoalesceable;

/**
 * Trail19Message is super class for all trail19 messages
 *
 * @author mithun on 27 May 2025
 */
public class Trail19Message
  extends NMessage
{
  // Override for outgoing messages
//  public boolean toOutputStream(OutputStream out)
//    throws Exception
//  {
//    // Use typed stream for more readable code.
//    TypedOutputStream to = new TypedOutputStream();
//
//    to.toOutputStream(out);
//    return false;
//  }

  //   Override for incoming messages
//  public void fromInputStream(InputStream in)
//    throws Exception
//  {
//    // Use typed stream for more readable code.
//    // Note: messageFactory must have created TypedInputStream
//    TypedInputStream ti = (TypedInputStream)in;
//  }

  //   Typical overrides
//  public Object getTag() { return nullTag; }
//  public boolean isResponse() { return false; }
//  public boolean isFragmentable() { return false; }
//  public int getResponseTimeOut() { return 2500; }

//  public String toTraceString()
//  {
//    return "??";
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
   * @param newElement
   */
  @Override
  public ICoalesceable coalesce(ICoalesceable newElement)
  {
    // TODO if the message can coalesce, determine the final coalesced message
    return newElement;
  }
}

package com.sun.corba.se.PortableActivationIDL.LocatorPackage;


/**
* com/sun/corba/se/PortableActivationIDL/LocatorPackage/ServerLocationPerORB.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u192/11897/corba/src/share/classes/com/sun/corba/se/PortableActivationIDL/activation.idl
* Saturday, October 6, 2018 9:38:35 AM PDT
*/

public final class ServerLocationPerORB implements org.omg.CORBA.portable.IDLEntity
{
  public String hostname = null;
  public com.sun.corba.se.PortableActivationIDL.EndPointInfo ports[] = null;

  public ServerLocationPerORB ()
  {
  } // ctor

  public ServerLocationPerORB (String _hostname, com.sun.corba.se.PortableActivationIDL.EndPointInfo[] _ports)
  {
    hostname = _hostname;
    ports = _ports;
  } // ctor

} // class ServerLocationPerORB

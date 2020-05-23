package org.omg.PortableServer;


/**
* org/omg/PortableServer/ServantActivatorHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u192/11897/corba/src/share/classes/org/omg/PortableServer/poa.idl
* Saturday, October 6, 2018 9:38:37 AM PDT
*/


/**
	 * When the POA has the RETAIN policy it uses servant 
	 * managers that are ServantActivators. 
	 */
abstract public class ServantActivatorHelper
{
  private static String  _id = "IDL:omg.org/PortableServer/ServantActivator:2.3";

  public static void insert (org.omg.CORBA.Any a, org.omg.PortableServer.ServantActivator that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.omg.PortableServer.ServantActivator extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (org.omg.PortableServer.ServantActivatorHelper.id (), "ServantActivator");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.omg.PortableServer.ServantActivator read (org.omg.CORBA.portable.InputStream istream)
  {
      throw new org.omg.CORBA.MARSHAL ();
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.omg.PortableServer.ServantActivator value)
  {
      throw new org.omg.CORBA.MARSHAL ();
  }

  public static org.omg.PortableServer.ServantActivator narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof org.omg.PortableServer.ServantActivator)
      return (org.omg.PortableServer.ServantActivator)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      org.omg.PortableServer._ServantActivatorStub stub = new org.omg.PortableServer._ServantActivatorStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static org.omg.PortableServer.ServantActivator unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof org.omg.PortableServer.ServantActivator)
      return (org.omg.PortableServer.ServantActivator)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      org.omg.PortableServer._ServantActivatorStub stub = new org.omg.PortableServer._ServantActivatorStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
